package managerpack;


import java.io.IOException;
import java.util.Scanner;

import networkpack.protocolpack.Encoder;
import ClientLogic.ClientLogic;
import ClientLogic.ConstantsServer;
import gamepack.Manager; 
import socketsLogic.LoadServer;


public class MainManager implements ConstantsServer {
	Manager _graphManager=new Manager();
	Encoder managerEncoder = Encoder.getInstance();
	private static MainManager singletonMainManager=new MainManager();
	ClientLogic f;
	tre n;
	
	static MainManager main;
	
	private MainManager(){}
	public static MainManager getInstance(){
		return singletonMainManager;
	}
	public void initServer(){
		LoadServer mainServer= new LoadServer();
	}
	public void initClient(){
		
        try {
        	f = new ClientLogic(ip, 1238, "cliente"); 
        	main.init();
			f.getServerData();
			
			System.out.println("cliente creado");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
			
	}
	
	private void init(){
		System.out.println("init!!!!");
		for (int x = 0; x < 20; x++){
			String a = _graphManager.crearRegionLocal();
			//managerEncoder.crearNodo(a);
			f.sendmsg(managerEncoder.crearNodo(a));	
		}		
		_graphManager.print();
	}
	
	
	
	public void evaluar(){
		System.out.println( "pas�� por evaluar: " );
		main.initClient();
	    //main.init();
	}
	
	
	public static void main(String[] args) {
		main= new MainManager();
		
		Scanner scanner = new Scanner( System.in );

	    System.out.println( "tipo de conexion: " );
	    
	    
	    
	    String input = scanner.nextLine();
	    
	    if(input.equals("server")){
	    	main.initServer();
	    	
	    	main.initClient();
		    main.init();
	    	
	    }
	    else if(input.equals("1")){
		    System.out.println( "entro a 1: " );
		    main.initClient();
		    
	    	
	    }
	    else if(input.equals("2")){
		    System.out.println( "entro a 1: " );
		    main.init();
	    	
	    }
	    
	   
	    
	    
	    
	    
	    
	    System.out.println( "input = " + input );
		}
	    
	
	public Manager getManager(){
		return _graphManager;
	
	}
	

	
	
}
