package combox;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import jxl.Cell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

public class SecondComboboxDemo {
	JFrame frame = new JFrame("JComboBox Demo");
	JComboBox jcb1, jcb2,jcb3;
	JTextArea ta = new JTextArea(0, 30); // 用于显示结果的文本区
	String[] No1=null,No2=null,NO3=null;
	String[] itemList;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	Border etched = BorderFactory.createEtchedBorder(); // 创建边框
	Border border = BorderFactory.createTitledBorder(etched,
			"Uneditable JComboBox"); // 表框加上标题

	

	public static void main(String args[]) {
		SecondComboboxDemo cbd = new SecondComboboxDemo();
		cbd.go();
	}

	public static String[] getNo1Lever() {
		InputStream is;
		String[] no1List = null;
		//double[] number=null;
		int j=0;
		try {
			is = new FileInputStream("中华人民共和国行政区划代码.xls");
			jxl.Workbook workbook = Workbook.getWorkbook(is);
			Sheet rs = workbook.getSheet(0);
			int row = rs.getRows();
			no1List = new String[row];
			for (int i = 0; i < row; i++) {
				Cell cell = rs.getCell(0, i);
				NumberCell value = (NumberCell) cell;
				double cellvalue = value.getValue();
				if(cellvalue%10000==0)
				{
				Cell cell1 = rs.getCell(1, i);
				System.out.println(cell1.getContents());
				no1List[j]=cell1.getContents();
				j++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return no1List;
	}
	
	public static String[] getNo2Lever(int row) {
		InputStream is;
		String[] no1List = null;
		int j=0;
		try {
			is = new FileInputStream("中华人民共和国行政区划代码.xls");
			jxl.Workbook workbook = Workbook.getWorkbook(is);
			Sheet rs = workbook.getSheet(0);
			int row1 = rs.getRows();
			no1List = new String[row1];
			Cell cell = rs.getCell(0, row);
			NumberCell value = (NumberCell) cell;
			double cellvalue = value.getValue()%10000;
			for (int i=row+1; i < row1; i++) {
				Cell cell1 = rs.getCell(0, i);
				NumberCell value1 = (NumberCell) cell1;
				double cellvalue1 = value1.getValue();
			    if(cellvalue1%10000!=0&&cellvalue1%10000<=(cellvalue+1)&&cellvalue1%100==0)
				{
				Cell cell2 = rs.getCell(1, i);
				System.out.println(cell2.getContents());
				no1List[j]=cell2.getContents();
				j++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return no1List;
	}
	public String[] getNo3Lever(int row) {
		InputStream is;
		String[] no1List = null;
		double[] number=null;
		int j=0;
		try {
			is = new FileInputStream("中华人民共和国行政区划代码.xls");
			jxl.Workbook workbook = Workbook.getWorkbook(is);
			Sheet rs = workbook.getSheet(0);
			int row1 = rs.getRows();
			no1List = new String[row1];
			Cell cell = rs.getCell(0, row);
			NumberCell value = (NumberCell) cell;
			double cellvalue = value.getValue()%10000;
			double cellvalue1=value.getValue()%100;
			for (int i=row+1; i < row1; i++) {
				Cell cell1 = rs.getCell(0, i);
				NumberCell value1 = (NumberCell) cell1;
				double cellvalue2 = value.getValue();
				if(cellvalue2%10000!=0&&cellvalue2%10000<=(cellvalue+1)&&cellvalue2%100!=0&&cellvalue%10!=0)
				{
				Cell cell2 = rs.getCell(1, i);
				no1List[j]=cell2.getContents();
				j++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return no1List;
	}
	public void go() {
		// 创建内部JPanel容器
		itemList = getNo1Lever();
		jcb1 = new JComboBox(itemList);
		jcb1.setSelectedIndex(0); // 设置第4个可选项为当前的显示项

		p1.add(jcb1);
		p1.setBorder(border);

		// 添加4个可选项
		itemList = getNo2Lever(1);		
		jcb2 = new JComboBox(itemList);
		
		// 将jcb2设置为可编辑的
		jcb2.setEditable(true);

		p2.add(jcb2);
		border = BorderFactory.createTitledBorder(etched, "Editable JComboBox");
		p2.setBorder(border);

		itemList = getNo3Lever(2);
		jcb3 = new JComboBox(itemList);
		jcb3.setSelectedIndex(0); // 设置第4个可选项为当前的显示项

		p3.add(jcb3);
		border = BorderFactory.createTitledBorder(etched,"Uneditable JComboBox"); 
		p3.setBorder(border);
		
		JScrollPane jp = new JScrollPane(ta);
		p4.setLayout(new BorderLayout());
		p4.add(jp);
		border = BorderFactory.createTitledBorder(etched, "Results");
		p4.setBorder(border);

		ActionListener al1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox jcb = (JComboBox) e.getSource();

				if (jcb == jcb2) {
					int row = jcb.getSelectedIndex();
			
						jcb3.removeAllItems(); // 去除所有选项
						p3.remove(jcb3);
						row = jcb.getSelectedIndex();		
						itemList = getNo3Lever(row);
						jcb3 = new JComboBox(itemList);
						border = BorderFactory.createTitledBorder(etched,"Uneditable JComboBox"); 
						p3.add(jcb3);
						jcb2.setEditable(true);	
				} else {
					
				}
			}
		};
			ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox jcb = (JComboBox) e.getSource();
				int row=0;	
				if (jcb == jcb1) {
					row = jcb.getSelectedIndex();		
					jcb2.removeAllItems(); // 去除所有选项
					p2.remove(jcb2);
					jcb3.removeAllItems(); // 去除所有选项
					p3.remove(jcb3);
					itemList = getNo2Lever(row);		
					jcb2 = new JComboBox(itemList);
					border = BorderFactory.createTitledBorder(etched, "Editable JComboBox");
					jcb2.setEditable(true);	
				}
			}
			
		};

		jcb1.addActionListener(al);
		jcb2.addActionListener(al1);
	
		
		p5.setLayout(new GridLayout(0, 1));
		p5.add(p1);
		p5.add(p2);
		p5.add(p3);
		
		Container cp = frame.getContentPane();
		cp.setLayout(new GridLayout(0, 1));
		cp.add(p5);
		cp.add(p4);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}