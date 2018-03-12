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
	  	
	// 第一步：加载驱动（驱动jar包必须加入classpath中）
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	// 第二步：建立连接（根据实际情况替换数据库的主机地址、端口号、数据库明、登录名、密码）
	//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "root");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	System.out.println("当前连接到的数据库=" + conn.getCatalog());// 查看当前连接到的数据库名
	// 第三步：创建Statement对象
	Statement stmt = conn.createStatement();// 只读的结果集
	// 第四步：执行操作（增删改查）
	ResultSet rs1 = stmt.executeQuery("select * from taxtable");
	//MysqlDB pi = new MysqlDB();
	// 处理结果
	/*while (rs1.next()) {
	System.out.println("startPoint: " + rs1.getInt(1) + "    endPoint: "
	 + rs1.getInt("endPoint")+ "    rate: "+ rs1.getInt(3)+ "    rate: "+ rs1.getInt(4));
	}*/
	double salary,start=3500.0;
	System.out.println("输入工资:");  
	Scanner salary1 = new Scanner(System.in);  
	salary=salary1.nextDouble();
	double taxableincome=(salary-start);
	float tax;
	while(rs1.next())
	{
		
		if(taxableincome>=rs1.getInt(1)&&taxableincome<=rs1.getInt(2))
		{
			System.out.println("查到应纳税所得额 所在范围:");
			System.out.println(rs1.getString(1)+"  "+rs1.getString(2)+"  "+rs1.getString(3)+"  "+rs1.getString(4));
			tax=(float)((taxableincome*rs1.getInt(3))/100-rs1.getInt(4));
			System.out.println("应交税收:");
			System.out.println(tax);
			break;
		}
	}	
 }
}
	// 第五步：关闭连接
/*	try {
		List<PersonIncomeTab> pitList = pi.getPersonIncomeTab(rs1);

		for (PersonIncomeTab pit : pitList)
		{
		 System.out.println(pit.getStartPoint() + " "+ pit.getEndPoint() + " " + pit.getRate() + " "+ pit.getDeduction());	
		}
		System.out.println("输入工资:");  
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
					System.out.println("查到应纳税所得额 所在范围:");
					System.out.println(pit.getStartPoint()+"  "+pit.getEndPoint()+"  "+pit.getRate()+"  "+pit.getDeduction());
					tax=(float)((taxableincome*pit.getRate())/100-pit.getDeduction());
					System.out.println("应交税收:");
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



 
 
 
 