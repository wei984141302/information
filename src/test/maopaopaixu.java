package test;

public class maopaopaixu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int [] values={2,53,15,65,72,89,8,87,54,54};
      sort(values);
      for(int i=0; i < values.length;i++)
            System.out.println("Index: " + i +" "+ "Value: " + values[i]);
	}
   public static void sort(int [] value)
   {
	  int i,j,t;
		for(i=0;i<value.length;i++)
		{
			for(j=0;j<value.length-i-1;j++)
			   if(value[j]>value[j+1])
			   {
				t=value[j];
				value[j]=value[j+1];
				value[j+1]=t;
			   }
		} 
   }
}
