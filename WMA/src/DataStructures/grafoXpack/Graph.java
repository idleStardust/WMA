package DataStructures.grafoXpack;

import DataStructures.exceptions.ItemNotFoundException;
import DataStructures.linkedlistpack.List;
import DataStructures.linkedlistpack.ListIterator;
import DataStructures.linkedlistpack.Matrix;

public class Graph<T extends Comparable<T> >
{
	final static int INFINITO = 1000;
	final static int SELF = 0;
	List<Vertex<T>> _ListVertex;
	Matrix <Integer> _MatrizPeso;
	Matrix <Vertex<T> > _MatrizAdj;
	
	public Graph() 
	{
		this._ListVertex = new List<Vertex<T>>();
		this._MatrizAdj = new Matrix<Vertex<T>>();
		this._MatrizPeso = new Matrix<Integer>();
	}
	
	public void add(T pDato, String pID)
	{
		Vertex<T> tmp = new Vertex<T>(pDato, pID);
		
		//	Anadir espacio en la matriz de peso.
		this.addSpaceMatrizPeso();
		this.addSpaceMatrizAdyacente(tmp);
		
		//	Lista Interna
		this._ListVertex.add(tmp);;
	}
	
	void remove(Vertex<T> pVertice)
	{
		int nodo = this._ListVertex.search(pVertice);
		
		//	Remover de los grafos
		this._MatrizAdj.removeQuark(nodo);
		this._MatrizAdj.removeQuark(nodo);
		
		//	Remover de la lista.
		this._ListVertex.remove(pVertice);
	}
	
	public void remove(T pVertice)
	{
		this.remove(this.searchG(pVertice));
	}
	
	public void remove(String pVertice)
	{
		this.remove(this.searchG(pVertice));
	}
	
	public void conect(T pNodo, T pOtroNodo, int Peso)
	{
		this.conect(this.searchG(pNodo), this.searchG(pOtroNodo),Peso);
	}
	public void conect(T pNodo, T pOtroNodo)
	{
		int temp = (int) (Math.random()*1000);
		this.conect(this.searchG(pNodo), this.searchG(pOtroNodo),temp);
	}
	
	public void conect(String pNodo, String pOtroNodo)
	{
		int temp = (int) (Math.random()*1000);
		this.conect(this.searchG(pNodo), this.searchG(pOtroNodo), temp);
	}
	
	void conect(Vertex<T> pNodo, Vertex<T> pOtroNodo, int pPeso)
	{
		pNodo.addNext(pOtroNodo);
		//	Matriz de Pesos
		int nodosaliente = this._ListVertex.search(pNodo);
		int nodoentrante = this._ListVertex.search(pOtroNodo);
		
		//	Se anaden los datos a las matrices
		this._MatrizPeso.set(pPeso, nodosaliente, nodoentrante);
		this._MatrizAdj.set(pNodo, nodosaliente, nodoentrante);
		//
	}
	
	public void disconnect(T pNodo, T pOtroNodo)
	{
		this.disconect(this.searchG(pNodo), this.searchG(pOtroNodo));
	}
	
	public void disconnect(String pNodo, String pOtroNodo)
	{
		this.disconect(this.searchG(pNodo), this.searchG(pOtroNodo));
	}
	
	void disconect(Vertex<T> pNodo, Vertex<T> pOtroNodo)
	{
		pNodo.addNext(pOtroNodo);
		//	Matriz de Pesos
		int nodosaliente = this._ListVertex.search(pNodo);
		int nodoentrante = this._ListVertex.search(pOtroNodo);
		
		//	Se anaden los datos a las matrices
		this._MatrizPeso.set(Graph.INFINITO, nodosaliente, nodoentrante);
		this._MatrizAdj.set(new Vertex<T>(null,"Not Conected"), nodosaliente, nodoentrante);
		//
	}
	
	Vertex<T> searchG(String pVertex)
	{
		/*----------------------------Preparacion de Iteradores---------------------------*/
		ListIterator<Vertex<T>> iterator = this._ListVertex.iterator();
		Vertex <T> tmp;
		while(iterator.hasNext())
		{
			tmp = iterator.next();
			if (tmp.getID().equalsIgnoreCase(pVertex))
				return tmp;
		}
		throw new ItemNotFoundException(pVertex);
	}
	
	
	
	private void addSpaceMatrizPeso()
	{
		this._MatrizPeso.addQuark(Graph.INFINITO, Graph.SELF);
	}
	
	Vertex<T> searchG(T pVertex)
	{
		ListIterator<Vertex<T>> iterator = this._ListVertex.iterator();
		Vertex <T> tmp;
		while(iterator.hasNext())
		{
			tmp = iterator.next();
			if (tmp.getDato().compareTo(pVertex) == 0)
				return tmp;
		}
		throw new ItemNotFoundException(pVertex.toString());
	}
	
	private void addSpaceMatrizAdyacente(Vertex<T> pVertex)
	{
		this._MatrizAdj.addQuark(new Vertex<T>(null, "null"), pVertex);
	}
	
	public void printVertex()
	{
		ListIterator< Vertex<T> > iterator = this._ListVertex.iterator();
		while(iterator.hasNext())
			iterator.next().print();
	}
	public T search(String pID)
	{
		return this.searchG(pID).getDato();
	}
	
	public String search(T pDato)
	{
		return this.searchG(pDato).getID();
	}
	
	void printMatrices()
	{
		this._MatrizAdj.print();
		this._MatrizPeso.print();
	}
	public static void main(String[] args)
	{
		Graph<Integer> in = new Graph<Integer>();
		in.add(1,"1");
		in.add(2,"2");
		in.add(3,"3");
		in.add(4,"4");
		
		in.conect(1, 2, 4);
		in.conect(2, 1, 4);
		in.conect(1, 3, 2);
		in.conect(3, 1, 2);
		in.conect(1, 4, 5);
		in.conect(4, 1, 5);
		
		in.conect(3, 4, 2);
		in.conect(4, 3, 2);
		in.conect(3, 2, 1);
		
		in.conect(2, 4, 1);
		in.conect(4, 2, 1);
		in.disconnect(2, 4);
		//in.printMatrices();
		in.runFloyd();
		
		//System.out.println("After Floyd");
		
		//in.printMatrices();
		in.getCamino(3, 3).print();
	}
	
	public void runFloyd()
	{
		int[][] ans = this.toArrayW();
		int n = ans.length;
		for (int k=0; k< n;k++) 
		{
			for (int i=0; i<n; i++) {
				for (int j=0; j<n;j++) 
				{        
					if (ans[i][k]+ans[k][j] < ans[i][j]) 
					{
						this._MatrizPeso.set(ans[i][k]+ans[k][j], i, j);
						ans[i][j] = ans[i][k]+ans[k][j];
						this._MatrizAdj.set(this._MatrizAdj.search(k, j), i  , j);
						//path[i][j] = path[k][j];
					}
				}
			}
		}
	}
	
	public int[][] toArrayW( )
	{
		Matrix<Integer> matrizpeso = this._MatrizPeso;
		ListIterator<List<Integer>> mainiterator = this._MatrizPeso.iterator();		
		
		int[][] tmp = new int[matrizpeso.size()][matrizpeso.size()];
		for(int x = 0; mainiterator.hasNext(); x++)
		{
			ListIterator<Integer> helperiterator = mainiterator.next().iterator();
			int[] tmpme = tmp[x];
			for(int i = 0; helperiterator.hasNext() ; i++)
				tmpme[i] = helperiterator.next() ;
		}
		return tmp;
	}
	
	
	public String arraytoString(int[][] pArreglo)
	 {
		 String result = "[ ";
		 for(int x = 0; x < pArreglo.length; x++)
		 {
			 result += "\n[" + "\t";
			 int[] tmparray = pArreglo[x];
			 for(int i = 0; i < tmparray.length; i++)
			 {
				 result += tmparray[i] + ", ";
			 }
			 result += " ]";
		 }
		 result += " ]";
		 return result;
	 }
	
	public void printArray(int[][] pArreglo)
	{
		System.out.println(this.arraytoString(pArreglo));
	}
	
	public ListIterator<T> getCaminoIterator(T pVertex, T pOtroVertex)
	{
		return this.getCamino(pVertex, pOtroVertex).iterator();
	}
	
	public List<T> getCamino (T pVertex, T pOtroVertex)
	{
		//	Vertices
		Vertex<T> verticesalida = this.searchG(pVertex);
		Vertex<T> verticeentrada = this.searchG(pOtroVertex);
		
		// Indices de la Matriz
		int vOut = this._ListVertex.search(verticesalida);
		int vIn = this._ListVertex.search(verticeentrada);
		/*
		System.out.println("Indices");
		System.out.println(vIn);
		System.out.println(vOut);
		System.out.println("Vertices: ");
		System.out.println(verticesalida);
		System.out.println(verticeentrada);
		*/
		//	El camino
		List<T> elcamino = new List<T>();
		boolean flag = true;
		while(flag)
		{
			/*
			System.out.println("Indice Salida: " + vOut);
			System.out.println("Indice Llegada: " + vIn);*/

			if(vIn == vOut)
				flag = false;
			else
			{
				Vertex<T> tmp = this._MatrizAdj.search(vOut, vIn);
				vOut = this._ListVertex.search(tmp);
				//System.out.println(tmp);
				//System.out.println(elcamino);
				verticesalida = tmp;
				vIn = this._ListVertex.search(verticesalida);
				elcamino.add(tmp.getDato());
			}
		}
		return elcamino;
	}
}