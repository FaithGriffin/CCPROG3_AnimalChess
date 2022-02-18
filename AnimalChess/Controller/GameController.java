package Controller;

import java.io.IOException;
import javax.sound.sampled.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;

import Model.*;
import View.*;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

/** 
* Represents a GameController
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class GameController implements ActionListener, MouseListener, MouseMotionListener{
    private ModelMainMenu gameMainMenu;
    private GUI gui;
    private Clip sound;
    private AudioInputStream audio;
    private FloatControl gainControl;

    private JLayeredPane pnlDragLayer;
    private boolean bDragging;
    private JLabel lblDragAnimal;
    private int nInitX;
    private int nInitY;

    //temporary placeholders
    private int[] nDrawNum;
    private int nTempFirstAttackerIndex;

    /** 
    * Constructs a new GameController object
    *
    */
    public GameController(){
        gameMainMenu = new ModelMainMenu();
        gameMainMenu.getGame().pushArrCells();
        Game.setPlayer("");
        Game.setPlayer("");

        initializeSoundFiles();
        controlSoundVolume(-20);

        nDrawNum = new int[2];
        pnlDragLayer = new JLayeredPane();
        pnlDragLayer.setSize(new Dimension(864, 672));
        pnlDragLayer.setBounds(0,0,864,672);

        gui = new GUI(gameMainMenu);
        gui.addDragLayer(pnlDragLayer);
        gui.setActionListeners(this);
        gui.setMouseListener(this);
        gui.setMouseDragListener(this);
    }


    /** 
    * This function listens to the GUI buttons with an ActionListener and
    * specifies the activities to be done if a particular button is pressed
    *
    * @param e      the ActionEvent that that is passed to every GUI button with an ActionListener
    */
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Start Game")){
            startGame();
        }
        if(e.getActionCommand().equals("Done")){
            getPlayerNames();
        }
        //DRAW
        if(e.getActionCommand().equals(Game.getPlayer(0).getName() + ", Draw")){
            drawPlayer1();
        }
        if(e.getActionCommand().equals(Game.getPlayer(1).getName() + ", Draw")){
            drawPlayer2();
        }
        if(e.getActionCommand().equals("OK")){
            checkIfValidDraw();
        }
        //CHOOSE COLOR
        if(e.getActionCommand().equals("B")){
            assignColor(true, "BLUE");
        }
        if(e.getActionCommand().equals("R")){
            assignColor(false, "RED");
        }
        if(e.getActionCommand().equals("Sound On")){
            turnSoundOn();
        }
        if(e.getActionCommand().equals("Sound Off")){
            turnSoundOff();
        }
        if(e.getActionCommand().equals("Quit Game")){
            quitGameReset();
        }
        if(e.getActionCommand().equals("Undo")){
            undo();
        }
        if(e.getActionCommand().equals("Redo")){
            redo();
        }
        if(e.getActionCommand().equals("How to Play")){
            gui.showHowToPlay();
        }
        if(e.getActionCommand().equals("Sound Settings")){
            gui.showSoundSettings();
        }
        if(e.getActionCommand().equals("Track 1")){
            changeSoundTrack(gameMainMenu.getSettings().getFile(1));
        }
        if(e.getActionCommand().equals("Track 2")){
            changeSoundTrack(gameMainMenu.getSettings().getFile(2));
        }
        if(e.getActionCommand().equals("Track 3")){
            changeSoundTrack(gameMainMenu.getSettings().getFile(3));
        }
        if(e.getActionCommand().equals("Default Track")){
            changeSoundTrack(gameMainMenu.getSettings().getFile(0));
        }
        if(e.getActionCommand().equals("Go back to Main Menu")){
            gui.showMainMenu();
        }
        if(e.getActionCommand().equals("Exit Game")){
            System.exit(0);
        }
    }


    /** 
    * This function initializes the .wav files to be used in the game
    *
    */
    private void initializeSoundFiles()
    {
        try {
            updateAudioInputStream(gameMainMenu.getSettings().getFile(0));
        } catch (UnsupportedAudioFileException e2) {
            e2.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            sound = AudioSystem.getClip();
        } catch (LineUnavailableException e1) {
            e1.printStackTrace();
        }
        try {
            sound.open(audio);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /** 
    * This function gets the audio input stream given a File object
    *
    * @param f     the File object to get the audio input stream from
    */
    private void updateAudioInputStream(File f) throws UnsupportedAudioFileException, IOException{
        audio = AudioSystem.getAudioInputStream(f);
    }


    /** 
    * This function controls the sound volume given a float value
    *
    * @param f     the float value to be set as the new volume of a Clip object
    */
    private void controlSoundVolume(float f){
        gainControl = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(f);
        sound.start();
        sound.loop(Clip.LOOP_CONTINUOUSLY);
    }


    /** 
    * This function starts the game
    *
    */
    private void startGame(){
        gui.updateDoneButton(true);
        gui.updateDrawButton1(true);
        gui.updateDrawButton2(false);
        gui.updateDrawDoneButton(false);
        gui.getPlayer1Name().setText(null);
        gui.getPlayer2Name().setText(null);
        gui.showSetUpGame();
    }


    /** 
    * This function gets the names of the players during a game
    *
    */
    private void getPlayerNames(){
        //if valid
        if(    (gui.getPlayer1Name().getText() != null)
            && (gui.getPlayer2Name().getText() != null)
            && !(gui.getPlayer1Name().getText().equals(gui.getPlayer2Name().getText())) 
            && (gui.getPlayer1Name().getText().matches("[A-Za-z0-9]+"))
            && (gui.getPlayer2Name().getText().matches("[A-Za-z0-9]+")))
        {
            //System.out.println("HELLO");
            Game.getPlayer(0).setName(gui.getPlayer1Name().getText());
            Game.getPlayer(1).setName(gui.getPlayer2Name().getText());
            gui.showDrawAnimal(Game.getPlayer(0).getName(), Game.getPlayer(1).getName(), "Rblank", "Rblank");
        }
        else
        {
            gui.showNoNameError();
        }
    }


    /** 
    * This function lets player one draw an animal
    *
    */
    private void drawPlayer1(){
        nDrawNum[0] = gameMainMenu.getGame().draw();
        gui.updateDrawnAnimalLabel1(nDrawNum[0]);
        gui.updateDrawButton1(false);
        gui.updateDrawButton2(true);
        gui.updateDrawDoneButton(false);
    }


    /** 
    * This function lets player two draw an animal
    *
    */
    private void drawPlayer2(){
        nDrawNum[1] = gameMainMenu.getGame().draw();
        gui.updateDrawnAnimalLabel2(nDrawNum[1]);
        gui.updateDrawButton2(false);
        gui.updateDrawDoneButton(true);
    }


    /** 
    * This function checks if a player won the draw by drawing an animal with higher rank
    *
    */
    private void checkIfValidDraw(){
        if(nDrawNum[0] == nDrawNum[1]){
            //add pop-up
            gui.updateDrawnAnimalLabel1(8);
            gui.updateDrawnAnimalLabel2(8);
            gui.updateDrawButton1(true);
            gui.updateDrawDoneButton(false);
        }
        else{
            if(nDrawNum[0] > nDrawNum[1]){
                nTempFirstAttackerIndex = 0;
            }
            else{
                nTempFirstAttackerIndex = 1;
            }
            // ANOTHER FUNCTION
            gui.showChooseColor(Game.getPlayer(nTempFirstAttackerIndex).getName());
        }
    }


    /** 
    * This function assigns a color to the players
    *
    * @param bColor        the boolean value corresponding to the team color of a player;
    *                      true if BLUE, and false if RED
    * @param strColor      the String value corresponding to the team color of a player
    */
    private void assignColor(boolean bBlue, String strColor){
        gameMainMenu.getGame().setPlayerInTurn(bBlue);
        gui.showGame(strColor, 0, 0);
        Game.getPlayer(nTempFirstAttackerIndex).setColor(bBlue);
    }


    /** 
    * This function turns on the soundtrack during the game
    *
    */
    private void turnSoundOn(){
        sound.start();
        sound.loop(Clip.LOOP_CONTINUOUSLY);
        gui.updateSoundOnOffBtn("Sound Off");
    }


    /** 
    * This function turns off the soundtrack during the game
    *
    */
    private void turnSoundOff(){
        sound.stop();
        gui.updateSoundOnOffBtn("Sound On");
    }


    /** 
    * This function resets the game and the gui when the Quit Game button is pressed or when a player won the game
    *
    */
    private void quitGameReset(){
        gameMainMenu.getGame().resetGame();
        gui.resetGUI(gameMainMenu.getGame());
    }


    /** 
    * This function undos the changes a player made
    *
    */
    private void undo(){
        gameMainMenu.getGame().undo();
        gui.updateDisplay(gameMainMenu.getGame());
        gui.getClsGameView().getGameProper().getGamePieces().resetBoardPieces(gameMainMenu.getGame());
    }


    /** 
    * This function redos the changes a player made
    *
    */
    private void redo(){
        gameMainMenu.getGame().redo();
        gui.updateDisplay(gameMainMenu.getGame());
        gui.getClsGameView().getGameProper().getGamePieces().resetBoardPieces(gameMainMenu.getGame());
    }


    /** 
    * This function changes the soundtrack of the game given a File object
    *
    */
    private void changeSoundTrack(File fileToPlay){
        sound.stop();
            sound.close();
            try {
                updateAudioInputStream(fileToPlay);
            } catch (UnsupportedAudioFileException e2) {
                e2.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                try {
                    sound.open(audio);
                    sound.start();
                    sound.loop(Clip.LOOP_CONTINUOUSLY);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } catch (LineUnavailableException e1) {
                e1.printStackTrace();
            }
    }

    /** 
    * This function calculates the row pressed during a game given a MouseEvent object
    *
    */
    private int calculatePostX(MouseEvent e){
        return e.getY()/96;
    }


    /** 
    * This function calculates the column pressed during a game given a MouseEvent object
    *
    */
    private int calculatePostY(MouseEvent e){
        return e.getX()/96;
    }


    /**
    * This function assumes a cell has animal, a move is not out of bounds, a piece is own piece, and prepares a piece to be dragged
    *
    * @param nInitX     the row where an animal piece is initially located 
    * @param nInitY     the column where an animal piece is initilially located
    */
    private void preDrag(int nInitX, int nInitY)
    {
        //valid piece
        if(    (!gameMainMenu.getGame().getBoardGame().isOutOfBounds(nInitX, nInitY))
            && (gameMainMenu.getGame().getBoardGame().getBoardCell(nInitX, nInitY).getAnimal() != null))
        {
            //filename of animal picture (color)
            String strTemp = "R";
            if(Game.getPlayerTurn()) strTemp ="B";
            BufferedImage image;

            lblDragAnimal = new JLabel();
            lblDragAnimal.setLocation(nInitX, nInitY); //sets the location of the new jlabel
            lblDragAnimal.setSize(new Dimension(96, 96));
            // Duplicate to be move image to draggrable layer
            try {

                image = ImageIO.read(new File("lib/Animals/"+strTemp+ gameMainMenu.getGame().getBoardGame().getBoardCell(nInitX, nInitY).getAnimal().getClass().getName().replace("Model.", "") + ".png"));
                lblDragAnimal.setIcon(new ImageIcon(image));
            } catch (IOException e) {
                e.printStackTrace();
            }
            gui.getClsGameView().getGameProper().getGamePieces().getPiece(nInitX, nInitY).setLabelVisible(false);

            pnlDragLayer.add(lblDragAnimal, JLayeredPane.DRAG_LAYER);
            pnlDragLayer.setVisible(true);
            pnlDragLayer.setOpaque(false);
            bDragging = true;
        }
        //if invalid piece
        else
        {
            bDragging = false;
        }
    }


    /**
    * This function executes a drag 
    *
    * @param nPostY     the row where an animal piece is newly located during drag
    * @param nPostY     the column where an animal piece is newly located during drag
    */
    private void executeDrag(int nPostX, int nPostY){
        if (lblDragAnimal != null) {
            lblDragAnimal.setLocation(nPostX, nPostY);
            lblDragAnimal.setVisible(true);
        }
    }


    /**
    * This function removes the dragged piece from the drag layer after dragging
    *
    */
    private void postDrag(){
        if(lblDragAnimal != null)
        {
            pnlDragLayer.remove(lblDragAnimal);
            pnlDragLayer.repaint();
        }
    }


    /**
    * This function implements and overrides the mouseClicked(MouseEvent e)
    *
    * @param    e       the MouseEvent that is passed to the boardPieces object 
    */
    @Override
    public void mouseClicked(MouseEvent e) {
    }


    /**
    * This function implements and overrides the mousePressed(MouseEvent e) and sets the nInitX and nInitY based on 
    * the surface pressed
    *
    * @param    e       the MouseEvent that is passed to the boardPieces object 
    */
    @Override
    public void mousePressed(MouseEvent e) {
        //if valid board cell, get initial coordinates
        if(    (!gameMainMenu.getGame().getBoardGame().isOutOfBounds(calculatePostX(e), calculatePostY(e))) 
            && (gameMainMenu.getGame().getBoardGame().getBoardCell(calculatePostX(e), calculatePostY(e)).getAnimal() != null)
            && (gameMainMenu.getGame().getBoardGame().getBoardCell(calculatePostX(e), calculatePostY(e)).getAnimal().isOwnColor(Game.getPlayerTurn())))
        {   
            //validChoice of piece-->let drag
            //change getPoint or override
            nInitX = calculatePostX(e);
            nInitY = calculatePostY(e);
        }
        else
        {
            //-1 serves as invalid x and y
            nInitX = -1;
            nInitY = -1;
        }
    }


    /**
    * This function implements and overrides the mouseReleased(MouseEvent e) and sets the icons
    * of the Pieces object in the BoardPieces object based on the move that a player wants to make
    *
    * @param    e       the MouseEvent that is passed to the boardPieces object 
    */
    @Override
    public void mouseReleased(MouseEvent e) {
        String strTemp = "R";
        if(Game.getPlayerTurn()) strTemp ="B";
        BufferedImage image;
        postDrag();

        if(bDragging){
            if(gameMainMenu.getGame().isNoMove(nInitX, nInitY, calculatePostX(e), calculatePostY(e)))
            {
                gui.getClsGameView().getGameProper().getGamePieces().getPiece(nInitX, nInitY).getLblAnimal().setVisible(true);
            }
            //if valid move
            else if(   (gameMainMenu.getGame().getBoardGame().isPossibleMove(nInitX, nInitY, calculatePostX(e), calculatePostY(e), Game.getPlayerTurn())) 
                    && (!gameMainMenu.getGame().getBoardGame().isOutOfBounds(nInitX, nInitY)))
            {
                try {
                    image = ImageIO.read(new File("lib/Animals/"+strTemp+ gameMainMenu.getGame().getBoardGame().getBoardCell(nInitX, nInitY).getAnimal().getClass().getName().replace("Model.", "") + ".png"));
                    gameMainMenu.getGame().moveAnimal(nInitX, nInitY, calculatePostX(e), calculatePostY(e)); //moves animal
                    gui.getClsGameView().getGameProper().getGamePieces().getPiece(calculatePostX(e), calculatePostY(e)).getLblAnimal().setIcon(new ImageIcon(image)); //set icon of landing tile
                    gui.getClsGameView().getGameProper().getGamePieces().getPiece(calculatePostX(e), calculatePostY(e)).getLblAnimal().setVisible(true);//set landing tile to visible
                    gui.getClsGameView().getGameProper().getGamePieces().getPiece(nInitX, nInitY).getLblAnimal().setIcon(null);
                    
                    gameMainMenu.getGame().changePlayerInTurn(); //change player in turn
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            //invalid move
            else
            {
                //make the source tile visible again
                gui.showInvalidMoveError();
                gui.getClsGameView().getGameProper().getGamePieces().getPiece(nInitX, nInitY).getLblAnimal().setVisible(true);
            }
        }
        bDragging = false;
        gui.updateDisplay(gameMainMenu.getGame());
        if(!gameMainMenu.getGame().isNoWinner()){
            String strTempWinnerName = Game.getPlayer(0).getName();
            if(Game.getPlayer(1).isWinner())
            {
                strTempWinnerName = Game.getPlayer(1).getName();
            }

            gui.showWinner(strTempWinnerName);

            //reset gui and model
            gameMainMenu.getGame().resetGame();
            gui.resetGUI(gameMainMenu.getGame());
        }
        else if(gameMainMenu.getGame().getBoardGame().isCheckMate(Game.getPlayerTurn()))
        {
            Game.getPlayer(!Game.getPlayerTurn()).setWinner();
            gui.showWinner(Game.getPlayer(!Game.getPlayerTurn()).getName());

            //reset gui and model
            quitGameReset();
        }
    }


    /**
    * This function implements and overrides the mouseEntered(MouseEvent e)
    *
    * @param    e       the MouseEvent that is passed to the boardPieces object 
    */
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }


    /**
    * This function implements and overrides the mouseExited(MouseEvent e)
    *
    * @param    e       the MouseEvent that is passed to the boardPieces object 
    */
    @Override
    public void mouseExited(MouseEvent e) {
        
    }


    /**
    * This function implements and overrides the mouseDragged(MouseEvent e)
    *
    * @param    e       the MouseEvent that is passed to the boardPieces object 
    */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (bDragging) 
        {
            executeDrag((int)e.getX(), (int)e.getY());
        } 
        else 
        {
            preDrag(nInitX, nInitY);
        }
        //System.out.println("mouse dragged: "+e.getPoint());
    }


    /**
    * This function implements and overrides the mouseMoved(MouseEvent e)
    *
    * @param    e       the MouseEvent that is passed to the boardPieces object 
    */
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}
