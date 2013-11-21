package factorypack;


import DataStructures.arraypack.ArregloDoble;
import DataStructures.datapack.*;

public class TheCreator {
	private static TheCreator _abstractFactorySingleton= new TheCreator();
	
	private TheCreator(){
	}
	
	public static TheCreator getInstance(){
		return _abstractFactorySingleton;
	}
	
	public IDato BuildDato(String pDato){
		return new StringMax(pDato);
	}
	public IDato BuildDato(int pDato){
		return new IntegerMax(pDato);
	}
	public IDato BuildDato(char pDato){
		return new CharMax(pDato);
	}
	public IDato BuildDato(float pDato){
		return new FloatMax(pDato);
	}
	public IDato builDato(ArregloDoble pDato){
		return new ArregloMax(pDato);
	}
	
	public ArregloDoble BuildArregloDoble(){
		return new ArregloDoble();
	}
}
