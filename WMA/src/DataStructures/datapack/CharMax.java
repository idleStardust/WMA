package DataStructures.datapack;

/**
 * Clase CharMax.
 * Contiene un dato de tipo char que lo representa.
 */


public class CharMax implements IDato{
	/** The _dato. */
	private char _dato;
	
	/**
	 * Instancia un CharMax. 
	 *
	 * @param pDato es el dato que lo representa
	 */
	public CharMax(char pDato){
		_dato = pDato;
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Mayor(datapack.IDato)
	 */
	@Override
	public boolean Mayor(IDato pDato) {
		return _dato > ((CharMax)pDato).getDato();
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Menor(datapack.IDato)
	 */
	@Override
	public boolean Menor(IDato pDato) {
		return _dato < ((CharMax)pDato).getDato();
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Igual(datapack.IDato)
	 */
	@Override
	public boolean Igual(IDato pDato) {
		return _dato == ((CharMax)pDato).getDato();
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Print()
	 */
	@Override
	public void Print() {
		System.out.print(_dato);
	}
	
	/**
	 * Solicita el dato. Retorna el dato que contiene.
	 *
	 * @return el dato que contiene.
	 */
	public char getDato(){
		return _dato;
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#getTipo()
	 */
	@Override
	public String getTipo() {
		return "CharMax";
	}

}
