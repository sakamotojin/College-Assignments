import java.util.*;
import java.io.*;

public class pass1chota 
{
static String out = "";
static String pooltable ="0 \n";
    public static void main(String args[]) throws Exception
    {
    HashMap <String,String> mot = new HashMap<>();

    String[] symbol = new String[10]; //for symbol and literal
    String[] literal = new String[10];
    for(int i=0;i<10;i++)
    {
        symbol[i]="";
        literal[i]="";
    }
    int[] symadd= new int[10];
    int[] litadd= new int[10];
    int lit=0,sym=0;

    mot.put("START","(AD,01)");
    mot.put("END","(AD,02)");
    mot.put("LTORG","(AD,03)");
    mot.put("ORIGIN","(AD,04)");
    mot.put("EQU","(AD,05)");
    mot.put("USING","(AD,06)");
    mot.put("COMP","(AD,07)");

    mot.put("STOP","(IS,00)");
    mot.put("ADD","(IS,01)");
    mot.put("SUB","(IS,02)");
    mot.put("MULT","(IS,03)");
    mot.put("MOVER","(IS,06)");
    mot.put("MOVEM","(IS,05)");
    mot.put("DIV","(IS,06)");
    mot.put("PRINT","(IS,07)");
    
    mot.put("AREG","(RG,01)");
    mot.put("BREG","(RG,02)");
    mot.put("CREG","(RG,03)");
    mot.put("DREG","(RG,04)");
    
    mot.put("DS","(DL,01)");
    mot.put("DC","(DL,02)");

    FileReader fr = new FileReader("asse.txt");
    BufferedReader br = new BufferedReader(fr);

    FileWriter fw = new FileWriter("output.txt");
    BufferedWriter bw = new BufferedWriter(fw);
    String pass = "";
    int lc = 0;                   //location counter    

    while((pass = br.readLine())!=null) //reading asse.txt line by line
        {
            String assem[] = pass.split(" ");     // slpiting the read line with the space between them    
            int i = -1;
            if(assem[1].equals("LTORG") || assem[1].equals("END"))
            out+=""; 
            else if(assem[1].equals("START"))
            out+=" ";   
            else 
            out += "\n"+lc+" ";
    
            while(++i<assem.length)
            {
                if(i == 0) //for first symbol
                {
                    if(!assem[i].equals("-"))  //for label			
                    { 
                        String present="nahihai";
                        for(int m=0;m<10;m++)
                        {
                            if(symbol[m].equals(assem[i]))
                             {   
                                 present ="hai";
                                 break; 
                            }                                      
                        }
                        if(present.equals("nahihai"))
                        {    symbol[sym]=assem[i];
                             symadd[sym++]=lc;
                        }
                    }
                }
                else if(mot.containsKey(assem[i]))         // for IS , REG , DL ,AD
                {
                    String clas = mot.get(assem[i]);

                   if(assem[i].equals("START") || assem[i].equals("ORIGIN")) //for start and origin
                    { 
                        out += clas +" ";
                        lc = Integer.valueOf(assem[i+1]);
                        lc-=1;             //decremented to nullify the effect of lc++ done at the end                      
                    }
                    else if(assem[i].equals("LTORG") || assem[i].equals("END"))
                    {
                        int po=0,cnt=0;
                        for(po=0;po<lit;po++)
                        {
                            if(litadd[po]==0)
                            {
                                cnt++;
                                out += "\n";
                                out += lc+" (DL,02) (L,"+literal[po]+") ";
                                litadd[po] = lc++; 
                            }
                        }
                        if(assem[i].equals("LTORG"))
                         pooltable += cnt+"\n";
                        lc-=1;
                    }
                    else if(assem[i].equals("EQU"))
                    {
                        out += clas + " ";
                        for(int mp=0;mp<sym;mp++)
                        {
                            if(symbol[mp].equals(assem[i-1]))
                            {
                                symadd[mp] = Integer.parseInt(assem[i+1]);
                                break;
                            }
                        }
                     }
                    else 
                    {
                        out += clas + " " ;
                        if(assem[i].equals("DS") || assem[i].equals("DC"))
                        {
                            for(int mp=0;mp<sym;mp++)           //for adding address of the symbol
                            {
                                if(symbol[mp].equals(assem[i-1]))
                                {
                                    symadd[mp] = lc;
                                    break;
                                }
                            }
                            if(assem[i].equals("DS"))
                            lc += Integer.valueOf(assem[i+1])-1;
                        }
                    }


                }
                else if (assem[i].charAt(0) == '\'')                //it is literal 
                { 
                        out += "(L," + assem[i] + ") ";
                        String literal_present="nahihai";
                        for(int m=0;m<10;m++)
                        {
                            if(literal[m].equals(assem[i]))
                               literal_present ="hai";                                    
                        }
                        if(literal_present.equals("nahihai"))
                            literal[lit++]=assem[i];
                        
                }

                else                    //it is a symbol
                { 
                        if(assem[i].charAt(0)>= '0' && assem[i].charAt(0)<= '9') // if its a constant
                        {
                            out += "(C," + assem[i] + ") ";
                        }
                        else    //for all other cases 
                        {
                            String present="nahihai";
                            out += "(S," + assem[i] + ") ";
                            for(int m=0;m<10;m++)
                            {
                                if(symbol[m].equals(assem[i]))
                                 {   
                                     present ="hai";
                                     break; 
                                }                                      
                            }
                            if(present.equals("nahihai"))
                                symbol[sym++]=assem[i];
                        }
                }

            }         // end of inner while
            lc++;
        }             // end of outer while
        System.out.print(out);
        bw.write(out);
        bw.close();

        FileWriter fg = new FileWriter("Symbol.txt");      //for writing in Symbol.txt
        BufferedWriter bg = new BufferedWriter(fg);
        FileWriter fna = new FileWriter("Literal.txt");    //for writing in Literal.txt
        BufferedWriter bna = new BufferedWriter(fna);
        FileWriter pool = new FileWriter("Pooltable.txt");  //for writing in pooltable.txt
        BufferedWriter poolta = new BufferedWriter(pool);
        poolta.write(pooltable);
        bg.write("Symbol\tAddress\n");
        bna.write("Literal\tAddress\n");
        for(int asd =0 ;asd<sym;asd++)
                bg.write(symbol[asd]+"\t"+Integer.toString(symadd[asd])+"\n");
        
        for(int msd=0;msd<lit;msd++)
                bna.write(literal[msd]+"\t"+Integer.toString(litadd[msd])+"\n");
        bg.close();
        bna.close();
		poolta.close();
    }              // end of main 
}                 // end of class pass1
