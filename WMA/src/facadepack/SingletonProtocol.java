package facadepack;

import networkpack.protocolpack.Encoder;

public class SingletonProtocol {
	private static SingletonProtocol _singletonProtocol = new SingletonProtocol();
	
	public static SingletonProtocol getInstance(){
		return _singletonProtocol;
	}
	
	public void enviarMensaje(String pMensaje){
		
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
