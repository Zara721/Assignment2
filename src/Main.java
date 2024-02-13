/*
Class: AUCSC 112
Group members: Zara Ezeasor, Camila Peri
ID Numbers: 1828118, 18382782
Due Date: February 13, 2024
Assignment 2: Dice Game
Summary: A dice game where the player plays against the computer to see who can get to 60 points
*/

import java.util.Scanner;
import java.util.Random;

public class Main {

    /**
     * main of the program that starts the game
     */
    public static void main(String[] args) {
        //questions; do the doubles stack, so if I roll a double after a double do I get to roll again,
        // also do I only roll again once, and what counts as a round if someone gets a double and then rolls a single one
        //do they also lose the points from the previous double
        startGame();
    }

    /**
     * initializes the game and handles the turn logic until a winner is determined
     */
    public static void startGame() {
        boolean isPlayerTurn = true;
        int totalPlayerScore = 0;
        int aiScore = 0;
        boolean ifWinner = false;
        System.out.println("""
                ===================================
                          ~ The Dice Game ~
                  How Much Can You Afford to Lose?
                ===================================
                Roll the dice, accumulating the total to add to your score.
                Hit 60 before the computer and you win!
                If you roll doubles, you get double the value!
                 And you must roll again.
                If you roll a one - you are done and lose the current round’s total,
                 unless it's snake eyes!
                 _______    _______\s
                |       |  |       |
                |   o   |  |   o   |
                |       |  |       |
                 ‾‾‾‾‾‾‾    ‾‾‾‾‾‾‾\s
                Here we go...
                --------------------------------------
                """);
        while (!ifWinner){
            int[] roundStatus;
            int currentScore;
            if(isPlayerTurn){
                System.out.println("Your turn");
                roundStatus = doRound("Player");
                currentScore = roundStatus[0];
                totalPlayerScore += currentScore;
                isPlayerTurn = nextTurn("Player", roundStatus, totalPlayerScore, aiScore);
            }
            else {
                System.out.println("Computer turn");
                roundStatus = doRound("Computer");
                currentScore = roundStatus[0];
                aiScore += currentScore;
                isPlayerTurn = nextTurn("Computer", roundStatus, totalPlayerScore, aiScore);
            }
            ifWinner = checkWinCondition(totalPlayerScore, aiScore);
        }

    }

    /**
     * method that handles the player's turn, handling the decision to roll again or stay
     *
     * @param turn the string representing whose turn it is ("Player" or "Computer")
     * @param roundStatus an array containing the current score and whether it's a doubles
     * @param totalPlayerScore the player's total score
     * @param aiScore the computer's total score
     * @return true if it's the player's turn again, false otherwise
     */
    public static boolean nextTurn(String turn, int[] roundStatus, int totalPlayerScore, int aiScore) {
        boolean isPlayerTurn = false;
        int currentScore = roundStatus[0];
        int isDoubles = roundStatus[1];
        if (currentScore == 0) {
            System.out.println("Score: Player " + totalPlayerScore + " Computer " + aiScore);
            System.out.println("--------------------------------------");
        }
        else if (isDoubles == 1) {
            isPlayerTurn = true;
            return isPlayerTurn;
        }
        else {
            totalPlayerScore += currentScore;
            System.out.println("Staying");
            System.out.println("Score: Player " + totalPlayerScore + " Computer " + aiScore);
            System.out.println("--------------------------------------");
        }
        if (turn.equals("Computer")) {
            isPlayerTurn = true;
        }
        return isPlayerTurn;
    }

    /**
     * checks the win condition based on the scores of the player and the computer
     *
     * @param totalPlayerScore the player's total score
     * @param aiScore the computer's total score
     * @return true if a winner is determined, false otherwise
     */
    public static boolean checkWinCondition(int totalPlayerScore, int aiScore){
        String winner = "You";
        if (aiScore > totalPlayerScore) {
            winner = "Computer";
        }
        if ((totalPlayerScore>=60)||(aiScore>=60)){
            System.out.println("TaTaTah Drum rollllllll");
            System.out.println("The winner is: " + winner);
            return true;
        }
        return false;

    }

    /**
     * executes a round of the dice game for a given player or the computer
     *
     * @param turn the string representing whose turn it is ("Player" or "Computer")
     * @return an array containing the current score and whether it's a doubles
     */
    public static int[] doRound(String turn) {
        TwoDice twoDice = new TwoDice();
        boolean rollAgain = false;
        int isDoubles = 0;
        int currentScore = 0;

        twoDice.roll();
        if (twoDice.isDoubles()) {
            rollAgain = true;
            currentScore += twoDice.getValue() * 2;
        } else {
            currentScore += twoDice.getValue();
        }

        System.out.println("Rolling...");
        System.out.println(twoDice.toString());

        if (rollAgain) {
            System.out.println("Doubles! Roll again!");
            isDoubles = 1;
            return new int[]{currentScore, isDoubles};
        }

        if (twoDice.hasSingleOne()) {
            System.out.println("OH NO...You lost it all!");
            System.out.println("You lost: " + currentScore);
            currentScore = 0;
            return new int[]{currentScore, isDoubles}; //if 0 turn player score to zero
        }

        char userResponse = 'y';
        if (turn.equals("Player")){
            userResponse = playerRollAgain(currentScore);
        } else {
            userResponse = aiRollAgain();
        }

        if (userResponse == 'n') {
            return new int[]{currentScore, isDoubles};
        } else {
            doRound(turn);
        }

        return new int[]{currentScore, isDoubles};
    }

    /**
     * asks the player if they want to roll again during their turn
     *
     * @param currentScore the score accumulated in the current round
     * @return 'y' if the player wants to roll again, 'n' otherwise
     */
    public static char playerRollAgain(int currentScore){

        String userResponse = processUserResponse(currentScore);
        userResponse = userResponse.toLowerCase();
        char[] userResponseArray = userResponse.toCharArray();
        char newUserResponse = userResponseArray[0];
        if (newUserResponse=='y'){
            return 'y';
        }
        else if (newUserResponse=='n'){
            return 'n';
        }
        else {
            while (userResponse != "y" && userResponse != "n") {
                System.out.println("Sorry did not recognize your response");
                userResponse = processUserResponse(currentScore);
            }
        }
        return newUserResponse;
    }

    /**
     * decides whether the computer will roll again during its turn
     *
     * @return 'y' if the computer will roll again, 'n' otherwise
     */
    public static char aiRollAgain(){
        Random random = new Random();
        int randomChoiceNumber = random.nextInt(1, 4);
        if (randomChoiceNumber == 1) {
            return 'y';
        } else {
            return 'n';
        }
    }

    /**
     * prompts the user for input on whether they wish to roll again
     *
     * @param currentScore the score accumulated in the current round
     * @return the user's response as a string
     */
    public static String processUserResponse(int currentScore){
        System.out.println("Roll Again? (current score is: " + currentScore + ") Enter 'y' for yes 'n' for no:");
        Scanner keyboard = new Scanner(System.in);
        return keyboard.next(); //return user response
    }
}
