/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettcpserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class SocketTCPServer {

    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    public SocketTCPServer(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }

    public void start() throws IOException {
        System.out.println(" (Servidor)esperando conexiones");
        socket = serverSocket.accept();
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("(Servidor) Conexión establecida");

    }

    public void stop() throws IOException {
        System.out.println("(Servidor) Cerrando conexiones..");
        is.close();
        os.close();
        socket.close();
        serverSocket.close();
        System.out.println("(Servidor) Conexiones cerradas.”");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            SocketTCPServer servidor = new SocketTCPServer(49171);
            servidor.start();
            System.out.println("Mensaje del cliente Josele:" + servidor.is.read());
            String mensaje="para mario";
            byte[] matriz=mensaje.getBytes();
            
            servidor.os.write(matriz);
            servidor.stop();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
