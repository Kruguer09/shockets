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

public class TCPClient {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 12345;

        try (Socket socket = new Socket(HOST, PUERTO)) {
            // Obtiene los flujos de entrada y salida del cliente
            BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salidaServidor = new PrintWriter(socket.getOutputStream(), true);

            // Lee el nombre del archivo del usuario
            BufferedReader entradaUsuario = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese la ruta del archivo:");
            String rutaArchivo = entradaUsuario.readLine();

            // Envía el nombre del archivo al servidor
            salidaServidor.println(rutaArchivo);

            // Lee y muestra el contenido del archivo recibido del servidor
            String linea;
            while ((linea = entradaServidor.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

