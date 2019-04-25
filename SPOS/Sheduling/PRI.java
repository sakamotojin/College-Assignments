/*
author : sakamoto_jin
u_know_me_and_u_don't_know_me
*/
import java.util.*;
@SuppressWarnings("unchecked")
class PRI
{
  int n ;
  Vector<JOB> jobs = new Vector();
  PRI()
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the total no of jobs ");
    n = sc.nextInt();
    System.out.println("Enter the jobs - Job Id ,  Prio  Bursttime");
    for(int i =0 ; i < n ;i++)
    {
        JOB temp = new JOB() ;
        temp.jobid = sc.nextInt() ;
        temp.prio  = sc.nextInt() ;
        temp.btime = sc.nextInt() ;
        jobs.add(temp);
    }
    Collections.sort(jobs , new SortP());
    //jobs.sort(Comparator.compareInt(JOB::prio));
    int beg = jobs.get(0).atime ;
    for(int i =0 ; i < n ; i++)
    {
        JOB temp = jobs.get(i) ;
        temp.ctime = beg + temp.btime;
        temp.wtime = beg- temp.atime  ;
        temp.ttime = temp.ctime - temp.atime ;
        beg = temp.ctime +1 ;
        temp.print() ;
    }
  }
}
