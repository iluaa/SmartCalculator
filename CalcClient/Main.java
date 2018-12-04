import java.io.IOException;

public class Main {

    static String logger;
    static String dataBase;

    static{
        SendToServer sender = new SendToServer();
        String loggerAndDataBase = null;
        try {
            loggerAndDataBase = sender.sender("New Connection");
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger = loggerAndDataBase.split(" ",2)[0];
        dataBase = loggerAndDataBase.split(" ",2)[1];
    }

    public static void main(String[] args) {

        //LoginWindow lW = new LoginWindow();
        //CalcWindow cW = new CalcWindow();
        InitLoginWindow.getlW();

        Thread clearingCache = new Thread( new ClearingCache());
        clearingCache.start();
    }
}
