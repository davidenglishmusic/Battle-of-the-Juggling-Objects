import java.util.Hashtable;
import java.util.Enumeration;

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
    private Hashtable<Location, GamePiece> startingPositions;

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

    public void setRows(int newNumberOfRows)
    {
        if(newNumberOfRows > 0){
            rows = newNumberOfRows;
        }
    }

    public void setColumns(int newNumberOfColumns)
    {
        if(newNumberOfColumns > 0){
            columns = newNumberOfColumns;
        }
    }

    public void setEmptySpotDisplay(String newEmptySpotDisplay)
    {
        if(newEmptySpotDisplay != null && newEmptySpotDisplay.length() == 1){
            emptySpotDisplay = newEmptySpotDisplay;
        }
    }

    public void setStartingPositions(Hashtable<Location, GamePiece> newStartingPositions)
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

    public void populateBoard()
    {
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                board[i][j] = null;
            }
        }
    }

    private void addPlayerPiecesToBoard()
    {
        Enumeration<Location> enumKey = startingPositions.keys();
        while(enumKey.hasMoreElements()) {
            Location key = enumKey.nextElement();
            GamePiece piece = startingPositions.get(key);
            board[key.getXPosition()][key.getYPosition()] = piece;
        }
    }

    public void displayBoard()
    {
        System.out.println(getBoardString());
    }

    private String getBoardString()
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
}
