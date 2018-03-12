package test;

public class calcuate {
	static int[] array=new int[10];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=100;i<1000;i++)
		{
			for(int j=100;j<1000;j++)
			{
				if(i*j<100000)
				{
					num(i);
					num(j);
					num(i*j);
					num(i*(j%10));
					num(i*((j/10)%10));
					num(i*(j/100));
					if(sum())
					{
						System.out.println("   "+i);
						System.out.println("   "+j);
						System.out.println("-*----------");
						System.out.println("   "+i*(j%10));
						System.out.println("  "+i*((j/10)%10));
						System.out.println(" "+i*(j/100));
						System.out.println("-*----------");
						System.out.println(" "+i*j);
					}
				}
			}
		}
	}
	public static void num(int a)
	{
		while(a>0)
		{
			array[a%10]+=1;
			a/=10;
		}
	}
	public static Boolean sum()
	{
		for(int i=0;i<array.length;i++)
		{
			if(array[i]!=2)
			{
				for(int j=0;j<array.length;j++)
				{
					array[j]=0;
				}
				return false;
			}
			
		}
		return true;
	}
	
}
