package project4;

public abstract class Airplane {
	protected String make;
	protected String model;
	protected String airline;
	protected String flightNum;
	protected String departure; //city
	protected String arrival; //city
	protected String departureTime;
	protected String arrivalTime;
	protected String status;
	protected static int numPlanes;
	
	//getters:
	public String getMake(){ return make; }
	public String getModel() { return model; }
	public String getAirline() { return airline; }
	public String getFlightNum() { return flightNum; }
	public String getDeparture() { return departure; }
	public String getArrival() { return arrival; }
	public String getDepartureTime() { return departureTime; }
	public String getArrivalTime() { return arrivalTime; }
	public String getStatus() { return status; }
	public static int getNumPlanes() { return numPlanes; }
	
	//setters:	
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//constructors:
	public Airplane (){
		setMake("");
		setModel("");
		numPlanes ++;
	}
	
	public Airplane (String make, String model){
		setMake(make);
		setModel(model);
		numPlanes ++;
	}
	
	public Airplane (String make, String model, String airline, String flightNum){
		setMake(make);
		setModel(model);
		setAirline(airline);
		setFlightNum(flightNum);
		numPlanes ++;
	}

	public int compareTo(Airplane x) {
		
		int arrivalOrder = arrivalTime.compareTo(x.getArrivalTime());
		if (arrivalOrder == 0) 
			return airline.compareTo(x.getAirline());
		return arrivalOrder;
	}
	
	public boolean equals (Object x){ //edit to compare every instance variable of both objects
		if (this == x) return true;
		if (x != null && x instanceof Airplane){
			Airplane somePlane = (Airplane) x;
			if (this.compareTo(somePlane) == 0){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		//the following if statements are used to properly store the departure time for future display:
		int hourD = Integer.parseInt(this.getDepartureTime().substring(this.getDepartureTime().length()-4, this.getDepartureTime().length()-2));
		int printHourD;
		String timeOfDayD = "";
		if (hourD == 0){
			printHourD = 12;
			timeOfDayD = "AM";
		}
		else if(hourD == 12){
			printHourD = 12;
			timeOfDayD = "PM";
		}
		else if(hourD/12 == 0){
			printHourD = hourD;
			timeOfDayD = "AM";
		}
		else{
			printHourD = hourD%12;
			timeOfDayD = "PM";
		}
		
		//the following if statements are used to properly store the arrival time for future display:
		int hourA = Integer.parseInt(this.getArrivalTime().substring(this.getArrivalTime().length()-4, this.getArrivalTime().length()-2));
		int printHourA;
		String timeOfDayA = "";
		
		if (hourA == 0){
			printHourA = 12;
			timeOfDayA = "AM";
		}
		else if(hourA == 12){
			printHourA = 12;
			timeOfDayA = "PM";
		}
		else if(hourA/12 == 0){
			printHourA = hourA;
			timeOfDayA = "AM";
		}
		else{
			printHourA = hourA%12;
			timeOfDayA = "PM";
		}
		
		//here the string to be returned is stored
		String out = getAirline() + ' ' + getFlightNum() + ", " + getDeparture().substring(getDeparture().length()-4, getDeparture().length()-1)
				+ ' ' + getDepartureTime().substring(0, getDepartureTime().length()-5) + ' ' + printHourD + ':' + 
				getDepartureTime().substring(getDepartureTime().length()-2) + ' ' + timeOfDayD + ", " +
				getArrival().substring(getArrival().length()-4, getArrival().length()-1) + ' ' +
				getArrivalTime().substring(0, getArrivalTime().length()-5) + ' ' + printHourA + ':' + 
				getArrivalTime().substring(getArrivalTime().length()-2) + ' ' + timeOfDayA;
		return out;
	}
}
