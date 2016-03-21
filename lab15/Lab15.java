package lab15;

import java.util.StringTokenizer;
import java.io.File;

public class Lab15 {
	public static void main(String[] args){
		String line = "Today,is,hot";
		
		String[] words = line.split(",");
		for (String w : words) System.out.println(w);
		
		System.out.println("\n\nStringTokenizer: ");
		StringTokenizer tokens = new StringTokenizer(line, ",");
		
		int size = tokens.countTokens();
		while (tokens.hasMoreTokens()){
			String w = tokens.nextToken();
			System.out.println(w);
		}
	}
}
