
package clases;
import java.sql.*;


public class Conexion {
    //Conexión a Base de Datos Local
    public static Connection conectar(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds","root","");
            return con;
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error en la conexión." +e);
        }
        
        return null;
    }
    
    
}
