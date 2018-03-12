package testtwo;

import java.util.ArrayList;
import java.util.Scanner;

public class StringAnalysis {

	 public static String sentences;
	 public ArrayList words = new ArrayList();  
	 public void get()
	{  System.out.println("Please input the sentence");  // 读入语句，读取要分析的句子 
	   Scanner scanner = new Scanner(System.in);    
	   sentences = scanner.nextLine();
	}
	 public String compare(String string, ArrayList<String> list, int n) {  
	 String stemp;   
	 String strre;  
	 String strresult;     //将句子与ArrayList对比，匹配的add进另一个ArrayList  
	 for (int i = 0; i < string.length() - n + 1; i++) 
	 {   
	  stemp = string.substring(i, i + n);   
	  if (list.contains(stemp))     
	  words.add(stemp);  
	 }  
	 strre = words.toString();             //删去已经匹配的词语   
	 strre = strre.replace(" ", "");   
	 strre = strre.replace(",", "|");   
	 strre = strre.substring(1, strre.length() - 1);     
	 strresult = string.replaceAll(strre, "");   
	 return strresult;  
	 }  
}
