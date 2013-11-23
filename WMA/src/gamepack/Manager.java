package gamepack;

import DataStructures.grafopack.*;
// TODO: Auto-generated Javadoc

/**
 * The Class Manager.
 */
public class Manager {
	
	/** Ip.Ip o direccion del dominio. */
	private String _ip = "192.168.1.1";
	
	/** Supergrafo. El grafo de conexion maxima */
	private Graph<Dominio> _supergrafo;
	
	/** El dominio. */
	private Dominio _dominio;
	
	/**
	 * Crear un nuevo manager.
	 */
	public Manager(){
		_supergrafo = new Graph<Dominio>();
		_dominio = new Dominio("192.168.1.1");
		_supergrafo.add(_dominio, "192.168.1.1");
	}
	
	/**
	 * Llamar cazador. Llama al cazador al home region.
	 *
	 * @param pId El id del cazador que se desea buscar.
	 */
	public void llamarCazador(String pId){
		
	}
	
	/**
	 * Mision cazador. Asigna una mision nueva al cazador.
	 *
	 * @param pId el Id del cazador.
	 */
	public void misionCazador(String pId){
		
	}
	
	/**
	 * Visitar. Visita un nodo.
	 *
	 * @param pId the id
	 * @param pHunter the hunter
	 */
	public void visitar(String pId,String pHunter){
		
	}
	
	/**
	 * Crear region local. Crea un nodo el el grafo dominio, que pertenece a la comptadora.
	 *
	 * @return La region recien creada.
	 */
	public String crearRegionLocal(){
		NormalRegion region = new NormalRegion(_ip, null);
		
		_dominio.getGraph().add(region,region.getID());
		return region.toString();
	}
	
	/**
	 * Crear region local. Crea un aregion local que contenga arduino
	 *
	 * @param pArduino el arduino asignado.
	 * @return La region creada.
	 */
	public String crearRegionLocal(Arduino pArduino){
		NormalRegion region = new NormalRegion(_ip, pArduino);
		_dominio.getGraph().add(region,region.getID());
		return region.toString();
	}
	
	/**
	 * Crear region extranjera.
	 *
	 * @param pID the id
	 * @param pIp the ip
	 * @param pArduino the arduino
	 * @return the string
	 */
	public String crearRegionExtranjera(String pID, String pIp,Arduino pArduino){
		NormalRegion region = new NormalRegion(pID, pIp, pArduino);
		Dominio dom = _supergrafo.search(pIp);
 		dom.getGraph().add(region,region.getID());
		return region.toString();
	}
	
	/**
	 * Crear region servidor extrangera.
	 *
	 * @param pID the id
	 * @param pIp the ip
	 * @return the string
	 */
	public String crearRegionServidorExtranjera(String pID,String pIp){
		RegionServer region = new RegionServer(pID, pIp);
		Dominio dom = _supergrafo.search(pIp);
 		dom.getGraph().add(region,region.getID());
		return region.toString();
	}
	
	/**
	 * Crear region cliente extrangera.
	 *
	 * @param pID the id
	 * @param pIp the ip
	 * @return the string
	 */
	public String crearRegionClienteExtrangera(String pID,String pIp){
		RegionClient region = new RegionClient(pID, pIp);
		Dominio dom = _supergrafo.search(pIp);
 		dom.getGraph().add(region,region.getID());
		return region.toString();
	}
	
	/**
	 * Crear region servidor local.
	 *
	 * @param pID the id
	 * @return the string
	 */
	public String crearRegionServidorLocal(String pID){
		RegionServer region = new RegionServer(pID);
 		_dominio.getGraph().add(region,region.getID());
		return region.toString();
	}
	
	/**
	 * Crear region cliente local.
	 *
	 * @param pID the id
	 * @return the string
	 */
	public String crearRegionClienteLocal(String pID){
		RegionClient region = new RegionClient(pID);
 		_dominio.getGraph().add(region,region.getID());
		return region.toString();
	}
	
	
	/**
	 * Crear arduino.
	 *
	 * @param pPuntos the puntos
	 * @param pId the id
	 */
	public void crearArduino(int pPuntos, String pId){
		Region region = _dominio.getGraph().search(pId);
		if ("node".equals(region.getTipo())){
			Arduino arduino = new Arduino(pPuntos);
			((NormalRegion)region).AssingArduino(arduino);
		}
	}
	
	/**
	 * Crear hunter.
	 *
	 * @param pId the id
	 * @param pIdNode the id node
	 */
	public void crearHunter(String pId,String pIdNode){
		Cazador cazador = new Cazador();
		Region region = _dominio.getGraph().search(pId);
		//cazador.setHomeRegion(region.);
		if ("node".equals("")){
			
		}	
	}
	
	/**
	 * Prints the.
	 */
	public void print(){
		_dominio.getGraph().printVertex();
	}
	
	/**
	 * Crear hunter.
	 *
	 * @param pId the id
	 * @param pRegion the region
	 * @param pDominio the dominio
	 */
	public void crearHunter(String pId,String pRegion,String pDominio){
		
	}
}