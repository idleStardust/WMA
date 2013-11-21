package arduino;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;



/*
 * <p> Administra todo lo referente a la coneccion con el Arduino.
 * Para usar estas funciones es necesario tener implementado la libreria RXTX <p>
 */
@SuppressWarnings("serial")
public class ArduinoConnect extends javax.swing.JFrame {

    private OutputStream Output = null;
    SerialPort serialPort;
    // &&&&&&&&&&&&&&&&&&&&&&&&&&&&&& IMPORTANTE %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    // Escoger bien el puerto que se va a utilizar en la variable PORT_NAME
    private final String PORT_NAME = "COM4";
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;

    
    /*
     * Constructor de la clase
     */
    public ArduinoConnect() {
        ArduinoConnection();
        PruebaEnvio();
    }
        
       
    
    public void PruebaEnvio (){
   
    int cont =0;
    while (true){ 
    EnviarDatos("");
    try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ArduinoConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        EnviarDatos(" LogicTEC - CE  "+cont);
    cont++;
    }
    }
        
        
    
    /*
     * <p> Se encarga de inicializar todos los puertos y lo referente a la coneccion del Arduino <p> 
     */
    public void ArduinoConnection() {

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

            if (PORT_NAME.equals(currPortId.getName())) {
                portId = currPortId;
                break;
            }
        }

        if (portId == null) {

            System.exit(ERROR);
            return;
        }

        try {

            serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            Output = serialPort.getOutputStream();

        } catch (PortInUseException | UnsupportedCommOperationException | IOException e) {

            System.exit(ERROR);
        }

    }

    

    /*
     * <p> Esta clase recibe un String y lo envia a la placa Arduino. Si hay algunn problema enviando los datos se lanza
     * una excepcion <p> 
     * @ param data: el String que se quire imprimir en el LCD del Arduino
     */
    private void EnviarDatos(String data) {
        
        try {
            Output.write(data.getBytes());

        } catch (IOException e) {
            System.out.println("Error: No se puede imprimir en el LCD");
            System.exit(ERROR);
        }
    }
    
    
    public static void main(String args[]) {
        
        ArduinoConnect hola = new ArduinoConnect();
        
    
}
}//fin de la clase
