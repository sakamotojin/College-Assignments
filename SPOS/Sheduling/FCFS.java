/*
author : sakamoto_jin
u_know_me_and_u_don't_know_me
*/
import java.util.*;
@SuppressWarnings("unchecked")
class FCFS
{
  int n ;
  Vector<JOB> jobs = new Vector();
  FCFS()
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the total no of jobs ");
    n = sc.nextInt();
    System.out.println("Enter the jobs - Job Id , Atime , Bursttime");
    for(int i =0 ; i < n ;i++)
      {
          JOB temp = new JOB() ;
          temp.jobid = sc.nextInt() ;
          temp.atime = sc.nextInt() ;
          temp.btime = sc.nextInt() ;
          jobs.add(temp);
      }
    Collections.sort(jobs , new SortAT());
    int beg = jobs.get(0).atime ;
    for(int i =0 ; i < n ; i++)
    {
      JOB temp = jobs.get(i);
      temp.ctime = beg + temp.btime ;
      temp.wtime = beg -  temp.atime ;
      temp.ttime = temp.ctime - temp.atime;
      temp.print();
      beg = temp.ctime + 1 ;
    }
  }

}
