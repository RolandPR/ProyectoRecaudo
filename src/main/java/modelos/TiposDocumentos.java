package modelos;

public class TiposDocumentos {

    private int idTiposDocumentos;
    private String nombre;

    public TiposDocumentos(String nombre) {
        this.nombre = nombre;
    }
    
    public int getIdTiposDocumentos() {
        return idTiposDocumentos;
    }

    public void setIdTiposDocumentos(int idTiposDocumentos) {
        this.idTiposDocumentos = idTiposDocumentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
