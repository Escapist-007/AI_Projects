
/**
 *
 * @author monir
 */
import java.util.ArrayList;


public class Square {
	
	public ArrayList<Integer> Domain; //Every Grid is a variable so it must have a domain of value satisfying constraint
        
	public boolean pre_assigned; // If any value is given as input or not
	public boolean assigned;
        
        public int Assigned_value;
	
	Square(int x,int y,int val){
		
		Domain = new ArrayList<Integer>();
                
		if(val!=0){
                    
                        assigned = true;
			Assigned_value = val;
			pre_assigned = true;
			
			Domain.add(val);
		}
		else{
			for(int i=0;i<9;i++){
				Domain.add(i+1);
			}
                        
			Assigned_value = 0;
			pre_assigned = false;
			assigned = false;
                        
			
		}
	}
	
}
