public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        char[][] dice = {{' ', '_', '_', '_', '_', '_', '_', ' '},
                {'|', ' ', 'o', ' ', ' ', 'o', ' ', '|'},
                {'|', ' ', 'o', ' ', ' ', 'o', ' ', '|'},
                {'|', ' ', 'o', ' ', ' ', 'o', ' ', '|'},
                {' ', '_', '_', '_', '_', '_', '_', ' '}};

        String[][] dice2 = {{"   ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ ", "   "},
                {" | ", "   ", " o ", "   ", "   ", " o ", "   ", " | "},
                {" | ", "   ", "  ", "   ", "   ", "  ", "   ", " | "},
                {" | ", "   ", " o ", "   ", "   ", " o ", "   ", " | "},
                {"   ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ ", "   "}};

        printDice(dice);
    }



    public static void printDice(char [][] diceArray) {
        for (int row = 0; row < diceArray.length; row++) {
            for (int col = 0; col < 8; col++) {
                System.out.print(diceArray[row][col]);
            }
            System.out.println();
        }
    }
}


