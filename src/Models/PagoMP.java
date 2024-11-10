package Models;
import com.google.gson.Gson;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;
import okhttp3.*;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class PagoMP {

    public static final String ACCESS_TOKEN = "APP_USR-7844775058804207-101721-0b3cf4153a9b280de84abf7a232b2800-1628474064";

    public static void init() throws MPConfException {
        MercadoPago.SDK.setAccessToken(ACCESS_TOKEN);
    }

    public static Preference crearPreferencia(String titulo, String descripcion, double precio, String correo) throws MPException {
        Preference preference = new Preference();

        Item item = new Item();
        item.setTitle(titulo)
                .setQuantity(1)
                .setUnitPrice((float) precio)
                .setDescription(descripcion);

        preference.appendItem(item);

        Payer payer = new Payer();
        payer.setEmail(correo);
        preference.setPayer(payer);

        preference.setExternalReference("BOLETO-"+System.currentTimeMillis());

        preference.save();
        return preference;
    }

    public static void redirigirAWeb(Preference preference) {
        String linkDePago = preference.getInitPoint();

        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI(linkDePago));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //---------------------------- CLASES PARA MAPIAR LA RESPUESTA JSON ----------------------------//

    class PagoResponse {
        List<Pago> results;
    }

    class Pago {
        String id;
        String status;
    }

    public static boolean verificarEstadoPago(String externalReference) {
        OkHttpClient client = new OkHttpClient();

        String url = "https://api.mercadopago.com/v1/payments/search?external_reference=" + externalReference;

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + ACCESS_TOKEN)
                .build();

        try {
            // Hacer la llamada de forma síncrona
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                return procesarRespuesta(responseBody); // Retorna si el pago fue exitoso o no
            } else {
                System.out.println("Error en la consulta del pago: " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static boolean procesarRespuesta(String responseBody) {
        Gson gson = new Gson();
        PagoResponse pagoResponse = gson.fromJson(responseBody, PagoResponse.class);

        if (pagoResponse != null && pagoResponse.results != null && !pagoResponse.results.isEmpty()) {
            Pago pago = pagoResponse.results.get(0);
            System.out.println("Estado del pago: " + pago.status);
            System.out.println("ID del pago: " + pago.id);

            if ("approved".equals(pago.status)) {
                //PAGO APROBADO
                return true;
            } else {
                //PAGO NO APROBADO O PENDIENTE
                return false;
            }
        } else {
            //NO SE ENCONTRO PAGO CON LA REFERENCIA
            return false;
        }
    }

    public static void enviarCorreo(String nombreCliente, String nombreConductor, String nombreRuta,
                                    String precio, String fechaSalida, String codigoTicket, String emailTo) {

        String emailFrom = "colectivoxpress@gmail.com";
        String passwordFrom = "yaca tceq ggdi xtnf";
        String subject = "Detalles de tu compra";

        String template =
                "<body style='font-size: 2.2vw;'>" +
                        "<div style='width: 50%; margin: 0 auto;'>" +
                        "<div style='text-align: center; background-color: #161616; padding-top: 15px; padding-bottom: 15px;'>" +
                        "<h1 style='color: #e7c049; display: inline; font-size: 1.5em;'>Colectivo</h1>" +
                        "<h1 style='color: #c94d65; display: inline; font-size: 1.5em;'>Xpress</h1>" +
                        "</div>" +

                        "<div style='text-align: left; padding: 15px; background-color: #ffffff; font-size: 0.4em;'>" +
                        "<p>Hola, <strong>" + nombreCliente + "</strong>,</p>" +
                        "<p>Gracias por tu compra. Aquí están los detalles de tu viaje:</p>" +

                        "<ul>" +
                        "<li><strong>Código de Ticket:</strong> " + codigoTicket + "</li>" +
                        "<li><strong>Conductor:</strong> " + nombreConductor + "</li>" +
                        "<li><strong>Ruta:</strong> " + nombreRuta + "</li>" +
                        "<li><strong>Precio pagado:</strong> $" + precio + "</li>" +
                        "<li><strong>Fecha de salida:</strong> " + fechaSalida + "</li>" +
                        "</ul>" +

                        "<p>A continuación, te dejamos 6 recomendaciones para tener un viaje seguro:</p>" +

                        "<ol>" +
                        "<li>No se olvide su identificación personal.</li>" +
                        "<li>Usa siempre el cinturón de seguridad.</li>" +
                        "<li>Procura llegar con tiempo.</li>" +
                        "<li>Sigue las indicaciones del conductor.</li>" +
                        "<li>No distraigas al conductor mientras maneja.</li>" +
                        "<li style='color: red;'>Si viaja con un menor, tener la documentación respectiva.</li>" +
                        "</ol>" +

                        "<p><a href='https://drive.google.com/file/d/1dSKyUJcgZqWjH_hRL7mE29eAVpdaQIsF/view?usp=sharing' target='_blank'>TyC</a></p>" +
                        "</div>" +

                        "<div style='text-align: center; background-color: #161616; padding-top: 15px; padding-bottom: 15px;'>" +
                        "<h1 style='color: #ffffff; display: inline; font-size: 0.7em;'>¡Gracias por su compra!</h1>" +
                        "</div>" +
                        "</div>" +
                        "</body>";

        Properties mProperties = new Properties();
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        Session mSession = Session.getDefaultInstance(mProperties);

        try {
            MimeMessage mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setContent(template, "text/html");

            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();

            System.out.println("Correo enviado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }

}

