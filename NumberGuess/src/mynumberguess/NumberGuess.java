package mynumberguess;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int attempt = 5;
		int i = 0;
		System.out.println("Total attempts: 5");
		while (i < attempt) {
			System.out.print("Enter number: ");
			int num = sc.nextInt();
			i++;

			if (isNumisCorrect(num)) {
				break;
			}
			System.out.println("Attempts left: " + (attempt - i));
		}

		sc.close();
	}

	private static boolean isNumisCorrect(int num) {

		int randomNum = generateRandomNum();
		if (randomNum == num) {
			System.out.println("You are correct!\nYou won the game");
			return true;
		} else if (num > randomNum) {
			System.out.println("Oops! your number is bigger than random number.");
			return false;
		} else {
			System.out.println("Oops! your number is smaller than random number.");
			return false;
		}

	}

	private static int generateRandomNum() {
		Random random = new Random();
		int randNum = 1 + random.nextInt(10);
		return randNum;
	}

}
