package Controlador;



import Modelo.Marca;
import Modelo.Producto;
import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Slayer
 */

//Aqui debo anadir metodos. Agregar, eliminar, buscar todo, buscar por id, actualizar la info. basicamente los tipicos
// en caso de empleados, necesito, buscar por rut, buscar por dinero ganado, buscar por fecha de contrato, buscar por fecha de nacimiento (para impresionar)
//en caso de productos, necesito, buscar por marca, buscar por id, buscar por fecha (para impresionar)
public class Registro {
    
    public boolean agregarProducto(Producto producto)
    {
        try {

            
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            

            //SQL
            String query = "INSERT INTO producto(nombreProd,precio,cantStock) VALUES(?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            //ahora le diremos los ?,?,?,?,?
            stmt.setString(1, producto.getNombreProd());
            stmt.setInt(2, producto.getPrecio());
            stmt.setInt(3, producto.getCant_stock());
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al agregar producto " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método agregar producto " + e.getMessage());
            return false;
        }
    }
public boolean agregarProducto(Marca marca)
    {
        try {
            
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
                     //SQL
            String query = "INSERT INTO marca(nombreMarca) VALUES(?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            //ahora le diremos los ?,?,?,?,?
            stmt.setString(1, marca.getNombreMarca());
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al agregar marca " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método agregar marca " + e.getMessage());
            return false;
        }
    }
}
       

