import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
     * filters through list of moves for chess game
     *
     * @author nfiroj3
     * @version 2
     */
public class ChessGame {

    private List<Move> moves;

/**
     * Constructor that sets up moves
     * @param moves that represents a list of chess moves
     */
    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }

/**
     * gets move
     * @param n an integer representing the integer index of a move
     * @return moves.get(n) returns the move at index n
     */
    public Move getMove(int n) {
        return moves.get(n);
    }

/**
     * Sets squareSet
     * @param filter represents a function that filters through a list
     * @return filteredMoves a list of moves based on a certain filter
     */
    public List<Move> filter(Predicate<Move> filter) {
        List<Move> filteredMoves = new ArrayList<Move>();
        for (Move move : moves) {
            if (filter.test(move)) {
                filteredMoves.add(move);
            }
        }
        return filteredMoves;
    }

/**
     * returns a list of moves with comments
     * @return filteredMoves a list of moves based on a certain filter
     */
    public List<Move> getMovesWithComment() { // 2 lambda
        List<Move> filteredMoves = filter((Move move) -> {
                return move.getWhitePly().getComment().isPresent()
                    || move.getBlackPly().getComment().isPresent();
            });
        return filteredMoves;
    }

/**
     * returns a list of moves without comments
     * @return filteredMoves a list of moves based on a certain filter
     */
    public List<Move> getMovesWithoutComment() { //1 anon inner class
        List<Move> filteredMoves = filter(new Predicate<Move>() {
            public boolean test(Move move) {
                return !move.getWhitePly().getComment().isPresent()
                    && !move.getBlackPly().getComment().isPresent();
            }
        });
        return filteredMoves;
    }

/**
     * returns a list of moves if they're identical
     * @param p a piece that we are matching the moves to
     * @return moves a list of moves based on a certain filter
     */
    public List<Move> getMovesWithPiece(Piece p) { //3 inner class
        Move move = new Move();
        class myPredicate implements Predicate {
            public boolean test(Piece p) {
                return move.getWhitePly().fenName() == p.fenName() && move.getBlackPly().fenName() == p.fenName();
            }
        }
        List<Move> filteredMoves = filter(new MyPredicate());
        return filteredMoves;
        // return moves;
    }

/**
     * returns a list of moves
     * @return moves
     */
    public List<Move> getMoves() {
        return moves;
    }

}