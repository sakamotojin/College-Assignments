import java.io.* ;
import java.util.* ;
public class Dll
{
	 public native int sum(int a , int b);
	 public native int dif(int a , int b);
	 public native int div(int a , int b);
	 public native int mul(int a , int b);
	public static void main(String args[])
	{
	    System.loadLibrary("dll");
	    Dll D = new Dll() ;
	    System.out.println("MY DLL Caluculator \n 1 SUM \n 2 MUL \n 3 DIV \n 4 SUB");
	    Scanner sc = new Scanner(System.in);
	    int c = sc.nextInt();
	    int a = sc.nextInt();
	    int b = sc.nextInt();
	    if(a==1)System.out.println(D.sum(a,b));
	    if(a==2)System.out.println(D.dif(a,b));
	    if(a==3)System.out.println(D.div(a,b));
	    if(a==4)System.out.println(D.mul(a,b));
	}
}
