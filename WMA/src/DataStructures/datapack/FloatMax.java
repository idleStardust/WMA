package DataStructures.datapack;

/**
 * Clase FloatMax.
 * Es contenedor de un dato del tipo float.
 */
public class FloatMax implements IDato{
	
	/** The _dato. */
	private float _dato;
	
	/**
	 * Instancia un FloatMax.
	 *
	 * @param pDato el dato que se quiere contener.
	 */
	public FloatMax(float pDato){
		_dato = pDato;
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Mayor(datapack.IDato)
	 */
	
	@Override
	public boolean Mayor(IDato pDato) {
		return _dato > ((FloatMax)pDato).getDato();
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Menor(datapack.IDato)
	 */
	@Override
	public boolean Menor(IDato pDato) {
		return _dato < ((FloatMax)pDato).getDato();
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Igual(datapack.IDato)
	 */
	@Override
	public boolean Igual(IDato pDato) {
		return _dato == ((FloatMax)pDato).getDato();
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#Print()
	 */
	@Override
	public void Print(){
		System.out.print(_dato);
	}
	
	/**
	 * Solicita el dato. Pide el dato que el objeto contiene.
	 *
	 * @return el dato contenido
	 */
	public float getDato(){
		return _dato;
	}
	
	/* (non-Javadoc)
	 * @see datapack.IDato#getTipo()
	 */
	@Override
	public String getTipo(){
		return "FloatMax";
	}
}
