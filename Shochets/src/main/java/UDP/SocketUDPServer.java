/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author USER
 */
public class SocketUDPServer {
    public static void main(String[] args) {
        DatagramSocket socket;
        try {
            // Paso 1: Creación de un socket UDP asociado a un puerto (49171 en este caso)
            socket = new DatagramSocket(49171);
            System.out.println("(Servidor): Creando socket");

            // Paso 2: Creación del array de bytes (buffer) para almacenar el mensaje recibido
            byte[] bufferLectura = new byte[64];

            // Paso 3: Creación del datagrama mediante la clase DatagramPacket, utilizando el buffer
            DatagramPacket datagramaEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
            System.out.println("(Servidor): Recibiendo datagrama");

            // Paso 4: Recepción del datagrama mediante el método receive del socket
            socket.receive(datagramaEntrada);
            System.out.println("(Servidor): Mensaje recibido: " + new String(bufferLectura));

            // Paso 5: Generación y envío de la respuesta utilizando el método send del socket
            System.out.println("(Servidor): Enviando datagrama");
            byte[] mensajeEnviado = new String("Mensaje enviado desde el servidor").getBytes();

            DatagramPacket datagramaSalida = new DatagramPacket(
                mensajeEnviado, 
                mensajeEnviado.length, 
                datagramaEntrada.getAddress(), 
                datagramaEntrada.getPort()
            );
            socket.send(datagramaSalida);

            // Paso 6: Cierre del socket una vez finalizada la comunicación
            System.out.println("(Servidor): Cerrando socket");
            socket.close();
            System.out.println("(Servidor): Socket cerrado.");

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}