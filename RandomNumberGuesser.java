
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

		int input = 0;
		int low = 0;
		int high = 0;
		boolean bool = false;
		String choice = null;

		Scanner myObj = new Scanner(System.in);

		while (true) {
			low = 1;
			high = 100;
			int randomNum = RNG.rand();
			System.out.println("This application generates a random integer between 1 and 100 and asks the user to guess repeatedly until they guess correctly.");
			System.out.println("Enter the first guess:");
			input = myObj.nextInt();

			if (input == randomNum) {
				System.out.println("Congratulations, you guessed correctly");
			} else {

				while (true) {
					do {
						bool = RNG.inputValidation(input, low, high);
						if (bool) {
							break;
						}
						input = myObj.nextInt();
					} while (!bool);

					if (input < randomNum) {
						low = input + 1;
						System.out.println("Your guess is too low");
					} else if (input > randomNum) {
						high = input;
						System.out.println("Your guess is too high");
					} else {
						System.out.println("Congratulations, you guessed correctly");
						break;
					}
					if (RNG.getCount() == 7) {
						System.out.println("You have exceeded the maximum number of guesses, " + RNG.getCount() + ". Try again");
						System.exit(0);
					}
					System.out.println("Number of guesses is: " + RNG.getCount());
					System.out.println("Enter your next guess between " + low + " and " + high);
					input = myObj.nextInt();
				}

			}
			System.out.println("Try again? (yes or no)");
			myObj.nextLine();
			choice = myObj.nextLine();
			if (choice.equalsIgnoreCase("no")) {
				System.out.println("Thank you for playing");
				System.out.println("Programmer name: Harlene Kaur");
				break;
			} else {
				RNG.resetCount();
			}

		}
		myObj.close();
	}

}