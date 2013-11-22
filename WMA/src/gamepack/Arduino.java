package gamepack;

public class Arduino {
	private int _points;
	private String _id;
	private static int _serial;
	
	public Arduino(int pPuntos){
		_id = "arduino@"+String.format("%03d", _serial);
		_serial++;
		_points = pPuntos;
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
	
	public static void main(String[] args) {
		Arduino arduino = new Arduino(74544);
		Arduino arduino1 = new Arduino(744);
		Arduino arduino2 = new Arduino(854);
		Arduino arduino3 = new Arduino(944);
		Arduino arduino4 = new Arduino(94584);
		Arduino arduino5 = new Arduino(79844);
		Arduino arduino6 = new Arduino(645994);
		System.out.println(arduino.toString());
		System.out.println(arduino1.toString());
		System.out.println(arduino2.toString());
		System.out.println(arduino3.toString());
		System.out.println(arduino4.toString());
		System.out.println(arduino5.toString());
		System.out.println(arduino6.toString());
	}
	
}
