
/**
 * A class representing a ball
 * 
 * @author David English
 * @version 2014.11.28
 */
public class Ball extends GamePiece
{
    /**
     * Constructor for objects of class Ball
     */
    public Ball(String newPieceDisplay, Player newOwningPlayer)
    {
        super(newPieceDisplay, newOwningPlayer);
    }
    
    public boolean isLegalMove(Location from, Location to)
    {
        if(from.getYPosition() == to.getYPosition()){
            if(Math.abs(to.getXPosition() - from.getXPosition()) == 1){
                return true;
            }
        }
        return false;
    }
}
