/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Slayer
 */
public class Empleado {
    
    private int idEmpleado;
    private int rut;
    private String nombreEmpleado,appaterno,apmaterno;
    private int sueldo;


    public Empleado() {
    }

    public Empleado(int idEmpleado, int rut, String nombreEmpleado, String appaterno, String apmaterno, int sueldo) {
        this.idEmpleado = idEmpleado;
        this.rut = rut;
        this.nombreEmpleado = nombreEmpleado;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.sueldo = sueldo;
    }

    

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }


    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }



    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", rut=" + rut + ", nombreEmpleado=" + nombreEmpleado + ", appaterno=" + appaterno + ", apmaterno=" + apmaterno + ", fechanac=" + ", sueldo=" + sueldo + '}';
    }

   
    
}
