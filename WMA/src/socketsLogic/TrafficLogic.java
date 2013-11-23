package socketsLogic;

import java.util.Observable;

public class TrafficLogic extends Observable{

    private String data;
    public TrafficLogic(){
    }
    
    public String getData(){
        return data;
    }
    

    public void setData(String pData){
        this.data = pData;
        
        this.setChanged();
        
        this.notifyObservers(this.getData());
   
    }
}