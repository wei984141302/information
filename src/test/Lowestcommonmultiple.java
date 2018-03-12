package test;

import java.util.Scanner;

public class Lowestcommonmultiple {

	/**
	 * @param args
	 */
	public static void flagnumber(int m,int n)
	{
		int j,k,a;
		j=m;
	    k=n;
	    a=j%k;
	    while(a!=0)
	    {
	      j=k;
	      k=a;
	      a=j%k;
	     }//循环求出最大公约数K
	      System.out.println("m,n两个数的最大公约数为："+k);
	      System.out.println("m,n两个数的最小公倍数为："+m*n/k);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    /*  int m,n,j,k,a;
      Scanner scanner=new Scanner(System.in);
      System.out.println("请输入m的值:");
      m=scanner.nextInt();
      System.out.println("请输入n的值:");
      n=scanner.nextInt();
      
      j=m;
      k=n;
      a=m%n;
      while(a!=0)
      {
    	  j=k;
    	  k=a;
    	  a=j%k;
      }//循环求出最大公约数K
      System.out.println("m,n两个数的最大公约数为："+k);
      System.out.println("m,n两个数的最小公倍数为："+m*n/k);
	}*/
		flagnumber(147,15);
		int i=100,j;
		j=--i;
		System.out.println(i+"   "+j);
	}
}
