
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
    
    public boolean isLegalMove()
    {
        return true;
    }
}
