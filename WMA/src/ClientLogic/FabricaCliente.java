package ClientLogic;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class FabricaCliente extends JFrame{

	private static final long serialVersionUID = 1L;
	private Socket socket;
    private int port;
    private String host;
    private String gamer;
    
    public FabricaCliente(String pHost, int pPort, String pGamer){
        super("Starnet");
        
    	this.host = pHost;
    	this.port = pPort;
    	this.gamer = pGamer;
    	
        
        JTextField tfData = new JTextField("", 20);
        JButton btSend = new JButton("send");

        Container c = this.getContentPane();
        c.setLayout(new GridBagLayout());
        
        c.add(tfData);
       
        c.add(btSend);
        
        this.setBounds(400, 100, 400, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
      
        try {
            socket = new Socket(host, port);
        } catch (UnknownHostException ex) {
            System.out.println("Error connecting to server (" + ex.getMessage() + ").");
        } catch (IOException ex) {
        	System.out.println("Error Connecting to server (" + ex.getMessage() + ").");
        }
        
        btSend.addActionListener(new ServerConnectionLogic(socket, tfData, gamer));
        
    }
    
    public void getServerData() throws IOException{
       
        DataInputStream inputData = null;
       
        try {
        	inputData = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.out.println("Error creating input Stream: " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("Error creating Socket.");
        }
        
        boolean connected = true;
        while (connected) {
           
        	System.out.println(inputData.readUTF());
            
        }
    }

}
