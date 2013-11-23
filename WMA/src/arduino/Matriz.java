package arduino;

import DataStructures.linkedlistpack.List;
import DataStructures.linkedlistpack.ListIterator;

/*
 * -------------------------------Public Operations----------------------------
 * 	----> addQuark( )
 *  ----> removeQuark ( )
 *  ----> search ( )
 *  ----> set ( )
 * ------------------------------Private Operations----------------------------
 */
public class Matriz < T >  extends List< List<T> >
{
	int _NumColumnas;

	public Matriz()
	{
		this(0);
	}

	public Matriz(int pCant)
	{
	}

	public void addQuark()
	{
		this.add(new List<T>());
		if(this.size() == 1)
		{
			this.search(0).add(null);
		}
		else
		{
			this.fillRow(null);
			this.fillColumn(null);
		}
	}
	
	public void removeQuark(int pIndice)
	{
		this.remove(pIndice);
		this.removerColumn(pIndice);
	}
	
	private void fillColumn(T pDato)
	{
		ListIterator<List<T>> list = this.iterator();
		for(int x =0; x < this.size()-1; x++)
			list.next().add(pDato);
	}
	private void fillRow(T pDato)
	{
		List<T> list = this.search(this.size()-1);
		for(int x =0; x < this.size(); x++)
			list.add(pDato);
	}

	private void addRow()
	{
		this.add(new List<T>());
	}

	/**
	 * Remover una columna
	 * @param pIndex
	 */
	private void removerColumn(int pIndex)
	{
		ListIterator<List<T>> iterator = this.iterator();
		while( iterator.hasNext() )
		{
			iterator.next().remove(pIndex);
		}
	}

	/**
	 * Anadir una columna de datos
	 * @param pDato
	 * @param pIndex
	 */
	private void addColumn(T pDato, int pIndex)
	{
		ListIterator<List<T>> iterator = this.iterator();
		while( iterator.hasNext() )
		{
			iterator.next().add(pDato, pIndex);;
		}
	}
	public T search(int pFila, int pColumna)
	{
		return this.search(pFila).search(pColumna);
	}

	public void print()
	{
		System.out.println(this.toString());
	}

	public String toString()
	{
		String result = "[ \n ";
		ListIterator<List<T>> iterator = this.iterator();
		while( iterator.hasNext() )
		{
			result += iterator.next().toString() + "\n ";
		}
		result += "\n]";
		return result;
	}

	public void set( T pDato, int pFila, int pColumna )
	{
		this.search(pFila).set(pDato, pColumna);
	}
}