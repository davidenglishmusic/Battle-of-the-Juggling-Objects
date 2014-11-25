
/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        if(from.getXPosition() == to.getXPosition()){
            if(Math.abs(to.getYPosition() - from.getYPosition()) == 1){
                return true;
            }
        }
        return false;
    }
}
