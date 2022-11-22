package modelos;

public class Clientes {

    private int idClientes;
    private int idTiposDocumentos;
    private String nombre;
    private int noDocumento;

    public Clientes(int idTiposDocumentos, String nombre, int noDocumento) {
        this.idTiposDocumentos = idTiposDocumentos;
        this.nombre = nombre;
        this.noDocumento = noDocumento;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
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

    public int getNoDocumento() {
        return noDocumento;
    }

    public void setNoDocumento(int noDocumento) {
        this.noDocumento = noDocumento;
    }

}
