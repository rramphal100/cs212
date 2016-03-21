package project4_2;

/**
 * Object that contains an Airplane object and a pointer to another node.
 * <p>
 * Purpose is to link several nodes together to make an AirplaneList to store all the different Airplane objects in a list
 *
 */
public class AirplaneNode {
	
	private Airplane data;
	private AirplaneNode next;
	
	/**
	 * constructor that sets all data values to null
	 */
	public AirplaneNode(){
		this(null, null);
	}
	
	/**
	 * Constructor that sets data value to parameter Airplane object.
	 * @param a
	 */
	public AirplaneNode(Airplane a){
		this(a, null);
	}
	
	/**
	 * 
	 * @param a
	 * @param n
	 * Constructor that sets the instance variables equal to the parameter values.
	 */
	public AirplaneNode(Airplane a, AirplaneNode n){
		data = a;
		next = n;
	}
	
	public void setNext(AirplaneNode n){
		next = n;
	}
	
	public AirplaneNode getNext(){
		return next;
	}
	
	public Airplane getData(){
		return data;
	}
	
	public void setData(Airplane airplane){
		data = airplane;
	}
}