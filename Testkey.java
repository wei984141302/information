package calculator;

import java.awt.*;
import java.awt.event.*;

class CloseFream extends WindowAdapter {
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}
}

class Close extends KeyAdapter {
	public void keyTyped(KeyEvent e) {
		System.out.print(e.getKeyChar());
		if (e.getKeyChar() == 'a') {
			System.out.println(e.getKeyChar());
			System.exit(0);
		}
	}
}

class MyFrame extends Frame implements ActionListener {
	Button b1, b2;

	public MyFrame() {
		b1 = new Button("click");
		b2 = new Button("quit");
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		addKeyListener(new Close());
		addWindowListener(new CloseFream());
		setSize(100, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		//this.requestFocus();                                                                                                                                                                                                                                                                                                                                 
		/*ʵ�ּ��̼�������ȡ�������˼
		��Ϊ�ĳ���Ľ���һ��ʼ��Button�ϣ����Ǽ��̼����ڴ����ϣ�
		����Ҫ���°ѽ��������ڴ�����
		���Button�󣬽�������Button����*/


		if (e.getActionCommand() == "click") {
			b1.setLabel("yes");
		} else if (e.getActionCommand() == "quit")
			System.exit(0);

	}
}

public class Testkey {

	public static void main(String[] args) {
		new MyFrame();
	}

}