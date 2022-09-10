package boardGame;

public class Position {

    private int row;
    private int column;

    public Position() {
    }

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setValues(int row, int column) {

        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {

        return row + ", " + column;
    }
}
