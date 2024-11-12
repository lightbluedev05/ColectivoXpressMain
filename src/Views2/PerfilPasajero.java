/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views2;

import Models.Pasajero;

/**
 *
 * @author Mihae
 */
public class PerfilPasajero extends javax.swing.JPanel {

    /**
     * Creates new form PerfilAdmin
     */
    
    private Pasajero pasajero;
    public PerfilPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
        initComponents();
        nuevo_contra_label.setVisible(false);
        nuevo_contra_input.setVisible(false);
        nuevo_contra_button.setVisible(false);
        
        nuevo_nombre_label.setVisible(false);
        nuevo_nombre_input.setVisible(false);
        nuevo_nombre_button.setVisible(false);
        
        nuevo_distrito_label.setVisible(false);
        nuevo_distrito_input.setVisible(false);
        nuevo_distrito_button.setVisible(false);
        
        nuevo_provincia_label.setVisible(false);
        nuevo_provincia_input.setVisible(false);
        nuevo_provincia_button.setVisible(false);
        
        nuevo_departamento_label.setVisible(false);
        nuevo_departamento_input.setVisible(false);
        nuevo_departamento_button.setVisible(false);
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
        jLabel1 = new javax.swing.JLabel();
        nuevo_contra_label = new javax.swing.JLabel();
        nuevo_contra_input = new javax.swing.JPasswordField();
        nuevo_contra_button = new javax.swing.JButton();
        nuevo_contra_message = new javax.swing.JLabel();
        nuevo_nombre_label = new javax.swing.JLabel();
        nuevo_nombre_input = new javax.swing.JTextField();
        nuevo_nombre_button = new javax.swing.JButton();
        nuevo_nombre_message = new javax.swing.JLabel();
        nuevo_distrito_label = new javax.swing.JLabel();
        nuevo_distrito_input = new javax.swing.JTextField();
        nuevo_distrito_button = new javax.swing.JButton();
        nuevo_distrito_message = new javax.swing.JLabel();
        nuevo_provincia_label = new javax.swing.JLabel();
        nuevo_provincia_input = new javax.swing.JTextField();
        nuevo_provincia_button = new javax.swing.JButton();
        nuevo_provincia_message = new javax.swing.JLabel();
        nuevo_departamento_label = new javax.swing.JLabel();
        nuevo_departamento_input = new javax.swing.JTextField();
        nuevo_departamento_button = new javax.swing.JButton();
        nuevo_departamento_message = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 20, 20));
        jLabel1.setText("Ingrese su contraseña para modificar sus datos");

        nuevo_contra_label.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        nuevo_contra_label.setForeground(new java.awt.Color(20, 20, 20));
        nuevo_contra_label.setText("Actualizar contraseña");

        nuevo_contra_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_contra_inputActionPerformed(evt);
            }
        });

        nuevo_contra_button.setText("Modificar");
        nuevo_contra_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_contra_buttonActionPerformed(evt);
            }
        });

        nuevo_nombre_label.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        nuevo_nombre_label.setForeground(new java.awt.Color(20, 20, 20));
        nuevo_nombre_label.setText("Actualiza nombre");

        nuevo_nombre_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_nombre_inputActionPerformed(evt);
            }
        });

        nuevo_nombre_button.setText("Modificar");
        nuevo_nombre_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_nombre_buttonActionPerformed(evt);
            }
        });

        nuevo_distrito_label.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        nuevo_distrito_label.setForeground(new java.awt.Color(20, 20, 20));
        nuevo_distrito_label.setText("Actualiza distrito");

        nuevo_distrito_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_distrito_inputActionPerformed(evt);
            }
        });

        nuevo_distrito_button.setText("Modificar");
        nuevo_distrito_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_distrito_buttonActionPerformed(evt);
            }
        });

        nuevo_provincia_label.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        nuevo_provincia_label.setForeground(new java.awt.Color(20, 20, 20));
        nuevo_provincia_label.setText("Actualiza provincia");

        nuevo_provincia_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_provincia_inputActionPerformed(evt);
            }
        });

        nuevo_provincia_button.setText("Modificar");
        nuevo_provincia_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_provincia_buttonActionPerformed(evt);
            }
        });

        nuevo_departamento_label.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        nuevo_departamento_label.setForeground(new java.awt.Color(20, 20, 20));
        nuevo_departamento_label.setText("Actualiza departamento");

        nuevo_departamento_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_departamento_inputActionPerformed(evt);
            }
        });

        nuevo_departamento_button.setText("Modificar");
        nuevo_departamento_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_departamento_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nuevo_departamento_label)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nuevo_departamento_input, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nuevo_departamento_button)
                        .addGap(18, 18, 18)
                        .addComponent(nuevo_departamento_message))
                    .addComponent(nuevo_nombre_label)
                    .addComponent(jLabel1)
                    .addComponent(ingresar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contra_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo_contra_label)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nuevo_provincia_label, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(nuevo_provincia_input, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(nuevo_provincia_button)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(nuevo_nombre_input, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(nuevo_nombre_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(nuevo_contra_input, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(nuevo_contra_button))
                                .addComponent(nuevo_distrito_label, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(nuevo_distrito_input, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(nuevo_distrito_button))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nuevo_nombre_message)
                            .addComponent(nuevo_contra_message)
                            .addComponent(nuevo_distrito_message)
                            .addComponent(nuevo_provincia_message))))
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contra_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ingresar_button)
                .addGap(40, 40, 40)
                .addComponent(nuevo_contra_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevo_contra_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo_contra_button)
                    .addComponent(nuevo_contra_message))
                .addGap(18, 18, 18)
                .addComponent(nuevo_nombre_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevo_nombre_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo_nombre_button)
                    .addComponent(nuevo_nombre_message))
                .addGap(18, 18, 18)
                .addComponent(nuevo_distrito_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevo_distrito_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo_distrito_button)
                    .addComponent(nuevo_distrito_message))
                .addGap(18, 18, 18)
                .addComponent(nuevo_provincia_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevo_provincia_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo_provincia_button)
                    .addComponent(nuevo_provincia_message))
                .addGap(18, 18, 18)
                .addComponent(nuevo_departamento_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevo_departamento_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo_departamento_button)
                    .addComponent(nuevo_departamento_message))
                .addContainerGap(99, Short.MAX_VALUE))
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
        if(pasajero.get_contrasena().equals(contra)){
            nuevo_contra_label.setVisible(true);
            nuevo_contra_input.setVisible(true);
            nuevo_contra_button.setVisible(true);
            
            nuevo_nombre_label.setVisible(true);
            nuevo_nombre_input.setVisible(true);
            nuevo_nombre_button.setVisible(true);

            nuevo_distrito_label.setVisible(true);
            nuevo_distrito_input.setVisible(true);
            nuevo_distrito_button.setVisible(true);

            nuevo_provincia_label.setVisible(true);
            nuevo_provincia_input.setVisible(true);
            nuevo_provincia_button.setVisible(true);

            nuevo_departamento_label.setVisible(true);
            nuevo_departamento_input.setVisible(true);
            nuevo_departamento_button.setVisible(true);
        }
    }//GEN-LAST:event_ingresar_buttonActionPerformed

    private void nuevo_contra_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_contra_buttonActionPerformed
        String contra = new String(nuevo_contra_input.getPassword());
        
        if(contra.isEmpty()){
            nuevo_contra_message.setText("Ingrese una contraseña valida");
            return;
        }
        
        boolean exito = pasajero.actualizar_contrasena(contra);
        if(!exito){
            nuevo_contra_message.setText("No se pudo cambiar la contraseña");
            return;
        }
        nuevo_contra_message.setText("Contraseña cambiada exitosamente!!");
    }//GEN-LAST:event_nuevo_contra_buttonActionPerformed

    private void nuevo_nombre_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_nombre_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevo_nombre_inputActionPerformed

    private void nuevo_contra_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_contra_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevo_contra_inputActionPerformed

    private void nuevo_distrito_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_distrito_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevo_distrito_inputActionPerformed

    private void nuevo_provincia_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_provincia_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevo_provincia_inputActionPerformed

    private void nuevo_departamento_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_departamento_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevo_departamento_inputActionPerformed

    private void nuevo_nombre_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_nombre_buttonActionPerformed
        String nombre = new String(nuevo_nombre_input.getText());
        
        if(nombre.isEmpty()){
            nuevo_nombre_message.setText("Ingrese un nombre valido");
            return;
        }
     
        boolean exito = pasajero.actualizar_nombre(nombre);
        if(!exito){
            nuevo_nombre_message.setText("No se pudo cambiar el nombre");
            return;
        }
        nuevo_nombre_message.setText("Nombre cambiado exitosamente!!");
    }//GEN-LAST:event_nuevo_nombre_buttonActionPerformed

    private void nuevo_distrito_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_distrito_buttonActionPerformed
        String distrito = new String(nuevo_distrito_input.getText());
        
        if(distrito.isEmpty()){
            nuevo_distrito_message.setText("Ingrese un distrito valido");
            return;
        }
     
        boolean exito = pasajero.actualizar_distrito(distrito);
        if(!exito){
            nuevo_distrito_message.setText("No se pudo cambiar el distrito");
            return;
        }
        nuevo_distrito_message.setText("Distrito cambiado exitosamente!!");
    }//GEN-LAST:event_nuevo_distrito_buttonActionPerformed

    private void nuevo_provincia_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_provincia_buttonActionPerformed
        String provincia = new String(nuevo_provincia_input.getText());
        
        if(provincia.isEmpty()){
            nuevo_provincia_message.setText("Ingrese una provincia valida");
            return;
        }
     
        boolean exito = pasajero.actualizar_provincia(provincia);
        if(!exito){
            nuevo_provincia_message.setText("No se pudo cambiar la provincia");
            return;
        }
        nuevo_provincia_message.setText("Provincia cambiada exitosamente!!");
    }//GEN-LAST:event_nuevo_provincia_buttonActionPerformed

    private void nuevo_departamento_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_departamento_buttonActionPerformed
        String departamento = new String(nuevo_departamento_input.getText());
        
        if(departamento.isEmpty()){
            nuevo_departamento_message.setText("Ingrese un departamento valido");
            return;
        }
     
        boolean exito = pasajero.actualizar_departamento(departamento);
        if(!exito){
            nuevo_departamento_message.setText("No se pudo cambiar el departamento");
            return;
        }
        nuevo_departamento_message.setText("Departamento cambiado exitosamente!!");
    }//GEN-LAST:event_nuevo_departamento_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contra_input;
    private javax.swing.JButton ingresar_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nuevo_contra_button;
    private javax.swing.JPasswordField nuevo_contra_input;
    private javax.swing.JLabel nuevo_contra_label;
    private javax.swing.JLabel nuevo_contra_message;
    private javax.swing.JButton nuevo_departamento_button;
    private javax.swing.JTextField nuevo_departamento_input;
    private javax.swing.JLabel nuevo_departamento_label;
    private javax.swing.JLabel nuevo_departamento_message;
    private javax.swing.JButton nuevo_distrito_button;
    private javax.swing.JTextField nuevo_distrito_input;
    private javax.swing.JLabel nuevo_distrito_label;
    private javax.swing.JLabel nuevo_distrito_message;
    private javax.swing.JButton nuevo_nombre_button;
    private javax.swing.JTextField nuevo_nombre_input;
    private javax.swing.JLabel nuevo_nombre_label;
    private javax.swing.JLabel nuevo_nombre_message;
    private javax.swing.JButton nuevo_provincia_button;
    private javax.swing.JTextField nuevo_provincia_input;
    private javax.swing.JLabel nuevo_provincia_label;
    private javax.swing.JLabel nuevo_provincia_message;
    // End of variables declaration//GEN-END:variables
}