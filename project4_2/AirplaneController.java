package project4_2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI controller class that implements ActionListener abstract class for control of UI for this application.
 *
 */
public class AirplaneController implements ActionListener{

	final static String[] DATA = 
		{"C,AmeriJet International,6391,Airbus,A330-200F,Hong Kong (HKG),New York (JFK),2-28 0100,2-28 0600,70000",
		"P,Air Berlin,4504,Boeing,767-300,Zurich (ZRH),New York (JFK),2-26 1000,2-26 1325,370",
		"P,Virgin America,483,Airbus,A320,San Francisco (SFO),New York (JFK),2-25 2320,2-26 0750,350",
		"P,American Airline,199,Boeing,767-300,Milano (MXP),New York(JFK),2-26 1010,2-26 1330,375",
		"C,AmeriJet International,6182,Boeing,747,Los Angeles (LAX),New York (JFK),2-27 1100,2-27 1400,120000",
		"B,Jetsuite,212, Boeing,737-800,New York (JFK),Los Angeles (LAX),2-25 1000,2-25 1400,10",
		"B,Jetsuite,289, Boeing,737-400,New York (JFK),Toronto (YYZ),2-28 1000,2-28 1700,30",
		"B,Jetsuite,291,Challenger,600,Boston (BOS),New York(JFK),2-24 1100,2-24 1300,15"
		};
	final String START = "START";
	final String CLEAR = "CLEAR";
	final String EXIT = "EXIT";
	final String PASSENGER = "P";
	final String BUSINESS = "B";
	final String CARGO = "C";

	AirplaneGUI gui;
	
	/**
	 * Constructor of controller object
	 * @param g
	 */
	public AirplaneController(AirplaneGUI g) {
		gui = g;
		gui.setButtonListener(this);
	}

	/**
	 * Lists what to do for each possible button's function if one of them is clicked.
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		String buttonName = e.getActionCommand();
		if(buttonName.equals("Passenger")){
			createList(PASSENGER);
		} else if(buttonName.equals("Business")){
			createList(BUSINESS);
		} else if(buttonName.equals("Cargo")){
			createList(CARGO);
		} else if(buttonName.equals("Start")){
			createList(START);
		} else if(buttonName.equals("Clear")){
			createList(CLEAR);
		} else if(buttonName.equals("Exit")){
			System.exit(0);
		}
	}

	/**
	 * 
	 * @param type //stores the type of airplane for which to make an Airplanelist of (doesn't add planes of not this type to the list)
	 */
	public void createList(String type){
		AirplaneList list = new AirplaneList();

		for(int i = 0; i < DATA.length; i++){
			String[] lineArray = DATA[i].split(",");
			String jetType = lineArray[0];
			String airline = lineArray[1];
			String flightNumber = lineArray[2];
			String make = lineArray[3];
			String model = lineArray[4];
			String departureCity = lineArray[5];
			String arrivalCity = lineArray[6];
			String departureTime = lineArray[7];
			String arrivalTime = lineArray[8];
			String number = lineArray[9];
			
			Airplane airplane = null;
			if(jetType.equals("C")){
				airplane = new CargoJet(jetType, airline, flightNumber, make, model, departureCity, arrivalCity, departureTime, arrivalTime, number);
			}else if(jetType.equals("P")){
				airplane = new JetAirliner(jetType, airline, flightNumber, make, model, departureCity, arrivalCity, departureTime, arrivalTime, number);
			}else if(jetType.equals("B")){
				airplane = new BusinessJet(jetType, airline, flightNumber, make, model, departureCity, arrivalCity, departureTime, arrivalTime, number);
			} 

			list.insert(airplane);
		}
		
		switch (type) {
		case "START":
			gui.displayList(list.toString());
			break;
		
		case "CLEAR":
			gui.displayList("");
			list.clear();
			break;

		default:
			gui.displayList(list.printByType(type));
			break;
		
		}
	}

}