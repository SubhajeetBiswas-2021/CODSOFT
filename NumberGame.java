import java.util.Scanner;
import java.util.Random;

public class NumberGame
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        int maxAttempts = 10;  
        boolean playAgain = true; 
        int score = 0; 

        while (playAgain)
        {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = maxAttempts;
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Number Game!!Lets Play");
            System.out.println("I have chosen a number between 1 and 100.");
            System.out.println("You will get total " + maxAttempts + " attempts to guess the right number.");

            while (attemptsLeft > 0 && !hasGuessedCorrectly)
            {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt(); 
                attemptsLeft--; 
                if (userGuess == numberToGuess) 
                {
                    System.out.println("Congratulations! CHAMP The gussed number is correct.");
                    hasGuessedCorrectly = true;  
                    score++;  
                } 
                else if (userGuess < numberToGuess) 
                {
                    System.out.println("Too low. Try again.");
                }
                 else
                {
                    System.out.println("Too high. Try again.");
                }

                System.out.println("Attempts left: " + attemptsLeft);
            }
            if (!hasGuessedCorrectly)
            {
                System.out.println("Sorry! You've used all your attempts. The number was: " + numberToGuess);
            }
            System.out.print("Do you want to play again? Enter(yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
            }
            System.out.println("Thanks for playing! Your score is: " + score);
            scanner.close();
    }



}