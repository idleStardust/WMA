package guipack;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*
 
 */
/**
 * The Class PantWA.
 */
public class PantWA extends JPanel implements MouseListener,MouseMotionListener{

    /** The y. */
    int x=0,y=0;
    
    /** The linea. */
    lineaWA linea;
    
    /** The circulo. */
    BolitaWA circulo;
    
    /** The jalada. */
    BolitaWA jalada=null;
    
    /** The List circulo. */
    List<BolitaWA> ListCirculo = new ArrayList<BolitaWA>();
    
    /** The List arista. */
    List<lineaWA> ListArista = new ArrayList<lineaWA>();
    
    /** The p. */
    InitGUI p;

    /**
     * Instantiates a new pant wa.
     *
     * @param prin {@link Principal}
     */
    public PantWA(InitGUI prin) {
        p=prin;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setVisible(true);
        this.setDoubleBuffered(true);
    }

    /**
     * Anadir circulo.
     *
     * @param x {@link Integer}
     * @param y {@link Integer}
     */
    public void anadirCirculo(int x, int y){
        circulo = new BolitaWA(ListCirculo.size(),x,y);
        ListCirculo.add(circulo);
        repaint();
        p.repaint();
    }

    /**
     * Anadir linea.
     *
     * @param x {@link Integer}
     * @param y {@link Integer}
     */
    public void anadirLinea( int x, int y){
        try{
            linea = new lineaWA (ListCirculo.get(x),ListCirculo.get(y));
            this.ListArista.add(linea);
            repaint();
            p.repaint();
        }catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "No se encontro circulo");
        }
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        for (lineaWA f:ListArista)
        {
            f.painter(g);
        }

        for (BolitaWA f:ListCirculo)
        {
            f.painter(g,this);
        }

    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    public void mouseClicked(MouseEvent e) {
        try{
            if(e.getButton()==1){
                x = e.getX();
                y = e.getY();
                anadirCirculo(x,y);
            }else
            {
                if(e.getButton()==3)
                {
                    int ini = Integer.parseInt(JOptionPane.showInputDialog("Numero de circulo inicual"));
                    int fin = Integer.parseInt(JOptionPane.showInputDialog("Numero de circulo final"));
                    anadirLinea(ini, fin);
                }
            }
        }catch(Exception ex){

        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    public void mousePressed(MouseEvent e) {}

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    public void mouseReleased(MouseEvent e) {}

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    public void mouseEntered(MouseEvent e) {}

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    public void mouseExited(MouseEvent e) {}

    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    public void mouseDragged(MouseEvent e) {
        if(jalada==null)
        {
            for (BolitaWA f:ListCirculo)
            {
                if(f.jaladopor(e.getPoint()))
                {
                    jalada=f;
                }
                x=e.getPoint().x;
                y=e.getPoint().y;
                repaint();
                p.repaint();
            }
        }
        else{
            jalada.transladar(e.getPoint().x-x,e.getPoint().y-y);
            x=e.getPoint().x;
            y=e.getPoint().y;
            repaint();
            p.repaint();
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    public void mouseMoved(MouseEvent e){
        jalada=null;
    }

}