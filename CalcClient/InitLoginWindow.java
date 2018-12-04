import java.io.IOException;

public class InitLoginWindow {

    private static LoginWindow lW;

    static {
        try {
            lW = new LoginWindow();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //private CalcWindow cW = new CalcWindow();

    public static LoginWindow getlW() {
        return lW;
    }


}
