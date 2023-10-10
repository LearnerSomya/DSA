/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
	    Scanner scn=new Scanner(System.in);
	    int n=scn.nextInt();
	    for(int i=n;i>=1;i--)
	    {
	        for(int j=1;j<=i;j++)
	        {
	            System.out.print("*\t");
	        }
	        System.out.println();
	    }
	}
}
