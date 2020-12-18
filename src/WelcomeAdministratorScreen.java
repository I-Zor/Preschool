import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-16
 * Time: 20:35
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class WelcomeAdministratorScreen extends JFrame {

    protected Database d = new Database();
    protected AttendanceDAO attendanceDAO = d;
    protected DatabaseDAO databaseDAO = d;
    protected PersonDAO personDAO = d;

    String name;
    Administrator admin;

    JPanel upper = new JPanel();
    JLabel welcome = new JLabel();
    JLabel choose = new JLabel("Välj aktivitet");
    JButton registerChild = new JButton("Registrera nytt barn");
    JButton registerEducator = new JButton("Registrera ny pedagog");

    JPanel lower = new JPanel();
    JLabel caregiverQ = new JLabel();
    JTextField caregiverA = new JTextField(20);
    JLabel info = new JLabel();
    JLabel secondNameQ = new JLabel();
    JTextField secondNameA = new JTextField(20);
    JLabel caregiverPN = new JLabel();
    JTextField pnAnswer = new JTextField(20);
    JLabel emailQ = new JLabel();
    JTextField emailA = new JTextField(20);
    JLabel telefonQ = new JLabel();
    JTextField telefonA = new JTextField(20);
    JLabel addressQ = new JLabel();
    JTextField addressA = new JTextField(20);

    JLabel childNameQ = new JLabel();
    JTextField childNameA = new JTextField(20);
    JLabel childSecondNameQ = new JLabel();
    JTextField childSecondNameA = new JTextField(20);
    JLabel childPnQ = new JLabel();
    JTextField childPnA = new JTextField(20);
    JLabel group = new JLabel();
    JTextField groupName = new JTextField(20);

    JButton register = new JButton("Registrera");

    public WelcomeAdministratorScreen(String name) {
        this.name = name;
        admin = personDAO.getAdministrator(name);

        add(upper, BorderLayout.NORTH);
        upper.setLayout(new GridLayout(3, 2));
        upper.add(welcome);
        welcome.setText("Välkommen " + admin.getFirstName());
        upper.add(choose);
        upper.add(registerChild);
        upper.add(registerEducator);

        add(lower, BorderLayout.CENTER);
        lower.setLayout(new GridLayout(12, 2));
        lower.add(caregiverQ);
        lower.add(caregiverA);
        lower.add(info);
        lower.add(secondNameQ);
        lower.add(secondNameA);
        lower.add(caregiverPN);
        lower.add(pnAnswer);
        lower.add(emailQ);
        lower.add(emailA);
        lower.add(telefonQ);
        lower.add(telefonA);
        lower.add(addressQ);
        lower.add(addressA);
        lower.add(childNameQ);
        lower.add(childNameA);
        lower.add(childSecondNameQ);
        lower.add(childSecondNameA);
        lower.add(childPnQ);
        lower.add(childPnA);
        lower.add(register);
        lower.add(group);
        lower.add(groupName);

        //TODO: dodati användarnamn
        //TODO:dodati sluta sa spremanjem ser.filer

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String firstName = caregiverA.getText();
                String lastName = secondNameA.getText();
                String personalNumber = pnAnswer.getText();
                String email = emailA.getText();
                String phoneNumber = telefonA.getText();
                String address = addressA.getText();
                Caregiver caregiver = new Caregiver(firstName, lastName, personalNumber);
                caregiver.setEmailAddress(email);
                caregiver.setPhoneNumber(phoneNumber);
                caregiver.setPostAddress(address);

                String firstNameChild = childNameA.getText();
                String lastNameChild = childSecondNameA.getText();
                String personalNumberChild = childPnA.getText();
                Child child = new Child(firstNameChild, lastNameChild, personalNumberChild);
                String group = groupName.getText();
                for (ChildGroup cg : databaseDAO.getDepartments()) {
                    if (group.equalsIgnoreCase(cg.getGroupName()))
                        child.setChildGroup(cg);
                }
                databaseDAO.addChild(child);
                child.addCaregiver(caregiver);
                caregiver.addChildren(child);
                attendanceDAO.addChildInAttendance(child);
            }
        });

        registerChild.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                caregiverQ.setText("Vem är vårdnadshavare?");
                info.setText("Denna vårdnadshavare finns inte registrerad");
                secondNameQ.setText("Ange vårdnadhavarens efternamn: ");
                caregiverPN.setText("Ange vårdnadshavarens personnummer: ");
                emailQ.setText("Ange vårdnadshavarens e-mail: ");
                telefonQ.setText("Ange vårdnadshavarens telefonnummer: ");
                addressQ.setText("Ange vårdnadshavarens adress: ");
                childNameQ.setText("Ange barnets förnamn: ");
                childSecondNameQ.setText("Ange barnets efternamn: ");
                childPnQ.setText("Ange barnets personnummer: ");
                group.setText("Avdelning");
            }
        });


        //TODO: prijava novog djeteta i vårdnadshavare
        //TODO: prijava nogo pedagoga
        //TODO: *ändra pedagogers uppgifter*
    }
}
