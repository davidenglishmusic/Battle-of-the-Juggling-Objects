import java.util.Hashtable;
import java.util.Enumeration;

/**
 * A class representing a board
 * 
 * @author David English
 * @version 2014.11.28
 */
public class Board
{
    private GamePiece[][] board;
    private int rows;
    private int columns;
    private String emptySpotDisplay;
    private Hashtable<Location, GamePiece> startingPositions;

    /**
     * Default Board Constructor
     *
     */
    public Board()
    {
        setRows(0);
        setColumns(0);
        board = new GamePiece[getRows()][getColumns()];
        setEmptySpotDisplay("");
        setStartingPositions(null);
        populateBoard();
        addPlayerPiecesToBoard();
    }

    /**
     * Board Constructor
     *
     * @param newNumberOfRows the number of rows for the board
     * @param newNumberOfColumns the number of columns for the board
     * @param newEmptySpotDisplay the string to represent an empty space on the board
     * @param newStartingPositions the starting positions of both players' pieces
     */
    public Board(int newNumberOfRows, int newNumberOfColumns, String newEmptySpotDisplay, Hashtable<Location, GamePiece> newStartingPositions)
    {
        setRows(newNumberOfRows);
        setColumns(newNumberOfColumns);
        board = new GamePiece[getRows()][getColumns()];
        setEmptySpotDisplay(newEmptySpotDisplay);
        setStartingPositions(newStartingPositions);
        populateBoard();
        addPlayerPiecesToBoard();
    }

    /**
     * Method setRows
     *
     * @param newNumberOfRows the number of rows for the board
     */
    public void setRows(int newNumberOfRows)
    {
        if(newNumberOfRows > 0){
            rows = newNumberOfRows;
        }
    }

    /**
     * Method setColumns
     *
     * @param newNumberOfColumns the number of columns for the board
     */
    public void setColumns(int newNumberOfColumns)
    {
        if(newNumberOfColumns > 0){
            columns = newNumberOfColumns;
        }
    }

    /**
     * Method setEmptySpotDisplay
     *
     * @param newEmptySpotDisplay the string to represent an empty space on the board
     */
    public void setEmptySpotDisplay(String newEmptySpotDisplay)
    {
        if(newEmptySpotDisplay != null && newEmptySpotDisplay.length() == 1){
            emptySpotDisplay = newEmptySpotDisplay;
        }
    }

    /**
     * Method setStartingPositions
     *
     * @param newStartingPositions the starting positions of both players' pieces
     */
    public void setStartingPositions(Hashtable<Location, GamePiece> newStartingPositions)
    {
        if(newStartingPositions != null){
            startingPositions = newStartingPositions;
        }
    }

    /**
     * Method getRows
     *
     * @return the number of rows
     */
    public int getRows()
    {
        return rows;
    }

    /**
     * Method getColumns
     *
     * @return the number of columns
     */
    public int getColumns()
    {
        return columns;
    }

    /**
     * Method getEmptySpotDisplay
     *
     * @return the string representing an empty space on the board
     */
    public String getEmptySpotDisplay()
    {
        return emptySpotDisplay;
    }

    /**
     * Method getStartingPositions
     *
     * @return the starting positions of both players' pieces
     */
    public Hashtable getStartingPositions()
    {
        return startingPositions;
    }

    /**
     * Method populateBoard
     *
     * Populates the board with null objects
     *
     */
    public void populateBoard()
    {
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                board[i][j] = null;
            }
        }
    }

    /**
     * Method addPlayerPiecesToBoard
     *
     * Adds the player pieces to the boards based on the starting positions
     *
     */
    private void addPlayerPiecesToBoard()
    {
        Enumeration<Location> enumKey = startingPositions.keys();
        while(enumKey.hasMoreElements()) {
            Location key = enumKey.nextElement();
            GamePiece piece = startingPositions.get(key);
            board[key.getXPosition()][key.getYPosition()] = piece;
        }
    }

    /**
     * Method getBoard
     *
     * @return a string of the board in its current state
     */
    public String getBoard()
    {
        String boardString = "";
        char columnLetter = 'a';
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(i == 0 && j == 0){
                    boardString += " " + " ";
                }
                else if(i == 0){
                    boardString += String.valueOf(columnLetter) + " ";
                    columnLetter += 1;
                }
                else if(j == 0){
                    boardString += String.valueOf(i) + " ";
                }
                else if(board[i][j] == null){
                    boardString += getEmptySpotDisplay() + " ";
                }
                else{
                    boardString += board[i][j].toString() + " ";
                }
            }
            boardString += "\n";
        }
        return boardString;
    }

    /**
     * Method getPlayerPieceTally
     *
     * @param player the player to query for pieces remaining on the board
     * @return the number of pieces of that player that are still on the board
     */
    public int getPlayerPieceTally(Player player)
    {
        int tally = 0;
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(board[i][j] != null && board[i][j].getOwningPlayer() == player){
                    tally += 1;
                }
            }
        }
        return tally;
    }
    
    /**
     * Method getPlayerPieceAtLocation
     *
     * @param location a location on the board
     * @return the game piece at that position
     */
    public GamePiece getPlayerPieceAtLocation(Location location)
    {
        if(board[location.getXPosition()][location.getYPosition()] != null)
            return board[location.getXPosition()][location.getYPosition()];
        else{
            return null;
        }
    }
    
    /**
     * Method setPieceAtLocation
     *
     * @param location a location on the board
     * @param pieceMovingIn the game piece to set at that position
     */
    public void setPieceAtLocation(Location location, GamePiece pieceMovingIn)
    {
        if(location.getXPosition() >= getRows() && location.getYPosition() >= getColumns()){
            return;
        }
        if(location.getXPosition() < 1 && location.getYPosition() < 1){
            return;
        }
        board[location.getXPosition()][location.getYPosition()] = pieceMovingIn;
    }
}
