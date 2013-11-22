package gui.networkpack.chatpack;

import networkpack.Cliente;
import networkpack.protocolpack.Encoder;



public class FacadeChatCliente {
	private static FacadeChatCliente _facadeSingleton = new FacadeChatCliente();
	private ChatCliente _interfaz;
	private Cliente _cliente;
	private String _ip;
	
	private FacadeChatCliente(){
	}
	public static FacadeChatCliente getInstace(){
		return _facadeSingleton;
	}
	public void setInterfaz(ChatCliente pinterfaz){
		_interfaz = pinterfaz;
	}
	

	public static void main(String[] args) {
		_facadeSingleton.setInterfaz(new ChatCliente());
		_facadeSingleton._interfaz.setVisible(true);
		_facadeSingleton.CrearCliente();
		System.out.println("Main");
	}
	public String CrearCliente(){
		_cliente = new Cliente();
		_cliente.CrearCliente();
		_ip = _cliente.getIp();
		if(_cliente.isCreable()){
			new Thread(_cliente).start();
			return "";
		}
		else{
			String mensaje = _cliente.getError();
			_cliente.finaliza();
			_cliente = null;
			return mensaje;	
		}
	}
	
	public void EscribeRecibido(String pmensaje){
			_interfaz.setTextoaCuadroTexto(pmensaje);
	}
	
	public void EnviarMensaje(){
		_cliente.AgregarMensaje(Encoder.getInstance().EncoderCorrespondence(_ip, "node", "create", "ID:node@533#Domain:"+_ip));
		_cliente.EnviarMensaje();
	}
	
	public void EnviarSolicitud(String pMensaje){
		_cliente.AgregarMensaje(pMensaje);
		_cliente.EnviarMensaje();
	}
	
	
	public Cliente getCliente(){
		return _cliente;
	}
	
	public void ResetCliente(){
		_cliente.finaliza();
		_cliente = null;
	}
	
	public void AssingID(String pID ){
		_interfaz.setID(pID);
	}
}
