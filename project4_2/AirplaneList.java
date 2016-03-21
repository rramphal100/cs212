package project4_2;

/**
 * 
 *Creates a Linkedlist of Airplane objects.
 */
public class AirplaneList {
	
	private AirplaneNode head;
	
	public AirplaneList(){
		head = new AirplaneNode();
	}
	
	/**
	 * 
	 * @param airplane
	 * inserts the parameter airplane into an existing AirplaneList object
	 */
	public void insert(Airplane airplane){
		if(head.getNext()==null)
		{
			head.setNext(new AirplaneNode(airplane));
		}
		else{
			AirplaneNode current = head.getNext();
			AirplaneNode previous = head;
			while(current!=null){
				
				if(current.getData().getAirline().compareTo(airplane.getAirline())>=0){
					previous.setNext(new AirplaneNode(airplane));
					previous.getNext().setNext(current);
					break;
				}
				else{
					if(current.getNext()==null){
						current.setNext(new AirplaneNode(airplane));
						break;
					}
					else{
						previous = current;
						current = current.getNext();
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @param list
	 * prints out the parameter list to the console
	 */
	public void print(AirplaneNode list){
		while(list.getNext()!=null){
			System.out.println(list.getData().toString());
			list = list.getNext();
		}
	}
	
	public AirplaneNode getFirst(){
		return head;
	}
	
	/**
	 * Prints the parameter AirplaneList as a string with all the data for all the list's planes.
	 */
	public String toString() {
		String result = "";
		AirplaneNode current = head.getNext();
		while (current != null) {
			result += current.getData().toString() +"\n";
			current = current.getNext();
		}
		return result;
	}
	
	/**
	 * 
	 * @param type //the type of planes to print (doesn't print those of not this type)
	 * @return String
	 * returns a string with the data for all planes in the this list for only that parameter type
	 */
	public String printByType(String type){
		AirplaneNode current = head.getNext(); 
		String str = "";
		while(current!=null){
			if(current.getData().getJetType().equals(type))
				str += current.getData().toString() +"\n";			
			
			current = current.getNext();
		}
		return str;
	}
	
	/**
	 * Makes an AirplaneList object empty by deleting the head node.
	 */
	public void clear(){
		head = null;
	}
}