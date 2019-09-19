/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_02;

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
		Route parent = new Route(tsp);
                int count=0,i=0;
                Route child = null;
               
                while(true){
                    
                    for(i=0;i<sigma;i++){
                        
                        Random random= new Random(System.currentTimeMillis());
                        double ran= random.nextDouble(); //random number between 0 to 1
                      
                        
                        if(ran<0.5){ 
                            child = Two_Opt.apply(parent);
                        }
                        else{
                            child = ZeroOneExchange.apply(parent);
                        }
                      
                        //If child is better than parent then break
                        if( child.getCost()<parent.getCost() )
                            break;
                    }
                    if(i==sigma){
                        SolutionInfo si= new SolutionInfo(parent,count);
                        return si;
                    }
                    parent=child;
                    count++;
               }
	
	}	
}
