package DataStructures.grafopack;

public class Edge <T> implements Serializable
{
	// Tipo de Objeto 
	final static String TYPE = "EDGE@";

	// Cantidad de Vertices
	static int _CantEdge = 0;
	
	// Identificador del Objeto
	int _Serial;
	String _ID;
	
	Vertex<T> _Salida;
	Vertex<T> _Entrada;
	int _Peso;
	
	public Edge()
	{
		this( (int) (Math.random() * 500) );
	}
	
	public Edge(int pPeso)
	{
		this._Peso = pPeso;
		this._Serial = Edge._CantEdge;
		this._ID = String.format(Edge.TYPE + "%03d", this._Serial);
		System.out.println(this._ID);
		Edge._CantEdge ++;
	}
	
	public void conect( Vertex<T> pSaliente, Vertex<T> pEntrante )
	{
		//Referencias del Arista
		this._Salida = pSaliente;
		this._Entrada = pEntrante;
		//Conexion de los Nodos
		System.out.println("\n Referenciando...");
		
		this._Salida.conectInput(this._Entrada);
		this._Entrada.conectOutput(this._Salida);
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
	
	public Vertex<T> getOutput()
	{
		return this._Salida;
	}
	
	public Vertex<T> getInput()
	{
		return this._Entrada;
	}
	
	public int getWeigth()
	{
		return this._Peso;
	}
	
	public void disconect()
	{
		//Remover Referencias
		this._Salida.disconectInput(this._Entrada);
		this._Entrada.disconectOutput(this._Salida);
		
		// Remover Aristas
		this._Salida.disconectEdge(this);
		this._Entrada.disconectEdge(this);
	}
}