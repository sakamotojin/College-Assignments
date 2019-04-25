/*
author : sakamoto_jin
u_know_me_and_u_don't_know_me
*/
import java.io.*;
import java.util.* ;
@SupressWarnings("unchecked")
class Macro
{
  static BufferedReader mnt , mdt , ala ,input;
  static  PrintWriter output ;
  public static void main(String ars[])
  {
    mnt = new BufferedReader(new FileReader("mnt.txt"));
    mdt = new BufferedReader(new FileReader("mdt.txt"));
    ala = new BufferedReader(new FileReader("ala.txt"));
    input = new BufferedReader(new FileReader("input.asm"));
    output = new PrintWriter(new FileWriter("output.txt"));

  }
}
