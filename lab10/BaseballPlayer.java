package lab10;

public class BaseballPlayer {
	private int number;
	private float battingAverage;
	private String firstName;
	private String lastName;
	private static BaseballPlayerGUI display = new BaseballPlayerGUI("Baseball Players");
	
	private static int numBaseballPlayers = 0;
	
	public BaseballPlayer(int num, double avg, String first, String last){
		if (num < 0) throw new IllegalArgumentException("Error: Player number cannot be negative.");
		else number = num;
		
		if (avg < 0 || avg > 1) throw new IllegalArgumentException("Error: Batting average must be between 0 and 1.");
		else battingAverage = (float)avg;
		
		firstName = first;
		lastName = last;
		
		display.add(this);
		
		numBaseballPlayers++;
	}
	
	public int getNumber(){ return number;}
	public float getAverage(){ return battingAverage;}
	public String getFirstName(){ return firstName;}
	public String getLastName(){ return lastName;}
	
	public static void Display(){
		display.setDisplay(true);
	}
	
	public static int getNumBaseballPlayers(){
		return numBaseballPlayers;
	}
}
