/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Departamento;
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
public class RegistroDepto {
    
        public boolean agregarDepto(Departamento departamento)
    {
        try {

            
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            

            //SQL
            String query = "INSERT INTO departamento(nombreDept) VALUES(?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            //ahora le diremos los ?,?,?,?,?
            stmt.setString(1, departamento.getNombreDept());
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al agregar Departamento " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método agregar Departamento " + e.getMessage());
            return false;
        }
        
    }//fin de metodo
        
        public Departamento buscarPorId(int idDept)
    {
        Departamento dept = new Departamento();        
        try {
                   
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            //SQL
            String query = "SELECT * FROM departamento WHERE idDept = ?" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idDept);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                dept.setIdDept(rs.getInt("idDept"));
                dept.setNombreDept(rs.getString("nombreDept"));

                
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error en SQL al listar Departamentos " + e.getMessage());
        }
       return dept;
    }
           
        public ArrayList<Departamento> buscarTodosDept()
    {
        ArrayList<Departamento> lista2 = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            //SQL
            String query = "SELECT * FROM departamento ORDER BY nombreDept" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            

            while (rs.next()) {
                Departamento dept = new Departamento();
                dept.setIdDept(rs.getInt("idDept"));
                dept.setNombreDept(rs.getString("nombreDept"));

                
                lista2.add(dept);
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error en SQL al listar Departamento " + e.getMessage());
        }
       return lista2;
    }
        public boolean eliminar(String nombreDept)
    {
        try {
        // Establecer conexión con la base de datos
        Conexion con = new Conexion();
        Connection cnx = con.obtenerConexion();
        
        // Sentencia SQL para eliminar empleados cuyo departamento coincida con el nombreDept ingresado
        String query = "DELETE FROM empleado WHERE nombreDept LIKE ?" ;
        PreparedStatement stmt = cnx.prepareStatement(query);
        
        // Asignar el valor al PreparedStatement
        // El '%' se usa como comodín para que coincida con cualquier nombre que contenga 'nombreDept'
        stmt.setString(1, "%" + nombreDept + "%");  // Buscará cualquier departamento que contenga el nombreDept

        // Ejecutar la eliminación
        int filaseliminadas = stmt.executeUpdate();
        

        if (filaseliminadas > 0) {
            System.out.println("Se eliminaron " + filaseliminadas + " empleados del departamento " + nombreDept);
        } else {
            System.out.println("No se encontraron empleados en el departamento " + nombreDept);
        }
        
        // Cerrar recursos
        stmt.close();
        cnx.close();
        
        return true;  // Indicamos que la operación fue exitosa
    } catch (SQLException e) {
        // Capturar errores relacionados con SQL
        System.out.println("Error en SQL al eliminar empleados: " + e.getMessage());
        return false;  // Retornar falso si hay un error SQL
    } catch (Exception e) {
        // Capturar cualquier otro tipo de error
        System.out.println("Error en el método eliminar empleados: " + e.getMessage());
        return false;  // Retornar falso si hay un error general
    }
    }
         public boolean actualizar(Departamento departamento)
    {
        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            //SQL
            String query = "UPDATE Departamento set nombreDept = ? WHERE idDept=?" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            //ahora le diremos los ?,?,?,?,?
            stmt.setInt(1, departamento.getIdDept());
            stmt.setString(1, departamento.getNombreDept());
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al actualizar Departamento " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método actualizar Departamento" + e.getMessage());
            return false;
        }
    }
}
