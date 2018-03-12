package communication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class serverinterface {

	/**
	 * @param args
	 */
	static JFrame frame;
	static JTextArea ta1;
	static JTextArea ta2;
	static JTextArea ta3;
	static JButton send;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		serverinterface that=new serverinterface();
		that.go();
	}
		public void go()
		{
		frame=new JFrame("·þÎñ¶Ë");
		ta1=new JTextArea(10,15);
		ta1.setSelectedTextColor(Color.red);
		ta1.setEditable(false);
		ta2=new JTextArea(3,15);
		ta3=new JTextArea(10,15);
		ta3.setEditable(false);
		
		JScrollPane jsp1=new JScrollPane(ta1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane jsp2=new JScrollPane(ta2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane jsp3=new JScrollPane(ta3,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		send=new JButton("send");
		send.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(ta2.getSelectedText()!=null)
				{
					ta3.append(ta2.getSelectedText()+"\n");
				    Client.ta1.append(ta2.getSelectedText()+"\n");
				}
				else
				{
					ta3.append("\n"+ta2.getText()+"\n");
				    Client.ta1.append(ta2.getText()+"\n");
				}
				
				ta2.setText("");
			}
		});
		JPanel panel1=new JPanel();
		panel1.add(jsp1);
		panel1.add(jsp3);
		Border etched=BorderFactory.createEtchedBorder();
		panel1.setBorder(etched);
		
		JPanel panel2=new JPanel();
		panel2.add(jsp2);
		panel2.add(send);
		panel2.setBorder(etched);
		
		Container cp=frame.getContentPane();
		cp.add(panel1,BorderLayout.CENTER);
		cp.add(panel2,BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

}
