package molecule;
import java.util.concurrent.Semaphore;

public class Hydrogen extends Thread {

	private static int hydrogenCounter = 0;
	private int id;
	private Propane sharedPropane;
	public static BarrierReusable barrier =  new BarrierReusable(8); //8 hydrogen atoms in Propane.; // all atoms must be at the barrier
	public static Semaphore sem = new Semaphore(8);
	
	public Hydrogen(Propane propane_obj) {
		Hydrogen.hydrogenCounter+=1;
		id=hydrogenCounter;
		this.sharedPropane = propane_obj;
		
	}
	
	public void run() {
	    try {
	    	sem.acquire();
	    	barrier.phase1(); //Only 8 hydrogens at a time are allowed through.
	    	
	    	sharedPropane.addHydrogen();	 
	    	sharedPropane.bond("H"+ this.id);
	    	
	    	sharedPropane.barrier.b_wait();	//Wait for all threads to finish printing.
	    	
	    	barrier.phase2();
	    	
	    	sem.release();
	    }
	   catch (InterruptedException ex) { /* not handling this  */}
	}

}
