package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] theArgs) {
        Game game = new Game();
        Scanner in = new Scanner(System.in);
        String playerNum = "1";

        System.out.println("Let the game begin!");

        while (game.getCont()) {
            boolean player = game.getPlayer();
            if (player) {
                playerNum = "1";
            } else {
                playerNum = "2";
            }
            System.out.println("Player " + playerNum + ", please select a box (1-9) to fill.");
            game.printBoard();
            int box = in.nextInt();
            game.setBox(box, player);
            game.checkWin();
            game.switchPlayer();

        }

        System.out.println("Congrats, Player " + playerNum + "!");
        game.printBoard();


    }
}
