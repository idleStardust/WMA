package ThreadsLogic;


public class CazaRecompensasThread {
	boolean alive=true;
	int i=0;
	   void Iterrumpir(){
		   this.alive=false;
	   }
	  public CazaRecompensasThread(){
		  new MultiThreadingLogic(); 

	      try {
	         while (alive) {
	           System.out.println("Main Thread: " + i);
	           Thread.sleep(100);
	           i++;
	         }
	      } catch (InterruptedException e) {
	      }
	   
	   }
	   
	}
