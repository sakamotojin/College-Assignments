/*
author : sakamoto_jin
u_know_me_and_u_don't_know_me
*/
import java.util.* ;
@SuppressWarnings("unchecked")
public class Optimal
{
  int n , m ;
  int pages[] = new int [100] ;
  Vector<Integer> frame = new Vector() ;
  int pagefaults = 0 ;
  boolean ispage[] = new boolean [100] ;
  Optimal()
  {
    Scanner sc = new Scanner(System.in) ;
    System.out.println("Enter The number Of Pages  and Frame Size ");
    n = sc.nextInt() ;
    m = sc.nextInt() ;

    System.out.println("Enter the pages with spaces ") ;
    for(int i =0 ; i < n ; i++)
        pages[i] = sc.nextInt() ;

      // Optimal Page Replacement Algorithm
    for(int i =0 ; i < n ; i++)
      {
          if(frame.size() < m && !frame.contains(new Integer(pages[i])))
          {
            pagefaults++ ;
            frame.add(pages[i]) ;
            ispage[pages[i]] = true ;
          }
          else
          {
              if(ispage[pages[i]]) {  }
              else
              {
                pagefaults++ ;
                int door =0 , page = 0  ,temp ;
                  for(int j =0 ; j < m ;j++)
                  {
                      temp = FindIndex(frame.get(j) ,i , n) ;
                      if(temp > door)
                      {
                        door = temp ;
                        page = frame.get(j) ;
                      }
                  }
                  frame.add(pages[i]);
                  ispage[pages[i]] = true ;
                  ispage[page] = false ;
                  frame.remove(new Integer(page));
              }
          }
          System.out.println(frame);
      }
      System.out.println("Page Faults = " + pagefaults) ;
  }
  int FindIndex(int page , int l , int r)
  {
      for(int i=l ; i < r ; i++)
          if(pages[i]==page) return i ;
          return r ;
  }
}
// get(index) in vector , annotation above the program
