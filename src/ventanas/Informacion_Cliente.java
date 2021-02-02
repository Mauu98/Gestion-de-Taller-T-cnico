package ventanas;

import java.sql.*;
import clases.Conexion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import static ventanas.GestionarClientes.ID_cliente_update;

public class Informacion_Cliente extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();

    int IDcliente_update = 0; //Se recupera el click.

    public static int id_equipo = 0;
    String user = "";

    public Informacion_Cliente() {
        initComponents();
        user = Login.user;
        IDcliente_update = GestionarClientes.ID_cliente_update; //Se recupera el valor de la interfaz de gestionar.
        setSize(630, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM clientes WHERE id_cliente = '" + IDcliente_update + "'");
            ResultSet rst = pst.executeQuery();

            if (rst.next()) {
                setTitle("Información del cliente " + rst.getString("nombre_cliente") + " - Sesion de " + user);
                label_EtiquetaInfoCliente.setText("Información del cliente " + rst.getString("nombre_cliente"));
                txt_nombre.setText(rst.getString("nombre_cliente"));
                txt_mail.setText(rst.getString("mail_cliente"));
                txt_celular.setText(rst.getString("tel_cliente"));
                txt_direccion.setText(rst.getString("dir_cliente"));
                txt_UltimaModificacionPor.setText(rst.getString("ultima_modificacion"));

            }

            con.close();

        } catch (SQLException e) {
            System.err.println("Error al buscar la Información del Cliente. Contacte al administrador. " + e);
            JOptionPane.showMessageDialog(null, "Error al buscar información de cliente - SQL Error. Contacte al Ingeniero.", "Error SQL - Información de cliente", JOptionPane.ERROR_MESSAGE);
        }

        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT id_equipo, tipo_equipo, marca, estatus FROM equipos WHERE id_cliente = '" + IDcliente_update + "'");
            ResultSet rst = pst.executeQuery();

            tabla_Equipos = new JTable(model);
            jScrollPane1.setViewportView(tabla_Equipos);

            //Columnas de la tabla
            model.addColumn("ID_Equipo");
            model.addColumn("Tipo de equipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");

            while (rst.next()) {
                Object[] fila = new Object[4];
                for (int x = 0; x < 4; x++) {
                    fila[x] = rst.getObject(x + 1); //Se encarga de llenar toda la fila.
                }

                model.addRow(fila); //Contiene la info y la pasa a la fila.
            }

            con.close();

        } catch (SQLException e) {
            System.err.println("Error en el llenado de la tabla equipos " + e);
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de equipos", "Error SQL - Tabla de Equipos", JOptionPane.ERROR_MESSAGE);
        }

        tabla_Equipos.addMouseListener(new MouseAdapter() { //Evento para escuchar los clicks al clickear en un cliente.
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla_Equipos.rowAtPoint(e.getPoint()); //Se obtienen las coordenadas de donde estamos haciendo click.
                int columna_point = 0;

                if (fila_point > -1) { //Si el usuario a dado click en un valor que es mayor a -1, se ejecuta el código..
                    id_equipo = (int) model.getValueAt(fila_point, columna_point); //Obtenemos el ID que clickeamos
                    InformacionEquipo informacion_equipo = new InformacionEquipo();
                    informacion_equipo.setVisible(true);
                    

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Equipos = new javax.swing.JTable();
        label_Nombre = new javax.swing.JLabel();
        label_mail = new javax.swing.JLabel();
        label_Celular = new javax.swing.JLabel();
        label_Direccion = new javax.swing.JLabel();
        label_ultimamodificación = new javax.swing.JLabel();
        label_EtiquetaInfoCliente = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_celular = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_UltimaModificacionPor = new javax.swing.JTextField();
        btn_Actualizar = new javax.swing.JButton();
        btn_ImprimirReporte = new javax.swing.JButton();
        btn_Registrar = new javax.swing.JButton();
        label_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane1.setViewportView(tabla_Equipos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 380, 180));

        label_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Nombre.setForeground(new java.awt.Color(0, 0, 0));
        label_Nombre.setText("Nombre:");
        getContentPane().add(label_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        label_mail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_mail.setForeground(new java.awt.Color(0, 0, 0));
        label_mail.setText("Email:");
        getContentPane().add(label_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        label_Celular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Celular.setForeground(new java.awt.Color(0, 0, 0));
        label_Celular.setText("Celular:");
        getContentPane().add(label_Celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        label_Direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Direccion.setForeground(new java.awt.Color(0, 0, 0));
        label_Direccion.setText("Dirección:");
        getContentPane().add(label_Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        label_ultimamodificación.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_ultimamodificación.setForeground(new java.awt.Color(0, 0, 0));
        label_ultimamodificación.setText("Última modificación por:");
        getContentPane().add(label_ultimamodificación, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        label_EtiquetaInfoCliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_EtiquetaInfoCliente.setForeground(new java.awt.Color(0, 0, 255));
        label_EtiquetaInfoCliente.setText("Información del Cliente");
        label_EtiquetaInfoCliente.setName(""); // NOI18N
        getContentPane().add(label_EtiquetaInfoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(102, 102, 255));
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));

        txt_mail.setBackground(new java.awt.Color(102, 102, 255));
        txt_mail.setForeground(new java.awt.Color(255, 255, 255));
        txt_mail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 180, -1));

        txt_celular.setBackground(new java.awt.Color(102, 102, 255));
        txt_celular.setForeground(new java.awt.Color(255, 255, 255));
        txt_celular.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 180, -1));

        txt_direccion.setBackground(new java.awt.Color(102, 102, 255));
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 180, -1));

        txt_UltimaModificacionPor.setBackground(new java.awt.Color(102, 102, 255));
        txt_UltimaModificacionPor.setForeground(new java.awt.Color(255, 255, 255));
        txt_UltimaModificacionPor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_UltimaModificacionPor.setEnabled(false);
        getContentPane().add(txt_UltimaModificacionPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 180, -1));

        btn_Actualizar.setBackground(new java.awt.Color(102, 102, 255));
        btn_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        btn_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Actualizar.setText("Actualizar Cliente");
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 160, -1));

        btn_ImprimirReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        btn_ImprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ImprimirReporteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ImprimirReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 120, 100));

        btn_Registrar.setBackground(new java.awt.Color(102, 102, 255));
        btn_Registrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        btn_Registrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Registrar.setText("Registrar equipo");
        btn_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 160, -1));
        getContentPane().add(label_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
        int validacion = 0;
        String nombre, mail, telefono, direccion;

        nombre = txt_nombre.getText().trim();
        mail = txt_mail.getText().trim();
        telefono = txt_celular.getText().trim();
        direccion = txt_direccion.getText().trim();

        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        }

        if (mail.equals("")) {
            txt_mail.setBackground(Color.red);
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
                PreparedStatement pst = con.prepareStatement("UPDATE clientes SET nombre_cliente = ?, mail_cliente = ?, tel_cliente = ?, dir_cliente = ?, "
                        + "ultima_modificacion = ? WHERE id_cliente = '" + ID_cliente_update + "'"); //No se conoce el valor que se pasa desde la interfaz por eso el "?".

                pst.setString(1, nombre);
                pst.setString(2, mail);
                pst.setString(3, telefono);
                pst.setString(4, direccion);
                pst.setString(5, user);

                pst.executeUpdate();
                con.close();

                Limpiar();

                txt_nombre.setBackground(Color.green);
                txt_mail.setBackground(Color.GREEN);
                txt_celular.setBackground(Color.green);
                txt_direccion.setBackground(Color.green);
                txt_UltimaModificacionPor.setText(user);

                JOptionPane.showMessageDialog(null, "Información de Cliente actualizada con éxito");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("Error al conectar con base de datos - Actualizar Cliente");
                JOptionPane.showMessageDialog(null, "Error al actualizar el cliente. Contacte con el Desarrollador.");

            }

        } else {

            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btn_ActualizarActionPerformed

    private void btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarActionPerformed
        RegistrarEquipo registrar_equipo = new RegistrarEquipo();
        registrar_equipo.setVisible(true);
    }//GEN-LAST:event_btn_RegistrarActionPerformed

    private void btn_ImprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ImprimirReporteActionPerformed
        Document documento = new Document();

        try {

            String ruta = System.getProperty("user.home"); //Se ubica dentro de la computadora en la que se esté ejecutando.

            //Se escribe sobre el PDF, el documento, se establece que la ruta será el escritorio, y tendrá el nombre del Cliente (txt_nombre), y será en formato PDF (".pdf")
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + txt_nombre.getText().trim() + ".pdf"));

            //Se establece la imágen que tendrá el documento.
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");

            header.scaleToFit(650, 1000); //Se establecen las medidas.
            header.setAlignment(Chunk.ALIGN_CENTER); //Se alinea al centro.

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Información del cliente. \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(header); //Se le agrega la imágen.
            documento.add(parrafo); //Se le agrega el párrafo.

            PdfPTable tabla_clientes = new PdfPTable(5); //Se indican la cantidad de columnas en el paréntesis
            tabla_clientes.addCell("ID");
            tabla_clientes.addCell("Nombre");
            tabla_clientes.addCell("e-Mail");
            tabla_clientes.addCell("Teléfono");
            tabla_clientes.addCell("Dirección");

            try {
                Connection con = Conexion.conectar();
                PreparedStatement pst = con.prepareStatement("SELECT * FROM clientes WHERE id_cliente = '" + ID_cliente_update + "'");
                ResultSet rst = pst.executeQuery();

                if (rst.next()) {
                    do {
                        //hacen referencia a los datos que estamos recuperando arriba.
                        tabla_clientes.addCell(rst.getString(1));
                        tabla_clientes.addCell(rst.getString(2));
                        tabla_clientes.addCell(rst.getString(3));
                        tabla_clientes.addCell(rst.getString(4));
                        tabla_clientes.addCell(rst.getString(5));

                    } while (rst.next());

                    documento.add(tabla_clientes);

                }
                
                Paragraph parrafo_2 = new Paragraph();
                parrafo_2.setAlignment(Chunk.ALIGN_CENTER);
                parrafo_2.add("\n \n Equipos Registrados. \n \n");
                parrafo_2.setFont(FontFactory.getFont("Tahoma",14,Font.BOLD,BaseColor.DARK_GRAY));
                
                documento.add(parrafo_2);
                
                PdfPTable tabla_equipos = new PdfPTable(4);
                tabla_equipos.addCell("ID");
                tabla_equipos.addCell("Tipo");
                tabla_equipos.addCell("Marca");
                tabla_equipos.addCell("Estatus");
                
                try{
                    Connection con2 = Conexion.conectar();
                    PreparedStatement pst2 = con2.prepareStatement("SELECT id_equipo, tipo_equipo, marca, estatus FROM equipos WHERE id_cliente = '"+ID_cliente_update+"'");
                    ResultSet rst2 = pst2.executeQuery();
                    
                    if(rst2.next()){
                        
                        do{
                            
                            tabla_equipos.addCell(rst2.getString(1));
                            tabla_equipos.addCell(rst2.getString(2));
                            tabla_equipos.addCell(rst2.getString(3));
                            tabla_equipos.addCell(rst2.getString(4));
                            
                        }while(rst2.next());
                        
                        documento.add(tabla_equipos);
                        
                    }
                    
                }catch(SQLException e){
                    System.err.println("Error al consultar tabla de equipos "+e);
                }
                

            } catch (SQLException e) {
                System.err.println("Error al obtener los datos del cliente " + e);
                
            }
            
            documento.close(); //Se cierra el documento.
            JOptionPane.showMessageDialog(null, "Reporte creado con éxito.");

        } catch (DocumentException | IOException e) {
            
            System.err.println("Error en ruta de imágen o PDF. "+e);
            JOptionPane.showMessageDialog(null, "Error al generar el PDF. Contacte al Desarrollador.","Error PDF",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_ImprimirReporteActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JButton btn_ImprimirReporte;
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_Celular;
    private javax.swing.JLabel label_Direccion;
    private javax.swing.JLabel label_EtiquetaInfoCliente;
    private javax.swing.JLabel label_Nombre;
    private javax.swing.JLabel label_Wallpaper;
    private javax.swing.JLabel label_mail;
    private javax.swing.JLabel label_ultimamodificación;
    private javax.swing.JTable tabla_Equipos;
    private javax.swing.JTextField txt_UltimaModificacionPor;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        txt_nombre.setText("");
        txt_mail.setText("");
        txt_celular.setText("");
        txt_direccion.setText("");
    }

}
