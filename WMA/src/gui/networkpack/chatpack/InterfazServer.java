package gui.networkpack.chatpack;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
public class InterfazServer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel label = new JLabel("");
	private JList<JLabel> list;

	/**
	 * Create the frame.
	 */
	public InterfazServer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(39, 22, 660, 300);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		tabbedPane.addTab("salones", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		tabbedPane.addTab("clientes", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnDesconectar = new JButton("Desconectar");
		btnDesconectar.setBounds(390, 15, 170, 30);
		panel_1.add(btnDesconectar);
		
		JButton btnAmonestar = new JButton("Amonestar");
		btnAmonestar.setBounds(390, 55, 170, 30);
		panel_1.add(btnAmonestar);
		
		list = new JList<JLabel>();
		list.setSelectedIndex(1);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(12, 12, 367, 200);
		panel_1.add(list);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		tabbedPane.addTab("conversaciones", null, panel_2, null);
		panel_2.setLayout(null);
		ChatServer chat = new ChatServer();
		chat.setBounds(30, 12, 600, 250);
		panel_2.add(chat);
		label.setBounds(0, -177, 1051, 648);
		contentPane.add(label);
	}
	public void InsertarCliente(String pDato){
		JLabel cliente = new JLabel(pDato);
	}
}
