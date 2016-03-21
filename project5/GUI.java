package project5;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.*;


public class GUI extends JFrame{
	private File f;
	private String filename = "";
	private JMenuItem openItem;
	private JMenuItem exitItem;
	private JMenuItem wordsItem;
	private JTextArea textArea;
	private HashMap<String, Integer> map;
	private LinkedList<String> list;
	
	public GUI(){
		GUIListener listener = new GUIListener(this);
		
		setTitle("Random Words HashMap & Sorting");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//makes sure the window is centered at start, may be moved after starting
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2 - 100);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		openItem = new JMenuItem("Open");
		file.add(openItem);
		file.addSeparator();
		exitItem = new JMenuItem("Exit");
		file.add(exitItem);
		menuBar.add(file);
		
		JMenu sort = new JMenu("Sort");
		wordsItem = new JMenuItem("Words");
		setListener(listener);
		sort.add(wordsItem);
		menuBar.add(sort);
		
		Container pane = getContentPane();
		setJMenuBar(menuBar);
		menuBar.setVisible(true);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.CYAN); //change the background color to indicate that the list was now sorted
		
		//display the hash map in this JTextArea
		JScrollPane scrollPane = new JScrollPane(textArea);
		pane.add(scrollPane);
		
		add(scrollPane);
	}
	
	public String getFilename(){ return filename; }
	
	public void setFilename(){
		filename = f.getAbsolutePath();
	}
	
	public void promptForFile() throws FileNotFoundException{
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		f = chooser.getSelectedFile();
		
	}
	
	public void setListener(GUIListener x){
		openItem.addActionListener(x);
		exitItem.addActionListener(x);
		wordsItem.addActionListener(x);
	}
	
	public void populateList(){
		map = new HashMap<String, Integer>();
		
		//use these to check if each of the words is valid (contains no bad chars. if so, print it as an error to console!)
		String spaces = "\\s+"; //use string.split() with this regex code that separates by spaces4
		String lastChar = "\\w+\\W"; //checks for error char at the end of a single word
		String firstChar = "\\W\\w+"; //checks for error char at the beginning of a single word
		String midChar = "\\w+\\W+\\w+"; //checks for error char in the middle of a single word
		String invalidChar = "\\W*[a-z]*(é|ì|ò|ù|á|í|ó|ú|ñ|Ñ|à|è)+[a-z]*\\W*"; //checks for invalid letter chars in any part of a word (ex. é, á, etc.)
		
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filename));
				String in; //holds a single line of input from the file
				while(true){
					in = reader.readLine(); //read the next line of the input file
					if (in == null){ //stop working on this when you've reached the end of the input file
						reader.close();
						break;
					}
					//put each match into the hash map
					String[] separate = in.split(spaces); 
					//check w/ 2 regex syntaxes: spaces for splitting by spaces, valid for filtering out those w/ wrong chars
					for (String w : separate){
						//the following if statements work with each of the words accordingly. words with bad chars in the middle are output
						//to the console. those with errors at the end such that the errors are non-letter errors (!,*&, etc.) are added to 
						//the hash map without the error char at either end.
						//those with bad chars that are types of letters in any part of the word are just output to console and 
						//not added to the map
						String copy = w;
						boolean check = false;
						while(true){
							if (w.matches(invalidChar)){
								//print error and don't add to list if this word has an illegal letter anywhere in it
								System.err.println("Error Entry: " + w);
								break;
							}
							else if (w.matches(midChar)){
								//print error and don't add to list if this word has an illegal char in the middle
								System.err.println("Error Entry: " + w);
								break;
							}
							else if(copy.matches(lastChar)){ 
								//checks if a word contains a non-letter error character (ex. filters "wow!" but not "wow") as the last char
								copy = copy.substring(0, copy.length()-1);
								check = true;
								continue;
							}
							else if (w.matches(firstChar)){
								//checks if a word contains a non-letter error character (ex. filters "!wow" but not "wow") as the first char
								copy = copy.substring(1);
								check = true;
								continue;
							}
							
							else {
								if (check == true){ //if an error was deleted from the original word, print the error message for that word
									System.err.println("Error Entry (Corrected and added to map): " + w);
								}
								insertInMap(map, copy.toLowerCase()); //this makes sure that there are no duplicate entries based on case
								//inserts the corrected form of the valid words into the hash map
								break;
							}
						}
					}
				}
			} catch (FileNotFoundException e) {
				System.err.println("Error: File not found.");
				System.exit(1);
			} catch (IOException e){
				System.err.println("Error: Bad input.");
				System.exit(1);
			} catch (NullPointerException e){
				System.err.println("Error: Null Pointer Exception thrown.");
				System.exit(1);
			}
		
		//put the hash map into a linked list
		
		list = new LinkedList<String>();
		for (String w : map.keySet()){
			list.add(w + ": " + map.get(w));
		}
		
		//add the linked list's elements to the JTextArea of the GUI
		String listData = ""; //stores all of the linked list's data as a single string to put into the GUI
		for (int i = 0; i < list.size(); i++){
			listData += list.get(i) + "\n";
		}
		textArea.setText(listData); //adds the linked list's data to the GUI
		textArea.setVisible(true); //makes the data actually show in the GUI
		
		
		
	}
	
	public static void insertInMap(HashMap<String, Integer> x, String in){
		if (x.get(in) != null){
			x.put(in, x.get(in) + 1);
		}
		else {
			x.put(in, new Integer(1));
		}
	}
	
	public void sortList(){
		//Creates a new LinkedList that is a lexicographically sorted version of the old linked list, sets it as the
		//new valid linked list for the GUI, and displays it in the GUI.
		//Executed when the user clicks "words" in the sort menu of the GUI.
		LinkedList<String> newList = new LinkedList<String>();
		while(list.size() > 0){
			String current = list.getFirst(); //keeps track of the lexicographically lowest element in the linked list
			int currentIndex = 0;
			for (int i = 0; i < list.size(); i++){
				if(list.get(i).compareTo(current) < 0){
					current = list.get(i);
					currentIndex = i;
				}
			}
			newList.add(current);
			list.remove(currentIndex);
		}
		//set the new list as the new official list of this GUI and make it visible
		list = newList;
		String listData = ""; //stores all of the linked list's data as a single string to put into the GUI
		for (int i = 0; i < list.size(); i++){
			listData += list.get(i) + "\n";
		}
		textArea.setText(listData); //adds the linked list's data to the GUI
		textArea.setBackground(Color.GREEN);
		textArea.setVisible(true); //makes the data actually show in the GUI
	}
}
