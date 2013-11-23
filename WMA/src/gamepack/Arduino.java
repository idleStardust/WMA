package gamepack;

public class Arduino {
	private int _points;
	private String _id;
	private static int _serial;
	public final String PUERTO_COM = "COM5";
	
	public Arduino(int pPuntos){
		_id = "arduino@"+String.format("%03d", _serial);
		_serial++;
		_points = pPuntos;
	}
	
	
	//manda un mensaje al facade del arduino.
	public int collectPoints(int pRobo){
		if (_points <0){
			return 0;
		}
		else if((_points - pRobo) < 0){
			int p = pRobo -_points;
			_points = 0;
			return p;
		}
		_points -= pRobo;
		return pRobo;
	}
	
	public int collectPoints(){
		int tmp = _points;
		_points = 0;
		return tmp;
	}
	
	public String getID(){
		return _id;
	}
	public String tipo(){
		return "arduino";
	}
	public String toString(){
		return "ID:" + _id + "#puntos:" + String.format("%06d",_points);
		
	}
}