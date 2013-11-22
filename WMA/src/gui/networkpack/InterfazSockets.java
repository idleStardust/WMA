package gui.networkpack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class InterfazSockets extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JTextField campoTexto;
	JButton boton;
	JTextArea textPane;
	String _mensaje;
	JScrollPane _scroll;
	JDialog _error;
	boolean _isServer = false;
	
	public InterfazSockets(){
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
		setBounds(30, 30, 430, 390);
		getContentPane().setLayout(null);
		campoTexto= new JTextField();
		campoTexto.setBounds(23, 326, 261, 23);
		getContentPane().add(campoTexto);
		boton = new JButton("send!");
		textPane = new JTextArea();
		textPane.setEditable(false);
		
		boton.setBounds(296, 326, 120, 23);
		getContentPane().add(boton);
		
		_scroll = new JScrollPane(textPane);
		_scroll.setBounds(23, 60, 393, 250);
		_scroll.setBackground(new Color(50, 22, 22, 20));
		getContentPane().add(_scroll);
		_mensaje = "";
		
		setVisible(true);
		addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(WindowEvent e){
				if (_isServer){
					FacadeInterfazCharla.getInstace().ResetServer();
				}
				else{
					FacadeInterfazCharla.getInstace().ResetCliente();
				}
				System.exit(0);
			}
		});
	}
	public String getMensaje(){
		return _mensaje;
	}
	public void setBotonA(){
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getSource() == boton){
					_mensaje = campoTexto.getText();
					FacadeInterfazCharla.getInstace().EnviarMensaje(1);
					if (!_mensaje.equals("")){
						textPane.append(_mensaje+"\n");
						campoTexto.setText("");
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
	
	public void setBotonB(){
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getSource() == boton){
					_mensaje = campoTexto.getText();
					FacadeInterfazCharla.getInstace().EnviarMensaje(2);
					if (!_mensaje.equals("")){
						textPane.append(_mensaje+"\n");
						campoTexto.setText("");
					}
				}
			}
		});
	}
	public static void Error(String pError){
		JOptionPane.showMessageDialog(null, pError);
	}
	public void setServer(){
		_isServer = true;
	}
}
