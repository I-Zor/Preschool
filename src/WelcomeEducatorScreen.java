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
 * Time: 20:34
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class WelcomeEducatorScreen extends JFrame implements ActionListener {

    protected Database d = new Database();

    protected PersonDAO personDAO = d;

    JPanel p = new JPanel();

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
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.setBorder(new EmptyBorder(50, 50, 50, 50));

        p.add(welcome);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcome.setText("Välkommen " + educator.getFirstName());

        p.add(Box.createRigidArea(new Dimension(500,10)));

        p.add(choose);
        choose.setAlignmentX(Component.CENTER_ALIGNMENT);

        p.add(Box.createRigidArea(new Dimension(500,10)));

        p.add(absence);
        absence.setAlignmentX(Component.CENTER_ALIGNMENT);

        absence.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AbsenceScreen ac = new AbsenceScreen(educator);
            }
        });

        p.add(Box.createRigidArea(new Dimension(500,10)));

        p.add(attendance);
        attendance.setAlignmentX(Component.CENTER_ALIGNMENT);

        attendance.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AttendanceScreen attendance = new AttendanceScreen(group);
            }
        });

        p.add(Box.createRigidArea(new Dimension(500,10)));

        p.add(caringTime);
        caringTime.setAlignmentX(Component.CENTER_ALIGNMENT);

        caringTime.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CaringTimeInfoScreen info = new CaringTimeInfoScreen(group);
            }
        });
        p.add(Box.createRigidArea(new Dimension(500,10)));

        p.add(caregiver);
        caregiver.setAlignmentX(Component.CENTER_ALIGNMENT);

        p.add(Box.createRigidArea(new Dimension(500,10)));

        p.add(questionCareg);
        questionCareg.setAlignmentX(Component.CENTER_ALIGNMENT);


        caregiver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                questionCareg.setText("Vilket barn?");
            }
        });

        p.add(Box.createRigidArea(new Dimension(500,10)));

        p.add(answerCaregiver);
        answerCaregiver.setAlignmentX(Component.CENTER_ALIGNMENT);
        answerCaregiver.setPreferredSize(new Dimension(200,50));
        answerCaregiver.setMaximumSize(new Dimension(200,50));

        answerCaregiver.addActionListener(this);

        p.add(Box.createRigidArea(new Dimension(500,10)));

        p.add(caregiverInfo);
        caregiverInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        caregiverInfo.setPreferredSize(new Dimension(200,50));
        caregiverInfo.setMaximumSize(new Dimension(200,50));

        p.add(Box.createRigidArea(new Dimension(500,10)));

        p.add(relative);
        relative.setAlignmentX(Component.CENTER_ALIGNMENT);

        p.add(Box.createRigidArea(new Dimension(500,10)));

        p.add(questionRelative);
        questionRelative.setAlignmentX(Component.CENTER_ALIGNMENT);

        relative.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                questionRelative.setText("Vilket barn?");
            }
        });
        p.add(Box.createRigidArea(new Dimension(500,10)));

        p.add(answerRelative);
        answerRelative.setPreferredSize(new Dimension(400,50));
        answerRelative.setMaximumSize(new Dimension(400,50));

        answerRelative.setAlignmentX(Component.CENTER_ALIGNMENT);

        answerRelative.addActionListener(this);
        p.add(Box.createRigidArea(new Dimension(500,10)));

        p.add(relativeInfo);
        relativeInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        relativeInfo.setPreferredSize(new Dimension(400,50));
        relativeInfo.setMaximumSize(new Dimension(400,50));

        p.add(Box.createRigidArea(new Dimension(500,10)));

        p.add(exit);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                LogInScreen ls = new LogInScreen();
            }
        });
        p.add(Box.createRigidArea(new Dimension(500,10)));

        p.add(clean);
        clean.setAlignmentX(Component.CENTER_ALIGNMENT);

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

        setSize(1000, 600);
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
