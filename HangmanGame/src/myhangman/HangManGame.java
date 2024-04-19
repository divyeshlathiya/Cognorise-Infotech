package myhangman;

import java.util.Random;
import java.util.Scanner;

public class HangManGame {

	private static final String[] words = { "apple", "orange", "pineapple","strawberry"};
	private final int attempts = 6;
	private Scanner sc;
	private static char[] guessWord;
	private int attemptLeft;
	static String randomWord;

	public HangManGame() {

		randomWord = randomWordGenerator();
		attemptLeft = attempts;
		guessWord = new char[randomWord.length()];
		for (int i = 0; i < guessWord.length; i++) {
			guessWord[i] = '_';
		}
	}

	private static String randomWordGenerator() {

		Random random = new Random();
		int randomIndex = random.nextInt(words.length);
		String rdmWord = words[randomIndex];
		return rdmWord;
	}

	public void startGame() {
		System.out.println("----------------------------");
		System.out.println("Word length: " + randomWord.length());
		System.out.println("Total Attempts: "+ attempts);
		System.out.println("----------------------------");
		
		while (attemptLeft > 0 && containsUnderScore()) {
			char inputChar = getLetters();
			updateGuessWord(inputChar);
		}
		displayResult();
	}

	private void displayResult() {
		if (!containsUnderScore()) {
			System.out.println("\nYou won the game! \nThe guessed word is " + randomWord);
		} else {
			System.out.println("\nYou lose the game.");
		}
	}

	private void updateGuessWord(char inputChar) {

		boolean isCorrect = false;

		for (int i = 0; i < randomWord.length(); i++) {
			if (randomWord.charAt(i) == inputChar) {
				guessWord[i] = inputChar;
				isCorrect = true;
			}
		}

		if (!isCorrect) {
			attemptLeft--;
		}
		System.out.println("Attempt left: " + attemptLeft);
	}

	private char getLetters() {
		sc = new Scanner(System.in);
		System.out.print("\nEnter a letter: ");
		char c = sc.next().charAt(0);
		return c;
	}

	private boolean containsUnderScore() {
		for (char c : guessWord) {
			if (c == '_') {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		HangManGame obj = new HangManGame();
		obj.startGame();
	}

}
