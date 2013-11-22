package socketsLogic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class LoadServer {
	
	public static void main(String[] args) {
		LoadServer prueba = new LoadServer();
	}
	 public LoadServer(){
		 int port = 1238; 
	        int maxGamers = 1000;
	        ServerSocket server = null; 
	        Socket socket = null;
	        TrafficLogic data = new TrafficLogic();
	        try {
	           
	        	server = new ServerSocket(port, maxGamers);
	            
	            while (true) {
	                System.out.println("waiting for new clients");
	                socket = server.accept();
	                System.out.println("client " + socket.getInetAddress().getHostName() + " connected.");
	                
	                ClientConection gc = new ClientConection(socket, data);
	                gc.start();
	                
	            }
	        } catch (IOException ex) {
	            System.out.println("Error: " + ex.getMessage());
	        } finally{
	            try {
	                socket.close();
	                server.close();
	            } catch (IOException ex) {
	            	System.out.println("Error stopping server: " + ex.getMessage());
	            }
	        }
	    }
}
	 
	 

