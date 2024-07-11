/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author USER
 */
public class SocketUDPClient {

    public static void main(String[] args) {
        // Paso 1: Definir el mensaje a enviar
        String strMensaje = "Mensaje enviado desde el cliente";
        DatagramSocket socketUDP;

        try {
            System.out.println("(Cliente): Estableciendo parámetros de conexión...");

            // Paso 2: Obtener la dirección del servidor mediante InetAddress.getByName
            InetAddress hostServidor = InetAddress.getByName("localhost");
            int puertoServidor = 49171;
            System.out.println("(Cliente): Creando socket...");

            // Paso 3: Crear el socket UDP mediante la clase DatagramSocket
            socketUDP = new DatagramSocket();
            System.out.println("(Cliente): Enviando datagrama...");

            // Paso 4: Generar el datagrama utilizando DatagramPacket y el array de bytes con el contenido
            byte[] mensaje = strMensaje.getBytes();
            DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServidor, puertoServidor);

            // Paso 5: Enviar el datagrama a través del método send del socket
            socketUDP.send(peticion);
            System.out.println("(Cliente): Recibiendo datagrama...");

            // Paso 6: Crear un array de bytes para almacenar la respuesta
            byte[] buffer = new byte[64];

            // Paso 7: Utilizar el método receive del socket para recibir la respuesta
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, hostServidor, 49171);
            socketUDP.receive(respuesta);

            System.out.println("(Cliente): Mensaje recibido: " + new String(buffer));

            // Paso 8: Cerrar el socket una vez finalizada la comunicación
            System.out.println("(Cliente): Cerrando Socket...");
            socketUDP.close();

            System.out.println("(Cliente): Socket cerrado.");

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}