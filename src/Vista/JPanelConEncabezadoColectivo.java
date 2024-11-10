package Vista;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelConEncabezadoColectivo extends JPanel{
    private URL url=getClass().getResource("/imagenes/FondoEncabezado.jpg");
    Image image=new ImageIcon(url).getImage();
    
    @Override
    public void paint(Graphics grphcs){
        grphcs.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(grphcs);
    }
}
