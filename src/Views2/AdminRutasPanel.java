/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views2;

import Models.Admin;
import Models.Conductor;
import Models.Ruta;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import kotlin.random.Random;

/**
 *
 * @author Mihae
 */
public class AdminRutasPanel extends javax.swing.JPanel {

    /**
     * Creates new form ConductoresAdmin
     */
    Admin admin;
    public AdminRutasPanel(Admin admin) {
        this.admin = admin;
        initComponents();
        correcciones_iniciales();
    }
    
    private void correcciones_iniciales(){
        id_buscar_input.setBackground(new Color(168, 168, 168));
        id_eliminar_input.setBackground(new Color(168, 168, 168));
        
        tabla_rutas.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabla_rutas.setBackground(new Color(230, 230, 230));
        tabla_datos_ruta.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabla_datos_ruta.setBackground(new Color(230, 230, 230));
    }
    
    private void listar_rutas(){
        DefaultTableModel modelo = (DefaultTableModel)tabla_rutas.getModel();
        modelo.setRowCount(0);
        
        List<Ruta> rutas = admin.ver_rutas();
        for(Ruta ruta:rutas){
            modelo.addRow(new Object[]{ruta.get_id_ruta(), ruta.get_origen(), ruta.get_destino()});
        }
        
        tabla_rutas.setModel(modelo);
    }
    
    private void ver_datos_ruta(){
        DefaultTableModel modelo = (DefaultTableModel)tabla_datos_ruta.getModel();
        modelo.setRowCount(0);
        
        String id_ruta = id_buscar_input.getText();
        Ruta ruta = admin.buscar_ruta(id_ruta);
        
        if(ruta==null){
            modelo.addRow(new Object[]{"ERROR", "ID NO EXISTE"});
        } else {
            
            long horas = ruta.get_tiempo_aproximado().toHours();
            long minutos = ruta.get_tiempo_aproximado().toMinutesPart();
            
            modelo.addRow(new Object[]{"ID Ruta", ruta.get_id_ruta()});
            modelo.addRow(new Object[]{"Origen", ruta.get_origen()});
            modelo.addRow(new Object[]{"Destino", ruta.get_destino()});
            modelo.addRow(new Object[]{"Tiempo Aproximado", String.format("%02d:%02d", horas, minutos)});
            modelo.addRow(new Object[]{"Precio", ruta.get_precio()});
        }
        
        tabla_datos_ruta.setModel(modelo);
    }
    
    private void eliminar_ruta(){
        String id_ruta = id_eliminar_input.getText();
        boolean exito = admin.eliminar_ruta(id_ruta);
        if(!exito){
            System.out.println("se deberia borrar");
            resultado_eliminar.setText("No se pudo borrar");
            return;
        }
        System.out.println("paso todo");
        resultado_eliminar.setText("Ruta eliminada!!");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        listar_rutas_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        buscar_ruta_button = new javax.swing.JButton();
        id_buscar_input = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        id_eliminar_input = new javax.swing.JTextField();
        eliminar_ruta_button = new javax.swing.JButton();
        resultado_eliminar = new javax.swing.JLabel();
        agregar_ruta_button = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_rutas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_datos_ruta = new javax.swing.JTable();
        editar_ruta_button = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1010, 580));
        setPreferredSize(new java.awt.Dimension(1010, 580));

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 23, 23));
        jLabel1.setText("Listado de Rutas");

        listar_rutas_button.setBackground(new java.awt.Color(30, 30, 30));
        listar_rutas_button.setForeground(new java.awt.Color(245, 245, 245));
        listar_rutas_button.setText("Listar Rutas");
        listar_rutas_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        listar_rutas_button.setMaximumSize(new java.awt.Dimension(170, 40));
        listar_rutas_button.setPreferredSize(new java.awt.Dimension(170, 40));
        listar_rutas_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listar_rutas_buttonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(23, 23, 23));
        jLabel2.setText("Buscar Ruta por ID");

        buscar_ruta_button.setBackground(new java.awt.Color(30, 30, 30));
        buscar_ruta_button.setForeground(new java.awt.Color(245, 245, 245));
        buscar_ruta_button.setText("Buscar Ruta");
        buscar_ruta_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        buscar_ruta_button.setMaximumSize(new java.awt.Dimension(161, 40));
        buscar_ruta_button.setMinimumSize(new java.awt.Dimension(161, 40));
        buscar_ruta_button.setPreferredSize(new java.awt.Dimension(161, 40));
        buscar_ruta_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_ruta_buttonActionPerformed(evt);
            }
        });

        id_buscar_input.setCaretColor(new java.awt.Color(168, 168, 168));

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(23, 23, 23));
        jLabel3.setText("Eliminar Ruta por ID");

        eliminar_ruta_button.setBackground(new java.awt.Color(30, 30, 30));
        eliminar_ruta_button.setForeground(new java.awt.Color(245, 245, 245));
        eliminar_ruta_button.setText("Eliminar Ruta");
        eliminar_ruta_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        eliminar_ruta_button.setMaximumSize(new java.awt.Dimension(161, 40));
        eliminar_ruta_button.setMinimumSize(new java.awt.Dimension(161, 40));
        eliminar_ruta_button.setPreferredSize(new java.awt.Dimension(161, 40));
        eliminar_ruta_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_ruta_buttonActionPerformed(evt);
            }
        });

        resultado_eliminar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        resultado_eliminar.setForeground(new java.awt.Color(44, 73, 168));

        agregar_ruta_button.setBackground(new java.awt.Color(30, 30, 30));
        agregar_ruta_button.setForeground(new java.awt.Color(245, 245, 245));
        agregar_ruta_button.setText("Agregar Ruta");
        agregar_ruta_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        agregar_ruta_button.setMaximumSize(new java.awt.Dimension(161, 40));
        agregar_ruta_button.setMinimumSize(new java.awt.Dimension(161, 40));
        agregar_ruta_button.setPreferredSize(new java.awt.Dimension(161, 40));
        agregar_ruta_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_ruta_buttonActionPerformed(evt);
            }
        });

        tabla_rutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Ruta", "Origen", "Destino"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabla_rutas);

        tabla_datos_ruta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dato", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabla_datos_ruta);

        editar_ruta_button.setBackground(new java.awt.Color(30, 30, 30));
        editar_ruta_button.setForeground(new java.awt.Color(255, 255, 255));
        editar_ruta_button.setText("Editar Ruta");
        editar_ruta_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        editar_ruta_button.setMaximumSize(new java.awt.Dimension(161, 40));
        editar_ruta_button.setMinimumSize(new java.awt.Dimension(161, 40));
        editar_ruta_button.setPreferredSize(new java.awt.Dimension(161, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(agregar_ruta_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buscar_ruta_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(75, 75, 75)
                                        .addComponent(editar_ruta_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(id_buscar_input)
                                    .addComponent(jLabel3)
                                    .addComponent(id_eliminar_input)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(eliminar_ruta_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(resultado_eliminar))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(listar_rutas_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(id_buscar_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscar_ruta_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editar_ruta_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_eliminar_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eliminar_ruta_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resultado_eliminar))
                        .addGap(46, 46, 46)
                        .addComponent(agregar_ruta_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(listar_rutas_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listar_rutas_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listar_rutas_buttonActionPerformed
        listar_rutas();
    }//GEN-LAST:event_listar_rutas_buttonActionPerformed

    private void buscar_ruta_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_ruta_buttonActionPerformed
       ver_datos_ruta();
    }//GEN-LAST:event_buscar_ruta_buttonActionPerformed

    private void eliminar_ruta_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_ruta_buttonActionPerformed
        eliminar_ruta();
    }//GEN-LAST:event_eliminar_ruta_buttonActionPerformed

    private void agregar_ruta_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_ruta_buttonActionPerformed
        AdminRutasCrear crear_ruta = new AdminRutasCrear(admin);
        crear_ruta.setVisible(true);
    }//GEN-LAST:event_agregar_ruta_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_ruta_button;
    private javax.swing.JButton buscar_ruta_button;
    private javax.swing.JButton editar_ruta_button;
    private javax.swing.JButton eliminar_ruta_button;
    private javax.swing.JTextField id_buscar_input;
    private javax.swing.JTextField id_eliminar_input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton listar_rutas_button;
    private javax.swing.JLabel resultado_eliminar;
    private javax.swing.JTable tabla_datos_ruta;
    private javax.swing.JTable tabla_rutas;
    // End of variables declaration//GEN-END:variables
}
