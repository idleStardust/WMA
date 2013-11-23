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
			this.fillRow(null, this.size());
			this.fillColumn(null, this.size()-1);
		}
	}
	
	public static void main(String[] args)
	{
		Matriz<Integer> m = new Matriz<Integer>();
		m.addRow();
		m.search(0).add(null);
		m.print();
	}
	public void fillColumn(T pDato, int pIndex)
	{
		ListIterator<List<T>> list = this.iterator();
		for(int x =0; x < pIndex-1; x++)
			list.next().add(pDato);
	}
	public void fillRow(T pDato, int pIndex )
	{
		List<T> list = this.search(pIndex);
		for(int x =0; x < pIndex-1; x++)
			list.add(pDato);
	}
	/**
	 * Eliminar un indice y una columna a la vez.
	 * @param pIndex
	 */
	public void removeQuark(int pIndex)
	{
		this.remove(pIndex);
	}

	protected void addRow()
	{
		this.add(new List<T>());
	}

	/**
	 * Remover una columna
	 * @param pIndex
	 */
	public void removerColumn(int pIndex)
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
	public void addColumn(T pDato, int pIndex)
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
		System.out.print(iterator.hasNext());
		while( iterator.hasNext() )
		{
			result += iterator.next().toString() + "\n ";
		}
		result += "\n]";
		return result;
	}

	public void addToAllRaw(T pDato)
	{
		ListIterator<List<T>> iterator = this.iterator();
		while( iterator.hasNext() )
			iterator.next().add(pDato);
	}

	public void set( T pDato, int pFila, int pColumna )
	{
		this.search(pFila).set(pDato, pColumna);
	}
}