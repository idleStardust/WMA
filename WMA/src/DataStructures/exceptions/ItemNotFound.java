package DataStructures.exceptions;

public class ItemNotFound extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemNotFound(String pElemento) 
	{
		super("Elemento: " + pElemento + " no se encuentra en la coleccion");
	}
}
