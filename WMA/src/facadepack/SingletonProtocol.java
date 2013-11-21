package facadepack;

import networkpack.protocolpack.Encoder;

public class SingletonProtocol {
	private static SingletonProtocol _singletonProtocol = new SingletonProtocol();
	Encoder prueba=Encoder.getInstance();
	
	public static SingletonProtocol getInstance(){
		return _singletonProtocol;
	}
	
	public void enviarMensaje(String pMensaje){
		
	}
	
	public void NuevoMensaje(String pMensaje){
		Encoder prueba=Encoder.getInstance();
	}
	
	public void Encod_enviar(String pMensaje){
		String[] msg_recieve=pMensaje.split("%");
		String toSend=prueba.EncoderCorrespondence(msg_recieve[0], msg_recieve[1], msg_recieve[2], msg_recieve[3]);
		prueba._from=msg_recieve[4];
		prueba._to=msg_recieve[5];
	}
	
	
	public void recibirMensaje(String pMensaje){
		
	}
	
	public void crear(String pDato){
	}
	
	public void destruir(String pDato){
		
	}
	
	public void call(String pDato,String pDirection){
		
	}
	
	public void conectar(String pDato1,String pDato2,String pArista){
		
	}
	public void mission(String pDato,String pDirection){
		
	}
	public void visit(String pDato,String pDirection){
		
	}
	public void halt(){
		
	}
	public void recolectar(String pDato){
		
	}
	public void rconectar(String pDato1,String pDato2,String pArista){
		
	}
}
