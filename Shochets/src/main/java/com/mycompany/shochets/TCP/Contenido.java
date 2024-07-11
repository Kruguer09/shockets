/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shochets.TCP;

/**
 *
 * @author USER
 */
public class Contenido {
    /*Teniendo en cuenta estos pasos: 
Los pasos para crear un servidor basado en sockets TCP son los siguiente:
* Crear un socket de tipo servidor (server socket) asociado a una dirección y a un
puerto concretos.
* Indicar al socket de tipo servidor que quede a la espera de peticiones de establecimiento
de conexión por parte del cliente.
* Aceptar el establecimiento de la conexión y obtención del socket.

*Abrir los flujos de lectura y escritura de datos.
*l Intercambiar datos con el cliente.
* Cerrar los flujos de lectura y escritura de datos.
* Cerrar de la conexión.

//////////////////////////////////////////////////////////////
Por su parte, los pasos para la creación de un cliente basado en sockets TCP son los siguientes:
* Crear un socket de tipo cliente (socket) indicando la dirección IP y el puerto del servidor.
*  Abrir los flujos de lectura y escritura de datos.
* Intercambiar datos con el servidor.
* Cerrar los flujos de lectura y escritura de datos.
* Cerrar la conexión.
//////////////////////////////////////////////////////////////
Los sockets UDP, además de tener características distintas a los sockets TCP, utilizan clases
y métodos diferentes, aunque a rasgos generales el proceso de comunicación es el
mismo.
Como diferencia fundamental está el hecho de que los paquetes enviados mediante
UDP son independientes entre sí, por lo que las estructuras de datos que los soportan
son arrays de bytes. Estos arrays deben ser dimensionados correctamente para evitar la
pérdida de información o el desaprovechamiento del canal de comunicación.
El proceso desde el lado servidor para el envío y recepción de datagramas es el siguiente:
Creación de un socket UDP mediante la clase DatagramSocket asociado a un puerto.
Creación del array de bytes que actuará de buffer donde almacenar el mensaje recibido.
Creación del datagrama mediante la clase DatagramPacket, utilizando el buffer
creado en el paso anterior.
Recepción del datagrama mediante el método receive del socket. En este punto el
servidor queda a la espera de envíos provenientes del cliente.
La generación y envío de la respuesta se realizará a partir de la información contenida
en el datagrama recibido (host y puerto) y del uso del método send del socket.
Fl Una vez finalizada la comunicación se cierra el socket.
///////////////////////////////////////////////////////////////////////////////////
Cliente UDP
    En el lado cliente, se realizan los siguientes pasos:
El Obtención de la dirección del servidor mediante el uso del método getByName de
la clase InetAddress.
E Creación del socket UDP mediante la clase DatagramSocket.
El Generación del datagrama mediante la clase DatagramPacket, utilizando el array de
bytes con el contenido que se desea enviar.
El Envío del datagrama a través del método send del socket.

Hi Para la recepción de la respuesta se debe crear un array de bytes del tamaño suficiente
para almacenar la respuesta y utilizando el método receive del socket.
El Una vez finalizada la comunicación se cierra el socket.

    //////////////////////////////////////////////////////////////////////////////////////////
    multihilo shokets
    El servidor de un sistema en red basado en sockets habitualmente deberá dar servicio a
varios clientes. Si dicho servidor atendiera a las peticiones de manera secuencial provocaría
un cuello de botella y la ralentización de todo el sistema.
Para poder atender a varias peticiones simultáneamente es necesario utilizar threads para
realizar los procesos solicitados sin bloquear el servidor.
El mecanismo es el siguiente: cuando el servidor recibe una petición de conexión, crea
un socket y se lo asigna a un hilo que se encarga de atender la petición de comunicación,
quedando el socket servidor a la espera de la siguiente petición. A grandes rasgos, los
pasos que sigue la ejecución de este tipo de servidores de sockets son los siguientes:
Hi El servidor queda a la espera de peticiones de los clientes mediante el método accept
de la clase ServerSocket. Cada una de estas peticiones se traduce en un socket
TCP entre el cliente y el servidor.
Hi” Cuando el servidor recibe una petición, crea un thread (en el ejemplo que se muestra
a continuación mediante la clase GestorProcesos) y le proporciona el socket.
Fl El thread se encarga de realizar el proceso, liberando al servidor para atender a la
siguiente petición.

    ///////////////////////////////////////////////////////////////////////////////////
    En las redes informáticas, localhost es el nombre reservado que tienen todos los ordenadores.
Está asociado a la dirección IPv4 127.0.0.1 y a la dirección IPv6 ::1. Todos los ordenadores, por
lo tanto, son localhost para sí mismos.
    ////////////////////////////////////////////////////////////////////////////
    Actualmente existen dos versiones de este protocolo: IPv4 e IPv6. IPv4 es el protocolo
tradicional de internet. Debido al tamaño de las direcciones, compuesto por números de
32 bits, admite un número ligeramente superior a cuatro mil millones de combinaciones.
Este número de posibles direcciones se consideró inicialmente suficiente para satisfacer
cualquier demanda de dispositivos conectados, una suposición que con el tiempo se
demostró errónea. La versión IPv6 proporciona direcciones de 128 bits, lo que permite
disponer de alrededor de dieciséis trillones de direcciones posibles.
    ///////////////////////////////////////////////////////////////////////
    Algunos puertos están reservados para servicios específicos. Los números de puerto inferiores
a 1024 se identifican con servicios históricos y se denominan puertos conocidos.
Los números de puerto más altos, entre 49152 y 65535 están disponibles para su
uso general y se conocen como puertos efímeros.
Algunos de los puertos conocidos y los servicios asociados más populares son:
E 21, FTP.
MH 22, SSH.
23, Telnet.
25. SMTP.
80. HTTP.
110. POP3.
143. IMAP.
443. HTTPS.
O Ediciones
    MySQL utiliza el
puerto 3306.
    
    ///////////////////////////////
    El método read sin parámetros de la clase InputStream solo lee un byte. Si
    
    //////////////////////////////PREGUNTAS FINALES////////////////////////////
    Capas del modelo TCP/IP:

Capa de interfaz de red(enlace de datos)
Capa de internet
Capa de transporte
Capa de aplicación
    
Diferencias entre direcciones IPv4 e IPv6:

Tamaño de dirección: IPv4 tiene direcciones de 32 bits, mientras que IPv6 tiene direcciones de 128 bits.
Notación: IPv4 utiliza notación decimal separada por puntos (por ejemplo, 192.168.1.1),
    mientras que IPv6 utiliza notación hexadecimal separada por dos puntos (por ejemplo, 2001:0db8::1).
    
Diferencia entre mensaje y paquete en comunicaciones en red:

Un mensaje es la unidad de datos de la capa de aplicación.
Un paquete es la unidad de datos de las capas inferiores (transporte y red).
    
Concepto de datagrama:

Un datagrama es un paquete de datos independiente y autónomo que contiene suficiente información para ser enrutable desde el origen hasta el destino 
    sin depender de otros paquetes.
    
Puerto por defecto de servidores de base de datos MySQL:

3306
    
Obtener la IP de un URL con la clase InetAddress
    
InetAddress address = InetAddress.getByName("www.ejemplo.com");
System.out.println("IP de www.ejemplo.com: " + address.getHostAddress());
    
Obtener la URL del host de una IP con la clase InetAddress:
    
InetAddress address = InetAddress.getByName("192.168.1.1");
System.out.println("URL del host: " + address.getHostName());
    
Diferencias entre sockets TCP y UDP:

TCP es orientado a la conexión, mientras que UDP es sin conexión.
TCP garantiza la entrega ordenada y sin pérdidas de datos, mientras que UDP no garantiza ni el orden ni la entrega.
TCP realiza el control de congestión, mientras que en UDP no hay control de congestión.
    
Razón por la que la web utiliza TCP y no UDP:

TCP proporciona una comunicación fiable y ordenada, lo cual es crucial para la transmisión de 
    datos en aplicaciones web. La pérdida de datos o la transmisión desordenada podría afectar negativamente la experiencia del usuario.
    
Pasos para crear un servidor de sockets TCP:

Crear un ServerSocket y especificar el puerto.
Esperar a que un cliente se conecte usando accept().
Establecer canales de entrada y salida para la comunicación con el cliente.
Leer y escribir datos a través de los canales.
    
Pasos para crear un cliente de sockets UDP:

Crear un DatagramSocket.
Crear un DatagramPacket con los datos a enviar y la dirección del servidor.
Enviar el DatagramPacket al servidor.
    
Razón de múltiples hilos en un servidor web:

Los hilos permiten que un servidor maneje múltiples solicitudes simultáneamente, mejorando la capacidad de 
    respuesta y el rendimiento al evitar bloqueos en la espera de operaciones de entrada/salida.
    
Razón para elegir UDP en un juego en red:

UDP es preferido en juegos en red debido a su menor latencia y menor sobrecarga en comparación con TCP. 
    En juegos, la velocidad y la capacidad de respuesta son prioritarias, y la pérdida ocasional de paquetes 
    (que no se gestiona en UDP) es aceptable en comparación con la posible demora que introduce TCP.
    
    ///////////////////////////TEST
    3.1. Respuesta: d) IP

3.2. Respuesta: c) Cada paquete puede llegar a su destino por una ruta distinta.

3.3. Respuesta: b) Para comunicaciones de voz.

3.4. Respuesta: a) getHostAdres.

3.5. Respuesta: a) accept.

3.6. Respuesta: c) getInputStream.

3.7. Respuesta: b) send.
    

Actividades de aplicación:

¿Qué información hay que proporcionar obligatoriamente a un socket servidor?

Respuesta: c) El puerto de escucha de peticiones.
¿Qué información hay que proporcionar obligatoriamente a un socket cliente?

Respuesta: a) La dirección IP o el nombre del servidor.
¿Cuál es el primer paso para crear un servidor de sockets TCP?

Respuesta: c) Crear un socket de tipo servidor asociado a una dirección y un puerto.
*/
}
