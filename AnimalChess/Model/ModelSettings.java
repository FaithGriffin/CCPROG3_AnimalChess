package Model;
import java.io.*;

/** 
* Represents a ModelSettings 
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class ModelSettings {
    private File[] arrTracks;


    /** 
    * Constructs a new ModelMainMenu object
    *
    * @apiNote 	   Lewis G. (2016, February 26). Stardew Valley OST - Stardew Valley Overture. 
    *              [Video]. YouTube. Retrieved August 29, 2021 from https://www.youtube.com/watch?v=FQSHcl6TJb4
    * @apiNote 	   Samuel Kim Music. (2020, June 14). He's a Pirate (Pirates of The Caribbean) - Medieval Style.
    *              [Video]. YouTube. Retrieved August 29, 2021 from https://www.youtube.com/watch?v=95M9UsQS2HI
    * @apiNote 		   Txrtaa. (2020, October 11). Zen Zen Zense (Lo-Fi Remix). 
    *              [Video]. YouTube. Retrieved August 29, 2021 from https://www.youtube.com/watch?v=2AszoWSNKjU
    * @apiNote 		   Lewis G. (2016, February 26). Stardew Valley OST - Grandpa's Theme. 
    *              [Video]. YouTube. Retrieved August 29, 2021 from https://www.youtube.com/watch?v=Zndgoac6R3o
    */
    public ModelSettings(){
        arrTracks = new File[4];
        arrTracks[0] = new File("lib/utilities/track default.wav");
        arrTracks[1] = new File("lib/utilities/track 1.wav");
        arrTracks[2] = new File("lib/utilities/track 2.wav");
        arrTracks[3] = new File("lib/utilities/track 3.wav");
    }


    /** 
    * This function returns a File inside arrTracks of a ModelSettings object
    *
    * @param   nIndex   the index corresponding to the location of a File object inside arrTracks
    * @return  File     the File object inside arrTracks
    */
    public File getFile(int nIndex){
        return arrTracks[nIndex];
    }
}
