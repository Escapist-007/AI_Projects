import java.util.Random;


public class FirstChoiceHillClimb 
{
	TSP tsp;
	int sigma;
	
	public FirstChoiceHillClimb(TSP tsp, int sigma) 
	{
		// TODO Auto-generated constructor stub
		this.tsp = tsp;
		this.sigma = sigma;
	}
	
	/**
	 * Main loop of your local search algorithm. 
	 * After the search is complete, create a SolutionInfo Object 
	 * with related information and return to the caller to generate aggregated results
	 * @return
	 */
	public SolutionInfo run() 
	{
		//Main loop of your local search algorithm. 
		
	
		SolutionInfo si = new SolutionInfo(neighbor,count);	
		return si;
	}
	
	
	
	
	
}
