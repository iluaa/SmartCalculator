import java.io.*;
import java.net.Socket;

public class SerwerWorker implements Runnable {
    private MathEngine mathEngine = new MathEngine();
    private static BufferedReader in;
    private static BufferedWriter out;
    static String operation;
    private Socket clientSocket;

    public SerwerWorker (Socket socket) {this.clientSocket = socket;}

    @Override
    public void run() {
        try {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                operation = in.readLine();
                if (operation.equals("New Connection")){
                    out.write(Main.logger + " ");
                    out.write(Main.dataBase);
                }
                out.write(mathEngine.makeMath(mathEngine.parserString(operation)) + "");

            } finally {
                out.flush();
                in.close();
                out.close();
            }
        } catch (IOException ex){ex.printStackTrace();}
    }
}
