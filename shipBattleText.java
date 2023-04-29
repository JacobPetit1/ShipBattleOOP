import java.util.Scanner;

public class shipBattleText 
{
    Scanner input = new Scanner(System.in);

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

     public void startGameMessage()
     {
        System.out.print("Welcome to shipBattleText... \n"
                        +"this is your battleShip type game. \n"
                        +"You will be asked to place your ship, please \n"
                        +"place this in the grid, then you will take turns \n"
                        +"guessing where the other ship is and sink them.");
     }

     




    public void main(String[] args)
    {
        startGameMessage();
    }

}
