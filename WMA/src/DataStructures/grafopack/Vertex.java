package DataStructures.grafopack;


import DataStructures.linkedlistpack.List;

public class Vertex <T extends Comparable<T> > implements Comparable<T>
{
	String _ID;

	/**
	 * 
	 */
	List< Vertex<T> > _ListaEntradas;


	/**
	 * 
	 */
	List< Edge<T> > _ListaAristas;


	/**
	 * 
	 */
	List< Vertex<T> > _ListaSalidas;

	T _Dato;

	Vertex(T pDato, String pEtiqueta)
	{
		//Asignacion del Dato
		this._Dato = pDato;

		//Creacion de lista de direcciones
		this._ListaEntradas = new List<Vertex<T>>();
		this._ListaSalidas = new List<Vertex<T>>();
		this._ListaAristas = new List< Edge<T> >();
		
		//Etiqueta en el arbol
		this._ID = pEtiqueta;
	}
	
	public String getID()
	{
		return this._ID;
	}

	public T getDato()
	{
		return this._Dato;
	}

	public void conectEdge(Edge<T> pEdge)
	{
		this._ListaAristas.add(pEdge);
	}

	public void conectInput(Vertex<T> pVertex)
	{
		this._ListaEntradas.add(pVertex);
	}

	public void conectOutput(Vertex<T> pVertex)
	{
		this._ListaSalidas.add(pVertex);
	}

	public void disconectInput( Vertex<T> pVertex )
	{
		this._ListaEntradas.remove( pVertex );
	}

	public void disconectOutput( Vertex<T> pVertex )
	{
		this._ListaSalidas.remove( pVertex );
	}

	public void disconectEdge( Edge<T> pEdge )
	{
		this._ListaAristas.remove(pEdge);
	}

	@Override
	public String toString()
	{
		return this._Dato.toString();
	}

	public void print()
	{
		System.out.println(this._ID + " contiene el dato: \t" + this._Dato + "\n");
	}

	public List<Vertex<T>> getInputs()
	{
		return this._ListaEntradas;
	}

	public List<Vertex<T>> getOutputs()
	{
		return this._ListaSalidas;
	}

	public List<Edge<T>> getEdges()
	{
		return this._ListaAristas;
	}

	public void printConexiones()
	{	
		System.out.println("____________________________________________");
		System.out.println("ID: " + this._ID + '\t' + " Dato: " + this._Dato.toString());
		System.out.println("............................................");
		System.out.print("Lista Conexiones Entrantes: ");
		this._ListaEntradas.print();
		System.out.print("Lista Conexiones Salientes: ");
		this._ListaSalidas.print();
		System.out.println("............................................" + "\n");
	}

	@Override
	public int compareTo(T o)
	{
		return this._Dato.compareTo(o);			
	}
}