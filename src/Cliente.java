import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Cliente conectado");
            while(true){
                Socket socketCliente = new Socket("172.31.115.140", 5000);

                // Crear buffers para recibir y enviar datos al cliente
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);

                // Escribir los datos a enviar en el buffer de salida
                System.out.print("Escriba un mensaje: ");
                String mensajeEnviar = sc.nextLine();
                salida.println(mensajeEnviar);

                // Leer los datos recibidos por el cliente
                String datosRecibidos = entrada.readLine();
                System.out.println("Servidor: " + datosRecibidos);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
