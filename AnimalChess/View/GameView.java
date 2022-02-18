package View;

import javax.swing.*;
import Model.Game;
import java.awt.*;

/** 
* Represents a GameView
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class GameView{ 
    private JPanel pnlGameView;
    private GameProper gameProper;
    private GameProperAddOns gameNorthDisplay;


    /** 
    * Constructs a new GameView object
    *
    * @param game the current instance of Game
    */
    public GameView(Game game){
        pnlGameView = new JPanel();
        pnlGameView.setSize(new Dimension(960,768));
        pnlGameView.setLayout(new BorderLayout());
        pnlGameView.setBackground(GUI.SOMEWHAT_YELLOW);
        pnlGameView.setOpaque(false);
        pnlGameView.setVisible(true);
        gameProper = new GameProper(game);
        gameNorthDisplay = new GameProperAddOns();
        pnlGameView.add(gameProper.getPnlGameProper(), BorderLayout.CENTER);
        pnlGameView.add(gameNorthDisplay.getPnlNorthDisplay(), BorderLayout.NORTH);
    }


    /** 
    * This function returns the pnlGameView
    *
    * @return JPanel  the pnlGameView of a GameView object
    */
    public JPanel getPnlGameView(){
        return pnlGameView;
    }


    /** 
    * This function returns the gameNorthDisplay
    *
    * @return GameProperAddOns  the gameNorthDisplay of a GameView object
    */
    public GameProperAddOns getGameNorthDisplay(){
        return gameNorthDisplay;
    }


    /** 
    * This function returns the gameProper
    *
    * @return GameProper  the gameNorthDisplay of a GameProper object
    */
    public GameProper getGameProper(){
        return gameProper;
    }


    /** 
    * This function updates the gameNorthDisplay, specifically the lblRScore, lblBScore, and the lblTeamTurn
    *
    * @param game      the current instance of the model.Game class
    */
    public void updateGameView(Game game){
        String strTemp = "RED";
        if(Game.getPlayerTurn()) strTemp = "BLUE";
        //System.out.println("RED KILLS" + Game.getPlayer(false).getKilledEnemyAnimalCounter());
        //System.out.println("BLUE KILLS" + Game.getPlayer(true).getKilledEnemyAnimalCounter());
        gameNorthDisplay.updateNorthDisplay(strTemp, Game.getPlayer(false).getKilledEnemyAnimalCounter(), Game.getPlayer(true).getKilledEnemyAnimalCounter());
    }
}