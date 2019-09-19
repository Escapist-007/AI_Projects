import java.io.File;
import java.io.FileNotFoundException;
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
		Route route = new Route(this);
		//route.print();
		

		FirstChoiceHillClimb fchc = new FirstChoiceHillClimb(this, 50000);
		SolutionInfo si = fchc.run();
		
		System.out.println(si.solution.getCost());
		si.solution.print();
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
		
	}
	
	public static void main(String[] args)
	{
		try 
		{
			Scanner in = new Scanner(new File("test.tsp"));
			//Scanner in = new Scanner(new File("att48.tsp"));
			//Scanner in = new Scanner(new File("burma14.tsp"));
			//Scanner in = new Scanner(new File("st70.tsp"));
			//Scanner in = new Scanner(new File("ulysses16.tsp"));
			//Scanner in = new Scanner(new File("ulysses22.tsp"));
			
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
