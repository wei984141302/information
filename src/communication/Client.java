package communication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Client extends Thread{
	static Socket s;
	static JFrame frame;
	static JTextArea ta1;
	static JTextArea ta2;
	static JTextArea ta3;
	static JButton send;
	public static void main(String args[]) throws IOException {

		frame=new JFrame("客户端");
		ta1=new JTextArea(10,15);
		ta1.setSelectedTextColor(Color.red);
		ta1.setEditable(false);
		ta2=new JTextArea(3,15);
		ta3=new JTextArea(10,15);
		ta3.setEditable(false);
		send=new JButton("send");
		send.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				if(ta2.getSelectedText()!=null)
			    	ta3.append(ta2.getSelectedText()+"\n");
			    else
					ta3.append("\n"+ta2.getText()+"\n");
				
				InputStream   inputStream=new ByteArrayInputStream(ta2.getText().toString().getBytes());	
				ta2.setText("");
				InputStreamReader isr = new InputStreamReader(inputStream ); 
				BufferedReader in = new BufferedReader(isr);
				OutputStream os;

				try {
					os = s.getOutputStream();
					String strOut = new String();

					while (true) {
					    strOut = in.readLine();			
						os.write(strOut.getBytes());
						
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			 	
		});
		
		JPanel panel1=new JPanel();
		panel1.add(ta3);
		Border etched=BorderFactory.createEtchedBorder();
		Border border=BorderFactory.createTitledBorder(etched,"客户端发出信息");
		panel1.setBorder(border);
		JPanel panel2=new JPanel();
		panel2.add(ta1);
		Border etched1=BorderFactory.createEtchedBorder();
		Border border1=BorderFactory.createTitledBorder(etched1,"接收来自服务器的信息");
		panel2.setBorder(border1);
		
		JPanel panel3=new JPanel();
		panel3.add(ta2);
		Border etched2=BorderFactory.createEtchedBorder();
		Border border2=BorderFactory.createTitledBorder(etched2,"输入信息");
		panel3.setBorder(border2);
		panel3.add(send);
		
		Container cp=frame.getContentPane();
		cp.add(panel1,BorderLayout.EAST);
		cp.add(panel2,BorderLayout.WEST);
		cp.add(panel3,BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		// 在端口5432打开连接
		s = new Socket("127.0.0.1", 5432);
		// 获得socket端口的输入句柄，并从中读取数据
		if (s.isConnected()) {
			System.out.println("client connected!!!");
		}
		Client client = new Client();
		client.start();
	}
	
	public void run(){
		// 得到与socket相连接的数据流对象
		InputStream is = null;
		try {
			is = s.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		int len = 0;
		byte[] str = new byte[100];

		while (true) {
			try {
				while ((len = is.read(str)) != -1) {
					String sr = new String(str);
					System.out.println(sr);
					ta1.append(sr);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
