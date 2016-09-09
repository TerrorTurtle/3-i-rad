/**
 * Created by leca14 on 2016-09-09.
 */
import java.util.Scanner;
public class Project {
    public static final int EMPTY = 0;
    public static final int CROSS = 1;
    public static final int NOUGHT = 2;

    public static final int PLAYING = 0;
    public static final int DRAW = 1;
    public static final int CROSS_WON = 2;
    public static final int NOUGHT_WON = 3;

    public static final int ROWS = 3, COLS = 3;
    public static int[][] board = new int [ROWS][COLS];

    public static int currenState;
    public static int currentPlayer;
    public static int currentRow, currentCol;

    public static Scanner in = new Scanner (System.in);

        public static void main(String[] args) {
            initGame();

            do {
                playerMove (currentPlayer);
                updateGame (currentPlayer, currentRow, currentCol);
                printBoard();

                if (currentState == CROSS_WON){
                    System.out.println("'X' Vann! Buhbye!");
                } else if (currentState == NOUGHT_WON){
                    System.out.println("'Nought' Won! Baibai!")
                } else if (currentState == DRAW){
                    System.out.println("Nobody wins! Get'em outta here!");
                }
                currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
            }   while (currentState == PLAYING);
        }

    private static void initGame() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++row) {
                board[row][col] = EMPTY;
            }
        }
        currentState = PLAYING;
        currentPlayer = CROSS;
    }

    public static void playerMove (int theSeed){
        boolean validInput = false;
        do {
            if (theSeed == CROSS) {
                System.out.print("Player 'X', enter your move (row[1-3] column[1-3]):");
            } else {
                System.out.print("Player 'O', enter your move (row[1-3] column[1-3]):");
            }
            int row =  in.nextInt() - 1;
            int col = in.nextInt() - 1;
            if (row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == EMPTY){
                currentRow = row;
                currentCol = col;
                board[currentRow][currentCol] = theSeed;
                validInput = true;
            } else {
                System.out.println("Ditt drag (" +(row + 1) + "," + (col + 1)+ ") är inte giltigt. Försök igen...")
            }
            while (!validInput);

        }
    }

}
