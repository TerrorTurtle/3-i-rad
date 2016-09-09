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
            }
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

}
