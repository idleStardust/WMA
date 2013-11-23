package facadepack;
import managerpack.MainManager;
import networkpack.protocolpack.Constantes;
import networkpack.protocolpack.Encoder;

public class FacadeProtocol {
	private static FacadeProtocol _singletonProtocol = new FacadeProtocol();
	Encoder prueba=Encoder.getInstance();
	String[] Mensaje ;
	
	public static FacadeProtocol getInstance(){
		return _singletonProtocol;
	}
	
	
	
	
	public void enviarMensaje(String pMensaje){
		prueba.EncoderCorrespondence(Mensaje[1], Mensaje[4], Mensaje[5], Mensaje[7]);
		prueba._from=Mensaje[2];
		prueba._to=Mensaje[3];
	}
	
	public void NuevoMensaje(String pMensaje){
		Encoder prueba=Encoder.getInstance();
	}
	
	public void Encod_enviar(String pMensaje){

	}
	
	
	public void recibirMensaje(String[] pMensaje){
		Mensaje=pMensaje;
	}
	
	public void crear(String pDato){
	}
	

	
	public void call(String pDato,String pDirection){
		
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
	
	public void crearNodo(String[] pMensaje){
		MainManager.getInstance().getManager().crearRegionExtranjera(pMensaje[6].split("#")[0].replace("ID:", ""), pMensaje[6].split("#")[1].replaceFirst("Domain:", ""), null);
	}
	
	public void borrarNodo(String[] pMensaje){
		MainManager.getInstance().getManager().borrarRegionExtranjera(pMensaje[6].split("#")[0].replace("ID:", ""), pMensaje[6].split("#")[1].replaceFirst("Domain:", ""));
	}
	public void conectarNodos(String[] pMensaje){
		if(pMensaje[4].equalsIgnoreCase(Constantes.CONECTOR))
			MainManager.getInstance().getManager().conectar(pMensaje[2], pMensaje[3]);
		//else 
			//MainManager.getInstance().getManager().rConectar(pMensaje[2], pMensaje[3]);
			
	}
	
	public void conectarNodoConexion(String[] pMensaje){
		//if(pMensaje[4]=="linker" )
		//MainManager.getInstance().getManager().(pMensaje[2], pMensaje[3]);
	}
	
	public void desconectarNodoConexion(String[] pMensaje){
		//MainManager.getInstance().getManager().crearRegionExtranjera(pMensaje[6].split("#")[0].replace("ID:", ""), pMensaje[6].split("#")[1].replaceFirst("Domain:", ""), null);
	}
	
	public void nuevaMission(String[] pMensaje){
		//MainManager.getInstance().getManager().crearRegionExtranjera(pMensaje[6].split("#")[0].replace("ID:", ""), pMensaje[6].split("#")[1].replaceFirst("Domain:", ""), null);
	}
	
	public void backHome(String[] pMensaje){
		//MainManager.getInstance().getManager().crearRegionExtranjera(pMensaje[6].split("#")[0].replace("ID:", ""), pMensaje[6].split("#")[1].replaceFirst("Domain:", ""), null);
	}
}
