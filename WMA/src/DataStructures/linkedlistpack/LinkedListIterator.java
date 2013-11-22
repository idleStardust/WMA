package DataStructures.linkedlistpack;

import java.util.Iterator;

public class LinkedListIterator<E> implements Iterator<E>
{
	List<E> _Lista;
	ListNode<E> _Current;
	
	public LinkedListIterator( List<E> pLista, ListNode<E> pFirst ) 
	{
		this._Lista = pLista;
		this._Current = new ListNode<E>(null);
		this._Current.setNext(pFirst);
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