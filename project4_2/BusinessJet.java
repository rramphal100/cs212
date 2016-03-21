package project4_2;

/**
 * 
 *Creates a BusinessJet object. This class is a child of the abstract class Airplane.
 */
public class BusinessJet extends Airplane{
	
	private int numberOfPassenger = Integer.parseInt(this.number);
	private static int numOfBusinessJets = 0;
	
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
	public BusinessJet(String jetType, String airline, String flightNumber, String make, String model, String departureCity, String arrivalCity, String departureTime, String arrivalTime, String number){
		super(jetType, airline, flightNumber, make, model, departureCity, arrivalCity, departureTime, arrivalTime, number);
		numOfBusinessJets++;
	}
	
	/**
	 * Compares this to the parameter plane to determine the order in which they should appear in a list (+, -, and 0 values represent 
	 * the respective positioning of this in comparison to the parameter).
	 */
	@Override
	public int compareTo(Airplane other){
		if(airline.compareTo(other.getAirline()) == 0)
			return flightNumber.compareTo(other.getFlightNumber());
		return flightNumber.compareTo(other.getFlightNumber());
	}
	
	/**
	 * returns a string with all the data of the this BusinessJet's data.
	 */
	public String toString(){
		return airline + " " + flightNumber + " " + ": " + number + " p";
	}
	
}
