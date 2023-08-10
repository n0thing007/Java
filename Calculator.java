package Project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Calculator implements ActionListener {   
    JFrame frame;//declaring variable frame
    JTextField textfield;//declaring variable textfield
    //defining JButton and taking memory of 10 button  and JButton class
    JButton[] numberButtons=new JButton[10];
    JButton[] functionButtons=new JButton[10];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton;
    JPanel panel;
    Font myFont=new Font("Arial",Font.BOLD,50);
    double num1=0,num2=0,result=0;
    char Operator;

    //Creating Constructor of Calcualtor1
    Calculator(){
        //creating Frame for calculator
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
        frame.setLayout(null);
       
        //creating textfield where we enter numbers and get the addition
        textfield= new JTextField();
        textfield.setBounds(20,20,396,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        //creating the object of JButton and assign to var addButton and passing text as +
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        clrButton = new JButton("AC");
        delButton = new JButton("DEL");
        
        //creating a functionButton[] array and passing var to each index 
        functionButtons[0]=addButton;
        functionButtons[1]=subButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=decButton;
        functionButtons[5]=equButton;
        functionButtons[6]=delButton;
        functionButtons[7]=clrButton;
        //creating a for loop which can iterate to each buttons
        for(int i=0;i<8;i++){
            functionButtons[i].addActionListener(this);//attaching current obj in the array to action listener at specific button
            functionButtons[i].setFont(myFont);//applying font to each button
            functionButtons[i].setFocusable(false) ;//when you click the button an outline pop up at its border to set it false
        }
        //this for loop is use to create digit from 0 to 9
        for(int i=0;i<10;i++){
            //JButton[] numberButtons=new JButton[10];
            // above line is use to create object of JButton and creating 10 size of array in Jbutton
            numberButtons[i]=new JButton(String.valueOf(i));//it creates a new object of JButton to each index of numberButtons and converting integer i to string 
            //why we need to convert integer into String?
            // because the JButton constructor expects a String as an argument for the button's label. 
            //The label is the text that appears on the button when it is displayed in the user interface.
            numberButtons[i].addActionListener(this);//attaching current obj in the array to action listener at specific button
            numberButtons[i].setFont(myFont);//applying font to each button
            numberButtons[i].setFocusable(false) ;
        }
        delButton.setBounds(65,400,145,50);
        clrButton.setBounds(220,400,145,50);
        frame.add(delButton);
        frame.add(clrButton);

        panel=new JPanel();
        panel.setBounds(33, 80, 370, 300);
        panel.setLayout(new GridLayout(4, 4,10,10));//horizontal gap and vertical gap
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);
        
    }
    public static void main(String args[]){
        Calculator calc=new Calculator();
        }
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks here
        //actions for 0 to 9 buttons
        for(int i=0;i<10;i++){
            if(e.getSource()==numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        //actions for . button
        if(e.getSource()==decButton){
            textfield.setText(textfield.getText().concat("."));
        }
        //actions for + button
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textfield.getText());
            //In the given code, num1 is already declared as a double variable. However, when you extract the value from the textfield using
            //textfield.getText(), the extracted value is in string format. In order to use this value for arithmetic operations, you need to 
            //convert it back to a numeric format (specifically, a double in this case).
            Operator='+';
            textfield.setText("");
        }
        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textfield.getText());
            textfield.setText(textfield.getText());
            Operator='-';
            textfield.setText("");
        }
        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textfield.getText());
            Operator='/';
            textfield.setText("");
        }
        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textfield.getText());
            Operator='*';
            textfield.setText("");
        }
       
        // after taking num1 input from above if loop and selcting the operation it goes to below if loop and take the second num2
          if(e.getSource()==equButton){
            num2 = Double.parseDouble(textfield.getText());
        switch(Operator){
            case '+':
            result =num1+num2;
            break;
            case '-':
            result =num1-num2;
            break; 
            case '*':
            result =num1*num2;
            break;
            case '/':
            result =num1/num2;
            break;     
        }
        //
        textfield.setText(String.valueOf(result));
        num1=result;//5(num1)+(operation)3(num2)=8(result=num1)+3(num2)=11(num1)
    }
    // below if loop use to convert double value into null
         if(e.getSource()==clrButton){
            textfield.setText("");
         }
         //
         if(e.getSource()==delButton){
            String string =textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }

         }
    }
}
