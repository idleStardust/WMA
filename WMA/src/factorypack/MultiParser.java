package factorypack;

import DataStructures.arraypack.IColeccion;
import DataStructures.datapack.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Caster.
 */
public class MultiParser {
	
	/** The _casteador singleton. */
	private static MultiParser _casteadorSingleton = new MultiParser();
	
	/**
	 * Instantiates a new caster.
	 */
	private MultiParser(){}
	
	/**
	 * Gets the single instance of Caster.
	 *
	 * @return single instance of Caster
	 */
	public static MultiParser getInstance(){
		return _casteadorSingleton;
	}
	
	public String ParseToString(IDato pDato){
		return ((StringMax) pDato).getDato();
	}
	public int ParseToInt(IDato pDato){
		return ((IntegerMax) pDato).getDato();
	}
	public char ParseToChar(IDato pDato){
		return ((CharMax) pDato).getDato();
	}
	public float ParseToFloat(IDato pDato){
		return ((FloatMax) pDato).getDato();
	}
	public IColeccion parseToColeccion(IDato pDato){
		return ((ArregloMax)pDato).getDato();
	}
}