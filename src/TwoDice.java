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

    public TwoDice() {

    }
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

    public void convertCoordsToDice(int[][] coordsArray, char[][] diceArray) {
        for (int[] coords: coordsArray) {
            int xCoord = coords[0];
            int yCoord = coords[1];
            diceArray[xCoord][yCoord] = 'o';
        }
    }

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

    public int getValue() {
        return diceNum1 + diceNum2;
    }

    public boolean isDoubles() {
        if (diceNum1==diceNum2){
            return true;
        }
        return false;
    }

    //that returns true exactly when one of the dice has
    //a one, but false when both dice have a one and false when neither dice has a one.
    public boolean hasSingleOne() {
        if ((diceNum1 == 1 && diceNum2!=1)||(diceNum2 == 1 && diceNum1!=1)){
            return true;
        }
        return false;
    }
}
