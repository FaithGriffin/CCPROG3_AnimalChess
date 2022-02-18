package Model;

import java.util.Stack;

/** 
* Represents a Board of the  Game
* 
* @author Kriz Royce Tahimic
* @author Faith Juliamae Griffin
* @version 28.0
* @since 1.0
*/
public class BoardGame {
    private BoardCell[][] arrCells;
    private static final int MAX_ROW = 7;
    private static final int MAX_COL = 9;
    private static final int MAX_ANIMALS = 16; // Count of ALL animals BOTH BLUE and RED
    private static final int MAX_PLAYERS = 2;

    private Stack<BoardCell[][]> undoStackHistory;
    private Stack<BoardCell[][]> redoStackHistory;

    /** Constructs the BoardGame
     *  Initialie the Animals
     *  Set the Rivers
     *  Set the Dens
     *  Set the Traps
     *  Create the undo Stack
     *  Create the redo Stack
     * 
     */
    public BoardGame ()
    {
      // Create all  BoardCelss
        this.arrCells = new BoardCell[MAX_ROW][MAX_COL];
        for (int i = 0; i < MAX_ROW; i++)
        {
            for (int j = 0; j < MAX_COL; j++)
            {
                arrCells[i][j] = new BoardCell();
            }
        }
        setAnimals();
        setRivers();
        setDens();
        setTraps();
        undoStackHistory  = new Stack<BoardCell[][]>();
        redoStackHistory  = new Stack<BoardCell[][]>();


    }

    /** Clones the current version of Animals in arrCells
     * 
     * @return BoardCell[][] of the current version of Animals in arrCells
     */
    private BoardCell[][] cloneBoardCells() 
    {
      BoardCell[][] tempBoardCells = new BoardCell[MAX_ROW][MAX_COL];

      for (int i = 0; i < MAX_ROW; i++)
      {
        for (int j = 0; j < MAX_COL; j++)
        {
            tempBoardCells[i][j] = new BoardCell();
            // If there is an animal
            if (this.arrCells[i][j].getAnimal()!= null)
            {
              // Initialize the animal
              tempBoardCells[i][j].setAnimal(this.arrCells[i][j].getAnimal());
            }
            else
            {
              tempBoardCells[i][j].setAnimal(null);
            }
        }
        
      }
      return tempBoardCells;
    }

    /** Push the current version of arrCells to undoStackHistory
     * 
     */
    public void pushArrCellsForUndo()
    {
      undoStackHistory.push(cloneBoardCells());
    }

    /** Undoes the Animals in the GameBoard
     * 
     * @return true if NOT the last 1 undoStackHistory, else return false
     */
    public boolean undo ()
    {
      boolean bTempReturn = undoStackHistory.size() > 1;

      // Prevents storing of the same states when undo is clicked repeatedly when reaching the Original State
      // If undoStackHistory still has more than the Original State of Animals
      if(bTempReturn)
      {
        // Store the current verions of arrCells to redoStackHistory
        redoStackHistory.push(cloneBoardCells());
      }

      // PLACE THE ANIMALS
      for (int i = 0; i < MAX_ROW; i++)
      {
          for (int j = 0; j < MAX_COL; j++)
          {
            if(undoStackHistory.peek()[i][j].getAnimal() != null)
            {
              this.arrCells[i][j].setAnimal(undoStackHistory.peek()[i][j].getAnimal());
            }
            else
            {
              this.arrCells[i][j].setAnimal(null);
            }
          }
      }
      
      // If undoStackHistory still has more than the Original State of Animals
      if(bTempReturn) 
      {
        // Remove the peeked state used to update the arrCells
        undoStackHistory.pop();
        return true;
      }
      else{
        return false;
      }
    }

    /** Redoes the Animals in the GameBoard
     * 
     * @return true if NOT the last 1 redoStackHistory, else return false
     */
    public boolean redo ()
    {
      // PLACE THE ANIMALS
      if(!redoStackHistory.isEmpty())
      {
        undoStackHistory.push(cloneBoardCells());
        for (int i = 0; i < MAX_ROW; i++)
        {
            for (int j = 0; j < MAX_COL; j++)
            {
              if(redoStackHistory.peek()[i][j].getAnimal() != null)
              {
                this.arrCells[i][j].setAnimal(redoStackHistory.peek()[i][j].getAnimal());
              }
              else
              {
                this.arrCells[i][j].setAnimal(null);
              }
            }
        }
      }
      
      // If not the latest state
      if(redoStackHistory.size() > 1)
      {
        // pop the already peeked redoStackHistory
        redoStackHistory.pop();
        return true;
      }
      else
      {
        return false;
      }
    }


    /** Checks if the undoStackHistory is Empty
     * 
     * @return true if undoStackHistory is Empty, otherwise return false
     */
    public boolean isUndoStackHistoryEmpty()
    {
      return undoStackHistory.isEmpty();
    }

    /** Reset the arrCells animals to its original state
     * 
     */
    public void resetBoardGame()
    {
      // Remove all animals in the arrCells
      for (int i = 0; i < MAX_ROW; i++)
      {
        for (int j = 0; j < MAX_COL; j++)
        {
            arrCells[i][j].setAnimal(null);
        }
      }

      // Set the animals to its Orginal locations
      setAnimals();
    }

    /** Set the arrCells river Locations
     * 
     */
    private void setRivers() 
    {
      for (int i = 0; i < MAX_ROW; i++)
      {
        for (int j = 0; j < MAX_COL; j++)
        {
          /* Check if in should be river coordinates */
          if( 1<=i && 3!=i && i<=5 )
          {
            /* Check if in column with river */
            if( 3<=j && j<= 5 )
            {
              arrCells[i][j].setRiver();
            }
          }
        }
      }
    }

    /** Set the arrCells dens Locations and color
     * 
     */
    private void setDens() 
    {
        int[][] arrDen = new int[][] {{3,0},{3,8}};
        for(int i = 0; i < MAX_PLAYERS; i++)
        {
          arrCells[arrDen[i][0]][arrDen[i][1]].setColor(i==0);
          arrCells[arrDen[i][0]][arrDen[i][1]].setDen(); /* Assign the Den locations */
        }
    }

    /** Set the arrCells trap Locations and color
     * 
     */
    private void setTraps () 
    {
        int nTrapPerColor = 3;
        int[][][] arrTrap = new int [][][] {{{2,0},{3,1},{4,0}},
                                        {{2,8},{3,7},{4,8}}};
        for(int i = 0; i < MAX_PLAYERS; i++)
        {
            for(int k = 0; k < nTrapPerColor; k++)
            {    
              arrCells[arrTrap[i][k][0]][arrTrap[i][k][1]].setColor(i==0); // Assign the color of the trap
              arrCells[arrTrap[i][k][0]][arrTrap[i][k][1]].setTrap(); /* Assign the Trap Locations */
            }
        }
    }

    /** 
     * Create animals to the first locations
     */
    private void setAnimals ()
    {
      int[][][] arrAnimalInitial = new int [][][] {{{6,2}, {1,1}, {5,1}, {2,2}, {4,2}, {0,0}, {6,0}, {0,2}},
                                                {{0,6}, {5,7}, {1,7}, {4,6}, {2,6}, {6,8}, {0,8},{6,6}}};
      
      for(int i = 0; i < MAX_PLAYERS; i++)
      {
        Animal[] arrAnimals = new Animal[MAX_ANIMALS];
        arrAnimals[0] = new Mouse();
        arrAnimals[1] = new Cat();
        arrAnimals[2] = new Dog();
        arrAnimals[3] = new Wolf();
        arrAnimals[4] = new Leopard();
        arrAnimals[5] = new Tiger();
        arrAnimals[6] = new Lion();
        arrAnimals[7] = new Elephant();
      
        for(int k = 0; k < MAX_ANIMALS/2; k++)
        {
          arrCells[arrAnimalInitial[i][k][0]][arrAnimalInitial[i][k][1]].setAnimal(arrAnimals[k]);
          arrCells[arrAnimalInitial[i][k][0]][arrAnimalInitial[i][k][1]].getAnimal().setColor(i==0);
        }  
      }
    }

    /**
     * Get the MAX_PLAYERS
     * @return int MAX_PLAYERS
     */
    public static int getMAX_PLAYERS ()
    {
      return MAX_PLAYERS;
    }

    /**
     *  Gets the MAX_ANIMALS
     * @return int MAX_ANIMALS
     */
    public static int getMAX_ANIMALS ()
    {
      return MAX_ANIMALS;
    }

    /**
     * Gets the MAX_ROW
     * @return int MAX_ROW
     */
    public static int getMAX_ROW ()
    {
      return MAX_ROW;
    }

    /**
     *  Gets the MAX_COL
     * @return int MAX_COL
     */
    public static int getMAX_COL ()
    {
      return MAX_COL;
    }

    /**
     * Gets the specific BoardCell in BoardCell[][]
     * @param nX 			ROW   of BoardCell want to be accessed
     * @param nY 			COLUMN    of BoardCell want to be accessed
     * @return BoardCell 	will return null if nX and nY are out of bounds, otherwise will return a BoardCell
     */
    public BoardCell getBoardCell (int nX, int nY)
    {
      if(isOutOfBounds(nX, nY))
      {
        return null;
      }
      else
      {
        return this.arrCells[nX][nY];
      }
    }

    /**
     * Move the animal in the INITIAL ROW and COL to POST ROW and COL
     * 
     * @param nInitX ROW   of INITIAL BoardCell to be accessed
     * @param nInitY COLUMN   of INITIAL BoardCell to be accessed
     * @param nPostX ROW   of POST BoardCell to be accessed
     * @param nPostY COLUMN   of POST BoardCell to be accessed
     * @param bPlayerInTurn true if current PlayerInTurn is BLUE and false for RED
     * @return boolean true if an animal was able to move, otherwise false
     */
    public boolean moveAnimal (int nInitX, int nInitY, int nPostX, int nPostY, boolean bPlayerInTurn)
    {
      // If possible move
      if( isPossibleMove( nInitX,  nInitY,  nPostX,  nPostY,  bPlayerInTurn))
      {
        // Store current arrCell state for undoStackHistory
        undoStackHistory.push(cloneBoardCells()); 

        // If the move eats an Animal
        if(this.arrCells[nPostX][nPostY].getAnimal() != null) 
        {
          // Increment the kill count of the playerInTurn
          Game.getPlayer(Game.getPlayerTurn()).incrementKilledEnemyAnimalCounter();
        }

        // Move the Animal
        this.arrCells[nPostX][nPostY].setAnimal(this.arrCells[nInitX][nInitY].getAnimal());

        // Remove the Animals in the moved Animal intial location
        this.arrCells[nInitX][nInitY].removeAnimal();
        
        
        redoStackHistory.clear(); // Prevents overlapping of inconsequence redoStackHistory
        redoStackHistory.push(cloneBoardCells()); // Store latest state
        return true;       
      }
      else 
      {
        return false;
      }
    }

    /**
     * Check if the ROW and COL is Out of Bounds of the declared arrCells
     * @param nX 	ROW
     * @param nY 	COL
     * @return boolean	true if nX and nRow will be out of bounds, otherwise false
     */
    public boolean isOutOfBounds(int nX, int nY)
    {
      if ( (nX >= MAX_ROW) || (nX < 0)
            || (nY >= MAX_COL) || (nY < 0))
      {
        return true;
      }
      else{
        return false;
      }
    }

    /**
     * Checks if the INITIAL AND POST ROWS and COLUMNS of the arrCells is Possible MOVE
     * @param nInitX ROW   of INITIAL BoardCell to be accessed
     * @param nInitY COLUMN   of INITIAL BoardCell to be accessed
     * @param nPostX ROW   of POST BoardCell to be accessed
     * @param nPostY COLUMN   of POST BoardCell to be accessed
     * @param bPlayerInTurn true if current PlayerInTurn is BLUE and false for RED
     * @return boolean	true if a move is possible, otherwise false
     */
    public boolean isPossibleMove(int nInitX, int nInitY, int nPostX, int nPostY, boolean bPlayerInTurn)
    {
      if(    !(isOutOfBounds(nInitX, nInitY)) // If Initial animal is not Out of Bounds
          && !(isOutOfBounds(nPostX, nPostY)) // If Post animal is not Out of Bounds
          && !(this.arrCells[nInitX][nInitY].getAnimal() == null) // If initial animal is not null
          && (this.arrCells[nInitX][nInitY].getAnimal().isOwnColor(bPlayerInTurn)) // If initial animal is own piece
          && (isProperDirection(nInitX, nInitY, nPostX, nPostY)) // If the move is proper direction
          && (canAnimalPerform(nInitX, nInitY, nPostX, nPostY)) // If the class of the animal can do the move
          && !(this.arrCells[nPostX][nPostY].isDen() && this.arrCells[nPostX][nPostY].isOwnColor(bPlayerInTurn)) //if animal does NOT go to own den
              //if POST Animal is NULL -OR- INITIAL animal can eat POST Animal
          && (   (this.arrCells[nPostX][nPostY].getAnimal() == null) 
              || (this.arrCells[nPostX][nPostY].getAnimal().isCaptured()) 
              || (canEat(nInitX, nInitY, nPostX, nPostY))
             )
        )
      {
        return true;
      }
      else
      {
        return false;
      }
    }

    /**
     * Checks if the Animal in the INITIAL ROW AND COL and eat the Animal in the POST ROW AND COL
     * 
     * @param nInitX ROW   of INITIAL BoardCell to be accessed
     * @param nInitY COLUMN   of INITIAL BoardCell to be accessed
     * @param nPostX ROW   of POST BoardCell to be accessed
     * @param nPostY COLUMN   of POST BoardCell to be accessed
     * @return true if the INITIAL ROW AND COL and eat the Animal in the POST ROW AND COL, otherwise returns false
     */
    private boolean canEat(int nInitX, int nInitY, int nPostX, int nPostY)
    {
      // If there is no animal to eat OR to be eaten
      if(this.arrCells[nInitX][nInitY].getAnimal() == null
        || this.arrCells[nPostX][nPostY].getAnimal() == null) 
      {
        return false; 
      }
      // If Mouse eats elephant
      if(this.arrCells[nInitX][nInitY].getAnimal() instanceof Mouse 
        && this.arrCells[nPostX][nPostY].getAnimal() instanceof Elephant)
      {
        return true;
      }
      // If elephant eats mouse
      else if (this.arrCells[nInitX][nInitY].getAnimal() instanceof Elephant 
                && this.arrCells[nPostX][nPostY].getAnimal() instanceof Mouse)
      {
        return false;
      }
      // If typical eating
      else if(this.arrCells[nInitX][nInitY].getAnimal().isLowerOrEqualRank(this.arrCells[nPostX][nPostY].getAnimal().getRank()) //if initial animal rank is > post animal
              || this.arrCells[nPostX][nPostY].getAnimal().isCaptured()) // Enemy is captured
      {
        return true;
      }
      else
      {
        return false;
      }
    } 

    /**
     * Checks if there is no SLANTED move
     * @param nInitX ROW   of INITIAL BoardCell to be accessed
     * @param nInitY COLUMN   of INITIAL BoardCell to be accessed
     * @param nPostX ROW   of POST BoardCell to be accessed
     * @param nPostY COLUMN   of POST BoardCell to be accessed
     * @return true if the move is NOT SLANTED, otherwise returns false
     */
    private boolean isProperDirection(int nInitX, int nInitY, int nPostX, int nPostY)
    {
      if(nInitX == nPostX // Similar ROWs
        || nInitY == nPostY)// Similar COLUMNS
      {
        return true;
      }
      else
      {
        return false;
      }
    }

    /**
     * Checks if the non abstract class of the animal can perform the inputted move from arrCells
     * @param nInitX ROW   of INITIAL BoardCell to be accessed
     * @param nInitY COLUMN   of INITIAL BoardCell to be accessed
     * @param nPostX ROW   of POST BoardCell to be accessed
     * @param nPostY COLUMN   of POST BoardCell to be accessed
     * @return true if the non abstract class of the animal can perform the inputted move from arrCells, otherwise returns false;
     */
    private boolean canAnimalPerform (int nInitX, int nInitY, int nPostX, int nPostY)
    {
      // Check if Single Move
      if( isSingleCellMove(nInitX, nInitY, nPostX, nPostY))
      {
        // If animal can water
        if( arrCells[nInitX][nInitY].getAnimal().getCanWater())
        {
          // If mouse eat an animal from river to land and viceversa
          if( ( (arrCells[nInitX][nInitY].isRiver() && !arrCells[nPostX][nPostY].isRiver()) 
                ||(!arrCells[nInitX][nInitY].isRiver() && arrCells[nPostX][nPostY].isRiver())
              )
              && (arrCells[nPostX][nPostY].getAnimal() != null))
          {
            return false;
          }
          else
          {
            return true;
          }
        }
        else
        {
          // if the animal goes to river
          if(arrCells[nPostX][nPostY].isRiver())
          {
            return false;
          }
          else
          {
            return true;
          }
        }
      }
      // If jump move
      else
      {
        // If post location is not in River
        // AND the animal can jump 
        // AND possibleJump
        if(!arrCells[nPostX][nPostY].isRiver() 
          && arrCells[nInitX][nInitY].getAnimal().getCanJump() 
          && isPossibleJump(nInitX, nInitY, nPostX, nPostY))
        {
          return true;
        }
        else
        {
          return false;
        }
      }
    }

    /**
     * Checks if the move only moves a distance of 1 arrCells
     * @param nInitX ROW   of INITIAL BoardCell to be accessed
     * @param nInitY COLUMN   of INITIAL BoardCell to be accessed
     * @param nPostX ROW   of POST BoardCell to be accessed
     * @param nPostY COLUMN   of POST BoardCell to be accessed
     * @return true if the move only moves a distance of 1 arrCells, otherwise returns false
     */
    private boolean isSingleCellMove (int nInitX, int nInitY, int nPostX, int nPostY)
    {
      // Computes the distance between arrCells
      if (Math.sqrt((nPostX-nInitX)*(nPostX-nInitX) + (nPostY-nInitY)*(nPostY-nInitY)) == 1.0)
      {
        return true;
      }
      else{
        return false;
      }
    }
    /** NOTE: Assumes only vertical and horizontal jump is done
     * 
     * Checks if the Jump is done properly in the river and without mouse in between
     * 
     * @param nInitX ROW   of INITIAL BoardCell to be accessed
     * @param nInitY COLUMN   of INITIAL BoardCell to be accessed
     * @param nPostX ROW   of POST BoardCell to be accessed
     * @param nPostY COLUMN   of POST BoardCell to be accessed
     * @return true if the Jump is done properly in the river and without mouse in between, otherwise returns false
     */
    private boolean isPossibleJump (int nInitX, int nInitY, int nPostX, int nPostY)
    {
      int nXStart,nXEnd;
      int nYStart,nYEnd;
      // Set the initializaiton for proper increment to take into account the move UP, DOWN, LEFT, RIGHT
      // IF UP
      if(nInitX < nPostX)
      {
        nXStart = nInitX;
        nXEnd = nPostX;
      }
      // DOWN
      else
      {
        nXStart = nPostX;
        nXEnd = nInitX;
      }
      // RIGHT
      if(nInitY < nPostY)
      {
        nYStart = nInitY;
        nYEnd = nPostY;
      }
      // LEFT
      else
      {
        nYStart = nPostY;
        nYEnd = nInitY;
      }

      // ROW Checking 
      for(int i = nXStart+1; i < nXEnd; i++)
      {
        // Check if NOT River OR ther is an animal in the area of jumping
        if(!arrCells[i][nInitY].isRiver()
            || arrCells[i][nInitY].getAnimal() != null)
        {
          return false;
        }
      }

      // COLUMN Checking 
      for(int i = nYStart+1; i < nYEnd; i++)
      {
        // Check if NOT River OR ther is an animal in the area of jumping
        if(!arrCells[nInitX][i].isRiver()
            || arrCells[nInitX][i].getAnimal() != null)
        {
          return false;
        }
      }
      return true;
    }
    /**
     * Updates the isCaptured animal in the POST ROW AND COL
     * AND checks if the currentPlayerInTurn is able to go to enemy's Den
     * @param nPostX ROW   of POST BoardCell to be accessed
     * @param nPostY COLUMN   of POST BoardCell to be accessed
     * @param bPlayerInTurn true if current PlayerInTurn is BLUE and false for RED
     * @return true if the currentPlayerInTurn is able to go to enemy's Den, otherwise returns false
     */
    public boolean updateStatus (int nPostX, int nPostY, boolean bPlayerInTurn)
    {
      //Check if new cell is a trap 
      if (this.arrCells[nPostX][nPostY].isTrap() && this.arrCells[nPostX][nPostY].isEnemyColor(bPlayerInTurn))
      {
        this.arrCells[nPostX][nPostY].getAnimal().setIsCaptured(true);
      }
      else
      {
        this.arrCells[nPostX][nPostY].getAnimal().setIsCaptured(false);
      }

      // Check if new cell is Den of the opponent
      if  (this.arrCells[nPostX][nPostY].isDen()
            && this.arrCells[nPostX][nPostY].isEnemyColor(bPlayerInTurn)
          )
      {
        return true;
      }
      return false;
    }

    /**
     * Check if the current playerInTurn has no possible moves left
     * @param bPlayerInTurn  true if current PlayerInTurn is BLUE and false for RED
     * @return true if the current playerInTurn has no possible moves left, otherwise returns false
     */
    public boolean isCheckMate (boolean bPlayerInTurn)
    {
      for (int i = 0; i < MAX_ROW; i++)
      {
        for (int j = 0; j < MAX_COL; j++)
        {
          // IF there is animal to move
          if( this.arrCells[i][j].getAnimal() != null
            && this.arrCells[i][j].getAnimal().isOwnColor(bPlayerInTurn))
          {
            // Check all move to all BoardCell
            for(int z = 0; z < MAX_ROW; z++)
            {
              for(int y = 0; y < MAX_ROW; y++)
              {
                if (isPossibleMove(i, j, z, y, bPlayerInTurn))
                {
                  return false;
                }
              }
            }
            
          }
        }
      }
      return true;
    }
}