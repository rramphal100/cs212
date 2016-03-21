package project5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class GUIListener implements ActionListener{
	private GUI gui;
	
	public GUIListener(GUI input){
		gui = input;
	}
	
	
	public void actionPerformed(ActionEvent e){
		String itemName = e.getActionCommand();
		
		if (itemName.equals("Open")){
			while(true){
				try{
					gui.promptForFile();
					break;
				} catch (FileNotFoundException fnfe){
					System.err.println("\nError: File not found. Please try again.\n\n");
				}
			}
			gui.setFilename(); //store the file name in the private string variable in the GUI object
			gui.populateList(); //add the words from the file to the hash map and linked list and displays all the data in the GUI
		}
		else if (itemName.equals("Exit")){
			System.exit(0);
		}
		else if (itemName.equals("Words")){
			//sort the linked list by the data(word)
			gui.sortList();
		}
		
		
	}
}
