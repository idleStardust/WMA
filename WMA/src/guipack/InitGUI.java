package guipack;

import javax.swing.JApplet;
import javax.swing.JFrame;


/**
 * The Class Principal.
 */
public class InitGUI extends JApplet {

    /**
     * Inits the.
     */
    public void init(){
        PantWA WA= new PantWA(this);
        WA.setBounds(0, 0, 400, 400);
        add(WA);
    }
}
