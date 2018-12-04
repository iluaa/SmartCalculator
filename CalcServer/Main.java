import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    static String logger;
    static String dataBase;

    static {
        try {
            File logFile = new File("logger.txt");
            File dataBaseFile = new File("dataBase.txt.");

            if (!logFile.exists())
                logFile.createNewFile();
            if (!dataBaseFile.exists())
                dataBaseFile.createNewFile();

            logger = logFile.getAbsolutePath();
            dataBase = dataBaseFile.getAbsolutePath();
        } catch (IOException ex) {ex.printStackTrace();}
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Сервер запущен!");

        while (true) {
            Socket clientSocket = server.accept();
            new Thread(new SerwerWorker(clientSocket)).start();
        }
    }
}
