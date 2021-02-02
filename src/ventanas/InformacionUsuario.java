package ventanas;

import javax.swing.WindowConstants;
import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class InformacionUsuario extends javax.swing.JFrame {

    String user = "", user_update = "";
    int ID;

    public InformacionUsuario() {
        initComponents();
        user = Login.user;
        user_update = GestionarUsuarios.user_update;

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información de Usuario - Sesion de " + user);
        setSize(630, 450);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Etiqueta_InfoUsuario.setText("Información del Usuario " + user_update); //Se concatena con el usuario que fue seleccionado. >>> Función en "Gestionar Usuarios".

        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios WHERE username = '" + user_update + "'");
            ResultSet rst = pst.executeQuery();

            if (rst.next()) {
                ID = rst.getInt("id_usuario"); //Se recupera el ID(PK) de el usuario para un futuro poder programar el botón de "Actualizar Usuario"

                txt_nombre.setText(rst.getString("nombre_usuario")); //Le asigno al campo txt_nombre lo que obtenga de la consulta de la columna "nombre_usuario".
                txt_email.setText(rst.getString("email"));
                txt_celular.setText(rst.getString("telefono"));
                txt_Username.setText(rst.getString("username"));
                txt_RegistradoPor.setText(rst.getString("registrado_por"));

                //Comando para los ComboBox.
                cmb_Niveles.setSelectedItem(rst.getString("tipo_nivel"));
                cmb_Estatus.setSelectedItem(rst.getString("estatus"));

            }

            con.close();

        } catch (SQLException e) {
            System.err.println("Error en cargar usuario " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar usuario. Contacte con el Ingeniero.");
        }

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png")); //No hace falta especificar el "src".
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Etiqueta_InfoUsuario = new javax.swing.JLabel();
        label_Nombre = new javax.swing.JLabel();
        label_Email = new javax.swing.JLabel();
        label_Celular = new javax.swing.JLabel();
        label_Username = new javax.swing.JLabel();
        label_Estatus = new javax.swing.JLabel();
        label_RegistradoPor = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_celular = new javax.swing.JTextField();
        txt_Username = new javax.swing.JTextField();
        txt_RegistradoPor = new javax.swing.JTextField();
        txt_PermisosDe = new javax.swing.JLabel();
        cmb_Estatus = new javax.swing.JComboBox<>();
        cmb_Niveles = new javax.swing.JComboBox<>();
        btn_ActualizarUser = new javax.swing.JButton();
        btn_RestaurarPassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        Etiqueta_InfoUsuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Etiqueta_InfoUsuario.setForeground(new java.awt.Color(0, 0, 255));
        Etiqueta_InfoUsuario.setText("Información del Usuario");

        label_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Nombre.setForeground(new java.awt.Color(0, 0, 0));
        label_Nombre.setText("Nombre:");

        label_Email.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Email.setForeground(new java.awt.Color(0, 0, 0));
        label_Email.setText("Email:");

        label_Celular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Celular.setForeground(new java.awt.Color(0, 0, 0));
        label_Celular.setText("Celular:");

        label_Username.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Username.setForeground(new java.awt.Color(0, 0, 0));
        label_Username.setText("Username:");

        label_Estatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Estatus.setForeground(new java.awt.Color(0, 0, 0));
        label_Estatus.setText("Estatus:");

        label_RegistradoPor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_RegistradoPor.setForeground(new java.awt.Color(0, 0, 0));
        label_RegistradoPor.setText("Registrado por:");
        label_RegistradoPor.setToolTipText("");

        txt_nombre.setBackground(new java.awt.Color(102, 102, 255));
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_email.setBackground(new java.awt.Color(102, 102, 255));
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_celular.setBackground(new java.awt.Color(102, 102, 255));
        txt_celular.setForeground(new java.awt.Color(255, 255, 255));
        txt_celular.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_Username.setBackground(new java.awt.Color(102, 102, 255));
        txt_Username.setForeground(new java.awt.Color(255, 255, 255));
        txt_Username.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_RegistradoPor.setBackground(new java.awt.Color(102, 102, 255));
        txt_RegistradoPor.setForeground(new java.awt.Color(255, 255, 255));
        txt_RegistradoPor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_RegistradoPor.setEnabled(false);

        txt_PermisosDe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_PermisosDe.setForeground(new java.awt.Color(0, 0, 0));
        txt_PermisosDe.setText("Permisos de:");

        cmb_Estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        cmb_Niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico" }));

        btn_ActualizarUser.setBackground(new java.awt.Color(102, 102, 255));
        btn_ActualizarUser.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        btn_ActualizarUser.setForeground(new java.awt.Color(255, 255, 255));
        btn_ActualizarUser.setText("Actualizar Usuario");
        btn_ActualizarUser.setBorder(null);
        btn_ActualizarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarUserActionPerformed(evt);
            }
        });

        btn_RestaurarPassword.setBackground(new java.awt.Color(102, 102, 255));
        btn_RestaurarPassword.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        btn_RestaurarPassword.setForeground(new java.awt.Color(255, 255, 255));
        btn_RestaurarPassword.setText("Restaurar Password");
        btn_RestaurarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RestaurarPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(txt_nombre)
                            .addComponent(label_Nombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_Email, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(184, 184, 184)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_Username)
                                    .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_Estatus)
                                    .addComponent(cmb_Estatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_PermisosDe)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmb_Niveles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_Celular)
                                .addGap(322, 322, 322))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_celular)
                                .addGap(184, 184, 184)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_RegistradoPor, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(label_RegistradoPor)
                            .addComponent(btn_ActualizarUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_RestaurarPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(Etiqueta_InfoUsuario)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Etiqueta_InfoUsuario)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Nombre)
                    .addComponent(label_Username))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Email)
                    .addComponent(label_Estatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_Estatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Celular)
                    .addComponent(label_RegistradoPor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_RegistradoPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txt_PermisosDe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_Niveles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ActualizarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btn_RestaurarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ActualizarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarUserActionPerformed
        int permisos_cmb, estatus_cmb, validacion = 0;

        String permisos_string = "", estatus_string = "", mail, nombre, username, celular;

        nombre = txt_nombre.getText().trim();
        mail = txt_email.getText().trim();
        celular = txt_celular.getText().trim();
        username = txt_Username.getText().trim();

        permisos_cmb = cmb_Niveles.getSelectedIndex() + 1;
        estatus_cmb = cmb_Estatus.getSelectedIndex() + 1;

        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.RED);
            validacion++;
        }

        if (mail.equals("")) {
            txt_email.setBackground(Color.red);
            validacion++;
        }

        if (celular.equals("")) {
            txt_celular.setBackground(Color.red);
            validacion++;
        }

        if (username.equals("")) {
            txt_Username.setBackground(Color.red);
            validacion++;
        }

        if (validacion == 0) { //Si ningún campo quedo vacío...
            if (permisos_cmb == 1) {
                permisos_string = "Administrador";
            } else if (permisos_cmb == 2) {
                permisos_string = "Capturista";
            } else if (permisos_cmb == 3) {
                permisos_string = "Tecnico";
            }

            if (estatus_cmb == 1) {
                estatus_string = "Activo";
            } else if (estatus_cmb == 2) {
                estatus_string = "Inactivo";
            }
            
            //Funcion para verificar que el nombre de usuario este disponible.
            try{
                
                Connection con = Conexion.conectar();
                //Se le dice que consulte con todos los registros y no únicamente con el que estamos seleccionando.
                PreparedStatement pst = con.prepareStatement("SELECT username FROM usuarios WHERE username = '"+username+"' and not id_usuario = '"+ID+"'"); 
                
                
                ResultSet rst = pst.executeQuery();
                
                if(rst.next()){ //Si el nombre de usuario no esta disponible...
                    
                    txt_Username.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible.","Usuario Existente",JOptionPane.WARNING_MESSAGE);
                    con.close();
                    
                }else{
                    
                    Connection con2 = Conexion.conectar();
                    PreparedStatement pst2 = con2.prepareStatement("UPDATE usuarios SET nombre_usuario = ?, email = ?, telefono = ?, username = ?, tipo_nivel = ?, estatus = ? "
                            + "WHERE id_usuario = '"+ID+"'");
                    
                    pst2.setString(1, nombre);
                    pst2.setString(2, mail);
                    pst2.setString(3, celular);
                    pst2.setString(4, username);
                    pst2.setString(5, permisos_string);
                    pst2.setString(6, estatus_string);
  
                    pst2.executeUpdate();
                    con2.close();
                    
                    JOptionPane.showMessageDialog(null, "Modificación correcta","Modificación de Usuario",JOptionPane.INFORMATION_MESSAGE);
                    
                }
                
            }catch(SQLException e){
                System.err.println(" "+e);
            }


        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
        }

    }//GEN-LAST:event_btn_ActualizarUserActionPerformed

    private void btn_RestaurarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RestaurarPasswordActionPerformed
        RestaurarPassword restaurar_password = new RestaurarPassword();
        restaurar_password.setVisible(true);
        
    }//GEN-LAST:event_btn_RestaurarPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Etiqueta_InfoUsuario;
    private javax.swing.JButton btn_ActualizarUser;
    private javax.swing.JButton btn_RestaurarPassword;
    private javax.swing.JComboBox<String> cmb_Estatus;
    private javax.swing.JComboBox<String> cmb_Niveles;
    private javax.swing.JLabel label_Celular;
    private javax.swing.JLabel label_Email;
    private javax.swing.JLabel label_Estatus;
    private javax.swing.JLabel label_Nombre;
    private javax.swing.JLabel label_RegistradoPor;
    private javax.swing.JLabel label_Username;
    private javax.swing.JLabel txt_PermisosDe;
    private javax.swing.JTextField txt_RegistradoPor;
    private javax.swing.JTextField txt_Username;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
