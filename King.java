/**
 * Represents King on a chess board.
 *
 * @author nfiroj3
 * @version 1
 */

public class King extends Piece {

/**
     * @param c enum from enum class Color, called from superclass Piece
     */
    public King(Color c) {
        super(c);
    }

/**
     * @return algebraic name of the piece
     */
    public String algebraicName() {
        return "K";
    }

/**
     * @return FEN name of piece
     */
    public String fenName() {
        if (getColor().equals(Color.WHITE)) {
            return "K";
        } else {
            return "k";
        }
    }

/**
     * @param square the initial starting position of type Square
     * @return finalMoves an array of object Square of all possible moves
     */
    public Square[] movesFrom(Square square) {
        int fileNum = square.fileCharToNum(square.getFile());
        int rankNum = square.rankCharToNum();
        Square[] moves = new Square[8];
        int count = 0;
        if (square.isValid(fileNum + 1) && square.isValid(rankNum + 1)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum + 1)
                + square.rankNumToChar(rankNum + 1));
            count++;
        }
        if (square.isValid(fileNum + 1)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum + 1)
                + square.rankNumToChar(rankNum));
            count++;
        }
        if (square.isValid(rankNum + 1)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum)
                + square.rankNumToChar(rankNum + 1));
            count++;
        }
        if (square.isValid(fileNum - 1) && square.isValid(rankNum - 1)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum - 1)
                + square.rankNumToChar(rankNum - 1));
            count++;
        }
        if (square.isValid(fileNum - 1)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum - 1)
                + square.rankNumToChar(rankNum));
            count++;
        }
        if (square.isValid(rankNum - 1)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum)
                + square.rankNumToChar(rankNum - 1));
            count++;
        }
        if (square.isValid(fileNum + 1) && square.isValid(rankNum - 1)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum + 1)
                + square.rankNumToChar(rankNum - 1));
            count++;
        }
        if (square.isValid(fileNum - 1) && square.isValid(rankNum + 1)) {
            moves[count] = new Square("" + square.fileNumToChar(fileNum - 1)
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