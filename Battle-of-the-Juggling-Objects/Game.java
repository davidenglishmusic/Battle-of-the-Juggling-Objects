import java.util.Hashtable;
import java.util.Scanner;
import java.util.regex.Pattern;

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
    private static final String COORDINATE_SPACE_COORDINATE = "\\d[A-Za-z] \\d[A-Za-z]";
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    

    private Board board;

    private Player playerOne;
    private Player playerTwo;

    private Hashtable<Location, GamePiece> startingPositions;
    
    private Player currentPlayerTurn;
    
    private Player winner;
    
    private Scanner userInput;

    /**
     * Constructor for objects of class Main
     */
    public Game()
    {
        playerOne = new Player(1);
        playerTwo = new Player(2);
        winner = null;
        startingPositions = new Hashtable<Location, GamePiece>();
        setStartingPositions();
        currentPlayerTurn = playerOne;
        board = new Board(ROWS, COLUMNS, EMPTY_SPOT_DISPLAY, startingPositions);
        userInput = new Scanner(System.in);
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

    public void play()
    {
        System.out.print('\u000C');
        System.out.println(getIntroduction());
        while(winner == null){
            turn();
        }
        System.out.println(getEnding());
        resetGame();
    }
    
    private void turn()
    {
        boolean successfulMoveCompleted = false;
        while(!successfulMoveCompleted){
            System.out.println(board.getBoard());
            System.out.print(currentPlayerTurn + " enter your move: > ");
            String move = userInput.nextLine();
            if(!isValidMoveInputFormat(move)){
                System.out.println(new InvalidMoveException("Please format your move by: coordinate space coordinate. ie. 3a 3c").getMessage());
            }
            else{
                Location from = new Location(Integer.parseInt(move.substring(0,1)), convertLetterToNumber(move.substring(1,TWO)));
                Location to = new Location(Integer.parseInt(move.substring(THREE,FOUR)), convertLetterToNumber(move.substring(FOUR,FIVE)));               
                if(!originPieceExists(from)){
                    System.out.println(new InvalidMoveException("No piece at the source location.").getMessage());
                }
                else if(!pieceBelongsToPlayer(from)){
                    System.out.println(new InvalidMoveException("That's not your piece.").getMessage());
                }
                else if(!destinationIsOnBoard(to)){
                    System.out.println(new InvalidMoveException("Invalid input for destination location.").getMessage());
                }
                else if(!destinationAndOriginAreDifferent(to, from)){
                    System.out.println(new InvalidMoveException("Invalid move, source and destination cannot be the same.").getMessage());
                }
                else if(!checkIsLegalMoveForPiece(from, to)){
                    System.out.println(new InvalidMoveException("Invalid move for this piece.").getMessage());
                }
                else if(pieceBlockingRoute(from, to)){
                    System.out.println(new InvalidMoveException("Path is not clear.").getMessage());
                }
                else if(samePlayerPieceAtDestination(to)){
                    System.out.println(new InvalidMoveException("You can't capture your own piece.").getMessage());
                }
                else{
                    GamePiece pieceToMove = board.getPlayerPieceAtLocation(from);
                    board.setPieceAtLocation(to, pieceToMove);
                    board.setPieceAtLocation(from, null);
                    successfulMoveCompleted = true;
                }
            }
        }
        endTurn();
    }
    
    private int convertLetterToNumber(String stringLetter)
    {
        if(stringLetter != null && stringLetter.length() == 1){
            char letter = stringLetter.charAt(0);
            return letter - 'a' + 1;
        }
        else{
            return 0;
        }
    }
    
    private boolean isValidMoveInputFormat(String moveInput)
    {
        return Pattern.matches(COORDINATE_SPACE_COORDINATE, moveInput);
    }
    
    private boolean originPieceExists(Location locationOfPiece)
    {
        if(board.getPlayerPieceAtLocation(locationOfPiece) != null){
            return true;
        }
        else{
            return false;
        }
    }
    
    private boolean pieceBelongsToPlayer(Location locationOfPiece)
    {
        if(board.getPlayerPieceAtLocation(locationOfPiece) != null && board.getPlayerPieceAtLocation(locationOfPiece).getOwningPlayer() == currentPlayerTurn){
            return true;
        }
        else{
            return false;
        }
    }
    
    private boolean destinationIsOnBoard(Location destination)
    {
        if(destination.getXPosition() < 1 || destination.getXPosition() > board.getRows() - 1){
            return false;
        }
        else if(destination.getYPosition() < 1 || destination.getYPosition() > board.getColumns() - 1){
            return false;
        }
        else{
            return true;
        }
    }
    
    private boolean destinationAndOriginAreDifferent(Location origin, Location destination)
    {
        if(origin.getXPosition() == destination.getXPosition() && origin.getYPosition() == destination.getYPosition()){
            return false;
        }
        else{
            return true;
        }
    }
    
    private boolean checkIsLegalMoveForPiece(Location origin, Location destination)
    {
        if(board.getPlayerPieceAtLocation(origin) != null){
            return board.getPlayerPieceAtLocation(origin).isLegalMove(origin, destination);
        }
        return false;
    }
    
    private boolean pieceBlockingRoute(Location origin, Location destination)
    {
        boolean pieceBlockingRoute = false;
        if(Math.abs(destination.getXPosition() - origin.getXPosition()) > 1){
            if(destination.getXPosition() > origin.getXPosition()){
                for(int i = origin.getXPosition() + 1; i < destination.getXPosition(); i++){
                    Location locationToTest = new Location(i, origin.getYPosition());
                    if(board.getPlayerPieceAtLocation(locationToTest) != null){
                        pieceBlockingRoute = true;
                    }
                }
            }
            else{
                for(int i = destination.getXPosition() + 1; i < origin.getXPosition(); i++){
                    Location locationToTest = new Location(i, origin.getYPosition());
                    if(board.getPlayerPieceAtLocation(locationToTest) != null){
                        pieceBlockingRoute = true;
                    }
                }
                
            }
        }
        if(Math.abs(destination.getYPosition() - origin.getYPosition()) > 1){
            if(destination.getYPosition() > origin.getYPosition()){
                for(int i = origin.getYPosition() + 1; i < destination.getYPosition(); i++){
                    Location locationToTest = new Location(origin.getXPosition(), i);
                    if(board.getPlayerPieceAtLocation(locationToTest) != null){
                        pieceBlockingRoute = true;
                    }
                }
            }
            else{
                for(int i = destination.getYPosition() + 1; i < origin.getYPosition(); i++){
                    Location locationToTest = new Location(origin.getXPosition(), i);
                    if(board.getPlayerPieceAtLocation(locationToTest) != null){
                        pieceBlockingRoute = true;
                    }
                }
                
            }
        }
        return pieceBlockingRoute;
    }
    
    private boolean samePlayerPieceAtDestination(Location destination)
    {
        if(board.getPlayerPieceAtLocation(destination) != null && board.getPlayerPieceAtLocation(destination).getOwningPlayer() == currentPlayerTurn){
            return true;
        }
        else{
            return false;
        }
    }
    
    private void endTurn()
    {
        if(board.getPlayerPieceTally(playerTwo) == 0){
            winner = playerOne;
        }
        if(board.getPlayerPieceTally(playerOne) == 0){
            winner = playerTwo;
        }
        if(currentPlayerTurn == playerOne){
            currentPlayerTurn = playerTwo;
        }
        else{
            currentPlayerTurn = playerOne;
        }
    }
    
    private String getIntroduction()
    {
        String introduction = "";
        introduction += "Welcome to the Battle of the Juggling Objects\n";
        introduction += "Players will take alternating turns moving piece about the board.\n";
        introduction += playerOne.toString() + ", your torches are displayed as " + PLAYER_ONE_TORCH_DISPLAY + " and your balls are displayed as " + PLAYER_ONE_BALL_DISPLAY + ".\n";
        introduction += playerTwo.toString() + ", your torches are displayed as " + PLAYER_TWO_TORCH_DISPLAY + " and your balls are displayed as " + PLAYER_TWO_BALL_DISPLAY + ".\n";
        introduction += "A ball can move either up or down, but not sideways. It can can move only one space per turn.\n";
        introduction += "A torch can move up or down, and also side-to-side. A torch can move any number of spaces, but only in one direction per turn.\n";
        introduction += "Whoever clears the board of the other player's pieces first will be victorious.\n";
        return introduction;
    }
    
    private String getEnding()
    {
        String ending = "";
        ending += "Congratulations " + winner.toString() + "! You have won the Battle of the Juggling Objects.\n";
        ending += "Thanks for playing!";
        return ending;
    }
    
    public void resetGame()
    {
        winner = null;
        currentPlayerTurn = playerOne;
        board = new Board(ROWS, COLUMNS, EMPTY_SPOT_DISPLAY, startingPositions);
    }
}
