package testtwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Insertstring {
	public  String s = new String();    
	
    public void gettext() {   
	   try 
	   {       //从电脑文件夹读入‘中文词库’文件     
		 BufferedReader input = new BufferedReader(new FileReader("download.jsp"));    
		 s = input.readLine();   
		 input.close();  
		} 
		 catch (Exception e) 
		 {   
		   System.out.println("Read Fail"); 
		 }
	}
	  
	 //将词库放入ArrayList，按词语长度放置，通常词语最长为4，最为1  
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
