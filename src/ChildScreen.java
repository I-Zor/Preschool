import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-17
 * Time: 09:28
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class ChildScreen extends JFrame {

    protected Database d = new Database();
    protected AttendanceDAO attendanceDAO = d;
    protected DatabaseDAO databaseDAO = d;
    protected PersonDAO personDAO = d;

    Child child;
    Caregiver caregiver;

    JPanel p = new JPanel();
    JPanel lower = new JPanel();
    JLabel welcomeInfo = new JLabel();
    JLabel info = new JLabel();
    JLabel info2 = new JLabel();
    JLabel chooseInfo = new JLabel("Välj en av alternativerna");
    JButton caringTime = new JButton("Omsorgstider");
    JButton attendance = new JButton("Registrera frånvaro");
    JLabel attendanceInfo = new JLabel();
    JButton educators = new JButton("Se pedagogers kontaktuppgifter");
    JLabel educatorsInfo = new JLabel();
    JButton returnToStartpage = new JButton("Tillbaka till start sidan");

    public ChildScreen(Child child, Caregiver caregiver) {
        this.child = child;
        this.caregiver = caregiver;

        add(p);
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.setBorder(new EmptyBorder(50, 50, 50, 50));
        p.add(welcomeInfo);
        welcomeInfo.setText("Välkommen till sidan för " + child.getFirstName() + " " + child.getLastName());
        p.add(Box.createRigidArea(new Dimension(500,50)));
        welcomeInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(info);
        info.setText(child.getChildGroup().getGroupName());
        p.add(Box.createRigidArea(new Dimension(500,20)));
        p.add(info2);
        info2.setText("Pedagoger: " + child.getChildGroup().printEducators());
        info2.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createRigidArea(new Dimension(500,20)));
        p.add(chooseInfo);
        chooseInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createRigidArea(new Dimension(500,20)));
        p.add(caringTime);
        caringTime.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CaringTimeScreen ct = new CaringTimeScreen(child);
            }
        });
        caringTime.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createRigidArea(new Dimension(500,20)));

        p.add(attendance);
        attendance.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createRigidArea(new Dimension(500,20)));

        p.add(educators);
        educators.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createRigidArea(new Dimension(500,20)));

        p.add(returnToStartpage);
        returnToStartpage.setAlignmentX(Component.CENTER_ALIGNMENT);

        educators.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                educatorsInfo.setText(child.getChildGroup().printEducatorInfo());
            }
        });
        p.add(Box.createRigidArea(new Dimension(500,20)));


        attendance.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                attendanceInfo.setText("Registrerat frånvaro för " + child.getFirstName() + " " + LocalDate.now());
                attendanceDAO.addAbsence(child);
                d.serialize(attendanceDAO.getAttendanceToday(), SerFiles.ATTENDANCE.serFiles);
            }
        });
        add(lower);
        lower.setBorder(new EmptyBorder(50, 50, 50, 50));
        lower.setLayout(new GridLayout(2,1));
        lower.add(attendanceInfo);

        lower.add(educatorsInfo);


        returnToStartpage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                WelcomeCaregiverScreen wcs = new WelcomeCaregiverScreen(caregiver.getUsername());
            }
        });

        Container contentPane = getContentPane();
        contentPane.add(p, BorderLayout.CENTER);
        contentPane.add(lower, BorderLayout.PAGE_END);


        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
