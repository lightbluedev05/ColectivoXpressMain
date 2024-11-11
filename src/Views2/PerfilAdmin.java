/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views2;

import Models.Admin;

/**
 *
 * @author Mihae
 */
public class PerfilAdmin extends javax.swing.JPanel {

    /**
     * Creates new form PerfilAdmin
     */
    
    private Admin admin;
    public PerfilAdmin(Admin admin) {
        this.admin = admin;
        initComponents();
        nuevo_codigo_label.setVisible(false);
        nuevo_codigo_input.setVisible(false);
        nuevo_codigo_button.setVisible(false);
        nuevo_contra_label.setVisible(false);
        nuevo_contra_input.setVisible(false);
        nuevo_contra_button.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        contra_input = new javax.swing.JPasswordField();
        ingresar_button = new javax.swing.JButton();
        nuevo_codigo_label = new javax.swing.JLabel();
        nuevo_codigo_input = new javax.swing.JTextField();
        nuevo_codigo_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nuevo_contra_label = new javax.swing.JLabel();
        nuevo_contra_input = new javax.swing.JPasswordField();
        nuevo_contra_button = new javax.swing.JButton();
        nuevo_codigo_message = new javax.swing.JLabel();
        nuevo_contra_message = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1010, 580));

        jPanel1.setMaximumSize(new java.awt.Dimension(1010, 580));
        jPanel1.setPreferredSize(new java.awt.Dimension(1010, 580));

        contra_input.setMinimumSize(new java.awt.Dimension(370, 22));
        contra_input.setPreferredSize(new java.awt.Dimension(370, 22));

        ingresar_button.setText("Ingresar");
        ingresar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresar_buttonActionPerformed(evt);
            }
        });

        nuevo_codigo_label.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        nuevo_codigo_label.setForeground(new java.awt.Color(20, 20, 20));
        nuevo_codigo_label.setText("Actualizar codigo");

        nuevo_codigo_button.setText("Modificar");
        nuevo_codigo_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_codigo_buttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 20, 20));
        jLabel1.setText("Ingrese su contraseña para modificar sus datos");

        nuevo_contra_label.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        nuevo_contra_label.setForeground(new java.awt.Color(20, 20, 20));
        nuevo_contra_label.setText("Actualizar contraseña");

        nuevo_contra_button.setText("Modificar");
        nuevo_contra_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_contra_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nuevo_contra_label)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nuevo_contra_input, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nuevo_codigo_label, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ingresar_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nuevo_codigo_input, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contra_input, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nuevo_contra_button)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nuevo_codigo_button)
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nuevo_contra_message)
                                    .addComponent(nuevo_codigo_message))))))
                .addContainerGap(371, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contra_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ingresar_button)
                .addGap(78, 78, 78)
                .addComponent(nuevo_codigo_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevo_codigo_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo_codigo_button)
                    .addComponent(nuevo_codigo_message))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nuevo_contra_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevo_contra_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo_contra_button)
                    .addComponent(nuevo_contra_message))
                .addContainerGap(199, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ingresar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresar_buttonActionPerformed
        String contra = new String(contra_input.getPassword());
        if(admin.get_contrasena().equals(contra)){
            nuevo_codigo_label.setVisible(true);
            nuevo_codigo_input.setVisible(true);
            nuevo_codigo_button.setVisible(true);
            nuevo_contra_label.setVisible(true);
            nuevo_contra_input.setVisible(true);
            nuevo_contra_button.setVisible(true);
        }
    }//GEN-LAST:event_ingresar_buttonActionPerformed

    private void nuevo_codigo_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_codigo_buttonActionPerformed
        String codigo = nuevo_codigo_input.getText();
        
        if(codigo.isEmpty()){
            nuevo_codigo_message.setText("Ingrese un codigo valido");
            return;
        }
        
        boolean exito = admin.actualizar_codigo(codigo);
        if(!exito){
            nuevo_codigo_message.setText("No se pudo cambiar el codigo");
            return;
        }
        nuevo_codigo_message.setText("Codigo cambiado exitosamente!!");
    }//GEN-LAST:event_nuevo_codigo_buttonActionPerformed

    private void nuevo_contra_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_contra_buttonActionPerformed
        String contra = new String(nuevo_contra_input.getPassword());
        
        if(contra.isEmpty()){
            nuevo_contra_message.setText("Ingrese una contraseña valida");
            return;
        }
        
        boolean exito = admin.actualizar_contrasena(contra);
        if(!exito){
            nuevo_contra_message.setText("No se pudo cambiar la contraseña");
            return;
        }
        nuevo_contra_message.setText("Contraseña cambiada exitosamente!!");
    }//GEN-LAST:event_nuevo_contra_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contra_input;
    private javax.swing.JButton ingresar_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nuevo_codigo_button;
    private javax.swing.JTextField nuevo_codigo_input;
    private javax.swing.JLabel nuevo_codigo_label;
    private javax.swing.JLabel nuevo_codigo_message;
    private javax.swing.JButton nuevo_contra_button;
    private javax.swing.JPasswordField nuevo_contra_input;
    private javax.swing.JLabel nuevo_contra_label;
    private javax.swing.JLabel nuevo_contra_message;
    // End of variables declaration//GEN-END:variables
}
