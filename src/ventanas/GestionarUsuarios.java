/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauri98
 */
public class GestionarUsuarios extends javax.swing.JFrame {

    String user;

    public static String user_update = "";
    DefaultTableModel model = new DefaultTableModel();

    public GestionarUsuarios() {
        initComponents();
        user = Login.user;
        setResizable(false);
        setSize(630, 330);
        setTitle("Usuarios registrados - Sesión de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT id_usuario, nombre_usuario, username, tipo_nivel, estatus FROM usuarios ");

            ResultSet rst = pst.executeQuery();

            table_Usuarios = new JTable(model);
            jScrollPane1.setViewportView(table_Usuarios); //Se le coloca a la tabla un scroll al costado.
            model.addColumn(" ");
            model.addColumn("Nombre");
            model.addColumn("Username");
            model.addColumn("Permisos");
            model.addColumn("Estatus");

            while (rst.next()) { //Mientras se encuentren los datos en la DB..
                Object[] fila = new Object[5]; //Se pone el número 5 porque hay 5 columnas.

                for (int x = 0; x < 5; x++) {
                    fila[x] = rst.getObject(x + 1); //Mediante un ciclo For se van poniendo datos en cada fila.

                }

                model.addRow(fila);
            }

            con.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar la table " + e);
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla. Contacte al administrador.");

        }

        table_Usuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = table_Usuarios.rowAtPoint(e.getPoint());
                int columna_point = 2;

                if (fila_point > -1) {
                    user_update = (String) model.getValueAt(fila_point, columna_point); //Se guarda en la variable el usuario que ha sido seleccionado.
                    InformacionUsuario informacion_usuario = new InformacionUsuario();
                    informacion_usuario.setVisible(true);

                }
            }
        });

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png")); //No hace falta especificar el "src".
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_EtiquetaUsuariosRegistrados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Usuarios = new javax.swing.JTable();
        label_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_EtiquetaUsuariosRegistrados.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_EtiquetaUsuariosRegistrados.setForeground(new java.awt.Color(0, 0, 255));
        label_EtiquetaUsuariosRegistrados.setText("Usuarios Registrados");
        label_EtiquetaUsuariosRegistrados.setName(""); // NOI18N
        getContentPane().add(label_EtiquetaUsuariosRegistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        table_Usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table_Usuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        label_Wallpaper.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(label_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_EtiquetaUsuariosRegistrados;
    private javax.swing.JLabel label_Wallpaper;
    private javax.swing.JTable table_Usuarios;
    // End of variables declaration//GEN-END:variables
}
