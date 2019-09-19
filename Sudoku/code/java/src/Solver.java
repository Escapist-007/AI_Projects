import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solver {

    public static Sudoku_Board Main_Board;
    
    public static void main(String[] args) {
        
    	long system_time = System.nanoTime();
        
          String filename = "Easy.txt";
         //String filename = "Hard.txt";
        // String filename = "Medium.txt";
        //String filename = "Medium_1.txt";
        
        
            try {
                    Main_Board = input(filename);
                    
            } catch (Exception e) {
                    
                e.printStackTrace();
                    
            }
		
        System.out.println(Main_Board.toString());

        Backtracking_Forward_Checking b_f = new Backtracking_Forward_Checking(Main_Board);
        
        b_f.Initial_Forward_Checking(); // Reduce the domain for pre_assigned values

        b_f.BackTrack();
        
        System.out.println(Main_Board.toString());
        System.out.printf("Time elapsed : %.2fms%n", (System.nanoTime() - system_time)/1000000.0);
  
    }
    
    
    public static Sudoku_Board input(String filename) throws IOException {

    	Scanner in = new Scanner(new File(filename));
			
        int dim = in.nextInt();	

        Square [][] sudoku_board = new Square[dim][dim];

        for (int i = 0; i < dim; i++) {
            
            for (int j = 0; j < dim; j++) {

                int val = in.nextInt();
                
                sudoku_board[i][j] = new Square(i,j,val);
                
            }
        }
			
            in.close();
            
            Sudoku_Board sudoku = new Sudoku_Board(sudoku_board);
            
            return sudoku;
            
	}
    
}
