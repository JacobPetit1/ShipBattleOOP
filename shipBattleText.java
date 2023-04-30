import java.util.Scanner;

public class shipBattleText 
{
    public Scanner input = new Scanner(System.in);
    public ship PlayerShip = new ship();
    public ship CPUShip = new ship();
    public gameBoard playerGameBoard = new gameBoard(5, 5);;
    public gameBoard cpuGameBoard = new gameBoard(5,5);
    /*  This class will start to build the rules of the game
     *  Starting with initial building the board, probably will 
     * set define the bounds of the board here
     *  Initially create the player ship to your liking and I might
     * create a separate class to handle the AI opponent.
     *  Use the information here to make sure the game works over text
     * then we can transfer this to the JFrame.
     * 
     * Similarly, we can use this for the shipBattle with the jFrame,
     * just incorporate the text with the Frame.
     * 
     */

    //to avoid using system.out.print()
    public void print(String args)
    {
        System.out.print(args);
    }

     public String startGameMessage()
     {
        String gameMessage = "Welcome to ShipBattle... \n"
        +"this is your BattleShip type game. \n"
        +"You will be asked to place your ship, please \n"
        +"place this in the grid, then you will take turns \n"
        +"guessing where the other ship is and sink them. \n"
        +"\n";
        
        return gameMessage;
     }


     public String shipPlacementQuery()
     {
        String placementQuery = "Click where you would like\n"
        + "to place your ship.\n"
        + "\n";

        return placementQuery;
     }


     public void initializeShips()
     {
        PlayerShip.setShipLength(3);
        CPUShip.setShipLength(3);
        PlayerShip.setShipIdentifier(1);
        CPUShip.setShipIdentifier(2);
     }
     public void playerGameBoard()
     {
        print(shipPlacementQuery());
        try
        {
            PlayerShip.setHeadXIndex(input.nextInt());
            PlayerShip.setHeadYIndex(input.nextInt());
        }
        catch(Exception e)
        {
            //invalid position exits the game
            print("an error occured");
            System.exit(0);
        }

        print("Choose 0 for vertical and 1 for horizontal placement:\n");

        PlayerShip.setShipDirection(input.nextInt());
        playerGameBoard.placeShip(PlayerShip);
     }

    public void printBoard(gameBoard boardToPrint)
     {
        print(boardToPrint.toString());
     }
     




    public static void main(String[] args)
    {
        shipBattleText game = new shipBattleText();
        game.initializeShips();;
        game.print(game.startGameMessage());
        game.playerGameBoard();
        game.printBoard(game.playerGameBoard);
    }

}
