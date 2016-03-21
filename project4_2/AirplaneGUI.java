package project4_2;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Creates a new User Interface particularly for working with Airplane objects and for displaying them with AirplaneLists.
 *
 */
public class AirplaneGUI extends JFrame{
	
	
	JMenuItem[] items = new JMenuItem[6];
	JTextArea textArea = new JTextArea();
	/**
	 * Constructor with default window size, functionality, etc.
	 */
	public AirplaneGUI(){
		setTitle("Flight Schedule");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMenuItems();
		setupDisplayPanel();
		setLayout(new GridLayout());
		setVisible(true);
	}
	
	/**
	 * Creates the standard menu for this GUI
	 */
	public void setMenuItems(){
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("File");
		JMenu menu2 = new JMenu("Filter");
		items[0] = new JMenuItem("Start"); 
		items[1] = new JMenuItem("Clear");
		items[2] = new JMenuItem("Exit");
		items[3] = new JMenuItem("Passenger");
		items[4] = new JMenuItem("Business");
		items[5] = new JMenuItem("Cargo");
		menu1.add(items[0]);
		menu1.add(items[1]);
		menu1.add(items[2]);
		menu2.add(items[3]);
		menu2.add(items[4]);
		menu2.add(items[5]);
		menuBar.add(menu1);
		menuBar.add(menu2);
		setJMenuBar(menuBar);
	}
	
	/**
	 * Creates the overall gui appearance and functionality with a JScrollPane and prevents editing by the user.
	 */
	public void setupDisplayPanel(){
		textArea.add(new JScrollPane());
		textArea.setEditable(false);
		add(textArea);
	}
	
	/**
	 * 
	 * @param a //makes this Actionlistener (in this case the AirplaneController object) have control over the gui's contents' functionality.
	 */
	public void setButtonListener(ActionListener a) {
		for(int i = 0; i< 6; i++){
			items[i].addActionListener(a);
		}
	}
	
	/**
	 * 
	 * @param result
	 * stores the finished data into the gui for proper displaying as a string.
	 */
	public void displayList(String result) {
		textArea.setText(result);
	}
	
}