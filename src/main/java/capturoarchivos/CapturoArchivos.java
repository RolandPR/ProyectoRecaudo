
package capturoarchivos;

import datos.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.*;

public class CapturoArchivos {
   

       public static void leerArchivo(String nombreArchivo) {
           var archivo = new File(nombreArchivo);
            String linea = "";
            String separador = ",";
            
            Clientes clientes;
            ClientesDAO clientesDao = new ClientesDAO();
            
            //Consulta todos los tipos de documentos
            TiposDocumentosDAO tiposDocumentosDao = new TiposDocumentosDAO();
            var listarTipos = tiposDocumentosDao.seleccionar();
            
            Recaudo recaudo;
            RecaudoDAO recaudoDao = new RecaudoDAO();
            
            int ID = 0;
            SimpleDateFormat formatter  = new SimpleDateFormat ("yyyy-MM-dd");
            
            try {
                
            var entrada = new BufferedReader(new FileReader(archivo));
            
                while ((linea = entrada.readLine()) != null) 
                {
                    String[] cliente = linea.split(separador);
                    
                    String nombre = cliente[0];
                    String tipoDocumento = cliente[1];
                    String numeroDocumento = cliente[2];
                    String numeroReferencia = cliente [3];
                    float valor = Float.parseFloat(cliente [4]);
                    
                    java.util.Date utilDate = formatter.parse(cliente[5]);
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    
                    clientes = new Clientes(nombre, numeroDocumento);
                    
                    //Encuentra el idTiposDocumentos correspondiente
                    for (TiposDocumentos tipoDocumentos: listarTipos){
                        if (tipoDocumentos.getNombre().equals(tipoDocumento)){
                            ID = tipoDocumentos.getIdTiposDocumentos();
                            clientes.setIdTiposDocumentos(ID);
                        }
                    }
//                    
                    ID = clientesDao.insertar(clientes);
                    
                    recaudo = new Recaudo(ID, 1, numeroReferencia, valor, sqlDate);
                    recaudoDao.insertar(recaudo);
                    
//                    
//                    recaudo.setIdClientes(clientes.getIdClientes());
//                    recaudo.setIdProveedores(1);
    
             
                  }
                
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException ex) {
               Logger.getLogger(CapturoArchivos.class.getName()).log(Level.SEVERE, null, ex);
           }
            
        }
    }


