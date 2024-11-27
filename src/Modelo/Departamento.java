
package Modelo;

/**
 *
 * @author Slayer
 */
public class Departamento {
    
    private int idDept;
    private String nombreDept;

    public Departamento() {
    }

    public Departamento(int idDept, String nombreDept) {
        this.idDept = idDept;
        this.nombreDept = nombreDept;
    }

    public int getIdDept() {
        return idDept;
    }

    public void setIdDept(int idDept) {
        this.idDept = idDept;
    }

    public String getNombreDept() {
        return nombreDept;
    }

    public void setNombreDept(String nombreDept) {
        this.nombreDept = nombreDept;
    }

 

    @Override
    public String toString() {
        return "Departamento{" + "idDept=" + idDept + ", nombreDept=" + nombreDept + '}';
    }

    
    
    
}
