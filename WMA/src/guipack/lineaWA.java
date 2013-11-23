package guipack;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The Class lineaWA.
 */
public class lineaWA {

    /** The inicial. */
    BolitaWA inicial;
    
    /** The ffinal. */
    BolitaWA ffinal;
    
    /** The color. */
    Color color = Color.BLACK;

    /**
     * Crea una nueva instancia wa linea.
     *
     * @param inicial {@link BolitaWA}
     * @param ffinal {@link BolitaWA}
     */
    public lineaWA(BolitaWA inicial, BolitaWA ffinal) {
        this.inicial = inicial;
        this.ffinal = ffinal;
    }

    /**
     * Painter.
     *
     * @param g {@link Graphics}
     */
    public void painter(Graphics g) {
        g.setColor(Color.BLUE);
        g.setColor(color);
        g.drawLine(inicial.getX(), inicial.getY(), ffinal.getX(), ffinal.getY());
    }

    /**
     * Establece el color.
     *
     * @param color {@link Color}
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Obtiene el final.
     *
     * @return {@link BolitaWA}
     */
    public BolitaWA getFfinal() {
        return ffinal;
    }

    /**
     * Obtiene el inicial.
     *
     * @return {@link BolitaWA}
     */
    public BolitaWA getInicial() {
        return inicial;
    }

}
