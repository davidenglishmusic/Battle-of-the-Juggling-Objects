
/**
 * A class representing a location
 * 
 * @author David English
 * @version 2014.11.28
 */
public class Location
{
    private int xPosition;
    private int yPosition;

    /**
     * Constructor for objects of class Location
     */
    public Location()
    {
        setXPosition(0);
        setYPosition(0);
    }
    
    public Location(int newXPosition, int newYPosition)
    {
        setXPosition(newXPosition);
        setYPosition(newYPosition);
    }

    public void setXPosition(int newXPosition)
    {
        if(newXPosition > 0){
            xPosition = newXPosition;
        }
    }
       
    public void setYPosition(int newYPosition)
    {
        if(newYPosition > 0){
            yPosition = newYPosition;
        }
    }
       
    public int getXPosition()
    {
        return xPosition;
    }
    
    public int getYPosition()
    {
        return yPosition;
    }
    
    public String toString()
    {
        return "" + getXPosition() + getYPosition();
    }
}
