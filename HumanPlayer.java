import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name, char mark, Board board, Scanner scanner) {
        super(name, mark, board);
        this.scanner = scanner;
    }

    @Override
    public boolean makeMove() {
        while (true) {
            System.out.println(name + " (" + mark + "), введите строку и столбец от 1 до 3:");
            if (!scanner.hasNextLine()) {
                return false;
            }

            String[] numbers = scanner.nextLine().trim().split("\s+");
            if (numbers.length != 2) {
                System.out.println("Введите два числа через пробел, например: 1 2.");
                continue;
            }

            try {
                int row = Integer.parseInt(numbers[0]);
                int col = Integer.parseInt(numbers[1]);
                if (board.placeMark(row - 1, col - 1, mark)) {
                    return true;
                }
                System.out.println("Клетка занята или координаты не от 1 до 3. Повторите ход.");
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целые числа.");
            }
        }
    }
}
