package DataStructures.grafopack;


import DataStructures.linkedlistpack.List;

public class Vertex <T> implements Serializable
{
	final static String TYPE = "VERTEX@";
	
	static int _VertexCant = 0;
	
	int _Serial;
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
	
	Vertex(T pDato)
	{
		this._ListaEntradas = new List<Vertex<T>>();
		this._ListaSalidas = new List<Vertex<T>>();
		this._Serial = Vertex._VertexCant;
		this._ID = String.format(Vertex.TYPE + "%03d", this._Serial);
		System.out.println(this._ID);
		this._Dato = pDato;
		Vertex._VertexCant ++;
	}
	
	@Override
	public String getID()
	{
		return this._ID;
	}

	@Override
	public int getSerial()
	{
		return this._Serial;
	}
	
	@Override
	public String getType()
	{
		return Vertex.TYPE;
	}
	
	public T getDato()
	{
		return this._Dato;
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
		System.out.println(this._ID + " contiene el dato: " + this._Dato);
	}
	
	public List<Vertex<T>> getInputs()
	{
		return this._ListaEntradas;
	}
	
	public List<Vertex<T>> getOutputs()
	{
		return this._ListaSalidas;
	}
}