/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad_3_2_UDP;

/**
 *
 * @author USER
 */
import java.net.*;
import java.io.*;

public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket socket = null; // Declaramos un socket de datagrama
        FileOutputStream ficheroSalida = null; // Declaramos un flujo de salida para escribir en el archivo
        final int PUERTO_SERVIDOR = 12345; // Puerto del servidor

        try {
            socket = new DatagramSocket(PUERTO_SERVIDOR); // Creamos un nuevo socket de datagrama y lo asociamos al puerto especificado

            // Bucle principal para recibir mensajes
            while (true) {
                byte[] buffer = new byte[1000]; // Creamos un buffer para almacenar los datos recibidos
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length); // Creamos un paquete para recibir los datos
                socket.receive(paquete); // Recibimos el paquete

                String mensajeRecibido = new String(paquete.getData(), 0, paquete.getLength()); // Convertimos los datos recibidos en un string

                if (mensajeRecibido.equals("FIN")) { // Comprobamos si se ha recibido el mensaje de FIN
                    System.out.println("Se ha recibido el mensaje FIN. Finalizando...");
                    break;
                } else {
                    if (ficheroSalida == null) {
                        ficheroSalida = new FileOutputStream("datos.txt"); // Creamos el archivo de salida si no existe
                    }
                    ficheroSalida.write(paquete.getData(), 0, paquete.getLength()); // Escribimos los datos recibidos en el archivo
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ficheroSalida != null) {
                    ficheroSalida.close(); // Cerramos el flujo de salida al finalizar
                }
                if (socket != null) {
                    socket.close(); // Cerramos el socket al finalizar
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

