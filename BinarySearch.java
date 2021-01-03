/**
 * This class goes thru a text file with a lot of words and returns the index of
 * the word or if the word exists in the file or not.
 * 
 * @author Jay Darshan Vakil
 * @version 02/18/2020
 */
public class BinarySearch{

    /**
     * This is the recursive search method inherited from the super class
     * SearchAlgorithm.
     * 
     * @param textStrings The array of string from the text file
     * @param word        The word to look for
     * @throws ItemNotFoundException if the word isnt found.
     */
    public int recSearch(String[] textStrings, String word){
        int len = textStrings.length;
        return recSearch(textStrings, word, 0, len);
    }

    /**
     * This is the recursive search method's helper method that recursively searches
     * through the file.
     * 
     * @param textStrings The array of Strings from the text file
     * @param word        The word to find.
     * @param lhs         The left side from the middle
     * @param rhs         The right side from the middle
     * @return
     * @throws ItemNotFoundException For this method i got help/inspiration from
     *                               this website:
     *                               https://www.geeksforgeeks.org/java-program-for-binary-search-recursive-and-iterative/
     * 
     */
    private int recSearch(String[] textStrings, String word, int lhs, int rhs) {
        int ret = -1;
        if (lhs > rhs) {
        } else {
            int middle = (lhs + rhs) / 2;
            if (textStrings[middle].equals(word)) {
                ret = middle;
            } else if (textStrings[middle].compareTo(word) > 0) {
                ret = recSearch(textStrings, word, lhs, middle - 1);
            } else if (textStrings[middle].compareTo(word) < 0) {
                ret = recSearch(textStrings, word, middle + 1, rhs);
            } else {
            }
        }
        return ret;
    }

    @Override
    /**
     * This is the binary search method that goes through the file using the binary
     * method to look for the word in the text file.
     * 
     * @param textStrings The array of string from the text file
     * @param word        The word to look for
     * @return The index of the element
     * @throws ItemNotFoundException if the word isnt found.
     */
    public int search(String[] textStrings, String word) {
        int lhs = 0, middle = 0;
        int rhs = textStrings.length;
        while (lhs <= rhs) {
            middle = (lhs + rhs) / 2;

            if (textStrings[middle].equals(word)) {
                return middle;
            } else if (textStrings[middle].compareTo(word) > 0) {
                rhs = middle - 1;
            } else if (textStrings[middle].compareTo(word) < 0) {
                lhs = middle + 1;
            }
        }
        throw new ItemNotFoundException("The word not found in the list...");
    }

}