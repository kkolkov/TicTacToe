import java.util.Random;

public class AIPlayer extends Player {
    private Random random = new Random();

    public AIPlayer(String name, char mark, Board board) {
        super(name, mark, board);
    }

    @Override
    public boolean makeMove() {
        if (board.isFull()) {
            return false;
        }

        // Выбираем случайную клетку, пока не найдём свободную.
        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            if (board.placeMark(row, col, mark)) {
                System.out.println(name + " выбрал: " + (row + 1) + " " + (col + 1));
                return true;
            }
        }
    }
}
