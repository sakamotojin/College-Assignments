/*
author : sakamoto_jin
u_know_me_and_u_don't_know_me
*/
import java.util.* ;
import java.io.* ;
@SuppressWarnings("unchecked")
class SJF{
  int jobs ;
  SJF()
  {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the number of processes");
      jobs = sc.nextInt();
      JOB jj[] = new JOB[jobs];
      for(int i =0 ; i < jobs ;i++)
      {
          jj[i] = new JOB() ;
          //jj[i].jobid = sc.nextInt();
          jj[i].atime = sc.nextInt() ;
          jj[i].btime = sc.nextInt() ;
      }
      int jc = 0 ,ctime =0 , mv = 1000 , mi = 0;
      boolean flag = true ;
      while(jc < jobs)
      {
        mv = 1000 ;
          for(int i =0 ; i < jobs ; i++)
          {
              if(jj[i].atime <= ctime && jj[i].btime < mv && jj[i].btime !=  0)
              {
                mv = jj[i].btime ;
                mi = i ;
                flag = false ;
              }
          }
          if(flag)ctime++;
          else{
                ctime++ ;
                jj[mi].btime--;
                if(jj[mi].btime==0)
                {
                    jc++;
                    jj[mi].ctime = ctime ;
                    System.out.println(jj[mi].ctime + " " + mi);
                }
          }
      }

  }

}
