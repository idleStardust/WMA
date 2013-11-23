package gamepack;

import DataStructures.grafopack.*;
import DataStructures.linkedlistpack.*;
// TODO: Auto-generated Javadoc

/**
 * The Class Manager.
 */
public class Manager {	
	/** Ip.Ip o direccion del dominio. */
	private String _ip = "192.168.1.1";
	
	/** Supergrafo. El grafo de conexion maxima */
	private Graph<Dominio> _supergrafo;
	
	
	/** The _cazadores coleccion. */
	private List<Cazador> _cazadoresColeccion;
	
	/** The _arduino coleccion. */
	private List<Arduino> _arduinoColeccion;

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
	public void misionCazador(String pId){}
	/**
	 * Visitar. Visita un nodo.
	 *
	 * @param pId el id de la {@link Region} a buscar.
	 * @param pHunter el {@link Cazador} al que se le desea asignar.
	 */
	@SuppressWarnings("deprecation")
	public void visitar(String pId,Cazador pHunter){
		pHunter.stop();
		pHunter.setTaget(pId);
		//Agregar Un Dijkstra.
		pHunter.start();
	}
	
	/**
	 * Crear region local. Crea un nodo el el grafo dominio, que pertenece a la computadora.
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
	 * Crear region extranjera. Crea una {@link Region} nueva en el grafo.
	 *
	 * @param pID el id de la region a insertar.
	 * @param pIp el ip del {@link Dominio} al que se desea insetar.
	 * @param pArduino el {@link Arduino} que contiene.
	 * @return el protocolo de la {@link Region}.
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
	 * @param pID el id de la {@link Region}.
	 * @param pIp el ip del {@link Dominio} al cual pertenece.
	 * @return el protocolo de la {@link Region}.
	 */
	public String crearRegionServidorExtranjera(String pID,String pIp){
		RegionServer region = new RegionServer(pID, pIp);
		Dominio dom = _supergrafo.search(pIp);
 		dom.getGraph().add(region,region.getID());
		return region.toString();
	}
	
	/**
	 * Crear {@link RegionClient} extrangera.
	 *
	 * @param pID el id de la {@link RegionClient}.
	 * @param pIp el ip del {@link Dominio}. 
	 * @return el protocolo del {@link RegionClient} creada.
	 */
	public String crearRegionClienteExtrangera(String pID,String pIp){
		RegionClient region = new RegionClient(pID, pIp);
		Dominio dom = _supergrafo.search(pIp);
 		dom.getGraph().add(region,region.getID());
		return region.toString();
	}
	
	/**
	 * Crear {@link RegionServer} local.
	 *
	 * @param pID el id de la {@link RegionServer}.
	 * @return el protocolo de la {@link RegionServer} creada recientemente.
	 */
	public String crearRegionServidorLocal(String pID){
		RegionServer region = new RegionServer(pID);
 		_dominio.getGraph().add(region,region.getID());
		return region.toString();
	}
	
	/**
	 * Crear {@link RegionClient} local. 
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
	 * Crear {@link Arduino}. crea un arduino en un {@link NormalRegion}. no crea {@link Arduino} en una {@link RegionClient} o {@link RegionServer}
	 *
	 * @param pPuntos los puntos que contiene.
	 * @param pId el id de la {@link Region} en donde se desea colocar.
 	 */
	public void crearArduino(int pPuntos, String pId){
		Region region = _dominio.getGraph().search(pId);
		if ("node".equals(region.getTipo())){
			Arduino arduino = new Arduino(pPuntos);
			((NormalRegion)region).AssingArduino(arduino);
			_arduinoColeccion.add(arduino);
		}
	}
	
	/**
	 * Crear {@link Cazador}. Crea un nuevo {@link Cazador} 
	 *
	 * @param pIdNode el id de la {@link Region} en el que "nace" esta es la region casa "home region".
	 */
	public void crearHunter(String pIdNode){
		Cazador cazador = new Cazador();
		Region region = _dominio.getGraph().search(pIdNode);
		cazador.setHomeRegion(region.getID());
		if ("node".equals("")){
			
		}	
	}
	

	/**
	 * Crear {@link Cazador}. Crea un nuevo cazador que sea de otro dominio ageno en el que se crea.
	 *
	 * @param pId el id del cazador.
	 * @param pRegion el id de la region.
	 * @param pDominio el ip del dominio en el cual se encuentra.
	 */
	public void crearHunter(String pId,String pRegion,String pDominio){
		Cazador cazador = new Cazador();
		_cazadoresColeccion.add(cazador);
		Region region = _dominio.getGraph().search(pId);
		if ("node".equals(pId.split("@")[0])){
			cazador.setHomeRegion(region.getID());	
		}
	}
	
	/**
	 * Borrar region extranjera.
	 *
	 * @param pDomain the domain
	 * @param pId the id
	 */
	public void borrarRegionExtranjera(String pDomain, String pId){
		_supergrafo.search(pDomain).getGraph().remove(pId);
	}
	
	/**
	 * Borrar region local.
	 *
	 * @param pId the id
	 * @return the string
	 */
	public String borrarRegionLocal(String pId){
		Region a = _dominio.getGraph().search(pId); 
		_dominio.getGraph().remove(pId);
		return a.toString();
	}
	
	/**
	 * Crear conector extranjero.
	 *
	 * @param pId the id
	 */
	public void crearConectorExtranjero(String pId){
		
	}
	
	/**
	 * Crear conector local.
	 *
	 * @return the string
	 */
	public String crearConectorLocal(){
		return null;
	}
	
	/**
	 * Conectar.
	 *
	 * @param pIdA the id a
	 * @param pIdB the id b
	 */
	public void conectar(String pIdA, String pIdB){
		_supergrafo.conect(pIdA, pIdB);
	}
	
	/**
	 * R conectar.
	 *
	 * @param pIdA the id a
	 * @param pIdB the id b
	 * @param _ipA the _ip a
	 * @param _ipB the _ip b
	 */
	public void rConectar(String pIdA, String pIdB, String pipA, String pipB){
		Region a = _supergrafo.search(pipA).getGraph().search(pIdA);
		Region b = _supergrafo.search(pipB).getGraph().search(pIdB);
		_supergrafo.search(pipA).getGraph().conect(a, b);
		_supergrafo.search(pipB).getGraph().conect(b,a);
	}
	
	public void disconnect(String pIda, String pIdb){
		_supergrafo.disconnect(pIda, pIdb);
	}
	
	public void rdisconnect(String pIda, String pIdb, String pipA, String pipB){
		Region a = _supergrafo.search(pipA).getGraph().search(pIda);
		Region b = _supergrafo.search(pipB).getGraph().search(pIdb);
		_supergrafo.search(pipA).getGraph().disconnect(a,b);
		_supergrafo.search(pipB).getGraph().disconnect(b,a);
	}
	
	
	
	/**
	 * Imprime el dominio.
	 */
	
	public void print(){
		_dominio.getGraph().printVertex();
	}
}