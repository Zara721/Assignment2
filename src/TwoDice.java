import java.util.Random;

public class TwoDice {
    private char[][] dice1 = {{' ', '＿', '＿', '＿', '＿', ' ', ' ', ' '},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {' ', '‾', '‾', '‾', '‾', '‾', '‾', ' '}};;
    private char[][] dice2 = {{' ', '＿', '＿', '＿', '＿', ' ', ' ', ' '},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {' ', '‾', '‾', '‾', '‾', '‾', '‾', ' '}};;

    private int diceNum1;
    private int diceNum2;

    public TwoDice() {

    }
    public void makeDieAsArray() {
        //make two die from an array
        //choose 2 random numbers
        //store those numbers as two arrays
        Random random = new Random();
        int num1 = random.nextInt(1, 7);
        int num2 = random.nextInt(1, 7);
        System.out.println(num1 + " " + num2);
    }

    public String toString() {
        //display the dice to standard output.
        return null;
    }

    public void roll() {
        //method to roll the dice
    }

    public void getValue() {
        //return the total on the dice
    }

    public void isDoubles() {
        //returns true exactly when the dice contains doubles and false otherwise.
    }

    public void hasSingleOne() {
        //that returns true exactly when one of the dice has
        //a one, but false when both dice have a one and false when neither dice has a one.
    }
}
