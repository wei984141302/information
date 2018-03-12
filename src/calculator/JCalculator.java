package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class JCalculator extends JFrame implements ActionListener {
    private static final long serialVersionUID = -169068472193786457L;
    private class WindowCloser extends WindowAdapter {
       public void windowClosing(WindowEvent we) {
           System.exit(0);
       }
    } 
    int i;
    private final String[] str = { "1", "2", "3", "+","C", "4", "5", "6", "-","退格", "7",
	           "8", "9", "*","1/X", "0", "+/-", ".", "/","=" };
    JButton[] buttons = new JButton[str.length];
    JTextField display = new JTextField("0");
    public static void main(String[] args) {
        new JCalculator();
     }
    public JCalculator() {
       super("Calculator");
    
       JPanel panel1 = new JPanel(new GridLayout(4, 5));
      
       for (i = 0; i < str.length; i++) {
           buttons[i] = new JButton(str[i]);
           panel1.add(buttons[i]);
       }
       JPanel panel2 = new JPanel(new BorderLayout());
     
       panel2.add("Center", display);
       getContentPane().setLayout(new BorderLayout());
       getContentPane().add("North", panel2);
       getContentPane().add("Center", panel1);
      
       for (i = 0; i < str.length; i++)
           buttons[i].addActionListener(this);
     
       display.addActionListener(this);
     
       addWindowListener(new WindowCloser());
   
       setSize(800, 800);
   
       setVisible(true);
       pack();
    }  
   
    public void actionPerformed(ActionEvent e) {
       Object target = e.getSource();
       String label = e.getActionCommand();
       if (target.equals(buttons[4]))
           handleReset();
       else if(target.equals(buttons[9])){//退格键，删除一个直到没有字符删除     
			String inputText = display.getText();           
			if(inputText.length() > 0) 
				display.setText(inputText.substring(0, inputText.length() - 1));        
			}
       else if ("0123456789.".indexOf(label) > 0)
           handleNumber(label);
       else
           handleOperator(label);
    }
    boolean isFirstDigit = true;
    public void handleNumber(String key) {
       if (isFirstDigit)
           display.setText(key);
       else if ((key.equals(".")) && (display.getText().indexOf(".") < 0))
           display.setText(display.getText() + ".");
       else if (!key.equals("."))
           display.setText(display.getText() + key);
       isFirstDigit = false;
    }
  
    public void handleReset() {
       display.setText("0");
       isFirstDigit = true;
       operator = "=";
    }
 
    double number = 0.0;
    String operator = "=";
    public void handleOperator(String key) {
       if (operator.equals("+"))
           number += Double.valueOf(display.getText());
       else if (operator.equals("-"))
            number -= Double.valueOf(display.getText());
       else if (operator.equals("*"))
            number *= Double.valueOf(display.getText());
       else if (operator.equals("/"))
            number /= Double.valueOf(display.getText());
       else if (operator.equals("="))
            number = Double.valueOf(display.getText());
       else if (operator.equals("1/X"))
    	    number =1/ Double.valueOf(display.getText());
       else if (operator.equals("+/-"))
       {
    	       if(Double.valueOf(display.getText())>0)
    	          {number =0.0-Double.valueOf(display.getText());}
    	       else number =0.0-Double.valueOf(display.getText());
       }
       display.setText(String.valueOf(number));
       operator = key;
       isFirstDigit = true;
    }
   
   
}


