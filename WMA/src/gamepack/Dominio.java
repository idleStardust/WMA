package gamepack;

import DataStructures.grafopack.Graph;

public class Dominio implements Comparable<Dominio>{
	private Graph<Region> _grafo;
	private String _ip;

	public Dominio(String pIp){
		_ip = pIp;
		_grafo = new Graph<Region>();
	}
	
	@Override
	public int compareTo(Dominio o) {
		if(_ip.compareTo(((Dominio)o).getIP()) < 0){
			return -1;
		}
		else if(_ip.compareTo(((Dominio)o).getIP()) < 0){
			return 1;
		}
		return 0;
	}
	public String getIP(){
		return _ip;
	}
	public Graph<Region> getGraph(){
		return _grafo;
	}
	
}
