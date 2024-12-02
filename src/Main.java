package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] theArgs) {
        Game game = new Game();
        Scanner in = new Scanner(System.in);
        String playerNum = "1";

        System.out.println("Let the game begin!");
        game.printStartBoard();
        System.out.println();

        while (game.getCont()) {
            boolean player = game.getPlayer();
            playerNum = player ? "1" : "2"; //if player = true, it is player 1's turn
            System.out.println("Player " + playerNum + ", please select a box (1-9) to fill.");

            game.printBoard();
            int box = in.nextInt();
            while (!game.checkBoxAvailability(box)) {
                box = in.nextInt();
            }
            game.setBox(box, player);
            game.checkWin(); // will switch cont to false and playerWon to true
            game.checkDraw(); // will switch cont to false but keep playerWon as false
            game.switchPlayer();

        }

        if (game.getPlayerWon()) {
            System.out.println("Congrats, Player " + playerNum + "!");
        } else {
            System.out.println("Game ended in a tie!");
        }

        game.printBoard();

    }
}
