
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class EnterButton implements ActionListener {
    //private String dataBase = "/Users/Илья/Desktop/учёба/курсыJava/SmartCalculator/src/Server/DataBase.txt";
    private String errorMessage = "Неверный логин/пароль.";


    @Override
    public void actionPerformed(ActionEvent e) {
        //String loginEnter = LoginWindow.login.getText();
        //String passwordEnter = new String (LoginWindow.pass.getPassword());
        //String accountEnter = loginEnter + " " + passwordEnter;
        ArrayList<String> logList = new ArrayList<>();
        ArrayList<String> passList = new ArrayList<>();


        boolean error = true;

        String login = Hashing.hashLogin();
        String pass = Hashing.hashPassword();

        try (BufferedReader reader = new BufferedReader(new FileReader(Main.dataBase))) {
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
            if(logList.get(i).equals(login)&&passList.get(i).equals(pass)){
                error = false;
                break;
            }
        }
        if(!error){
            InitCalcWindow.getcW();
            LoginWindow.getLoginWindowInvisible();
        }
        else {
            JOptionPane.showMessageDialog(null, errorMessage,"Ошибка.", JOptionPane.ERROR_MESSAGE);
        }


    }

}
