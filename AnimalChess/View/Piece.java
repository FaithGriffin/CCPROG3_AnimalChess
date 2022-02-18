package View;

import javax.swing.*;
import java.awt.*;


/** 
* Represents a Piece
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class Piece extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblAnimal;


    /** 
    * Constructs a new Piece object
    *
    * 
    */
    public Piece(){
        lblAnimal = new JLabel();
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(96,96));
        this.setOpaque(false);
        this.setVisible(true);
    }


    /** 
    * This function returns the instance of a Piece class
    *
    * @return JPanel  the instance of a Piece class
    */
    public JPanel getPnlPiece(){
        return this;
    }


    /** 
    * This function returns lblAnimal
    *
    * @return JLabel  the lblAnimal of a Piece object
    */
    public JLabel getLblAnimal(){
        return lblAnimal;
    }


    /** 
    * This function sets the icon of lblAnimal
    *
    * @param newImage  the ImageIcon to be set as the new icon of the lblAnimal of a Piece object
    */
    public void setLblAnimal(ImageIcon newImage){
        this.lblAnimal.setIcon(newImage);
    }


    /** 
    * This function changes the visibility of lblAnimal
    *
    * @param bVisible  the boolean value that will determine if the lblAnimal of a Piece object will be visible   
    */
    public void setLabelVisible(boolean bVisible){
        this.lblAnimal.setVisible(bVisible);
    } 


    /** 
    * This function assigns the animal picture to be set as the new ico of the lblAnimal of a Piece object
    *
    * @param strAnimalNameAndColor  the name of an animal in a tile   
    */
    public void assignAnimalPiece(String strAnimalNameAndColor){
        if(strAnimalNameAndColor != null){
            lblAnimal.setIcon(new ImageIcon("lib/Animals/"+ strAnimalNameAndColor + ".png"));
            lblAnimal.setSize(new Dimension(96,96));
            lblAnimal.setVisible(true);
            this.add(lblAnimal);
        }  
        else{
            lblAnimal.setIcon(null);
            lblAnimal.setSize(new Dimension(96,96));
            this.add(lblAnimal);
        }
    }
}