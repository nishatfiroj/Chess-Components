/**
     * creates a move
     *
     * @author nfiroj3
     * @version 2
     */

public class Move {

    private Ply whitePly;
    private Ply blackPly;

/**
     * constructor
     * @param whitePly the ply representing the White Player's move
     * @param blackPly the ply representing the Black Player's move
     */
    public Move(Ply whitePly, Ply blackPly) {
        this.whitePly = whitePly;
        this.blackPly = blackPly;
    }

/**
     * @return whitePly the move that the white player does
     */
    public Ply getWhitePly() {
        return whitePly;
    }

/**
     * @return blackPly the move that the black player does
     */
    public Ply getBlackPly() {
        return blackPly;
    }

}