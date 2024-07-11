/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad_3_2_UDP;

import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket = null; // Declaramos un socket de datagrama
        final int PUERTO_SERVIDOR = 12345; // Puerto del servidor
        final String HOST_SERVIDOR = "localhost"; // Host del servidor

        try {
            // Creamos un nuevo socket de datagrama
            socket = new DatagramSocket();
            InetAddress direccionServidor = InetAddress.getByName(HOST_SERVIDOR); // Obtenemos la dirección IP del servidor

            // Bucle para enviar 10,000 mensajes
            for (int i = 0; i < 10000; i++) {
                String mensaje = "Mensaje: " + i; // Crear el mensaje
                byte[] buffer = mensaje.getBytes(); // Convertir el mensaje a bytes
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR); // Crear un paquete con el mensaje
                socket.send(paquete); // Enviar el paquete al servidor
            }

            // Enviar mensaje de FIN
            String finMensaje = "FIN";
            byte[] bufferFin = finMensaje.getBytes();
            DatagramPacket paqueteFin = new DatagramPacket(bufferFin, bufferFin.length, direccionServidor, PUERTO_SERVIDOR);
            socket.send(paqueteFin);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close(); // Cerrar el socket al finalizar
            }
        }
    }
}

