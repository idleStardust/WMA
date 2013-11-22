package DataStructures.grafopack;


import DataStructures.exceptions.ItemNotFoundException;
import DataStructures.linkedlistpack.ListIterator;
import DataStructures.linkedlistpack.List;

public class Graph <T extends Comparable<T> >
{
	List< Vertex<T> > _ListVertices;
	List< Edge <T> > _ListAristas;
	
	/**
	 * Construye una estructura de datos de tipo 
	 * <b>grafo</b> que contendra una coleccion de nodos y aristas
	 */
	public Graph()
	{
		//---------------Inicializacion de listas bases de datos----------------------\\
		this._ListVertices = new List<Vertex<T>>() ;
		this._ListAristas = new List<Edge<T>>() ;
	}
	
	/**
	 * Añade a la estructura un nuevo dato, sin ninguna conexión establecida.
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
	public void conect( String pVerticeSaliente, String pVerticeEntrante )
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
	
	public void conect( T pVerticeSaliente, T pVerticeEntrante )
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
	public void printEdgeConection(Vertex<T> pNodoSaliente, Vertex<T> pNodoEntrante)
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
			ListIterator< Edge<T> > iterator = removed.getEdges().iterator();
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
	 * Elimina por medio de un dato un vertice del grafo.
	 * @param pDato {@link String}
	 * @throws ItemNotFoundException
	 */
	public void remove(T pDato)
	{
		//	Busqueda del vertice removido
		Vertex<T> removed = this.searchVertex(pDato);
		List<Edge<T>> removeedges = removed.getEdges();
		if(removeedges != null)
		{
			/*-------------------------------Preparacion de Iteradores---------------------*/
			//	Tipo: Vertex<T>
			ListIterator< Edge<T> > iterator = removed.getEdges().iterator();
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
	 * Elimina una arista por medio de dos etiqueta dadas.
	 * @param pEdge {@link String}
	 * @throws ItemNotFoundException
	 * @version 1.4 (Vie 2:41 AM)
	 */
	public void disconnect(String pEtiqueta, String pOtraEtiqueta)
	{
		Vertex<T> vertex1 = this.searchVertexID(pEtiqueta);
		Vertex<T> vertex2 = this.searchVertexID(pOtraEtiqueta);
		Edge<T> edge = this.searchEdge(vertex1, vertex2);
		edge.disconect();
	}
	
	
	/**
	 * Elimina una arista por medio de dos datos dados.
	 * @param pEdge {@link String}
	 * @throws ItemNotFoundException
	 * @version 1.4 (Vie 2:41 AM)
	 */
	public void disconnect(T pDato, T pOtroDato)
	{
		Vertex<T> vertex1 = this.searchVertex(pDato);
		Vertex<T> vertex2 = this.searchVertex(pOtroDato);
		Edge<T> edge = this.searchEdge(vertex1, vertex2);
		edge.disconect();
	}
	
	
	protected Edge<T> searchEdge(Vertex<T> pVertexSaliente, Vertex<T> pVertexEntrante)
	{
		ListIterator<Edge<T>> iteratorOut = pVertexSaliente.getEdges().iterator();
		ListIterator<Edge<T>> iteratorIn = pVertexEntrante.getEdges().iterator();
		while(iteratorOut.hasNext())
		{
			Edge<T> tmpOut = iteratorOut.next();
			while(iteratorIn.hasNext())
			{
				Edge<T> tmpIn = iteratorIn.next();
				if(tmpOut.equals(tmpIn))
					return tmpIn;
			}
		}
		throw new ItemNotFoundException("Arista Buscada");
		
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
	@SuppressWarnings("unused")
	private Edge<T> searchEdgeID(String pEtiqueta)
	{
		/*-------------------------------Preparacion de Iteradores---------------------*/
		//	Tipo: Edge<T>
		ListIterator<Edge<T>> iterator = this._ListAristas.iterator();
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
	protected Vertex <T> searchVertexID(String pEtiqueta)
	{
		/*-------------------------------Preparacion de Iteradores---------------------*/
		//	Tipo: Vertex<T>
		ListIterator<Vertex<T>> iterator = this._ListVertices.iterator();
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
	protected Vertex <T> searchVertex(T pDato)
	{
		/*----------------------------Preparacion de Iteradores---------------------------*/
		ListIterator<Vertex<T>> iterator = this._ListVertices.iterator();
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
	
	/**
	 * Imprime las conexiones que cada vertices presenta. Sus listas de entradas y de salidas.
	 */
	public void printVertex()
	{
		ListIterator< Vertex<T> > iterator = this._ListVertices.iterator();
		while(iterator.hasNext())
		{
			iterator.next().printConexiones();
		}
	}
	
	public GraphIterator<T> iterator(String pVertex)
	{
		return new GraphIterator<T>(this, pVertex);
	}
	
	public GraphIterator<T> iterator(T pVertex)
	{
		return new GraphIterator<T>(this, pVertex);
	}
	
	public T search(String pEtiqueta)
	{
		return this.searchVertexID(pEtiqueta).getDato();
	}
	
	public String search(T pDato)
	{
		return this.searchVertex(pDato).getID();
	}
	
	public void runDijkstra(T pVerticeInicial)
	{
		
	}
	
	public void runFloyd()
	{
		
	}
}
