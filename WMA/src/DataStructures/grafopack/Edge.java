package DataStructures.grafopack;

import DataStructures.linkedlistpack.List;

public class Edge <T> implements Serializable
{
	// Tipo de Objeto 
	final static String TYPE = "Edge";

	// Cantidad de Vertices
	static int _CantEdge = 0;
	
	// Identificador del Objeto
	int _Serial;
	String _ID;
	
	Vertex<T> _Salida;
	Vertex<T> _Entrada;
	int _Peso;
	
	Edge()
	{
		this._Peso = (int) (Math.random() * 500);
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
	
	Vertex<T> getSalida()
	{
		return this._Salida;
	}
	
	Vertex<T> getEntrada()
	{
		return this._Entrada;
	}
	
	int getPeso()
	{
		return this._Peso;
	}
}