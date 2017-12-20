/**
 * Represents pieces on a chess board.
 *
 * @author nfiroj3
 * @version 1
 */

public abstract class Piece {

    private Color c;
    private String fenName;

/**
     * Initializes color of a piece from the enum class Color
     * @param c an instantiation of private enum Color
     */
    public Piece(Color c) {
        this.c = c;
    }

/**
     * @return Color enum cP
     */
    public Color getColor() {
        return c;
    }

/**
     * @param file a char representing file
     * @param rank a char representing char
     * @return whether it is a valid square
     */
    public boolean isInBoard(char file, char rank) {
        return file >= 'a' && file <= 'h' && rank >= '1' && rank <= '8';
    }

/**
     * Abstract method for algebraic name of a chess piece.
     * @return String algebraic name of piece
     */
    public abstract String algebraicName();

/**
     * Abstract method for FEN name of a chess piece.
     * @return String FEN name of piece
     */
    public abstract String fenName();

/**
     * Abstract method for array of possible squares a chess piece can go.
     * @return Square[] array of all possible moves
     * @param square Square object representing initial position of piece
     */
    public abstract Square[] movesFrom(Square square);

}