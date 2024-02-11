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
        char[][] dice = {{' ', '＿', '＿', '＿', '＿', ' ', ' ', ' '},
                {'|', ' ', 'o', ' ', ' ', 'o', ' ', '|'},
                {'|', ' ', 'o', ' ', ' ', 'o', ' ', '|'},
                {'|', ' ', 'o', ' ', ' ', 'o', ' ', '|'},
                {' ', '‾', '‾', '‾', '‾', '‾', '‾', ' '}};

        printDice(dice);
    }


    public static void printDice(char[][] diceArray) {
        for (int row = 0; row < diceArray.length; row++) {
            for (int col = 0; col < 8; col++) {
                System.out.print(diceArray[row][col]);
            }
            System.out.println();
        }
    }
}


