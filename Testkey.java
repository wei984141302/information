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
		/*实现键盘监听，获取焦点的意思
		因为的程序的焦点一开始在Button上，但是键盘监听在窗体上，
		所以要重新把焦点设置在窗体上
		点击Button后，焦点又在Button上了*/


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