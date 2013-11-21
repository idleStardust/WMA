package arduino;

import java.io.ObjectInputStream.GetField;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.ws.handler.MessageContext;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import Arduino.Arduino;



/**
 * Clase que se encarga de la conexion del Arduino y del manejo de su LCD y fotoresistencia
 * La fotoresistencia envia un valor entre 0 y 1024, donde 0 corresponde a la ausencia total de luz y 1024 a la maxima cantidad de luz.
 * El LCD imprime un String enviado correspondiente a la IP. En la LCD se imprimira: IP: "String enviado"
 *
 */
public class ArduinoConexion {
	//instancia de la libreria
	static Arduino Arduino = new Arduino();
	SerialPortEventListener evento = new SerialPortEventListener() {
		
		@Override
		public void serialEvent(SerialPortEvent arg0) {
			
		}
	};

	
	
	/**
	 * Constructor de la clase
	 */
	public ArduinoConexion() {

		try {
			//importante escoger bien el nombre del puerto a usar
			Arduino.ArduinoRXTX("COM5", 2000, 9600, evento);
		} catch (Exception e) {
			System.out.println("Error: revisar que el nombre de los puertos este bien");
			e.printStackTrace();
		}
		
		
		//este delay es necesario pues la conexion desde la computadora al Arduino tarda 10 segundos aproximadamente, lo que se envie antes de este delay no se procesara
		try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ArduinoConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		System.out.println("La conexion entre la computadora y el Arduino se ha iniciado correctamente");

	}
	
	/**
	 * Este metodo obtiene el valor de la fotoresistencia conectada al Arduino. El valor esta en el intervalo de 0 a 1024. 
	 * El valor retornado es un String, por lo que no es necesario convertirlo de ASCII a decimal
	 * @return {@link String}
	 */
	public String getValorFoto (){
		
		if (Arduino.MessageAvailable()==true){
			return Arduino.PrintMessage();
		}
		
		else{
			return "0";
		}
	}
	
	
	
	
	/**
	 * Este metodo se encarga del envio de mensajes por medio del puerto serial hacia el Arduino
	 * @param mensaje: corresponde al String que se quiere enviar a la LCD del Arduino. Si el mensaje enviado supera los 13 caracteres solamente se imprimiran los primeros 13
	 */
	public void enviarMensaje(String mensaje){
		
		try {
			Arduino.SendData(mensaje);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	/**
	 * Como el Arduino envia datos constantemente cada segundo, el buffer de los puertos serie se llena de todos estos datos, y cuando se solicita recuperarlos
	 * se recupera toda la lista de datos anteriores, no solamente el ultimo (que es el dato que se necesita). Para vaciar el buffer se usa este metodo
	 * que consiste en asignarle el valor del buffer a una variable y asi la memoria serie quedara limpia y lista para recuperar el siguiente dato.
	 * es un metodo viod pues no envia ni recibe nada
	 */
	public static void vaciarBuffer(){
		String 	vaciarBuffer=Arduino.PrintMessage();

	}
	
	
	
	public static void main(String[] args) {
		ArduinoConexion hola = new ArduinoConexion();
		
		hola.enviarMensaje("hola ninos");

		vaciarBuffer();

			try {
	            Thread.sleep(700);
	        } catch (InterruptedException ex) {
	            Logger.getLogger(ArduinoConexion.class.getName()).log(Level.SEVERE, null, ex);
	        }
			System.out.println(hola.getValorFoto());
			
			
			vaciarBuffer();

			try {
	            Thread.sleep(700);
	        } catch (InterruptedException ex) {
	            Logger.getLogger(ArduinoConexion.class.getName()).log(Level.SEVERE, null, ex);
	        }
			
			System.out.println(hola.getValorFoto());
			
			
			try {
	            Thread.sleep(6000);
	        } catch (InterruptedException ex) {
	            Logger.getLogger(ArduinoConexion.class.getName()).log(Level.SEVERE, null, ex);
	        }
			hola.enviarMensaje("qqqqqqqqq");

		

	}

}
