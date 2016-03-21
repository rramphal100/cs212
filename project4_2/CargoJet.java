package project4_2;

/**
 * 
 *Creates a CargoJet object. This class is a child of the abstract class Airplane.
 */
public class CargoJet extends Airplane{
	
	private int totalMass = Integer.parseInt(this.number) ;
	private static int numOfCargoJets = 0;
	
	/**
	 * 
	 * @param jetType
	 * @param airline
	 * @param flightNumber
	 * @param make
	 * @param model
	 * @param departureCity
	 * @param arrivalCity
	 * @param departureTime
	 * @param arrivalTime
	 * @param number //stores the data for an arbitrary plane. Unit of measure is set by type of plane in that respective child class.
	 */
	public CargoJet(String jetType, String airline, String flightNumber, String make, String model, String departureCity, String arrivalCity, String departureTime, String arrivalTime, String number){
		super(jetType, airline, flightNumber, make, model, departureCity, arrivalCity, departureTime, arrivalTime, number);
		numOfCargoJets++;
	}
	
	/**
	 * @return int
	 * returns an integer that represents the relative positioning of this with the parameter airplane object.
	 * The returned int's value (+, -, or 0) represents the proper position of this with respect to the parameter in a list. 
	 */
	@Override
	public int compareTo(Airplane other){
		return number.compareTo(other.getNumber());
	}
	
	/**
	 * @return String
	 * Returns a string that contains all the data for the this CargoJet.
	 */
	public String toString(){
		return airline + " " + flightNumber + " " + ": " + number + " kg";
	}
	
}