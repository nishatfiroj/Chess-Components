/**
 * Exception class checking and throwing invalid square input
 *
 * This is checked exception because it's checking for invalid input, which
 * should be checked and corrected before compilation. In other words, this is
 * not a runtime type of error (which in that case would mean this would be an
 * unchecked error).
 *
 * @author nfiroj3
 * @version 1
 */

public class InvalidSquareException extends RuntimeException {

/**
     * Has the name of the invalid square
     * @param invalidSquare name of the invalid square
     */
    public InvalidSquareException(String invalidSquare) {
        super(invalidSquare);
    }
}


