/**
 * Represents Bishop on a chess board.
 *
 * @author nfiroj3
 * @version 1
 */

public class Bishop extends Piece {

/**
     * @param c enum from enum class Color, called from superclass Piece
     */
    public Bishop(Color c) {
        super(c);
    }

/**
     * @return algebraic name of the piece
     */
    public String algebraicName() {
        return "B";
    }

/**
     * @return FEN name of piece
     */
    public String fenName() {
        if (getColor().equals(Color.WHITE)) {
            return "B";
        } else {
            return "b";
        }
    }

/**
     * @param square the initial starting position of type Square
     * @return finalMoves an array of object Square of all possible moves
     */
    public Square[] movesFrom(Square square) {
        Square[] sq = new Square[27];
        int counter = 0;
        char rank = square.getRank();
        char file = square.getFile();
        for (int i = 1; i <= 8; i++) {
            char[] ranks = new char[]{(char) (rank + i), (char) (rank - i)};
            char[] files = new char[]{(char) (file + i), (char) (file - i)};
            if (isInBoard(files[0], ranks[0])) {
                sq[counter++] = new Square(files[0], ranks[0]);
            }
            if (isInBoard(files[1], ranks[0])) {
                sq[counter++] = new Square(files[1], ranks[0]);
            }
            if (isInBoard(files[0], ranks[1])) {
                sq[counter++] = new Square(files[0], ranks[1]);
            }
            if (isInBoard(files[1], ranks[1])) {
                sq[counter++] = new Square(files[1], ranks[1]);
            }
        }

        Square[] full = new Square[counter];
        for (int i = 0; i < counter; i++) {
            full[i] = sq[i];
        }

        return full;
    }
}