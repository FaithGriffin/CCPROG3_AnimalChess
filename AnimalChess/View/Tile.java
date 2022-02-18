package View;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import Model.BoardGame;

/** 
* Represents a Tile
*  
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class Tile{
    private JPanel pnlTile;
    private BoardGame ruleTemp; 

    /** 
    * Constructs a new Tile object
    *
    * @param temp the Point pertaining to the location of a Tile object in a Board object 
    */
    public Tile(Point temp){
        pnlTile = new JPanel();
        pnlTile.setLayout(new GridBagLayout());
        pnlTile.setPreferredSize(new Dimension(96,96));
        pnlTile.setBackground(GUI.GOLD);
        ruleTemp = new BoardGame();
        assignTerrain(temp);
        pnlTile.setVisible(true);
    }


    /** 
    * This function returns the pnlTile
    *
    * @return JPanel  the pnlTile of a Tile object
    */
    public JPanel getPnlTile(){
        return pnlTile;
    }


    /** 
    * This function assigns a terrain image to a Tile object
    *
    * @param temp  the Point in a Board instance where a Tile object is located
    */
    private void assignTerrain(Point temp){
        String strTemp = "land.png";
        if(ruleTemp.getBoardCell((int)temp.getX(), (int)temp.getY()).isRiver()){
            strTemp = "river.png"; 
        }
        else if(ruleTemp.getBoardCell((int)temp.getX(), (int)temp.getY()).isDen()){
            strTemp = "den.png";
        }
        else if(ruleTemp.getBoardCell((int)temp.getX(), (int)temp.getY()).isTrap()){
            strTemp = "trap.png";
        }
        try{
            BufferedImage image = ImageIO.read(getClass().getResource(("/lib/Terrains/"+strTemp)));
            JLabel lblTemp = new JLabel(new ImageIcon(image));
            lblTemp.setSize(new Dimension(96,96));
            pnlTile.add(lblTemp);
            pnlTile.setVisible(true);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}