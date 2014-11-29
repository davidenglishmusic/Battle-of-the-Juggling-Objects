
/**
 * A class representing a torch
 * 
 * @author David English
 * @version 2014.11.28
 */
public class Torch extends GamePiece
{
    /**
     * Default Torch Constructor
     *
     */
    public Torch()
    {
        super("", null);
    }
    
    /**
     * Torch Constructor
     *
     * @param newPieceDisplay a string to represent the look of the piece
     * @param newOwningPlayer the player who owns the particular piece
     */
    public Torch(String newPieceDisplay, Player newOwningPlayer)
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
        if(from.getXPosition() != to.getXPosition()){
            if(from.getYPosition() == to.getYPosition()){
                return true;
            }
        }
        if(from.getYPosition() != to.getYPosition()){
            if(from.getXPosition() == to.getXPosition()){
                return true;
            }
        }
        return false;
    }
}
