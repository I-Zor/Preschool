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

    private final Database d = new Database();

    private PersonDAO personDAO = d;


    JPanel welcomeScreen = new JPanel();
  //  JPanel logInScreen = new JPanel();
    JLabel title = new JLabel("Välkommen till förskolan!");
    JLabel logIninput = new JLabel("Skriv ditt användarnamn");
    JTextField username = new JTextField(20);

    String name;
  //  JButton caregiver = new JButton("Vårdnadshavare");
  //  JButton educator = new JButton("Pedagog");
  //  JButton endProgram = new JButton("Avsluta programmet");
  //  int input = 0;

  /*  JLabel usernameInput = new JLabel("Skriv ditt namn:");
    JTextField username = new JTextField();*/

   public LogInScreen(){
        add(welcomeScreen);
        welcomeScreen.setLayout(new GridLayout(4,1));
        welcomeScreen.add(title);
        welcomeScreen.add(logIninput);
        welcomeScreen.add(username);

        username.addActionListener(this);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

 /*   public void showLogInScreen(){
        add(logInScreen);
        logInScreen.add(usernameInput, BorderLayout.NORTH);
        logInScreen.add(username, BorderLayout.CENTER);

        username.addActionListener(this);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==username){
            name = username.getText();
            Caregiver caregiver = personDAO.getCaregiver(name);
            Educator educator = personDAO.getEducator(name);
            Administrator administrator = personDAO.getAdministrator(name);
            if (name.equals(caregiver.getUsername())){
                WelcomeCaregiverScreen wc = new WelcomeCaregiverScreen(name);
            }
        }
    }
}
