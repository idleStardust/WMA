package DataStructures.linkedlistpack;

public class Matrix < T >
{
	private List < List<T> > _Matrix;
	
	public Matrix(int pNumber)
	{
		this._Matrix = new List< List<T> >();
		for(int x = 0; x < pNumber; x++)
		{
			this.addRow();
		}
		for(int x = 0; x < pNumber; x++)
		{
			this.addColumn();
		}
	}
	public Matrix() 
	{
		this(0);
	}
	
	public void addRow()
	{
		this._Matrix.add(new List<T>());
	}
	
	public void addColumn()
	{
		ListIterator<List<T>> iterator = this._Matrix.iterator();
		while( iterator.hasNext() )
			iterator.next().add(null);
	}
	
	public void addToAllRaw(T pDato)
	{
		ListIterator<List<T>> iterator = this._Matrix.iterator();
		while( iterator.hasNext() )
			iterator.next().add(pDato);
	}
	public void add( T pDato, int pFila, int pColumna )
	{
		this._Matrix.search(pFila).add(pDato, pColumna);
	}
	
	public void set( T pDato, int pFila, int pColumna )
	{
		this._Matrix.search(pFila).set(pDato, pColumna);
	}
	
	public T search( int pFila, int pColumna  )
	{
		return this._Matrix.search(pFila).search(pColumna);
	}
	
	
	/**
	 * 
	 * @param pFila
	 */
	public void removeRow(int pFila)
	{
		this._Matrix.remove(pFila);
	}
	
	/**
	 * 
	 * @param pFila
	 */
	public void remove(int pFila)
	{
		ListIterator<List<T>> iterator = this._Matrix.iterator();
		while( iterator.hasNext() )
			iterator.next().remove(pFila);
	}
	
	/**
	 * 
	 */
	public void print()
	{
		System.out.println("\t Matriz");
		System.out.println("-------------------------------------------------------------------------------");
		ListIterator<List<T>> iterator = this._Matrix.iterator();
		for(int x=0; iterator.hasNext(); x++ )
		{
			System.out.print(x+"   ");
			iterator.next().print();
		}
		System.out.println();
	}
}
