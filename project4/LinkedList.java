package project4;

import project3.Airplane;
import project3.Node;

public class LinkedList {
	private Node first;
	private Node last;
	private int length = 0;
	
	public LinkedList(){
		first = null;
		last = null;
	}
	
	public LinkedList(Node n){
		first = n;
		last = n;
		length++;
	}
	
	public LinkedList(Airplane x){
		first = new Node(x);
		last = first;
		length++;
	}
	public void append(Airplane x){
		Node current = new Node(x);
		if (first == null){
			first = current;
			last = current;
			length++;
			return;
		}
		last.setNext(current);
		last = current;
		length++;
	}
	
	public void prepend(Airplane x){
		Node current = new Node (x);
		if (first == null){
			first = current;
			last = first;
			length++;
			return;
		}
		current.setNext(first);
		first = current;
		length++;
	}
	
	/* old toString method
	public String toString(){
		Node current = first;
		String out = "";
		while(current!=null){
			out += current.getData().toString() + "\n";
			current = current.getNext();
		}
		return out;
	}*/
	
	public String toString(){
		Node current = first;
		if (current.getNext() == null) return current.getData().toString();
		while(current.getNext() != null){
			return current.getData().toString() + current.getNext().toString();
		}
	}

	public void insert(Airplane x){
		if (first == null){
			first = new Node(x);
			last = first;
		}
		else if (x.compareTo(last.getData()) < 0){
			Node current= first;
			while(current.getNext() != null){
				if (current.getNext().getData().compareTo(x) > 0) {
					Node in = new Node(x);
					in.setNext(current.getNext());
					current.setNext(in);
					break;
				}
				else current = current.getNext();
			}
		}
		else {
			last.setNext(new Node(x));
			last = last.getNext();
		}
		
		length++;
	}
}
