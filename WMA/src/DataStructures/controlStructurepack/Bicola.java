package DataStructures.controlStructurepack;

import DataStructures.nodepack.NodoDoble;
import DataStructures.datapack.IDato;

/**
 * Clase Bicola.
 * Para formase se ayuda del tipo de dato {@link  DataStructures.nodepack.Nodo}.
 */
public class Bicola {
	/** El elemento inicial. */
	private NodoDoble _head;
	
	/** El elemento final. */
	private NodoDoble _tail;

	/**
	 * Insertar al inicio. Inserta el dato en la primera posicion
	 *
	 * @param pDato el dato a ingresar.
	 */
	public void InsertarAlInicio(IDato pDato){
		if(!Vacio()){
			NodoDoble tmp = _head;
			_head = new NodoDoble(pDato);
			_head.setNext(tmp);
			tmp.setPrev(_head);
		}
		else{
			_head = new NodoDoble(pDato);
			_tail = _head;
			_head.setNext(_tail);
			_tail.setPrev(_head);
		}
	}
	
	/**
	 * Insertar al final. Inserta el elemento en la ultima posicion de la cola
	 *
	 * @param pDato el Dato a ingresar
	 */
	public void InsertarAlFinal(IDato pDato){
		if(!Vacio()){
			NodoDoble tmp = _tail;
			_tail = new NodoDoble(pDato);
			tmp.setNext(_tail);
			_tail.setPrev(tmp);
		}
		else{
			_head = new NodoDoble(pDato);
			_tail = _head;
			_head.setNext(_tail);
			_tail.setPrev(_head);
		}
	}
	
	/**
	 * Borrar inicio. Borra el primer elemento de la cola.
	 *
	 * @return el dato borrado. Retornara null si la cola esta vacia.
	 */
	public IDato BorrarInicio(){
		if(Vacio()){
			NodoDoble tmp = _head;
			if (_head == _tail){
				_head = null;
				_tail = null;
			}
			else{
				_head = _head.getNext();
				_head.setPrev(null);
				tmp.setNext(null);	
			}
			
			return tmp.getDato();
		}
		else{
			return null;
		}
	}
	
	/**
	 * Borrar final. Borra el dato que se encuentra en la ultima posicion.
	 *
	 * @return el dato borrado. retorna null si la cola esta vacia.
	 */
	public IDato BorrarFinal(){
		if (!Vacio()){
			NodoDoble tmp = _tail;
			if (_head == _tail){
				_head = null;
				_tail = null;
			}
			else{
				_tail = _tail.getPrev();
				_tail.setNext(null);
				tmp.setPrev(null);	
			}
			return tmp.getDato();
		}
		else{
			return null;
		}
	}
	
	
	/**
	 * Vacio. verifica si la cola tiene algun elemento
	 *
	 * @return true, si esta vacio.
	 */
	public boolean Vacio(){
		return _head == null;
	}
}
