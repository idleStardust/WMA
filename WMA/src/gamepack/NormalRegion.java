package gamepack;

public class NormalRegion extends Region{
	private Arduino _arduino;
	
	public NormalRegion(String pDomain,Arduino pArduino) {
		super("node",pDomain);
		_arduino = pArduino;
		// TODO Auto-generated constructor stub
	}
	public NormalRegion(String pRegion, String pDomain,Arduino pArduino) {
		super("node",pRegion,pDomain);
		_arduino = pArduino;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "node";
	}
	
	public String toString(){
		return super.toString();
	}
	public String ArduinoToString (){
		if (tieneArduino()){
			return _arduino.toString();
		}
		return null;
	}
	
	public boolean tieneArduino(){
		return _arduino != null;
	}
}
