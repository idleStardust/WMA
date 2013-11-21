package DataStructures.linkedlistpack;

class ListNode < T >
{
	T _Data;
	
	ListNode < T > _NextNode; 
	ListNode < T > _PrevNode;
	
	ListNode( T pDato)
	{
		this._Data = pDato;
	}
	
	void setData(T pDato)
	{
		this._Data = pDato; 
	}
	
	void setNext(ListNode<T> pNodo) 
	{ 
		this._NextNode = pNodo; 
	}
	
	void setPrev(ListNode<T> pNodo) 
	{ 
		this._PrevNode = pNodo; 
	}
	
	T getData() 
	{ 
		return this._Data; 
	}
	
	ListNode< T > getNext()
	{ 
		return this._NextNode; 
	}
	
	ListNode< T > getPrev()
	{
		return this._PrevNode;
	}
}