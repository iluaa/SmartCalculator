package Client;

import javax.swing.*;
import java.awt.*;

public class CalcWindow{

    private JButton numbers[] = new JButton[10];
    private JButton buttonRes = new JButton("=");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonDiv = new JButton("/");
    private JButton buttonMult = new JButton("*");
    private JButton buttonClear = new JButton("C");
    private JButton buttonPoint = new JButton(".");
    public static JTextField inputField = new JTextField();
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

        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(null);

        for (int x=0; x<3; x++){
            for (int y=0; y<3; y++){
                numbers[x * 3 + y + 1] = new JButton((x * 3 + y + 1) + "");
                numbers[x * 3 + y + 1].setBounds(x * (50 + 20) + 135,y * (50 + 20) + 70,50,50);
                numbers[x * 3 + y + 1].setBackground(Color.white);
                numbers[x * 3 + y + 1].setFont(font);
                numbers[x * 3 + y + 1].setBorder(null);
                numbers[x * 3 + y + 1].addActionListener( new ButtonAction());
                numberPanel.add(numbers[x * 3 + y + 1]);

            }
        }
        numbers[0] = new JButton("0");
        numbers[0].setFont(font);
        numbers[0].setBackground(Color.white);
        numbers[0].setBounds(205,280,50,50);
        numbers[0].setBorder(null);
        numbers[0].addActionListener(new ButtonAction());
        numberPanel.add(numbers[0]);


        buttonPlus.setBackground(Color.lightGray);
        buttonPlus.setFont(font);
        buttonPlus.setBounds(20,70,50,50);
        buttonPlus.addActionListener(new ButtonAction());
        buttonPlus.setBorder(null);
        buttonMinus.setBackground(Color.lightGray);
        buttonMinus.setFont(font);
        buttonMinus.setBounds(20,140,50,50);
        buttonMinus.addActionListener(new ButtonAction());
        buttonMinus.setBorder(null);
        buttonMult.setBackground(Color.lightGray);
        buttonMult.setFont(font);
        buttonMult.setBounds(20,210,50,50);
        buttonMult.addActionListener(new ButtonAction());
        buttonMult.setBorder(null);
        buttonDiv.setBackground(Color.lightGray);
        buttonDiv.setFont(font);
        buttonDiv.setBounds(20,280,50,50);
        buttonDiv.setBorder(null);
        buttonDiv.addActionListener(new ButtonAction());
        buttonRes.setBackground(Color.lightGray);
        buttonRes.setFont(font);
        buttonRes.setBounds(285,10,50,50);
        buttonRes.addActionListener( new ButtonResult());
        buttonRes.setBorder(null);
        buttonClear.setFont(font);
        buttonClear.setBounds(275,280,50,50);
        buttonClear.setBackground(Color.lightGray);
        buttonClear.addActionListener(new ButtonCleared());
        buttonClear.setBorder(null);
        buttonPoint.setFont(font);
        buttonPoint.setBounds(135,280,50,50);
        buttonPoint.setBackground(Color.lightGray);
        buttonPoint.addActionListener(new ButtonAction());
        buttonPoint.setBorder(null);


        inputField.setBounds(10,10,260, 50);
        inputField.setBackground(Color.lightGray);
        inputField.setEditable(false);
        inputField.setFont(font);
        inputField.setBorder(null);

        numberPanel.add(inputField);
        numberPanel.add(buttonPlus);
        numberPanel.add(buttonMinus);
        numberPanel.add(buttonMult);
        numberPanel.add(buttonDiv);
        numberPanel.add(buttonRes);
        numberPanel.add(buttonClear);
        numberPanel.add(buttonPoint);
        numberPanel.setBackground(Color.white);

        frameCalc.add(numberPanel);

    }

}
