package testtwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Insertstring {
	public  String s = new String();    
	
    public void gettext() {   
	   try 
	   {       //�ӵ����ļ��ж��롮���Ĵʿ⡯�ļ�     
		 BufferedReader input = new BufferedReader(new FileReader("download.jsp"));    
		 s = input.readLine();   
		 input.close();  
		} 
		 catch (Exception e) 
		 {   
		   System.out.println("Read Fail"); 
		 }
	}
	  
	 //���ʿ����ArrayList�������ﳤ�ȷ��ã�ͨ�������Ϊ4����Ϊ1  
	 public ArrayList split(String str, int l) {   
		 
	  String[] strarray = str.split(" ");  
	  ArrayList words = new ArrayList();   
	  for (int i = 0; i < strarray.length; i++)
	  {   
		if (strarray[i].length() == l)       
	    words.add(strarray[i]);  
	  }    
	 return words; }

}
