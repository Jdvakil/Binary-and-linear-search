/**
 * This is the ItemNotFoundException that is a subclass of the parent class
 * Exception.
 * 
 * @author Jay Darshan Vakil
 * @version 02/18/2020
 */
public class ItemNotFoundException extends Exception {

    /**
     * Empty constructor
     */
    public ItemNotFoundException() {
        super("Item not found: please try again...");
    }

    /**
     * Constructor that outputs text given by the user
     * 
     * @param errorText text given by the user to output.
     * PRECONDITIONS: The user will give a not empty string to output.
     */
    public ItemNotFoundException(String errorText) {
        super(errorText);
    }

}