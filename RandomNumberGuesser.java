import java.util.Scanner;

public class RandomNumberGuesser {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		RNG rng = new RNG();
		String retry;
		
		do {
			rng.resetCount();
			int randomNumber = rng.rand();
			int userGuess, lowGuess = 0, highGuess = 100;
			int guessCount = rng.getCount();
			guessCount = 1;
			System.out.println("Enter your first guess");
			userGuess = scan.nextInt();
			while(userGuess != randomNumber) {
				System.out.println("Number of guesses is " + guessCount);
				if(userGuess > randomNumber) {
					System.out.println("Your guess is too high");
					if(userGuess < highGuess) {
						highGuess = userGuess;
					}
				} else if(userGuess < randomNumber) {
					System.out.println("Your guess is too low");
					if(userGuess > lowGuess) {
					lowGuess = userGuess;
					}
				}
				rng.inputValidation(userGuess, lowGuess, highGuess);
				userGuess = scan.nextInt();
				guessCount++;
			}
			System.out.println("Number of guesses is " + guessCount);
			System.out.println("Congratulations, you guessed correctly");
			System.out.println("Try again? (yes or no)");
			retry = scan.next();
			if("Yes".equalsIgnoreCase(retry) || "yes".equalsIgnoreCase(retry)) {
				System.out.println("\n");
			}
		} while ("Yes".equalsIgnoreCase(retry) || "yes".equalsIgnoreCase(retry));
		System.out.println("Thanks for playing...");
	}	
}