import java.util.ArrayList;


public class Sudoku_Board {
	
	public Square [][] board;
	public ArrayList<Integer> unassigned_var;
	
	Sudoku_Board(Square[][] b){
		
		unassigned_var = new ArrayList<Integer>();
		board = b;
		int position = 0;
                
		for(int i=0;i<9;i++){
                    for(int j=0;j<9;j++){
                            if(!board[i][j].pre_assigned){
                                    unassigned_var.add(position);
                            }
                            position++;
                    }
		}
		
		System.out.println();
	}
	
	
	//Checking if sudoku game is finshed or not
	public boolean isFinished(){
	       	
                //Check if any square is unassigned or not
                int i=0,j=0;
                
                while(i<9){
                    j=0;
                    while(j<9){
                        if(board[i][j].Assigned_value==0)
			  return false;
			j++;
                   }
                  
                  i++;
                }
               
                //check if any squre is inconsistent or not
                i=0;j=0;
                
                while(i<9){
                    j=0;
                    while(j<9){
                        
                        if(!Consistency_checking(i,j,board[i][j].Assigned_value))
		          return false;
			
			j++;
                  }
                  i++;
                }
           	
		return true;
	}
	
	
	
    public boolean Consistency_checking(int x,int y,int value){
		
        int i = x;
        int j = y;

        //Checking  Row-Consistency
        
        for(int k=0;k<9;k++){
            
            if((k!=j && board[i][k].Assigned_value==value))
                    return false;
            
        }

        //Checking  Column-Consistency
        
        for(int k=0;k<9;k++){	
            
            if(k!=i && board[k][j].Assigned_value==value)
                    return false;
            
        }

        //checking Block-Consistency
        
        int X = (i/3)*3;
        int Y = (j/3)*3;

        for(int m=X ; m < X+3 ; m++){	
            
                for(int n=Y ; n< Y+3 ; n++){
                    
                        if((m!=i && n!=j) && board[m][n].Assigned_value==value)
                                return false;
                        			
                }
        }

        return true;
     }
	
	
	
	
    public String toString() 
	{
		String str="";
		
		for (int i=0; i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				str += (board[i][j].Assigned_value+" ");
			}
			str +="\n";
		}
		return str;
	}
	
}
