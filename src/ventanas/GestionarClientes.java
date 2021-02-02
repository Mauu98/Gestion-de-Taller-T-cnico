
package ventanas;
import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class GestionarClientes extends javax.swing.JFrame {
    
    String user;
    
    public static int ID_cliente_update = 0; //Permite enviar mensajes entre interfaces.
    DefaultTableModel model = new DefaultTableModel();
    
    
    
 
    public GestionarClientes() {
        initComponents();
        user = Login.user;
        setSize(630,330);
        setTitle("Capturista - Sesion de "+user);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        
        
         try{
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT id_cliente, nombre_cliente, mail_cliente, tel_cliente, ultima_modificacion FROM clientes");
            ResultSet rst = pst.executeQuery();
            
            tabla_Clientes = new JTable(model);
            jScrollPane1.setViewportView(tabla_Clientes); //Le indicamos que nuestra tabla está dentro de el Scroll.
            
            model.addColumn(" "); //ID se pone automático
            model.addColumn("Nombre");
            model.addColumn("Mail");
            model.addColumn("Teléfono");
            model.addColumn("Modificado por");
            
            while(rst.next()){ //Mientras encuentre registros...
                Object [] fila = new Object[5]; //5 posiciones o 5 elementos.
                for(int x = 0; x < 5; x++){
                    fila[x] = rst.getObject(x + 1); //Se pone x+1 para empezar desde el 1, ya que la X empieza en 0, si empezara en 1, no haría falta poner el x + 1.
                    
                }
                
                model.addRow(fila); //Agrega los registros que encontro en cada fila
                
            }
            
            con.close();
            
        }catch(SQLException e){
            System.err.println("Error al llenar la tabla "+e);
        }
         
         tabla_Clientes.addMouseListener(new MouseAdapter() { //Evento para escuchar los clicks al clickear en un cliente.
             @Override
             public void mouseClicked(MouseEvent e){
                 int fila_point = tabla_Clientes.rowAtPoint(e.getPoint()); //Se obtienen las coordenadas de donde estamos haciendo click.
                 int columna_point = 0;
                 
                 if(fila_point > -1){ //Si el usuario a dado click en un valor que es mayor a -1, se ejecuta el código..
                     ID_cliente_update = (int) model.getValueAt(fila_point, columna_point); //Obtenemos el ID que clickeamos
                     Informacion_Cliente informacion_cliente = new Informacion_Cliente();
                     informacion_cliente.setVisible(true);
         
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

        label_EtiquetaGestionarClientes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Clientes = new javax.swing.JTable();
        label_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_EtiquetaGestionarClientes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_EtiquetaGestionarClientes.setForeground(new java.awt.Color(0, 0, 255));
        label_EtiquetaGestionarClientes.setText("Gestionar Clientes");
        label_EtiquetaGestionarClientes.setName(""); // NOI18N
        getContentPane().add(label_EtiquetaGestionarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        tabla_Clientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_Clientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));
        getContentPane().add(label_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GestionarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_EtiquetaGestionarClientes;
    private javax.swing.JLabel label_Wallpaper;
    private javax.swing.JTable tabla_Clientes;
    // End of variables declaration//GEN-END:variables
}
