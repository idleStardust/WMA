package ClientLogic;

import java.io.IOException;

public class Main {
	 public static void main(String[] args) throws IOException {
	        FabricaCliente f = new FabricaCliente("172.26.110.94", 1238, "Gamer1");
	        f.getServerData();
	    }
}
