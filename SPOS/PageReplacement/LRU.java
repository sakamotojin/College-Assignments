/*
author : sakamoto_jin
u_know_me_and_u_don't_know_me
*/
import java.util.* ;
@SuppressWarnings("unchecked")
public class LRU
{
  int n , m ;
  int pages[] = new int [100] ;
  Vector<Integer> frame = new Vector() ;
  int pagefaults = 0 ;
  LRU()
  {
    Scanner sc = new Scanner(System.in) ;
    System.out.println("Enter The number Of Pages  and Frame Size ");
    n = sc.nextInt() ;
    m = sc.nextInt() ;
    System.out.println("Enter the pages with spaces ") ;
    for(int i =0 ; i < n ; i++)
        pages[i] = sc.nextInt() ;

    // LRU cache implementation
    for(int i =0 ; i < n ;i++)
    {
      if(frame.size()< m && !frame.contains(new Integer(pages[i])))
      {
        frame.add(pages[i]);
        pagefaults++ ;
      }
      else
      {
          if(!frame.contains(new Integer(pages[i])))
            {
              pagefaults++ ;
              frame.remove(0);
            }
          else frame.remove(new Integer(pages[i]));
          frame.add(new Integer(pages[i]));
      }
      System.out.println(frame);
    }
    System.out.println("Total No Of Page Faults  = " + pagefaults);
  }
}
