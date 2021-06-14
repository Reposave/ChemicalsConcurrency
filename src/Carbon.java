package molecule;

public class Carbon extends Thread {
	
	private static int carbonCounter =0;
	private int id;
	private Propane sharedPropane;
	public static BarrierReusable barrier = new BarrierReusable(3); // all atoms must be at the barrier //3 carbon atoms in Propane
	
	public Carbon(Propane propane_obj) {
		 
		Carbon.carbonCounter+=1;
		id=carbonCounter;
		this.sharedPropane = propane_obj;
	}
	
	public void run() {
	    try {	 
	    	 // you will need to fix below
	    	
	    	barrier.phase1(); //Only 3 carbons at a time are allowed through.
	    	System.out.println(this.id+" Carbon through.");
	    	sharedPropane.barrier.b_wait();
	    	System.out.println("---Group ready for bonding---");
	    	sharedPropane.addCarbon();
	    	sharedPropane.bond("C"+ this.id);  //bond
	    	sharedPropane.removeCarbon(1);
	    	barrier.phase2();
	    	 
	    }
	    catch (InterruptedException ex) { /* not handling this  */}
	   // System.out.println(" ");
	}

}
