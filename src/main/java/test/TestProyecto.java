package test;

//import static capturoarchivos.CapturoArchivos.leerArchivo;
import static capturoarchivos.CapturoArchivos.obtener;
import capturoarchivos.Persona;
import java.util.ArrayList;

public class TestProyecto {

    public static void main(String[] args) {
        // var nombreArchivo = "C:\\Users\\CAROL VELEZ\\Documents\\prueba\\primero.csv";

//        leerArchivo(nombreArchivo);
        ArrayList<Persona> personas = obtener();
        // Podemos imprimirlas...
        System.out.println(personas);
        // O recorrerlas
        for (int x = 0; x < personas.size(); x++) {
            Persona persona = personas.get(x);
           System.out.println("Tenemos una persona con nombre " + persona.getNombre() + " tipo documento " 
                   + persona.getTipo_documento() + " documento " + persona.getNumero_documento() 
                   + " y referencia de pago " + persona.getReferencia_pago());
        }

    }

}

