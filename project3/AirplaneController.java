//Ramphal, Ryan
//CS212 Night
//Project 3

package project3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AirplaneController implements ActionListener{
	AirplaneGUI gui;
	
	public AirplaneController(AirplaneGUI apgui){
		gui = apgui;
	}
	
	@Override
	public void actionPerformed(ActionEvent event){
		String buttonName = event.getActionCommand();
		
		//each of the following lines sets the respective field's display value to the opposite of what it was before (display on/off buttons)
		if (buttonName.equals("Append")){
			gui.areaVisible(gui.getAppendScroll(), !gui.getAppendState());
			gui.setAppendState(!gui.getAppendState());
		}
		else if (buttonName.equals("Prepend")){
			gui.areaVisible(gui.getPrependScroll(), !gui.getPrependState());
			gui.setPrependState(!gui.getPrependState());
		}
		else if (buttonName.equals("Insert")){
			gui.areaVisible(gui.getInsertScroll(), !gui.getInsertState());
			gui.setInsertState(!gui.getInsertState());
		}
	}
}
