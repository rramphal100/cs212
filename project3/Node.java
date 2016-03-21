//Ramphal, Ryan
//CS212 Night
//Project 3

package project3;

public class Node {
	private Airplane data;
	private Node next;
	
	public Node(){
		data = null;
		next = null;
	}
	
	public Node(Airplane plane){
		data = plane;
		next = null;
	}
	
	public Node(Airplane plane, Node n){
		data = plane;
		next = n;
	}
	
	public Airplane getData(){return data;}
	public void setData(Airplane x){data = x;}
	
	public Node getNext(){return next;}
	public void setNext(Node n){next = n;}
	
	public String toString(Node x){
		return x.getData().toString();
	}
}