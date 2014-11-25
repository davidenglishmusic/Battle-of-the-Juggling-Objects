
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
