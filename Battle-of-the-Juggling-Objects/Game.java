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
    private static final int ROWS = 6; // This includes the header row
    private static final int COLUMNS = 6; // This includes the header column

    private Board board;

    private Player playerOne;
    private Player playerTwo;

    private Hashtable<Location, GamePiece> startingPositions;
    
    private Player currentTurn;

    /**
     * Constructor for objects of class Main
     */
    public Game()
    {
        startingPositions = new Hashtable<Location, GamePiece>();
        setStartingPositions();
        playerOne = new Player(1);
        playerTwo = new Player(2);
        currentTurn = playerOne;
        board = new Board(ROWS, COLUMNS, EMPTY_SPOT_DISPLAY, startingPositions);
    }
   
    private void setStartingPositions()
    {
        //playerOne      
        startingPositions.put(new Location(1,2), new Torch(PLAYER_ONE_TORCH_DISPLAY, playerOne));
        startingPositions.put(new Location(1,3), new Torch(PLAYER_ONE_TORCH_DISPLAY, playerOne));
        startingPositions.put(new Location(1,4), new Torch(PLAYER_ONE_TORCH_DISPLAY, playerOne));
        startingPositions.put(new Location(2,2), new Ball(PLAYER_ONE_BALL_DISPLAY, playerOne));
        startingPositions.put(new Location(2,3), new Ball(PLAYER_ONE_BALL_DISPLAY, playerOne));
        startingPositions.put(new Location(2,4), new Ball(PLAYER_ONE_BALL_DISPLAY, playerOne));

        //playerTwo
        startingPositions.put(new Location(5,2), new Torch(PLAYER_TWO_TORCH_DISPLAY, playerTwo));
        startingPositions.put(new Location(5,3), new Torch(PLAYER_TWO_TORCH_DISPLAY, playerTwo));
        startingPositions.put(new Location(5,4), new Torch(PLAYER_TWO_TORCH_DISPLAY, playerTwo));
        startingPositions.put(new Location(4,2), new Ball(PLAYER_TWO_BALL_DISPLAY, playerTwo));
        startingPositions.put(new Location(4,3), new Ball(PLAYER_TWO_BALL_DISPLAY, playerTwo));
        startingPositions.put(new Location(4,4), new Ball(PLAYER_TWO_BALL_DISPLAY, playerTwo));
    }

    public void play(){
        System.out.println(getIntroduction());
    }
    
    private String getIntroduction(){
        String introduction = "";
        introduction += "Welcome to the Battle of the Juggling\n";
        introduction += "Players will take alternating turns moving piece about the board\n";
        introduction += playerOne.toString() + ", your torches are displayed as " + PLAYER_ONE_TORCH_DISPLAY + " and your balls are display as " + PLAYER_ONE_BALL_DISPLAY + "\n";
        introduction += playerTwo.toString() + ", your torches are displayed as " + PLAYER_TWO_TORCH_DISPLAY + " and your balls are display as " + PLAYER_TWO_BALL_DISPLAY + "\n";
        introduction += "A ball can move either up or down, but not sideways. It can can move only one space per turn.";
        introduction += "A torch can move up or down, and also side-to-side. A torch can move any number of spaces, but only in one direction per turn.";
        introduction += "Whoever clears the board of the other player's pieces first will victorious";
        return introduction;
    }
}
