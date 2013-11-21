package networkpack;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import factorypack.MultiParser;
import factorypack.TheCreator;
import networkpack.protocolpack.Decoder;
import DataStructures.controlStructurepack.Cola;

// TODO: Auto-generated Javadoc
/**
 * The Class Cliente.
 */
public class Cliente implements Runnable{
	
	public static void main(String[] args) {
		
	}
	/** The _socket. */
	private Socket _socket;
	
	/** The _puerto. */
	private final int _puerto = 4444;
	
	/** The _entrada. */
	private DataInputStream _entrada;
	
	/** The _salida. */
	private DataOutputStream _salida;
	
	/** The _ip. */
	private InetAddress _ip = getIp();
	
	/** The _mensaje. */
	private String _mensaje;
	
	/** The _recibido. */
	private String _recibido;
	
	/** The _mensajes salida. */
	private Cola _mensajesSalida = new Cola();
	
	/** The _mensajes entrada. */
	private Cola _mensajesEntrada = new Cola();
	
	private boolean _esCreable = true;
	
	private String _error;
	/**
	 * Gets the ip.
	 *
	 * @return the ip
	 */
	
	private InetAddress getIp(){
		try {
			InetAddress direccion = InetAddress.getLocalHost();
			return direccion;
		} catch (UnknownHostException e) {
			_esCreable = false;
			_error = "No Hay Red";
			return null;
		}
	}
	
	public void CrearCliente(){
		try {
			_socket = new Socket(_ip,_puerto);
			_salida = new DataOutputStream(_socket.getOutputStream());
			_entrada = new DataInputStream(_socket.getInputStream());
		} catch (Exception e1) {
			_esCreable = false;
			_error = "No Existe servidor en el puerto " + _puerto;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run(){
		try {
			  MultiParser cast = MultiParser.getInstance();
			  String a="";
			while(!Server.QUIT.equalsIgnoreCase(_recibido)){
				_recibido = _entrada.readUTF();
				_mensajesEntrada.Enqueue(TheCreator.getInstance().BuildDato(_recibido));
				a = cast.ParseToString(_mensajesEntrada.Dequeue());
				Decoder.getInstance().Decode(a);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {}
			}
			finaliza();
		} catch (IOException e1) {
			finaliza();
		}
	}
	
	/**
	 * Finaliza.
	 */
	public void finaliza() {
			try {
				_entrada.close();
				_salida.close();
				_socket.close();
				System.exit(0);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				_error = "No es posible Conectar con el servidor";
			}
	}
	/**
	 * Enviar mensaje.
	 */
	public void EnviarMensaje(){
		if(!_mensajesSalida.Vacio()){	
			try {
				_mensaje = MultiParser.getInstance().ParseToString(_mensajesSalida.Dequeue());
				if (!_mensaje.equals("")){
					_salida.writeUTF(_mensaje);
				}
			} catch (IOException e) {
				System.exit(1);
			}
		}
	}

	/**
	 * Sets the mensaje.
	 *
	 * @param pmensaje the new mensaje
	 */
	public void AgregarMensaje(String pmensaje){
		_mensajesSalida.Enqueue(TheCreator.getInstance().BuildDato(pmensaje));
	}
	
	public boolean isCreable(){
		return _esCreable;
	}
	public String getError(){
		return _error;
	}
}