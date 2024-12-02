package src;

public class Game {

    private int[] board;

    /** Player One = True, Player Two = False */
    private boolean player;

    private boolean cont;

    public Game() {
        board = new int[9];
        player = true;
        cont = true;
    }

    public boolean getPlayer() {
        return player;
    }

    public void switchPlayer() {
        //player = !player;
        if (player) {
            player = false;
        } else {
            player = true;
        }
    }

    public boolean getCont() {
        return cont;
    }

    public void setCont(boolean theCont) {
        cont = theCont;
    }

    public void setBox(int boxNum, boolean thePlayer) {
        boxNum--;
        int num = 1;
        if (!thePlayer) {
            num *= -1;
            System.out.println("helllloooooo");
        }
        board[boxNum] = num;
    }

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

    public void printBoard() {
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        for (int i = 3; i < 5; i++) {
            System.out.println("---+---+---");
            System.out.println(" " + board[i] + " | " + board[i + 1] + " | " + board[i + 2]);
        }
    }



}
