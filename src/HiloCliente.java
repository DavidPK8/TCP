import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloCliente extends Thread{

    Socket socketCliente;

    public HiloCliente(Socket socketCliente){
        this.socketCliente = socketCliente;
    }

    public void run(){
        try {
            // Crear buffers para recibir y enviar datos al cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);

            // Leer los datos recibidos por el cliente almacenados en entrada
            String datosRecibidos = entrada.readLine();
            System.out.println("El mensaje recibido es: " + datosRecibidos);

            // Escribir los datos a enviar en el buffer de salida
            String mensajeEnviar = "Hola soy el servidor";
            salida.println(mensajeEnviar);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
