import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button2 implements ActionListener {
    int button2;
    @Override
    public void actionPerformed(ActionEvent e) {
        button2 = 2;
        CalcWindow.inputField.setText(String.valueOf(button2));
        //System.out.println(button2);
    }
}
