/**
 * Represents squares on a chess board.
 *
 * @author nfiroj3
 * @version 2
 */


public class Square {

// a class to represent squares on a chess board. Square should be instantiable
// and have the following constructors and methods:

    private char file;
    private char rank;

/**
     * Sets file and rank of a square
     * @param file the char letter representing the horizontal index of a piece
     * @param rank the char number representing the vertical index of a piece
     */
    public Square(char file, char rank) throws InvalidSquareException {
        this.file = file;
        this.rank = rank;

        int ourFile = fileCharToNum(file);
        int ourRank = 8 - Character.getNumericValue(rank);

        if (!isValid(ourFile)) {
            throw new InvalidSquareException(this.toString());
        } else if (!isValid(ourRank)) {
            throw new InvalidSquareException(this.toString());
        }
    }

/**
     * Sets name of a square
     * @param name the name of the square at hand
     */
    public Square(String name) throws InvalidSquareException {
        this(name.charAt(0), name.charAt(1));

        int ourFile = fileCharToNum(name.charAt(0));
        int ourRank = 8 - Character.getNumericValue(name.charAt(1));

        if (!isValid(ourFile)) {
            throw new InvalidSquareException(this.toString());
        } else if (!isValid(ourRank)) {
            throw new InvalidSquareException(this.toString());
        }

    }

/**
     * @return String of name of square
     */
    public String toString() {
        return "" + this.file + this.rank;
    }

/**
     * @return returns char of file
     */
    public char getFile() {
        return file;
    }

/**
     * @param fileCheck char passed in to check and convert char to int index
     * @return array index (horizontal)
     */
    public int fileCharToNum(char fileCheck) {
        int num;
        if (fileCheck == 'a') {
            num = 0;
        } else if (fileCheck == 'b') {
            num = 1;
        } else if (fileCheck == 'c') {
            num = 2;
        } else if (fileCheck == 'd') {
            num = 3;
        } else if (fileCheck == 'e') {
            num = 4;
        } else if (fileCheck == 'f') {
            num = 5;
        } else if (fileCheck == 'g') {
            num = 6;
        } else {
            num = 7;
        }
        return num;
    }

/**
     * @param num int passed in to check and convert int index to char
     * @return fileFin
     */
    public char fileNumToChar(int num) {
        char fileFin;
        if (num == 0) {
            fileFin = 'a';
        } else if (num == 1) {
            fileFin = 'b';
        } else if (num == 2) {
            fileFin = 'c';
        } else if (num == 3) {
            fileFin = 'd';
        } else if (num == 4) {
            fileFin = 'e';
        } else if (num == 5) {
            fileFin = 'f';
        } else if (num == 6) {
            fileFin = 'g';
        } else {
            fileFin = 'h';
        }
        return fileFin;
    }

/**
     * @return rank char
     */
    public char getRank() {
        return rank;
    }
/**
     * @return rank char is converted to int representing index in array
     */
    public int rankCharToNum() {
        return 8 - Character.getNumericValue(rank);
    }

/**
     * @param num int representing the integer index of array
     * @return rank as a char value
     */
    public char rankNumToChar(int num) {
        String value = String.valueOf(8 - num);
        return value.charAt(0);
    }

/**
     * @param num represents the integer index of the array that file or
     *        rank may be in
     * @return boolean of whether or not a file/rank is in bounds
     */
    public boolean isValid(int num) {
        return (num >= 0 && num < 8);
    }

/**
     * @return result int that represents hash int
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = (result * 31) + (int) this.file;
        result = (result * 31) + (int) this.rank;
        return result;
    }


/**
     * @param other an object of type Object
     * @param that an object of type Square
     * @return rank char
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (null == other) {
            return false;
        }
        if (!(other instanceof Square)) {
            return false;
        }
        Square that = (Square) other;
        return (this.file) == (that.file) && (this.rank) == (that.rank);
    }

}