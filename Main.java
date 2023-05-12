import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

class Main {

  private static int m;
  private static int p;
  private static int n;
  private static int [][] a;
  private static int [][] b;
  private static int [][] v;
  public static int [][] c;
  public static int [][]f;
  
  
  
  public static void main(String[] args) 
  {
    System.out.println("Welcome to the resource requirement calculator.");

    // Ask the user to enter a file name.
    
    Scanner in = new Scanner(System.in);
		System.out.print("Please enter a file name containing the data: ");
		String filename = in.nextLine();
		in.close();

    // Checking if the file exists. If it does, storing the data that's in the file. 
    
    File file = new File(filename);
    Scanner rd = null;
    try 
      {
        rd = new Scanner(file);
        // Store the basic resources M
        m = rd.nextInt();
        // Store the intermediate materials N
        n = rd.nextInt();
        //Store the final products P
        p = rd.nextInt();

        // Initialize and store matrix A that defines the number of basic resources to produce intermediate materials.
        a = new int[m][n];

        rd.nextLine();
        for(int i = 0; i< m;i++)
        {
          for(int j = 0; j < n; j++)
          {
            a[i][j] = rd.nextInt();
          }
        }

        //Initialize and store matrix B that defines the number of intermediate materials to produce final products
        b = new int[n][p];
        
        for(int i = 0; i< n;i++)
        {
          for(int j = 0; j < p; j++)
          {
            b[i][j] = rd.nextInt();
          }
        }

        //Initialize and store matrix V containing the amount of each of the final products we want to produce
        v = new int [p][1];
        for(int i = 0; i< p;i++)
        {
          v[i][0] = rd.nextInt();
        }
        
      rd.close();
      }
    catch (FileNotFoundException e)
      {
        System.out.println("File not found.");
			  return;
      }

    //Initialize new matrix C that defines how many of each basic resource is required to produce a given final product
    c = new int [m][p];
    //Initialize new matrix F telling us how much of each basic resource we will need.
    f = new int [m][1];

    //Get matrix C
    multiply(a,b,c);
    //Get matrix F
    multiply(c,v,f);

    System.out.println("The number of basic resources required is:");
    // Print matrix F
    print(f);
    System.out.println("Thank you!");
    
    
  }

  //Method to multiply matrix1 by matrix2 using threads
  private static void multiply( int[][] matrix1, int[][] matrix2, int[][] result ) 
  {
    int rows = matrix1.length;
    RowMultiply[] threads = new RowMultiply[rows];
    for ( int i = 0; i < rows; i++ ) 
    {
      threads[i] = new RowMultiply(result, matrix1, matrix2, i);
      threads[i].start( );
      try 
      {
        threads[i].join( );
      } 
      catch( InterruptedException e) 
      {
        e.printStackTrace();
      }
    } 
  }


  //Method to print a matrix
  public static void print(int [][] matrix)
  {
    int rows = matrix.length;
    int cols = matrix[0].length;

    for ( int i = 0; i < rows; i++ ) 
    {
      for ( int j = 0; j < cols; j++ ) 
      {
        System.out.print( matrix[i][j] + " " );
      }
      System.out.println( );
    }
  }

}