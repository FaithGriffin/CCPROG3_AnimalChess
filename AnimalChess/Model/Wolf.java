package Model;
/** 
* Represents a Wolf
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class Wolf extends Animal{
    /** 
    * Constructs a new Wolf object
    *
    * 
    */
    public Wolf(){
        super();
        setRank(3);
        setCanJump(false);
        setCanWater(false);
    }
}