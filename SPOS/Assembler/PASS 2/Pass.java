/*
author : sakamoto_jin
u_know_me_and_u_don't_know_me
*/
import java.util.* ;
import java.io.* ;
@SuppressWarnings("unchecked")
class Pass
{
  public static void main(String args[])
  {
    try{

       HashMap<String , String> val= new HashMap();
       BufferedReader in = new BufferedReader(new FileReader("input.txt"));
       BufferedReader lit = new BufferedReader(new FileReader("lit.txt"));
       BufferedReader sym = new BufferedReader(new FileReader("sym.txt"));
        PrintWriter pr = new PrintWriter(new FileWriter("mach.txt"));
    String line ;
    int i =0 ;
      while((line = lit.readLine())!=null)
      {
        String part[]= line.split(" ");
        val.put(new String("L").concat(new Integer(i).toString()),part[1]);
        i++;
      }
      i =0 ;
      while((line = sym.readLine())!=null)
        {
          String part[]= line.split(" ");
          val.put(new String("S").concat(new Integer(i).toString()),part[1]);
          i++;
        }
        //for(Map.Entry m : val.entrySet())
      //  System.out.println(m.getKey() + " "+ m.getValue());
      //  System.out.println(val.get(new String("L1")));
        int lc = 0 ;
        line = in.readLine();
        String par [] = line.split("[()]|[,]|[)]");
        lc = Integer.parseInt(par[5]);
        while((line=in.readLine())!=null)
        {
          String par1 [] = line.split("[()]|[,]|[)]");
          if(par1[1].equals("DL"))
          {  if(par1[2].equals("01"))
              { pr.println(lc);
                lc += Integer.parseInt(par1[5]);
              }
              if(par1[2].equals("02"))
              {
                System.out.println(lc + " 00 00 0" + par1[5]);
                lc++;
              }
          }
          if(par1[1].equals("AD"))
          {
            if(par1[2].equals("02")) continue ;
            if(par1[3].equals("03")) lc = Integer.parseInt(par1[5]);
          }
          if(par1[1].equals("IS"))
          {
            if(par1.length > 6)
            {
            System.out.println(lc + " "  + par1[2] + " " + par1[5] + " " + val.get(new String(par1[7]).concat(par1[8])));
            }
            else if(par1.length > 4)
            {
            System.out.println(lc + " "+ par1[2] + " 00 " + val.get(new String(par1[4]).concat(par1[5])));
            }
            else System.out.println(lc + " 00 00 000");
            lc++;
          }

        }
      }catch(Exception e)
      {
        System.out.println(e);
      }
  }
}
