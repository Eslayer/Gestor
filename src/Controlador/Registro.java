
package Controlador;

import Modelo.Departamento;
import Modelo.Empleado;
import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Slayer
 */
public class Registro {

    public boolean agregarEmpleado(Empleado empleado)
    {
        try {

            
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            


            String query = "INSERT INTO empleado(rut,nombreEmpleado,appaterno,apmaterno,sueldo) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            

            stmt.setInt(1, empleado.getRut());
            stmt.setString(2, empleado.getNombreEmpleado());
            stmt.setString(3, empleado.getAppaterno());
            stmt.setString(4, empleado.getApmaterno());
            stmt.setInt(5, empleado.getSueldo());
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al agregar Empleado " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método agregar Empleado " + e.getMessage());
            return false;
        }
    }
     public boolean actualizarEmpleado(Empleado empleado)
    {
        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            

            String query = "UPDATE empleado set nombreEmpleado = ?,rut=?,appaterno=?,apmaterno=?,sueldo=? WHERE idEmpleado=?" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            

            stmt.setString(1, empleado.getNombreEmpleado());
            stmt.setInt(2, empleado.getRut());
            stmt.setString(3, empleado.getAppaterno());
            stmt.setString(4,empleado.getApmaterno());
            stmt.setInt(5, empleado.getSueldo());
            stmt.setInt(6, empleado.getIdEmpleado());
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al actualizar libro " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método actualizar Libro " + e.getMessage());
            return false;
        }
    }
    public Empleado buscarPorId(int idEmpleado)
    {
        Empleado empleado = new Empleado();        
        try {
                   
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            

            String query = "SELECT * FROM empleado WHERE idEmpleado = ?" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idEmpleado);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleado.setAppaterno(rs.getString("appaterno"));
                empleado.setApmaterno(rs.getString("apmaterno"));
                empleado.setRut(rs.getInt("rut"));
                
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error en SQL al listar libros " + e.getMessage());
        }
       return empleado;
    }
    public ArrayList<Empleado> buscarTodos()
    {
        ArrayList<Empleado> lista = new ArrayList<>();
        try {
                   
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            

            String query = "SELECT * FROM empleado ORDER BY nombreEmpleado" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setRut(rs.getInt("rut"));
                empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleado.setAppaterno(rs.getString("appaterno"));
                empleado.setApmaterno(rs.getString("apmaterno"));

                
                lista.add(empleado);
            }

            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error en SQL al listar Empleados " + e.getMessage());
        }
       return lista;
    }
    public boolean eliminar(int idEmpleado)
    {
        try {
            
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            //SQL
            String query = "DELETE FROM empleado WHERE idEmpleado=?" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            //ahora le diremos los ?,?,?,?,?
            stmt.setInt(1, idEmpleado);
            
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al elimina Empleado " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método eliminar Empleado " + e.getMessage());
            return false;
        }
    }  
}
