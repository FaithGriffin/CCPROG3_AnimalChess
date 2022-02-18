package View;

import javax.swing.*;
import Model.Game;
import java.awt.*; 

/** 
* Represents a GameProper
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class GameProper{
    private Board gameBoard;
    private BoardPieces gamePieces;
    private JLayeredPane pnlGameProper;


    /** 
    * Constructs a new GameProper object
    *
    * @param game	the current instance of Game
    */
    public GameProper(Game game){
        pnlGameProper = new JLayeredPane();
        pnlGameProper.setLayout(null);
        pnlGameProper.setSize(new Dimension(864, 672));
        pnlGameProper.setBounds(0,0,864,672);
        pnlGameProper.setBackground(GUI.SOMEWHAT_YELLOW);
        pnlGameProper.setOpaque(false);
        pnlGameProper.setVisible(true); 
        gameBoard = new Board();
        gamePieces = new BoardPieces(game);

        gameBoard.getPnlBoard().setBounds(40,15,864,672);
        pnlGameProper.add(gameBoard.getPnlBoard(), Integer.valueOf(0), 0);

        gamePieces.getPnlBoardPieces().setBounds(40,15,864,672);
        pnlGameProper.add(gamePieces.getPnlBoardPieces(), Integer.valueOf(1), 0);
    }


    /** 
    * This function returns the gameBoard attribute
    *
    * @return Board     the gameBoard of a GameProper object
    */
    public Board getGameBoard(){
        return gameBoard;
    }


    /** 
    * This function returns the gamePieces attribute
    *
    * @return BoardPieces     the gamePieces of a GameProper object
    */
    public BoardPieces getGamePieces(){
        return gamePieces;
    }


    /** 
    * This function returns the pnlGameProper attribute
    *
    * @return JLayeredPane     the pnlGameProper of a GameProper object
    */
    public JLayeredPane getPnlGameProper(){
        return pnlGameProper;
    }
}
