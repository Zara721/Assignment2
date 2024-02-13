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
        startGame();
    }

    /**
     * initializes the game and handles the turn logic until a winner is determined
     */
    public static void startGame() {
        TwoDice twoDice = new TwoDice();
        boolean isPlayerTurn = true;
        int totalPlayerScore = 0;
        int aiScore = 0;
        boolean ifWinner = false;
        //a game header
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
                """);
        System.out.println(twoDice.toString());
        System.out.println("""
        Here we go...
        --------------------------------------
        """);

        while (!ifWinner){
            int currentScore;
            if(isPlayerTurn){
                System.out.println("Your turn");
                currentScore = doRound("Player",0);
//                System.out.println("Round status: " + Arrays.toString(roundStatus));
                totalPlayerScore += currentScore;
                isPlayerTurn = nextTurn("Player", currentScore, totalPlayerScore, aiScore);
            }
            else {
                System.out.println("Computer turn");
                currentScore = doRound("Computer",0);
                aiScore += currentScore;
                isPlayerTurn = nextTurn("Computer", currentScore, totalPlayerScore, aiScore);
            }
            ifWinner = checkWinCondition(totalPlayerScore, aiScore);
        }

    }

    /**
     * method that handles the player's turn, handling the decision to roll again or stay
     *
     * @param turn the string representing whose turn it is ("Player" or "Computer")
     * @param currentScore an int that has the current score
     * @param totalPlayerScore the player's total score
     * @param aiScore the computer's total score
     * @return true if it's the player's turn again, false otherwise
     */
    public static boolean nextTurn(String turn, int currentScore, int totalPlayerScore, int aiScore) {
        boolean isPlayerTurn = false;
//        System.out.println("Is it a double, " + isDoubles);
        if (currentScore == 0) {
            //displays the total score of the player and computer
            System.out.println("Score: Player " + totalPlayerScore + " Computer " + aiScore);
            System.out.println("--------------------------------------");
        }  else {
            System.out.println("Staying");
            //displays the total score of the player and computer
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
     * @param currentScore an int that has the current score
     * @return an int containing the current score
     */
    public static int doRound(String turn, int currentScore) {
        TwoDice twoDice = new TwoDice();
        boolean rollAgain = false;
        int roundScore = 0; //score for the current roll only

        twoDice.roll();
        if (twoDice.isDoubles()) {
            rollAgain = true;
            //doubles gets the total times two added to current score
            roundScore += twoDice.getValue() * 2;
        } else {
            roundScore += twoDice.getValue();
        }

        System.out.println("Rolling...");
        System.out.println(twoDice.toString());

        if (rollAgain) {
            System.out.println("Doubles! Roll again!");
            currentScore += roundScore;
            //doubles gets to roll again
            return doRound(turn, currentScore);
        }

        if (twoDice.hasSingleOne()) {
            System.out.println("OH NO...You lost it all!");
            System.out.println("You lost: " + currentScore); //shows how much is lost, not including single one roll
            //single round loses all the points for that round
            currentScore = 0;
            return currentScore;
        }

        char userResponse = 'y';
        if (turn.equals("Player")){
            userResponse = playerRollAgain(currentScore + roundScore);
        } else {
            userResponse = aiRollAgain();
        }

        if (userResponse == 'n') {
            // no means staying, which adds the round score to current score
            currentScore += roundScore;
            return currentScore;
        } else {
            return doRound(turn, currentScore);
        }
    }

    /**
     * asks the player if they want to roll again during their turn
     *
     * @param currentScore the score accumulated in the current round
     * @return 'y' if the player wants to roll again, 'n' otherwise
     */
    public static char playerRollAgain(int currentScore){

        String userResponse = processUserResponse(currentScore);
        //only registers the first letter of response, and ignores case sensitivity
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
        // use random numbers to determine computers choice
        int randomChoiceNumber = random.nextInt(1, 4);
        // 2/3 of the time the computer chooses to roll again
        if (randomChoiceNumber == 1) {
            return 'n';
        } else {
            return 'y';
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
