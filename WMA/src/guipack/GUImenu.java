package guipack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.print.DocFlavor.URL;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * The Class Menus.
 * @author E,L,C,I,A.
 */
public class GUImenu extends JFrame{
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main (String [] args){
		GUImenu prueba = new GUImenu();
	}
	
	
		/**
		 * Instantiates a new menus.
		 */
		public GUImenu(){
			
			//pantalla principal de nuestro proyecto menu de WheArd
			
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//tamaño de menu principal y titulo.
			setTitle("Menu Principal");
			setSize(800, 700);
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			
			Container contentPane = new Container();
			contentPane.setSize(850, 850);
			contentPane.setVisible(true);
			add(contentPane);
			
			//Botones que se encuentran en nuestro menu principal de WheArd
			
			JButton WheArd = new JButton("Where is my Arduino");
			WheArd.setBounds(60, 620, 140, 27);
			WheArd.addActionListener(new ActionListener() {
				
				/**
				 * 
				 */
				//
				@Override
				public void actionPerformed(ActionEvent e) {					
					GUIaction mainFrame= new GUIaction();
					dispose();
					
				}
	        });
			contentPane.add(WheArd);
			
			//Boton que se encuentran en nuestro menu principal de WheArd boton salir
			JButton botonSalir = new JButton("Salir");
			botonSalir.setBounds(650, 620, 120, 27);
			contentPane.add(botonSalir);
			botonSalir.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose(); 
	            }
	        });
			
			//Boton que se encuentran en nuestro menu principal de WheArd boton instrucciones
			JButton botonInstrucciones = new JButton("Instrucciones");
			botonInstrucciones.setBounds(355, 620, 130, 27);
			contentPane.add(botonInstrucciones);
			botonInstrucciones.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                System.out.println("Boton instrucciones");
	                GUIintruccion.main(null);
	                dispose();
	            }
	        });
			
			//Imagen de nuestro menu principal de WheArd
			
			java.net.URL url = getClass().getResource("/images/Interfaz/v1.jpg");  
			ImageIcon icon = new ImageIcon(url);  
			
			//Label de nuestros menu Principal
			
			JLabel labelFondo = new JLabel();
			labelFondo.setSize(800, 700);
			labelFondo.setIcon(icon);
			contentPane.add(labelFondo);
			setVisible(true);
	
			JLabel label1 = new JLabel();
			label1.setSize(500, 100);
			label1.setText("    WheArd   ");
			contentPane.add(label1);
			setVisible(true);
			
			
		}
		
		
		
	      
		
		
}