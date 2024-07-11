/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiHoloShockes;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author USER
 */
public class GestorProcesos extends Thread {

    private Socket socket;
    private OutputStream os;

    public GestorProcesos(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            realizarProceso();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void realizarProceso() throws IOException {
        os = this.socket.getOutputStream(); // (Hilo) Obtiene el OutputStream del socket
        Random generadorNumerosAleatorios = new Random();
        int tiempoEspera = generadorNumerosAleatorios.nextInt(60);
        try {
            TimeUnit.SECONDS.sleep(tiempoEspera); // (Hilo) Espera un tiempo aleatorio antes de enviar el mensaje
            os.write(tiempoEspera); // (Hilo) Envía el mensaje al cliente
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            os.close(); // (Hilo) Cierra el OutputStream
        }
    }
}
