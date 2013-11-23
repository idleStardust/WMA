package facadepack;


public class facadeInterfaz {
	static facadeInterfaz facadeGUISingleton= new facadeInterfaz();
	facadeInterfaz(){}
	
	public static facadeInterfaz getInstance(){
		return facadeGUISingleton;
	}
	
	
	
	
}
