package modelos;

public class Proveedores {

    private int idProveedores;
    private String nombre;

    public Proveedores(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(int idProveedores) {
        this.idProveedores = idProveedores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
