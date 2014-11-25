
/**
 * Write a description of class GamePiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class GamePiece
{
    private String pieceDisplay;
    private Player owningPlayer;

    public GamePiece()
    {
        setPieceDisplay("");
        setOwningPlayer(null);
    }

    public GamePiece(String newPieceDisplay, Player newOwningPlayer)
    {
        setPieceDisplay(newPieceDisplay);
        setOwningPlayer(newOwningPlayer);
    }
    
    public void setPieceDisplay(String newPieceDisplay)
    {
        if(newPieceDisplay != null && newPieceDisplay.length() == 1)
        {
            pieceDisplay = newPieceDisplay;
        }
    }
    
    public void setOwningPlayer(Player newOwningPlayer)
    {
        if(newOwningPlayer != null){
            owningPlayer = newOwningPlayer;
        }
    }
    
    public String getPieceDisplay()
    {
        return pieceDisplay;
    }
    
    public String toString()
    {
        return getPieceDisplay();
    }
    
    abstract public boolean isLegalMove(Location from, Location to);
}
