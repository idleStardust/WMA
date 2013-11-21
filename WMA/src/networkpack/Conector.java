package networkpack;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import DataStructures.datapack.IDato;

public class Conector extends Thread implements IDato{
	
	private Socket _socket;
	private DataInputStream _entrada;
	private DataOutputStream _salida;
	private int _dato;
	private static int _serial;
	
	
	private void Conectar(ServerSocket pServerSocket){
		System.out.println("Estableciendo conexion....");
		try {
			_socket = pServerSocket.accept();
			System.out.println("Conexion Establecida!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR: No se pudo establecer conexion!");
			Close();
		}
	}
	
	private void Enceder(){
		try {
			_salida = new DataOutputStream(_socket.getOutputStream());			
			_entrada = new DataInputStream(_socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR: No se pueden establecer entradas y salidas!");
			Close();
		}
	}
	
	public void run(){
		Conectar(Server.getServer());
		Enceder();
		_dato = _serial;
		_serial++;
		System.out.println("Buffers listos!");
		Server.AgregarConexion(this);
		Conector conector = new Conector();
		conector.start();
		String recibido = "";
		try {
			while (!recibido.equals(Server.QUIT)){
				recibido = _entrada.readUTF();
				if (recibido != null){
					Server.AgregarMensajeRecibido(recibido);
				}
			}			
		} catch (IOException e) {
			System.out.println("ERROR: No se ha podido encontrar entrada");
			Close();
		}
	}
	
	
	public void Enviar(String pMensaje){
		try {
			_salida.writeUTF(pMensaje);
		} catch (IOException e) {
			System.out.println("ERROR: No se ha podido encontrar Salida");
			Close();
		}
		catch (NullPointerException e) {
			System.out.println("ERROR: No se ha podido encontrar Salida");
			Close();
		}
	}
	
	public void Close(){
		try {
			System.out.println("Conexion Cerrada!");
			Server.DestruirConexion(this);
			_salida.close();
			_entrada.close();
			_socket.close();
		} catch (IOException e) {System.exit(0);
		} catch (NullPointerException e) {
			System.exit(0);
		}
	}
	
	public int getDato(){
		return _dato;
	}
	
	@Override
	public boolean Mayor(IDato pDato) {
		return _dato>((Conector)pDato).getDato();
	}

	@Override
	public boolean Menor(IDato pDato) {
		// TODO Auto-generated method stub
		return _dato<((Conector)pDato).getDato();
	}

	@Override
	public boolean Igual(IDato pDato) {
		// TODO Auto-generated method stub
		return _dato == ((Conector)pDato).getDato();
	}

	@Override
	public void Print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return null;
	}

}
