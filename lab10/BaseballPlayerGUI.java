package lab10;

import javax.swing.*;
import java.awt.*;

public class BaseballPlayerGUI extends JFrame{
	private Container playerData = getContentPane();
	private BaseballPlayer array[] = new BaseballPlayer[50];
	private int nextIndex = 0; //keeps track of which index is the next empty one to add a new baseball player to
	
	public void add(BaseballPlayer in){
		array[nextIndex] = in;
		nextIndex++;
	}
	
	public BaseballPlayerGUI(String title){
		setTitle(title);
		setSize(400,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setDisplay(boolean in){ 
		setLayout(new GridLayout(1,1));
		
		JTextArea textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		for(int i=0; i<nextIndex; i++){
			String nextPlayer = (array[i].getLastName() + ", " + array[i].getFirstName() + ' ' + array[i].getNumber() + " (" + array[i].getAverage() + ")");
			textArea.append(nextPlayer + "\n");
		}
		textArea.setVisible(true);
		
		playerData.add(scroll);
		
		playerData.setVisible(in);
		this.setVisible(in);
	}
}
