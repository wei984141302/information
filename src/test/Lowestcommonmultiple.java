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
	     }//ѭ��������Լ��K
	      System.out.println("m,n�����������Լ��Ϊ��"+k);
	      System.out.println("m,n����������С������Ϊ��"+m*n/k);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    /*  int m,n,j,k,a;
      Scanner scanner=new Scanner(System.in);
      System.out.println("������m��ֵ:");
      m=scanner.nextInt();
      System.out.println("������n��ֵ:");
      n=scanner.nextInt();
      
      j=m;
      k=n;
      a=m%n;
      while(a!=0)
      {
    	  j=k;
    	  k=a;
    	  a=j%k;
      }//ѭ��������Լ��K
      System.out.println("m,n�����������Լ��Ϊ��"+k);
      System.out.println("m,n����������С������Ϊ��"+m*n/k);
	}*/
		flagnumber(147,15);
		int i=100,j;
		j=--i;
		System.out.println(i+"   "+j);
	}
}
