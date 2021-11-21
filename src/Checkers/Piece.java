package Checkers;

public class Piece {
    private int x;
    private int y;
    private boolean isKing = false;
    private boolean isWhite;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing() {
        isKing = true;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public int[] getCoordinates() {
        return new int[]{getX(), getY()};
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Piece(int x, int y, boolean isWhite) {
        setX(x);
        setY(y);
        setWhite(isWhite);
    }

}
