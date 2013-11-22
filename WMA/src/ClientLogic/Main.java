package ClientLogic;

import java.io.IOException;
public class Main {
	 public static void main(String[] args) throws IOException {
	        FabricaCliente f = new FabricaCliente("172.18.117.147", 1238, "Gamer1");
	        f.getServerData();
	    }
}
