import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        //You should write the
        //code to control the turns, keep track of overall scores, and determine an actual winner. Print
        //appropriate information as the game progresses, including the total score lost (if lost), when
        //doubles occur, whose turn it is, etc. Do not use any “global” variables, that is, variables declared
        //in the spot where instance variables are declared in an ADT. This class should only need local
        //variables.
        //Handle inputs that may not be simply a ‘y’ or an ‘n’. When you read a line, and if the first char is
        //a ‘y’, ‘Y’, ‘n’ or ‘N’ then continue and assume the appropriate response. Otherwise, ask the user
        //for new input. For example, an entry of “Yo” is treated as “yes”, while an entry of “eyes” would
        //ask the user for new input.

        //do the doubles stack, so if I roll a double after a double do I get to roll again, also do I only roll again once
        startGame();
    }


    public static void startGame() {
        String turn = "player";
        int totalPlayerScore = 0;
        int aiScore = 0;
        boolean ifWinner = false;
        System.out.println("===================================\n" +
                " The Dice Game\n" +
                " How Much Can You Afford to Lose?\n" +
                "===================================\n" +
                "Roll the dice, accumulating the total to add to your score.\n" +
                "Hit 60 before the computer and you win!\n" +
                "If you roll doubles, you get double the value!\n" +
                " And you must roll again.\n" +
                "If you roll a one - you are done and lose the current round’s total,\n" +
                " unless it's snake eyes!\n" +
                " _______    _______ \n" +
                "|       |  |       |\n" +
                "|   o   |  |   o   |\n" +
                "|       |  |       |\n" +
                " ‾‾‾‾‾‾‾    ‾‾‾‾‾‾‾ \n" +
                "Here we go...\n" +
                "--------------------------------------\n");

        int currentPlayerScore = 0;
        currentPlayerScore = doPlayerRound(0);
        if (currentPlayerScore == 0) {
            totalPlayerScore = 0;
            System.out.println("Score: Player " + totalPlayerScore + " Computer " + aiScore);
        } else {
            totalPlayerScore += currentPlayerScore;
        }

    }

    public static int doPlayerRound(int currentScore) {
        TwoDice twoDice = new TwoDice();
        boolean rollAgain = false;

        twoDice.roll();
        if (twoDice.isDoubles()) {
            rollAgain = true;
            currentScore += twoDice.getValue() * 2;
        } else {
            currentScore += twoDice.getValue();
        }

        System.out.println("Your turn");
        System.out.println("Rolling...");
        System.out.println(twoDice.toString());

        if (rollAgain) {
            System.out.println("Doubles! Roll again!");
            doPlayerRound(currentScore);
        }

        if (twoDice.hasSingleOne()) {
            System.out.println("OH NO...You lost it all!");
            System.out.println("You lost: " + currentScore);
            currentScore = 0;
            return currentScore; //if 0 turn player score to zero
        }

        System.out.println("Roll Again? (current score is: " + currentScore + ") Enter 'y' for yes 'n' for no:");
        Scanner keyboard = new Scanner(System.in);
        String userResponse = keyboard.next();
        if (userResponse != "y" && userResponse != "n") {
            System.out.println("Sorry did not recognize your response");
        }

        return currentScore;
    }





}


