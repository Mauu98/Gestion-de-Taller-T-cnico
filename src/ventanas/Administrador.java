
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;


public class Administrador extends javax.swing.JFrame {
    
    String user, nombre_usuario;
    
    public static int sesion_usuario;

 
    public Administrador() {
        initComponents();
        user = Login.user; //El usuario es igual al que el inicia sesión.
        sesion_usuario = 1;
        
        
        setSize(650,430);
        setResizable(false);
        setTitle("Administrador - Sesion de "+user); //Aparecerá el username en la ventana
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Al cerrarse la ventana el programa se cierra por completo.
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg"); //Imágen de Wallpaper
        Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(label_Wallpaper.getWidth(), label_Wallpaper.getHeight(), Image.SCALE_DEFAULT)); //Se ajusta el icóno a la ventana.
        label_Wallpaper.setIcon(icon);
        this.repaint(); //Se confirma que se ve, es opcional.
        
        try{
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT nombre_usuario FROM usuarios WHERE username = '"+user+"'"); //Selecciona el username para ponerlo en la ventana.
            ResultSet rst = pst.executeQuery();
            
            if(rst.next()){
                nombre_usuario = rst.getString("nombre_usuario");
                label_NombreUsuario.setText(nombre_usuario); //Le colocamos al label superior izquierdo, el nombre del usuario que inicia sesión.
                
            }else{
                System.out.println("Error al seleccionar datos.");
            }
        }catch (SQLException e){
            System.err.println("Error en conexión desde Interfaz Administrador.");
        }
        
        
        
    }
    
      @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png")); //No hace falta especificar el "src".
        return retValue;
    }
    
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_NombreUsuario = new javax.swing.JLabel();
        btn_RegistrarUsuarios = new javax.swing.JButton();
        btn_GestionarUsuarios = new javax.swing.JButton();
        btn_Creatividad = new javax.swing.JButton();
        btn_Capturista = new javax.swing.JButton();
        btn_Tecnico = new javax.swing.JButton();
        btn_AcercaDe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_NombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        label_NombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        label_NombreUsuario.setText("jLabel1");
        getContentPane().add(label_NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_RegistrarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addUser.png"))); // NOI18N
        btn_RegistrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_RegistrarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 120, 100));
        btn_RegistrarUsuarios.getAccessibleContext().setAccessibleDescription("");

        btn_GestionarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationuser.png"))); // NOI18N
        btn_GestionarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GestionarUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_GestionarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 120, 100));

        btn_Creatividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/creatividad.png"))); // NOI18N
        getContentPane().add(btn_Creatividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 120, 100));

        btn_Capturista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/capturista.png"))); // NOI18N
        btn_Capturista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapturistaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Capturista, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 120, 100));

        btn_Tecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tecnico.png"))); // NOI18N
        btn_Tecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TecnicoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Tecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 120, 100));

        btn_AcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/geekipedia.png"))); // NOI18N
        getContentPane().add(btn_AcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 120, 100));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registrar Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestionar Usuarios");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Creatividad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Panel Vista Capturista");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Panel Vista Técnico");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Acerca de...");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, -1, -1));

        jLabel7.setText("Creado por N0x");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, -1, -1));
        getContentPane().add(label_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));
        label_Wallpaper.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RegistrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarUsuariosActionPerformed
        Registrar_Usuarios registrar_usuarios = new Registrar_Usuarios();
        registrar_usuarios.setVisible(true); //Se abre la ventana y se permite la visibilidad.
    }//GEN-LAST:event_btn_RegistrarUsuariosActionPerformed

    private void btn_GestionarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GestionarUsuariosActionPerformed
        GestionarUsuarios gestionar_usuarios = new GestionarUsuarios();
        gestionar_usuarios.setVisible(true);
        
    }//GEN-LAST:event_btn_GestionarUsuariosActionPerformed

    private void btn_CapturistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapturistaActionPerformed
        Capturista capturista = new Capturista();
        capturista.setVisible(true);
        
    }//GEN-LAST:event_btn_CapturistaActionPerformed

    private void btn_TecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TecnicoActionPerformed
        Tecnico tecnico = new Tecnico();
        tecnico.setVisible(true);
    }//GEN-LAST:event_btn_TecnicoActionPerformed

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AcercaDe;
    private javax.swing.JButton btn_Capturista;
    private javax.swing.JButton btn_Creatividad;
    private javax.swing.JButton btn_GestionarUsuarios;
    private javax.swing.JButton btn_RegistrarUsuarios;
    private javax.swing.JButton btn_Tecnico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel label_NombreUsuario;
    private javax.swing.JLabel label_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
