//Ramphal, Ryan
//CS212 Night
//Project 3

package project3;

import javax.swing.*;
import java.awt.*;

public class AirplaneGUI extends JFrame{
	private boolean appendState = false;
	private boolean prependState = false; //these boolean flags store whether or not to display each of the respective fields in the GUI
	private boolean insertState = false;
	
	private JScrollPane appendScroll;
	private JScrollPane prependScroll; //the 3 scroll panes to display all the output data in the GUI
	private JScrollPane insertScroll;
	
	//getters and setters for each private variable
	public boolean getAppendState(){return appendState;}
	public boolean getPrependState(){return prependState;}
	public boolean getInsertState(){return insertState;}
	
	public void setAppendState(boolean in){appendState = in;}
	public void setPrependState(boolean in){prependState = in;}
	public void setInsertState(boolean in){insertState = in;}
	
	
	public JScrollPane getAppendScroll(){return appendScroll;}
	public JScrollPane getPrependScroll(){return prependScroll;}
	public JScrollPane getInsertScroll(){return insertScroll;}
	
	public void setAppendScroll(JScrollPane in){appendScroll = in;}
	public void setPrependScroll(JScrollPane in){prependScroll = in;}
	public void setInsertScroll(JScrollPane in){insertScroll = in;}
	
	public AirplaneGUI(Airplane[] array){
		
		AirplaneController controller = new AirplaneController(this);
		
		setTitle("Flight Schedule");
		setSize(800,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(1,4));
		Container pane = getContentPane();
		
		Container buttons = new Container(); //adds the 3 buttons to the left side of the GUI
		buttons.setLayout(new GridLayout(3,1));
		
		Button append = new Button("Append");
		append.addActionListener(controller);
		buttons.add(append);
		
		Button prepend = new Button("Prepend");
		prepend.addActionListener(controller);
		buttons.add(prepend);
		
		Button insert = new Button("Insert");
		insert.addActionListener(controller);
		buttons.add(insert);
		
		buttons.setVisible(true);
		pane.add(buttons);
		
		String data[] = new String[3]; //string array that holds display for append, prepend, and insert, respectively
		
		
		LinkedList Append = new LinkedList(); //stores the data for the append button display
		for (int i = 0; i < array.length; i++){
			Append.append(array[i]);
		}
		String app = "Append:\n\n" + Append.toString();
		data[0] = app;
		
		LinkedList Prepend = new LinkedList(); //stores the data for the prepend button display
		for (int i = 0; i < array.length; i++){
			Prepend.prepend(array[i]);
		}
		data[1] = new String("Prepend:\n\n" + Prepend.toString());
		
		LinkedList Insert = new LinkedList(); //stores the data for the insert button display
		for (int i = 0; i < array.length; i++){
			Insert.insert(array[i]);
		}
		data[2] = new String("Insert:\n\n" + Insert.toString());
		
		
		JTextArea [] textAreas = new JTextArea[3]; //inserts the stored data into the GUI
		JScrollPane [] scroll = new JScrollPane[3];
		for (int i = 0; i < 3; i++){
			textAreas[i] = new JTextArea(data[i]); //stores the data for each of append, prepend, and insert buttons, respectively
			textAreas[i].setEditable(false); //can't edit the displayed data
			scroll[i] = new JScrollPane(textAreas[i]);
		}
		
		//store the data into the private variables that can be passed into the GUI controller class:
		setAppendScroll(scroll[0]);
		setPrependScroll(scroll[1]);
		setInsertScroll(scroll[2]);
		
		pane.add(getAppendScroll());
		getAppendScroll().setVisible(false);
		
		pane.add(getPrependScroll());
		getPrependScroll().setVisible(false);
		
		pane.add(getInsertScroll());
		getInsertScroll().setVisible(false);
	}
	
	public void areaVisible(JScrollPane in, boolean value){ //this will change whether or not each field is displayed based on the button pressed
		in.setVisible(value);
	}
}
