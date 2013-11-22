package gui.networkpack.chatpack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatCliente extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTextField _campoTexto;
	private String ID = "Cristian";
	private JButton boton;
	private JTextArea textPane;
	private String _mensaje;
	private JScrollPane _scroll;
	
	public ChatCliente() {
		setBounds(10, 540, 430, 153);
		setLayout(null);
		_campoTexto= new JTextField();
		_campoTexto.setBounds(23, 105, 261, 23);
		add(_campoTexto);
		boton = new JButton("enviar!");
		textPane = new JTextArea();
		textPane.setEditable(false);
		
		boton.setBounds(296, 105, 120, 23);
		add(boton);
		
		_scroll = new JScrollPane(textPane);
		_scroll.setBounds(23, 12, 393, 84);
		_scroll.setBackground(new Color(50, 22, 22, 20));
		add(_scroll);
		_mensaje = "";
		setClientButton();
		FacadeChatCliente.getInstace().setInterfaz(this);
	}
	public String getMensaje(){
		return _mensaje;
	}
	public void setClientButton(){
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getSource() == boton){
					_mensaje = _campoTexto.getText();
					FacadeChatCliente.getInstace().EnviarMensaje();
					if (!_mensaje.equals("")){
						textPane.append(ID + ": " + _mensaje+"\n");
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

	public void setID(String pID){
		ID = pID;
	}
}
