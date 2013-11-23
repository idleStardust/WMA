package facadepack;
import networkpack.protocolpack.Encoder;

public class FacadeProtocol {
	private static FacadeProtocol _singletonProtocol = new FacadeProtocol();
	Encoder prueba=Encoder.getInstance();
	
	public static FacadeProtocol getInstance(){
		return _singletonProtocol;
	}
	
	public void enviarMensaje(String pMensaje){
		
	}
	
	public void NuevoMensaje(String pMensaje){
		Encoder prueba=Encoder.getInstance();
	}
	
	public void Encod_enviar(String pMensaje){

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
