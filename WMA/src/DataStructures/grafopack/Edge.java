package DataStructures.grafopack;

public class Edge <T extends Comparable<T> > implements Comparable<Edge<T>>
{	
	// Identificador del Objeto
	String _ID;
	String _Type;
	static int Serial = 0;
	
	//Referencias a otros objetos
	Vertex<T> _Salida;
	Vertex<T> _Entrada;
	int _Peso;
	
	public Edge( )
	{
		this( (int) (Math.random() * 500) );
	}
	
	public Edge(int pPeso)
	{
		this._Peso = pPeso;
		this._ID = "Edge@" + Edge.Serial;
		Edge.Serial++;
	}
	
	public void conect( Vertex<T> pSaliente, Vertex<T> pEntrante )
	{
		//Referencias del Arista
		this._Salida = pSaliente;
		this._Entrada = pEntrante;
		//Conexion de los Nodos
		
		this._Salida.conectEdge(this);
		this._Entrada.conectEdge(this);
	}
	
	public String getID()
	{
		return this._ID;
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
		this._Salida.disconectOutput(this._Entrada);
		this._Entrada.disconectInput(this._Salida);
		// Remover Aristas
		this._Salida.disconectEdge(this);
		this._Entrada.disconectEdge(this);
	}
	
	void print()
	{
		System.out.println("ID: " + this._ID );
		System.out.println("...................................................................");
		System.out.println("Peso de la arista: " + this._Peso);
		System.out.println("Vertice Saliente: "  + this._Salida.getID() + "\t Vertice Entrante: " + this._Entrada.getID());
		System.out.println("Vertice Saliente: " + this._Salida.getDato() +  " \t \t Vertice Entrante: " + this._Entrada.getDato());
		System.out.println();
	}


	@Override
	public int compareTo(Edge<T> o)
	{
		int index = -1;
		if(this._Peso == o.getWeigth())
			index = 0;
		else if(this._Peso > o.getWeigth())
			index = 1;
		return index;
	}
	
	public void set(int pPeso, Vertex<T> pVertice)
	{
		this._Salida
	}	
	
	public String toString()
	{
		return "Edge: " + this._Peso;
	}
}