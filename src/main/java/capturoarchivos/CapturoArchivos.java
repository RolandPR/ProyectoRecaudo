package capturoarchivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CapturoArchivos {

    public static ArrayList<Persona> obtener() {
        final String archivo = "C:\\Users\\CAROL VELEZ\\Documents\\prueba\\carol1.txt";
        String linea;
        String separador = ",";
        ArrayList<Persona> personas = new ArrayList<>();
        FileReader entrada = null;
        BufferedReader entrada1 = null;

        try {
            entrada = new FileReader(archivo);
            entrada1 = new BufferedReader(entrada);

            while ((linea = entrada1.readLine()) != null) {
                String[] cliente = linea.split(separador);
                personas.add(new Persona(cliente[0], cliente[1], Integer.parseInt(cliente[2]), Integer.parseInt(cliente[3])));
               

            }
        } catch (IOException e) {
            System.out.println("Excepción leyendo archivo: " + e.getMessage());
        } finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
                if (entrada1 != null) {
                    entrada1.close();
                }
            } catch (IOException e) {
                System.out.println("Excepción cerrando: " + e.getMessage());
            }
            return personas;
        }
    }
}
