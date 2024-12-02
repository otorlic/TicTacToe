package src;

public class Game {

    /** Use's 0's for unused box, 1's for p1 claimed box, and -1's for p2 claimed box */
    private int[] board;

    /** Use's spaces for unused box, X's for p1 claimed box, and O's for p2 claimed box */
    private char[] marks;

    /** Player One = True, Player Two = False */
    private boolean player;

    /** Tracks whether the game should continue or not */
    private boolean cont;

    /**
     * Fills board array with zeros, fills marks array with spaces, sets player to
     * true for player 1, and cont to true so the game can start.
     */
    public Game() {
        board = new int[9];
        marks = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        player = true;
        cont = true;
    }

    /**
     * Returns true for player 1 and false for player 2.
     *
     * @return which player's turn it is
     */
    public boolean getPlayer() {
        return player;
    }

    /**
     * Flips which player's turn it is.
     */
    public void switchPlayer() {
        player = !player;

    }

    /**
     * Returns if the game should end or not.
     *
     * @return true if game should continue, false otherwise
     */
    public boolean getCont() {
        return cont;
    }

    /**
     * Set cont to true to allow the game to continue, false otherwise.
     *
     * @param theCont boolean for if the game should continue or not
     */
    public void setCont(boolean theCont) {
        cont = theCont;
    }

    /**
     * Sets the correct number and symbols in the board and marks arrays based
     * on which player's turn it is. boxNum is 1 greater than the index, so it is decremented
     * at the beginning.
     *
     * @param boxNum the box number selected by the player
     * @param thePlayer uses 1's and X's for p1 and -1's and O's for p2
     */
    public void setBox(int boxNum, boolean thePlayer) {
        boxNum--;
        int num = 1;
        char mark = 'X';
        if (!thePlayer) {
            num *= -1;
            mark = 'O';
        }
        board[boxNum] = num;
        marks[boxNum] = mark;
    }

    /**
     * Checks if the box the player has selected has already been selected.
     *
     * @param boxNum the box selected by player
     * @return whether the box is available
     */
    public boolean checkBoxAvailability(int boxNum) {
        if (board[--boxNum] != 0) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the game has been won by using a brute force approach.
     */
    public void checkWin() {
        int ans = 3;
        if (!player) {ans *= -1;}

        if (board[0] + board[1] + board[2] == ans) {
            this.setCont(false);
        } else if (board[3] + board[4] + board[5] == ans) {
            this.setCont(false);
        } else if (board[6] + board[7] + board[7] == ans) {
            this.setCont(false);
        } else if (board[0] + board[3] + board[6] == ans) {
            this.setCont(false);
        } else if (board[1] + board[4] + board[7] == ans) {
            this.setCont(false);
        } else if (board[2] + board[5] + board[8] == ans) {
            this.setCont(false);
        } else if (board[0] + board[4] + board[8] == ans) {
            this.setCont(false);
        } else if (board[2] + board[4] + board[6] == ans) {
            this.setCont(false);
        }
    }

    /**
     * Prints the game board using X's and O's
     */
    public void printBoard() {
        System.out.println(" " + marks[0] + " | " + marks[1] + " | " + marks[2]);
        for (int i = 3; i < 9; i += 3) {
            System.out.println("---+---+---");
            System.out.println(" " + marks[i] + " | " + marks[i + 1] + " | " + marks[i + 2]);
        }
    }

}
