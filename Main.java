import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board.Builder().build();
        String type1 = args.length > 0 ? args[0] : "human";
        String type2 = args.length > 1 ? args[1] : "human";
        Player player1 = PlayerFactory.createPlayer(type1, "Игрок 1", 'X', board, scanner);
        Player player2 = PlayerFactory.createPlayer(type2, "Игрок 2", 'O', board, scanner);

        Game game = Game.getInstance(board, player1, player2);
        game.startGame();
        scanner.close();
    }
}
