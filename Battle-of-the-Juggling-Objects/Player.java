
/**
 * A class representing a player
 * 
 * @author David English
 * @version 2014.11.28
 */
public class Player
{
    private int playerNumber;

    public Player()
    {
        setPlayerNumber(0);
    }
    
    public Player(int newPlayerNumber)
    {
        setPlayerNumber(newPlayerNumber);
    }

    public void setPlayerNumber(int newPlayerNumber)
    {
        if(newPlayerNumber > 0){
            playerNumber = newPlayerNumber;
        }
    }
    
    public int getPlayerNumber()
    {
        return playerNumber;
    }
    
    public String toString()
    {
        return "Player " + getPlayerNumber();
    }
}
