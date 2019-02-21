package TicTacToeGame;

public class Move {

	int row,col;

	Computer c=new Computer();
	char player=c.ComputerMove;
	
	Human h=new Human();
	char opponent=h.HumanMove;
	
	public void getBoard(char board[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
    } 
    
    public void displayBoard(char board[][]) {
     for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }
    } 
 
 Boolean isMovesLeft(char board[][])
 {
     for (int i = 0; i<3; i++)
         for (int j = 0; j<3; j++)
             if (board[i][j]=='_')
                 return true;
     return false;
 }
 
 
 int evaluate(char b[][])
 {
   
	 Computer c=new Computer();
     for (int row = 0; row<3; row++)
     {
         if (b[row][0]==b[row][1] &&
             b[row][1]==b[row][2])
         {
             if (b[row][0]==player)
                 return +10;
             else if (b[row][0]==opponent)
                 return -10;
         }
     }
  
    
     for (int col = 0; col<3; col++)
     {
         if (b[0][col]==b[1][col] &&
             b[1][col]==b[2][col])
         {
             if (b[0][col]==player)
                 return +10;
  
             else if (b[0][col]==opponent)
                 return -10;
         }
     }
  

     if (b[0][0]==b[1][1] && b[1][1]==b[2][2])
     {
         if (b[0][0]==player)
             return +10;
         else if (b[0][0]==opponent)
             return -10;
     }
  
     if (b[0][2]==b[1][1] && b[1][1]==b[2][0])
     {
         if (b[0][2]==player)
             return +10;
         else if (b[0][2]==opponent)
             return -10;
     }
  
    
     return 0;
 }
    
    //Alpha Beta pruning named minimax
    int minimax(char board[][], int depth, Boolean isMax,int alpha,int beta)
    {
        int score = evaluate(board);
 
        if (score == 10)
            return score;
     
        if (score == -10)
            return score;
     
        if (isMovesLeft(board)==false)
            return 0;
     
        if (isMax)
        {
            int best = -1000;
     
            for (int i = 0; i<3; i++)
            {
                for (int j = 0; j<3; j++)
                {
                    if (board[i][j]=='_')
                    {
                        board[i][j] = player;
     
                        best = Math.max( best, minimax(board, depth+1, !isMax ,alpha,beta) );
                        
                        board[i][j] = '_';
                        
                        if(best >= beta)
                           return best; 	
                        
                        alpha=Math.max(alpha,best);
                        
                        
                    }
                }
            }
            return best;
        }
        else
        {
            int best = 1000;
            for (int i = 0; i<3; i++)
            {
                for (int j = 0; j<3; j++)
                {
                    if (board[i][j]=='_')
                    {
                        board[i][j] = opponent;
     
                        best = Math.min(best, minimax(board, depth+1, !isMax,alpha,beta));
     
                        board[i][j] = '_';
                        
                        if(best <= alpha)
                        {
                        	return best;
                        }
                    	beta= Math.min(beta,best);
                    }
                }
            }
            return best;
        }
    }
    
     
       
		Move findBestMove(char board[][])
        {
            int bestVal = -1000;
            Move bestMove = new Move();
            bestMove.row = -1;
            bestMove.col = -1;
            
            int alpha =-1000000;
            int beta  = 1000000;
         
            for (int i = 0; i<3; i++)
            {
                for (int j = 0; j<3; j++)
                {
                    if (board[i][j]=='_')
                    {
                        board[i][j] = player;
         
                        int moveVal = minimax(board, 0, false,alpha,beta);
         
                        board[i][j] = '_';
         
                        if (moveVal > bestVal)
                        {
                            bestMove.row = i;
                            bestMove.col = j;
                            bestVal = moveVal;
                        }
                    }
                }
            }
         
            //System.out.printf("The value of the best Move is : %d",bestVal);
         
            return bestMove;
        }  
		
		 public boolean hasXWon(char board[][]) {
		        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 1) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 'X')) {
		            //System.out.println("X Diagonal Win");
		            return true;
		        }
		        for (int i = 0; i < 3; ++i) {
		            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 'X')
		                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 'X'))) {
		                // System.out.println("X Row or Column win");
		                return true;
		            }
		        }
		        return false;
		    }

		    public boolean hasOWon(char board[][]) {
		        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == '0') || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == '0')) {
		            // System.out.println("O Diagonal Win");
		            return true;
		        }
		        for (int i = 0; i < 3; ++i) {
		            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == '0')
		                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == '0')) {
		                //  System.out.println("O Row or Column win");
		                return true;
		            }
		        }

		        return false;
		    }
		    
		 
		    
    }
    
	

