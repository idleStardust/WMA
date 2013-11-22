package DataStructures.grafopack;

import DataStructures.linkedlistpack.LinkedListIterator;
import DataStructures.linkedlistpack.List;

public class Graph <T>
{
	List< Vertex<T> > _ListVertices;
	List< Edge <T> > _ListAristas;
	
	public Graph()
	{
		this._ListVertices = new List<Vertex<T>>() ;
		this._ListAristas = new List<Edge<T>>() ;
	}
	
	public void addVertex( T pDato )
	{
		this._ListVertices.add( new Vertex<T>(pDato) );
	}
	
	public void addEdge(String pVerticeSaliente, String pVerticeEntrante)
	{
		Edge<T> tmpedge = new Edge<T>();
		this._ListAristas.add( tmpedge );
		
		System.out.println("Conectando Nodos....");
		Vertex<T> tmpvertexentrante = this.searchVertex(pVerticeSaliente);
		Vertex<T> tmpvertexsaliente = this.searchVertex(pVerticeEntrante);
		System.out.println("Nodo Entrante " + tmpvertexentrante + '\t' + "Nodo Saliente " + tmpvertexsaliente  );
		tmpedge.conect(tmpvertexsaliente, tmpvertexentrante);
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
	
	public Edge<T> searchEdge(String pEdge)
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
	
	public Vertex <T> searchVertex(String pVertex)
	{
		LinkedListIterator<Vertex<T>> iterator = this._ListVertices.iterator();
		Vertex <T> result = null;
		Vertex <T> tmp;
		while(iterator.hasNext())
		{
			tmp = iterator.next();
			if(tmp.getID().equalsIgnoreCase(pVertex))
			{
				result = tmp;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		Graph<Integer> grafo = new Graph<Integer>();
		grafo.addVertex( 52 );
		grafo.addVertex( 23 );
		System.out.println("Vacaciones NO WAY");
		grafo.addEdge("VERTEX@000", "VERTEX@001");
		grafo.searchVertex("VERTEX@000").getInputs().print();
		grafo.searchVertex("VERTEX@000").getOutputs().print();
		grafo.searchVertex("VERTEX@001").getInputs().print();
		grafo.searchVertex("VERTEX@001").getOutputs().print();
	}
}
