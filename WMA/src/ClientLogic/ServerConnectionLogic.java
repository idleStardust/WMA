package ClientLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextField;

import networkpack.protocolpack.Decoder;

public class ServerConnectionLogic implements ActionListener{
	
    private Socket socket; 
    private String gamer;
    private DataOutputStream outputData;
    private JTextField data;
    private Decoder decoding = new Decoder().getInstance();
    public ServerConnectionLogic(Socket pSocket, JTextField pData, String pGamer) {
    	this.socket = pSocket;
        this.data = pData;
        this.gamer = pGamer;
        try {
            this.outputData = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Error creating output stream : " + ex.getMessage());
        } catch (NullPointerException ex) {
        	System.out.println("El socket was not started correctly");
        }
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            outputData.writeUTF(gamer + ": " + data.getText() );
            System.out.println("verificando entrada"+data.getText());
        	decoding.Decode(data.getText());
            data.setText("");
            
        } catch (IOException ex) {
        	System.out.println("Error sending data: " + ex.getMessage());
        }
    }

}
