
/**
 * Write a description of class Location here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public void setXPosition(String newXPosition)
    {
        if(newXPosition != null && newXPosition.length() == 1){
            if(newXPosition.matches("\\p{L}") || newXPosition.matches("\\p{Lu}")){
                xPosition = convertLetterToNumber(newXPosition);
            }
        }
    }
    
    public void setYPosition(int newYPosition)
    {
        if(newYPosition > 0){
            yPosition = newYPosition;
        }
    }
    
    public void setYPosition(String newYPosition)
    {
        if(newYPosition != null && newYPosition.length() == 1){
            if(newYPosition.matches("\\p{L}") || newYPosition.matches("\\p{Lu}")){
                yPosition = convertLetterToNumber(newYPosition);
            }
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
    
    private int convertLetterToNumber(String stringLetter)
    {
        if(stringLetter != null && stringLetter.length() == 1){
            char letter = stringLetter.charAt(0);
            return letter - 'a' + 1;
        }
        else{
            return 0;
        }
    }
}
