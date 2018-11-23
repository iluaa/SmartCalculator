package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class SigninButton implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        String dataBase = "/Users/Илья/Desktop/учёба/курсыJava/SmartCalculator/src/Server/DataBase.txt";
        ArrayList<String> logList = new ArrayList<>();
        boolean passwordError = false;
        boolean loginError = false;
        boolean logPassError = false;

        String trueMessage = "Регистрация завершена";
        String falseLogMessage = "Пользователь с таким именем уже существует";
        String falseIsEmpty = "Логин/Пароль должны быть заполнены";
        String falseContainsSpace = "Логин не может содержать пробелы";

        String log = LoginWindow.login.getText();
        String password = new String (LoginWindow.pass.getPassword());
        //System.out.println(log);
        //String message = "Вы успешно зарегистрированы!";

        String login = Hashing.hashLogin();
        String pass = Hashing.hashPassword();

        /*Проверка на недопустимые символы*/
        if (log.contains(" ")) {
            logPassError = true;
            JOptionPane.showMessageDialog(null, falseContainsSpace, "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        /*Проверяем не пусты ли поля "Login" и "Password"*/
        if (log.isEmpty() || password.isEmpty()) {
            logPassError = true;
            JOptionPane.showMessageDialog(null, falseIsEmpty, "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        /*Проверка введенного логина на уникальность*/
        try (BufferedReader reader = new BufferedReader(new FileReader(dataBase))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String logLine = line.split(" ", 2)[0];
                logList.add(logLine);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (String str : logList){
            if (!logPassError && str.equals(log)){
                loginError = true;
                JOptionPane.showMessageDialog(null, falseLogMessage, "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
        /*Если логин оригинален и введенные пароли совпадают, регистрация прошла успешно*/
        if (!logPassError && !loginError && !passwordError) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataBase, true))) {
                writer.write(login + " " + pass);
                writer.newLine();
                ;

                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, trueMessage, "Информация.", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
