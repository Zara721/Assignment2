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
        System.out.println("Hello world!");
        char[][] oneDice = {{' ', '_', '_', '_', '_', '_', '_', '_', ' '},
                {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', 'o', ' ' , ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
                {' ', '‾', '‾', '‾', '‾', '‾', '‾','‾',' '}};

        char[][] two2Dice = {{' ', '_', '_', '_', '_', '_', '_', '_', ' '},
                {'|', ' ', 'o', ' ', ' ', ' ' , ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ' , 'o', ' ', '|'},
                {' ', '‾', '‾', '‾', '‾', '‾', '‾','‾',' '}};

        char[][] threeDice = {{' ', '_', '_', '_', '_', '_', '_', '_', ' '},
                {'|', ' ', 'o', ' ', ' ', ' ' , ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', 'o', ' ' , ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ' , 'o', ' ', '|'},
                {' ', '‾', '‾', '‾', '‾', '‾', '‾','‾',' '}};

        char[][] fourDice = {{' ', '_', '_', '_', '_', '_', '_', '_', ' '},
                {'|', ' ', 'o', ' ', ' ', ' ' , 'o', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
                {'|', ' ', 'o', ' ', ' ', ' ' , 'o', ' ', '|'},
                {' ', '‾', '‾', '‾', '‾', '‾', '‾','‾',' '}};

        char[][] fiveDice = {{' ', '_', '_', '_', '_', '_', '_', '_', ' '},
                {'|', ' ', 'o', ' ', ' ', ' ' , 'o', ' ', '|'},
                {'|', ' ', ' ', ' ', 'o', ' ' , ' ', ' ', '|'},
                {'|', ' ', 'o', ' ', ' ', ' ' , 'o', ' ', '|'},
                {' ', '‾', '‾', '‾', '‾', '‾', '‾','‾',' '}};

        char[][] sixDice = {{' ', '_', '_', '_', '_', '_', '_', '_', ' '},
                {'|', ' ', 'o', ' ', ' ', ' ' , 'o', ' ', '|'},
                {'|', ' ', 'o', ' ', ' ', ' ' , 'o', ' ', '|'},
                {'|', ' ', 'o', ' ', ' ', ' ' , 'o', ' ', '|'},
                {' ', '‾', '‾', '‾', '‾', '‾', '‾','‾',' '}};
        printTwoDice(oneDice, sixDice);
        printDice(oneDice);
        printDice(two2Dice);
        printDice(threeDice);
        printDice(fourDice);
        printDice(fiveDice);
        printDice(sixDice);


        TwoDice twoDice = new TwoDice();
        twoDice.makeDieAsArray();
    }


    public static void printDice(char[][] diceArray) {
        for (int row = 0; row < diceArray.length; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(diceArray[row][col]);
            }
            System.out.println();
        }
    }

    public static void printTwoDice(char[][] diceArray, char[][] diceArray2) {
        for (int row = 0; row < diceArray.length; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(diceArray[row][col]);
            }
            System.out.print("  ");
            for (int col = 0; col < 9; col++) {
                System.out.print(diceArray2[row][col]);
            }
            System.out.println();
        }
    }


}


