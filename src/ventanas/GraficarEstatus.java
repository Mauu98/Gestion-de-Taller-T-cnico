
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;


public class GraficarEstatus extends javax.swing.JFrame {
    
    String user = "";
    int nuevo_ingreso, no_reparado, reparado, entregado;
    
    
    //SE VAN A GUARDAR LOS NOMBRES DE LOS ESTATUS CUANDO SE HAGAN LAS CONSULTAS A LA BASE DE DATOS. 
    String [] vector_estatus_nombre = new String[4];
    
    //Número de veces que se ha repetido un estado.
    int [] vector_estatus_cantidad = new int [4];
    


    public GraficarEstatus() {
        initComponents();
        user = Login.user;
        setSize(550,450);
        setTitle("Técnico - Sesión de "+user);
        setLocationRelativeTo(null);
        setResizable(false);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        try{
            
            Connection con = Conexion.conectar();
            //Se realiza la consulta a la base de datos, en la cual se dice que cuente la cantidad de equipos según su estatus.
            PreparedStatement pst = con.prepareStatement("SELECT estatus, count(estatus) AS Cantidad FROM equipos GROUP BY estatus");
            ResultSet rst = pst.executeQuery();
            
            if(rst.next()){
                //Variable que permite recorrer las posiciones de los vectores.
                int posicion = 0;
                
                do{
                    
                    vector_estatus_nombre[posicion] = rst.getString(1);
                    vector_estatus_cantidad[posicion] = rst.getInt(2);
                    
                    if(vector_estatus_nombre[posicion].equalsIgnoreCase("Nuevo ingreso")){
                        nuevo_ingreso = vector_estatus_cantidad[posicion];
                        
                    } else if (vector_estatus_nombre[posicion].equalsIgnoreCase("No reparado")){
                        no_reparado = vector_estatus_cantidad[posicion];
                    } else if(vector_estatus_nombre[posicion].equalsIgnoreCase("Reparado")){
                        reparado = vector_estatus_cantidad[posicion];
                    } else if(vector_estatus_nombre[posicion].equalsIgnoreCase("Entregado")){
                        entregado = vector_estatus_cantidad[posicion];
                    }
                    
                        
                    posicion++;
                    
                    
                }while(rst.next());
                
                
            }
            
        }catch(SQLException e){
            System.err.println("Error en conectar con la base de datos"+e);
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos. Contacte al Desarrollador.");
        }
        
        repaint();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png")); //No hace falta especificar el "src".
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_GraficaEstatus = new javax.swing.JLabel();
        label_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_GraficaEstatus.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_GraficaEstatus.setForeground(new java.awt.Color(0, 0, 255));
        label_GraficaEstatus.setText("Gráfica de Estatus");
        label_GraficaEstatus.setName(""); // NOI18N
        getContentPane().add(label_GraficaEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        getContentPane().add(label_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 450));

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
            java.util.logging.Logger.getLogger(GraficarEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficarEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficarEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficarEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficarEstatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label_GraficaEstatus;
    private javax.swing.JLabel label_Wallpaper;
    // End of variables declaration//GEN-END:variables

    public int Estatus_Mas_Repetido(int Nuevo_Ingreso, int Reparado, int No_Reparado, int Entregado){
        if(Nuevo_Ingreso > Reparado && Nuevo_Ingreso > No_Reparado && Nuevo_Ingreso > Entregado){
            return Nuevo_Ingreso;
        } else if(Reparado > No_Reparado && Reparado > Entregado){
            return Reparado;
        } else if(No_Reparado > Entregado){
            return No_Reparado;
        } else {
            return Entregado;
        }
        
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        int Estatus_Mas_Repetido = Estatus_Mas_Repetido(nuevo_ingreso, reparado, no_reparado, entregado);
        
        //Se multiplican por 400 ya que es el largo de la ventana y se divide por el estatus más repetido.
        int largo_nuevoingreso = nuevo_ingreso * 400 / Estatus_Mas_Repetido;
        int largo_reparado = reparado * 400 / Estatus_Mas_Repetido;
        int largo_noreparado = no_reparado * 400 / Estatus_Mas_Repetido;
        int largo_entregado = entregado * 400 / Estatus_Mas_Repetido;
        
        //Se asigna a cada barra un color. (Nuevo Ingreso)
        g.setColor(new Color(240,248,0)); //Amarillo
        g.fillRect(100, 100, largo_nuevoingreso, 40);
        g.drawString("Nuevo Ingreso", 10, 118);
        g.drawString("Cantidad: "+nuevo_ingreso, 10, 133);
        
        g.setColor(new Color(255,0,0)); //Rojo
        g.fillRect(100, 150, largo_noreparado, 40);
        g.drawString("No reparado", 10, 168);
        g.drawString("Cantidad: "+no_reparado, 10, 183);
        
        g.setColor(new Color(0,0,0)); //Negro
        g.fillRect(100, 200, largo_reparado, 40);
        g.drawString("En revision", 10, 218);
        g.drawString("Cantidad: "+reparado, 10, 233);
        
        g.setColor(new Color(0,85,0)); //Verde
        g.fillRect(100, 250, largo_entregado, 40);
        g.drawString("Entregado", 10, 258);
        g.drawString("Cantidad: "+entregado, 10, 283);
                
    }

}
