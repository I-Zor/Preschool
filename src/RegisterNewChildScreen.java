import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-19
 * Time: 10:09
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class RegisterNewChildScreen extends JFrame{

    protected Database d = new Database();
    protected AttendanceDAO attendanceDAO = d;
    protected DatabaseDAO databaseDAO = d;
    protected PersonDAO personDAO = d;


    JPanel p = new JPanel();
    JLabel caregiverQ = new JLabel("Vem är vårdnadshavare?");
    JTextField caregiverA = new JTextField(20);
    JButton check = new JButton("Check");
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
    JLabel username = new JLabel();
    JTextField usernameInput = new JTextField(20);

    JLabel childNameQ = new JLabel();
    JTextField childNameA = new JTextField(20);
    JLabel childSecondNameQ = new JLabel();
    JTextField childSecondNameA = new JTextField(20);
    JLabel childPnQ = new JLabel();
    JTextField childPnA = new JTextField(20);
    JLabel childAddressQ = new JLabel();
    JTextField childAddressA = new JTextField(20);
    JLabel group = new JLabel();
    JTextField groupName = new JTextField(20);

    JButton registerNew = new JButton("Registrera nytt");
    JButton update = new JButton("Uppdatera");
    JButton exit = new JButton("Sluta");

    String inputCaregiversName;
    List<ChildGroup> childGroupList;

    public RegisterNewChildScreen() {

        childGroupList = databaseDAO.getDepartments();

        add(p);
        p.setLayout(new GridLayout(12, 2));
        p.add(caregiverQ);
        p.add(caregiverA);
        p.add(check);
        check.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inputCaregiversName = caregiverA.getText().trim();
     //           boolean found = true;
                for (Caregiver caregiver : personDAO.getCaregiverList()) {
                    System.out.println(caregiver.getFirstName());
                    if (inputCaregiversName.equalsIgnoreCase(caregiver.getFirstName())) {
                        childNameQ.setText("Ange barnets förnamn: ");
                        childSecondNameQ.setText("Ange barnets efternamn: ");
                        childPnQ.setText("Ange barnets personnummer: ");
                        childAddressQ.setText("Ange barnets postadress");
                        group.setText("Avdelning");
                        //                    found = true;
                        //                else
                        //                    found = false;
                    } else {
                        //            if (!found){
                        info.setText("Denna vårdnadshavare finns inte registrerad");
                        secondNameQ.setText("Ange vårdnadhavarens efternamn: ");
                        caregiverPN.setText("Ange vårdnadshavarens personnummer: ");
                        emailQ.setText("Ange vårdnadshavarens e-mail: ");
                        telefonQ.setText("Ange vårdnadshavarens telefonnummer: ");
                        addressQ.setText("Ange vårdnadshavarens adress: ");
                        username.setText("Ange användarnamn");
                        childNameQ.setText("Ange barnets förnamn: ");
                        childSecondNameQ.setText("Ange barnets efternamn: ");
                        childPnQ.setText("Ange barnets personnummer: ");
                        childAddressQ.setText("Ange barnets postadress");
                        group.setText("Avdelning");

                    }
                }


            }
        });
        p.add(info);
        p.add(secondNameQ);
        p.add(secondNameA);
        p.add(caregiverPN);
        p.add(pnAnswer);
        p.add(emailQ);
        p.add(emailA);
        p.add(telefonQ);
        p.add(telefonA);
        p.add(addressQ);
        p.add(addressA);
        p.add(username);
        p.add(usernameInput);
        p.add(childNameQ);
        p.add(childNameA);
        p.add(childSecondNameQ);
        p.add(childSecondNameA);
        p.add(childPnQ);
        p.add(childPnA);
        p.add(childAddressQ);
        p.add(childAddressA);
        p.add(group);
        p.add(groupName);
        p.add(registerNew);
        p.add(update);

        update.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String firstNameChild = childNameA.getText();
                String lastNameChild = childSecondNameA.getText();
                String personalNumberChild = childPnA.getText();
                String addressChild = childAddressA.getText();
                Child child = new Child(firstNameChild, lastNameChild, personalNumberChild);
                databaseDAO.addChild(child);

                String groupNameText = groupName.getText().trim();
                for (ChildGroup cg : childGroupList) {
                    System.out.println(cg.getGroupName());
                    if (groupNameText.equalsIgnoreCase(cg.getGroupName())){
                        child.setChildGroup(cg);
                        System.out.println(child.getChildGroup().getGroupName());
                        cg.addEnrolledChild(child);
                    }
                    else
                        System.out.println("Denna grupp finns inte");
                }
                child.setPostAddress(addressChild);
                for (Caregiver caregiver : personDAO.getCaregiverList()) {
                    if (caregiver.getFirstName().equalsIgnoreCase(inputCaregiversName)) {
                        System.out.println("Det nya barnet kommer att registreras på den redan " +
                                "\nexisterande vårdnadshavaren " + caregiver.getFirstName() + " " + caregiver.getLastName());

                        child.addCaregiver(caregiver);
                        caregiver.addChildren(child);
                        attendanceDAO.addChildInAttendance(child);
                    }
                }

                info.setText("");
                secondNameQ.setText("");
                caregiverPN.setText("");
                emailQ.setText("");
                telefonQ.setText(" ");
                addressQ.setText(" ");
                username.setText("");
                childNameQ.setText("");
                childSecondNameQ.setText("");
                childPnQ.setText("");
                childAddressQ.setText("");
                group.setText("");
                caregiverA.setText("");
                secondNameA.setText("");
                pnAnswer.setText("");
                emailA.setText("");
                telefonA.setText("");
                addressA.setText("");
                usernameInput.setText("");
                childNameA.setText("");
                childSecondNameA.setText("");
                childPnA.setText("");
                childAddressA.setText("");
                groupName.setText("");

                System.out.println("Registrerad!");

                saveAllFiles();


            }
        });
        p.add(exit);

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

        registerNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String firstName = caregiverA.getText();
                String lastName = secondNameA.getText();
                String personalNumber = pnAnswer.getText();
                String email = emailA.getText();
                String phoneNumber = telefonA.getText();
                String address = addressA.getText();
                String ui = usernameInput.getText();
                Caregiver caregiver = new Caregiver(firstName, lastName, personalNumber);
                databaseDAO.addCaregiver(caregiver);
                caregiver.setEmailAddress(email);
                caregiver.setPhoneNumber(phoneNumber);
                caregiver.setPostAddress(address);
                caregiver.setUsername(ui);

                String firstNameChild = childNameA.getText();
                String lastNameChild = childSecondNameA.getText();
                String personalNumberChild = childPnA.getText();
                String addressChild = childAddressA.getText();
                Child child = new Child(firstNameChild, lastNameChild, personalNumberChild);
                databaseDAO.addChild(child);
                child.setPostAddress(addressChild);

                String groupNameText = groupName.getText();
                for (ChildGroup cg : databaseDAO.getDepartments()) {
                    if (groupNameText.equalsIgnoreCase(cg.getGroupName())) {
                        child.setChildGroup(cg);
                        cg.addEnrolledChild(child);
                    }
                    else
                        System.out.println("Denna grupp finns inte");
                }
                child.addCaregiver(caregiver);
                caregiver.addChildren(child);
                attendanceDAO.addChildInAttendance(child);

                info.setText("");
                secondNameQ.setText("");
                caregiverPN.setText("");
                emailQ.setText("");
                telefonQ.setText(" ");
                addressQ.setText(" ");
                username.setText("");
                childNameQ.setText("");
                childSecondNameQ.setText("");
                childPnQ.setText("");
                childAddressQ.setText("");
                group.setText("");
                caregiverA.setText("");
                secondNameA.setText("");
                pnAnswer.setText("");
                emailA.setText("");
                telefonA.setText("");
                addressA.setText("");
                usernameInput.setText("");
                childNameA.setText("");
                childSecondNameA.setText("");
                childPnA.setText("");
                childAddressA.setText("");
                groupName.setText("");

                System.out.println("Registrerad!");

                saveAllFiles();

            }
        });

        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

   }

    public void saveAllFiles(){
        attendanceDAO.addAttendanceTodayInList(attendanceDAO.getAttendanceToday());
        d.serialize(attendanceDAO.getAttendanceList(), SerFiles.LIST_OF_ATTENDANCES.serFiles);
        d.serialize(attendanceDAO.getAttendanceToday(), SerFiles.ATTENDANCE.serFiles);
        d.serialize(personDAO.getChildList(), SerFiles.CHILDREN.serFiles);
        d.serialize(personDAO.getEducatorList(), SerFiles.EDUCATOR.serFiles);
        d.serialize(personDAO.getAdministratorList(), "Admin.ser");
        d.serialize(databaseDAO.getDepartments(),"Departments.ser");
    }

}
