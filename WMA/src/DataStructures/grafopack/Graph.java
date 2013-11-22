package DataStructures.grafopack;

import DataStructures.linkedlistpack.LinkedListIterator;
import DataStructures.linkedlistpack.List;

public class Graph <T>
{
	List< Vertex<T> > _ListVertices;
	List< Edge <T> > _ListAristas;
	
	Graph()
	{
		this._ListVertices = new List<Vertex<T>>() ;
		this._ListAristas = new List<Edge<T>>() ;
	}
	
	public void addVertex(String pVertex)
	{
		
	}
	
	public void addEdge(String pEdge)
	{
		
	}
	
	public void removeVertex(String pVertex)
	{
		Vertex<T> removed = this.searchVertex(pVertex);
		this._ListVertices.remove(removed);
	}
	
	public void removeEdge(String pEdge)
	{
		Edge<T> removed = this.searchEdge(pEdge);
		this._ListAristas.remove(removed);
	}
	
	Edge<T> searchEdge(String pEdge)
	{
		LinkedListIterator<Edge<T>> iterator = this._ListAristas.iterator();
		Edge<T> result = null;
		Edge<T> tmp;
		while(iterator.hasNext())
		{
			tmp = iterator.next();
			if(tmp.getID().equalsIgnoreCase(pEdge))
			{
				result = tmp;
				break;
			}
		}
		return result;
	}
	
	Vertex <T> searchVertex(String pEdge)
	{
		LinkedListIterator<Vertex<T>> iterator = this._ListVertices.iterator();
		Vertex <T> result = null;
		Vertex <T> tmp;
		while(iterator.hasNext())
		{
			tmp = iterator.next();
			if(tmp.getID().equalsIgnoreCase(pEdge))
			{
				result = tmp;
				break;
			}
		}
		return result;
	}
}
