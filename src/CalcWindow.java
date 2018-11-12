import javax.swing.*;
import java.awt.*;

public class CalcWindow{
    private JButton button0 = new JButton("0");
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");
    private JButton button7 = new JButton("7");
    private JButton button8 = new JButton("8");
    private JButton button9 = new JButton("9");
    private JButton buttonRes = new JButton("=");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonDiv = new JButton("/");
    private JButton buttonMult = new JButton("*");
    static JTextField inputField = new JTextField();
    private JLabel inputText = new JLabel("Введите операцию");
    private JLabel text = new JLabel(" ");
    private Font font = new Font(Font.SANS_SERIF,Font.BOLD,20);

    public CalcWindow(){
        JFrame frameCalc = new JFrame("Калькулятор");
        frameCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCalc.setBounds(100,100,350,385);
        frameCalc.setLocationRelativeTo(null);
        frameCalc.setVisible(true);
        frameCalc.setResizable(false);
        frameCalc.setBackground(Color.white);

        //JPanel inputPanel = new JPanel(new GridLayout(1,2));
        //JPanel numberPanel = new JPanel(new GridLayout(5,3,50,35));
        //JPanel resPanel = new JPanel(new GridLayout(1,1));
        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(null);

        button1.setBackground(Color.white);
        button1.setFont(font);
        button1.setBounds(135,70,50,50);
        button1.addActionListener(new Button1());
        button2.setBackground(Color.white);
        button2.setFont(font);
        button2.setBounds(205,70,50,50);
        button2.addActionListener(new Button2());
        button3.setBackground(Color.white);
        button3.setFont(font);
        button3.setBounds(275,70,50,50);
        button4.setBackground(Color.white);
        button4.setFont(font);
        button4.setBounds(135,140,50,50);
        button5.setBackground(Color.white);
        button5.setFont(font);
        button5.setBounds(205,140,50,50);
        button6.setBackground(Color.white);
        button6.setFont(font);
        button6.setBounds(275,140,50,50);
        button7.setBackground(Color.white);
        button7.setFont(font);
        button7.setBounds(135,210,50,50);
        button8.setBackground(Color.white);
        button8.setFont(font);
        button8.setBounds(205,210,50,50);
        button9.setBackground(Color.white);
        button9.setFont(font);
        button9.setBounds(275,210,50,50);
        button0.setBackground(Color.white);
        button0.setFont(font);
        button0.setBounds(205,280,50,50);
        buttonPlus.setBackground(Color.lightGray);
        buttonPlus.setFont(font);
        buttonPlus.setBounds(20,70,50,50);
        buttonMinus.setBackground(Color.lightGray);
        buttonMinus.setFont(font);
        buttonMinus.setBounds(20,140,50,50);
        buttonMult.setBackground(Color.lightGray);
        buttonMult.setFont(font);
        buttonMult.setBounds(20,210,50,50);
        buttonDiv.setBackground(Color.lightGray);
        buttonDiv.setFont(font);
        buttonDiv.setBounds(20,280,50,50);
        buttonRes.setBackground(Color.lightGray);
        buttonRes.setFont(font);
        buttonRes.setBounds(285,10,50,50);

        inputField.setBounds(10,10,260, 50);
        inputField.setBackground(Color.lightGray);
        inputField.setEditable(false);
        inputField.setFont(font);
        inputField.setBorder(null);
        //inputField.setBackground(Color.white);

        //inputPanel.setBackground(Color.white);
        //inputPanel.add(inputText);
        numberPanel.add(inputField);
        numberPanel.add(buttonPlus);
        numberPanel.add(button1);
        numberPanel.add(button2);
        numberPanel.add(buttonMinus);
        numberPanel.add(button3);
        numberPanel.add(button4);
        numberPanel.add(buttonMult);
        numberPanel.add(button5);
        numberPanel.add(button6);
        numberPanel.add(buttonDiv);
        numberPanel.add(button7);
        numberPanel.add(button8);
        numberPanel.add(buttonRes);
        numberPanel.add(button9);
        numberPanel.add(button0);
        numberPanel.setBackground(Color.white);
        //resPanel.add(buttonRes);
        //resPanel.setBackground(Color.white);

        //frameCalc.add(inputPanel);
        frameCalc.add(numberPanel);
        //frameCalc.add(resPanel);

        /*frameCalc.add(inputPanel, BorderLayout.NORTH);
        frameCalc.add(numberPanel, BorderLayout.CENTER);
        frameCalc.add(resPanel, BorderLayout.SOUTH);*/
    }

}
