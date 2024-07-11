/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiHoloShockes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author USER
 */
public class SocketTCPServer {

    private ServerSocket serverSocket;

    public SocketTCPServer(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);// Crea un ServerSocket para escuchar en el puerto especificado
        while (true) {
            Socket socket = serverSocket.accept(); // (Servidor) Acepta la conexión del cliente
            System.out.println("(Servidor) Conexión establecida");
            new GestorProcesos(socket).start(); // (Servidor) Crea un hilo para atender la petición del cliente
        }
    }

    public void stop() throws IOException {
        serverSocket.close();// Cierra el ServerSocket
    }
}

