import java.util.Collection;
import java.util.Set;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
     * Implements Set interface for a square set
     *
     * @author nfiroj3
     * @version 3
     */
public class SquareSet implements Set<Square> {

    private Square[] squareSet;
    private char[] validFiles = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private char[] validRanks = {'1', '2', '3', '4', '5', '6', '7', '8'};

/**
     * Sets squareSet
     */
    public SquareSet() {
        this.squareSet = new Square[1];
    }

/**
     * Sets squareSet
     * @param c an array of Square objects
     */
    public SquareSet(Collection<Square> c) {
        Iterator<Square> iter = c.iterator();
        while (iter.hasNext()) {
            Square next = iter.next();
            this.add(next);
        }
    }

/**
     * Getter method for squareSet
     * @return squareSet
     */
    public Square[] getSquareSet() {
        return squareSet;
    }

/**
     * adds a square to squareSet
     * @param square the Square object we are adding
     * @return boolean where true is returned if it's a new and valid square
     */
    public boolean add(Square square) {
        Square[] squareSetTemp = new Square[squareSet.length + 1];

        if (square == null) {
            throw new NullPointerException();
        } else if (!isValid(square)) {
            throw new InvalidSquareException(square.toString());
        } else if (this.contains(square)) {
            return false;
        } else {
            for (int i = 0; i < squareSet.length; i++) {
                squareSetTemp[i] = squareSet[i];
            }
            squareSetTemp[squareSet.length] = square;
            squareSet = squareSetTemp;
        }
        return true;
    }

/**
     * adds squares from one array to squareSet
     * @param set the Square array we are adding
     * @return boolean where true is returned if we successfully add the set
     */
    @Override
    public boolean addAll(Collection<? extends Square> c) {
        boolean bool = false;
        for (Square h : c) {
            char file = h.getFile();
            char rank = h.getRank();
            if (file <= 'a' && file >= 'h' && rank <= '1' && rank >= '8') {
                throw new InvalidSquareException(h.toString());
            } else if (this.contains(h)) {
                return bool;
            } else {
                this.add(h);
                bool = true;
            }
        }
        return bool;
    }

        // int i = this.size();
        // int j = 0;
        // // Iterator<Square> iter = set.iterator(Square);
        // Iterator<? extends Square> iter = set.iterator();
        // while (iter.hasNext()) {
        //     squareSetTemp[i] = iter.next();
        //     i += 1;
        //     j += 1;
        // }
        // // for (Square square : set) {
        // //     squareSetTemp[i] = square;
        // //     i += 1;
        // // }
        // squareSet = squareSetTemp;
        // return true;
    // }

/**
     * unnecessary
     */
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

/**
     * check if parameter is in squareSet
     * @param o Object o passed in to check if it's in set
     * @return boolean true if object is in squareSet
     */
    public boolean contains(Object o) {
        if (o == null) {
            for (Square square : squareSet) {
                if (square == null) {
                    return true;
                }
            }
        } else {
            Square cast = (Square) o;
            for (Square square : squareSet) {
                if (cast.equals(square)) {
                    return true;
                }
            }
        }
        return false;
    }

/**
     * check if set is a subset of squareSet
     * @param set the Square array we are checking
     * @return boolean true is returned if set is subset of squareSet
     */
    @Override
    public boolean containsAll(Collection<?> set) {
        for (Object o: set) {
            if (!this.contains((Square) o)) {
                return false;
            }
        }
        return true;
    }

/**
     * equals method
     * @param other Object other is getting compared
     * @return boolean true if two objects are equivalent in value and identity
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (null == other) {
            return false;
        }
        if (!(other instanceof Set)) {
            return false;
        }
        Set that = (Set) other;
        return (this.size() == that.size() && this.containsAll(that));
    }

/**
     * Helper method that searches into an array
     * @param a array of type char we are passing in
     * @param item a char that we are searching for
     * @return boolean representing whether or not an array contains element
     */
    public static boolean has(char[] a, char item) {
        for (char value : a) {
            if (value == item) {
                return true;
            }
        }
        return false;
    }

/**
     * gives unique mathematical code represnting the object at hand
     * @return num2 int representing a mathematical code
     */
    @Override
    public int hashCode() {
        int result = 0;
        for (Square square : squareSet) {
            if (square != null) {
                result += square.hashCode();
            }
        }
        return result;
    }

/**
     * checks if array is empty
     * @return boolean true if array is empty
     */
    @Override
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }

/**
     * isValid helper method to check validity of squares
     * @param square that we are checking validity of
     * @return boolean whether a square is valid for the Chess game
     */
    public boolean isValid(Square square) {
        return has(validFiles, square.getFile())
            && has(validRanks, square.getRank());
    }

/**
     * creates instance of iterator
     * @return SquareIterator() instance of iterator for this object
     */
    @Override
    public Iterator<Square> iterator() {
        return new SquareIterator();
    }

/**
     * removes a given object
     * @param o Object o we are looking to remove
     * @return boolean true if we are able to remove the object
     */
    @Override
    public boolean remove(Object o) {
        Square cast = (Square) o;
        for (int i = 0; i < squareSet.length; i++) {
            if (cast.equals(squareSet[i])) {
                squareSet[i] = null;
                return true;
            }
        }
        return false;
    }

/**
     * unnecessary
     */
    @Override
    public boolean removeAll(Collection<?> set)  {
        return false;
        // throw new UnsupportedOperationException();
    }

/**
     * unnecessary
     */
    @Override
    public boolean retainAll(Collection<?> set) {
        return false;
    }

/**
     * checks size of array
     * @return counter, that reveals the size of the array
     */
    @Override
    public int size() {
        int counter = 0;
        for (Square square : squareSet) {
            if (square != null) {
                counter += 1;
            }
        }
        return counter;
    }

/**
     * returns array type of squareSet
     * @return squareSet
     */
    @Override
    public Square[] toArray() {
        int counter = 0;
        int counter2 = 0;
        for (Square square : squareSet) {
            if (square != null) {
                counter++;
            }
        }
        Square[] squareSetTemp = new Square[counter];
        for (int i = 0; i < squareSet.length; i++) {
            if (squareSet[i] != null) {
                squareSetTemp[counter2] = squareSet[i];
                counter2++;
            }
        }
        return squareSetTemp;
    }

/**
     * returns array type of squareSet
     * @param a a set/array
     * @return a a set/array
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return a;
    }


/**
     * inner iterator class
     */
    private class SquareIterator implements Iterator<Square> {

        private int cursor = 0;

    /**
         * constructor
         */
        public SquareIterator() {
        }

    /**
         * returns SquareIterator()
         * @return SquareIterator() instantiation
         */
        public Iterator<Square> iterator() {
            return new SquareIterator();
        }

    /**
         * checks to see if iterator can move on to next element
         * @return boolean about whether next move is valid
         */
        public boolean hasNext() {
            return cursor < size();
        }

    /**
         * returns next element in a squareSet
         * @return square representing the next element
         */
        public Square next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Square square = squareSet[cursor];
            cursor++;
            return square;
        }
    }
}