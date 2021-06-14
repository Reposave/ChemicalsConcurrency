package molecule;
import java.util.concurrent.Semaphore;

public class Carbon extends Thread {
	
	private static int carbonCounter =0;
	private int id;
	private Propane sharedPropane;
	public static BarrierReusable barrier = new BarrierReusable(3); // all atoms must be at the barrier //3 carbon atoms in Propane
	public static Semaphore sem = new Semaphore(3);
	public static Semaphore print_sem = new Semaphore(1);
	public static boolean print = true;
	
	public Carbon(Propane propane_obj) {
		 
		Carbon.carbonCounter+=1;
		id=carbonCounter;
		this.sharedPropane = propane_obj;
	}
	
	public void run() {
	    try {	 
	    	 // you will need to fix below
	    	//System.out.println("Carbon "+ this.id +" Present");
	    	sem.acquire();
	    	barrier.phase1(); //Only 3 carbons at a time are allowed through.
	    	
	    	//System.out.println(this.id+" Carbon through.");
	    	
	    	//sharedPropane.barrier.b_wait();
	    	print_sem.acquire();
	    	if(print){
	    		System.out.println("---Group ready for bonding---");
	    		print = false;
	    	}
	    	print_sem.release();
	    	
	    	
	    	sharedPropane.addCarbon();
	    	sharedPropane.bond("C"+ this.id);  //bond
	    	
	    	//System.out.println(barrier.count);
	    	barrier.phase2(); //The semaphore and Barrier are necessary as we want to make sure all 3 threads are done first and the count is 0 before any other thread comes in.
	    	print = true;
	    	sem.release();
	    	
	    	
	    	//System.out.println("Carbon Exit!");
	    }
	    catch (InterruptedException ex) { /* not handling this  */}
	   // System.out.println(" ");
	}

}
