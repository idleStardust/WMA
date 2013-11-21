package networkpack;

import java.net.*;
import java.io.*;

import factorypack.MultiParser;
import factorypack.TheCreator;
import networkpack.protocolpack.Decoder;
import DataStructures.controlStructurepack.Cola;


// TODO: Auto-generated Javadoc
/**
 * The Class Server tambien considerada como una clase server.
 */
public class Server implements Runnable{
	/** The _servidor. Socket principal de conexi��n*/
	private static ServerSocket _servidor;
	
	public final static String QUIT = "QUIT";
	
	private static int _numclients;
	
	private static int _numsalons;

	/** The puerto. Puerto de la conexi��n*/
	private final int puerto = 4444;

	private String _recibido;
	
	/** The _aviso de fallo. Pemite saber porque no anda el server*/
	private String _avisoDeFallo;
	
	/** The _encendido. Condicion de apagado/enciendido de la conexi��n*/
	private boolean _encendido;
	
	private static Cola _mensajesPendientesRecibido = new Cola();
	
	private static Cola _conexiones;
	
	private boolean _posibleCrearse = true;
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	
	public static ServerSocket getServer(){
		return _servidor;
	}
	
	public void CrearServer(){
		_conexiones = new Cola();
		try {
			_servidor = new ServerSocket(puerto);
			System.out.println("El sevidor pudo Crearse");
		} catch (IOException e) {
			_posibleCrearse = false;
			_avisoDeFallo = "El puerto " + String.valueOf(puerto) + " no esta disponible.";
			finaliza();
		}
	}
	
	@Override
	public void run(){

		_encendido = true;
		MultiParser cast = MultiParser.getInstance();
		Conector conect;
		(new Conector()).start();
		while(_encendido){
			if (!_mensajesPendientesRecibido.Vacio()){
				_recibido = cast.ParseToString(_mensajesPendientesRecibido.Dequeue());
				for (int x =0; x<_numclients;x++){
					conect = (Conector)_conexiones.Dequeue();
					_conexiones.Enqueue(conect);
					conect.Enviar(_recibido);
				}
			}
		}
		finaliza();
	}
	
	/**
	 * @funcion Finaliza.
	 * Rompe la conexion del conector
	 */
	public void finaliza() {
		try {
			_servidor.close();
			while(!_conexiones.Vacio()){
				((Conector)_conexiones.Dequeue()).Enviar(QUIT);
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			_posibleCrearse = false;
		}
		_encendido = false;
	}
	
	
	/**
	 * @funcion setONOFF
	 * 
	 * Sets the onoff.
	 *
	 * @param pflag the new onoff
	 * Cambia el estado actual de la conexion al estado opuesto (Encendido-Apagado)
	 * 
	 */
	public void setONOFF(boolean pflag){
		_encendido = pflag;
	}
	
	public static void AgregarMensajeRecibido(String pmensaje){
		_mensajesPendientesRecibido.Enqueue(TheCreator.getInstance().BuildDato(pmensaje));
	}
	
	public static void AgregarConexion(Conector pConector){
		_conexiones.Enqueue(pConector);
		_numclients++;
	}
	
	public static void DestruirConexion(Conector pDato){
		_conexiones.Dequeue(pDato);
		_numclients--;
	}
	
	public static int getCantidadConexionex(){
		return _numclients;
	}
	
	public static int getCantidadSalones(){
		_numsalons++;
		return _numsalons;
	}
	
	public String getError(){
		return _avisoDeFallo;
	}
	public boolean isCreable(){
		return _posibleCrearse;
	}
}
