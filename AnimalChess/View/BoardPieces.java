package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import Model.Game; 

/** 
* Represents a BoardPieces
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class BoardPieces extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Piece[][] pieces;


    /** 
    * Constructs a new BoardPieces object
    *
    * @param game	the current instance of Game
    */
    public BoardPieces(Game game){ 
        this.setLayout(new GridLayout(7,9,4,4));
        this.setPreferredSize(new Dimension(864, 672));
        this.setOpaque(false);
        this.setVisible(true);
        pieces = new Piece[7][9];

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 9; j++){
                String strTempAnimalNameAndColor = new String();
                if(game.getBoardGame().getBoardCell(i, j).getAnimal() != null)
                {
                    strTempAnimalNameAndColor = game.getBoardGame().getBoardCell(i, j).getAnimal().getClass().getName().toLowerCase().replace("model.","");

                    if(game.getBoardGame().getBoardCell(i, j).getAnimal().isBlue())
                    {
                        strTempAnimalNameAndColor = "B" + strTempAnimalNameAndColor;
                    }
                    else
                    {
                        strTempAnimalNameAndColor = "R" + strTempAnimalNameAndColor;
                    }
                }
                else
                {
                    strTempAnimalNameAndColor = null;
                }
                pieces[i][j] = new Piece();
                pieces[i][j].assignAnimalPiece(strTempAnimalNameAndColor); //assigns the animal piece to tile
                this.add(pieces[i][j]);
            }
        }
    }


    /** 
    * This function returns an instance of BoardPieces
    *
    * @return JPanel  the instance of a BoardPieces class
    */
    public JPanel getPnlBoardPieces(){
        return this;
    }


    /** 
    * This function returns a Piece instance stored in pieces[][]
    *
    * @param  i      the int value of the row a Piece instance is located 
    * @param  j      the int value of the column a Piece instance is located
    * @return Piece  the instance of a Piece inside pieces[][]
    */
    public Piece getPiece(int i, int j){
        return pieces[i][j];
    }


    /** 
    * This function resets the animal pictures in the pieces attribute of a BoardPieces object
    *
    * @param  game   the current instance of the model.Game class
    */
    public void resetBoardPieces(Game game){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 9; j++){
                String strTempAnimalNameAndColor = new String();
                if(game.getBoardGame().getBoardCell(i, j).getAnimal() != null)
                {
                    strTempAnimalNameAndColor = game.getBoardGame().getBoardCell(i, j).getAnimal().getClass().getName().toLowerCase().replace("model.","");
                    if(game.getBoardGame().getBoardCell(i, j).getAnimal().isBlue())
                    {
                        strTempAnimalNameAndColor = "B" + strTempAnimalNameAndColor;
                    }
                    else
                    {
                        strTempAnimalNameAndColor = "R" + strTempAnimalNameAndColor;
                    }
                }
                else
                {
                    strTempAnimalNameAndColor = null;
                }
                pieces[i][j].assignAnimalPiece(strTempAnimalNameAndColor); //assigns the animal piece to tile
            }
        }
    }
}
