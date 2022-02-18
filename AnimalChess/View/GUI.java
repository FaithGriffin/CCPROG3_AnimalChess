package View;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.*;

import Model.Game;
import Model.ModelMainMenu;

import java.awt.Container;
import javax.swing.border.*;
import java.awt.event.MouseListener;
import java.awt.event.*;

/** 
* Represents a GUI
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class GUI{
    protected static final Color GOLD = new Color(255,204,51);
    protected static final Color LIGHT_BROWN = new Color(153,102,0);
    protected static final Color CADET_BLUE = new Color(95,158,160);
    protected static final Color GOLDEN_ROD = new Color(218,165,32);
    protected static final Color SOMEWHAT_YELLOW = new Color(210,144,25);
    protected static final Color SOMEWHAT_RED = new Color(205,33,57);
    protected static final Color SOMEWHAT_BROWN = new Color(112,62,1);
    protected static final Color SOMEWHAT_BLUE = new Color(65,139,202);
    protected static final Color DARK_ORANGE = new Color(255,140,0);
    protected static final Color DARK_CYAN = new Color(0,139,139);
    protected static final Color MEDIUM_VIOLET_RED = new Color(218,112,214);
    protected static final Color HOT_PINK = new Color(255,105,180);
    protected static final Color TEAL = new Color(0,128,128);
    protected static final Color ORCHID = new Color(218,112,214);
    protected static final Color ORANGE = new Color(255,165,0);
    protected static final Color SOMEWHAT_MAROON = new Color(167,0,41);
    
    

    private JFrame screen;
    private Container container;
    private MainMenu clsMainMenu;
    private HowToPlay clsHowToPlay;
    private SoundSettings clsSoundSettings;
    private SetUpGame clsSetUpGame;
    private GameView clsGame;
    private JButton btnBackToMainMenu1;
    private JButton btnBackToMainMenu2;
    private String[][] animalPics;


    /** 
    * Constructs a new GUI object
    *
    * @param gameMainMenu      the current instance of ModelMainMenu
    */
    public GUI(ModelMainMenu gameMainMenu){
        screen = new JFrame("Animal Chess");
        screen.setSize(new Dimension(960, 768));
        screen.setLayout(new BorderLayout());
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.getContentPane().setBackground(CADET_BLUE);
        container = screen.getContentPane();
        initializeAnimalPics();

        initializeGUIParts(gameMainMenu);
        showMainMenu();

        screen.setVisible(true);
        //System.out.println("Main" + clsGame.getGameProper().getGamePieces().getPiece(0, 0).getTileNum());
    }


    /** 
    * This function initilaizes the file names to be used during set up game
    *
    */
    public void initializeAnimalPics(){
        animalPics = new String[2][9];
        String[] strAnimalFiles = {"Rmouse", "Rcat", "Rwolf", "Rdog", "Rleopard", "Rtiger", "Rlion", "Relephant", "Rblank",
                                    "Bmouse", "Bcat", "Bwolf", "Bdog", "Bleopard", "Btiger", "Blion", "Belephant", "Bblank"};
        for(int i = 0, k = 0; i < 2; i++){
            for(int j = 0; j < 9; j++){
                animalPics[i][j] = strAnimalFiles[k];
                k++;
            }
        }
    }


    /** 
    * This function returns the clsGame attribute of a GUI object
    *
    * @return GameView    the clsGame attribute of a GUI object
    */
    public GameView getClsGameView(){
        return clsGame;
    }


    /** 
    * This function adds the drag layer from an instance of the GameController object
    *
    * @param pane    the JLayeredPane to be added to the container attribute of a GUI object
    */
    public void addDragLayer(JLayeredPane pane){
        container.add(pane);
    }


    /** 
    * This function initiliazes btnBackToMainMenu1
    *
    */
    public void initializeBtnBackToMainMenu(){
        btnBackToMainMenu1 = new JButton("Go back to Main Menu");
        btnBackToMainMenu1.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnBackToMainMenu1.setBackground(GUI.GOLDEN_ROD);
        btnBackToMainMenu1.setForeground(Color.white);
        btnBackToMainMenu1.setUI(new StyledButtonUI(10,15,10,15));
        btnBackToMainMenu1.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnBackToMainMenu2 = new JButton("Go back to Main Menu");
        btnBackToMainMenu2.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        btnBackToMainMenu2.setBackground(GUI.GOLDEN_ROD);
        btnBackToMainMenu2.setForeground(Color.white);
        btnBackToMainMenu2.setUI(new StyledButtonUI(10,15,10,15));
        btnBackToMainMenu2.setAlignmentX(Component.CENTER_ALIGNMENT);
    }


    /** 
    * This function initializes the clsMainMenu, clsHowToPlay, clsSoundSettings, clsSetUpGame, 
    * and clsGame of a GUI object
    *
    * @param gameMainMenu the current instance of ModelMainMenu
    */
    public void initializeGUIParts(ModelMainMenu gameMainMenu){
        clsMainMenu = new MainMenu();
        clsHowToPlay = new HowToPlay(gameMainMenu.getStrInstructions());
        clsSoundSettings = new SoundSettings();
        clsSetUpGame = new SetUpGame();
        initializeBtnBackToMainMenu();
        clsHowToPlay.getPnlInstructions().add(btnBackToMainMenu1);
        clsSoundSettings.getPnlSoundSettings().add(btnBackToMainMenu2);
        clsGame = new GameView(gameMainMenu.getGame());
    }


    /** 
    * This function adds an ActionListener to the buttons of the different parts of a GUI object
    *
    * @param listener    the ActionListener to be added as the action listener of the different buttons
    */
    public void setActionListeners(ActionListener listener){
        clsMainMenu.getBtnStartGame().addActionListener(listener);
        clsMainMenu.getBtnHowToPlay().addActionListener(listener);
        btnBackToMainMenu1.addActionListener(listener);
        btnBackToMainMenu2.addActionListener(listener);
        clsMainMenu.getBtnSoundSettings().addActionListener(listener);
        clsSoundSettings.getBtnTrack1().addActionListener(listener);
        clsSoundSettings.getBtnTrack2().addActionListener(listener);
        clsSoundSettings.getBtnTrack3().addActionListener(listener);
        clsSoundSettings.getBtnDefaultTrack().addActionListener(listener);
        clsMainMenu.getBtnExitButton().addActionListener(listener);

        clsSetUpGame.getBtnDone().addActionListener(listener);
        clsSetUpGame.getBtnDrawPlayer1().addActionListener(listener);
        clsSetUpGame.getBtnDrawPlayer2().addActionListener(listener);
        clsSetUpGame.getBtnDoneDraw().addActionListener(listener);
        clsSetUpGame.getBtnBlueTeam().addActionListener(listener);
        clsSetUpGame.getBtnRedTeam().addActionListener(listener);

        clsGame.getGameNorthDisplay().getBtnQuitGame().addActionListener(listener);
        clsGame.getGameNorthDisplay().getBtnSoundOnOff().addActionListener(listener);
        clsGame.getGameNorthDisplay().getBtnUndo().addActionListener(listener);
        clsGame.getGameNorthDisplay().getBtnRedo().addActionListener(listener);
    }


    /** 
    * This function adds a MouseListener to the current BoardPieces object 
    *
    * @param listener    the MouseListener to be added as the mouse listener of the current BoardPieces object
    */
    public void setMouseListener(MouseListener listener){
        clsGame.getGameProper().getGamePieces().getPnlBoardPieces().addMouseListener(listener);
    }


    /** 
    * This function adds a MouseMotionListener to the current BoardPieces object 
    *
    * @param listener    the MouseMotionListener to be added as the mouse listener of the current BoardPieces object
    */
    public void setMouseDragListener(MouseMotionListener listener){
        clsGame.getGameProper().getGamePieces().getPnlBoardPieces().addMouseMotionListener(listener);
    }


    /** 
    * This function adds the pnlMainMenu of the clsMainMenu object to the container attribute of a GUI object 
    * and sets the visibility of the other GUI parts to ultimately show the Main Menu
    * 
    */
    public void showMainMenu(){
        container.add(clsMainMenu.getPnlMainMenu());
        screen.getContentPane().setBackground(CADET_BLUE);
        clsHowToPlay.getPnlInstructions().setVisible(false);
        clsSoundSettings.getPnlSoundSettings().setVisible(false);
        clsSetUpGame.getPnlSetUpGame().setVisible(false);
        clsSetUpGame.getPnlDrawAnimal().setVisible(false);
        clsSetUpGame.getPnlChooseColor().setVisible(false);
        clsGame.getPnlGameView().setVisible(false);
        clsMainMenu.getPnlMainMenu().setVisible(true);
    }


    /** 
    * This function adds the pnlInstructions of the clsHowToPlay object to the container attribute of a GUI object 
    * and sets the visibility of the other GUI parts to ultimately show the game instructions
    * 
    */
    public void showHowToPlay(){
        container.add(clsHowToPlay.getPnlInstructions());
        clsMainMenu.getPnlMainMenu().setVisible(false);
        clsHowToPlay.getPnlInstructions().setVisible(true);
    }


    /** 
    * This function adds the pnlSoundSettings of the clsSoundSettings object to the container attribute of a GUI object 
    * and sets the visibility of the other GUI parts to ultimately show the sound settings
    * 
    */
    public void showSoundSettings(){
        container.add(clsSoundSettings.getPnlSoundSettings());
        clsMainMenu.getPnlMainMenu().setVisible(false);
        clsSoundSettings.getPnlSoundSettings().setVisible(true);
    }


    /** 
    * This function adds the pnlSetUpGame of the clsSetUpGame object to the container attribute of a GUI object 
    * and sets the visibility of the other GUI parts to ultimately show the set up game
    * 
    */
    public void showSetUpGame(){
        container.add(clsSetUpGame.getPnlSetUpGame());
        clsMainMenu.getPnlMainMenu().setVisible(false);
        clsSetUpGame.getPnlSetUpGame().setVisible(true);
    }


    /** 
    * This function updates the draw animal panel inside the clsSetUpGame object of a GUI object, adds it to the container
    * attribute of a GUI object, and sets the visibility of the other GUI parts to ultimately show the draw animal panel
    * 
    * @param strName1         the name of player 1
    * @param strName2         the name of player 2
    * @param strDrawnAnimal1   the name of the animal that player 1 drew
    * @param strDrawnAnimal2   the name of the animal that player 2 drew
    */
    public void showDrawAnimal(String strName1, String strName2, String strDrawnAnimal1, String strDrawnAnimal2){
        clsSetUpGame.updatePnlDrawAnimal(strName1, strName2, strDrawnAnimal1, strDrawnAnimal2);
        container.add(clsSetUpGame.getPnlDrawAnimal());
        clsSetUpGame.getPnlSetUpGame().setVisible(false);
        clsSetUpGame.getPnlDrawAnimal().setVisible(true);
    }


    /** 
    * This function updates the choose color panel inside the clsSetUpGame object of a GUI object, adds it to the container
    * attribute of a GUI object, and sets the visibility of the other GUI parts to ultimately show the choose color panel
    * 
    * @param strDrawWinner         the name of the player who won the draw
    */
    public void showChooseColor(String strDrawWinner){
        clsSetUpGame.getPnlDrawAnimal().setVisible(false);
        clsSetUpGame.updatePnlChooseColor(strDrawWinner);
        container.add(clsSetUpGame.getPnlChooseColor());
        clsSetUpGame.getPnlChooseColor().setVisible(true);
    }


    /** 
    * This function updates the north display panel inside the clsSetUpGame objest of a GUI object, adds it to the container
    * attribute of a GUI object, and sets the visibility of the other GUI parts to ultimately show the game view panel
    * 
    * @param strTurn          the team in turn
    * @param nRScore          the number of kills RED team currently has
    * @param nBScore          the number of kills BLUE team currently has
    */
    public void showGame(String strTurn, int nRScore, int nBScore){
        container.add(clsGame.getPnlGameView());
        screen.getContentPane().setBackground(SOMEWHAT_YELLOW);
        clsGame.getGameNorthDisplay().updateNorthDisplay(strTurn, nRScore, nBScore);
        clsSetUpGame.getPnlChooseColor().setVisible(false);
        clsGame.getPnlGameView().setVisible(true);
    }


    /** 
    * This function sets the enabled value of the btnDone of a SetUpGame object
    * 
    * @param bNew          the new boolean value to be set as the enable value of btnDone
    */
    public void updateDoneButton(boolean bNew){
        clsSetUpGame.getBtnDone().setEnabled(bNew);
    }


    /** 
    * This function sets the enabled value of the btnDrawPlayer1 of a SetUpGame object
    * 
    * @param bNew          the new boolean value to be set as the enable value of btnDrawPlayer1
    */
    public void updateDrawButton1(boolean bNew){
        clsSetUpGame.getBtnDrawPlayer1().setEnabled(bNew);
    }


    /** 
    * This function sets the enabled value of the btnDrawPlayer2 of a SetUpGame object
    * 
    * @param bNew          the new boolean value to be set as the enable value of btnDrawPlayer2
    */
    public void updateDrawButton2(boolean bNew){
        clsSetUpGame.getBtnDrawPlayer2().setEnabled(bNew);
    }


    /** 
    * This function sets the enabled value of the btnDoneDraw of a SetUpGame object
    * 
    * @param bNew          the new boolean value to be set as the enable value of btnDoneDraw
    */
    public void updateDrawDoneButton(boolean bNew){
        clsSetUpGame.getBtnDoneDraw().setEnabled(bNew);
    }


    /** 
    * This function updates the icon of the first label during draw animals
    * 
    * @param n          the int value that tells the location of an animal picture in animalPics[][]
    */
    public void updateDrawnAnimalLabel1(int n){
        clsSetUpGame.updateLbl1(animalPics[0][n]);
    }


    /** 
    * This function updates the icon of the second label during draw animals
    * 
    * @param n          the int value that tells the location of an animal picture in animalPics[][]
    */
    public void updateDrawnAnimalLabel2(int n){
        clsSetUpGame.updateLbl2(animalPics[0][n]);
    }


    /** 
    * This function returns the JTextField where player one is expected to enter their name
    * 
    * @return JTextField    the JTextField that is the txtfldPlayer1 of a SetUp game object
    */
    public JTextField getPlayer1Name(){
        return clsSetUpGame.getTxtfldPlayer1();
    }


    /** 
    * This function returns the JTextField where player two is expected to enter their name
    * 
    * @return JTextField    the JTextField that is the txtfldPlayer2 of a SetUp game object
    */
    public JTextField getPlayer2Name(){
        return clsSetUpGame.getTxtfldPlayer2();
    }


    /** 
    * This function updates the text of the btnSoundOnOff
    * 
    * @param strNew    the new String value of the btnSoundOnOff of a GameProperAddOns object
    */
    public void updateSoundOnOffBtn(String strNew){
        clsGame.getGameNorthDisplay().getBtnSoundOnOff().setText(strNew);
    }


    /** 
    * This function shows the no name pop-up error
    * 
    * @apiNote		   Jain, A.(2019, June 04). tutorialspoint. Retrieved 2021, August 29 from 
    *                  https://www.tutorialspoint.com/java-program-to-set-an-icon-for-joptionpane 
    */
    public void showNoNameError(){
        JPanel pnlError1 = new JPanel();
        pnlError1.setLayout(new FlowLayout());

        ImageIcon icnError = new ImageIcon("lib/utilities/errorIcon.png");
        JLabel lblImage = new JLabel(icnError);
        lblImage.setBackground(SOMEWHAT_MAROON);
        lblImage.setUI(new StyledLabelUI(5,10,5,10));
        pnlError1.add(lblImage);

        JLabel lblError = new JLabel("Ahoy! Input your name, Matey :((");
        lblError.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        lblError.setBackground(SOMEWHAT_MAROON);
        lblError.setForeground(Color.white);
        lblError.setUI(new StyledLabelUI(15,20,15,20));
        pnlError1.add(lblError);
        pnlError1.setOpaque(false);
        JOptionPane.showMessageDialog(container,pnlError1,"xxx OH NOOO!!! xxx", JOptionPane.DEFAULT_OPTION);
        
    }


    /** 
    * This function shows the invalid move pop-up error
    * 
    * @apiNote       Jain, A.(2019, June 04). tutorialspoint. Retrieved 2021, August 29 from 
    *                  https://www.tutorialspoint.com/java-program-to-set-an-icon-for-joptionpane 
    */
    public void showInvalidMoveError(){
        JPanel pnlError2 = new JPanel();
        pnlError2.setLayout(new FlowLayout());

        ImageIcon icnError = new ImageIcon("lib/utilities/errorIcon.png");
        JLabel lblImage = new JLabel(icnError);
        lblImage.setBackground(SOMEWHAT_MAROON);
        lblImage.setUI(new StyledLabelUI(5,10,5,10));
        pnlError2.add(lblImage);

        JLabel lblError = new JLabel("Ahoy! Invalid Move, Matey :((");
        lblError.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        lblError.setBackground(SOMEWHAT_MAROON);
        lblError.setForeground(Color.white);
        lblError.setUI(new StyledLabelUI(15,20,15,20));
        pnlError2.add(lblError);
        pnlError2.setOpaque(false);
        JOptionPane.showMessageDialog(container,pnlError2,"xxx OH NOOO!!! xxx", JOptionPane.DEFAULT_OPTION);
    }


    /** 
    * This function shows the winner pop-up message
    * 
    * @apiNote       		Jain, A.(2019, June 04). tutorialspoint. Retrieved 2021, August 29 from 
    *                  https://www.tutorialspoint.com/java-program-to-set-an-icon-for-joptionpane 
    * @param strWinner name of the player who won
    */
    public void showWinner(String strWinner){
        JPanel pnlWinner = new JPanel();
        pnlWinner.setLayout(new FlowLayout());

        ImageIcon icnError = new ImageIcon("lib/utilities/winIcon.png");
        JLabel lblImage = new JLabel(icnError);
        lblImage.setBackground(SOMEWHAT_YELLOW);
        lblImage.setUI(new StyledLabelUI(5,10,5,10));
        pnlWinner.add(lblImage);

        JLabel lblError = new JLabel("Congratulations, " + strWinner + "!!! YOU WONNN!!!");
        lblError.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        lblError.setBackground(SOMEWHAT_YELLOW);
        lblError.setForeground(Color.white);
        lblError.setUI(new StyledLabelUI(15,20,15,20));
        pnlWinner.add(lblError);
        pnlWinner.setOpaque(false);
        JOptionPane.showMessageDialog(container,pnlWinner,"xxx CONGRATSSS!! xxx", JOptionPane.DEFAULT_OPTION);
    }


    /** 
    * This function resets the GUI object
    * 
    * @param  game      the reset instance of the model.Game class
    */
    public void resetGUI(Game game){
        clsGame.getGameProper().getGamePieces().resetBoardPieces(game);
        showMainMenu();
    }


    /** 
    * This function updates the GUI object based on the model
    * 
    * @param  game      the current instance of the model.Game class
    */
    public void updateDisplay(Game game){
        clsGame.updateGameView(game);
    }


    /** 
    * Represents a StyledLabelUI
    *
    * @reference   Walser, P.(2014, May 16). stack overflow. Retrieved 2021, August 27 from https://stackoverflow.com/a/23699047
    */
    private class StyledLabelUI extends BasicLabelUI{
        private int x;
        private int y;
        private int x2;
        private int y2;


        /** 
        * Constructs a new StyledLabelUI
        *
        * 
        */
        public StyledLabelUI(int a, int b, int c, int d){
            x = a;
            y = b;
            x2 = c;
            y2 = d;
        }


        /** 
        * This function overrides the installUI method
        *
        * @param c        the JComponent to be customized
        */
        @Override
        public void installUI (JComponent c) {
            super.installUI(c);
            JLabel label = (JLabel) c;
            label.setOpaque(false);
            label.setBorder(new EmptyBorder(x,y,x2,y2));
        }


        /** 
        * This function overrides the paint method
        *
        * @param g       an instance of Graphics
        * @param c       the JComponent to be customized
        */
        @Override
        public void paint (Graphics g, JComponent c) {
            JLabel b = (JLabel) c;
            paintBackground(g, b, 2);
            super.paint(g, c);
        }


        /** 
        * This function paints the background of a JComponent
        *
        * @param g          an instance of Graphics
        * @param c          the JComponent object to be customized
        * @param yOffset    the int value that allows the customization of a JComponent object
        */
        private void paintBackground (Graphics g, JComponent c, int yOffset) {
            Dimension size = c.getSize();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(c.getBackground().darker());
            g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
            g.setColor(c.getBackground());
            g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
        }
    }


    /** 
    * Represents a StyledButtonUI
    *
    * @reference   Walser, P.(2014, May 16). stack overflow. Retrieved 2021, August 27 from https://stackoverflow.com/a/23699047
    */
    private class StyledButtonUI extends BasicButtonUI{
        private int x;
        private int y;
        private int x2;
        private int y2;


        /** 
        * Constructs a new StyledButtonUI
        *
        * 
        */
        public StyledButtonUI(int a, int b, int c, int d){
            x = a;
            y = b;
            x2 = c;
            y2 = d;
        }


        /** 
        * This function overrides the installUI method
        *
        * @param c        the JComponent to be customized
        */
        @Override
        public void installUI (JComponent c) {
            super.installUI(c);
            AbstractButton button = (AbstractButton) c;
            button.setOpaque(false);
            button.setBorder(new EmptyBorder(x, y, x2, y2));
        }


        /** 
        * This function overrides the paint method
        *
        * @param g       an instance of Graphics
        * @param c       the JComponent to be customized
        */
        @Override
        public void paint (Graphics g, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
            super.paint(g, c);
        }


        /** 
        * This function paints the background of a JComponent
        *
        * @param g          an instance of Graphics
        * @param c          the JComponent object to be customized
        * @param yOffset    the int value that allows the customization of a JComponent object
        */
        private void paintBackground (Graphics g, JComponent c, int yOffset) {
            Dimension size = c.getSize();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(c.getBackground().darker());
            g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
            g.setColor(c.getBackground());
            g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
        }
    }
}