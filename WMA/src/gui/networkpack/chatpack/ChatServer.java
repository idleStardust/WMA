package gui.networkpack.chatpack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTextField _campoTexto;
	private String ID = "Server@WMA";
	private JButton boton;
	private JTextArea textPane;
	private String _mensaje;
	private JScrollPane _scroll;
	
	public ChatServer() {
		setBounds(0, 0, 611, 250);
		setLayout(null);
		setOpaque(false);
		_campoTexto= new JTextField();
		_campoTexto.setBackground(Color.WHITE);
		_campoTexto.setForeground(Color.DARK_GRAY);
		_campoTexto.setBounds(0, 210, 467, 25);
		add(_campoTexto);
		boton = new JButton("enviar!");
		textPane = new JTextArea();
		textPane.setForeground(Color.DARK_GRAY);
		textPane.setBackground(Color.WHITE);
		textPane.setEditable(false);
		
		boton.setBounds(470,208, 130, 30);
		add(boton);
		
		_scroll = new JScrollPane(textPane);
		_scroll.setBounds(0, 0, 600, 200);
		add(_scroll);
		_mensaje = "";
		setServerButton();
		FacadeAdminServer.getInstace().setInterfaz(this);
	}
	public String getMensaje(){
		return _mensaje;
	}
	public void setServerButton(){
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getSource() == boton){
					_mensaje = _campoTexto.getText();
					FacadeAdminServer.getInstace().EnviarMensaje();
					if (!_mensaje.equals("")){
						textPane.append(ID + ": "+  _mensaje+"\n");
						_campoTexto.setText("");
					}
				}
			}
		});
	}
	public void setTextoaCuadroTexto(String pTexto){
		if (pTexto != null){
			textPane.append(pTexto + "\n");
		}
	}
	public static void Error(String pError){
		JOptionPane.showMessageDialog(null, pError);
	}
}
