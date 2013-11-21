package DataStructures.arraypack;

import DataStructures.datapack.IDato;


/**
 * Interface IColeccion.
 * Organiza los datos secuenciencialmente, y los mantiene con facil accesabilidad.
 * con ayuda del tipo de dato {@link  DataStructures.nodepack.Nodo} y {@link  DataStructures.nodepack.NodoDoble}
 */
public interface IColeccion {
	
	/**
	 * Agregar al inicio. Inserta el dato de modo que aparezca al principio del arreglo.Si se usa es recomendable
	 * no usar la insercion en orden.
	 * @param pDato el dato El dato a ingresar
	 */
	public void AgregarAlInicio(IDato pDato);
	
	/**
	 * Agregar al final. Inserta el dato al final del arreglo. Si se usa es recomendable
	 * no usar la insercion en orden.
	 *
	 * @param pDato the dato
	 */
	public void AgregarAlFinal(IDato pDato);
	
	/**
	 * Agregar en orden. Inserta el dato en el espacio que corresponde respecto a un orden
	 * creciente. no se recomienda hacer uso de la insercion al inicio y al final si desea
	 * un arreglo completamente ordenado, en el caso que sea necesario usarlo de la manera
	 * anteriormente mencionada, use un algortirmo de ordenamiento antes de usarlo, en el 
	 * caso de que el dato ya exista no lo insertara.
	 *
	 * @param pDato el dato a insertar
	 */
	public void AgregarEnOrden(IDato pDato);
	
	/**
	 * Borrar. Elimina el dato deseado del arreglo
	 *
	 * @param pDato el dato que se desea borrar.
	 * @return el dato borrado, en caso se no existir retornara null.
	 */
	public IDato Borrar(IDato pDato);
	
	/**
	 * Borrar. Elimina el dato en la posicion indicada.
	 *
	 * @param pposicion the pposicion
	 * @return the i dato
	 */
	public IDato Borrar(int pposicion);
	
	/**
	 * Buscar. Busca el dato deseado en el arreglo
	 *
	 * @param pDato el dato que se desea encontrar.
	 * @return el dato buscado, en caso se no existir retornara null.
	 */
	public IDato Buscar(IDato pDato);
	
	/**
	 * Buscar. busca el dato con un indice de 0 a el largo-1.
	 *
	 * @param pPosicion la posicion de busqueda
	 * @return el dato buscado, en caso se no existir retornara null.
	 */
	public IDato Buscar(int pPosicion);
	
	/**
	 * Borrar inicio. Borra el primer elemento del arreglo.
	 *
	 * @return el primer dato del arreglo, en caso se no existir retornara null.
	 */
	public IDato BorrarInicio();
	
	/**
	 * Borrar final. Borra el ultimo elemento del arreglo.
	 *
	 * @return el ultimo dato del arreglo, en caso se no existir retornara null.
	 */
	public IDato BorrarFinal();
	
	/**
	 * Solicitar el largo. Retorna La cantidad de elementos, que contiene el arreglo.
	 *
	 * @return el largo del arreglo
	 */
	public int getLargo();
	
	/**
	 * Imprimir. Imprime el arreglo.
	 */
	public void Print();
}
