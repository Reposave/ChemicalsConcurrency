package molecule;

public class Hydrogen extends Thread {

	private static int hydrogenCounter = 0;
	private int id;
	private Propane sharedPropane;
	public static BarrierReusable barrier =  new BarrierReusable(8); //8 hydrogen atoms in Propane.; // all atoms must be at the barrier
	
	public Hydrogen(Propane propane_obj) {
		Hydrogen.hydrogenCounter+=1;
		id=hydrogenCounter;
		this.sharedPropane = propane_obj;
		
	}
	
	public void run() {
	    try {
	    	 // you will need to fix below
	    	
	    	barrier.phase1(); //Only 8 hydrogens at a time are allowed through.
	    	System.out.println(this.id + " hydrogen through.");
	    	sharedPropane.barrier.b_wait();
	    	sharedPropane.addHydrogen();			 
	    	sharedPropane.bond("H"+ this.id);
	    	barrier.phase2();
	    }
	   catch (InterruptedException ex) { /* not handling this  */}
	    //System.out.println(" ");
	}

}
