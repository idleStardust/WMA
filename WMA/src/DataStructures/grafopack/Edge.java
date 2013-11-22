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
		Edge._CantEdge ++;
	}
	
	public void conect( Vertex<T> pSaliente, Vertex<T> pEntrante )
	{
		//Referencias del Arista
		this._Salida = pSaliente;
		this._Entrada = pEntrante;
		//Conexion de los Nodos
		this._Salida.conectOutput(this._Entrada);
		this._Entrada.conectInput(this._Salida);
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
	
	void print()
	{
		System.out.println("ID: " + this._ID );
		System.out.println("...................................................................");
		System.out.println("Vertice Saliente: "  + this._Salida.getID() + "\t Vertice Entrante: " + this._Entrada.getID());
		System.out.println("Vertice Saliente: " + this._Salida.getDato() +  " \t \t Vertice Entrante: " + this._Entrada.getDato());
		System.out.println();
	}
}