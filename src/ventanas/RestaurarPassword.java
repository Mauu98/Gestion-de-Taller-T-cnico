
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;

public class RestaurarPassword extends javax.swing.JFrame {
    
    String user = "", user_update = "";
    
    

   
    public RestaurarPassword() {
        initComponents();
        user = Login.user;
        user_update = GestionarUsuarios.user_update;
        
        setSize(360,290);
        setResizable(false);
        setTitle("Reseteo de Password - Sesión de "+user_update);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
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
        label_nuevaPassword = new javax.swing.JLabel();
        label_ConfirmarPassword = new javax.swing.JLabel();
        txt_nuevaPassword = new javax.swing.JPasswordField();
        txt_confirmarPassword = new javax.swing.JPasswordField();
        btn_RestaurarPass = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        Etiqueta_InfoUsuario.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        Etiqueta_InfoUsuario.setForeground(new java.awt.Color(0, 0, 255));
        Etiqueta_InfoUsuario.setText("Restaurar Password ");

        label_nuevaPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_nuevaPassword.setForeground(new java.awt.Color(0, 0, 0));
        label_nuevaPassword.setText("Nueva Password:");

        label_ConfirmarPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_ConfirmarPassword.setForeground(new java.awt.Color(0, 0, 0));
        label_ConfirmarPassword.setText("Confirmar Password:");

        txt_nuevaPassword.setBackground(new java.awt.Color(102, 102, 255));
        txt_nuevaPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nuevaPassword.setForeground(new java.awt.Color(255, 255, 255));
        txt_nuevaPassword.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_confirmarPassword.setBackground(new java.awt.Color(102, 102, 255));
        txt_confirmarPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_confirmarPassword.setForeground(new java.awt.Color(255, 255, 255));
        txt_confirmarPassword.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_RestaurarPass.setBackground(new java.awt.Color(51, 204, 0));
        btn_RestaurarPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_RestaurarPass.setForeground(new java.awt.Color(0, 0, 0));
        btn_RestaurarPass.setText("Restaurar Password");
        btn_RestaurarPass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_RestaurarPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RestaurarPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_RestaurarPass, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label_ConfirmarPassword)
                            .addComponent(label_nuevaPassword)
                            .addComponent(txt_nuevaPassword)
                            .addComponent(txt_confirmarPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(Etiqueta_InfoUsuario)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Etiqueta_InfoUsuario)
                .addGap(32, 32, 32)
                .addComponent(label_nuevaPassword)
                .addGap(18, 18, 18)
                .addComponent(txt_nuevaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(label_ConfirmarPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_confirmarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_RestaurarPass, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RestaurarPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RestaurarPassActionPerformed
        String password, confirmar_password;
        
        password = txt_nuevaPassword.getText().trim();
        confirmar_password = txt_confirmarPassword.getText().trim();
        
        if(!password.equals("") && !confirmar_password.equals("")){
            
            if(password.equals(confirmar_password)){
                
                try{
                    Connection con = Conexion.conectar();
                    PreparedStatement pst = con.prepareStatement("UPDATE usuarios SET password = ? WHERE username = '"+user_update+"'");
                    pst.setString(1, password);
                    
                    pst.executeUpdate();
                    con.close();
                    
                    txt_nuevaPassword.setBackground(Color.GREEN);
                    txt_confirmarPassword.setBackground(Color.GREEN);
                    JOptionPane.showMessageDialog(null, "Restauración de Password exitosa","Password actualizada",JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    
                    
                    
                }catch(SQLException e){
                    System.err.println("Error al guardar contraseña en Base de Datos "+e);
                }
                
            }else{
                txt_confirmarPassword.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.","Contraseñas sin coincidencia",JOptionPane.ERROR_MESSAGE);
            }
            
        }else{
            txt_nuevaPassword.setBackground(Color.red);
            txt_confirmarPassword.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "No se admiten contraseñas vacías.","Contraseña vacía",JOptionPane.WARNING_MESSAGE);
            
            
        }
        
    }//GEN-LAST:event_btn_RestaurarPassActionPerformed

 
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurarPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Etiqueta_InfoUsuario;
    private javax.swing.JButton btn_RestaurarPass;
    private javax.swing.JLabel label_ConfirmarPassword;
    private javax.swing.JLabel label_nuevaPassword;
    private javax.swing.JPasswordField txt_confirmarPassword;
    private javax.swing.JPasswordField txt_nuevaPassword;
    // End of variables declaration//GEN-END:variables
}
