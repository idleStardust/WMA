package gui.networkpack.chatpack;

import networkpack.Server;
import networkpack.protocolpack.Encoder;

public class FacadeAdminServer {
	private static FacadeAdminServer _facadeSingleton = new FacadeAdminServer();
	private ChatServer _interfaz;
	private Server _server;
	private FacadeAdminServer(){
	}
	public static FacadeAdminServer getInstace(){
		return _facadeSingleton;
	}
	public void setInterfaz(ChatServer pinterfaz){
		_interfaz = pinterfaz;
	}
	
	public String CrearServer(){
		_server = new Server();
		_server.CrearServer();
		if(_server.isCreable()){
			return "";
		}
		else{
			String mensaje = _server.getError();
			_server.finaliza();
			_server = null;
			return mensaje;	
		}
	}
	
	public void EscribeRecibido(String pmensaje){
			_interfaz.setTextoaCuadroTexto(pmensaje);
	}
	
	public void EnviarMensaje(){
		Server.AgregarMensajeRecibido(Encoder.getInstance().EncoderCorrespondence("Server@WMA", "node", "create", (_interfaz.getMensaje().replace('#', '?'))));
	}
	
	
	public Server getServer(){
		return _server;
	}
	
	public void ResetServer(){
		_server.finaliza();
		_server = null;
	}
}
