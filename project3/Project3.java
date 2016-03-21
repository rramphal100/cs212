//Ramphal, Ryan
//CS212 Night
//Project 3

package project3;

public class Project3 {
	final static String [][] data = { 
			{"Air Berlin", "4504", "Boeing", "767-300", "Zurich (ZRH)", "New York, NY (JFK)", "2-26 1000", "2-26 1325", "On Time"}, 
			{"Qatar Airways", "212", "Boeing", "767-300", "Milano (MXP)", "New York, NY (JFK)", "2-26 1000", "2-26 1330", "Delayed for 2 Hours"},
			{"Jetblue Airways", "298", "Airbus", "A320", "Tampa, FL (TPA)", "New York, NY (JFK)", "2-26 0728", "2-26 0959", "On Time"}, 					
			{"Air Canada", "6851", "Airbus", "A340-300", "Dakar (DKR)", "New York, NY (JFK)", "2-26 0255", "2-26 0650", "Cancelled"}, 
			{"Alaska Airlines", "1219", "Boeing", "737-800", "Boston, MA (BOS)", "New York, NY (JFK)","2-26 0940", "2-26 1055", "On Time"},
			{"Delta Airlines", "6182", "Canada Air", "CRJ", "Toronto (YYZ)", "New York, NY (JFK)", "2-26 0606", "2-26 0800", "Delayed for 4 Hours"}, 
			{"American Airline", "199", "Boeing", "767-300", "Milano (MXP)", "New York, NY (JFK)", "2-26 1010", "2-26 1330", "Cancelled"},
			{"United Airlines", "9855", "", "", "Cairo (CAI)", "New York, NY (JFK)", "2-26 1025", "2-26 0325", "On Time"}, 
			{"Virgin America", "483", "Airbus", "A320", "San Francisco (SFO)", "New York, NY (JFK)", "2-25 2320", "2-26 0750", "On Time"}, 
			{"Air France", "3650", "Boeing", "767-400", "Barcelona (BCN)", "New York, NY (JFK)", "2-26 1055", "2-26 0158", "On Time"},
			{"Air China", "7266", "Boeing", "757-200", "Los Angeles, CA (LAX)", "New York, NY (JFK)","2-25 2159", "2-26 0616", "On Time"}
		};
	
	public static void main(String[] args){
		int size = data.length;
		Airplane [] array = new Airplane [size];
		
		for (int i=0; i<size; i++){ //loop to store input data into new Airplane array
			String airline = data[i][0];
			String flightnum = data[i][1];
			String make = data[i][2];
			String model = data[i][3];
			String departureCity = data[i][4];
			String arrivalCity = data[i][5];
			String departureTime = data[i][6];
			String arrivalTime = data[i][7];
			String status = data[i][8];
			
			array[i] = new Airplane(make, model, airline, flightnum);
			array[i].setDeparture(departureCity);
			array[i].setArrival(arrivalCity);
			array[i].setDepartureTime(departureTime);
			array[i].setArrivalTime(arrivalTime);
			array[i].setStatus(status);
		}
		
		AirplaneGUI  gui = new AirplaneGUI(array);
		gui.setVisible(true);
		
	}
}
