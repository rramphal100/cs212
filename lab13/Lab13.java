package lab13;

import java.io.*;

public class Lab13 {
	public static void main(String[] args){
		String filename = args[0];
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader("input.txt"));
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null){
				System.out.println(i + " : " + line + " --->");
				String[] lineArray = line.split(",");
				for (String word : lineArray) //this for each loop iterates thru the entire length of the array lineArray
					System.out.print(word + " ");
				System.out.println();
				i++;
			}
		} catch (FileNotFoundException fnf){
			
		} catch (IOException ioe){
			
		}
		
	}
}
