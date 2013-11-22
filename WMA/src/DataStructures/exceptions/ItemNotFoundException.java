package DataStructures.exceptions;

public class ItemNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(String pElemento) 
	{
		super("Elemento: " + pElemento + " no se encuentra en la coleccion");
	}
}
