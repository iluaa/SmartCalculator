import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button1 implements ActionListener {
    int button1;
    String inputText;
    @Override
    public void actionPerformed(ActionEvent e) {
        button1 = 1;
        //CalcWindow.inputField.setText(String.valueOf(button1));;
        inputText = String.valueOf(button1);
    }
}
