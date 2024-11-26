/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
//    public boolean agregarProducto(Producto producto, Marca marca)
//    {
//        try {
//
//            
//            Conexion con = new Conexion();
//            Connection cnx = con.obtenerConexion();
//            
//
//            //SQL
//            String query = "INSERT INTO producto(nombreProd,precio,cantStock,nombreMarca) VALUES(?,?,?,?)";
//            PreparedStatement stmt = cnx.prepareStatement(query);
//            
//            //ahora le diremos los ?,?,?,?,?
//            stmt.setString(1, producto.getNombreProd());
//            stmt.setInt(2, producto.getPrecio());
//            stmt.setInt(3, producto.getCant_stock());
//            stmt.setString(4, marca.getNombreMarca());
//            stmt.executeUpdate();
//            stmt.close();
//            cnx.close();
//            
//            return true;
//        } catch (SQLException e) {
//            System.out.println("Error en SQL al agregar producto " + e.getMessage());
//            return false;
//        }
//        catch(Exception e){
//            System.out.println("Error en el método agregar producto " + e.getMessage());
//            return false;
//        }
//    }//fin de metodo
    public boolean agregarEmpleado(Empleado empleado)
    {
        try {

            
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            

            //SQL
            String query = "INSERT INTO empleado(rut,nombreEmpleado,appaterno,apmaterno,sueldo) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            //ahora le diremos los ?,?,?,?,?
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
            
            //SQL
            String query = "UPDATE empleado set nombreEmpleado = ?,rut=?,appaterno=?,apmaterno=?,sueldo=? WHERE idEmpleado=?" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            //ahora le diremos los ?,?,?,?,?
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
            
            //SQL
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
            
            //SQL
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
//    public ArrayList<Departamento> buscarTodosDept()
//    {
//        ArrayList<Departamento> lista2 = new ArrayList<>();
//        try {
//                   
//            Conexion con = new Conexion();
//            Connection cnx = con.obtenerConexion();
//            
//            //SQL
//            String query = "SELECT * FROM Departamento ORDER BY nombreDepartamento" ;
//            PreparedStatement stmt = cnx.prepareStatement(query);
//            
//            ResultSet rs = stmt.executeQuery();
//            
//
//            while (rs.next()) {
//                Departamento dept = new Departamento();
//                dept.getNombreDept(rs.getString("paterno"));
//
//                
//                lista2.add(dept);
//            }
//            rs.close();
//            stmt.close();
//            cnx.close();
//            
//        } catch (SQLException e) {
//            System.out.println("Error en SQL al listar Departamento " + e.getMessage());
//        }
//       return lista2;
//    }
//public boolean agregarMarca(Marca marca)
//    {
//        try {
//            
//            Conexion con = new Conexion();
//            Connection cnx = con.obtenerConexion();
//                     //SQL
//            String query = "INSERT INTO producto(nombreMarca) VALUES(?)";
//            PreparedStatement stmt = cnx.prepareStatement(query);
//            
//            //ahora le diremos los ?,?,?,?,?
//            stmt.setString(1, marca.getNombreMarca());
//            
//            stmt.executeUpdate();
//            stmt.close();
//            cnx.close();
//            
//            return true;
//        } catch (SQLException e) {
//            System.out.println("Error en SQL al agregar marca " + e.getMessage());
//            return false;
//        }
//        catch(Exception e){
//            System.out.println("Error en el método agregar marca " + e.getMessage());
//            return false;
//        }
//    }
    
}
