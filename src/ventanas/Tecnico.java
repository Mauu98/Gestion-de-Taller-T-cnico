
package ventanas;
import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.WindowConstants;


        


public class Tecnico extends javax.swing.JFrame {
    
    String user, nombre_usuario;
    int sesion_usuario;

    public Tecnico() {
        initComponents();
        user = Login.user;
        sesion_usuario = Administrador.sesion_usuario;
        
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(550,330);
        setTitle("Técnico - Sesion de "+user);
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
            System.err.println("Error al cargar Nombre de Técnico de la Base de Datos " +e);
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
        btn_GestionarEquipo = new javax.swing.JButton();
        btn_GraficaEstatus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_NombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        label_NombreUsuario.setForeground(new java.awt.Color(0, 0, 0));
        label_NombreUsuario.setText("jLabel1");
        getContentPane().add(label_NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_GestionarEquipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/apoyo-tecnico.png"))); // NOI18N
        btn_GestionarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GestionarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_GestionarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 100));

        btn_GraficaEstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grafica.png"))); // NOI18N
        btn_GraficaEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GraficaEstatusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_GraficaEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 120, 100));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Gestión de Equipo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Gráfica de Estatus");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));
        getContentPane().add(label_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GestionarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GestionarEquipoActionPerformed
        Gestionar_Equipos gestionar_equipo = new Gestionar_Equipos();
        gestionar_equipo.setVisible(true);
    }//GEN-LAST:event_btn_GestionarEquipoActionPerformed

    private void btn_GraficaEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GraficaEstatusActionPerformed
    GraficarEstatus grafica_Estatus = new GraficarEstatus();
    grafica_Estatus.setVisible(true);
    
        
    }//GEN-LAST:event_btn_GraficaEstatusActionPerformed

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_GestionarEquipo;
    private javax.swing.JButton btn_GraficaEstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_NombreUsuario;
    private javax.swing.JLabel label_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
