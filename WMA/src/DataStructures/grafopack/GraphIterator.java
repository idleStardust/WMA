package DataStructures.grafopack;

import java.util.Iterator;

public class GraphIterator<E extends Comparable < E > > implements Iterator<E>
{
	Vertex< E > _Current;
	Graph < E > _Graph;
	
	
	public GraphIterator(Graph<E> pGraph, E pVertex)
	{
		this._Graph = pGraph;
		this._Current = pGraph.searchVertex(pVertex);
	}
	
	
	public GraphIterator(Graph<E> pGraph, String pVertex)
	{
		this._Graph = pGraph;
		this._Current = pGraph.searchVertexID(pVertex);
	}
	
	
	@Override
	public boolean hasNext()
	{
		return this._Current.getOutputs().isEmpty();
	}
	
	
	public boolean hasPrev()
	{
		return this._Current.getInputs().isEmpty();
	}
	
	
	@Override
	public E next()
	{
		// Implementar Algoritmos busqueda
		return null;
	}

	@Override
	public void remove()
	{
		// TODO Auto-generated method stub
		
	}

}
