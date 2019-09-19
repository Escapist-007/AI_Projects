
public class Backtracking_Forward_Checking {
	
	public Sudoku_Board board;
	public int back_track = 0;
	public int Variable_Count;
	public int Value_Count;
        
	Backtracking_Forward_Checking(Sudoku_Board b){
		
		Variable_Count = 0;
		Value_Count = 0;
		board = b;
	}
	
	
	public boolean BackTrack(){
		
		
		if(board.isFinished())
		{
                    System.out.println("Variable Count: "+Variable_Count+" Value_Count: "+Value_Count);
                    System.out.println("\n");
                    return true;
		}
			
		int position = variable_first();
		//int position = MRV();
                
		int i = position / 9;
		int j = position % 9;
		
		
		if(board.board[i][j].Domain.isEmpty()){
			
			System.out.println("Domain is empty:\n\n"+board.toString());
			return false;
		}
		
		
	if(!board.board[i][j].assigned){

            for(int k=0; k<board.board[i][j].Domain.size(); k++){

                int value = vaule_first(i,j,k);

                if(board.Consistency_checking(i,j,value)){

                    board.board[i][j].Assigned_value = value;
                    board.board[i][j].assigned = true;

                    if(Forward_Check(i,j,board.board[i][j].Assigned_value)){

                            try{

                                    boolean result = BackTrack();
                                    if(result)return result;

                            }catch(Exception IndexOutofBound){
                                    System.out.println(board.unassigned_var.size()+" "+position+1);
                            }
                    }


                    Backward_Check(i,j,board.board[i][j].Assigned_value);
                    
                    board.board[i][j].Assigned_value = 0;
                    board.board[i][j].assigned = false;

                 }
            }
			
        }
		
		return false;
    }
	
	public void Initial_Forward_Checking(){
		
            for(int i=0;i<9;i++){
                
                for(int j=0;j<9;j++){
                    
                        if(board.board[i][j].pre_assigned){

                            int val = board.board[i][j].Assigned_value;
                            Forward_Check(i,j,val);

                        }
                }
            }
	}
	
        //constraint propagation
        
	public boolean Forward_Check(int x,int y,int value){
		
        int i = x;
        int j = y;
        boolean flag;

        //Reducing the domain of the square in that row
        for(int k=0;k<9;k++){		
           
            if(k==j)continue; //skipping the square for which forward checking is  performed
            
            flag = (!board.board[i][k].pre_assigned) && (!board.board[i][k].assigned);
            
            if(flag){
                
                if(board.board[i][k].Domain.contains((Integer)value))

                    board.board[i][k].Domain.remove((Integer)value);
            }
        }
    
        
        //Reducing the domain of the square in that column

        for(int k=0;k<9;k++){					
            
            if(k==i)continue; ////skipping the square for which forward checking is  performed
            
            flag = (!board.board[k][j].pre_assigned) && (!board.board[k][j].assigned);
            
            if(flag){

                if(board.board[k][j].Domain.contains((Integer)value))
                    
                        board.board[k][j].Domain.remove((Integer)value);
                
            }
        }
        
        //Reducing the domain of the square in that block/regions
        
        int X = (i/3)*3;
        int Y = (j/3)*3;

        for(int m = X ; m< X+3 ; m++){	
            
            for(int n = Y ; n < Y+3 ; n++){
            
                if(m==i && n==j)continue;
                
                flag = (!board.board[m][n].pre_assigned) && (!board.board[m][n].assigned);
                
                if(flag){
                    
                    if(board.board[m][n].Domain.contains((Integer)value))
                            board.board[m][n].Domain.remove((Integer)value);
                }			
            }
        }

        //inference constraint propagation check
        
        for(i=0;i<9;i++){
            
            for(j=0;j<9;j++){
                
                // checking if domain is empty for any variable
                if(board.board[i][j].Domain.isEmpty())
                     return false;
          
            }
        }

        return true;
		
   }
	
        public void Backward_Check(int x,int y,int value){
		
        int i = x;
        int j = y;
        boolean flag;

        //Fixing the domain of the square in that row
        for(int k=0;k<9;k++){		
           
            if(k==j)continue; //skipping the square for which forward checking is  performed
            
            flag = (!board.board[i][k].pre_assigned) && (!board.board[i][k].assigned);
            
            if(flag){
                
                if(!board.board[i][k].Domain.contains((Integer)value))

                    board.board[i][k].Domain.add(value);
            }
        }
        
        //Fixing the domain of the square in that column

        for(int k=0;k<9;k++){					
            
            if(k==i)continue; ////skipping the square for which forward checking is  performed
            
            flag = (!board.board[k][j].pre_assigned) && (!board.board[k][j].assigned);
            
            if(flag){

                if(!board.board[k][j].Domain.contains((Integer)value))
                    
                        board.board[k][j].Domain.add(value);
                
            }
        }

        //Fixing the domain of the square in that block/regions
        
        int X = (i/3)*3;
        int Y = (j/3)*3;

        for(int m = X ; m< X+3 ; m++){	
            
            for(int n = Y ; n < Y+3 ; n++){
            
                if(m==i && n==j)continue;
                
                flag = (!board.board[m][n].pre_assigned) && (!board.board[m][n].assigned);
                
                if(flag){
                    
                    if(!board.board[m][n].Domain.contains((Integer)value))
                            board.board[m][n].Domain.add((Integer)value);
                }			
            }
        }

       
  }
	
	
	public int variable_first(){
		
            Variable_Count++;

            for(int i=0;i<board.unassigned_var.size();i++){
                
                int row = board.unassigned_var.get(i)/9 ;
                int col = board.unassigned_var.get(i)%9 ;
                
                if(!board.board[row][col].assigned)
                   return board.unassigned_var.get(i);
                 
            }

            return -1;
	}
	
	
	public int MRV(){
		
            int min_domain = 200000;
            int position = -1;
            Variable_Count++;

           for(int i=0;i<board.unassigned_var.size();i++){

                int x = board.unassigned_var.get(i)/9;
                int y = board.unassigned_var.get(i)%9;

                if((!board.board[x][y].assigned) && (board.board[x][y].Domain.size()< min_domain) ){

                        min_domain = board.board[x][y].Domain.size();
                        position = board.unassigned_var.get(i);
                }
           }


           return position;
	}
        //value heuristic
	public int vaule_first(int x,int y,int z){
		
		Value_Count++;
                
		for(int j=0;j<board.board[x][y].Domain.size();j++){
			
			if(j==z){
				
				return board.board[x][y].Domain.get(z); 
			}
		}
		
		return 0;
	}
	

}
