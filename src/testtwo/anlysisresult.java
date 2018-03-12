package testtwo;

import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

public class anlysisresult {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 StringAnalysis sa = new StringAnalysis();  
		  Insertstring is = new Insertstring();   
		  is.gettext();    
		  sa.get();   
		  String sretain; 
		  sretain = sa.sentences;  //将词库放入ArrayList，按词语长度放置，通常词语最长为4，最短长度为1  
		  for (int i = 4; i > 0; i--)        
		  sretain = sa.compare(sretain, is.split(is.s, i), i);  
		     //新建一个TreeMap，为了可以使匹配了的分词重新按原先的顺序排列  
		   TreeMap resultword = new TreeMap();   
		   java.util.Iterator it = sa.words.iterator(); 
		   while (it.hasNext())
		   {  
		    String s = (String) it.next();   
		    resultword.put(sa.sentences.indexOf(s), s);  //将匹配了的ArrayList放入TreeMap     
		    }  
		  //输出TreeMap的values，即分拆好的句子 
		   System.out.println("output result words:");
		   System.out.println(resultword.values());    } 

	}


