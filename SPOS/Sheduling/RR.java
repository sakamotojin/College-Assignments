/*
author : sakamoto_jin
u_know_me_and_u_don't_know_me
*/
import java.util.* ;
import java.io.*;
@SuppressWarnings("unchecked")
class RR
{
  Vector<Integer> temp = new Vector<>();
  RR()
    {
      int job , qua ;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of jobs and time quanta");
    job = sc.nextInt();
    qua = sc.nextInt() ;
      JOB in [] = new JOB[job];
    System.out.println("Enter the job id , arival time ,  burst time for each job");
    for(int i =0 ; i < job ; i++)
    {
      in[i] = new JOB();
      in[i].jobid = sc.nextInt();
      in[i].atime = sc.nextInt();
      in[i].btime = sc.nextInt();
    }
    Arrays.sort(in , new SortAT());
    int jc = 0 ,ctime = 0 ,j=-1 ;
    while(jc < job)
    {
      for(int i =0 ; i < job ; i++)
      {
        if(ctime < in[i].atime ) break ;
        else
         {
           if(in[i].btime>0 && !temp.contains(new Integer(i)) && i!= j)
            {
              temp.add(new Integer(i));
            }
        }
      }
      if(j!=-1)if(in[j].btime > 0 ){
        temp.add(new Integer(j));
      }
      System.out.println(temp);
      if(temp.size()!=0)
      {
       j = temp.get(0);
      System.out.print(j+ " ");
      ctime += Math.min(qua,in[j].btime);
      in[j].btime = Math.max(0 ,in[j].btime-qua);
      if(in[j].btime==0)jc++;
      temp.remove(0);
    	}
    	else ctime++;
  }
}
}
