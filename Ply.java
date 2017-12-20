
import java.util.Optional;
/**
     * One player's move in chess. Kind of like half of a move.
     *
     * @author nfiroj3
     * @version 2
     */
public class Ply {

    private Piece piece;
    private Square from;
    private Square to;
    private Optional<String> comment;

/**
     * Constructor
     * @param piece represents the piece at play
     * @param from the square that the piece starts on
     * @param to the square that the piece is headed towards
     * @param comment a comment that is associated with the move
     */
    public Ply(Piece piece, Square from, Square to, Optional<String> comment) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.comment = comment;
    }

/**
     * @return piece representing a Piece that will be moved
     */
    public Piece getPiece() {
        return piece;
    }

/**
     * @return from the Square on which the Piece is originally
     */
    public Square getFrom() {
        return from;
    }

/**
     * @return to the Square to where Piece is moving
     */
    public Square getTo() {
        return to;
    }

/**
     * @return comment of type Optional
     */
    public Optional<String> getComment() {
        return comment;
    }

}