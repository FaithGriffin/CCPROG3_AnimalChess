package Model;

/** 
* Represents a BoardCell of the  Board
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class BoardCell implements Colored{
    private Animal aAnimal;
    private boolean bRiver;
    private boolean bTrap;
    private boolean bDen;
    private boolean bBlue;

    /**
     * Construct the BoardCell and initialize bRiver, bDen, and bTrap values to false
     */
    public BoardCell ()
    {
        this.bRiver = false;
        this.bDen = false;
        this.bTrap = false;
    }

    /** Set the aAnimal as the new animal located to this BoardCell
     * 
     * @param aAnimal Animal class to be placed in this cell
     */
    public void setAnimal (Animal aAnimal)
    {
        this.aAnimal = aAnimal;
    }

    /**
     * Set the River. If called will set the bRiver to true
     */
    public void setRiver ()
    {
        this.bRiver = true;
    }

    /**
     * Set the Den. If called will set the bDen to true
     */
    public void setDen ()
    {
        this.bDen = true;
    }

    /**
     * Set the Trap. If called will set the bTrap to true
     */
    public void setTrap ()
    {
        this.bTrap = true;
    }

    /**
     * Get aAnimal
     * @return the Animal in BoardCell
     */
    public Animal getAnimal()
    {
        return this.aAnimal;
    }

    /**
     * Check if the BoardCell is a River
     * @return true if BoardCell is a River otherwise false
     */
    public boolean isRiver ()
    {
        return this.bRiver;
    }
    

    /**
     * Check if the BoardCell is a Trap
     * @return true if BoardCell is a Trap otherwise false
     */
    public boolean isTrap ()
    {
        return this.bTrap;
    }

    /**
     * Check if the BoardCell is a Den
     * @return true if BoardCell is a Den otherwise false
     */
    public boolean isDen ()
    {
        return this.bDen;
    }

    /**
     * Set the Animal in the BoardCell as null
     */
    public void removeAnimal () 
    {
        this.aAnimal = null;
    }

    /**
     * Set the team color of the player
     * @param bBlue true if Blue otherwise false
     */
    @Override
    public void setColor (boolean bBlue)
    {
        this.bBlue = bBlue;
    }

    /**
     * Checks if the color of the class is Blue
     * @return true if the color of the class is Blue, otherwise false
     */
    @Override
    public boolean isBlue() {
        return this.bBlue;
    }

    /**
     * Checks if the color of the class is the same with bBlue
     * @param bBlue true if the color of the class is Blue, otherwise false
     * @return  true if the color of the class is the same with bBlue, otherwise false
     */
    @Override
    public boolean isOwnColor(boolean bBlue) {
        return Boolean.compare(this.bBlue, bBlue)==0;
    }

    /**
     * Checks if the color of the class is the different with bBlue
     * @param bBlue true if the color of the class is Blue, otherwise false
     * @return  true if the color of the class is the different with bBlue, otherwise false
     */
    @Override
    public boolean isEnemyColor(boolean bBlue) {
        return Boolean.compare(this.bBlue, bBlue)!=0;
    }
}