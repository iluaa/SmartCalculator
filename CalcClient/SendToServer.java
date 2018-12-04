import java.io.*;
import java.net.Socket;

public class SendToServer {

    private String result = "";

    String sender (String operation) throws IOException {

        Socket client = new Socket("localhost", 12345);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        out.write(operation + "\n");
        out.flush();
        result = in.readLine();

        return result;
    }
}
