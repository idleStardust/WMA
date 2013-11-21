package ThreadsLogic;

public class MultiThreadingLogic implements Runnable {
	
	
		   Thread t;
		   MultiThreadingLogic() {
		      t = new Thread(this, "Nuevo Thread");
		    
		      t.start(); 		   }
		   
		  		   public void run() {
		      try {
		         for(int i = 5; i > 0; i--) {
		            Thread.sleep(50);
		         }
		     } catch (InterruptedException e) {

		     }
		     System.out.println("Thread iterrumped");
		   }
	}

		

