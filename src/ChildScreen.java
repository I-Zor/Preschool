import javax.swing.*;
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

    String childName;
    Caregiver caregiver;

    JPanel p = new JPanel();
    JLabel welcomeInfo = new JLabel();
    JLabel info = new JLabel();
    JLabel chooseInfo = new JLabel("Välj en av alternativerna");
    JButton caringTime = new JButton("Omsorgstider");
    JButton attendance = new JButton("Registrera frånvaro");
    JLabel attendanceInfo = new JLabel();
    JButton educators = new JButton("Se pedagogers kontaktuppgifter");
    JLabel educatorsInfo = new JLabel();
    JButton returnToStartpage = new JButton("Tillbaka till start sidan");

    public ChildScreen(String childName, Caregiver caregiver) {
        this.childName = childName;
        this.caregiver = caregiver;
        Child child = personDAO.getChild(childName);

        add(p);
        p.add(welcomeInfo);
        welcomeInfo.setText("Välkommen till sidan för " + child.getFirstName() + " " + child.getLastName());
        p.add(info);
        info.setText(child.getChildGroup().getGroupName() + "\n" +
                "Pedagoger: " + child.getChildGroup().printEducators());

        p.add(chooseInfo);
        p.add(caringTime);
        caringTime.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CaringTimeScreen ct = new CaringTimeScreen(child);
            }
        });

        p.add(attendance);
        attendance.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                attendanceInfo.setText("Registrerat frånvaro för " + child.getFirstName() + " " + LocalDate.now());
                attendanceDAO.addAbsence(child);
                d.serialize(attendanceDAO.getAttendanceToday(), SerFiles.ATTENDANCE.serFiles);
            }
        });
        p.add(attendanceInfo);
        p.add(educators);
        educators.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                educatorsInfo.setText(child.getChildGroup().printEducatorInfo());
            }
        });
        p.add(educatorsInfo);
        p.add(returnToStartpage);
        returnToStartpage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                WelcomeCaregiverScreen wcs = new WelcomeCaregiverScreen(caregiver.getUsername());
            }
        });

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
