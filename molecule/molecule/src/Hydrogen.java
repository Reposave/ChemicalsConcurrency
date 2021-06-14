package molecule;

public class Hydrogen extends Thread {

	private static int hydrogenCounter =0;
	private int id;
	private Propane sharedPropane;
	public BarrierReusable barrier; // all atoms must be at the barrier
	
	public Hydrogen(Propane propane_obj) {
		this.barrier=new BarrierReusable(8); //8 hydrogen atoms in Propane.
		Hydrogen.hydrogenCounter+=1;
		id=hydrogenCounter;
		this.sharedPropane = propane_obj;
		
	}
	
	public void run() {
	    try {
	    	 // you will need to fix below
	    	System.out.println("---Group ready for bonding---");
	    	barrier.b_wait();
	    	sharedPropane.barrier.b_wait();	
	    	sharedPropane.addHydrogen();			 
	    	sharedPropane.bond("H"+ this.id);
	    }
	   catch (InterruptedException ex) { /* not handling this  */}
	    //System.out.println(" ");
	}

}
