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
		
		System.out.println("-----------------------Conectando Nodos-------------------");
		
		Vertex<T> tmpvertexsaliente = this.searchVertex(pVerticeSaliente);
		Vertex<T> tmpvertexentrante = this.searchVertex(pVerticeEntrante);
		
		//Impresion de la conexion
		System.out.println("Nodo Saliente: " + tmpvertexsaliente.getID() + '\t' + "Nodo Entrante: " + tmpvertexentrante.getID() );
		System.out.println("Nodo Saliente: " + tmpvertexsaliente + "\t \t" + "Nodo Entrante: " + tmpvertexentrante );
		System.out.println("..........................................................." + "\n");
		
		//Asignacion de la arista.
		tmpedge.conect(tmpvertexsaliente, tmpvertexentrante);
		tmpvertexentrante.conectEdge(tmpedge);
		tmpvertexsaliente.conectEdge(tmpedge);
	}
	
	public void removeVertex(String pVertex)
	{
		Vertex<T> removed = this.searchVertex(pVertex);
		List<Edge<T>> removeedges = removed.getEdges();
		if(removeedges != null)
		{
			LinkedListIterator< Edge<T> > iterator = removed.getEdges().iterator();
			while(iterator.hasNext())
			{
				Edge<T> tmp = iterator.next();
				this.removeEdge( tmp );
			}
		}
		this._ListVertices.remove(removed);
	}
	
	public void removeEdge(String pEdge)
	{
		this.removeEdge(this.searchEdge(pEdge));
	}
	
	private void removeEdge(Edge<T> pEdge)
	{
		pEdge.disconect();
		this._ListAristas.remove(pEdge);
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
		grafo.addVertex( 50 );
		
		grafo.addEdge("VERTEX@000", "VERTEX@001");
		grafo.addEdge("VERTEX@002", "VERTEX@001");
		grafo.addEdge("VERTEX@001", "VERTEX@002");
		grafo.addEdge("VERTEX@002", "VERTEX@000");
		grafo.printVertex();
		
		System.out.print("After....." + "\n");
		grafo.removeVertex("VERTEX@002");
		grafo.printVertex();
	}
	
	public void printVertex()
	{
		LinkedListIterator< Vertex<T> > iterator = this._ListVertices.iterator();
		while(iterator.hasNext())
		{
			iterator.next().printConexiones();
		}
	}
}
