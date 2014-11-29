
/**
 * A class representing a ball
 * 
 * @author David English
 * @version 2014.11.28
 */
public class Ball extends GamePiece
{
    /**
     * Default Ball Constructor
     *
     */
    public Ball()
    {
        super("", null);
    }
    
    /**
     * Ball Constructor
     *
     * @param newPieceDisplay a string to represent the look of the piece
     * @param newOwningPlayer the player who owns the particular piece
     */
    public Ball(String newPieceDisplay, Player newOwningPlayer)
    {
        super(newPieceDisplay, newOwningPlayer);
    }
    
    /**
     * Method isLegalMove
     *
     * @param from the origin location
     * @param to the destination location
     * @return a boolean value, true if the move is legal for that piece or false if it is not
     */
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
