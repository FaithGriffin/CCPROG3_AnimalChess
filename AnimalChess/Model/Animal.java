package Model;

/** 
* Represents an Animal
*
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public abstract class Animal implements Colored{
    private int nRank;
    private boolean bBlue;
    private boolean bAlive;
    private boolean bCaptured;
    private boolean bCanJump;
    private boolean bCanWater;


    /** 
    * Constructs a new Animal object
    *
    */ 
    public Animal(){
      this.bAlive = true;
      this.bCaptured = false;
    }

    /** 
    * This function sets the rank of an Animal object
    *
    * @param nRank     the int value to be set as the rank of an Animal object
    */
    public void setRank(int nRank){
      this.nRank = nRank;
    }


    /** 
    * This function sets whether an Animal object can jump
    *
    * @param bCanJump     the boolean value to be set as the value bCanJump of an Animal object
    */
    public void setCanJump(boolean bCanJump){
      this.bCanJump = bCanJump;
    }


    /** 
    * This function sets whether an Animal object can walk in the river
    *
    * @param bCanWater     the boolean value to be set as the value bCanWater of an Animal object
    */
    public void setCanWater(boolean bCanWater){
      this.bCanWater = bCanWater;
    }



    /** 
    * This function sets the bCaptured attribute of an Animal object
    *
    * @param bCaptured    The new boolean value that will be stored in this.bCaptured variable. 
    *                     True if captured because of a trap, otherwise false
    */
    public void setIsCaptured(boolean bCaptured){
      this.bCaptured = bCaptured;
    }


    /** 
    * This function sets the bAlive attribute of an Animal object
    *
    * @param bAlive       The new boolean value to be assigned as the value of the 
    *                     bAlive attribute of an Animal object. True if alive, otherwise false
    */
    public void setIsAlive(boolean bAlive){
      this.bAlive = bAlive;
    }

    /** 
    * This function returns the rank of an Animal object
    *
    * @return int     the rank of an Animal object
    */
    public int getRank(){
      return this.nRank;
    }


    /** 
    * This function returns the bCanJump attribute of an Animal object
    *
    * @return boolean     true if an Animal object can jump, otherwise false
    */
    public boolean getCanJump(){
      return this.bCanJump;
    }


    /** 
    * This function returns the bCanWater attribute of an Animal object
    *
    * @return boolean     true if an Animal object can walk in the river, otherwise false
    */
    public boolean getCanWater(){
      return this.bCanWater;
    }
    /** 
    * This function checks if an animal is still alive.
    *
    * @return boolean    the value of the bAlive attribute of an Animal object
    */
    public boolean isAlive(){
      return this.bAlive;
    }


    /** 
    * This function checks if an Animal object is captured
    *
    * @return boolean    the value of the bCaptured attribute of an Animal object
    */
    public boolean isCaptured(){
      return this.bCaptured;
    }


    /** 
    * This function checks if the rank of an Animal object is lower or equal to another Animal object
    *
    * @param  nRank      the int value to be compared with tha nRank of an Animal object
    * @return boolean    true if an Animal object has a lower or equal rank, false otherwise
    */
    public boolean isLowerOrEqualRank(int nRank){
      return this.nRank >= nRank;
    }


    /**
    * Set the bBlue. If called will set the bBLue to true
    *
    * @param bBlue true if the color of the class is Blue, otherwise false
    */
    @Override
    public void setColor (boolean bBlue){
      this.bBlue = bBlue;
    }
    
    /**
    * Checks if the color of the class is Blue
    * @return true if the color of the class is Blue, otherwise false
    */
    @Override
    public boolean isBlue(){
      return this.bBlue;
    }


    /**
    * Checks if the color of the class is the same with bBlue
    * @param bBlue true if the color of the class is Blue, otherwise false
    * @return  true if the color of the class is the same with bBlue, otherwise false
    */
    @Override
    public boolean isOwnColor(boolean bBlue){
      return Boolean.compare(this.bBlue, bBlue) == 0;
    }


    /**
     * Checks if the color of the class is the different with bBlue
     * @param bBlue true if the color of the class is Blue, otherwise false
     * @return  true if the color of the class is the different with bBlue, otherwise false
     */
    public boolean isEnemyColor(boolean bBlue){
      return Boolean.compare(this.bBlue, bBlue) != 0;
    }


    
}