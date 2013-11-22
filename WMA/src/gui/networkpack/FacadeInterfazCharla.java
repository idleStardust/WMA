package gui.networkpack;


import networkpack.Cliente;
import networkpack.Server;

public class FacadeInterfazCharla {
	private static FacadeInterfazCharla _facadeSingleton = new FacadeInterfazCharla();
	private InterfazSockets _interfaz;
	private Cliente _cliente;
	private Server _server;
	private FacadeInterfazCharla(){
	}
	public static FacadeInterfazCharla getInstace(){
		return _facadeSingleton;
	}
	public void setInterfaz(InterfazSockets pinterfaz){
		_interfaz = pinterfaz;
	}
	public void setCliente(){
		_interfaz.setTitle("Cliente");
		_interfaz.setBotonA();
	}
	public void setServer(){
		_interfaz.setTitle("Server");
		_interfaz.setServer();
		_interfaz.setBotonB();
	}
	
	public String CrearServer(){
		_server = new Server();
		_server.CrearServer();
		if(_server.isCreable()){
			return "";
		}
		else{
			String mensaje = _server.getError();
			_server = null;
			return mensaje;	
		}
	}

	public String CrearCliente(){
		_cliente = new Cliente();
		_cliente.CrearCliente();
		if(_cliente.isCreable()){
			return "";
		}
		else{
			String mensaje = _cliente.getError();
			_cliente = null;
			return mensaje;	
		}
	}

	public void EscribeRecibido(String pmensaje){
			_interfaz.setTextoaCuadroTexto(pmensaje);
	}
	public void EnviarMensaje(int pdireccion){
		if (pdireccion == 1){
			_cliente.AgregarMensaje(_interfaz.getMensaje());
			_cliente.EnviarMensaje();
		}
		else{
			Server.AgregarMensajeRecibido(_interfaz.getMensaje());	
		}
		
	}
	public Cliente getCliente(){
		return _cliente;
	}
	public Server getServer(){
		return _server;
	}
	
	public void ResetCliente(){
		_cliente.finaliza();
		_cliente = null;
	}
	public void ResetServer(){
		_server.finaliza();
		_server = null;
	}
	
	
	
	
	
}
