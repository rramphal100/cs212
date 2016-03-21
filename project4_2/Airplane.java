package project4_2;

/**
 * 
 * This class makes a single airplane object that holds all the typical information
 * for a single airplane object.
 * <p>
 * Airplanes have types that are instantiated by this class' children classes.
 *
 */
public abstract class Airplane {
	
	protected String jetType, make, model, airline, flightNumber, departureCity, arrivalCity, departureTime, arrivalTime, number;
	protected static int numOfPlanes = 0;
	
	/**
	 * 
	 * @param jetType //stores the type (JetAirliner = P, BusinessJet = B, CargoJet = C)
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
	public Airplane(String jetType, String airline, String flightNumber, String make, String model, String departureCity, String arrivalCity, String departureTime, String arrivalTime, String number){
		this.jetType = jetType;
		this.airline = airline;
		this.flightNumber = flightNumber;
		this.make = make;
		this.model = model;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.number = number;
		numOfPlanes++;
	}
	
	/**
	 * 
	 * @param other //an airplane that will be compared to this for order of sorting
	 * @return int
	 * returns the integer value that represents relative position of the parameter and calling plane objects 
	 * (negative if this is before parameter, 0 if they're the same, positive if this is after parameter)
	 */
	public int compareTo(Airplane other){
		if(airline.compareTo(other.getAirline())==0)
			return flightNumber.compareTo(other.getFlightNumber());
		return flightNumber.compareTo(other.getFlightNumber());
	};
	
	public abstract String toString();

	public String getJetType() {
		return jetType;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getAirline() {
		return airline;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public String getNumber() {
		return number;
	}

	public static int getNumOfPlanes() {
		return numOfPlanes;
	}

	public void setJetType(String jetType) {
		this.jetType = jetType;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setTypeOfPlane(String number) {
		this.number = number;
	}

	public static void setNumOfPlanes(int numOfPlanes) {
		Airplane.numOfPlanes = numOfPlanes;
	}
	
}
