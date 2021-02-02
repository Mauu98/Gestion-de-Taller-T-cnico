package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;

public class InformacionEquipo extends javax.swing.JFrame {
    
    int id_cliente_udpate = 0, id_equipo = 0;
    String user = "", nom_cliente = "";
    
    public InformacionEquipo() {
        initComponents();
        
        user = Login.user;
        id_cliente_udpate = GestionarClientes.ID_cliente_update;
        id_equipo = Informacion_Cliente.id_equipo;
        
        try {
            
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT nombre_cliente FROM clientes WHERE id_cliente = '" + id_cliente_udpate + "'");
            ResultSet rst = pst.executeQuery();
            
            if (rst.next()) {
                
                nom_cliente = rst.getString("nombre_cliente");
            }
            
        } catch (SQLException e) {
            System.err.println("Error al consultar datos de cliente. " + e);
        }
        
        try {
            
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM equipos WHERE id_equipo = '" + id_equipo + "'");
            ResultSet rst = pst.executeQuery();
            
            if (rst.next()) {
                cmb_TipoEquipo.setSelectedItem(rst.getString("tipo_equipo")); //Se le asigna al combobox, lo que se recupera de la base de datos.
                cmb_Marcas.setSelectedItem(rst.getString("marca"));
                cmb_Estatus.setSelectedItem(rst.getString("estatus"));
                
                txt_Modelo.setText(rst.getString("modelo"));
                txt_numSerie.setText(rst.getString("num_serie"));
                txt_ultimaModificacion.setText(rst.getString("ultima_modificacion"));
                
                String dia = "", mes = "", año = "";
                
                dia = rst.getString("dia_ingreso");
                mes = rst.getString("mes_ingreso");
                año = rst.getString("anio_ingreso");
                
                txt_Fecha.setText(dia + "/" + mes + "/" + año);
                
                TextPane_DañoObservaciones.setText(rst.getString("observaciones"));
                TextPane_ComentariosTecnico.setText(rst.getString("comentarios_tecnicos"));
                
                label_RevisionTecnica.setText("Comentarios y actualización del técnico " + rst.getString("revision_tecnica"));
                
            }
            
        } catch (SQLException e) {
            System.err.println("Error al consultar la información del equipo "+e);
        }
        
        setTitle("Equipo del cliente "+nom_cliente);
        setSize(670, 530);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        txt_nombreCliente.setText(nom_cliente);
        
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png")); //No hace falta especificar el "src".
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_Nombre = new javax.swing.JLabel();
        label_Nombre1 = new javax.swing.JLabel();
        label_Nombre2 = new javax.swing.JLabel();
        label_Nombre3 = new javax.swing.JLabel();
        label_Nombre4 = new javax.swing.JLabel();
        label_Nombre5 = new javax.swing.JLabel();
        label_Nombre6 = new javax.swing.JLabel();
        label_Nombre7 = new javax.swing.JLabel();
        label_Nombre8 = new javax.swing.JLabel();
        label_EtiquetaInfoEquipo = new javax.swing.JLabel();
        label_RevisionTecnica = new javax.swing.JLabel();
        txt_nombreCliente = new javax.swing.JTextField();
        txt_Modelo = new javax.swing.JTextField();
        txt_numSerie = new javax.swing.JTextField();
        txt_ultimaModificacion = new javax.swing.JTextField();
        txt_Fecha = new javax.swing.JTextField();
        cmb_TipoEquipo = new javax.swing.JComboBox<>();
        cmb_Marcas = new javax.swing.JComboBox<>();
        cmb_Estatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextPane_DañoObservaciones = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextPane_ComentariosTecnico = new javax.swing.JTextPane();
        btn_Actualizar = new javax.swing.JButton();
        label_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Nombre.setForeground(new java.awt.Color(0, 0, 0));
        label_Nombre.setText("Nombre del Cliente:");
        getContentPane().add(label_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        label_Nombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Nombre1.setForeground(new java.awt.Color(0, 0, 0));
        label_Nombre1.setText("Tipo de equipo:");
        getContentPane().add(label_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        label_Nombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Nombre2.setForeground(new java.awt.Color(0, 0, 0));
        label_Nombre2.setText("Marca:");
        getContentPane().add(label_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        label_Nombre3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Nombre3.setForeground(new java.awt.Color(0, 0, 0));
        label_Nombre3.setText("Modelo:");
        getContentPane().add(label_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        label_Nombre4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Nombre4.setForeground(new java.awt.Color(0, 0, 0));
        label_Nombre4.setText("Número de Serie:");
        getContentPane().add(label_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        label_Nombre5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Nombre5.setForeground(new java.awt.Color(0, 0, 0));
        label_Nombre5.setText("Fecha de Ingreso:");
        getContentPane().add(label_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        label_Nombre6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Nombre6.setForeground(new java.awt.Color(0, 0, 0));
        label_Nombre6.setText("Última modificación por:");
        getContentPane().add(label_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        label_Nombre7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Nombre7.setForeground(new java.awt.Color(0, 0, 0));
        label_Nombre7.setText("Estatus:");
        getContentPane().add(label_Nombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        label_Nombre8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_Nombre8.setForeground(new java.awt.Color(0, 0, 0));
        label_Nombre8.setText("Daño Reportado / Observaciones");
        getContentPane().add(label_Nombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        label_EtiquetaInfoEquipo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_EtiquetaInfoEquipo.setForeground(new java.awt.Color(0, 0, 255));
        label_EtiquetaInfoEquipo.setText("Información del Equipo");
        label_EtiquetaInfoEquipo.setName(""); // NOI18N
        getContentPane().add(label_EtiquetaInfoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        label_RevisionTecnica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_RevisionTecnica.setForeground(new java.awt.Color(0, 0, 0));
        label_RevisionTecnica.setText("Comentarios del Técnico:");
        getContentPane().add(label_RevisionTecnica, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        txt_nombreCliente.setBackground(new java.awt.Color(102, 102, 255));
        txt_nombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombreCliente.setEnabled(false);
        getContentPane().add(txt_nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 180, -1));

        txt_Modelo.setBackground(new java.awt.Color(102, 102, 255));
        txt_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 180, -1));

        txt_numSerie.setBackground(new java.awt.Color(102, 102, 255));
        txt_numSerie.setForeground(new java.awt.Color(255, 255, 255));
        txt_numSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_numSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 180, -1));

        txt_ultimaModificacion.setBackground(new java.awt.Color(102, 102, 255));
        txt_ultimaModificacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_ultimaModificacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ultimaModificacion.setEnabled(false);
        getContentPane().add(txt_ultimaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 180, -1));

        txt_Fecha.setBackground(new java.awt.Color(102, 102, 255));
        txt_Fecha.setForeground(new java.awt.Color(255, 255, 255));
        txt_Fecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Fecha.setEnabled(false);
        getContentPane().add(txt_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 180, -1));

        cmb_TipoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Multifuncional" }));
        getContentPane().add(cmb_TipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cmb_Marcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Alienware", "Apple", "Asus", "Brother", "Dell", "HP", "Lenovo", "Samsung", "Toshiba", "Xerox" }));
        getContentPane().add(cmb_Marcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        cmb_Estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo Ingreso", "No reparado", "Reparado", "Entregado" }));
        getContentPane().add(cmb_Estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jScrollPane1.setViewportView(TextPane_DañoObservaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 330, 120));

        TextPane_ComentariosTecnico.setEditable(false);
        jScrollPane2.setViewportView(TextPane_ComentariosTecnico);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 330, 120));

        btn_Actualizar.setBackground(new java.awt.Color(102, 102, 255));
        btn_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        btn_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Actualizar.setText("Actualizar Equipo");
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 160, -1));
        getContentPane().add(label_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
        int validacion = 0;
        String tipo_equipo, marca, modelo, num_serie, estatus, observaciones;
        
        tipo_equipo = cmb_TipoEquipo.getSelectedItem().toString();
        marca = cmb_Marcas.getSelectedItem().toString();
        estatus = cmb_Estatus.getSelectedItem().toString();
        
        num_serie = txt_numSerie.getText().trim();
        modelo = txt_Modelo.getText().trim();
        observaciones = TextPane_DañoObservaciones.getText();
        
        if(modelo.equals("")){
            validacion++;
            txt_Modelo.setBackground(Color.red);
        }
        
        if(num_serie.equals("")){
            validacion++;
            txt_numSerie.setBackground(Color.red);
        }
        
        if(observaciones.equals("")){
            validacion++;
            TextPane_DañoObservaciones.setText("Sin observaciones.");
        }
        
        if(validacion == 0){
            
            try{
                
                Connection con = Conexion.conectar();
                PreparedStatement pst = con.prepareStatement("UPDATE equipos SET tipo_equipo = ?, marca = ?, modelo = ?, num_serie = ?, observaciones = ?,"
                        + "estatus = ?, ultima_modificacion = ? WHERE id_equipo = '"+id_equipo+"'");
                
                pst.setString(1, tipo_equipo);
                pst.setString(2, marca);
                pst.setString(3, modelo);
                pst.setString(4, num_serie);
                pst.setString(5, observaciones);
                pst.setString(6, estatus);
                pst.setString(7, user);
                
                pst.executeUpdate();
                con.close();
                
                Limpiar();
                
                txt_nombreCliente.setBackground(Color.GREEN);
                txt_Fecha.setBackground(Color.GREEN);
                txt_Modelo.setBackground(Color.GREEN);
                txt_numSerie.setBackground(Color.GREEN);
                txt_ultimaModificacion.setText(user);
                
                JOptionPane.showMessageDialog(null, "Actualización de equipo exitosa");
                this.dispose();
                
            }catch(SQLException e){
                System.err.println("Error al actualizar equipo. "+e);
                JOptionPane.showMessageDialog(null, "Error al consultar informacion de equipo. Contacte al Desarrollador.","Error de Conexion - Equipo",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        }
    }//GEN-LAST:event_btn_ActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane TextPane_ComentariosTecnico;
    private javax.swing.JTextPane TextPane_DañoObservaciones;
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JComboBox<String> cmb_Estatus;
    private javax.swing.JComboBox<String> cmb_Marcas;
    private javax.swing.JComboBox<String> cmb_TipoEquipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_EtiquetaInfoEquipo;
    private javax.swing.JLabel label_Nombre;
    private javax.swing.JLabel label_Nombre1;
    private javax.swing.JLabel label_Nombre2;
    private javax.swing.JLabel label_Nombre3;
    private javax.swing.JLabel label_Nombre4;
    private javax.swing.JLabel label_Nombre5;
    private javax.swing.JLabel label_Nombre6;
    private javax.swing.JLabel label_Nombre7;
    private javax.swing.JLabel label_Nombre8;
    private javax.swing.JLabel label_RevisionTecnica;
    private javax.swing.JLabel label_Wallpaper;
    private javax.swing.JTextField txt_Fecha;
    private javax.swing.JTextField txt_Modelo;
    private javax.swing.JTextField txt_nombreCliente;
    private javax.swing.JTextField txt_numSerie;
    private javax.swing.JTextField txt_ultimaModificacion;
    // End of variables declaration//GEN-END:variables

    public void Limpiar(){
        txt_nombreCliente.setText("");
        txt_Modelo.setText("");
        txt_Fecha.setText("");
        txt_numSerie.setText("");
        TextPane_DañoObservaciones.setText("");
    }


}
