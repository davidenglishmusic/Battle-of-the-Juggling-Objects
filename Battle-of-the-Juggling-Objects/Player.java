
/**
 * A class representing a player
 * 
 * @author David English
 * @version 2014.11.28
 */
public class Player
{
    private int playerNumber;

    /**
     * Default Player Constructor
     *
     */
    public Player()
    {
        setPlayerNumber(0);
    }
    
    /**
     * Player Constructor
     *
     * @param newPlayerNumber the new player number // Ultimately it might be nice to get some way of generating this number based on a class variable
     */
    public Player(int newPlayerNumber)
    {
        setPlayerNumber(newPlayerNumber);
    }

    /**
     * Method setPlayerNumber
     *
     * @param newPlayerNumber the new player number
     */
    public void setPlayerNumber(int newPlayerNumber)
    {
        if(newPlayerNumber > 0){
            playerNumber = newPlayerNumber;
        }
    }
    
    /**
     * Method getPlayerNumber
     *
     * @return the player number
     */
    public int getPlayerNumber()
    {
        return playerNumber;
    }
    
    /**
     * Method toString
     *
     * @return a string containing the word player and their particular player number
     */
    public String toString()
    {
        return "Player " + getPlayerNumber();
    }
}
