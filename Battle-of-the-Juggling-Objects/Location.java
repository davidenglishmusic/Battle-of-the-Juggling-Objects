
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
     * Default Location Constructor
     *
     */
    public Location()
    {
        setXPosition(0);
        setYPosition(0);
    }
    
    /**
     * Location Constructor
     *
     * @param newXPosition a horizontal position
     * @param newYPosition a vertical position
     */
    public Location(int newXPosition, int newYPosition)
    {
        setXPosition(newXPosition);
        setYPosition(newYPosition);
    }

    /**
     * Method setXPosition
     *
     * @param newXPosition a horizontal position
     */
    public void setXPosition(int newXPosition)
    {
        if(newXPosition > 0){
            xPosition = newXPosition;
        }
    }
       
    /**
     * Method setYPosition
     *
     * @param newYPosition a vertical position
     */
    public void setYPosition(int newYPosition)
    {
        if(newYPosition > 0){
            yPosition = newYPosition;
        }
    }
       
    /**
     * Method getXPosition
     *
     * @return the horizontal position
     */
    public int getXPosition()
    {
        return xPosition;
    }
    
    /**
     * Method getYPosition
     *
     * @return the vertical position
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    /**
     * Method toString
     *
     * @return a string comprised of the horizontal and vertical positions
     */
    public String toString()
    {
        return "" + getXPosition() + getYPosition();
    }
}
