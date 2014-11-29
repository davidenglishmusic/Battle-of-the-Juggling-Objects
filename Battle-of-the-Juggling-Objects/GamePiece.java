
/**
 * An abstract class representing a game piece
 * 
 * @author David English
 * @version 2014.11.28
 */
public abstract class GamePiece
{
    private String pieceDisplay;
    private Player owningPlayer;

    /**
     * Default GamePiece Constructor
     *
     */
    public GamePiece()
    {
        setPieceDisplay("");
        setOwningPlayer(null);
    }

    /**
     * GamePiece Constructor
     *
     * @param newPieceDisplay a string to represent the look of the piece
     * @param newOwningPlayer the player who owns the particular piece
     */
    public GamePiece(String newPieceDisplay, Player newOwningPlayer)
    {
        setPieceDisplay(newPieceDisplay);
        setOwningPlayer(newOwningPlayer);
    }
    
    /**
     * Method setPieceDisplay
     *
     * @param newPieceDisplay a string to represent the look of the piece
     */
    public void setPieceDisplay(String newPieceDisplay)
    {
        if(newPieceDisplay != null && newPieceDisplay.length() == 1)
        {
            pieceDisplay = newPieceDisplay;
        }
    }
    
    /**
     * Method setOwningPlayer
     *
     * @param newOwningPlayer the player who owns the particular piece
     */
    public void setOwningPlayer(Player newOwningPlayer)
    {
        if(newOwningPlayer != null){
            owningPlayer = newOwningPlayer;
        }
    }
    
    /**
     * Method getPieceDisplay
     *
     * @return the display of the piece
     */
    public String getPieceDisplay()
    {
        return pieceDisplay;
    }
    
    /**
     * Method getOwningPlayer
     *
     * @return the owning player
     */
    public Player getOwningPlayer()
    {
        return owningPlayer;
    }
    
    /**
     * Method toString
     *
     * @return the display of the piece
     */
    public String toString()
    {
        return getPieceDisplay();
    }
    
    /**
     * Method isLegalMove
     *
     * @param from the origin location
     * @param to the destination location
     * @return a boolean value, true if the move is legal for that piece or false if it is not
     */
    abstract public boolean isLegalMove(Location from, Location to);
}
