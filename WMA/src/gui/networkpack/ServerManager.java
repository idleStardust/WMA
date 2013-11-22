package gui.networkpack;

import gui.networkpack.chatpack.FacadeAdminServer;
import gui.networkpack.chatpack.InterfazServer;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ServerManager {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InterfazServer frame = new InterfazServer();
		String mensaje = FacadeAdminServer.getInstace().CrearServer();
		if (mensaje.equals("")){
			frame.setVisible(true);
			new Thread(FacadeAdminServer.getInstace().getServer()).start();
			frame.InsertarCliente("Cliente 1");
		}
		else{
			frame.setVisible(false);
			InterfazSockets.Error(mensaje);
			System.exit(0);
		}
			
	}
}
