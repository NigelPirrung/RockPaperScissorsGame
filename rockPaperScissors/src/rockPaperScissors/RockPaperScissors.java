package rockPaperScissors;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
													
public class RockPaperScissors {
	
	public int userWinningCounter, opponentWinningCounter, totalGameCounter;
	public static Scanner input = new Scanner(System.in);
	private static RockPaperScissors game = new RockPaperScissors();
	
	
	public static void main(String[] args) {
		
		int menuChoice = game.displayMenu();
		
		while (menuChoice != 3) {
		
			switch (menuChoice) {
			case 1:
				System.out.print("\nPlease enter your choice (R,P,S): ");
				String userInput = input.next().toUpperCase();
				game.play(userInput);
			break;
			case 2:
				while(game.userWinningCounter !=3 && game.opponentWinningCounter != 3) {
					
					System.out.println("\nScoreboard: \nYour Score: " + game.userWinningCounter + "\t Your opponent Score: " + game.opponentWinningCounter);
					System.out.print("\nPlease enter your choice (R,P,S): ");
					userInput = input.next().toUpperCase();
				
					game.play(userInput);
				}
				
				if(game.userWinningCounter ==3) {
					System.out.println("\nCongrats! you won the match!");
				}

				if(game.opponentWinningCounter == 3) {
					System.out.println("\nSadly you lost the match");
				}
				
			break;
			case 3:
				System.exit(0);
			break;
			}
			menuChoice = game.displayMenu();
		}
	}
	
	
	public int displayMenu() {
		System.out.println("\nWelcome to the game Rock, Paper, Scissors!");
		System.out.println("1. Play one game \n2. Play a best of 5\n3. Exit\nPlease select an option: ");
		int menuChoice = input.nextInt();
		return menuChoice;
	}
	
	public void play(String userInput) {
		
		List<String> choices = new ArrayList<>();
		choices.add("R");
		choices.add("P");
		choices.add("S");
		
		Random rand = new Random();
		String opponentChoice = choices.get(rand.nextInt(choices.size()));
		
		System.out.println("Your opponent chose: " + opponentChoice);
		boolean opponentWon = false ,userWon = false;
		
		switch(userInput) {
		case "R":
			
			if(opponentChoice.equals("R")) {
				System.out.println("There was a Draw");
			}
			
			if(opponentChoice.equals("P")) {
				System.out.println("Your opponent Won");
				opponentWon = true;
			}
			
			if(opponentChoice.equals("S")) {
				System.out.println("You Won!" );
				userWon = true;
			}	
		break;
		case "P":
			
			if(opponentChoice.equals("R")) {
				System.out.println("You Won!");
				userWon = true;
			}
			
			if(opponentChoice.equals("P")) {
				System.out.println("There was a Draw");
			}
			
			if(opponentChoice.equals("S")) {
				System.out.println("Your opponent Won");
				opponentWon = true;
			}
		break;
		case "S":
			
			if(opponentChoice.equals("R")) {
				System.out.println("Your opponent Won");
				opponentWon = true;
			}
			
			if(opponentChoice.equals("P")) {
				System.out.println("You Won!");
				userWon = true;
			}
			
			if(opponentChoice.equals("S")) {
				System.out.println("There was a Draw");
			}
		break;
		}
		
		if(userWon==true) {
			userWinningCounter++;
		}
		
		if(opponentWon==true) {
			opponentWinningCounter++;
		}
		
	}
	
}