package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;

public class RegistrarClientes extends javax.swing.JFrame {
    
    String user = "";
    
    public RegistrarClientes() {
        user = Login.user;
        
        initComponents();
        setTitle("Registrar nuevo Cliente - " + user);
        setSize(530, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
     
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png")); //No hace falta especificar el "src".
        return retValue;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_RegistrarClientes = new javax.swing.JLabel();
        label_EtiquetaNombre = new javax.swing.JLabel();
        label_EtiquetaNombre1 = new javax.swing.JLabel();
        label_EtiquetaNombre2 = new javax.swing.JLabel();
        label_EtiquetaNombre3 = new javax.swing.JLabel();
        label_EtiquetaNombre4 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_celular = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        btn_addUser = new javax.swing.JButton();
        label_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_RegistrarClientes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_RegistrarClientes.setForeground(new java.awt.Color(0, 0, 204));
        label_RegistrarClientes.setText("Registrar Clientes");
        getContentPane().add(label_RegistrarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        label_EtiquetaNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_EtiquetaNombre.setForeground(new java.awt.Color(0, 0, 0));
        label_EtiquetaNombre.setText("Nombre:");
        getContentPane().add(label_EtiquetaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        label_EtiquetaNombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_EtiquetaNombre1.setForeground(new java.awt.Color(0, 0, 0));
        label_EtiquetaNombre1.setText("Email:");
        getContentPane().add(label_EtiquetaNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        label_EtiquetaNombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_EtiquetaNombre2.setForeground(new java.awt.Color(0, 0, 0));
        label_EtiquetaNombre2.setText("Celular:");
        getContentPane().add(label_EtiquetaNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        label_EtiquetaNombre3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_EtiquetaNombre3.setForeground(new java.awt.Color(0, 0, 0));
        label_EtiquetaNombre3.setText("Direccion:");
        getContentPane().add(label_EtiquetaNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        label_EtiquetaNombre4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_EtiquetaNombre4.setForeground(new java.awt.Color(0, 0, 0));
        label_EtiquetaNombre4.setText(" Registrar Cliente");
        getContentPane().add(label_EtiquetaNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(102, 102, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_email.setBackground(new java.awt.Color(102, 102, 255));
        txt_email.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        txt_celular.setBackground(new java.awt.Color(102, 102, 255));
        txt_celular.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_celular.setForeground(new java.awt.Color(255, 255, 255));
        txt_celular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_celular.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        txt_direccion.setBackground(new java.awt.Color(102, 102, 255));
        txt_direccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        btn_addUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addUserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 120, 100));
        getContentPane().add(label_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addUserActionPerformed
        int validacion = 0;
        String nombre, mail, telefono, direccion;
        
        nombre = txt_nombre.getText().trim();
        mail = txt_email.getText().trim();
        telefono = txt_celular.getText().trim();
        direccion = txt_direccion.getText().trim();
        
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        }
        
        if (mail.equals("")) {
            txt_email.setBackground(Color.red);
            validacion++;
        }
        
        if (telefono.equals("")) {
            txt_celular.setBackground(Color.red);
            validacion++;
        }
        
        if (direccion.equals("")) {
            txt_direccion.setBackground(Color.red);
            validacion++;
        }
        
        if (validacion == 0) {
            try {
                
                Connection con = Conexion.conectar();
                PreparedStatement pst = con.prepareStatement("INSERT INTO clientes VALUES (?,?,?,?,?,?)");
                pst.setInt(1, 0); //Va 0 porque el ID se pone automáticamente.
                pst.setString(2, nombre);
                pst.setString(3, mail);
                pst.setString(4, telefono);
                pst.setString(5, direccion);
                pst.setString(6, user); //Registrado por:
                
                pst.executeUpdate();
                con.close();
                Limpiar();
                
                txt_nombre.setBackground(Color.GREEN);
                txt_email.setBackground(Color.GREEN);
                txt_celular.setBackground(Color.GREEN);
                txt_direccion.setBackground(Color.GREEN);
                
                JOptionPane.showMessageDialog(null, "Registro de Cliente exitoso", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                
            } catch (SQLException e) {
                System.err.println("Error al intentar registrar cliente " + e);
                JOptionPane.showMessageDialog(null, "Error al registrar cliente. Contacte con el Ingeniero Pino", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btn_addUserActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addUser;
    private javax.swing.JLabel label_EtiquetaNombre;
    private javax.swing.JLabel label_EtiquetaNombre1;
    private javax.swing.JLabel label_EtiquetaNombre2;
    private javax.swing.JLabel label_EtiquetaNombre3;
    private javax.swing.JLabel label_EtiquetaNombre4;
    private javax.swing.JLabel label_RegistrarClientes;
    private javax.swing.JLabel label_Wallpaper;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
    public void Limpiar() {
        txt_nombre.setText("");
        txt_email.setText("");
        txt_celular.setText("");
        txt_direccion.setText("");
    }
    
}
