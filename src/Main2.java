import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

public class Main2 extends JFrame implements ActionListener {

    private final Database d = new Database();

    private AttendanceDAO attendanceDAO = d;
    private DatabaseDAO databaseDAO = d;
    private PersonDAO personDAO = d;

    JPanel views = new JPanel(new CardLayout());

    JPanel welcomeScreen = new JPanel();
    JPanel logInScreen = new JPanel();
    JPanel caregiversScreen = new JPanel();



    JLabel title = new JLabel("Välkommen till förskolan!");
    JLabel logInas = new JLabel("Logga in som");
    JButton caregiver = new JButton("Vårdnadshavare");
    JButton educator = new JButton("Pedagog");
    JButton endProgram = new JButton("Avsluta programmet");
    int input;

    JLabel usernameInput = new JLabel("Skriv ditt namn:");
    JTextField username = new JTextField(20);
    JLabel info = new JLabel();

    JLabel welcomeCaregiver = new JLabel();
    JLabel chooseChild = new JLabel("Välj barn:");
    JToggleButton child;
    String name;

    public void showWelcomeScreen() {

    //    add(welcomeScreen);
        welcomeScreen.setLayout(new GridLayout(5, 1));
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

    public void showLogInScreen() {
        add(logInScreen);
        logInScreen.add(usernameInput, BorderLayout.NORTH);
        logInScreen.add(username, BorderLayout.CENTER);
        logInScreen.add(info, BorderLayout.SOUTH);

        username.addActionListener(this);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void showCaregiversScreen() {
        add(caregiversScreen);
        caregiversScreen.setLayout(new GridLayout(5,1));
        caregiversScreen.add(welcomeCaregiver);
        welcomeCaregiver.setText("Välkommen "+username.getText());
        caregiversScreen.add(chooseChild);
        name = username.getText();
        Caregiver caregiver = personDAO.getCaregiver(name);
        for (Child child : caregiver.getChildren()) {
            new JToggleButton(child.getFirstName());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == caregiver){
            dispose();
            showLogInScreen();}
        else if (e.getSource() == educator)
            input = 2;
        else if (e.getSource() == endProgram)
            input = 3;
        else if (e.getSource() == username) {
            name = username.getText();
            Caregiver caregiver = personDAO.getCaregiver(name);

            while (caregiver == null) {
                info.setText("Var god försök igen");
                name = username.getText();
                caregiver = personDAO.getCaregiver(name);
            }
            showCaregiversScreen();

        }
    }

    public static void main(String[] args) {
        Main2 m = new Main2();

        m.views.add(m.welcomeScreen);
        m.views.add(m.caregiversScreen);
        m.views.add(m.logInScreen);

        m.showWelcomeScreen();
    }
}


