import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;

public class gameJPanel extends JFrame implements ActionListener, KeyListener{


    // Maybe create methods to help access some of these?

    private JMenuBar menuBar;

    private JPanel textPanel;

    private JPanel playerGrid;

    private JPanel computerGrid;

    private JLabel playerLabel;

    private JLabel computerLabel;

    private JTextArea txtArea;

    private JScrollPane scrollPane;

    private final static String newline = "\n";


    // gameJPanel constructer
    public gameJPanel() {

        super("ShipBattle ");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1000, 600);

        setResizable(false);

        setLocationRelativeTo(null);

        GamePanel();

    }

    private void GamePanel() {

        // Create the player grid panel

        playerGrid = new JPanel(new GridLayout(5, 5));

        playerGrid.setPreferredSize(new Dimension(350, 350));

        for (int row = 0; row < 5; row++) {

            for (int col = 0; col < 5; col++) {

                JButton button = new JButton();

                playerGrid.add(button);

            }

        }

        // Create the computer grid panel

        computerGrid = new JPanel(new GridLayout(5, 5));

        computerGrid.setPreferredSize(new Dimension(350, 350));

        for (int row = 0; row < 5; row++) {

            for (int col = 0; col < 5; col++) {

                JButton button = new JButton();

                computerGrid.add(button);

            }

        }

        // Create menu bar and menus. 
        menuBar = new JMenuBar();

        JMenu optionsMenu = new JMenu("Options");
        optionsMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(optionsMenu);

        JMenuItem newGameMenuItem = new JMenuItem("New Game", KeyEvent.VK_O);
        newGameMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // restart game here
            }
        });
        optionsMenu.add(newGameMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save", KeyEvent.VK_S);
        optionsMenu.add(saveMenuItem);
        optionsMenu.addSeparator();

        JMenuItem exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_X);
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        optionsMenu.add(exitMenuItem);
        
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        menuBar.add(editMenu);
        
        // this just clears text
        JMenuItem clearMenuItem = new JMenuItem("Clear Text", KeyEvent.VK_C);
        clearMenuItem.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                txtArea.setText(null); // clears out all old text
                getContentPane().revalidate();
            }
        });        
        editMenu.add(clearMenuItem);
        //add(menuBar, BorderLayout.NORTH);

        // makes a text area that outputs stream text to jpanel

        textPanel = new JPanel();
        txtArea = new JTextArea(10,20);
        scrollPane = new JScrollPane(txtArea);
        txtArea.setEditable(false);
        textPanel.add(txtArea);

        // Create the player and computer labels

        playerLabel = new JLabel("Player Grid", SwingConstants.CENTER);

        computerLabel = new JLabel("Computer Grid", SwingConstants.CENTER);

        // Add components to the content pane

        getContentPane().setLayout(new BorderLayout());

        getContentPane().add(menuBar, BorderLayout.NORTH);

        getContentPane().add(playerGrid, BorderLayout.WEST);
        getContentPane().add(textPanel, BorderLayout.CENTER);

        getContentPane().add(computerGrid, BorderLayout.EAST);

        //getContentPane().add(playerLabel, BorderLayout.NORTH);

        //getContentPane().add(computerLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // abstract methods
    public void actionPerformed(ActionEvent e) {/*leave empty */}
    public void keyPressed(KeyEvent e) {/*leave empty */}
    public void keyReleased(KeyEvent e) {/*leave empty */}
    public void keyTyped(KeyEvent e) {/*leave empty */}

    // method to accessing the text pane
    public void printToTextPane(String args)
    {
        txtArea.append(args + newline);
    }


    public static void main(String[] args) 
    {
        gameJPanel game = new gameJPanel();
        shipBattleText  gameText = new shipBattleText();
        game.printToTextPane(gameText.startGameMessage());
        game.printToTextPane(gameText.shipPlacementQuery());
    }

}