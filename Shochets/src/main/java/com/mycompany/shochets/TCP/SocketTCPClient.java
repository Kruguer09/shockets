/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.shochets.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author USER
 */
public class SocketTCPClient {
    private String serveriP;
    private int serverPort;
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    public SocketTCPClient(String serveriP, int serverPort) {
        this.serveriP = serveriP;  //aqui en el constructor es donde se crean los shockets
        this.serverPort = serverPort;
    }

    public void start() throws UnknownHostException, IOException {
        // Paso 1: Crear un socket de tipo cliente indicando la dirección IP y el puerto del servidor
        System.out.println("(Cliente) Estableciendo conexión ... ");
        socket = new Socket(serveriP, serverPort);

        // Paso 2: Abrir los flujos de lectura y escritura de datos
        os = socket.getOutputStream();
        is = socket.getInputStream();

        System.out.println("(Cliente) Conexión establecida.");
    }

    public void stop() throws IOException {
        // Paso 4: Cerrar los flujos de lectura y escritura de datos
        System.out.println("(Cliente) Cerrando conexiones ... ");
        is.close();
        os.close();

        // Paso 5: Cerrar la conexión
        socket.close();

        System.out.println("(Cliente) Conexiones cerradas.");
    }

    public static void main(String[] args) {
        SocketTCPClient cliente = new SocketTCPClient("172.16.8.25", 49000);
        try {
            // Paso 1 y 2: Crear un socket de tipo cliente e indicar la dirección IP y puerto del servidor,
            // y abrir los flujos de lectura y escritura de datos
            cliente.start();

            // Paso 3: Intercambiar datos con el servidor
            cliente.os.write(100);
            System.out.println("Mensaje del cliente:" + cliente.is.read());

            // Paso 4 y 5: Cerrar los flujos de lectura y escritura de datos, y cerrar la conexión
            cliente.stop();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
