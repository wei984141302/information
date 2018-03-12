package mathgroup;

import java.util.Scanner;

public class result {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		 Media name=new Media();
		 Media number=new Media();
	        while (true) {
	            Scanner input = new Scanner(System.in);
	            System.out.println("选择操作");
	            System.out.println("########################");
	            System.out.println("a 添加信息");
	            System.out.println("b 删除信息");
	            System.out.println("c 修改信息");
	            System.out.println("d 查看信息");
	            System.out.println("########################");
	            String opertype = input.next();
	            if (opertype.equals("a")) {
	                System.out.println("输入name:");
	                name.addstring(input.next());
	                System.out.println("输入number");
	                number.addstring(input.next());
	            } else if (opertype.equals("b")) {
	                System.out.println("输入要删除的number");
	                String number1 = input.next();
	                for(int i=0;i<number.size();i++)
	                {
	                	if(number.remove(number1))
	                	{
	                		name.removestring(i);
	                	}
	                	break;
	                }
	            } else if (opertype.equals("c")) {
	                System.out.println("输入要修改的number");
	                String number2 = input.next();
	                for(int i=0;i<number.size();i++)
	                	{
	                	   if(number.elementAt(i).equals(number2))
	                	   {
	                	   System.out.println("重新录入信息，请输入name");
	                       name.modistring(input.next(), i);
	                	   System.out.println("重新录入信息，请输入number");
	                	   number.modistring(input.next(), i);
	                	   }
	                	   break;
	                	}             
	            } else if (opertype.equals("d")) {
	            	System.out.println("输出结果:");
	                for(int i=0;i<number.size();i++)
	                {
	                	System.out.println("编号:"+number.elementAt(i));
	                	System.out.println("名字:"+name.elementAt(i));	                	
	                }
	            }

	        }
	    }

}
