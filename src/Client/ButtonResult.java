package Client;

import Server.MathEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ButtonResult implements ActionListener {
    String logger = "/Users/Илья/Desktop/учёба/курсыJava/SmartCalculator/src/Server/Logger.txt";
    String login = LoginWindow.login.getText();
    @Override
    public void actionPerformed(ActionEvent e) {
        MathEngine result = new MathEngine();
        MathEngine list = new MathEngine();
        //result.math();
        String finalResult = result.makeMath(list.parserString(CalcWindow.inputField.getText()));
        JButton b = (JButton)e.getSource();
        CalcWindow.inputField.setText(CalcWindow.inputField.getText()+b.getText() + finalResult);

        Date date = new Date();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logger, true))) {
            writer.write("Пользователь: " + login + "\n" + "Операция: " + CalcWindow.inputField.getText() + "\n" + "Дата: " + date.toString() + "\n");
            writer.newLine();
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
