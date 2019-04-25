/*
author : sakamoto_jin
u_know_me_and_u_don't_know_me
*/
import java.util.* ;
@SuppressWarnings("unchecked")
class Main
{
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter The Page Replacement Algorithm You want To Use ");
    System.out.println("1 . LRU ");
    System.out.println("2 . Optimal ");
    int choice = sc.nextInt() ;
    if(choice == 1)
        new LRU() ;
    else  new Optimal() ;
  }
}
