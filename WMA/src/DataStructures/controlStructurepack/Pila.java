package DataStructures.controlStructurepack;

import DataStructures.datapack.IDato;
import DataStructures.nodepack.Nodo;

/**
 * Clase Pila.
 * Para formase se ayuda del tipo de dato {@link  DataStructures.nodepack.Nodo}.
 */
public class Pila {
	
	/** el nodo superior, o el unico nodo accesible. */
	private Nodo _top;
	
	/**
	 * Instancia una nueva pila.
	 */
	public Pila(){
		_top = null;
	}
	
	/**
	 * Push. Ingresa un dato al principio de la pila
	 *
	 * @param pdato el dato a ingresar
	 */
	public void Push(IDato pdato){
		Nodo tmp = _top;
		_top = new Nodo(pdato);
		_top.setNext(tmp);
	}
	
	/**
	 * Pop. Retorna el dato superior de la pila y lo elimina.
	 *
	 * @return el dato en la parte superior de la pila. retorna null si la pila esta vacia.
	 */
	public IDato Pop(){
		if (!Vacio()){
			Nodo tmp = _top;
			_top = _top.getNext();
			return (IDato) tmp.getDato();
		}
		else{
			return null;
		}
	}
	
	/**
	 * Top. Retorna el primer elemento visible de la pila, sin borrarlo.
	 *
	 * @return el primer dato de la pila. retorna null si la pila esta vacia.
	 */
	public IDato top(){
		if (!Vacio()){
			return _top.getDato(); 			
		}
		else{
			return null;
		}

	}
	
	/**
	 * Vacio. Verifica si la lista esta vacia
	 *
	 * @return true, si la lista no tiene elementos
	 */
	public boolean Vacio(){
		return _top == null;
	}
}
