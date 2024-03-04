package oasistask2;
import java.util.*;
import java.util.Random;
	public class task2 {
	    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();

	    public static void main(String[] args) {
	        task2 game = new task2();
	        game.menu();
	    }

	    public void menu() {
	        Scanner input = new Scanner(System.in);
	        System.out.println("--------------------");
	        System.out.println("Welcome to the number game Created By Noaman Shaikh");
	        System.out.println("1) Play the Game");
	        System.out.println("2) Score Board");
	        System.out.println("3) Exit the game");
	        System.out.println("--------------------");
	        
	        try {
	            System.out.print("Enter the action :");
	            int menuOption = input.nextInt();

	            switch (menuOption) {
	                case 1:
	                    System.out.print("\n"+"What would you like the range of the numbers to be? ");
	                    int numberRange = input.nextInt();
	                    int randomNumber = generateRandomNumber(numberRange);
	                    guessNumber(randomNumber);
	                    break;
	                case 2:
	                    displayScoreBoard();
	                    break;
	                case 3:
	                    System.out.println("\n"+"Thanks for playing the game!");
	                    System.exit(1);
	                    break;
	                default:
	                    throw new InputMismatchException("Invalid number entry. Please try again later.");
	            }
	        } catch (InputMismatchException e) {
	            System.err.println("\n"+e.getMessage() +"\n");
	            menu();
	        }
	    }

	    public int generateRandomNumber(int numberRange) {
	        Random random = new Random();
	        int randomNumber = random.nextInt(numberRange) + 1;
	        return randomNumber;
	    }

	    public void guessNumber(int randomNumber) {
	        Scanner input = new Scanner(System.in);
	        int userGuess;
	        int guessCount = 0;

	        System.out.println("*** WELCOME TO NUMBER GUESSING GAME ***");
	        System.out.println("A number is chosen between 1 to " + randomNumber + ".");
	        System.out.println("NOTE: Guess the number within 5 trials.");
	        System.out.println("Best of luck!");

	        while (true) {
	            System.out.print("Enter your guess number: ");
	            userGuess = input.nextInt();
	            guessCount++;

	            if (userGuess == randomNumber) {
	                System.out.println("CONGRATULATIONS!!!");
	                System.out.println("HURRAY!!! You have guessed the number correctly.");
	                System.out.println("You used "+ guessCount + " turns to guess the right number");

	                int score = calculateScore(guessCount);
	                System.out.println("Your score for this round: " + score);
	                
	                scoreBoard.add(score);
	                break;
	            } else if (userGuess < randomNumber) {
	                System.out.println("The number is greater than " + userGuess);
	                System.out.println("Turns left: " + (5 - guessCount));
	            } else {
	                System.out.println("The number is less than " + userGuess);
	                System.out.println("Turns left: " + (5 - guessCount));
	            }

	            if (guessCount >= 5) {
	                System.out.println("You have exhausted 5 trials.");
	                System.out.println("The number was " + randomNumber);
	                System.out.println("BETTER LUCK NEXT TIME!");
	                scoreBoard.add(0); // Score 0 for unsuccessful attempts
	                break;
	            }
	        }

	        menu();
	    }

	    public int calculateScore(int guessCount) {
	        if (guessCount == 1) {
	            return 100;
	        } else if (guessCount == 2) {
	            return 80;
	        } else if (guessCount == 3) {
	            return 60;
	        } else if (guessCount == 4) {
	            return 40;
	        } else if (guessCount == 5) {
	            return 20;
	        } else {
	            return 0;
	        }
	    }

	    public void displayScoreBoard() {
	        System.out.println("--------------------");
	        System.out.println("Score Board");
	        System.out.println("--------------------");
	        System.out.println("Your fastest games today out of all tries is: " +"\n");
	        
	        Collections.sort(scoreBoard);
	        
	        for (Integer score : scoreBoard) {
	            if (score != 0) {
	                System.out.println("Finished the number game with a score of " + score);
	            } else {
	                System.out.println("Could not guess the number within 5 trials.");
	            }
	        }
	        System.out.println(" ");

	        menu();
	    }
	}
