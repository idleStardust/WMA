package DataStructures.nodepack;

import DataStructures.datapack.IDato;

/**
 * Clase Nodo. Ayuda a la clase {@link  DataStructures.arraypack.ArregloSimple} y {@link  DataStructures.arraypack.ArregloCircularSimple}.
 * Contiene cualquier dato que sea del tipo {@link  DataStructures.datapack.IntegerMax},
 * {@link  DataStructures.datapack.StringMax}, {@link  DataStructures.datapack.CharMax}, {@link  DataStructures.datapack.FloatMax}
 */
public class Nodo {
	
	/** The _dato. */
	private IDato _dato;
	
	/** The _next. */
	private Nodo _next;
	
	/**
	 * Instancia un nuevo nodo.
	 *
	 * @param pDato el dato que contiene el nodo.
	 */
	public Nodo(IDato pDato){
		_dato = pDato;
		_next = null;
	}
	
	/**
	 * Define el siguiente. Define el nodo siguiente.
	 *
	 * @param pNodo el nodo siguiente.
	 */
	public void setNext(Nodo pNodo){
		_next = pNodo;
	}
	
	/**
	 * Solicitar el siguiente.
	 *
	 * @return retorna el dato siguiente.
	 */
	public Nodo getNext(){
		return _next;
	}
	
	/**
	 * Solicita el dato. Retorna el dato que este contiene
	 *
	 * @return el dato que contiene.
	 */
	public IDato getDato(){
		return _dato;
	}
	
	/**
	 * Imprime. Imprime el dato en consola
	 */
	public void Print(){
		_dato.Print();
	}
}
