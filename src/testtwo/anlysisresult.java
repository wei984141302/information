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
		  sretain = sa.sentences;  //���ʿ����ArrayList�������ﳤ�ȷ��ã�ͨ�������Ϊ4����̳���Ϊ1  
		  for (int i = 4; i > 0; i--)        
		  sretain = sa.compare(sretain, is.split(is.s, i), i);  
		     //�½�һ��TreeMap��Ϊ�˿���ʹƥ���˵ķִ����°�ԭ�ȵ�˳������  
		   TreeMap resultword = new TreeMap();   
		   java.util.Iterator it = sa.words.iterator(); 
		   while (it.hasNext())
		   {  
		    String s = (String) it.next();   
		    resultword.put(sa.sentences.indexOf(s), s);  //��ƥ���˵�ArrayList����TreeMap     
		    }  
		  //���TreeMap��values�����ֲ�õľ��� 
		   System.out.println("output result words:");
		   System.out.println(resultword.values());    } 

	}


