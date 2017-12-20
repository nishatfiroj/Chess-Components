/**
 * Represents Pawn on a chess board.
 *
 * @author nfiroj3
 * @version 1
 */

public class Pawn extends Piece {

/**
     * @param c enum from enum class Color, called from superclass Piece
     */
    public Pawn(Color c) {
        super(c);
    }

/**
     * @return algebraic name of the piece
     */
    public String algebraicName() {
        return "";
    }

/**
     * @return FEN name of piece
     */
    public String fenName() {
        if (getColor().equals(Color.WHITE)) {
            return "P";
        } else {
            return "p";
        }
    }

/**
     * @param square the initial starting position of type Square
     * @return finalMoves an array of object Square of all possible moves
     */
    public Square[] movesFrom(Square square) {
        int fileNum = square.fileCharToNum(square.getFile());
        int rankNum = square.rankCharToNum();
        Square[] moves = new Square[3];
        int count = 0;

        if (rankNum == 6 && getColor().equals(Color.WHITE)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum)
                + square.rankNumToChar(rankNum - 2));
            count++;

            moves[count] = new Square("" + square.fileNumToChar(fileNum)
                + square.rankNumToChar(rankNum - 1));
            count++;
        } else if (square.isValid(rankNum - 1)
            && getColor().equals(Color.WHITE)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum)
                + square.rankNumToChar(rankNum - 1));
            count++;
        }

        if (rankNum == 1 && getColor().equals(Color.BLACK)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum)
                + square.rankNumToChar(rankNum + 2));
            count++;

            moves[count] = new Square("" + square.fileNumToChar(fileNum)
                + square.rankNumToChar(rankNum + 1));
            count++;
        } else if (square.isValid(rankNum + 1)
            && getColor().equals(Color.BLACK)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum)
                + square.rankNumToChar(rankNum + 1));
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