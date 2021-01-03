/**
 * This class finds a String in a text file with a lot of words. It implements
 * the linear search method to look for the word
 * 
 * @author Jay Darshan Vakil
 * @version 02/18/2020
 */
public class LinearSearch extends SearchAlgorithm {
    @Override
    /**
     * This is the recursive search method.
     */
    public int recSearch(String[] textStrings, String word) throws ItemNotFoundException {
        return recSearch(textStrings, word, 0);
    }

    /**
     * This is the helper method to the recursive search method.
     * @param textStrings The array of strings from the text file
     * @param word The word to find 
     * @param index The index to start at.
     * @return The index of the word if found
     * @throws ItemNotFoundException
     */
    public int recSearch(String[] textStrings, String word, int index) throws ItemNotFoundException {
        int ret = -1, len = textStrings.length;
        if (index >= len) {
            throw new ItemNotFoundException("Index out of bounds...");
        }
        else if (textStrings[index].equals(word)) {
            ret = index;
        }
        incrementCount();
        return ret;
    }

    @Override
    /**
     * This is the search method implemented from the super class, used to find the index of the word using linear search implementation.
     */
    public int search(String[] textStrings, String word) throws ItemNotFoundException {
        int index = 0, len = textStrings.length, ret = -1;
        while (index < len && !(textStrings[index].equals(word))) {// keep moving through the text until the word isnt found
            incrementCount();
            index++;
        }
        if (index < len) {
            ret = index;
            incrementCount();
        } else {
            throw new ItemNotFoundException("Item not found...");
        }
        return ret;
    }

}