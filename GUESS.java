import java.util.Scanner;
import java.util.Random;

class GUESS{
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Number num = new Number();
        Userreply res = new Userreply();

        boolean flag = true;
        int totalrounds = 0;
        int totalscore = 0;
        int numbertoguess = 0;
        int maximum;

        System.out.print("How many Attemps do you want to guess the number : ");
        maximum = sc.nextInt();
        sc.nextLine();
        System.out.println("You have maximum " + maximum + " to guess the number.");

        while (flag) {

            numbertoguess = num.randomnum();
            int attempts = 0;
            boolean result = false;
            System.out.println("\nRound " + (totalrounds + 1) + " - Guess the number between 1 and 100 \n");

            while (attempts < maximum && !result) {
                System.out.print("Enter your guess : ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numbertoguess) {
                    System.out.println("Congratulations ! You guessed the correct number.\n");
                    result = true;
                } else if (userGuess < numbertoguess) {
                    System.out.println("Too low ! Try again.\n");
                } else {
                    System.out.println("Too high ! Try again.\n");
                }
            }

            if (!result) {
                System.out.println("You've used all attempts. The correct number was : " + numbertoguess + "\n");
            }

            if (result) {
                int roundPoints = maximum - attempts + 1;
                totalscore += roundPoints;
            } else {
                totalscore += 0;
            }

            totalrounds++;
            
            flag = res.reply(sc);
        }

        System.out.println("\nGame Over ! ");
        System.out.println("Total Rounds Played : " + totalrounds);
        System.out.println("Total Score : " + totalscore );
        sc.close();
    }
}class Number{

    int randomnum(){
        Random randnum = new Random();
        return randnum.nextInt(100) + 1;
    }
}
class Userreply{
    boolean reply(Scanner sc){

        while (true) {
            System.out.print("Do you want to play again ? (Yes/No) : ");
            String res = sc.next().trim().toLowerCase();
            String response1 = res.trim();
            if (response1.equalsIgnoreCase("yes")) {
                return true;
            } else if (response1.equalsIgnoreCase("no")) {
                return false;
            } else{
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }       
    }
}