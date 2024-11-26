/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Departamento;
import bd.Conexion;
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
            stmt.setString(1, departamento.getNombreDept(query));
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
            String query = "SELECT * FROM Departamento ORDER BY nombreDepartamento" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            

            while (rs.next()) {
                Departamento dept = new Departamento();
                dept.getNombreDept(rs.getString("nombreDept"));

                
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
        public boolean eliminar(int idDept)
    {
        try {
            
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            //sentencia del sql
            String query = "DELETE FROM departamento WHERE idDept=?" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            //poner valor a el prepared statement es decir al stmt
            stmt.setInt(1, idDept);
            
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al elimina Departamento " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método eliminar Depto " + e.getMessage());
            return false;
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
            stmt.setString(1, departamento.getNombreDept(query));
            stmt.setInt(2, departamento.getIdDept());
            
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
