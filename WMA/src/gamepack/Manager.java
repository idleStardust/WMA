package gamepack;

import DataStructures.grafopack.*;
public class Manager {
	private String _ip;
	
	private Graph<Dominio> _supergrafo;
	
	private Dominio _dominio;
	
	public Manager(){
		_supergrafo = new Graph<Dominio>();
		_dominio = new Dominio("192.168.1.1");
	}
	
	public void llamarCazador(String pId){
		
	}
	
	public void misionCazador(String pId){
		
	}
	public void visitar(String pId,String pHunter){
		
	}
	
	public String crearRegionLocal(){
		NormalRegion region = new NormalRegion(_ip, null);
		
		_dominio.getGraph().add(region,region.getID());
		return region.getID();
	}
	
	public String crearRegionLocal(Arduino pArduino){
		NormalRegion region = new NormalRegion(_ip, pArduino);
		_dominio.getGraph().add(region,region.getID());
		return region.getID();
	}
	
	public String crearRegionExtrangera(String pID, String pIp,Arduino pArduino){
		NormalRegion region = new NormalRegion(pID, pIp, pArduino);
		Dominio dom = _supergrafo.search(pIp);
 		dom.getGraph().add(region,region.getID());
		return region.getID();
	}
	
	public void crearArduino(int pPuntos, String pId){
		Region region = _dominio.getGraph().search(pId);
		if ("node".equals(region.getTipo())){
			Arduino arduino = new Arduino(pPuntos);
			((NormalRegion)region).AssingArduino(arduino);
		}
	}
	public void crearHunter(String pId,String pIdNode){
		Cazador cazador = new Cazador();
		Region region = _dominio.getGraph().search(pId);
		//cazador.setHomeRegion(region.);
		if ("node".equals("")){
			
		}	
	}
	public void print(){
		_dominio.getGraph().printVertex();
	}
	
	public void crearHunter(String pId,String pRegion,String pDominio){
		
	}
}