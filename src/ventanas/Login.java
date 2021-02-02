
package ventanas;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.sql.*;
import clases.Conexion;
import javax.swing.JOptionPane;



public class Login extends javax.swing.JFrame {
    
    public static String user = "";
    String pass = "";

    
    public Login() {
        initComponents();
        setSize(400,570); //Se confirman las medidas que le pusimos a la ventana.
        setResizable(false); //El usuario no puede modificar las medidas.
        setTitle("Acceso al Sistema"); //Titulo de la Ventana.
        this.setLocationRelativeTo(null);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg"); //Imágen de Wallpaper
        Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(label_Commentario.getWidth(), label_Commentario.getHeight(), Image.SCALE_DEFAULT)); //Se ajusta el icóno a la ventana.
        label_Commentario.setIcon(icon);
        this.repaint(); //Se confirma que se ve, es opcional.
        
        ImageIcon wallpaper_logo = new ImageIcon("src/images/DS.png");
        Icon icono_logo = new ImageIcon(wallpaper_logo.getImage().getScaledInstance(label_Logo.getWidth(),label_Logo.getHeight(), Image.SCALE_DEFAULT)); //REDIMENSIONAR EL LOGO AL TAMAÑO DE LA VENTANA, O AJUSTAR.
        label_Logo.setIcon(icono_logo);
        this.repaint();
    }
    
    //Poner icono a la ventana.
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png")); //No hace falta especificar el "src".
        return retValue;
    }
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_Logo = new javax.swing.JLabel();
        label_Commentario = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        label_Password = new javax.swing.JLabel();
        label_Usuario = new javax.swing.JLabel();
        btn_Acceder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(label_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 270, 230));

        label_Commentario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_Commentario.setText("Sistema de Gestión Técnica");
        label_Commentario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(label_Commentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 270, -1));

        txt_user.setBackground(new java.awt.Color(153, 153, 153));
        txt_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_user.setForeground(new java.awt.Color(0, 0, 0));
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 210, 30));

        txt_password.setBackground(new java.awt.Color(153, 153, 153));
        txt_password.setForeground(new java.awt.Color(0, 0, 0));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 210, 30));

        label_Password.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_Password.setForeground(new java.awt.Color(0, 0, 0));
        label_Password.setText("Contraseña:");
        getContentPane().add(label_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 110, -1));

        label_Usuario.setBackground(new java.awt.Color(102, 51, 255));
        label_Usuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_Usuario.setForeground(new java.awt.Color(0, 0, 0));
        label_Usuario.setText("Usuario:");
        getContentPane().add(label_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 100, 30));

        btn_Acceder.setBackground(new java.awt.Color(102, 255, 0));
        btn_Acceder.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_Acceder.setForeground(new java.awt.Color(0, 0, 0));
        btn_Acceder.setText("Acceder");
        btn_Acceder.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AccederActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 260, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void btn_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AccederActionPerformed
        user = txt_user.getText().trim();
        pass = txt_password.getText().trim();
        
        if(!user.equals("") || !pass.equals("")){ //Si los campos de Usuario y Password son distintos a CAMPOS VACIOS = "", se ejecuta el programa. Si son iguales a CAMPOS VACÍOS, tira el error.
          
            try{
              Connection con = Conexion.conectar();
              PreparedStatement pst = con.prepareStatement("SELECT tipo_nivel, estatus FROM usuarios WHERE username ='"+user+"'and password = '"+pass+"'");
              ResultSet rst = pst.executeQuery();
              
              if(rst.next()){
                  String tipo_nivel = rst.getString("tipo_nivel");
                  String estatus = rst.getString("estatus");
                  
                  if(tipo_nivel.equalsIgnoreCase("Administrador") && estatus.equalsIgnoreCase("Activo")){
                      dispose(); //Cierra la interfaz del Login.
                      new Administrador().setVisible(true); //Se abre la ventana de Administrador.
                      
                  } else if(tipo_nivel.equalsIgnoreCase("Capturista") && estatus.equalsIgnoreCase("Activo")){
                      dispose();
                      new Capturista().setVisible(true);
                      
                  } else if(tipo_nivel.equalsIgnoreCase("Tecnico") && estatus.equalsIgnoreCase("Activo")) {
                      dispose();
                      new Tecnico().setVisible(true);
                  }
                  
              }else{
                  JOptionPane.showMessageDialog(null, "Datos incorrectos. Intente nuevamente", "Datos incorrectos",JOptionPane.WARNING_MESSAGE);
                  txt_user.setText("");
                  txt_password.setText("");
              }
              
          }catch (SQLException e){
              System.out.println("Error en el boton Acceder"+e);
              JOptionPane.showMessageDialog(null, "Error al iniciar sesión. Contacte al Administrador del Sistema", "Error 320",JOptionPane.ERROR_MESSAGE);
          }
        }else{
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Campos vacíos",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_AccederActionPerformed


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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Acceder;
    private javax.swing.JLabel label_Commentario;
    private javax.swing.JLabel label_Logo;
    private javax.swing.JLabel label_Password;
    private javax.swing.JLabel label_Usuario;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
