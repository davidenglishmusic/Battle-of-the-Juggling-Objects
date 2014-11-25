import java.util.Hashtable;

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board
{
    private GamePiece[][] board;
    private int rows;
    private int columns;
    private String emptySpotDisplay;
    private Hashtable startingPositions;

    public Board()
    {
        setRows(0);
        setColumns(0);
        board = new GamePiece[getRows()][getColumns()];
        setEmptySpotDisplay("");
        setStartingPositions(null);
    }
    
    public Board(int newNumberOfRows, int newNumberOfColumns, String newEmptySpotDisplay, Hashtable newStartingPositions)
    {
        setRows(newNumberOfRows);
        setColumns(newNumberOfColumns);
        board = new GamePiece[getRows()][getColumns()];
        setEmptySpotDisplay(newEmptySpotDisplay);
        setStartingPositions(newStartingPositions);
    }

    public void setRows(int newNumberOfRows)
    {
        if(newNumberOfRows > 0){
            rows = newNumberOfRows;
        }
    }
    
    public void setColumns(int newNumberOfColumns)
    {
        if(newNumberOfColumns > 0){
            rows = newNumberOfColumns;
        }
    }
    
    public void setEmptySpotDisplay(String newEmptySpotDisplay)
    {
        if(newEmptySpotDisplay != null && newEmptySpotDisplay.length() == 1){
            emptySpotDisplay = newEmptySpotDisplay;
        }
    }
    
    public void setStartingPositions(Hashtable newStartingPositions)
    {
        if(newStartingPositions != null){
            startingPositions = newStartingPositions;
        }
    }
    
    public int getRows()
    {
        return rows;
    }
    
    public int getColumns()
    {
        return columns;
    }
    
    public String getEmptySpotDisplay()
    {
        return emptySpotDisplay;
    }
    
    public Hashtable getStartingPositions()
    {
        return startingPositions;
    }
    
    private void populateBoard()
    {
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                board[i][j] = null;
            }
        }
    }
    
    private void addPlayerPiecesToBoard()
    {
        
    }
    
    public void displayBoard()
    {
        System.out.println(getBoardString());
    }
    
    private String getBoardString()
    {
        String boardString = "";
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(board[i][j] == null){
                    boardString += getEmptySpotDisplay() + " ";
                }
                else{
                    boardString += board[i][j].toString() + " ";
                }
                boardString += "\n";
            }
        }
        return boardString;
    }
}
