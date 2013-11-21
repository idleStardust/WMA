package DataStructures.controlStructurepack;

import DataStructures.nodepack.Nodo;
import DataStructures.datapack.IDato;

/**
 * Clase Cola.
 * Para formase se ayuda del tipo de dato {@link  DataStructures.nodepack.Nodo}.
 */
public class Cola {
	
	/** El elemento inicial. */
	private Nodo _head;
	
	/** El elemento final. */
	private Nodo _tail;
	
	/**
	 * Enqueue. Agrega un nodo al final de la cola 
	 *
	 * @param pDato el dato a insertar.
	 */
	public void Enqueue(IDato pDato){
		if(_head != null){
			Nodo tmp = _tail;
			_tail = new Nodo(pDato);
			tmp.setNext(_tail);
		}
		else{
			_head = new Nodo(pDato);
			_tail = _head;
		}
	}
	
	/**
	 * Dequeue. Quita el dato en la primera posicion de la cola.
	 *
	 * @return  el dato en la primera posicion, retorna null si la cola esta vacia.
	 */
	public IDato Dequeue(){
		if(_head !=null){
			Nodo tmp = _head;
			_head = _head.getNext();
			tmp.setNext(null);
			return tmp.getDato();
		}
		else{
			return null;
		}
	}
	
	public void Dequeue(IDato pDato){
		if(_head !=null){
			if (_head.getDato().Igual(pDato)){
				_head = _head.getNext();
			}
			else if (_tail.getDato().Igual(pDato)){
				Dequeue();
			}
			else{
				Nodo nodoActual = _head;
				while(nodoActual.getNext() != null && !nodoActual.getNext().getDato().Igual(pDato)){
					nodoActual = nodoActual.getNext();
				}
				if (nodoActual.getNext() != null){
					Nodo nodoSwap = nodoActual.getNext();
					nodoActual.setNext(nodoSwap.getNext());
				}
			}
		}
	}
	
	
	/**
	 * Vacio. verifica si la cola tiene algun elemento
	 *
	 * @return true, si esta vacio
	 */
	public boolean Vacio(){
		return _head == null;
	}
	public void Print(){
		Nodo tmp = _head;
		System.out.print("[");
		while (tmp != null){
			tmp.Print();
			System.out.print(",");
			tmp = tmp.getNext();
		}
		System.out.print("]");
	}
}
