package guipack;
//Bibliotecas Importadas y necesarias para Proyecto de LogicTEC

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The Class Instructions.
 * @author E,L,C,I,A.
 */
public class GUIintruccion extends JFrame implements ActionListener {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main (String [] args){
		GUIintruccion pruebaa = new GUIintruccion();
	}
	
	/**
	 * Instantiates a new instructions.
	 */
	public GUIintruccion(){
		
		//pantalla principal de las instrucciones de LogicTEC
		setTitle("Instrucciones");
		setSize(800, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = new Container();
		contentPane.setSize(850, 1000);
		contentPane.setVisible(true);
		add(contentPane);
	
		//Botoes que se encuentran en nuestras instrucciones de LogicTEC
		JButton botonSalir = new JButton("Atras");
		botonSalir.setBounds(650, 620, 120, 27);
		contentPane.add(botonSalir);
		botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	GUImenu.main(null);
            	dispose(); 
            }
        });
		
		//Imagen de nuestra pantalla de instrucciones de LogicTEC
		java.net.URL url = getClass().getResource("/images/Interfaz/v2.jpg");  
		ImageIcon icon = new ImageIcon(url);  
		JLabel labelFondo = new JLabel();
		labelFondo.setSize(800, 700);
		labelFondo.setIcon(icon);
		contentPane.add(labelFondo);
		setVisible(true);
	
		// Label de que se encuentran en la pantalla de las instrucciones
		
		JLabel label2 = new JLabel();
		label2.setSize(500, 100);
		label2.setText("Las Instrucciones de LogicTEC son las siguientes:");
		contentPane.add(label2);
		setVisible(true);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}