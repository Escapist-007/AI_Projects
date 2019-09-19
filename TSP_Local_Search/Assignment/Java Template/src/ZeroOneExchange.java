import java.util.Random;


public class ZeroOneExchange 
{
	private static Random random = new Random(System.currentTimeMillis());
	public static Route apply(Route rt) 
	{
		
		Route route = new Route (rt);

		route.updateCost();
		return route;
	}
}
