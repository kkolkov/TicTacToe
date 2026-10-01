public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
    }

    public void startGame() {
        System.out.println("Крестики-нолики. Игрок 1 — X, Игрок 2 — O.");
        System.out.println("Точка обозначает свободную клетку.");
        board.displayBoard();

        while (true) {
            if (!currentPlayer.makeMove()) {
                System.out.println("Игра завершена: ввод закончился.");
                return;
            }
            board.displayBoard();
            if (checkForWinOrDraw()) {
                return;
            }
            switchPlayer();
        }
    }

    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean checkForWinOrDraw() {
        if (board.checkWin(currentPlayer.getMark())) {
            System.out.println("Победил " + currentPlayer.getName() + " (" + currentPlayer.getMark() + ")!");
            return true;
        }
        if (board.isFull()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }
}
