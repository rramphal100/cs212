package lab11;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Container;

public class Lab11 {
	public static void main(String[] args){
		String line = "This,is,a,line,separated,by,commas";
		String newline = "aAaAaBa";
		String[] lineArray = line.split(",");
		System.out.print(line);
		for (int i = 0; i<lineArray.length; i++){
			System.out.println(lineArray[i]);
		}
		
		createMenuBar();
		
	}
	
	public static void createMenuBar(){
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		menu.addSeparator();
		JMenuItem closeItem = new JMenuItem("Close");
		menu.add(closeItem);
		menuBar.add(menu);
		
		Container pane = frame.getContentPane();
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}
}
