
/**
 * Write a description of class Torch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Torch extends GamePiece
{
    /**
     * Constructor for objects of class Torch
     */
    public Torch(String newPieceDisplay, Player newOwningPlayer)
    {
        super(newPieceDisplay, newOwningPlayer);
    }

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
