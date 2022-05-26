package rockPaperScissors;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
													
public class RockPaperScissors {
	
	public int userWinningCounter, opponentWinningCounter, totalGameCounter;
	
	public static void main(String[] args) {
		
		RockPaperScissors game = new RockPaperScissors();
		
		Scanner input = new Scanner(System.in);
		System.out.print("Welcome to the game Rock, Paper, Scissors! This is a best 3 out of 5");
		
		//Loops through the games until a best of 5 is met.
		while(game.userWinningCounter !=3 && game.opponentWinningCounter != 3) {
		
		System.out.println("\nScoreboard: \nYour Score: " + game.userWinningCounter + "\t Your opponent Score: " + game.opponentWinningCounter);
		System.out.print("\nPlease enter your choice (R,P,S): ");
		String userInput = input.next();
		userInput = userInput.toUpperCase();	
	
			game.play(userInput);
		}
		
		input.close();
		
		if(game.userWinningCounter ==3) {
			System.out.println("\nCongrats! you won!");
		}
		
		if(game.opponentWinningCounter == 3) {
			System.out.println("\nSadly you lost");
		}
		 
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