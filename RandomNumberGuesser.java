/*
 * Class: CMSC203 
 * Instructor:Ashique Tanveer
 * Description: This project will generate a random number from 1-100. The user will have to guess the random number that was generated. 
 * Due: 02/08/2023
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Harlene Kaur
 */
import java.util.*;

public class RandomNumberGuesser {
	public static void main(String[] args) {

		// Initialize variables
		int input = 0; // user's guess
		int low = 0; // lowest possible value for random number
		int high = 0; // highest possible value for random number
		boolean bool = false; // input validation result
		String choice = null; // user's choice to play again or not

		Scanner myObj = new Scanner(System.in); // create Scanner object for user input

		while (true) {
			// Reset low and high values for each game
			low = 1;
			high = 100;

			// Generate a random number between 1 and 100
			int randomNum = RNG.rand();

			// Display instructions to the user
			System.out.println("This application generates a random integer between 1 and 100 and asks the user to guess repeatedly until they guess correctly.");
			System.out.println("Enter the first guess:");
			input = myObj.nextInt();

			// If the user's first guess is correct, exit the loop and display a message
			if (input == randomNum) {
				System.out.println("Congratulations, you guessed correctly");
			} else {
				// Loop until the user guesses correctly or exceeds the maximum number of allowed guesses
				while (true) {
					do {
						// Check if the user's guess is valid (within the range of possible values)
						bool = RNG.inputValidation(input, low, high);
						if (bool) {
							break;
						}
						input = myObj.nextInt();
					} while (!bool);

					// If the user's guess is too low, update the lowest possible value for the random number
					if (input < randomNum) {
						low = input + 1;
						System.out.println("Your guess is too low");
					} else if (input > randomNum) {
						// If the user's guess is too high, update the highest possible value for the random number
						high = input;
						System.out.println("Your guess is too high");
					} else {
						// If the user's guess is correct, exit the loop and display a message
						System.out.println("Congratulations, you guessed correctly");
						break;
					}

					// If the user has exceeded the maximum number of allowed guesses, exit the loop and display a message
					if (RNG.getCount() == 7) {
						System.out.println("You have exceeded the maximum number of guesses, " + RNG.getCount() + ". Try again");
						System.exit(0);
					}

					// Display the number of guesses the user has made and prompt them to make another guess within the updated range of possible values
					System.out.println("Number of guesses is: " + RNG.getCount());
					System.out.println("Enter your next guess between " + low + " and " + high);
					input = myObj.nextInt();
				}
			}
			//Ask user if they want to play again
			System.out.println("Try again? (yes or no)");
			myObj.nextLine();
			choice = myObj.nextLine();
			//If user enters no end the program and print programmers name 
			if (choice.equalsIgnoreCase("no")) {
				System.out.println("Thank you for playing");
				System.out.println("Programmer name: Harlene Kaur");
				break;
			} 
			//If user enters yes restart the program
			else {
				RNG.resetCount();
			}
		}
		myObj.close();
	}

}
