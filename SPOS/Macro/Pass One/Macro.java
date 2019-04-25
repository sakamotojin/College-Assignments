/*
author : sakamoto_jin
u_know_me_and_u_don't_know_me
*/
import java.util.* ;
import java.io.*;
@SuppressWarnings("unchecked")
class Macro
{
  static BufferedReader input ;
  static PrintWriter mnt ,mdt ,ala;
  static HashMap<String , Integer> mname = new HashMap<>();
    public static void main(String[] args) {
      try{
      input =  new BufferedReader(new FileReader("input.asm"));
      mnt   =  new PrintWriter (new FileWriter("mnt.txt"));
      mdt   =  new PrintWriter(new FileWriter("mdt.txt"));
      ala   =  new PrintWriter(new FileWriter("ala.txt"));
      String line ;
      int i =0 ;
      while((line=input.readLine())!=null)
      {
          if(line.equals("MACRO"))
          {
            boolean flag = true ;
            while(!line.equals("MEND"))
            {
              line = input.readLine();
              mdt.println(line);
              if(flag)
              {
                String fline[] = line.split(" |,");
                mnt.println(fline[0] + " " + i);
                mname.put(fline[0] , new Integer(fline.length-1));
              }
              i++;
              flag = false ;
            }
          }
      }
      for(Map.Entry m : mname.entrySet())
        System.out.println(m.getKey() + " "+ m.getValue());
      mnt.close();
      mdt.close();
    }
    catch (Exception e)
    {
      System.out.print(e);
    }
    }
}
