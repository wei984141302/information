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
	            System.out.println("ѡ�����");
	            System.out.println("########################");
	            System.out.println("a �����Ϣ");
	            System.out.println("b ɾ����Ϣ");
	            System.out.println("c �޸���Ϣ");
	            System.out.println("d �鿴��Ϣ");
	            System.out.println("########################");
	            String opertype = input.next();
	            if (opertype.equals("a")) {
	                System.out.println("����name:");
	                name.addstring(input.next());
	                System.out.println("����number");
	                number.addstring(input.next());
	            } else if (opertype.equals("b")) {
	                System.out.println("����Ҫɾ����number");
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
	                System.out.println("����Ҫ�޸ĵ�number");
	                String number2 = input.next();
	                for(int i=0;i<number.size();i++)
	                	{
	                	   if(number.elementAt(i).equals(number2))
	                	   {
	                	   System.out.println("����¼����Ϣ��������name");
	                       name.modistring(input.next(), i);
	                	   System.out.println("����¼����Ϣ��������number");
	                	   number.modistring(input.next(), i);
	                	   }
	                	   break;
	                	}             
	            } else if (opertype.equals("d")) {
	            	System.out.println("������:");
	                for(int i=0;i<number.size();i++)
	                {
	                	System.out.println("���:"+number.elementAt(i));
	                	System.out.println("����:"+name.elementAt(i));	                	
	                }
	            }

	        }
	    }

}
