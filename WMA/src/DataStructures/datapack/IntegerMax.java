package DataStructures.datapack;

/**
 * Clase IntegerMax. Contiene un dato del tipo int
 */
public class IntegerMax implements IDato{
	
	/** el dato contenido. */
	private int _dato;
	
	/**
	 * Instancia un nuevo integerMax.
	 *
	 * @param pDato el dato que representa al objeto
	 */
	public IntegerMax(Integer pDato){
		_dato = pDato;
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Mayor(datapack.IDato)
	 */
	@Override
	public boolean Mayor(IDato pDato) {
		return _dato > ((IntegerMax)pDato).getDato();
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Menor(datapack.IDato)
	 */
	@Override
	public boolean Menor(IDato pDato) {
		return _dato < ((IntegerMax)pDato).getDato();
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Igual(datapack.IDato)
	 */
	@Override
	public boolean Igual(IDato pDato) {
		return _dato == ((IntegerMax)pDato).getDato();
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Print()
	 */
	@Override
	public void Print() {
		System.out.print(_dato);
	}
	
	/**
	 * Solicitar el dato. Retorna el dato que representa al objeto instanciado
	 *
	 * @return el dato que reprensa el objeto creado.
	 */
	public int getDato(){
		return _dato;
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#getTipo()
	 */
	@Override
	public String getTipo() {
		return "IntegerMax";
	}

}
