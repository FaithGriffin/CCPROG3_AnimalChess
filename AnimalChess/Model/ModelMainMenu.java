package Model;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

/** 
* Represents a ModelMainMenu
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/ 
public class ModelMainMenu{
    private Game game;
    private String strInstructions;
    private ModelSettings settings;


    /** 
    * Constructs a new ModelMainMenu object
    *
    */
    public ModelMainMenu(){
        try {
            strInstructions = new String(Files.readAllBytes(Paths.get("lib/utilities/instructions.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        game = new Game();
        settings = new ModelSettings();
    }


    /** 
    * This function returns the game attribute
    *
    * @return  Game     the game of a ModelMainMenu object
    */
    public Game getGame(){
        return game;
    }


    /** 
    * This function returns the strInstructions of a ModelMainMenu object
    *
    * @return  String     the strInstructions of a ModelMainMenu object
    */
    public String getStrInstructions(){
        return strInstructions;
    }


    /** 
    * This function returns the ModelSettings of a ModelMainMenu object
    *
    * @return  ModelSettings     the settings of a ModelMainMenu object
    */
    public ModelSettings getSettings(){
        return settings;
    }

}
