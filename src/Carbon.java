package molecule;

public class Carbon extends Thread {
	
	private static int carbonCounter =0;
	private int id;
	private Propane sharedPropane;
	public BarrierReusable barrier; // all atoms must be at the barrier
	
	public Carbon(Propane propane_obj) {
		this.barrier=new BarrierReusable(3); //3 carbon atoms in Propane
		Carbon.carbonCounter+=1;
		id=carbonCounter;
		this.sharedPropane = propane_obj;
	}
	
	public void run() {
	    try {	 
	    	 // you will need to fix below
	    	System.out.println("---Group ready for bonding---");
	    	barrier.phase1();
	    	sharedPropane.barrier.b_wait();
	    	sharedPropane.addCarbon();
	    	sharedPropane.bond("C"+ this.id);  //bond
	    	barrier.phase2();
	    	 
	    }
	    catch (InterruptedException ex) { /* not handling this  */}
	   // System.out.println(" ");
	}

}
