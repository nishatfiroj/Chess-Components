/**
 * Represents Rook on a chess board.
 *
 * @author nfiroj3
 * @version 1
 */

public class Rook extends Piece {

/**
     * @param c enum from enum class Color, called from superclass Piece
     */
    public Rook(Color c) {
        super(c);
    }

/**
     * @return algebraic name of the piece
     */
    public String algebraicName() {
        return "R";
    }

/**
     * @return FEN name of piece
     */
    public String fenName() {
        if (getColor().equals(Color.WHITE)) {
            return "R";
        } else {
            return "r";
        }
    }

/**
     * @param square the initial starting position of type Square
     * @return finalMoves an array of object Square of all possible moves
     */
    public Square[] movesFrom(Square square) {
        int fileNum = square.fileCharToNum(square.getFile());
        int rankNum = square.rankCharToNum();
        Square[] moves = new Square[14];
        int count = 0;
        int vert = 1;
        int hor = 1;

        // vertical downward movement for loop
        while (square.isValid(rankNum + vert)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum)
                + square.rankNumToChar(rankNum + vert));
            vert++;
            count++;
        }

        // vertical upward movement for loop
        vert = 1;
        while (square.isValid(rankNum - vert)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum)
                + square.rankNumToChar(rankNum - vert));
            vert++;
            count++;
        }

        // horizontal rightward movement for loop
        while (square.isValid(fileNum + hor)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum + hor)
                + square.rankNumToChar(rankNum));
            hor++;
            count++;
        }

        hor = 1;
        // horizontal leftward movement for loop
        while (square.isValid(fileNum - hor)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum - hor)
                + square.rankNumToChar(rankNum));
            hor++;
            count++;
        }


        Square[] finalMoves = new Square[count];

        for (int i = 0; i < count; i++) {
            if (moves[i] != null) {
                finalMoves[i] = moves[i];
            }
        }

        return finalMoves;
    }

}