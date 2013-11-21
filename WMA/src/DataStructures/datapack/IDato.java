package DataStructures.datapack;

/**
 * Interface IDato.
 * Contiene un dato basicos que sea del tipo float, int, string y char
 */
public interface IDato {
	
	/**
	 * Mayor. Compara el dato con otro y verifica si es mayor o no.
	 *
	 * @param pDato the dato
	 * @return true, si es respecto al tipo de dato se considera mayor
	 */
	public boolean Mayor(IDato pDato);
	
	/**
	 * Menor. Compara el dato con otro y verifica si es menor o no.
	 *
	 * @param pDato the dato
	 * @return true, si es respecto al tipo de dato se considera menor
	 */
	public boolean Menor(IDato pDato);
	
	/**
	 * Igual. Compara el dato con otro y verifica si su contenido es igual o no.
	 *
	 * @param pDato el dato a comparar
	 * @return true, si es respecto al tipo de dato se considera igual
	 */
	public boolean Igual(IDato pDato);
	
	/**
	 * Imprime. Imprime el dato en consola
	 */
	public void Print();
	
	/**
	 * Solicitar el tipo. Pide el tipo del dato que contiene.
	 *
	 * @return "StringMax" si el dato que contine es un String.
	 * "IntegerMax" si el dato que contiene es un int.
	 * "CharMax" si el dato que contiene es un char.
	 * "FloatMax" si el dato que contiene es un float.
	 */
	public String getTipo();
}
