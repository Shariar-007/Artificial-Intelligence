package TicTacToeGame;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char board[][] =new char[3][3];
	/*	char board[][] =new char[][]
				{
			       { '_', '_', '_' },
			       { '_', '_', '_' },
			       { '_', '_', '_' }
			    };
		
		*/
		Move b = new Move();
        Random rand = new Random();
        Scanner scanner=new Scanner(System.in);
       
        b.getBoard(board);
        b.displayBoard(board);
        
        int computer=rand.nextInt(2);
        if(computer == 1)
        {
        	//System.out.print("COMPUTER’S MOVE, ");
        	Move bestMove=b.findBestMove(board);
        	//System.out.print(", IT CHOSE ");
        	//System.out.println("ROW:"+bestMove.row+" "+"COL:"+bestMove.col );
        	
        	System.out.println("");
        	do
    		{
        	      
      
        		if(!b.hasOWon(board) && !b.hasXWon(board) && (board[0][0]!='_' && board[0][1]!= '_'&& board[0][2]
        				!='_' && board[1][0]!='_' && board[1][1]!='_' && board[1][2]!='_' && board[2][0]!='_'
        						&& board[2][1]!='_' && board[2][2]!='_'))
        		{
        			System.out.print("Match Draw.");
        			break;
        		}
        		if(b.hasOWon(board))
        		{
        			System.out.print("Human Win.");
        			break;
        		}
        		if(b.hasXWon(board))
        		{
        			System.out.print("Computer Win.");
        			break;
        		}
       
        	
        			System.out.print("COMPUTER’S MOVE, ");
                	Move bestMove1=b.findBestMove(board);
                	bestMove=bestMove1;
                	System.out.print(", IT CHOSE ");
                	System.out.println("ROW:"+bestMove1.row+" "+"COL:"+bestMove1.col );	
        		   
                	board[bestMove1.row][bestMove1.col]='X';
        		    b.displayBoard(board);
        		    
        		  
                		if(!b.hasOWon(board) && !b.hasXWon(board) && (board[0][0]!='_' && board[0][1]!= '_'&& board[0][2]
                				!='_' && board[1][0]!='_' && board[1][1]!='_'&& board[1][2]!='_' && board[2][0]!='_'
                						&& board[2][1]!='_' && board[2][2]!='_'))
                		{
                			System.out.print("MATCH DRAWS!");
                			break;
                		}
                		if(b.hasOWon(board))
                		{
                			System.out.print("HUMAN WINS!");
                			break;
                		}
                		if(b.hasXWon(board))
                		{
                			System.out.print("COMPUTER WINS!");
                			break;
                		}
               
        		    
        		   if(board[bestMove1.row][bestMove1.col] == 'X')
        		   {
        			   System.out.println("NOW THE MOVE IS HUMANS, PLEASE CHOOSE A ROW AND COLUMN");
        			   int HumanRow=scanner.nextInt();
        			   int HumanCol=scanner.nextInt();
        			   int k=0;
        			   do{
        				   if(k!=0){
        				   HumanRow=scanner.nextInt();
            			   HumanCol=scanner.nextInt();}
        				   k++;
        				   if(HumanRow >=3 || HumanCol>=3 || HumanRow <0 || HumanCol<0 )
            			   {
            				   System.out.println("ERROR! THE ROW OR COLUMN VALUE IS OUT OF ARRAY BOUND!");
            				   
            			   }
        				   else if(board[HumanRow][HumanCol] == 'X' || board[HumanRow][HumanCol] == '0') 
        			       {
        					 System.out.println("ERROR! THERE IS ALREADY A VALUE THERE!");
        					 
        			       }else
        			       {
        				     board[HumanRow][HumanCol]='0';
        				     b.displayBoard(board);
        				     break;
        			        }
        			   }while( HumanRow>= 3 || HumanCol>=3 || HumanRow < 0 || HumanCol < 0 || 
        					   board[HumanRow][HumanCol] == 'X'|| board[HumanRow][HumanCol] == '0');
        		   }
        		}while(bestMove.row>=0 && bestMove.col>=0 && bestMove.row < 3 && bestMove.col<3);
        		
        	
        }else
        {
        	Move bestMove=b.findBestMove(board);
          do{
            	System.out.println("NOW THE MOVE IS HUMANS, PLEASE CHOOSE A ROW AND COLUMN");
			   int HumanRow=scanner.nextInt();
			   int HumanCol=scanner.nextInt();
			   int k=0;
			   do{
				   if(k!=0){
				   HumanRow=scanner.nextInt();
    			   HumanCol=scanner.nextInt();}
				   k++;
				   if(HumanRow >=3 || HumanCol>=3 || HumanRow <0 || HumanCol<0 )
    			   {
    				   System.out.println("ERROR! THE ROW OR COLUMN VALUE IS OUT OF ARRAY BOUND!");
    				   
    			   }
				   else if(board[HumanRow][HumanCol] == 'X' || board[HumanRow][HumanCol] == '0') 
			       {
					 System.out.println("ERROR! THERE IS ALREADY A VALUE THERE!");
					 
			       }else
			       {
				     board[HumanRow][HumanCol]='0';
				     b.displayBoard(board);
				     break;
			        }
			   }while( HumanRow>= 3 || HumanCol>=3 || HumanRow < 0 || HumanCol < 0 || 
					   board[HumanRow][HumanCol] == 'X'|| board[HumanRow][HumanCol] == '0');
       
			   
		 if(!b.hasOWon(board) && !b.hasXWon(board) && (board[0][0]!='_' && board[0][1]!= '_'&& board[0][2]
       				!='_' && board[1][0]!='_' && board[1][1]!='_'&& board[1][2]!='_' && board[2][0]!='_'
       						&& board[2][1]!='_' && board[2][2]!='_'))
       		{
       			System.out.print("Match Draw.");
       			break;
       		}
       		if(b.hasOWon(board))
       		{
       			System.out.print("Human Win.");
       			break;
       		}
       		if(b.hasXWon(board))
       		{
       			System.out.print("Computer Win.");
       			break;
       		}
        
        
       		System.out.print("COMPUTER’S MOVE, ");
        	Move bestMove1=b.findBestMove(board);
        	bestMove=bestMove1;
        	System.out.print(", IT CHOSE ");
        	System.out.println("ROW:"+bestMove1.row+" "+"COL:"+bestMove1.col );	
		   
        	board[bestMove1.row][bestMove1.col]='X';
		    b.displayBoard(board);
		    
		  
        		if(!b.hasOWon(board) && !b.hasXWon(board) && (board[0][0]!='_' && board[0][1]!= '_'&& board[0][2]
        				!='_' && board[1][0]!='_' && board[1][1]!='_'&& board[1][2]!='_' && board[2][0]!='_'
        						&& board[2][1]!='_' && board[2][2]!='_'))
        		{
        			System.out.print("Match Draw!");
        			break;
        		}
        		if(b.hasOWon(board))
        		{
        			System.out.print("Human Win!");
        			break;
        		}
        		if(b.hasXWon(board))
        		{
        			System.out.print("Computer Win!");
        			break;
        		}

       		
       		
        }while(bestMove.row>=0 && bestMove.col>=0 && bestMove.row < 3 && bestMove.col<3);
        
       
        }
            
	}

}
