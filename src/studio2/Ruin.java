package studio2;

public class Ruin {

	public static void main(String[] args) {
		
		
		
		boolean random;
		double winLimit = 15;
		int totalSimulations = 15;
		int count = 0;
		int ruin = 0;
		double winChance = 0.5;
		double expectedRuin;
		double startAmount = 10;
		
		for(int i=1;i<=totalSimulations;i++) {
		double restartAmount = startAmount;
		while(restartAmount < winLimit && restartAmount > 0) {
			random = Math.random()>winChance;
			if(random == true) {
				restartAmount++;
				count++;
			}else {
				restartAmount--;
				count++;
			}
			
		}
		
		if(restartAmount >= winLimit) {
			System.out.println("Day "+i);
			System.out.println("Number of plays: "+count);
			System.out.println("You win!");
		}else {
			System.out.println("Day "+i);
			System.out.println("Number of plays: "+count);
			System.out.println("Ruin");
			ruin++;
		}
		}
		double ruinRate = ((double)ruin/totalSimulations)*100;
		System.out.println("The percentage of simulations that resulted in ruin: " + Math.round(ruinRate) + "%");
		if(winChance == 0.5) {
			expectedRuin = (1-(startAmount/winLimit))*100;
			System.out.println("Expected percentage of simulations that result in ruin: "+expectedRuin+"%");
		}else {
			double a = (1-winChance)/winChance;
			System.out.println(a);
			expectedRuin = (Math.pow(a, startAmount) - Math.pow(a, winLimit)) / (1-Math.pow(a, winLimit));
			System.out.println("Expected percentage of simulations that result in ruin: "+expectedRuin*100+"%");
		}
	}

}
