 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_02;

import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Route 
{
	ArrayList<Integer> route;
	int n;
	double cost;
	TSP tsp;
	
	/**
	 * Initialize a new route and update its cost
	 * @param tsp
	 */
	public Route(TSP tsp) {
		// TODO Auto-generated constructor stub
		this.n = tsp.n;
		this.tsp = tsp;
		route = new ArrayList<Integer>();
		
		initialize();
		updateCost();
	}
	
	/**
	 * Initialize a route with another route, makes a copy.
	 * @param src
	 */
	public Route(Route src)
	{
		this.n = src.n;
		this.tsp = src.tsp;
		
		route = new ArrayList<Integer>();
		
		for (Iterator iterator = src.route.iterator(); iterator.hasNext();) {
			route.add((Integer)iterator.next());
		}
		this.cost = updateCost();
	}
	
	
	/**
	 * Initializes a solution/route with a random permutation
	 */
	public void initialize() {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			route.add(i);
		}
		
		Collections.shuffle(route);
	}
	
	/**
	 * Prints the route
	 */
	
	public void print() 
	{
		for (Iterator iterator = route.iterator(); iterator.hasNext();) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
	
	/**
	 * Updates the member variable cost with the route length and also returns it. 
	 * @return
	 */
	public double updateCost()
	{
            double distance =0.0;
            for(int i=1;i<route.size();i++){
              
                int cur  = route.get(i);
                int prev = route.get(i-1);
                
                double x2= tsp.x[cur];
                double y2= tsp.y[cur];
                
                double x1= tsp.x[prev];
                double y1= tsp.y[prev];
                
                distance  = distance  +( sqrt (Math.pow((x2-x1),2)+Math.pow((y2-y1),2)));
            }
            this.cost = distance ;
            return distance ;
	}

	public double getCost() {
		return cost;
	}

}
