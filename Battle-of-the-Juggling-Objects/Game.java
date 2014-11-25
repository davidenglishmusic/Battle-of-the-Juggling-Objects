import java.util.Hashtable;

/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    private static final String PLAYER_ONE_TORCH_DISPLAY = "T";
    private static final String PLAYER_ONE_BALL_DISPLAY = "O";
    private static final String PLAYER_TWO_TORCH_DISPLAY = "t";
    private static final String PLAYER_TWO_BALL_DISPLAY = "o";
    private static final String EMPTY_SPOT_DISPLAY = "*";
    private static final int ROWS = 5;
    private static final int COLUMNS = 5;

    private Board board;

    private Player playerOne;
    private Player playerTwo;

    private Hashtable<String, GamePiece> startingPositions;

    /**
     * Constructor for objects of class Main
     */
    public Game()
    {

    }

    private void setStartingPositions()
    {
        //playerOne      
        startingPositions.put("12", new Torch(PLAYER_ONE_TORCH_DISPLAY, playerOne));
        startingPositions.put("13", new Torch(PLAYER_ONE_TORCH_DISPLAY, playerOne));
        startingPositions.put("14", new Torch(PLAYER_ONE_TORCH_DISPLAY, playerOne));
        startingPositions.put("22", new Ball(PLAYER_ONE_TORCH_DISPLAY, playerOne));
        startingPositions.put("23", new Ball(PLAYER_ONE_TORCH_DISPLAY, playerOne));
        startingPositions.put("24", new Ball(PLAYER_ONE_TORCH_DISPLAY, playerOne));

        //playerTwo
        startingPositions.put("52", new Torch(PLAYER_TWO_TORCH_DISPLAY, playerTwo));
        startingPositions.put("53", new Torch(PLAYER_TWO_TORCH_DISPLAY, playerTwo));
        startingPositions.put("54", new Torch(PLAYER_TWO_TORCH_DISPLAY, playerTwo));
        startingPositions.put("42", new Ball(PLAYER_TWO_TORCH_DISPLAY, playerTwo));
        startingPositions.put("43", new Ball(PLAYER_TWO_TORCH_DISPLAY, playerTwo));
        startingPositions.put("44", new Ball(PLAYER_TWO_TORCH_DISPLAY, playerTwo));
    }

}
