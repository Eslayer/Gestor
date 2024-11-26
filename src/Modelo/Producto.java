
package Modelo;

import java.util.Date;

/**
 *
 * @author Slayer
 */
//crear clase producto
public class Producto {
    
    private int idProducto;
    private String nombreProd;
    private int precio;
    private int cant_stock;

    public Producto() {
    }

    public Producto(int idProducto, String nombreProd, int precio, int cant_stock) {
        this.idProducto = idProducto;
        this.nombreProd = nombreProd;
        this.precio = precio;
        this.cant_stock = cant_stock;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCant_stock() {
        return cant_stock;
    }

    public void setCant_stock(int cant_stock) {
        this.cant_stock = cant_stock;
    }

   
}

    


   