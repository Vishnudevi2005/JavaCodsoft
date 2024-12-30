import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int roundsPlayed=0;
        int score=0;
        boolean playAgain=true;
        while(playAgain){
            int numberToGuess=random.nextInt(100) + 1;
            int attemptsLeft=5;
            boolean guessedCorrectly=false;
            System.out.println("Guess the number between 1 to 100,Youhave"+attemptsLeft+"attempts");
            while(attemptsLeft>0){
                System.out.println("Enter your guess");
                int guess=scanner.nextInt();
                if(guess==numberToGuess){
                    System.out.println("CONGRATULATIONS! You guessed the correct number!");
                    guessedCorrectly=true;
                    score++;
                    break;
                }else if(guess<numberToGuess){
                    System.out.println("Too low!Try Again");

                }else{
                    System.out.println("Too high! Try again");
                }
                attemptsLeft--;
                System.out.println("Attempts left"+attemptsLeft);

            }
            if(!guessedCorrectly){
              System.out.println("Sorry,you've run out of attempts!the correct number was"+numberToGuess+".");

            }roundsPlayed++;;
            System.out.println("Rounds played:" + roundsPlayed + ",Score" + score);
            System.out.println("Do you want to play another round?(yes/no):");
            playAgain=scanner.next().equalsIgnoreCase("yes");

        }
        System.out.println("Thanks you for playing final score:"+score);
        scanner.close();
    }

    
}
