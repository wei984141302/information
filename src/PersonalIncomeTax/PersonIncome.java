package PersonalIncomeTax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.File;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class PersonIncome {
	

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
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PersonIncome pi = new PersonIncome();
		try {
			List<PersonIncomeTab> pitList = pi.getPersonIncomeTab("PersonalIncomeTax.xls");

			for (PersonIncomeTab pit : pitList)
			{
			 System.out.println(pit.getStartPoint() + " "+ pit.getEndPoint() + " " + pit.getRate() + " "+ pit.getDeduction());	
			}
			float tax = pi.getPersonIncomeTax(10000.8,3500.0,pitList);
			System.out.println("#################################");
			float[] randomtax=new float[10];
			for(int i=0;i<10;i++)
			{
				double salary=(Math.random()*7000+3000);
				System.out.println("工资");
				System.out.println(salary);
				randomtax[i]=pi.getPersonIncomeTax(salary,3500.0,pitList);	
				System.out.println("实际工资:");
				System.out.println(salary-randomtax[i]);
			}
			

		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<PersonIncomeTab> getPersonIncomeTab(String xlsFile)
			throws BiffException, IOException {

		InputStream is = new FileInputStream(xlsFile);
		Workbook wb = Workbook.getWorkbook(is);

		Sheet st = wb.getSheet(0);

		int row = st.getRows();
		int column = st.getColumns();
		

		System.out.println("row:" + row + "    column:" + column);

		ArrayList<PersonIncomeTab> pitList = new ArrayList<PersonIncomeTab>();

		for (int i = 1; i < row; i++) {
			PersonIncomeTab pit = new PersonIncomeTab();

			for (int j = 1; j < column; j++) {
				Cell cell = st.getCell(j, i);

				switch (j) {
				case 1:
					pit.setEndPoint(Integer.parseInt(cell.getContents()));
					break;
				case 2:
					pit.setEndPoint(Integer.parseInt(cell.getContents()));
					break;
				case 3:
					pit.setRate(Integer.parseInt(cell.getContents()));
					break;
				case 4:
					pit.setDeduction(Integer.parseInt(cell.getContents()));
					break;
				}				
			}
			pitList.add(pit);
		}

		return pitList;
	}
}
