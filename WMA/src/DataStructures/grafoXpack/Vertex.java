package DataStructures.grafoXpack;

import DataStructures.linkedlistpack.List;



public class Vertex<T extends Comparable<T>> implements Comparable<T>
{
	String _ID;

	List< Vertex<T> > _ListCon;
	List<Integer> _PesoAdy;
	List< Vertex<T> > _ListAdy;
	
	T _Dato;
	
	Vertex(T pDato, String pID)
	{
		this._Dato = pDato;
		this._PesoAdy = new List<Integer>();
		this._ListCon = new List<Vertex<T>>();
		this._ID = pID;
	}
	
	void addNext(Vertex<T> pVertex)
	{
		this._ListCon.add(pVertex);
	}
	
	void removeNext(Vertex<T> pVertex)
	{
		this._ListCon.remove(pVertex);
	}
	
	void updateWeigth()
	{
		updateWeigth(1000);
	}
	
	void updateWeigth(int pPeso)
	{
		this._PesoAdy.add(pPeso);
	}
	
	String getID()
	{
		return this._ID;
	}
	
	void print()
	{
		System.out.println("____________________________________________");
		System.out.println("ID: " + this._ID + '\t' + " Dato: " + this.toString());
		System.out.println("............................................");
	}
	
	public T getDato()
	{
		return this._Dato;
	}
	
	public String toString()
	{
		if(this._Dato == null)
			return "Dato del Vertice: null ";
		else
			return "Dato del Vertice: " + this.getDato().toString();
	}

	@Override
	public int compareTo(T o)
	{
		int index = -1;
		if(this.equals(o))
			index = 0;
		else if(this.getDato().compareTo(o) > 0)
			index = 1;
		return index;
	}
}