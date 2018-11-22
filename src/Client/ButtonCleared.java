package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCleared implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CalcWindow.inputField.setText("");
    }
}
