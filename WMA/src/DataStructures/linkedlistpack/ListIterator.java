package DataStructures.linkedlistpack;

import java.util.Iterator;

public class ListIterator<E> implements Iterator<E>
{
	List<E> _Lista;
	ListNode<E> _Current;
	
	public ListIterator( List<E> pLista) 
	{
		this._Lista = pLista;
		this._Current = new ListNode<E>(null);
		this._Current.setNext(pLista.getHead());
	}
	
	@Override
	public boolean hasNext()
	{
		return this._Current.getNext() != null;
	}

	@Override
	public E next()
	{
		this._Current = this._Current.getNext();
		return this._Current.getData();
	}

	@Override
	public void remove()
	{
		this._Lista.remove(this._Current.getData());
	}
	
}