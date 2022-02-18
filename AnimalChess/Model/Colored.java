package Model;

/** 
* Represents Colored
*
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public interface Colored
{
    /**
     * Checks if the color of the class is Blue
     * @return true if the color of the class is Blue, otherwise false
     */
    public boolean isBlue();

    /**
     * Set the bBlue. If called will set the bBLue to true
     * 
     * @param bBlue true if the color of the class is Blue, otherwise false
     */
    public void setColor (boolean bBlue);

    /**
     * Checks if the color of the class is the same with bBlue
     * @param bBlue true if the color of the class is Blue, otherwise false
     * @return  true if the color of the class is the same with bBlue, otherwise false
     */
    public boolean isOwnColor(boolean bBlue);

    /**
     * Checks if the color of the class is the different with bBlue
     * @param bBlue true if the color of the class is Blue, otherwise false
     * @return  true if the color of the class is the different with bBlue, otherwise false
     */
    public boolean isEnemyColor(boolean bBlue);

}