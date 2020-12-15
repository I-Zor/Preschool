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
public class GUI extends JFrame implements ActionListener {

    JPanel welcomeScreen = new JPanel();
    JPanel logInScreen = new JPanel();
    /*System.out.println("Välkommen till förskolan!" + "\nLOGGA IN SOM"
                    + "\n 1. Vårdnadshavare" + "\n 2. Pedagog" + "\n 3. Avsluta programmet");*/
    JLabel title = new JLabel("Välkommen till förskolan!");
    JLabel logInas = new JLabel("Logga in som");
    JButton caregiver = new JButton("Vårdnadshavare");
    JButton educator = new JButton("Pedagog");
    JButton endProgram = new JButton("Avsluta programmet");
    int input = 0;

    JLabel usernameInput = new JLabel("Skriv ditt namn:");
    JTextField username = new JTextField();

    public void showWelcomeScreen(){
        add(welcomeScreen);
        welcomeScreen.setLayout(new GridLayout(5,1));
        welcomeScreen.add(title);
        welcomeScreen.add(logInas);
        welcomeScreen.add(caregiver);
        welcomeScreen.add(educator);
        welcomeScreen.add(endProgram);

        caregiver.addActionListener(this);
        educator.addActionListener(this);
        endProgram.addActionListener(this);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void showLogInScreen(){
        add(logInScreen);
        logInScreen.add(usernameInput, BorderLayout.NORTH);
        logInScreen.add(username, BorderLayout.CENTER);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==caregiver)
            input = 1;
        else if (e.getSource()==educator)
            input = 2;
        else if (e.getSource()==endProgram)
            input = 3;
    }
}
