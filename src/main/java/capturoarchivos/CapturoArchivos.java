package capturoarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CapturoArchivos {
   

       public static void leerArchivo(String nombreArchivo) {
           var archivo = new File(nombreArchivo);
            String linea = "";
            String separador = ",";
            
            try {
            var entrada = new BufferedReader(new FileReader(archivo));
            
                while ((linea = entrada.readLine()) != null) 
                {
                    String[] cliente = linea.split(separador);
                    String nombre = cliente[0];
                    String apellido = cliente[1];
                    String identificacion = cliente[2];
                    String celular = cliente [3];
                    String referencia = cliente [4];
                    String correo = cliente [5];
                    String valor_pagar = cliente [6];
                    String fecha_venci = cliente [7];
                    
                    
                    System.out.println("nombre = " + nombre);
                    System.out.println("Apellido = " + apellido);
                    System.out.println("Identificación = " + identificacion);
                    System.out.println("N° cedlular = " + celular);
                    System.out.println("N° Referencia = " + referencia);
                    System.out.println("Correo electronico = " + correo);
                    System.out.println("Valor a pagar= " + valor_pagar);
                    System.out.println("Fecha de vencimiento = " + fecha_venci);
                    System.out.println("Cliente -----------------------------");
             
                  }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


