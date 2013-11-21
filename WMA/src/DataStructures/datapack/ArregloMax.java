package DataStructures.datapack;

import DataStructures.arraypack.IColeccion;

public class ArregloMax implements IDato{
	private IColeccion _lista;
	private int _y;
	
	
	public ArregloMax(IColeccion pDato){
		_lista = pDato;
	}
	
	@Override
	public boolean Mayor(IDato pDato) {
		return _y > ((ArregloMax)pDato).getY();
	}

	@Override
	public boolean Menor(IDato pDato) {
		return _y < ((ArregloMax)pDato).getY();
	}

	@Override
	public boolean Igual(IDato pDato) {
		return _y == ((ArregloMax)pDato).getY();
	}

	@Override
	public void Print() {
		_lista.Print();
	}

	@Override
	public String getTipo() {
		return "ArregloMax";
	}
	
	public void setY(int pY){
		_y = pY;
	}
	
	public int getY(){
		return _y;
	}
	public IColeccion getDato(){
		return _lista;
	}

}
