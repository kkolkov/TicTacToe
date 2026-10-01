public class Board {
    private final char[][] grid = new char[3][3];

    public Board() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                grid[row][col] = '.';
            }
        }
    }

    public void displayBoard() {
        System.out.println("  1 2 3");
        for (int row = 0; row < 3; row++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < 3; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    public boolean placeMark(int row, int col, char mark) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }
        if (grid[row][col] != '.' || (mark != 'X' && mark != 'O')) {
            return false;
        }
        grid[row][col] = mark;
        return true;
    }

    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row][col] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(char mark) {
        for (int i = 0; i < 3; i++) {
            // Проверяем строку и столбец.
            if (grid[i][0] == mark && grid[i][1] == mark && grid[i][2] == mark) {
                return true;
            }
            if (grid[0][i] == mark && grid[1][i] == mark && grid[2][i] == mark) {
                return true;
            }
        }

        // Проверяем две диагонали.
        return (grid[0][0] == mark && grid[1][1] == mark && grid[2][2] == mark)
            || (grid[0][2] == mark && grid[1][1] == mark && grid[2][0] == mark);
    }
}
