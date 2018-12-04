
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ButtonResult implements ActionListener {
    //private String logger = "/Users/Илья/Desktop/учёба/курсыJava/SmartCalculator/src/Server/Logger.txt";
    private String login = LoginWindow.login.getText();
    private SendToServer sender = new SendToServer();
    private Caches cache = new Caches();
    private Date date = new Date();
    @Override
    public void actionPerformed(ActionEvent e) {

        if (cache.isInCacheFirst(CalcWindow.inputField.getText())){
            String result = cache.toReadFromCacheFirst(CalcWindow.inputField.getText());
            String finalResult= result.split("=",2)[1];
            JButton b  = (JButton) e.getSource();
            CalcWindow.inputField.setText(CalcWindow.inputField.getText() + b.getText() + finalResult);
            //String toWrite = "Пользователь: " + login + "\n" + "Операция взята из кэша 1 уровня: " + CalcWindow.inputField.getText() + "\n" + "Дата: " + date.toString() + "\n";
            /*try {
                FileWorker.fileWriter(logger,toWrite);
            } catch (IOException e1) {
                e1.printStackTrace();
            }*/
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(Main.logger, true))) {
                writer.write("Пользователь: " + login + "\n" + "Операция взята из кэша 1 уровня: " + CalcWindow.inputField.getText() + b.getText() + "\n" + "Дата: " + date.toString() + "\n");
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(cache.isInCacheSecond(CalcWindow.inputField.getText())){
            String result = cache.toReadFromCacheSecond(CalcWindow.inputField.getText());
            String finalResult=result.split("=",2)[1];
            JButton b = (JButton) e.getSource();
            CalcWindow.inputField.setText(CalcWindow.inputField.getText() + finalResult);
            String toWrite = "Пользователь: " + login + "\n" + "Операция взята из кэша 2 уровня: " + CalcWindow.inputField.getText() + "\n" + "Дата: " + date.toString() + "\n";
            /*try {
                FileWorker.fileWriter(logger,toWrite);
            } catch (IOException e1) {
                e1.printStackTrace();
            }*/
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(Main.logger, true))) {
                writer.write("Пользователь: " + login + "\n" + "Операция взята из кэша 2 уровня: " + CalcWindow.inputField.getText() + "\n" + "Дата: " + date.toString() + "\n");
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else {
            /*MathEngine result = new MathEngine();
            MathEngine list = new MathEngine();
            String finalResult = "";
                    //result.makeMath(list.parserString(CalcWindow.inputField.getText()));
            JButton b = (JButton) e.getSource();
            CalcWindow.inputField.setText(CalcWindow.inputField.getText() + b.getText() + finalResult);
            cache.toWriteInCache(CalcWindow.inputField.getText());
            //String toWrite = "Пользователь: " + login + "\n" + "Операция: " + CalcWindow.inputField.getText() + "\n" + "Дата: " + date.toString() + "\n";
            /*try {
                FileWorker.fileWriter(logger, toWrite);
            } catch (IOException e1) {
                e1.printStackTrace();
            }*/
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(Main.logger, true))) {
                String finalResult = sender.sender(CalcWindow.inputField.getText());
                JButton b = (JButton) e.getSource();
                if (!finalResult.equals("error")) {
                    writer.write("Пользователь: " + login + "\n" + "Операция: " + CalcWindow.inputField.getText() + b.getText() + finalResult + "\n" + "Дата: " + date.toString() + "\n");
                    writer.newLine();
                    cache.toWriteInCache(CalcWindow.inputField.getText() + b.getText() + finalResult);
                    CalcWindow.inputField.setText(CalcWindow.inputField.getText() +  b.getText() + finalResult);
                    writer.flush();
                }
                else {
                    CalcWindow.inputField.setText(CalcWindow.inputField.getText() +  b.getText() + finalResult);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
