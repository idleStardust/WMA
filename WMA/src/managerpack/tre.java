package managerpack;

import java.io.IOException;

import ClientLogic.ClientLogic;

public class tre extends Thread{
	ClientLogic f;
	String ip ="172.26.100.65";
	public void run(){
		f = new ClientLogic(ip, 1238, "cliente"); 
		try {
			f.getServerData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ClientLogic getLogic(){
		return f;
	}
}
