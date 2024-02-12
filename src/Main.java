import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //questions; do the doubles stack, so if I roll a double after a double do I get to roll again,
        // also do I only roll again once, and what counts as a round if someone gets a double and then rolls a single one
        //do they also lose the points from the previous double
        startGame();
    }


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
            int currentScore = 0;
            if(isPlayerTurn){
                System.out.println("Your turn");
                roundStatus = doRound("Player");
                currentScore = roundStatus[0];
                totalPlayerScore += currentScore;
                isPlayerTurn = startTurn("Player", roundStatus, totalPlayerScore, aiScore);
            }
            else {
                System.out.println("Computer turn");
                roundStatus = doRound("Computer");
                currentScore = roundStatus[0];
                aiScore += currentScore;
                isPlayerTurn = startTurn("Computer", roundStatus, totalPlayerScore, aiScore);
            }
            ifWinner = checkWinCondition(totalPlayerScore, aiScore);
        }

    }

    public static boolean startTurn(String turn, int[] roundStatus, int totalPlayerScore, int aiScore) {
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

    public static char aiRollAgain(){
        Random random = new Random();
        int randomChoiceNumber = random.nextInt(1, 4);
        if (randomChoiceNumber == 1) {
            return 'y';
        } else {
            return 'n';
        }
    }

    public static String processUserResponse(int currentScore){
        System.out.println("Roll Again? (current score is: " + currentScore + ") Enter 'y' for yes 'n' for no:");
        Scanner keyboard = new Scanner(System.in);
        return keyboard.next(); //return user response
    }
}
