/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiHoloShockes;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCPClient {

    private String serverlP;
    private int serverPort;
    private Socket socket;
    private InputStream is;

    public SocketTCPClient(String serverlP, int serverPort) {
        this.serverlP = serverlP;
        this.serverPort = serverPort;
    }

    public void start() throws UnknownHostException, IOException {
        System.out.println("(Cliente) Estableciendo conexión...");
        socket = new Socket(serverlP, serverPort); // (Cliente) Establece la conexión con el servidor
        is = socket.getInputStream(); // (Cliente) Obtiene el InputStream del socket
        System.out.println("(Cliente) Conexión establecida.");
    }

    public void stop() throws IOException {
        System.out.println("(Cliente) Cerrando conexiones...");
        is.close(); // (Cliente) Cierra el InputStream
        socket.close(); // (Cliente) Cierra el socket
        System.out.println("(Cliente) Conexiones cerradas.");
    }

    public static void main(String[] args) {
        SocketTCPClient cliente = new SocketTCPClient("localhost", 49171);
        try {
            cliente.start(); // (Cliente) Inicia el proceso de conexión
            System.out.println("Mensaje del servidor:" + cliente.is.read()); // (Cliente) Lee el mensaje enviado por el servidor
            cliente.stop(); // (Cliente) Cierra la conexión

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
