/**
 * Represents Queen on a chess board.
 *
 * @author nfiroj3
 * @version 1
 */

public class Queen extends Piece {

/**
     * @param c enum from enum class Color, called from superclass Piece
     */
    public Queen(Color c) {
        super(c);
    }

/**
     * @return algebraic name of the piece
     */
    public String algebraicName() {
        return "Q";
    }

/**
     * @return FEN name of piece
     */
    public String fenName() {
        if (getColor().equals(Color.WHITE)) {
            return "Q";
        } else {
            return "q";
        }
    }

/**
     * @param square the initial starting position of type Square
     * @return finalMoves an array of object Square of all possible moves
     */
    // public Square[] movesFrom(Square square) {
    //     int fileNum = square.fileCharToNum(square.getFile());
    //     int rankNum = square.rankCharToNum();
    //     Square[] moves = new Square[8];
    //     int count = 0;
    //     if (square.isValid(fileNum + 2) && square.isValid(rankNum + 1)) {
    //         moves[count] = new Square("" + square.fileNumToChar(fileNum + 1)
    //             + square.rankNumToChar(rankNum + 1));
    //         count++;
    //     }
    //     if (square.isValid(fileNum + 1) && square.isValid(rankNum + 2)) {
    //         moves[count] = new Square("" + square.fileNumToChar(fileNum + 1)
    //             + square.rankNumToChar(rankNum));
    //         count++;
    //     }
    //     if (square.isValid(rankNum + 1)) {
    //         moves[count] = new Square("" + square.fileNumToChar(fileNum)
    //             + square.rankNumToChar(rankNum + 1));
    //         count++;
    //     }
    //     if (square.isValid(fileNum - 1) && square.isValid(rankNum - 1)) {
    //         moves[count] = new Square("" + square.fileNumToChar(fileNum - 1)
    //             + square.rankNumToChar(rankNum - 1));
    //         count++;
    //     }
    //     if (square.isValid(fileNum - 1)) {
    //         moves[count] = new Square("" + square.fileNumToChar(fileNum - 1)
    //             + square.rankNumToChar(rankNum));
    //         count++;
    //     }
    //     if (square.isValid(rankNum - 1)) {
    //         moves[count] = new Square("" + square.fileNumToChar(fileNum)
    //             + square.rankNumToChar(rankNum - 1));
    //         count++;
    //     }
    //     if (square.isValid(fileNum + 1) && square.isValid(rankNum - 1)) {
    //         moves[count] = new Square("" + square.fileNumToChar(fileNum + 1)
    //             + square.rankNumToChar(rankNum - 1));
    //         count++;
    //     }
    //     if (square.isValid(fileNum - 1) && square.isValid(rankNum + 1)) {
    //         moves[count] = new Square("" + square.fileNumToChar(fileNum - 1)
    //             + square.rankNumToChar(rankNum + 1));
    //         count++;
    //     }

    //     Square[] finalMoves = new Square[count];

    //     for (int i = 0; i < count; i++) {
    //         if (moves[i] != null) {
    //             finalMoves[i] = moves[i];
    //         }
    //     }

    //     return finalMoves;
    // }


    public Square[] movesFrom(Square square) {
        Square[] sq = new Square[64];
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
            if (isInBoard(files[0], rank)) {
                sq[counter++] = new Square(files[0], rank);
            }
            if (isInBoard(files[1], rank)) {
                sq[counter++] = new Square(files[1], rank);
            }
            if (isInBoard(file, ranks[0])) {
                sq[counter++] = new Square(file, ranks[0]);
            }
            if (isInBoard(file, ranks[1])) {
                sq[counter++] = new Square(file, ranks[1]);
            }
        }

        Square[] full = new Square[counter];
        for (int i = 0; i < counter; i++) {
            full[i] = sq[i];
        }

        return full;
    }
}