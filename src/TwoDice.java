import java.util.Random;
public class TwoDice {
    private char[][] diceArray1 = {{' ', '_', '_', '_', '_', '_', '_', '_', ' '},
            {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
            {' ', '‾', '‾', '‾', '‾', '‾', '‾','‾',' '}};
    private char[][] diceArray2 = {{' ', '_', '_', '_', '_', '_', '_', '_', ' '},
            {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
            {' ', '‾', '‾', '‾', '‾', '‾', '‾','‾',' '}};

    private int[][] oneDot = {{2, 4}};
    private int[][] twoDots = {{1, 2}, {3, 6}};
    private int[][] threeDots = {{1, 2}, {2, 4}, {3, 6}};
    private int[][] fourDots = {{1, 2}, {1, 6}, {3, 2}, {3, 6}};
    private int[][] fiveDots = {{1, 2}, {1, 6}, {2, 4},  {3, 2}, {3, 6}};
    private int[][] sixDots = {{1, 2}, {1, 6}, {2, 2}, {2, 6}, {3, 2}, {3, 6}};

    private int diceNum1;
    private int diceNum2;

    /**
     * a constructor that initializes two dice with two ones
     */
    public TwoDice() {
        diceArray1 = new char[][]{{' ', '_', '_', '_', '_', '_', '_', '_', ' '},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', 'o', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {' ', '‾', '‾', '‾', '‾', '‾', '‾', '‾', ' '}};
        diceArray2 = new char[][]{{' ', '_', '_', '_', '_', '_', '_', '_', ' '},
                {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', 'o', ' ' , ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
                {' ', '‾', '‾', '‾', '‾', '‾', '‾','‾',' '}};
    }

    /**
     * create the representation of two random dice in the form of an array
     */
    public void makeDieAsArray() {
        //make two die from an array
        //choose 2 random numbers
        //store those numbers as two arrays
        Random random = new Random();
        diceNum1 = random.nextInt(1, 7);
        diceNum2 = random.nextInt(1, 7);
        addDotsToDice(diceNum1, diceArray1);
        addDotsToDice(diceNum2, diceArray2);

    }

    /**
     * a method that updates a die array with a certain amount of dots
     * @param num the number of dots to add to dice
     * @param diceArray the dice array that needs to be updated with dots
     */
    public void addDotsToDice(int num, char[][] diceArray) {
        if (num == 1) {
            convertCoordsToDice(oneDot, diceArray);
        } else if (num == 2) {
            convertCoordsToDice(twoDots, diceArray);
        } else if (num == 3) {
            convertCoordsToDice(threeDots, diceArray);
        } else if (num == 4) {
            convertCoordsToDice(fourDots, diceArray);
        } else if (num == 5) {
            convertCoordsToDice(fiveDots, diceArray);
        } else {
            convertCoordsToDice(sixDots, diceArray);
        }
    }

    /**
     * a method that updates dice with the correct representation with the coordinates of the dots to add
     * @param coordsArray a two-dimensional list with the coordinates for the associated dice face
     * @param diceArray the dice array that needs to be updated with dots
     */
    public void convertCoordsToDice(int[][] coordsArray, char[][] diceArray) {
        for (int[] coords: coordsArray) {
            int xCoord = coords[0];
            int yCoord = coords[1];
            diceArray[xCoord][yCoord] = 'o';
        }
    }

    /**
     * a method that stores the two dice as a singular string
     * @return the string representation of the two dice
     */
    public String toString() {
        String stringTwoDice = "";
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                stringTwoDice += diceArray1[row][col];
            }
            stringTwoDice += "  ";
            for (int col = 0; col < 9; col++) {
                stringTwoDice += diceArray2[row][col];
            }
            stringTwoDice += "\n";
        }
        return stringTwoDice;
    }

    /**
     * a method that resets the dice to a blank state and calls makeDieAsArray() to roll for new numbers
     */
    public void roll() {
        diceArray1 = new char[][]{{' ', '_', '_', '_', '_', '_', '_', '_', ' '},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {' ', '‾', '‾', '‾', '‾', '‾', '‾', '‾', ' '}};
        diceArray2 = new char[][]{{' ', '_', '_', '_', '_', '_', '_', '_', ' '},
                {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', '|'},
                {' ', '‾', '‾', '‾', '‾', '‾', '‾','‾',' '}};
        makeDieAsArray();

    }

    /**
     * get the total value of the two die
     * @return the total value of the two die
     */
    public int getValue() {
        return diceNum1 + diceNum2;
    }

    /**
     * checks if two doubles have been rolled
     * @return true exactly when the dice contains doubles and false otherwise
     */
    public boolean isDoubles() {
        return diceNum1 == diceNum2;
    }

    /**
     * checks if the dice pair has a single one
     * @return  true exactly when one of the dice has a one, but false when both dice have a one and false when neither dice has a one
     */
    public boolean hasSingleOne() {
        if ((diceNum1 == 1 && diceNum2!=1)||(diceNum2 == 1 && diceNum1!=1)){
            return true;
        }
        return false;
    }
}
