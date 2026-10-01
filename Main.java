import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Player player1 = new HumanPlayer("Игрок 1", 'X', board, scanner);
        Player player2 = new HumanPlayer("Игрок 2", 'O', board, scanner);

        Game game = new Game(board, player1, player2);
        game.startGame();
        scanner.close();
    }
}
