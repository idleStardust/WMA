package DataStructures.linkedlistpack;


/*
 * -------------------------------Public Operations----------------------------
 * 	----> addQuark( )
 *  ----> removeQuark ( )
 *  ----> search ( )
 *  ----> set ( )
 * ------------------------------Private Operations----------------------------
 */
public class Matrix < T >  extends List< List<T> >
{
	int _NumColumnas;

	public Matrix()
	{
		this(0);
	}

	public Matrix(int pCant)
	{
		for(int x = 0; x < pCant; x++)
		this.addQuark();
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

	@SuppressWarnings("unused")
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
	@SuppressWarnings("unused")
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
		System.out.println(this.search(pFila).search(pColumna));
		this.searchVertex();
	}
}