
package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteSocket {
    public static void main(String[] args) {

        //Host del servidor
        final String HOST = "127.0.0.1";
        //Puerto del servidor
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            //Envio un mensaje al cliente
            out.writeUTF("99424");

            //Recibo el mensaje del servidor
            String mensaje = in.readUTF();

            System.out.println(mensaje);

            sc.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
}
