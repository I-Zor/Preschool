import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
/**
 * Created by Ivona Zoricic
 * Date: 2020-12-16
 * Time: 20:35
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class WelcomeAdministratorScreen extends JFrame implements ActionListener {

    protected Database d = new Database();
    protected AttendanceDAO attendanceDAO = d;
    protected DatabaseDAO databaseDAO = d;
    protected PersonDAO personDAO = d;

    String name;
    Administrator admin;
    List<Caregiver> caregiverList;


    JPanel p = new JPanel();
    JLabel welcome = new JLabel();
    JLabel choose = new JLabel("Välj aktivitet");
    JButton registerChild = new JButton("Registrera nytt barn");
    JLabel question = new JLabel();
    JTextField answer = new JTextField();
    JButton exit = new JButton("Logga ut");


    public WelcomeAdministratorScreen(String name) {
        this.name = name;
        admin = personDAO.getAdministrator(name);
        caregiverList = personDAO.getCaregiverList();

        add(p);
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.setBorder(new EmptyBorder(50, 50, 50, 50));
        p.add(welcome);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcome.setText("Välkommen " + admin.getFirstName());
        p.add(Box.createRigidArea(new Dimension(500,20)));

        p.add(choose);
        choose.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createRigidArea(new Dimension(500,20)));

        p.add(registerChild);
        registerChild.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerChild.setPreferredSize(new Dimension(200,50));
        registerChild.setMaximumSize(new Dimension(200,50));


        registerChild.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                question.setText("Vem är vårdnadshavare?");
            }
        });

        answer.addActionListener(this);

        p.add(Box.createRigidArea(new Dimension(500,20)));

        p.add(question);
        question.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(answer);
        answer.setPreferredSize(new Dimension(200,50));
        answer.setMaximumSize(new Dimension(200,50));

        p.add(Box.createRigidArea(new Dimension(500,20)));

        p.add(exit);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setPreferredSize(new Dimension(200,50));
        exit.setMaximumSize(new Dimension(200,50));


        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                LogInScreen ls = new LogInScreen();
            }
        });

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==answer){
            String name = answer.getText().trim();
            String firstName = name.substring(0,name.indexOf(" "));
            String secondName = name.substring(name.indexOf(" ")+1);
            for (Caregiver caregiver : caregiverList){
                if (firstName.equalsIgnoreCase(caregiver.getFirstName()) && secondName.equalsIgnoreCase(caregiver.getLastName())){
                    UpdateScreen us = new UpdateScreen(caregiver);
                }
                else{
                    RegisterNewChildScreen rs = new RegisterNewChildScreen();
                }
            }

        }
    }
}
