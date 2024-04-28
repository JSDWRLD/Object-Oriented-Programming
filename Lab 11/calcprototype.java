/**
 *  @version 4-28-24
 *  This lab we create a simple calculator using java swing
 */
  
import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 
class calcprototype extends JFrame implements ActionListener { 
    // create a frame 
    static JFrame f; 
  
    // create a textfield 
    static JTextField l; 
  
    // store oprerator and operands 
    String s0, s1, s2; 
  
    // default constructor
    calcprototype() { 
        s0 = s1 = s2 = ""; 
    } 
  
    // main function 
    public static void main(String args[]) { 
        // create a frame 
        f = new JFrame("Calculator"); 

  
        try { 
            // set look and feel 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
        } 
        catch (Exception e) { 
            System.err.println(e.getMessage()); 
        } 
  
        // create a object of class 
        calcprototype c = new calcprototype(); 
  
        // create a textfield 
        l = new JTextField(16); 
  
        // set the textfield to non editable 
        l.setEditable(false); 
        l.setText("0");

        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9; 

        // create number buttons 
        b0 = new JButton("0"); 
        b1 = new JButton("1"); 
        b2 = new JButton("2"); 
        b3 = new JButton("3"); 
        b4 = new JButton("4"); 
        b5 = new JButton("5"); 
        b6 = new JButton("6"); 
        b7 = new JButton("7"); 
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0.addActionListener(c); 
        b1.addActionListener(c); 
        b2.addActionListener(c); 
        b3.addActionListener(c); 
        b4.addActionListener(c); 
        b5.addActionListener(c); 
        b6.addActionListener(c); 
        b7.addActionListener(c); 
        b8.addActionListener(c); 
        b9.addActionListener(c); 



        JButton addB = new JButton("+");
        JButton subB = new JButton("-");
        JButton multiB = new JButton("*");
        JButton divisionB = new JButton("/");
        JButton dotB = new JButton(".");
        JButton equalB = new JButton("=");
        JButton clearB = new JButton("C");
        
        addB.addActionListener(c); 
        subB.addActionListener(c);
        multiB.addActionListener(c); 
        divisionB.addActionListener(c); 
        dotB.addActionListener(c); 
        equalB.addActionListener(c); 
        clearB.addActionListener(c); 
  
        JPanel p = new JPanel(); 
  
        p.add(l); 
        p.add(b0);
        p.add(b1); 
        p.add(b2); 
        p.add(b3); 
        p.add(b4); 
        p.add(b5); 
        p.add(b6); 
        p.add(b7); 
        p.add(b8); 
        p.add(b9); 

        p.add(addB);
        p.add(subB);
        p.add(multiB);
        p.add(divisionB);
        p.add(dotB);
        p.add(equalB);
        p.add(clearB);
  
        // set Background of panel 
        p.setBackground(Color.blue); 
  
        // add panel to frame 
        f.add(p); 
  
        f.setSize(200, 220); 
        f.setVisible(true); 
        } 
        public void actionPerformed(ActionEvent e) { 
            // s0 First operand
            // s1 Operator
            // s2 Second operand
            String s = e.getActionCommand(); 
            // handling number inputs first
            if(s.charAt(0) >= '0' && s.charAt(0) <= '9' || s.equals(".")){
                // if our operator is not empty we append number input into second operand
                // else it our first operand
                if(!s1.equals("")){
                    s2 = s2 + s;
                } else {
                    s0 = s0 + s;
                }
                l.setText(s0 + s1 + s2);
            } else if (s.charAt(0) == 'C'){
                s0 = "";
                s1 = "";
                s2 = "";
                l.setText(s0 + s1 + s2);
            } else if (s.charAt(0) == '.'){
                // same logic as number we just try to find where to put the dot
                if(!s1.equals("")){
                    s2 = s2 + s;
                } else {
                    s0 = s0 + s;
                }
                l.setText(s0 + s1 + s2);
            } else if (s.charAt(0) == '=') {
                // do math, switch statement with operator
                double result = 0;
                switch(s1){
                    case "+":
                        result = Double.parseDouble(s0) + Double.parseDouble(s2);
                        break;
                    case "-":
                        result = Double.parseDouble(s0) - Double.parseDouble(s2);
                        break;
                    case "*":
                        result = Double.parseDouble(s0) * Double.parseDouble(s2);
                        break;
                    case "/":
                        result = Double.parseDouble(s0) / Double.parseDouble(s2);
                        break;
                }
                s1 = "";
                s2 = "";
                s0 = Double.toString(result);
                l.setText(s0 + s1 + s2);
            } else {
                // this is all the multiplaticion, divison, minus, and add BASICALLY operator 
                // handle case where user tries to input another operator, do auto calc
                if(s0 == "" || s2 == ""){
                    // we can add without calculating
                    s1 = s;
                } else {
                    // We have two operands and one operator
                    // calculate result and store result in first operator, and store new user input operator
                    double result = 0;
                    switch(s1){
                        case "+":
                            result = Double.parseDouble(s0) + Double.parseDouble(s2);
                            break;
                        case "-":
                            result = Double.parseDouble(s0) - Double.parseDouble(s2);
                            break;
                        case "*":
                            result = Double.parseDouble(s0) * Double.parseDouble(s2);
                            break;
                        case "/":
                            result = Double.parseDouble(s0) / Double.parseDouble(s2);
                            break;
                    }
                    s1 = s;
                    s2 = "";
                    s0 = Double.toString(result);


                }

                l.setText(s0 + s1 + s2);
            }
        
        } 
} 
