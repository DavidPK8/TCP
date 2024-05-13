import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Crear socket
            ServerSocket socketServidor = new ServerSocket(1234);
            System.out.println("Esperando Conexiones...");

            while (true) {
                // Esperar y aceptar conexiones de clientes
                Socket socketCliente = socketServidor.accept();

                // Crear un hilo para cada cliente
                HiloCliente hilo = new HiloCliente(socketCliente);
                hilo.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
