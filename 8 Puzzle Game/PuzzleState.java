package Assignment1;


import java.util.Objects;

/**
 *
 * @author shariar
 */

public class PuzzleState {
    int Board[][],boardRow,boardCoulumn;
    static int finalstate[][]=null;
   
    public PuzzleState(int Board[][])
    {
       // super();
        this.Board=Board;
       
        for (int i = 0; i < 3; ++i) {
	     for (int j = 0; j < 3; ++j){
		 if (Board[i][j] == 0) {
				boardRow = i;
			    boardCoulumn = j;
                break;
		    }
		}
        }
    
    }
   
    

    public PuzzleState up() {

		if (boardRow == 0)
			return null;

		int newBoard[][] = new int[3][3];

		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				newBoard[i][j] = Board[i][j];

		int temp = newBoard[boardRow][boardCoulumn];
		newBoard[boardRow][boardCoulumn] = newBoard[boardRow - 1][boardCoulumn];
		newBoard[boardRow - 1][boardCoulumn] = temp;

		return new PuzzleState(newBoard);
	}

	public PuzzleState down() {

                if (boardRow == 2)
			return null;

		int newBoard[][] = new int[3][3];

		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				newBoard[i][j] = Board[i][j];

		int temp = newBoard[boardRow][boardCoulumn];
		newBoard[boardRow][boardCoulumn] = newBoard[boardRow + 1][boardCoulumn];
		newBoard[boardRow + 1][boardCoulumn] = temp;

		return new PuzzleState(newBoard);
		
	}

	public PuzzleState left() {

                if (boardCoulumn == 0)
			return null;

		int newBoard[][] = new int[3][3];

		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				newBoard[i][j] = Board[i][j];

		int temp = newBoard[boardRow][boardCoulumn];
		newBoard[boardRow][boardCoulumn] = newBoard[boardRow ][boardCoulumn - 1];
		newBoard[boardRow][boardCoulumn -1 ] = temp;

		return new PuzzleState(newBoard);
	}

	public PuzzleState right() {

                if (boardCoulumn == 2)
			return null;

		int newBoard[][] = new int[3][3];

		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				newBoard[i][j] = Board[i][j];

		int temp = newBoard[boardRow][boardCoulumn];
		newBoard[boardRow][boardCoulumn] = newBoard[boardRow ][boardCoulumn + 1];
		newBoard[boardRow][boardCoulumn + 1 ] = temp;

		return new PuzzleState(newBoard);
	}


    @Override
	public String toString() {

		String s = "";

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j)
				s += Board[i][j];

			s += "\n";
		}

		return s;
	}

    public int manhattan_distance() {

        int h = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(Board[i][j] == 1)
                    h+= (Math.abs(i-0)+Math.abs(j-0));
                if(Board[i][j] == 2)
                    h+= (Math.abs(i-0)+Math.abs(j-1));
                if(Board[i][j] == 3)
                    h+= (Math.abs(i-0)+Math.abs(j-2));
                if(Board[i][j] == 4)
                    h+= (Math.abs(i-1)+Math.abs(j-0));
                if(Board[i][j] == 5)
                    h+= (Math.abs(i-1)+Math.abs(j-1));
                if(Board[i][j] == 6)
                    h+= (Math.abs(i-1)+Math.abs(j-2));
                if(Board[i][j] == 7)
                    h+= (Math.abs(i-2)+Math.abs(j-0));
                if(Board[i][j] == 8)
                    h+= (Math.abs(i-2)+Math.abs(j-1));
            }
        }

        return h;
    }

	public int misplaced_tiles() {
		int h = 0;
         for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (Board[i][j] != 0) {
                    if ((i != (Board[i][j] /3)) || (j != ((Board[i][j] % 3) - 1))) {
                        h += 1;
                    }
                }
            }
        }
		return h;
	}

    public static void PassGoalState(int[][] a) {
    	finalstate=a;
    }
    
    boolean goal_test() {
    	return Board[0][0]==finalstate[0][0] && Board[0][1]==finalstate[0][1] &&
    			Board[0][2]==finalstate[0][2] && Board[1][0]==finalstate[1][0] &&
    					Board[1][1]==finalstate[1][1] && Board[1][2]==finalstate[1][2] &&
    							Board[2][0]==finalstate[2][0] && Board[2][1]==finalstate[2][1] &&
    									Board[2][2]==finalstate[2][2] ;
    			
    }
     @Override
    public boolean equals(Object obj) {

        PuzzleState s = (PuzzleState) obj;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (Board[i][j] != s.Board[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
    	@Override
	public int hashCode() {
		return Objects.hash(Board[0][0], Board[0][1], Board[0][2], Board[1][0],
						Board[1][1], Board[1][2], Board[2][0], Board[2][1],
						Board[2][2]);
	}
 
}
