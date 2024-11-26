
package bd;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Slayer
 */
    public class Conexion {
    
    public Connection obtenerConexion()
    {
        Connection conexion = null;
        //trycatch + tab
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestorsupermercado", "root", "Slayer");
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Fallo conexión con Servidor");
        }
        
        return conexion;
    }
//     public static void main(String[] args) {
//        Conexion con = new Conexion();
//        con.obtenerConexion();
//    }
}

