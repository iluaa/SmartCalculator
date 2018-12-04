import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LoginWindow {


    private JLabel loginLabel = new JLabel("Введите логин:");
    private JLabel passLabel = new JLabel("Введите пароль:");
    static JTextField login = new JTextField();
    static JPasswordField pass = new JPasswordField();
    private JButton enterButton = new JButton("Войти");
    private JButton signinButton = new JButton("Зарегистрироваться");
    private static JFrame frame = new JFrame("Авторизация");
    public LoginWindow () throws IOException, ClassNotFoundException {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,350,105);
        //frame.setSize(450,165);
        //frame.setLocation(500,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBackground(Color.white);

        JPanel upPanel = new JPanel(new GridLayout(2,2));
        JPanel downPanel = new JPanel(new GridLayout(1,2,1,1));
        JPanel middlePanel = new JPanel(new GridLayout(1,2,1,1));

        upPanel.add(loginLabel);
        upPanel.add(login);
        upPanel.setBackground(Color.white);
        upPanel.add(passLabel);
        upPanel.add(pass);
        pass.setEchoChar('*');


        enterButton.setBackground(Color.white);
        signinButton.setBackground(Color.white);

        downPanel.add(enterButton);
        enterButton.addActionListener(new EnterButton());
        downPanel.add(signinButton);
        signinButton.addActionListener(new SigninButton());
        downPanel.setBackground(Color.white);

        middlePanel.setBackground(Color.white);

        frame.add(upPanel, BorderLayout.NORTH);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(downPanel, BorderLayout.SOUTH);
    }
    static void getLoginWindowInvisible(){
        frame.setVisible(false);
    }
}

