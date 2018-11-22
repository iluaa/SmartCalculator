package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class EnterButton implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String loginEnter = LoginWindow.login.getText();
        String passwordEnter = new String (LoginWindow.pass.getPassword());
        String accountEnter = loginEnter + " " + passwordEnter;
        ArrayList<String> logList = new ArrayList<>();
        ArrayList<String> passList = new ArrayList<>();

        String dataBase = "/Users/Илья/Desktop/учёба/курсыJava/SmartCalculator/src/Server/DataBase.txt";
        String errorMessage = "Неверный логин/пароль.";
        String secsessMessage ="Вход выполнен";
        boolean error = true;

        try (BufferedReader reader = new BufferedReader(new FileReader(dataBase))) {
            while(reader.ready()){
                String line = reader.readLine();
                String logLine = line.split(" ", 2)[0];
                String passLine = line.split(" ", 2)[1];
                logList.add(logLine);
                passList.add(passLine);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        for (int i = 0; i < logList.size(); i++){
            if(logList.get(i).equals(loginEnter)&&passList.get(i).equals(passwordEnter)){
                error = false;
                break;
            }
        }
        if(!error){
            //JOptionPane.showMessageDialog(null,secsessMessage,"Вход выполненен.", JOptionPane.INFORMATION_MESSAGE);
            //CalcWindow cW = new CalcWindow();
            InitCalcWindow initCalcWindow = new InitCalcWindow();
            initCalcWindow.getcW();

        }
        else {
            JOptionPane.showMessageDialog(null, errorMessage,"Ошибка.", JOptionPane.ERROR_MESSAGE);
        }

    }

}
