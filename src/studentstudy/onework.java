package studentstudy;
import java.util.Scanner;
public class onework {

	
	private static Scanner scanner;
	public static void main(String[] args) {
		System.out.print("«Î ‰»Î÷µ:");
		scanner = new Scanner(System.in);
		int i=Integer.parseInt(scanner.next());
		for(int x=1;x<=(i+1)/2;x++)
		{
			printBlack(x);
			printstar(i-2*(x-1));
			printBlack(x-1);
			System.out.println();
			
		}
		for(int x=(i+1)/2-1;x>0;x--)
		{
			printBlack(x);
			printstar(i-2*(x-1));
			printBlack(x-1);
			System.out.println();
			
		}

	}
	public static void printstar(int i)
	{
		for(int m=0;m<i;m++)
		{
	     System.out.print("* ");
	     
		}
		System.out.println();
	}
	public static void printBlack(int i)
	{
		for(int n=0;n<i;n++)
		{
	      System.out.print(" ");
		}
	}

}
