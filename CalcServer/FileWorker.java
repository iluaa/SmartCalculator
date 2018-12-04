import java.io.*;
import java.util.ArrayList;

public class FileWorker implements Serializable {
    private static ArrayList<String> logList = new ArrayList<>();
    private static ArrayList<String> passList = new ArrayList<>();


    public static ArrayList fileReaderLogin(String locationFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(locationFile));
        while(reader.ready()){
            String line = reader.readLine();
            String logLine = line.split(" ", 2)[0];
            logList.add(logLine);
        }
        return logList;
    }

    public static ArrayList fileReaderPass(String locationFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(locationFile));
        while(reader.ready()){
            String line = reader.readLine();
            String passLine = line.split(" ", 2)[1];
            passList.add(passLine);
        }
        return passList;
    }

    public static void fileWriter(String locationFail, String valueToWrite) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(locationFail, true));
        writer.write(valueToWrite);
        writer.newLine();
        writer.flush();
    }
}
