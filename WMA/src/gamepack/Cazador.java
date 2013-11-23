package gamepack;

import DataStructures.linkedlistpack.List;

public class Cazador extends Thread{
	private int _points;
	private String _id;
	private static int _serial;
	private String _homeDomain = "192.168.1.1";
	private String _homeRegion = "533";
	private String _foreingDomain;
	private String _foreingRegion;
	private String _target;
	private boolean _mover;
	private List<Region> _Direccion;
	
	public Cazador() {
		// TODO Auto-generated constructor stub
		_id = "bountyhunter@" + String.format("%03d", _serial);
		_serial++;
		_mover = true;
	}
	
	
	/*private NodoGrafo nodoActual;
	
	public void visitar(NodoGrafo pDestino){
		
	}
	
	public void setTaget(String pTarget){
	}
	**/
	@Override
	public void run(){
		while(_mover){
			/*
			 * Aqui debe estar el nodo target;
			 */
		}
	}
	
	public String tipo(){
		return "bountyhunter";
	}
	public String getID(){
		return _id;
	}
	public String getHomeDomain(){
		return _homeDomain;
	}
	public String getHomeRegion(){
		return _homeRegion;
	}
	public void setHomeRegion(String pHomeRegion){
		_homeRegion = pHomeRegion;
	}
	public String getForeingRegion(){
		return _foreingRegion;
	}
	public String getForeingDomain(){
		return _foreingDomain;
	}
	public void setForeingDomain(String pForeingDomain){
		_foreingDomain = pForeingDomain;
	}
	public void setForeingRegion(String pForeingRegion){
		_foreingRegion = pForeingRegion;
	}
	//target es un nodo
	public void setTaget(String pTarget){
		_target = pTarget;
	}
	//target en un nodo
	public String getTaget(){
		return _target;
	}
	public void apagar(){
		_mover = false;
	}
	public String toString(){
		return "ID:" + _id + "#Domain:" + _homeDomain + ":"+ _homeRegion + "#" + "Points:" + _points;
	}
	
}
