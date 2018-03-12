package sql;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import PersonalIncomeTax.PersonIncomeTab;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class MysqlDB {
 public static void main(String[] args) throws Exception {
	  	
	// ��һ������������������jar���������classpath�У�
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	// �ڶ������������ӣ�����ʵ������滻���ݿ��������ַ���˿ںš����ݿ�������¼�������룩
	//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "root");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	System.out.println("��ǰ���ӵ������ݿ�=" + conn.getCatalog());// �鿴��ǰ���ӵ������ݿ���
	// ������������Statement����
	Statement stmt = conn.createStatement();// ֻ���Ľ����
	// ���Ĳ���ִ�в�������ɾ�Ĳ飩
	ResultSet rs1 = stmt.executeQuery("select * from taxtable");
	//MysqlDB pi = new MysqlDB();
	// ������
	/*while (rs1.next()) {
	System.out.println("startPoint: " + rs1.getInt(1) + "    endPoint: "
	 + rs1.getInt("endPoint")+ "    rate: "+ rs1.getInt(3)+ "    rate: "+ rs1.getInt(4));
	}*/
	double salary,start=3500.0;
	System.out.println("���빤��:");  
	Scanner salary1 = new Scanner(System.in);  
	salary=salary1.nextDouble();
	double taxableincome=(salary-start);
	float tax;
	while(rs1.next())
	{
		
		if(taxableincome>=rs1.getInt(1)&&taxableincome<=rs1.getInt(2))
		{
			System.out.println("�鵽Ӧ��˰���ö� ���ڷ�Χ:");
			System.out.println(rs1.getString(1)+"  "+rs1.getString(2)+"  "+rs1.getString(3)+"  "+rs1.getString(4));
			tax=(float)((taxableincome*rs1.getInt(3))/100-rs1.getInt(4));
			System.out.println("Ӧ��˰��:");
			System.out.println(tax);
			break;
		}
	}	
 }
}
	// ���岽���ر�����
/*	try {
		List<PersonIncomeTab> pitList = pi.getPersonIncomeTab(rs1);

		for (PersonIncomeTab pit : pitList)
		{
		 System.out.println(pit.getStartPoint() + " "+ pit.getEndPoint() + " " + pit.getRate() + " "+ pit.getDeduction());	
		}
		System.out.println("���빤��:");  
		Scanner salary1 = new Scanner(System.in);  
		float tax = pi.getPersonIncomeTax(salary1.nextDouble(),3500.0,pitList);
		

	} catch (BiffException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	} 	 	
 public float getPersonIncomeTax(double salary,double start,List<PersonIncomeTab> pitList){
		float tax = 0;
			double taxableincome=(salary-start);
			for(PersonIncomeTab pit:pitList)
			{
				
				if(taxableincome>=pit.getStartPoint()&&taxableincome<=pit.getEndPoint())
				{
					System.out.println("�鵽Ӧ��˰���ö� ���ڷ�Χ:");
					System.out.println(pit.getStartPoint()+"  "+pit.getEndPoint()+"  "+pit.getRate()+"  "+pit.getDeduction());
					tax=(float)((taxableincome*pit.getRate())/100-pit.getDeduction());
					System.out.println("Ӧ��˰��:");
					System.out.println(tax);
					break;
				}
			}	
			return tax;
			
		}
public ArrayList<PersonIncomeTab> getPersonIncomeTab(ResultSet rs)
		throws BiffException, IOException, SQLException {

	    ArrayList<PersonIncomeTab> pitList = new ArrayList<PersonIncomeTab>();

		
		while(rs.next())
		{
			PersonIncomeTab pit = new PersonIncomeTab();
			pit.setStartPoint(rs.getInt("startPoint"));
			
			pit.setEndPoint(rs.getInt(2));
			pit.setRate(rs.getInt(3));
			pit.setDeduction(rs.getInt(4));
			pitList.add(pit);	
		}		

	return pitList;
}
}*/



 
 
 
 