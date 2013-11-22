package socketsLogic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class ClientConection extends Thread implements Observer {
	private Socket socket;
	private TrafficLogic data;
	private DataInputStream inputData;
	private DataOutputStream ouputData;

	public ClientConection(Socket socket, TrafficLogic pData) {
		this.socket = socket;
		this.data = pData;

		try {
			inputData = new DataInputStream(socket.getInputStream());
			ouputData = new DataOutputStream(socket.getOutputStream());
		} catch (IOException ex) {
			System.out.println("Error creating input stream and output stream : " + ex.getMessage());
		}

	}

	@Override
	public void run() {
		String dataReceived;
		boolean conectado = true;

		data.addObserver(this);

		while (conectado) {
			try {

				dataReceived = inputData.readUTF();

				data.setData(dataReceived);
			} catch (IOException ex) {
				System.out.println("IP Gamer "
						+ socket.getInetAddress().getHostName()
						+ " disconnected.");
				conectado = false;

				try {
					inputData.close();
					ouputData.close();
				} catch (IOException ex2) {
					System.out.println("Error ending input stream and output stream:" + ex2.getMessage());
				}
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
            // Envia el mensaje al cliente
			ouputData.writeUTF(arg.toString());
        } catch (IOException ex) {
            System.out.println("Error sending message to client (" + ex.getMessage() + ").");
        }

	}

}
