package managerpack;

import gamepack.Manager; 
import socketsLogic.LoadServer;

public class MainManager {
	Manager _graphManager=new Manager();
	
	public void Init(){
		//LoadServer mainServer= new LoadServer();
		for (int x = 0; x < 20; x++){
			_graphManager.crearRegionLocal();
		}
		_graphManager.print();
	}
	
	public static void main(String[] args) {
		MainManager main = new MainManager();
		main.Init();
	}
	
	
	
	
	
	
	
	
	
	
	
}
