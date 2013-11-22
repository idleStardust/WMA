package ClientLogic;

import java.io.IOException;
public class Main implements ConstantsServer{
	 public static void main(String[] args) throws IOException {
	        ClientLogic f = new ClientLogic(ip, 1238, "cliente"); 
	        f.getServerData();
	        
	    }
}
