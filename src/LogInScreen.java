import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-15
 * Time: 15:10
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class LogInScreen extends JFrame implements ActionListener {

    protected Database d = new Database();

    protected PersonDAO personDAO = d;
    protected AttendanceDAO attendanceDAO = d;
    protected DatabaseDAO databaseDAO = d;


    JPanel welcomeScreen = new JPanel();
    JLabel title = new JLabel("Välkommen till förskolan!");
    JLabel logIninput = new JLabel("Skriv ditt användarnamn");
    JTextField username = new JTextField(20);
    JLabel info = new JLabel();

    String name;

    public LogInScreen() {
        add(welcomeScreen);
        welcomeScreen.setLayout(new GridLayout(4, 1));
        welcomeScreen.add(title);
        welcomeScreen.add(logIninput);
        welcomeScreen.add(username);
        welcomeScreen.add(info);

        username.addActionListener(this);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == username) {
            name = username.getText().trim();
            System.out.println(name);
            if (personDAO.getCaregiver(name) != null) {
                System.out.println("Welcome caregiver");
                dispose();
                WelcomeCaregiverScreen wc = new WelcomeCaregiverScreen(name);
            } else if (personDAO.getEducator(name) != null) {
                dispose();
                WelcomeEducatorScreen we = new WelcomeEducatorScreen(name);
                System.out.println("Welcome educator");
            } else if (personDAO.getAdministrator(name) != null) {
                dispose();
                WelcomeAdministratorScreen wa = new WelcomeAdministratorScreen(name);
                System.out.println("Welcome administrator");
            } else {
                info.setText("Var god försök igen");
                username.setText(" ");
                System.out.println("Försok igen");
            }
        }
    }

    public static void main(String[] args) {
        LogInScreen ls = new LogInScreen();
    }
}
