package DataStructures.arraypack;

import DataStructures.nodepack.NodoDoble;
import DataStructures.datapack.IDato;

/**
 * Clase ArregloDoble.
 * para formarse se ayuda del tipo de dato {@link  DataStructures.nodepack.NodoDoble}.
 */
public class ArregloDoble implements IColeccion{
	
	/** The _head. */
	private NodoDoble _head;
	
	/** The _tail. */
	private NodoDoble _tail;
	
	/** The _largo. */
	private int _largo;


	/* (non-Javadoc)
	 * @see arraypack.IColeccion#AgregarAlInicio(datapack.IDato)
	 */
	@Override
	public void AgregarAlInicio(IDato pDato){
		if (_largo == 0){
			_head = new NodoDoble(pDato);
			_tail = _head;
			_head.setNext(_tail);
			_tail.setPrev(_head);
		}
		else{
			NodoDoble tmp = _head;
			_head = new NodoDoble(pDato);
			_head.setNext(tmp);
			tmp.setPrev(_head);	
		}
		_largo++;
	}


	/* (non-Javadoc)
	 * @see arraypack.IColeccion#AgregarAlFinal(datapack.IDato)
	 */
	@Override
	public void AgregarAlFinal(IDato pDato){
		NodoDoble tmp = _tail;
		_tail = new NodoDoble(pDato);
		if (_largo == 0){
			_head = _tail;
			_head.setNext(_tail);
			_tail.setPrev(_head);
		}
		else{
			tmp.setNext(_tail);
			_tail.setPrev(tmp);
		}
		_largo++;
	}


	/* (non-Javadoc)
	 * @see arraypack.IColeccion#AgregarEnOrden(datapack.IDato)
	 */
	@Override
	public void AgregarEnOrden(IDato pDato){
		if (_largo == 0 || _head.getDato().Mayor(pDato)){
			AgregarAlInicio(pDato);
		}
		else if(_tail.getDato().Menor(pDato)){
			AgregarAlFinal(pDato);
		}
		else{
			NodoDoble nodoActual = _head;
			while(nodoActual.getDato().Menor(pDato)){
				nodoActual = nodoActual.getNext();
			}
			if (!nodoActual.getDato().Igual(pDato)){
				NodoDoble nodoInsercion = new NodoDoble(pDato);
				
				nodoInsercion.setNext(nodoActual);
				nodoInsercion.setPrev(nodoActual.getPrev());
				nodoInsercion.getPrev().setNext(nodoInsercion);
				nodoInsercion.getNext().setPrev(nodoInsercion);	
				_largo++;	
			}
		}
	}
	
	public void AgregarEnPosicion(IDato pDato, int pPosicion){
		if (pPosicion == _largo){
			AgregarAlFinal(pDato);
		}
		else if (pPosicion == 0){
			AgregarAlInicio(pDato);
		}
		else{
			NodoDoble nodoActual = BuscarNodo(pPosicion);
			NodoDoble nodoInsercion = new NodoDoble(pDato);
			if (nodoActual != null){
				nodoInsercion.setNext(nodoActual);
				nodoInsercion.setPrev(nodoActual.getPrev());
				nodoInsercion.getPrev().setNext(nodoInsercion);
				nodoInsercion.getNext().setPrev(nodoInsercion);
				_largo++;
			}
			else{
				System.out.println("Fuera del Indice");
			}
		}
	}

	/* (non-Javadoc)
	 * @see arraypack.IColeccion#Print()
	 */
	@Override
	public void Print(){
		System.out.print("[");
		if (_largo != 0){
			NodoDoble nodoActual = _head;
			for (int x=0; x!=_largo-1; x++){
				nodoActual.Print();
				System.out.print(",");
				nodoActual = nodoActual.getNext();
			}
			nodoActual.Print();			
		}
		System.out.println("]");
	}


	/* (non-Javadoc)
	 * @see arraypack.IColeccion#BorrarInicio()
	 */
	public IDato BorrarInicio(){
		if (_largo != 0){
			NodoDoble tmp = _head;
			_head = _head.getNext();
			_head.setPrev(null);
			tmp.setNext(null);
			_largo--;
			return tmp.getDato();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see arraypack.IColeccion#BorrarFinal()
	 */
	@Override
	public IDato BorrarFinal(){
		if (_largo != 0){
			NodoDoble tmp = _tail;
			if (_largo == 1){
				_head = null;
				_tail = null;
			}
			else{
				_tail = BuscarNodo(_largo-2);
				_tail.setNext(null);
				tmp.setPrev(null);
			}
			_largo--;
			return tmp.getDato();
		}
		else{
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see arraypack.IColeccion#Borrar(datapack.IDato)
	 */
	@Override
	public IDato Borrar(IDato pDato){
		if (_largo != 0){
			if (_head.getDato().Igual(pDato)){
				return BorrarInicio();
			}
			else if (_tail.getDato().Igual(pDato)){
				return BorrarFinal();
			}
			else{
				NodoDoble nodoActual = _head;
				while(nodoActual != null && !nodoActual.getDato().Igual(pDato)){
					nodoActual = nodoActual.getNext();
				}
				if (nodoActual != null){
					nodoActual.getPrev().setNext(nodoActual.getNext());
					nodoActual.getNext().setPrev(nodoActual.getPrev());
					_largo--;
					return nodoActual.getDato();
				}
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see arraypack.IColeccion#Buscar(datapack.IDato)
	 */
	@Override
	public IDato Buscar(IDato pDato){
		NodoDoble nodoActual = _head;
		while(nodoActual != null && !nodoActual.getDato().Igual(pDato)){
			nodoActual = nodoActual.getNext();
		}
		if (nodoActual != null){
			return nodoActual.getDato();
		}
		return null;
	}

	/**
	 * Buscar nodo.
	 *
	 * @param pPosicion the posicion
	 * @return the nodo doble
	 */
	private NodoDoble BuscarNodo(int pPosicion){
		if (pPosicion >= 0 || pPosicion < _largo){
			if (pPosicion < _largo/2){
				NodoDoble nodo = _head;
				for (int x = 0; x<pPosicion; x++){
					nodo = nodo.getNext();
				}
				return nodo;
			}
			else{
				NodoDoble nodo = _tail;
				for (int x = _largo-1; x>pPosicion; x--){
					nodo = nodo.getPrev();
				}
				return nodo;
			}
			
		}
		else{
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see arraypack.IColeccion#Borrar(int)
	 */
	@Override
	public IDato Borrar(int pposicion){
		if (_largo == 0){
			return null;
		}
		else{
			IDato nodoBorrar;
			if (_largo == 1){
				nodoBorrar = BorrarInicio();
			}
			else if(_largo == pposicion+1){
				nodoBorrar = BorrarFinal();
			}
			else{
				NodoDoble tmp = BuscarNodo(pposicion);
				if (tmp != null){
					tmp.getNext().setPrev(tmp.getPrev());
					tmp.getPrev().setNext(tmp.getNext());
					nodoBorrar = tmp.getDato();
				}
				else{
					return null;
				}
			}
			return nodoBorrar;
		}
	}
	

	/* (non-Javadoc)
	 * @see arraypack.IColeccion#Buscar(int)
	 */
	@Override
	public IDato Buscar(int pPosicion){
		NodoDoble nodo = BuscarNodo(pPosicion);
		if (nodo != null){
			return nodo.getDato();		
		}
		else{
			return null;
		}	
	}
	
	/* (non-Javadoc)
	 * @see arraypack.IColeccion#getLargo()
	 */
	@Override
	public int getLargo(){
		return _largo;
	}

}
