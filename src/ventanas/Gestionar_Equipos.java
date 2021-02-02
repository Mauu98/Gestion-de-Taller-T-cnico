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

public class Gestionar_Equipos extends javax.swing.JFrame {

    String user;

    public static int ID_equipo_update = 0; //Permite enviar mensajes entre interfaces.
    DefaultTableModel model = new DefaultTableModel();

    public Gestionar_Equipos() {
        initComponents();
        user = Login.user;
        setSize(630, 380);
        setTitle("Capturista - Sesion de " + user);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT id_equipo, tipo_equipo, marca, estatus FROM equipos");
            ResultSet rst = pst.executeQuery();

            tabla_Equipos = new JTable(model);
            ScrollPane_Equipos.setViewportView(tabla_Equipos); //Le indicamos que nuestra tabla está dentro de el Scroll.

            model.addColumn(" "); //ID se pone automático
            model.addColumn("Tipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");

            while (rst.next()) { //Mientras encuentre registros...
                Object[] fila = new Object[4]; //5 posiciones o 5 elementos.
                for (int x = 0; x < 4; x++) {
                    fila[x] = rst.getObject(x + 1); //Se pone x+1 para empezar desde el 1, ya que la X empieza en 0, si empezara en 1, no haría falta poner el x + 1.

                }

                model.addRow(fila); //Agrega los registros que encontro en cada fila

            }

            con.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla " + e);
        }
        
        obtenerDatos_tabla();

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
        ScrollPane_Equipos = new javax.swing.JScrollPane();
        tabla_Equipos = new javax.swing.JTable();
        cmb_Estatus = new javax.swing.JComboBox<>();
        btn_Mostrar = new javax.swing.JButton();
        label_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_EtiquetaGestionarClientes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_EtiquetaGestionarClientes.setForeground(new java.awt.Color(0, 0, 255));
        label_EtiquetaGestionarClientes.setText("Equipos Registrados");
        label_EtiquetaGestionarClientes.setName(""); // NOI18N
        getContentPane().add(label_EtiquetaGestionarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        tabla_Equipos.setModel(new javax.swing.table.DefaultTableModel(
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
        ScrollPane_Equipos.setViewportView(tabla_Equipos);

        getContentPane().add(ScrollPane_Equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        cmb_Estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(cmb_Estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 130, -1));

        btn_Mostrar.setBackground(new java.awt.Color(102, 102, 255));
        btn_Mostrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        btn_Mostrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Mostrar.setText("Mostrar");
        btn_Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 160, -1));
        getContentPane().add(label_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MostrarActionPerformed
         String seleccion = cmb_Estatus.getSelectedItem().toString();
         String query = "";
         
         //Se realiza la limpieza de la tabla, tanto de las filas como de las columnas.
         model.setRowCount(0);
         model.setColumnCount(0);
         
         try{
             
             Connection con = Conexion.conectar();
             
             //Si en la tabla selecciona todos, debe mostrar todos los datos de la tabla, sino, los que salgan en el menú desplegable (seleccion).
             if(seleccion.equals("Todos")){
                 
                 query = "SELECT id_equipo, tipo_equipo, marca, estatus FROM equipos";
                 
             }else{
                 
                 query = "SELECT id_equipo, tipo_equipo, marca, estatus FROM equipos WHERE estatus = '"+seleccion+"'";
                 
             }
             
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rst = pst.executeQuery();
             
             //Se crea la tabla nuevamente
             tabla_Equipos = new JTable(model);
             ScrollPane_Equipos.setViewportView(tabla_Equipos);
             
             model.addColumn(" ");
             model.addColumn("Tipo");
             model.addColumn("Marca");
             model.addColumn("Estatus");
             
             while(rst.next()){
                 Object [] fila = new Object[4];
                 for(int x=0; x<4; x++){
                     
                     fila[x] = rst.getObject(x + 1);
                 }
                 
                 model.addRow(fila);

             }
             
             con.close();
             
         }catch(SQLException e){
             System.err.println("Error al recuperar registros de equipos. "+e);
             
             
         }
         
         //Este método va a estar a la escucha cuando se realice una búsqueda con filtro.
         obtenerDatos_tabla();
    }//GEN-LAST:event_btn_MostrarActionPerformed

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
            java.util.logging.Logger.getLogger(Gestionar_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestionar_Equipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane_Equipos;
    private javax.swing.JButton btn_Mostrar;
    private javax.swing.JComboBox<String> cmb_Estatus;
    private javax.swing.JLabel label_EtiquetaGestionarClientes;
    private javax.swing.JLabel label_Wallpaper;
    private javax.swing.JTable tabla_Equipos;
    // End of variables declaration//GEN-END:variables

    //Se genera aca para cuando se cambie el estado, y se presione en mostrar, para que los datos se actualicen.
    public void obtenerDatos_tabla() {
        tabla_Equipos.addMouseListener(new MouseAdapter() { //Evento para escuchar los clicks al clickear en un cliente.
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla_Equipos.rowAtPoint(e.getPoint()); //Se obtienen las coordenadas de donde estamos haciendo click.
                int columna_point = 0;

                if (fila_point > -1) { //Si el usuario a dado click en un valor que es mayor a -1, se ejecuta el código..
                    ID_equipo_update = (int) model.getValueAt(fila_point, columna_point); //Obtenemos el ID que clickeamos
                    InformacionEquipo_Tecnico informacion_equipo_tecnico = new InformacionEquipo_Tecnico();
                    informacion_equipo_tecnico.setVisible(true);
                    

                }

            }

        });
    }

}
