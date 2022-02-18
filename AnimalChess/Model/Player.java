package Model;
/** 
* Represents a Player of the Game
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class Player implements Colored{
    private String strName;
    private boolean bBlue;
    private boolean bWinner;
    private int nKilledEnemyAnimalCtr;


    /**
     * Construct the Player without name
     *
     */
    public Player ()
    {
        this.strName = new String();
        this.bBlue = false;
        this.bWinner = false;
        this.nKilledEnemyAnimalCtr = 0;
    }

    /**
     * Construct the Player
     * @param strName String player's name
     */
    public Player (String strName)
    {
        this.strName = strName;
        this.bBlue = false;
        this.bWinner = false;
        this.nKilledEnemyAnimalCtr = 0;
    }

    /**
     * Set the name of the Player
     * @param strName the String to be set as the name of a player
     */
    public void setName(String strName){
        this.strName = strName;
    }

    /**
    * Set the player's bWinner to true
    */
    public void setWinner()
    {
        this.bWinner = true;
    }

    /**
     * Sets the Killed Enemy Animal count of the Player
     * @param nKilledEnemyAnimalCtr new count of  the Killed Enemy Animal count of the Player
     */
    public void setKilledAnimalCounter(int nKilledEnemyAnimalCtr)
    {
        this.nKilledEnemyAnimalCtr = nKilledEnemyAnimalCtr;
    }

    /**
     * Gets the name of the player
     * @return String strName = name of the player
     */
    public String getName()
    {
        return this.strName;
    }

    /**
     * Gets bWInner state of the player
     * @return true if the player is already a winner, otherwise false
     */
    public boolean isWinner ()
    {
        return this.bWinner;
    }

    /**
     *  Gets the Killed Enemy Animal count of the Player
     * @return the Killed Enemy Animal count of the Player
     */
    public int getKilledEnemyAnimalCounter ()
    {
        return this.nKilledEnemyAnimalCtr;
    }

    

    /**
     * Add 1 to the Killed Enemy Animal count of the Player 
     */
    public void incrementKilledEnemyAnimalCounter ()
    {
        this.nKilledEnemyAnimalCtr++;
    }

    /**
     * Delete all the information about the player
     */
    public void resetPlayer()
    {
        this.strName = null;
        this.bBlue = false;
        this.bWinner = false;
        this.nKilledEnemyAnimalCtr = 0;
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