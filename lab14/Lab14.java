package lab14;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;


public class Lab14 {

	public static void main(String[] args) {
		
//		String line = "This       is      a      cat";
//		String[] words = line.split("\\s+");
//		for (int i = 0; i < words.length; i++)
//			System.out.print(words[i] + " : " + words[i].length() + "\t");
//		System.out.println();
//		for (String w : words)
//			System.out.print(w +  " : " + w.length() + "\t");
//		
//		System.out.println("\n\n");
		createMap();
		System.out.println("\n\n");
		//createList();

	}
	
	public static void createMap() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		map.put("chocolate", new Integer(5));
		System.out.println ("chocolate : " + map.get("chocolate"));
		map.put("chocolate", new Integer(10));
		map.put("cotton", new Integer(3));
		System.out.println ("chocolate : " + map.get("chocolate"));
		System.out.println("map size : " + map.size());

		System.out.println("KeySet : " + map.keySet().toString());
		for (String key : map.keySet()) {
			System.out.println (key + " : " + map.get(key));
		}
	}
	
	public static void createList() {

		LinkedList<Integer> numList = new LinkedList<Integer>();
		Integer a = new Integer(7) + 9;
		System.out.println("a : " + a);
		numList.add(new Integer(7));
		numList.add(new Integer(8));
		numList.add(a);
		System.out.println("Unsorted List: " + numList.toString());
		Collections.sort(numList);
		System.out.println("Sorted List: " + numList.toString());	
		
	}
}