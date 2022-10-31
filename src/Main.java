import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Player player1, player2, currentPlayer;
        Board board = new Board();
        boolean gameOver = false;
        player1 = getPlayerFromKeyboard(input);
        player2 = getPlayerFromKeyboard(input);
        currentPlayer = getRandomPlayer(player1, player2);
        while (!gameOver) {
            System.out.println(board);
            System.out.println(currentPlayer.getName() +
                    " Enter row and col:");
            System.out.println("Row: ");
            int row = input.nextInt() - 1;
            System.out.println("Col: ");
            int col = input.nextInt() - 1 ;
            if (board.shoot(row, col, currentPlayer)) {
                if (board.wins()) {
                    System.out.println(board);
                    System.out.println("WINNER " + currentPlayer);
                    gameOver = true;
                } else {
                    currentPlayer = changePlayer(currentPlayer, player1, player2);
                }
            }
        }
    }

    private static Player changePlayer(Player current, Player player1, Player player2) {
        return current == player1 ? player2 : player1;

    }

    private static Player getRandomPlayer(Player player1, Player player2) {
        int rand = (int) (Math.random() * 2);
        return rand == 0 ? player1 : player2;

    }

    private static Player getPlayerFromKeyboard(Scanner input) {
        System.out.println("Enter the name of the player " + (Player.getNumPlayers() == 0 ? "1" : "2"));
        String name = input.next();
        return new Player(name);
    }
}



