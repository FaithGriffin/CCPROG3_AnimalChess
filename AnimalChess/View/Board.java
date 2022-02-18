package View;

import javax.swing.*;
import java.awt.*;
import Model.BoardGame;

/** 
* Represents a Board
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0 
*/
public class Board{ 
    private JPanel pnlBoard;
    private Point locTempLocation;


    /** 
    * Constructs a new Board object
    *
    * 
    */
    public Board(){
        pnlBoard = new JPanel();
        pnlBoard.setLayout(new GridLayout(7,9,4,4));
        pnlBoard.setPreferredSize(new Dimension(864, 672));
        pnlBoard.setBackground(GUI.LIGHT_BROWN);
        pnlBoard.setVisible(true);
        locTempLocation = new Point();

        for(int i = 0; i < BoardGame.getMAX_ROW(); i++){
            for(int j = 0; j < BoardGame.getMAX_COL(); j++){
                locTempLocation.setLocation(i, j);
                Tile tempTile = new Tile(locTempLocation);
                pnlBoard.add(tempTile.getPnlTile());
            }
        }
    }


    /** 
    * This function returns the pnlBoard
    *
    * @return JPanel  the pnlBoard of a Board object
    */
    public JPanel getPnlBoard(){
        return pnlBoard;
    }
}