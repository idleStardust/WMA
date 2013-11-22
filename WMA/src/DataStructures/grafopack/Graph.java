package DataStructures.grafopack;

import DataStructures.exceptions.ItemNotFoundException;
import DataStructures.linkedlistpack.LinkedListIterator;
import DataStructures.linkedlistpack.List;

public class Graph <T extends Comparable<T> >
{
	List< Vertex<T> > _ListVertices;
	List< Edge <T> > _ListAristas;
	
	/**
	 * 
	 */
	public Graph()
	{
		//---------------Inicializacion de listas bases de datos----------------------\\
		this._ListVertices = new List<Vertex<T>>() ;
		this._ListAristas = new List<Edge<T>>() ;
	}
	
	/**
	 * Añade a la estructura un nuevo dato, sin ninguna conexión.
	 * @param pDato T
	 * @param pEtiqueta {@link String}
	 * @see Vertex
	 * @caution El metodo posiblememente necesitara una etiqueta para la arista.
	 */
	public void add( T pDato, String pEtiqueta )
	{
		this._ListVertices.add( new Vertex<T>(pDato, pEtiqueta) );
	}
	
	/**
	 * Conecta a dos vertices del grafo a través de dos etiquetas correspondientes
	 * a los vértices.
	 * @param pVerticeSaliente {@link String}
	 * @param pVerticeEntrante {@link String}
	 * @throws ItemNotFoundException
	 */
	public void conect(String pVerticeSaliente, String pVerticeEntrante)
	{
		/*------------------------------Preparacion por la adicion--------------------------*/
		Edge<T> tmpedge = new Edge<T>();
		
		
		//	Busqueda de los vertices correspondientes
		Vertex<T> tmpvertexsaliente = this.searchVertexID(pVerticeSaliente);
		Vertex<T> tmpvertexentrante = this.searchVertexID(pVerticeEntrante);
		
		//	Impresion de la conexion
		//this.printEdgeConection(tmpvertexsaliente, tmpvertexentrante);
		
		/*----------------------------Asignacion de Referencias-------------------------------*/
		tmpedge.conect(tmpvertexsaliente, tmpvertexentrante);
		tmpvertexentrante.conectEdge(tmpedge);
		tmpvertexsaliente.conectEdge(tmpedge);
		
		//	Adición a la base de datos interna.
		this._ListAristas.add( tmpedge );
	}
	
	public void conect(T pVerticeSaliente, T pVerticeEntrante)
	{
		/*------------------------------Preparacion por la adicion--------------------------*/
		Edge<T> tmpedge = new Edge<T>();
		
		
		//	Busqueda de los vertices correspondientes
		Vertex<T> tmpvertexsaliente = this.searchVertex(pVerticeSaliente);
		Vertex<T> tmpvertexentrante = this.searchVertex(pVerticeEntrante);
		
		//	Impresion de la conexion
		//this.printEdgeConection(tmpvertexsaliente, tmpvertexentrante);
		
		/*----------------------------Asignacion de Referencias-------------------------------*/
		tmpedge.conect(tmpvertexsaliente, tmpvertexentrante);
		tmpvertexentrante.conectEdge(tmpedge);
		tmpvertexsaliente.conectEdge(tmpedge);
		
		//	Adición a la base de datos interna.
		this._ListAristas.add( tmpedge );
	}
	/**
	 * 
	 * @param pNodoSaliente {@link Vertex}
	 * @param pNodoEntrante {@link Vertex}
	 */
	protected void printEdgeConection(Vertex<T> pNodoSaliente, Vertex<T> pNodoEntrante)
	{
		System.out.println("-----------------------Conectando Nodos-------------------");
		System.out.println("Nodo Saliente: " + pNodoSaliente.getID() + '\t'  +  "Nodo Entrante: " + pNodoEntrante.getID() );
		System.out.println("Nodo Saliente: " + pNodoSaliente + 		   '\t'  +  "Nodo Entrante: " + pNodoEntrante );
		System.out.println("...........................................................");
	}
	
	/**
	 * Elimina por medio de una etiqueta un vertice del grafo.
	 * @param pEtiqueta {@link String}
	 * @throws ItemNotFoundException
	 */
	public void remove(String pEtiqueta)
	{
		//	Busqueda del vertice removido
		Vertex<T> removed = this.searchVertexID(pEtiqueta);
		List<Edge<T>> removeedges = removed.getEdges();
		if(removeedges != null)
		{
			/*-------------------------------Preparacion de Iteradores---------------------*/
			//	Tipo: Vertex<T>
			LinkedListIterator< Edge<T> > iterator = removed.getEdges().iterator();
			while(iterator.hasNext())
			{
				Edge<T> tmp = iterator.next();
				this.removeEdge( tmp );
			}
		}
		//	Removicion de la base de datos interna
		this._ListVertices.remove(removed);
	}
	
	/**
	 * Elimina una arista por medio de una etiqueta dada.
	 * @param pEdge {@link String}
	 * @throws ItemNotFoundException
	 * @version 1.3 (Vie 2:41 AM)
	 */
	public void disconnect(String pEdge)
	{
		//Busqueda y eliminacion de una arista.
		this.removeEdge(this.searchEdgeID(pEdge));
	}
	
	/**
	 * Elimina una arista del grafo y desconecta la referencias 
	 * entre vertices.
	 * @param pEdge {@link Edge}
	 * @version 1.2 (Vie 2.41 AM)
	 */
	private void removeEdge(Edge<T> pEdge)
	{
		//	Desconexion de la Arista de los Vertices
		pEdge.disconect();
		//	Removicion de la Arista del Grafo
		this._ListAristas.remove(pEdge);
	}
	
	/**
	 * Busca y retorna una arista con la etiqueta igual a la brindada.
	 * @param pEtiqueta {@link String}
	 * @return Edge T
	 * @version 1.2 (Vie 1:36 AM)
	 * @throws ItemNotFoundException
	 */
	private Edge<T> searchEdgeID(String pEtiqueta)
	{
		/*-------------------------------Preparacion de Iteradores---------------------*/
		//	Tipo: Edge<T>
		LinkedListIterator<Edge<T>> iterator = this._ListAristas.iterator();
		Edge<T> result = null;
		Edge<T> tmp;
		
		//=====================================Busqueda===================================/
		while(iterator.hasNext())
		{
			tmp = iterator.next();
			if(tmp.getID().equalsIgnoreCase(pEtiqueta))
			{
				result = tmp;
				break;
			}
		}
		// Dato no encontrado ====> Excepcion: ItemNotFoundException
		if(result == null)
			throw new ItemNotFoundException(pEtiqueta);
		return result;
	}
	
	
	/**
	 * Busca y retorna un vertice que contenda la misma etiqueta que
	 * la etiqueta brindada.
	 * @param pEtiqueta {@link String}
	 * @throws ItemNotFoundException
	 * @version 1.1 (Vie 1:24 AM)
	 * @return Vertex T
	 */
	private Vertex <T> searchVertexID(String pEtiqueta)
	{
		/*-------------------------------Preparacion de Iteradores---------------------*/
		//	Tipo: Vertex<T>
		LinkedListIterator<Vertex<T>> iterator = this._ListVertices.iterator();
		Vertex <T> result = null;
		Vertex <T> tmp;
		
		//=====================================Busqueda===================================/
		while(iterator.hasNext())
		{
			tmp = iterator.next();
			if(tmp.getID().equalsIgnoreCase(pEtiqueta))
			{
				result = tmp;
				break;
			}
		}
		// Dato no encontrado ====> Excepcion: ItemNotFoundException
		if(result == null)
			throw new ItemNotFoundException(pEtiqueta);
		return result;
	}
	
	/**
	 * Busca y retorna un vertice que contenga un dato indicado.
	 * @param pDato
	 * @return Vertex T
	 * @version 1.1 (Vie 1:32 AM)
	 * @throws ItemNotFoundException
	 */
	private Vertex <T> searchVertex(T pDato)
	{
		/*----------------------------Preparacion de Iteradores---------------------------*/
		LinkedListIterator<Vertex<T>> iterator = this._ListVertices.iterator();
		Vertex <T> result = null;
		Vertex <T> tmp;
		//=====================================Busqueda===================================/
		while(iterator.hasNext())
		{
			tmp = iterator.next();
			if( tmp.compareTo(pDato) == 0)
			{
				result = tmp;
				break;
			}
		}
		// Dato no encontrado ====> Excepcion: ItemNotFoundException
		if(result==null)
			throw new ItemNotFoundException(pDato.toString());
		return result;
	}
	
	public static void main(String[] args)
	{
		Graph<Integer> grafo = new Graph<Integer>();
		grafo.add( 52, "Nodin" );
		grafo.add( 23, "Nodae" );
		grafo.add( 50, "Nodaa" );
		
		grafo.conect("Nodin", "Nodae");
		grafo.conect("Nodaa", "Nodae");
		grafo.conect("Nodae", "Nodaa");
		grafo.printVertex();
		
		Graph<Integer> grafe = new Graph<Integer>();
		grafe.add( 52, "Nodin" );
		grafe.add( 23, "Nodae" );
		grafe.add( 50, "Nodaa" );
		
		grafe.conect(52, 23);
		grafe.conect(50, 23);
		grafe.conect(23, 50);
		grafe.printVertex();
	}
	
	/**
	 * Imprime las conexiones que cada vertices presenta. Sus listas de entradas y de salidas.
	 */
	protected void printVertex()
	{
		LinkedListIterator< Vertex<T> > iterator = this._ListVertices.iterator();
		while(iterator.hasNext())
		{
			iterator.next().printConexiones();
		}
	}
}
