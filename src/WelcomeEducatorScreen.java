import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-16
 * Time: 20:34
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class WelcomeEducatorScreen extends JFrame implements ActionListener {

    protected Database d = new Database();

    protected PersonDAO personDAO = d;

    JPanel p = new JPanel();

    JLabel label;

    JLabel welcome = new JLabel();
    JLabel choose = new JLabel("Välj mellan alternativerna");
    JButton absence = new JButton("Ange frånvaro");
    JButton attendance = new JButton("Se närvaro idag");
    JButton caringTime = new JButton("Se ett barns omsorgstider");
    JButton caregiver = new JButton("Se vårdnadshavares kontaktuppgifter");
    JLabel questionCareg = new JLabel();
    JTextField answerCaregiver = new JTextField(20);
    JTextArea caregiverInfo = new JTextArea();
    JButton relative = new JButton("Se närstående kontaktuppgifter");
    JLabel questionRelative = new JLabel();
    JTextField answerRelative = new JTextField(20);
    JTextArea relativeInfo = new JTextArea();
    JButton exit = new JButton("Logga ut");
    JButton clean = new JButton("Rensa");

    String name;
    Educator educator;
    ChildGroup group;
    List<Child> children;


    public WelcomeEducatorScreen(String name) {
        this.name = name;
        educator = personDAO.getEducator(name);
        group = educator.getChildGroup();
        children = group.getEnrolledChildren();

        add(p);
        p.setLayout(new GridLayout(11, 1));
        p.add(welcome);
        welcome.setText("Välkommen " + educator.getFirstName());
        p.add(choose);
        p.add(absence);

        absence.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AbsenceScreen ac = new AbsenceScreen(educator);
            }
        });

        p.add(attendance);
        attendance.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AttendanceScreen attendance = new AttendanceScreen(group);
            }
        });

        p.add(caringTime);
        caringTime.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CaringTimeInfoScreen info = new CaringTimeInfoScreen(group);
            }
        });

        p.add(caregiver);
        caregiver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                questionCareg.setText("Vilket barn?");
            }
        });

        p.add(answerCaregiver);
        answerCaregiver.addActionListener(this);

        p.add(questionCareg);
        p.add(caregiverInfo);
        caregiverInfo.setPreferredSize(new Dimension(50,50));
        p.add(relative);
        p.add(questionRelative);
        relative.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                questionRelative.setText("Vilket barn?");
            }
        });

        p.add(answerRelative);
        answerRelative.addActionListener(this);

        p.add(relativeInfo);
        relativeInfo.setPreferredSize(new Dimension(50,50));

        p.add(exit);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                LogInScreen ls = new LogInScreen();
            }
        });

        p.add(clean);
        clean.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                caregiverInfo.selectAll();
                caregiverInfo.replaceSelection("");
                relativeInfo.selectAll();
                relativeInfo.replaceSelection("");
                answerCaregiver.setText("");
                answerRelative.setText("");
            }
        });

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //TODO: närvaro idag poseban prozor (sve tri liste na jednom mjestu)

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == answerCaregiver) {
            String name = answerCaregiver.getText().trim();
            String firstName = name.substring(0, name.indexOf(" "));
            String secondName = name.substring(name.indexOf(" ") + 1);
            for (Child c : children) {
                if (c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(secondName)) {
                    List<Caregiver> caregivers = c.getCaregivers();
                    for (Caregiver car : caregivers) {
                        caregiverInfo.append(car.getFirstName() + " " + car.getLastName() + ", " + car.getPhoneNumber() + ", " + car.getEmailAddress()+"\n");
                    }
                }
            }
        }
        if (e.getSource() == answerRelative) {
            String name = answerRelative.getText().trim();
            String firstName = name.substring(0, name.indexOf(" "));
            String secondName = name.substring(name.indexOf(" ") + 1);
            for (Child c : children){
                if (c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(secondName)){
                    List<Relative> relatives = c.getRelatives();
                    for (Relative r : relatives){
                        relativeInfo.append(r.getFirstName()+" "+r.getSecondName()+", "+r.getPhoneNumber()+", "+r.geteMailAddress()+"\n");
                    }
                }
            }


        }
    }
}
