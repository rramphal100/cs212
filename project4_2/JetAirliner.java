package project4_2;

/**
 * Creates a JetAirliner object that is a child of Airplane class
 *
 */
public class JetAirliner extends Airplane{
	
	private int numberOfPassengers = Integer.parseInt(this.number);
	private static int numOfJetAirliners = 0;
	
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
	public JetAirliner(String jetType, String airline, String flightNumber, String make, String model, String departureCity, String arrivalCity, String departureTime, String arrivalTime, String number){
		super(jetType, airline, flightNumber, make, model, departureCity, arrivalCity, departureTime, arrivalTime, number);
		numOfJetAirliners++;
	}
	
	/**
	 * @param other //Airplane object that is compared to this for order of sorting
	 * @return int (+, -, and 0 represent the different positions of the two)
	 */
	@Override
	public int compareTo(Airplane other){
		if(airline.compareTo(other.getAirline()) == 0)
			return flightNumber.compareTo(other.getFlightNumber());
		return flightNumber.compareTo(other.getFlightNumber());
	}
	
	/**
	 * prints a JetAirliner's data as a string
	 */
	public String toString(){
		return airline + " " + flightNumber + " " + ": " + number + " p";
	}
	
}
