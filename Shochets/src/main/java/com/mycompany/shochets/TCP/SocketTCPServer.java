/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.shochets.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author USER
 */
public class SocketTCPServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    public SocketTCPServer(int puerto) throws IOException {
        // Paso 1: Creación un socket de tipo servidor indicando el puerto de escucha
        serverSocket = new ServerSocket(puerto);
    }

    public void start() throws IOException {
        System.out.println("(Servidor) Esperando conexiones . . . '' ");
        // Paso 2: Indica al socket que quede a la espera de peticiones mediante el método accept().
        // En este punto la ejecución quedará detenida hasta que llegue una petición de conexión por parte de un cliente

        // Paso 3: Una vez recibida la petición de conexión se crea el objeto de la clase Socket que
        // representa la conexión entre servidor y eliente.
        socket = serverSocket.accept();

        // Paso 4: Una vez establecida la conexión se abren los flujos de lectura y escritura de datos
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("(Servidor) Conexión establecida.");
    }

    public void stop() throws IOException {

        System.out.println("(Servidor) Cerrando conexiones...");
        // Paso 6: Cerrar los flujos de lectura y escritura de datos
        is.close();
        os.close();

        // Paso 7: Cerrar la conexión
        socket.close();
        serverSocket.close();
        System.out.println("(Servidor) Conexiones cerradas." );
        }

        //vamos a comentar los pasos para crear un servidor TCP
        public static void main(String[] args) {
            try {

                SocketTCPServer servidor = new SocketTCPServer(49000);

                servidor.start();

                // Paso 5: Intercambiar datos con el cliente
                System.out.println( "Mensaje del servidor:" + (byte)servidor.is.read());
                servidor.os.write(200);

                // Paso 6: Cerrar los flujos de lectura y escritura de datos y la conexión en el método stop
                servidor.stop();
            } catch (IOException ioe ) {
                ioe.printStackTrace() ;
            }
        }
}




