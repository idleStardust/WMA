package DataStructures.nodepack;

import DataStructures.datapack.IDato;

/**
 * Clase NodoDoble. Ayuda a la clase {@link  DataStructures.arraypack.ArregloDoble} y {@link  DataStructures.arraypack.ArregloCircularDoble}.
 * Contiene cualquier dato que sea del tipo {@link  DataStructures.datapack.IntegerMax},
 * {@link  DataStructures.datapack.StringMax}, {@link  DataStructures.datapack.CharMax}, {@link  DataStructures.datapack.FloatMax}
 */
public class NodoDoble {
	
	/** The _dato. */
	private IDato _dato;
	
	/** The _next. */
	private NodoDoble _next;
	
	/** The _prev. */
	private NodoDoble _prev;
	
	/**
	 * Instancia un nuevo nodo doble.
	 *
	 * @param pDato el dato que contiene el nodo.
	 */
	public NodoDoble(IDato pDato){
		_dato = pDato;
		_next = null;
		_prev = null;
	}
	
	/**
	 * Define el siguiente. Define el nodo siguiente.
	 *
	 * @param pNodo el nodo siguiente.
	 */
	public void setNext(NodoDoble pNodo){
		_next = pNodo;
	}
	
	/**
	 * Solicitar el siguiente.
	 *
	 * @return retorna el dato siguiente.
	 */
	public NodoDoble getNext(){
		return _next;
	}
	
	/**
	 * Define el anterior. Define el nodo anterior a este.
	 *
	 * @param pNodo el nodo anterior.
	 */
	public void setPrev(NodoDoble pNodo){
		_prev = pNodo;
	}
	
	/**
	 * Solicitar el Anterior.
	 *
	 * @return retorna el dato anterior.
	 */
	public NodoDoble getPrev(){
		return _prev;
	}
	
	/**
	 * Solicita el dato. Retorna el dato que este contiene
	 *
	 * @return el dato que contiene.
	 */
	public IDato getDato(){
		return _dato;
	}
	
	public void setDato(IDato pDato){
		_dato = pDato;
	}
	
	/**
	 * Imprime. Imprime el dato en consola
	 */
	public void Print(){
		_dato.Print();
	}
}
