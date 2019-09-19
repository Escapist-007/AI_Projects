/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_02;

import java.util.Random;


public class ZeroOneExchange 
{
	private static Random random = new Random(System.currentTimeMillis());
	public static Route apply(Route rt) 
	{
		
		Route route = new Route (rt);
		
//		System.out.println(rt.route);
//		System.out.println(route.route);
//		rt.print();
//		route.print();
		
		int n = route.n;  // Length of the route
		int rand_1= random.nextInt(n); // Random integer between 1 to n
		int p = route.route.remove(rand_1); // removing the city from route( An arraylist of integer )

	       //rt.print();
	       //route.print();

                int rand_2 = 0;
		
                while(true)
                {
                    rand_2 = random.nextInt(n-1);
                    if(rand_1==rand_2)continue;
                    break;
                }
		
		route.route.add(rand_2,p); // add the removed city at position rand_2
		
		//rt.print();
		//route.print();

		route.updateCost();
		return route;
                
	}
}
