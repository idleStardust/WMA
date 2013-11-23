package DataStructures.grafopack;


import DataStructures.exceptions.ItemNotFoundException;
import DataStructures.linkedlistpack.ListIterator;
import DataStructures.linkedlistpack.List;
import DataStructures.linkedlistpack.Matrix;

public class Graph <T extends Comparable<T> >
{
	List< Vertex<T> > _ListVertices;
	List< Edge <T> > _ListAristas;
	Matrix<Edge<T>> _Matrix;
	/**
	 * Construye una estructura de datos de tipo 
	 * <b>grafo</b> que contendra una coleccion de nodos y aristas
	 */
	public Graph()
	{
		//---------------Inicializacion de listas bases de datos----------------------\\
		this._ListVertices = new List<Vertex<T>>() ;
		this._ListAristas = new List<Edge<T>>() ;
		this._Matrix = new Matrix<Edge<T>>();
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
		this._Matrix.addQuark(new Edge<T>(1000), new Edge<T>(0));
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
		this.printEdgeConection(tmpvertexsaliente, tmpvertexentrante);
		//	Impresion de la conexion
		//this.printEdgeConection(tmpvertexsaliente, tmpvertexentrante);

		/*----------------------------Asignacion de Referencias-------------------------------*/
		tmpedge.conect(tmpvertexsaliente, tmpvertexentrante);

		//	Adición a la base de datos interna.
		this._Matrix.set(tmpedge, 
				this._ListVertices.search(tmpvertexsaliente), 
				this._ListVertices.search(tmpvertexentrante));
		this._ListAristas.add( tmpedge );
	}
	
	public void conect( T pVerticeSaliente, T pVerticeEntrante )
	{
		/*------------------------------Preparacion por la adicion--------------------------*/
		Edge<T> tmpedge = new Edge<T>();


		//	Busqueda de los vertices correspondientes
		Vertex<T> tmpvertexsaliente = this.searchVertex(pVerticeSaliente);
		Vertex<T> tmpvertexentrante = this.searchVertex(pVerticeEntrante);
		this.printEdgeConection(tmpvertexsaliente, tmpvertexentrante);
		//	Impresion de la conexion
		//this.printEdgeConection(tmpvertexsaliente, tmpvertexentrante);

		/*----------------------------Asignacion de Referencias-------------------------------*/
		tmpedge.conect(tmpvertexsaliente, tmpvertexentrante);

		//	Adición a la base de datos interna.
		this._Matrix.set(tmpedge, 
				this._ListVertices.search(tmpvertexsaliente), 
				this._ListVertices.search(tmpvertexentrante));
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
		this._Matrix.removeQuark(this._ListVertices.search(removed));
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
		this._Matrix.removeQuark(this._ListVertices.search(removed));
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
		Vertex<T> vertex2 = this.searchVertexID(pEtiqueta);
		Vertex<T> vertex1 = this.searchVertexID(pOtraEtiqueta);
		Edge<T> edge = this.searchEdge(vertex2, vertex1);
		this._Matrix.set(new Edge<T>(1000), 
				this._ListVertices.search(vertex2), 
				this._ListVertices.search(vertex1));
		edge.disconect();
		this._ListAristas.remove(edge);
	}


	/**
	 * Elimina una arista por medio de dos datos dados.
	 * @param pEdge {@link String}
	 * @throws ItemNotFoundException
	 * @version 1.4 (Vie 2:41 AM)
	 */
	public void disconnect(T pDato, T pOtroDato)
	{
		Vertex<T> vertexsaliente = this.searchVertex(pDato);
		Vertex<T> vertexentrante = this.searchVertex(pOtroDato);
		Edge<T> edge = this.searchEdge(vertexsaliente, vertexentrante);
		this._Matrix.set(new Edge<T>(1000), 
				this._ListVertices.search(vertexsaliente), 
				this._ListVertices.search(vertexentrante));
		edge.disconect();
		this._ListAristas.remove(edge);
	}


	protected Edge<T> searchEdge(Vertex<T> pVertexSaliente, Vertex<T> pVertexEntrante)
	{
		ListIterator<Edge<T>> iteratorOut = pVertexSaliente.getEdges().iterator();
		ListIterator<Edge<T>> iteratorIn = pVertexEntrante.getEdges().iterator();
		while(iteratorIn.hasNext())
		{
			Edge<T> tmpIn = iteratorIn.next();
			while(iteratorOut.hasNext())
			{
				Edge<T> tmpOut = iteratorOut.next();
				if(tmpIn.equals(tmpOut))
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
		int[][] ans = this.toArray();
		int n = ans.length;

		for (int k=0; k< n;k++) 
		{
			for (int i=0; i<n; i++) {
				for (int j=0; j<n;j++) 
				{        
					if (ans[i][k]+ans[k][j] < ans[i][j]) 
					{
						ans[i][j] = ans[i][k]+ans[k][j];
						
					}
				}
			}
		}
	}

	public ListIterator<T>  iterator( )
	{

		return null;
	}

	 public void printMatriz()
	 {
		 this._Matrix.print();
	 }

	 public int[][] toArray()
	 {
		 int [][] tmp = new int [this._Matrix.size()][this._Matrix.size()];
		 ListIterator<List<Edge<T>>> piv = this._Matrix.iterator();
		 for(int x = 0; x < tmp.length; x++)
		 {
			 ListIterator< Edge<T> > pivdata = piv.next().iterator();
			 for(int i = 0; i < tmp[x].length; i++)
			 {
				 tmp[x][i] = pivdata.next().getWeigth();
			 }
		 }

		 return tmp;

	 }

	 public String arraytoString(int[][] pArreglo)
	 {
		 String result = "[ ";
		 for(int x = 0; x < pArreglo.length; x++)
		 {
			 result += "\n[" + "\t";
			 int[] tmparray = pArreglo[x];
			 for(int i = 0; i < tmparray.length; i++)
			 {
				 result += tmparray[i] + ", ";
			 }
			 result += " ]";
		 }
		 result += " ]";
		 return result;
	 }
	 public static void main(String[] args)
	 {
		 Graph<Integer> g = new Graph<Integer>();
		 g.add(1, "nodin");		 
		 g.add(2, "juan");
		 g.add(3, "nodae");
		 g.add(4, "nad");

		 
		 g.conect(2, 4, 1);
		 g.conect(4, 2, 1);
		 
		 g.conect(3, 4, 2);
		 g.conect(4, 3, 2);
		 g.conect(3, 2, 1);
		 
		 g.conect(1, 2, 4);
		 g.conect(2, 1, 4);
		 g.conect(1, 3, 2);
		 g.conect(3, 1, 2);
		 
		 g.conect(1, 4, 5);
		 g.conect(4, 1, 5);
		 g.printMatriz();
		 g.runFloyd();
		 g.printMatriz();
	 }
	 
	 public void conect( T pVerticeSaliente, T pVerticeEntrante, int pPeso )
		{
			/*------------------------------Preparacion por la adicion--------------------------*/
			Edge<T> tmpedge = new Edge<T>(pPeso);


			//	Busqueda de los vertices correspondientes
			Vertex<T> tmpvertexsaliente = this.searchVertex(pVerticeSaliente);
			Vertex<T> tmpvertexentrante = this.searchVertex(pVerticeEntrante);
			
			this.printEdgeConection(tmpvertexsaliente, tmpvertexentrante);
			//	Impresion de la conexion
			//this.printEdgeConection(tmpvertexsaliente, tmpvertexentrante);

			/*----------------------------Asignacion de Referencias-------------------------------*/
			tmpedge.conect(tmpvertexsaliente, tmpvertexentrante);

			//	Adición a la base de datos interna.
			this._Matrix.set(tmpedge, 
					this._ListVertices.search(tmpvertexsaliente), 
					this._ListVertices.search(tmpvertexentrante));
			this._ListAristas.add( tmpedge );
		}
}