/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad_3_1_envio_archivo_txt;

/**
 *
 * @author USER
 */
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        final int PUERTO = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor esperando conexiones...");

            // Acepta la conexión entrante
            Socket socketCliente = serverSocket.accept();
            System.out.println("Cliente conectado");

            // Obtén el flujo de entrada del cliente
            BufferedReader entradaCliente = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

            // Lee el nombre del archivo enviado por el cliente
            String nombreArchivo = entradaCliente.readLine();

            // Intenta leer el contenido del archivo
            try (BufferedReader lectorArchivo = new BufferedReader(new FileReader(nombreArchivo))) {
                // Prepara el flujo de salida para enviar el contenido del archivo al cliente
                PrintWriter salidaCliente = new PrintWriter(socketCliente.getOutputStream(), true);
                
                // Lee línea por línea del archivo y envía al cliente
                String linea;
                while ((linea = lectorArchivo.readLine()) != null) {
                    salidaCliente.println(linea);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

