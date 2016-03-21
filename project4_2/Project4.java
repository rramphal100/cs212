package project4_2;

/**
 * Main class to drive this application.
 *<p>
 *Creates a new GUI for the input data stored in the AirplaneController class and has it ready for display modification by the user in this GUI.
 */
public class Project4 {
	public static void main(String[] args){
		AirplaneGUI x = new AirplaneGUI();
		AirplaneController gui = new AirplaneController(x);
		x.setVisible(true);
	}
}