public abstract class Player {
    protected String name;
    protected char mark;
    protected Board board;

    public Player(String name, char mark, Board board) {
        this.name = name;
        this.mark = mark;
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public char getMark() {
        return mark;
    }

    // true — ход сделан, false — ввод закончился.
    public abstract boolean makeMove();
}
