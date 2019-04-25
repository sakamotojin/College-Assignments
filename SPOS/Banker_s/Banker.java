/*
author : sakamoto_jin
u_know_me_and_u_don't_know_me
*/
import java.util.* ;
@SuppressWarnings("unchecked")
class Banker
{
  static int need[][] = new int[20][20] ;
  static int n , m ;
  static int available[] = new int [30] ;
  static int max[][] = new int [20][20] ;
  static int allocated [][] = new int [20][20] ;
  static boolean finished[] = new boolean [30] ;
  static Vector<Integer> sequence = new Vector() ;

  public static void main(String args[])
  {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the number of processes and resources ");
      n = sc.nextInt() ;
      m = sc.nextInt() ;

      System.out.println("Enter available Resource array ");
      for(int i =0 ; i < m ; i++)
        available[i] = sc.nextInt() ;

      System.out.println("Enter Max Resource Required matrix");
      for(int i =0 ; i < n ; i++)
        for(int j =0 ; j < m ; j++)
            max[i][j] = sc.nextInt();

      System.out.println("Enter Allocated Matrix");
      for(int i =0 ; i < n ;i++)
        for(int j =0 ; j < m ;j++)
            allocated[i][j] = sc.nextInt();

      // Calculation of need Matrix
      for(int i =0 ; i < n ; i++)
        for(int j =0 ; j < m ; j++)
            need[i][j] = max[i][j] - allocated[i][j] ;

      // safety and resource request algorithm
      for(int c =0 ; c < n ; c++)
      {
          for(int i =0 ; i < n ; i++)
                if(!finished[i])
                {
                    boolean flag = true ;
                    for(int j =0 ; j < m ; j++)
                        if(available[j] < need[i][j] )
                            flag = false ;
                    if(flag)
                    {
                        finished[i] = true ;
                        sequence.add(i+1);
                        for(int j =0 ; j < m ;j++)
                            available[j] += allocated[i][j] ;
                    }
                }
      }
      
      if(sequence.size()==n)
      System.out.println( "Safe Sequence \t" + sequence);
      else System.out.println("Not in safe state ");
  }
}
