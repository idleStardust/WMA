package DataStructures.arraypack;

import DataStructures.datapack.IDato;
import DataStructures.nodepack.Nodo;

/**
 * Clase ArregloCircularSimple.
 * Para formarse se ayuda del tipo de dato {@link  DataStructures.nodepack.Nodo}.
 * 
 */
public class ArregloCircularSimple implements IColeccion{
	
	/** The _head. */
	private Nodo _head;
	
	/** The _tail. */
	private Nodo _tail;
	
	/** The _largo. */
	private int _largo;

	/* (non-Javadoc)
	 * @see arraypack.IColeccion#AgregarAlInicio(datapack.IDato)
	 */
	@Override
	public void AgregarAlInicio(IDato pDato){
		if (_largo == 0){
			_head = new Nodo(pDato);
			_tail = _head;
			_head.setNext(_tail);
			_tail.setNext(_head);
		} 
		else{
			Nodo tmp = _head;
			_head = new Nodo(pDato);
			_head.setNext(tmp);
			_tail.setNext(_head);
		}
		_largo++;
	}


	/* (non-Javadoc)
	 * @see arraypack.IColeccion#AgregarAlFinal(datapack.IDato)
	 */
	@Override
	public void AgregarAlFinal(IDato pDato){
		Nodo tmp = _tail;
		_tail = new Nodo(pDato);
		if (_largo == 0){
			_head = _tail;
			_head.setNext(_tail);
			_tail.setNext(_head);
		}
		else{
			tmp.setNext(_tail);
			_tail.setNext(_head);
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
			Nodo nodoActual = _head;
			while(nodoActual.getNext().getDato().Menor(pDato)){
				nodoActual = nodoActual.getNext();
			}
			if (!nodoActual.getNext().getDato().Igual(pDato)){
				if (!nodoActual.getDato().Igual(pDato)){
					Nodo nodoSwap = nodoActual.getNext();
					nodoActual.setNext(new Nodo(pDato));
					nodoActual.getNext().setNext(nodoSwap);	
					_largo++;
				}
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
			Nodo nodoActual = _head;
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
	@Override
	public IDato BorrarInicio(){
		if (_largo != 0){
			Nodo tmp = _head;
			_head = _head.getNext();
			_tail.setNext(_head);
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
			Nodo tmp = _tail;
			if (_largo == 1){
				_head = null;
				_tail = null;
			}
			else{
				_tail = BuscarNodo(_largo-2);
				_tail.setNext(_head);
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
				Nodo nodoActual = _head;
				while(nodoActual.getNext() != _tail && !nodoActual.getNext().getDato().Igual(pDato)){
					nodoActual = nodoActual.getNext();
				}
				if (nodoActual.getNext() != _tail){
					Nodo nodoSwap = nodoActual.getNext();
					nodoActual.setNext(nodoSwap.getNext());
					_largo--;
					return nodoSwap.getDato();
				}
			}
		}
		return null;
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
				Nodo tmp = BuscarNodo(pposicion-1);
				Nodo tmp2 = tmp.getNext();
				tmp.setNext(tmp.getNext().getNext());
				nodoBorrar = tmp2.getDato();
			}
			return nodoBorrar;
		}
	}

	/* (non-Javadoc)
	 * @see arraypack.IColeccion#Buscar(datapack.IDato)
	 */
	@Override
	public IDato Buscar(IDato pDato){
		if (_largo !=0){
			Nodo nodoActual = _head;
			while(nodoActual != _tail && !nodoActual.getDato().Igual(pDato)){
				nodoActual = nodoActual.getNext();
			}
			if (_tail.getDato().Igual(pDato)){
				return _tail.getDato();
			}
			else if(nodoActual.getDato().Igual(pDato)){
				return nodoActual.getDato();
			}	
			return null;
		}
		return null;
	}

	/**
	 * Buscar nodo.
	 *
	 * @param pPosicion the posicion
	 * @return the nodo
	 */
	private Nodo BuscarNodo(int pPosicion){
		Nodo nodo = _head;
		if (pPosicion >= 0 || pPosicion < _largo){
			for (int x = 0; x<pPosicion; x++){
				nodo = nodo.getNext();
			}
			return nodo;
		}
		else{
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see arraypack.IColeccion#Buscar(int)
	 */
	@Override
	public IDato Buscar(int pPosicion){
		Nodo nodo = BuscarNodo(pPosicion);
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
