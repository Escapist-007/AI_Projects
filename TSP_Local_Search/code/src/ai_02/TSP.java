/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_02;

import java.io.File;
import java.util.Scanner;


public class TSP 
{
	double x[], y[];
	int n;

	public TSP(double x[], double y[], int n) 
	{
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.n = n;

	}
	
	private void solve() {
		// TODO Auto-generated method stub
                    //int s=10;
                    
                    int sigma[] = {5000,10000,15000,20000,25000,30000,35000,40000,45000,50000};
                    
                    for(int j=0 ;j<=9; j++){
                        double total_cost = 0;
                        double total_count = 0;
                    //Just initially assuming a huge value for min_cost
                        double min_cost = 999999999999.9;
            
                        for(int i=0;i<10;i++){

                            Route route = new Route(this);

                            FirstChoiceHillClimb fchc = new FirstChoiceHillClimb(this,sigma[j]);
                            SolutionInfo si = fchc.run();

                            total_cost = total_cost + si.solution.getCost();
                            total_count = total_count + si.loopCount;

                            if(si.solution.getCost()<min_cost){
                                min_cost = si.solution.getCost();
                            }

                        }
                        //System.out.println("Sigma :"+s);
                        System.out.println("Value of sigma: "+sigma[j]);
                        System.out.println("average count: "+total_count/10);
                        System.out.println("average cost: "+total_cost/10);
                        System.out.println("minimum cost: "+min_cost);
                        System.out.println();
                   
                    }
                    
                    //s=s+100;
                    
                    //if(s==300)
                      //  break;
               
                	
               //si.solution.print();
	}
        
        
	void print()
	{
		System.out.println("Dimension: "+n);
		for (int i = 0; i < n; i++) {
			System.out.println(x[i] + " " + y[i]);
		}
	}
	
	/**
	 * Returns the distance between the node a and b
	 * @param a
	 * @param b
	 * @return
	 */
	public double edgeCost(int a, int b)
	{
		return 1.0;
	}
	
	public static void main(String[] args)
	{
		try 
		{
			//Scanner in = new Scanner(new File("test.tsp"));
			//Scanner in = new Scanner(new File("att48.tsp"));
			 //Scanner in = new Scanner(new File("burma14.tsp"));
			//Scanner in = new Scanner(new File("st70.tsp"));
			//Scanner in = new Scanner(new File("ulysses16.tsp"));
			Scanner in = new Scanner(new File("ulysses22.tsp"));
			
			String line = "";
			int n;
			
			//three comment lines
			in.nextLine();
			in.nextLine();
			in.nextLine();
			//get n
			line = in.nextLine();
			line = line.substring(11).trim();
			n = Integer.parseInt(line);
			
			//System.out.println("" +n);
			
			//two comment lines
			in.nextLine();
			in.nextLine();
			
			double x[] = new double[n];
			double y[] = new double[n];
			
			for (int i = 0; i < n; i++)
			{
				in.nextInt();
				x[i] = in.nextDouble();
				y[i] = in.nextDouble();
			}
			
			TSP tsp = new TSP (x,y,n);
			//tsp.print();
			tsp.solve();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}

