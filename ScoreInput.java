package lesson12;
import java.util.InputMismatchException;
import java.util.Scanner;

class ScoreInputException extends Exception{
    public ScoreInputException(String message){
        super(message);
    }
}
public class ScoreInput {
    public static void main(String[] args){
        try{
            int score = getScore();
            System.out.println("Entered Score:" + score);
        }catch (ScoreInputException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static int getScore()throws ScoreInputException{
        Scanner scan = new Scanner(System.in);
        try{
            System.out.println("Enter the score (0-100): ");
            int score = scan.nextInt();
            if(score < 0 || score >100){
                throw new ScoreInputException("Score must be in the range of 0 to 100.");
            }
            return score;
        }catch (InputMismatchException e){
            throw new ScoreInputException("Invalid input. Please enter a valid Integer");
        }finally {
            scan.close();
        }
    }
}
