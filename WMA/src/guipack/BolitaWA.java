package guipack;

import java.awt.*;
import javax.swing.ImageIcon;

/**
 * The Class BolitaWA.
 */
public class BolitaWA{

    /** The n. */
    int x,y,n;
    
    /** The image. */
    Image image;

    /**
     *Crea una nueva instancia wa bolita.
     *
     * @param n {@link Integer}
     * @param x {@link Integer}
     * @param y {@link Integer}
     */
    public BolitaWA(int n, int x, int y) {
        this.n=n;
        this.x=x;
        this.y=y;
        image = new ImageIcon(getClass().getResource("/images/Interfaz/ON.png")).getImage();
    }

    /**
     * Painter.
     *
     * @param g {@link Graphics}
     * @param l {@link PantWA}
     */
    public void painter(Graphics g,PantWA l) {
        g.drawImage(image, x-15, y-15, l);
        g.setColor(Color.RED);
        g.drawString(""+n, x-15, y-15);
        g.drawString(""+n, x-14, y-14);
    }

    /**
     * Obtiene el x.
     *
     * @return {@link Integer}
     */
    public int getX() {
        return x;
    }

    /**
     * Obtiene el y.
     *
     * @return {@link Integer}
     */
    public int getY() {
        return y;
    }

    /**
     * Obtiene el n.
     *
     * @return {@link Integer}
     */
    public int getN() {
        return n;
    }

    /**
     * Transladar.
     *
     * @param dx Obtiene el x.
     * @param dy Obtiene el x.
     */
    public void transladar(int dx,int dy) {
        this.x+=dx; this.y+=dy;
    }

    /**
     * Ajusta la imagen.
     *
     * @param image {@link Image}
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Jaladopor.
     *
     * @param d {@link Point}
     * @return {@link Boolean}
     */
    public boolean jaladopor(Point d) {
        if(d.distance(x, y)<=15) {
            return true;
        }
        else {
            return false;
        }
    }
}