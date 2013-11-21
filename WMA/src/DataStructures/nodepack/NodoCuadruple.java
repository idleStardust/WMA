package DataStructures.nodepack;

import DataStructures.datapack.IDato;

// TODO: Auto-generated Javadoc
/**
 * The Class NodoCuadruple.
 */
public class NodoCuadruple{
	private IDato _dato;
	
	private NodoCuadruple _next;
	
	private NodoCuadruple _prev;
	/** The _up. */
	private NodoCuadruple _up;
	
	/** The _down. */
	private NodoCuadruple _down;
	
	/**
	 * Instantiates a new nodo cuadruple.
	 *
	 * @param pDato the pvalor
	 */
	public NodoCuadruple(IDato pDato) {
		_dato = pDato;
	}
	
	
	
	/*
	 * -------------------------------------------------------------------------
	 * *************************** SETTERS GETTERS *****************************
	 * -------------------------------------------- ----------------------------
	 */
	
	
	/**
	 * Gets the _up.
	 *
	 * @return the _up
	 */
	public NodoCuadruple getUp() {
		return _up;
	}
	
	/**
	 * Gets the _down.
	 *
	 * @return the _down
	 */
	public NodoCuadruple getDown() {
		return _down;
	}
	
	/**
	 * Sets the _up.
	 *
	 * @param pUp the new _up
	 */
	public void setUp(NodoCuadruple pUp) {
		_up = pUp;
	}
	
	/**
	 * Sets the _down.
	 *
	 * @param pDown the new _down
	 */
	public void setDown(NodoCuadruple pDown) {
		_down = pDown;
	}
	public void setNext(NodoCuadruple pNodo){
		_next = pNodo;
	}
	
	/**
	 * Solicitar el siguiente.
	 *
	 * @return retorna el dato siguiente.
	 */
	public NodoCuadruple getNext(){
		return _next;
	}
	
	/**
	 * Define el anterior. Define el nodo anterior a este.
	 *
	 * @param pNodo el nodo anterior.
	 */
	public void setPrev(NodoCuadruple pNodo){
		_prev = pNodo;
	}
	
	/**
	 * Solicitar el Anterior.
	 *
	 * @return retorna el dato anterior.
	 */
	public NodoCuadruple getPrev(){
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
