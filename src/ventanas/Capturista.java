
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
import com.itextpdf.text.pdf.PdfException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;

        


public class Capturista extends javax.swing.JFrame {
    
    String user, nombre_usuario;
    int sesion_usuario;

    public Capturista() {
        initComponents();
        user = Login.user;
        sesion_usuario = Administrador.sesion_usuario;
        
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(550,330);
        setTitle("Capturista - Sesion de "+user);
        setLocationRelativeTo(null);
        
        if(sesion_usuario == 1){ //Si se inicia sesión como Administrador....
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            
        }else{
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        
        try{
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT nombre_usuario FROM usuarios WHERE username = '"+user+"'");
            ResultSet rst = pst.executeQuery();
            
            if(rst.next()){
                nombre_usuario = rst.getString("nombre_usuario");
                label_NombreUsuario.setText("Bienvenido "+nombre_usuario);
            }
            
            
        }catch(SQLException e){
            System.err.println("Error al cargar Nombre de Capturista de la Base de Datos " +e);
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

        label_NombreUsuario = new javax.swing.JLabel();
        btn_RegistrarCliente = new javax.swing.JButton();
        btn_GestionarClientes = new javax.swing.JButton();
        btn_Imprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_NombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        label_NombreUsuario.setForeground(new java.awt.Color(0, 0, 0));
        label_NombreUsuario.setText("jLabel1");
        getContentPane().add(label_NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_RegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cr7.png"))); // NOI18N
        btn_RegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_RegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 100));

        btn_GestionarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationuser.png"))); // NOI18N
        btn_GestionarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GestionarClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_GestionarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 100));

        btn_Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        btn_Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 100));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registrar Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Gestionar Clientes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Imprimir Clientes");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));
        getContentPane().add(label_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarClienteActionPerformed
        RegistrarClientes registrar_clientes = new RegistrarClientes();
        registrar_clientes.setVisible(true);
    }//GEN-LAST:event_btn_RegistrarClienteActionPerformed

    private void btn_GestionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GestionarClientesActionPerformed
        GestionarClientes gestionar_clientes = new GestionarClientes();
        gestionar_clientes.setVisible(true);
        
    }//GEN-LAST:event_btn_GestionarClientesActionPerformed

    private void btn_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ImprimirActionPerformed
        Document documento = new Document();
        
        try{
            
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Lista_Clientes.pdf"));
            
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
            header.scaleToFit(650,1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Lista de Clientes \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma",14,Font.BOLD,BaseColor.DARK_GRAY));
            
            documento.open();
            documento.add(header);
            documento.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(5);
            
            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("Correo electrónico");
            tabla.addCell("Celular");
            tabla.addCell("Dirección");
            
            try{
                
                Connection con = Conexion.conectar();
                PreparedStatement pst = con.prepareStatement("SELECT * FROM clientes");
                ResultSet rst = pst.executeQuery();
                
                if(rst.next()){
                    
                    do{
                        //Se recupera todo lo de la base de datos, de la consulta anterior y se pone en cada columna.
                        tabla.addCell(rst.getString(1));
                        tabla.addCell(rst.getString(2));
                        tabla.addCell(rst.getString(3));
                        tabla.addCell(rst.getString(4));
                        tabla.addCell(rst.getString(5));
                        
                    }while(rst.next());
                    
                    documento.add(tabla);
                }
                
            }catch(SQLException e){
                System.err.println("Error al generar lista de clientes. "+e);
                
            }
            
            documento.close();
            
            
            JOptionPane.showMessageDialog(null, "Documento PDF de clientes generado con éxito");
            
            
            
        }catch(Exception e){
            System.err.println("Error al generar PDF "+e);
        }
    }//GEN-LAST:event_btn_ImprimirActionPerformed

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capturista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_GestionarClientes;
    private javax.swing.JButton btn_Imprimir;
    private javax.swing.JButton btn_RegistrarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel label_NombreUsuario;
    private javax.swing.JLabel label_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
