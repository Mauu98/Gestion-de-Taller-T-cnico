
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import clases.Conexion;
import java.awt.Color;
import java.sql.*;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;


public class RegistrarEquipo extends javax.swing.JFrame {
    
    int IDcliente_udpate = 0;
    String user = "", nom_cliente = "";
    

    
    public RegistrarEquipo() {
        initComponents();
        user = Login.user;
        IDcliente_udpate = GestionarClientes.ID_cliente_update;
        setTitle("Registrar nuevo equipo para "+nom_cliente);
        setSize(630,445);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        try{
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT nombre_cliente FROM clientes WHERE id_cliente ='"+IDcliente_udpate+"'");
            ResultSet rst = pst.executeQuery();
            
            if(rst.next()){
                nom_cliente = rst.getString("nombre_cliente"); //Se recupera lo que viene de la base de datos de nombre_cliente
                
            }
            
            con.close();
            
            
        }catch(SQLException e){
            System.err.println("Error al consultar nombre de cliente. - Registrar Equipo -");
        }
        
        
        
        txt_NombreCliente.setText(nom_cliente);
    }
    
      @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png")); //No hace falta especificar el "src".
        return retValue;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_NombreCliente = new javax.swing.JLabel();
        label_TipoEquipo = new javax.swing.JLabel();
        label_Marca = new javax.swing.JLabel();
        label_Modelo = new javax.swing.JLabel();
        label_NumSerie = new javax.swing.JLabel();
        label_dañoObservaciones = new javax.swing.JLabel();
        label_EtiquetaInfoCliente = new javax.swing.JLabel();
        txt_NombreCliente = new javax.swing.JTextField();
        txt_Modelo = new javax.swing.JTextField();
        txt_numSerie = new javax.swing.JTextField();
        cmb_tipoequipo = new javax.swing.JComboBox<>();
        cmb_marcas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextPane_Observaciones = new javax.swing.JTextPane();
        btn_RegistrarEquipo = new javax.swing.JButton();
        label_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_NombreCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_NombreCliente.setForeground(new java.awt.Color(0, 0, 0));
        label_NombreCliente.setText("Nombre del Cliente:");
        getContentPane().add(label_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        label_TipoEquipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_TipoEquipo.setForeground(new java.awt.Color(0, 0, 0));
        label_TipoEquipo.setText("Tipo de Equipo:");
        getContentPane().add(label_TipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        label_Marca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Marca.setForeground(new java.awt.Color(0, 0, 0));
        label_Marca.setText("Marca:");
        getContentPane().add(label_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        label_Modelo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Modelo.setForeground(new java.awt.Color(0, 0, 0));
        label_Modelo.setText("Modelo:");
        getContentPane().add(label_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        label_NumSerie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_NumSerie.setForeground(new java.awt.Color(0, 0, 0));
        label_NumSerie.setText("Número de Serie:");
        getContentPane().add(label_NumSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        label_dañoObservaciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_dañoObservaciones.setForeground(new java.awt.Color(0, 0, 0));
        label_dañoObservaciones.setText("Daño Reportado - Observaciones");
        getContentPane().add(label_dañoObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        label_EtiquetaInfoCliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_EtiquetaInfoCliente.setForeground(new java.awt.Color(0, 0, 255));
        label_EtiquetaInfoCliente.setText("Registro de Equipo");
        label_EtiquetaInfoCliente.setName(""); // NOI18N
        getContentPane().add(label_EtiquetaInfoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        txt_NombreCliente.setBackground(new java.awt.Color(102, 102, 255));
        txt_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_NombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 180, -1));

        txt_Modelo.setBackground(new java.awt.Color(102, 102, 255));
        txt_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 180, -1));

        txt_numSerie.setBackground(new java.awt.Color(102, 102, 255));
        txt_numSerie.setForeground(new java.awt.Color(255, 255, 255));
        txt_numSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_numSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 180, -1));

        cmb_tipoequipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Multifuncional" }));
        cmb_tipoequipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipoequipoActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_tipoequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cmb_marcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Alienware", "Apple", "Asus", "Brother", "Dell", "HP", "Lenovo", "Samsung", "Toshiba", "Xerox" }));
        getContentPane().add(cmb_marcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jScrollPane1.setViewportView(TextPane_Observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 330, 230));

        btn_RegistrarEquipo.setBackground(new java.awt.Color(102, 102, 255));
        btn_RegistrarEquipo.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        btn_RegistrarEquipo.setForeground(new java.awt.Color(255, 255, 255));
        btn_RegistrarEquipo.setText("Registrar equipo");
        btn_RegistrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_RegistrarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 160, -1));
        getContentPane().add(label_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 445));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarEquipoActionPerformed
        int validacion = 0;
        String tipo_equipo, marca, modelo, num_serie, dia_ingreso, mes_ingreso, anio_ingreso, estatus, observaciones;
        
        tipo_equipo = cmb_tipoequipo.getSelectedItem().toString(); //Se convierte a cadena de carácteres.
        marca = cmb_marcas.getSelectedItem().toString(); // ""
        modelo = txt_Modelo.getText().trim();
        num_serie = txt_numSerie.getText().trim();
        observaciones = TextPane_Observaciones.getText();
        estatus = "Nuevo ingreso";
        
        //Se crea un objeto de tipo Calendario
        Calendar calendar = Calendar.getInstance();
        
        dia_ingreso = Integer.toString(calendar.get(Calendar.DATE));
        mes_ingreso = Integer.toString(calendar.get(Calendar.MONTH));
        anio_ingreso = Integer.toString(calendar.get(Calendar.YEAR));
        
        if(modelo.equals("")){
            txt_Modelo.setBackground(Color.red);
            validacion++;
        }
        
        if(num_serie.equals("")){
            txt_numSerie.setBackground(Color.red);
            validacion++;
        }
        
        if(observaciones.equals("")){
            TextPane_Observaciones.setText("Sin observaciones.");
        }
        
        if(validacion == 0){
            
            try{
                
                Connection con = Conexion.conectar();
                PreparedStatement pst = con.prepareStatement("INSERT INTO equipos VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
                pst.setInt(1, 0); //Se envía el ID a la Base de Datos.
                pst.setInt(2, IDcliente_udpate);
                pst.setString(3, tipo_equipo);
                pst.setString(4, marca);
                pst.setString(5, modelo);
                pst.setString(6, num_serie);
                pst.setString(7, dia_ingreso);
                pst.setString(8, mes_ingreso);
                pst.setString(9, anio_ingreso);
                pst.setString(10, observaciones);
                pst.setString(11, estatus);
                pst.setString(12, user);
                pst.setString(13, "");
                pst.setString(14, "");
                
                pst.executeUpdate();
                con.close();
                
                txt_NombreCliente.setBackground(Color.green);
                txt_Modelo.setBackground(Color.green);
                txt_numSerie.setBackground(Color.green);
                
                JOptionPane.showMessageDialog(null, "Registro de equipo realizado exitósamente");
                this.dispose();
                
            }catch(SQLException e){
                System.err.println("Error en registrar equipo - Registro de Equipo - Ingeniería");
                JOptionPane.showMessageDialog(null, "Error al registrar equipo. Contacte al Ingeniero.");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.","Campos Incompletos",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_RegistrarEquipoActionPerformed

    private void cmb_tipoequipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipoequipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_tipoequipoActionPerformed

 
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane TextPane_Observaciones;
    private javax.swing.JButton btn_RegistrarEquipo;
    private javax.swing.JComboBox<String> cmb_marcas;
    private javax.swing.JComboBox<String> cmb_tipoequipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_EtiquetaInfoCliente;
    private javax.swing.JLabel label_Marca;
    private javax.swing.JLabel label_Modelo;
    private javax.swing.JLabel label_NombreCliente;
    private javax.swing.JLabel label_NumSerie;
    private javax.swing.JLabel label_TipoEquipo;
    private javax.swing.JLabel label_Wallpaper;
    private javax.swing.JLabel label_dañoObservaciones;
    private javax.swing.JTextField txt_Modelo;
    private javax.swing.JTextField txt_NombreCliente;
    private javax.swing.JTextField txt_numSerie;
    // End of variables declaration//GEN-END:variables
}
