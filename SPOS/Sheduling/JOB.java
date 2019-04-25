/*
author : sakamoto_jin
u_know_me_and_u_don't_know_me
*/
import java.util.*;
@SuppressWarnings("unchecked")
class JOB
{
  int jobid ;
  int atime ;
  int btime;
  int prio;
  int wtime;
  int ttime;
  int ctime;
  JOB()
  {
    jobid = atime = btime = prio = wtime = ttime = ctime = 0;
  }
  void prinh()
  {
    System.out.print("J");
  }
  void print()
  {
    System.out.println();
    System.out.print(jobid + " " + atime + " " + btime + " " );
    System.out.println(prio + " " + wtime + " " + ttime + " " + ctime);
  }
}
class SortAT implements Comparator <JOB>
{
  @Override
  public int compare(JOB J1 , JOB J2)
  {
    return (J1.atime - J2.atime );
  }
}
class SortP implements Comparator <JOB>
{
  @Override
  public int compare(JOB J1 , JOB J2)
  {
    return (J1.prio - J2.prio );
  }
}
