package DataStructures.datapack;

// TODO: Auto-generated Javadoc
/**
 * Clase StringMax. Contiene un dato del tipo int.
 */
public class StringMax implements IDato{
	
	/** The _dato. */
	private String _dato;
	
	/**
	 * Instancia un nuevo StringMax.
	 *
	 * @param pDato el dato que representa el objeto instanciado.
	 */
	public StringMax(String pDato){
		_dato = pDato;
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Mayor(datapack.IDato)
	 */
	@Override
	public boolean Mayor(IDato pDato) {
		return _dato.compareTo(((StringMax)pDato).getDato()) > 0;
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Menor(datapack.IDato)
	 */
	@Override
	public boolean Menor(IDato pDato) {
		return _dato.compareTo(((StringMax)pDato).getDato()) < 0;
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Igual(datapack.IDato)
	 */
	@Override
	public boolean Igual(IDato pDato) {
		return _dato.equals(((StringMax)pDato).getDato());
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Print()
	 */
	@Override
	public void Print() {
		System.out.print(_dato);
	}
	
	/**
	 * Solicita el dato. Retorna el dato representativo del objeto instanciado.
	 *
	 * @return el dato que representa el objeto.
	 */
	public String getDato(){
		return _dato;
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#getTipo()
	 */
	@Override
	public String getTipo() {
		return "StringMax";
	}

}
