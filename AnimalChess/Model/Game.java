package Model;
import java.util.ArrayList;
import java.util.Random;

/** 
* Represents a Game in the MainMenu
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class Game {
    private BoardGame bBoardGame;
    private static boolean bPlayerInTurn;
    private static ArrayList<Player> arrPlayers;
    
    /**
     * Constructs the Game
     */
    public Game()
    {
        bBoardGame = new BoardGame();
        arrPlayers = new ArrayList<Player>();
         
        ///undoStackHistory = new Stack<BoardCell[][]>();
    }

    /**
     * Set a Player and add is into the arrPlayers
     * @param strName String strName = Name of the player
     */
    public static void setPlayer ( String strName ) 
    {
        // Prevent more than two Players
        if(arrPlayers.size() >= getMAX_PLAYERS())
        {
            // DO not add a new player
        }
        else
        {
            arrPlayers.add(new Player(strName));
        }
    }

    /**
     * Returns a randomized number from 0-7
     * @return the randomized number from 0-7
     */
    public int draw ()
    {
        Random rand = new Random(); //instance of random class
        int upperbound = 7;
    
        //generate random values from 0-7
        return rand.nextInt(upperbound); 

    }

    /**
     * Set the first player to attack to choosen team color he/she wanted
     * @param bPlayerInTurn team color of the first player to attack
     * @param bBlue team color first player to attack  wanted
     */
    public void pickColor (boolean bPlayerInTurn, boolean bBlue)
    {
        getPlayer(bPlayerInTurn).setColor(bBlue); // Set the first person to attack color
        getPlayer(!bPlayerInTurn).setColor(!bBlue); // Set first person to attack oppenent color
    }


    /**
     * Set the current player in turn
     * @param bBlue true to make player in turn to BLUE otherwise false
     */
    public void setPlayerInTurn (boolean bBlue)
    {
        bPlayerInTurn = bBlue;
    }

    /**
     * Get count of Players
     * @return int count of Players
     */
    public static int getMAX_PLAYERS()
    {
        return BoardGame.getMAX_PLAYERS();
    }

    /**
     * Get the count of ALL animals both blue and not
     * @return count of ALL animals both blue and not
     */
    public static int getMAX_ANIMALS()
    {
        return BoardGame.getMAX_ANIMALS();
    }

    /**
     * Get the current color of the Player In Turn
     * @return true if Blue otherwise false
     */
    public static boolean getPlayerTurn ()
    {
        return bPlayerInTurn;
    }

    /**
     *  Get the whole BoardGame
     * @return BoardGame bBoardGame = board of the game
     */
    public BoardGame getBoardGame()
    { 
        return this.bBoardGame;
    }

    /**
     * Get the player based on their name
     * @param strName name of the player you want to get
     * @return the player with name of strName
     */
    public static Player getPlayer (String strName)
    {
        if(arrPlayers.get(0).getName().equals(strName))
        {
            return arrPlayers.get(0);
        }
        else if(arrPlayers.get(1).getName().equals(strName))
        {
            return arrPlayers.get(1);
        }
        return null;
    }

    /**
     * Get the Player based on their team
     * @param bBlue true if blue otherwise false
     * @return the player with the team of bBLue param
     */
    public static Player getPlayer (boolean bBlue)
    {
        if (Boolean.compare(arrPlayers.get(0).isBlue(),bBlue) == 0)
        {
            return arrPlayers.get(0);
        }
        else
        {
            return arrPlayers.get(1);
        }
    }

    /**
     * Get the player based on the players index on the arraylist
     * @param nIndex index of the player you want to get
     * @return the player in the index of nIndex of arrPlayers
     */
    public static Player getPlayer (int nIndex)
    {
        if(nIndex >= BoardGame.getMAX_PLAYERS())
        {
            return null;
        }
        else
        {
            return arrPlayers.get(nIndex);
        }
        
    }

    /**
     * check if all player is still not a winner
     * @return true if all player is still not a winner, otherwise false
     */
    public boolean isNoWinner ()
    {
        if (arrPlayers.get(0).isWinner() 
            || arrPlayers.get(1).isWinner())
        {
            return false;
        }

        return true;
    }

    /**
     * Display the name of the winning player
     * @return String  = the name of the winning player
     */
    public String displayWinner ()
    {
        if (arrPlayers.get(0).isWinner())
        {
            return arrPlayers.get(0).getName();
        }
        else
        {
            return arrPlayers.get(1).getName();
        }
    }

    /**
     * Move the animal in the INITIAL ROW and COL to POST ROW and COL
     * 
     * @param nInitX ROW   of INITIAL BoardCell to be accessed
     * @param nInitY COLUMN   of INITIAL BoardCell to be accessed
     * @param nPostX ROW   of POST BoardCell to be accessed
     * @param nPostY COLUMN   of POST BoardCell to be accessed
     * @return true if possible move, otherwise return false
     */
    public boolean moveAnimal (int nInitX, int nInitY, int nPostX, int nPostY)
    {
        boolean bReturn = bBoardGame.moveAnimal(nInitX, nInitY, nPostX, nPostY, bPlayerInTurn);
        
        // If the current player in turn already won
        if  (bReturn 
                &&  (updateStatus(nPostX, nPostY) // If the post boardcell is a den
                    || isAllEnemyKilled() // If all enemy animals are killed
                    )
            )
        {
            if(Boolean.compare(arrPlayers.get(0).isBlue(),bPlayerInTurn) == 0)
            {
                arrPlayers.get(0).setWinner();
            }
            else
            {
                arrPlayers.get(1).setWinner();
            }
  
        }
        return bReturn;
    }

    /**
     * Update the status of the move Animals if captured or not
     * and Checks if the current player in turn already won
     * @param nPostX ROW   of POST BoardCell to be accessed
     * @param nPostY COLUMN   of POST BoardCell to be accessed
     * @return true if the current player in turn already won, otherwise false
     */
    private boolean updateStatus (int nPostX, int nPostY)
    {
        return bBoardGame.updateStatus(nPostX, nPostY, bPlayerInTurn);
    }

    /**
     * Check if all enemy of the current player in turn is already killed
     * @return true if all enemy of the current player in turn is already killed, otherwise false
     */
    private boolean isAllEnemyKilled ()
    {
        if(Boolean.compare(arrPlayers.get(0).isBlue(),bPlayerInTurn) == 0)
        {
            return arrPlayers.get(0).getKilledEnemyAnimalCounter() == getMAX_ANIMALS()/2;
        }
        else
        {
            return arrPlayers.get(1).getKilledEnemyAnimalCounter() == getMAX_ANIMALS()/2;
        }
    }
     
    /**
     * Changes the Player In Turn
     */
    public void changePlayerInTurn ()
    {
        if(bPlayerInTurn)
        {
            bPlayerInTurn = false;
        }
        else 
        {
            bPlayerInTurn = true;
        }
    }

    
    
    /**
     * Save the current state of the arrCells in the bBoardGame for the undo History
     */
    public void pushArrCells()
    {
        this.bBoardGame.pushArrCellsForUndo();
    }

    /**
     * Checks if there is no previous state stored to be undone
     * @return true if the undoStackHistory is empty, otherwise false
     */
    public boolean isEmptyHistory()
    {
        return bBoardGame.isUndoStackHistoryEmpty();
    }

    /**
     * Check if the move is placed to same row and column
     * @param nInitX ROW   of INITIAL BoardCell to be accessed
     * @param nInitY COLUMN   of INITIAL BoardCell to be accessed
     * @param nPostX ROW   of POST BoardCell to be accessed
     * @param nPostY COLUMN   of POST BoardCell to be accessed
     * @return true if the move is placed to same row and column, otherwise return false
     */
    public boolean isNoMove(int nInitX, int nInitY, int nPostX, int nPostY)
    {
      if(nInitX == nPostX
        && nInitY == nPostY)
      {
        return true;
      }
      else
      {
        return false;
      }
    }

    /**
     * Revert back to the previous state arrCells (especially the animals)
     */
    public void undo ()
    {
        int[] tempOwnAnimalsCounter = new int[2];
        tempOwnAnimalsCounter[0] = 0;
        tempOwnAnimalsCounter[1] = 0;
        
        // If undo is executed (not the last state History of arrCells to be undone)
        if (bBoardGame.undo()) 
        {
            changePlayerInTurn();
        }

        // RESET the count of killed animals of both players
        for (int i = 0; i < BoardGame.getMAX_ROW(); i++)
        {
            for (int j = 0; j < BoardGame.getMAX_COL(); j++)
            {
                if(this.bBoardGame.getBoardCell(i, j).getAnimal() != null)
                {
                    if(this.bBoardGame.getBoardCell(i, j).getAnimal().isOwnColor(true))
                    {
                        tempOwnAnimalsCounter[0]++;
                    }
                    else
                    {
                        tempOwnAnimalsCounter[1]++;
                    }
                }
            }
        }
        getPlayer(true).setKilledAnimalCounter(BoardGame.getMAX_ANIMALS()/2 - tempOwnAnimalsCounter[1]);
        getPlayer(false).setKilledAnimalCounter(BoardGame.getMAX_ANIMALS()/2 -tempOwnAnimalsCounter[0]);
    }

    /**
    * This function redos the move of a player
    * 
    */
    public void redo ()
    {
        int[] tempOwnAnimalsCounter = new int[2];
        tempOwnAnimalsCounter[0] = 0;
        tempOwnAnimalsCounter[1] = 0;
        
        // If redo is executed (not the last state History of arrCells to be redone)
        if (bBoardGame.redo()) 
        {
            changePlayerInTurn();
        }

        // RESET the count of killed animals of both players
        for (int i = 0; i < BoardGame.getMAX_ROW(); i++)
        {
            for (int j = 0; j < BoardGame.getMAX_COL(); j++)
            {
                if(this.bBoardGame.getBoardCell(i, j).getAnimal() != null)
                {
                    if(this.bBoardGame.getBoardCell(i, j).getAnimal().isOwnColor(true))
                    {
                        tempOwnAnimalsCounter[0]++;
                    }
                    else
                    {
                        tempOwnAnimalsCounter[1]++;
                    }
                }
            }
        }
        getPlayer(true).setKilledAnimalCounter(BoardGame.getMAX_ANIMALS()/2 - tempOwnAnimalsCounter[1]);
        getPlayer(false).setKilledAnimalCounter(BoardGame.getMAX_ANIMALS()/2 -tempOwnAnimalsCounter[0]);
    }

    /**
     * Reset the game to its original state
     */
    public void resetGame()
    {
        // Reset Board Game
        bBoardGame.resetBoardGame();

        // Reset Players
        for(int i = 0; i < BoardGame.getMAX_PLAYERS(); i++)
        {
            arrPlayers.get(i).resetPlayer();
        }
    }
}