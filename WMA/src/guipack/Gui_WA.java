package guipack;


import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledEditorKit.BoldAction;

/**
 * 
 * @author E,L,C,I,A.
 *
 */
public class Gui_WA extends JPanel{
	
	/** The Scroll de edicion. */
	JScrollPane ScrollDeEdicion;
	/**
	 * 
	 */
	 
	public Gui_WA(){
	    final JFrame mainFrame=new JFrame();
		JPanel contentButtons=new JPanel();
		JPanel B_Whe_Ar=new JPanel();
		JScrollPane Scroll = new JScrollPane();
		ScrollDeEdicion = new JScrollPane(this);
		//mainFrame.setIconImages(new ImageIcon(getClass().getClassLoader().getResource("images/interfaz/ico2.png")));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(50,50,1000,750);
        setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(0, 0, 728, 2000);
		/**
		 * 
		 */
		 
		Scroll.setBounds(20, 60, 300, 450);
		contentButtons.add(Scroll);
		Scroll.setViewportView(B_Whe_Ar);
		Scroll.getViewport().setView(B_Whe_Ar);
		B_Whe_Ar.setLayout(null);
		B_Whe_Ar.setPreferredSize(new Dimension(280, 720));
		
		/**
		 * 
		 */
		ScrollDeEdicion.setBounds(0, 0, 990, 550);
		mainFrame.add(ScrollDeEdicion);
		ScrollDeEdicion.setViewportView(this);
		ScrollDeEdicion.getViewport().setView(this);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(2000, 2000));
		mainFrame.setLayout(null);
		
		JLabel fondo = new JLabel();
		
		/**
		 * 
		 */
		fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/Interfaz/v3.jpg")));
		fondo.setBounds(0, 0, 352, 720);
		contentButtons.add(fondo);
		mainFrame.add(contentButtons);
		mainFrame.setVisible(true);
	}
	
}
