package lab10;

public class Main {
	public static void main(String[] args){ //creates 2 GUI's to test that multiple instances can be created
		
		//BaseballPlayerGUI gui = new BaseballPlayerGUI("Baseball Players");
		BaseballPlayer x = new BaseballPlayer(5, 0.784, "Alex", "Rodriguez");
		//gui.add(x);
		BaseballPlayer y = new BaseballPlayer(14, 0.468, "Derek", "Jeter");
		//gui.add(y);
		BaseballPlayer z = new BaseballPlayer(27, 0.589, "Sammy", "Sosa");
		//gui.add(z);
		BaseballPlayer a = new BaseballPlayer(34, 0.849, "Curtis", "Granderson");
		//gui.add(a);
		BaseballPlayer b = new BaseballPlayer(40, 0.672, "Robert", "Kennedy");
		//gui.add(b);
		//BaseballPlayer c = new BaseballPlayer(-57, 0.593, "Dummy", "Player 1"); //tests for thrown exception for negative #
		//gui.add(c);
		//BaseballPlayer d = new BaseballPlayer(48, 1.569, "Dummy", "Player 2"); //tests for thrown exception for average over 1.0
		//gui.add(d);
		
		BaseballPlayer.Display();
		
		System.out.println("The amount of BaseballPlayer instances that currently exist is " + BaseballPlayer.getNumBaseballPlayers() + '.');
	}
}