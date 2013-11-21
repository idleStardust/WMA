package guipack;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

/**
 * 
 * @author E,L,C,I,A.
 *
 */
public class GUIaction extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static mxGraph graph = new mxGraph();
	protected static HashMap m = new HashMap();
	private mxGraphComponent graphComponent;
	private JTextField texto;
	private JButton botaoAdd;
	private JButton botaoDel;
	private JButton botaoLigar;
	private Object cell;
	
	/**
	 * 
	 */
	public static HashMap getM() {
		return m;
	}
	
	/**
	 * 
	 * @return
	 */
	public static mxGraph getGraph(){
		return graph;
	}

	/**
	 * 
	 */
	public GUIaction(){
		super("JGraph - Fluxograma ");
		initGUI();
		setVisible(true);
	}

	/**
	 * 
	 */
	
	private void initGUI() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(780,600);
		setLocationRelativeTo(null);
		graph = new mxGraph();
		graphComponent = new mxGraphComponent(graph);
		graphComponent.setToolTipText("componente");
		graphComponent.setPreferredSize(new Dimension(770,300));
		graphComponent.setLocation(0, 0);
		getContentPane().add(graphComponent);
		
		texto = new JTextField();
		getContentPane().add(texto);
		texto.setPreferredSize(new Dimension(520, 21));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		botaoAdd = new JButton ("Adicionar");
		getContentPane().add(botaoAdd);
		botaoAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				getGraph().getModel().beginUpdate();
				getM().put(getGraph().insertVertex(getGraph().getDefaultParent(), null, texto.getText(), 0, 0, 90, 90),texto.getText());
				getGraph().getModel().endUpdate();
			}
		});
		
		botaoDel = new JButton ("Deletar");
		getContentPane().add(botaoDel);
		botaoDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				graph.getModel().remove(cell);
			}
		});
		
		
		botaoLigar = new JButton ("Ligar");
		getContentPane().add(botaoLigar);
		botaoLigar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ligando1");
				getGraph().getModel().beginUpdate();
				System.out.println("Ligando2");
				String nome = JOptionPane.showInputDialog("Digite o nome o linha:");
				System.out.println("Ligando3:"+nome);
				getGraph().insertEdge(getGraph().getDefaultParent(),null, nome, getM().get(JOptionPane.showInputDialog("Digite el grafo 1:")),
				getM().get(JOptionPane.showInputDialog("Digite el grafo 2:")));
				System.out.println("Ligando4");
				getGraph().getModel().endUpdate();
				System.out.println("Ligando5");
				repaint();
				//AdicionarLinha linha = new AdicionarLinha();
				
			}
		});
		
		
		
		graphComponent.getGraphControl().addMouseListener(new MouseAdapter()
		{
			/**
			 * 
			 */
			public void mouseReleased(MouseEvent e)
			{
				cell = graphComponent.getCellAt(e.getX(), e.getY());
			}
		});
			
			
		
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GUIaction uno = new GUIaction();
		uno.setVisible(true);
	}
}
