package Assignment1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
*
* @author shariar
*/
public class Solver {
	static int row=3,col=3;
	 static int SBoard[][]=new int[row][col];
	
    public void takeInput() throws FileNotFoundException, IOException{
    	
        FileInputStream fstream = new FileInputStream("inputOutput.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        
        String strLine;
        int line=0;
        while((strLine=br.readLine())!=null)
        {
        	//System.out.println(strLine);
        	String[] x=strLine.split("");
        	for(int i=0;i<x.length;i++)
        	{
        		if(x[i].equals(" "))
        		{
        			x[i]="0";
        		}
        	}
        	if(line ==1)
        	{
        	// System.out.println(strLine);
        	 SBoard[0][0]=Integer.parseInt(x[0]);
        	 SBoard[0][1]=Integer.parseInt(x[1]);
        	 SBoard[0][2]=Integer.parseInt(x[2]);
        	}
        	if(line ==2)
        	{
        	// System.out.println(strLine);
        	 SBoard[1][0]=Integer.parseInt(x[0]);
        	 SBoard[1][1]=Integer.parseInt(x[1]);
        	 SBoard[1][2]=Integer.parseInt(x[2]);
        	}
        	if(line ==3)
        	{
        	 //System.out.println(strLine);
        	 SBoard[2][0]=Integer.parseInt(x[0]);
        	 SBoard[2][1]=Integer.parseInt(x[1]);
        	 SBoard[2][2]=Integer.parseInt(x[2]);
        	}
        	++line;
        }
        
    }

		public static void main(String[] args) {
				Solver input=new Solver();
				try {
					input.takeInput();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Initial State: ");
		        for (int i = 0; i < row; ++i) {
		   	     for (int j = 0; j < col; ++j){
		             System.out.print(SBoard[i][j]+"");
		   		} System.out.println("");
		           }
		        
		        int FBoard[][]={{0,1,2},{3,4,5},{6,7,8}};
		        
		        PuzzleState initialState=new PuzzleState(SBoard);
		        
		       
		        PuzzleState.PassGoalState(FBoard);
		        
		        PuzzleNode target = PuzzleNode.A_star(initialState);
		

				if (target != null) {
					System.out.println("\nSolution sequence:\n");
					PuzzleNode.print_soln(target);
				} else
					System.out.println("No solution found.");
		        
			}

	

}
