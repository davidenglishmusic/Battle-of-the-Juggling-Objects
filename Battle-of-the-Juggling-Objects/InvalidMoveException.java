
/**
 * A class representing an invalid move exception
 * 
 * @author David English
 * @version 2014.11.28
 */
public class InvalidMoveException extends Exception
{
    /**
     * InvalidMoveException Constructor
     *
     * @param message the message explaining to the user the source of the error
     */
    public InvalidMoveException(String message)
    {
        super(message);
    }
}
