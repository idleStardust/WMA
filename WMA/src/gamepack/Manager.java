package gamepack;

import DataStructures.grafopack.*;
public class Manager {
	private String _ip;
	
	private Graph<Region> _dominio;
	
	public void llamarCazador(String pId){
		
	}
	
	public void misionCazador(String pId){
		
	}
	
	public void visitar(String pId,String pHunter){
		
	}
	
	public String crearRegion(){
		NormalRegion region = new NormalRegion(_ip, null);
		_dominio.addVertex(region);
		return region.getID();
	}
	
	public String crearRegion(Arduino pArduino){
		NormalRegion region = new NormalRegion(_ip, pArduino);
		_dominio.addVertex(region);
		return region.getID();
	}
	
	public String crearRegion(String pIp){
		NormalRegion region = new NormalRegion(pIp, null);
		_dominio.addVertex(region);
		return region.getID();
	}
	
	public String crearRegion(String pIp,Arduino pArduino){
		NormalRegion region = new NormalRegion(pIp, pArduino);
		_dominio.addVertex(region);
		return region.getID();
	}
	
	public void crearArduino(int pPuntos, String pId){
		Region region = _dominio.search(pId).getDato();
		if ("node".equals(region.getTipo())){
			Arduino arduino = new Arduino(pPuntos);
			((NormalRegion)region).AssingArduino(arduino);
		}
	}
	
	public void crearHunter(String pId,String pIdNode){
		
		Cazador cazador = new Cazador();
		Region region = _dominio.search(pId).getDato();
		//cazador.setHomeRegion(region.);
		if ("node".equals("")){
			
		}	
	}
	
	public void crearHunter(String pId,String pRegion,String pDominio){
		
	}
}