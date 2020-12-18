import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-18
 * Time: 10:08
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class AttendanceScreen extends JFrame {

    protected Database d = new Database();

    protected PersonDAO personDAO = d;
    protected AttendanceDAO attendanceDAO = d;
    protected DatabaseDAO databaseDAO = d;

    ChildGroup group;
    List<Child> childList;
    List<Attendance> attendanceList;
    Educator educator;

    JPanel p = new JPanel();
    JButton all = new JButton("Alla barn");
    JTextArea allChildren = new JTextArea();
    JButton attendant = new JButton("Närvarande barn");
    JTextArea attendantChildren = new JTextArea();
    JButton absent = new JButton("Frånvarande barn");
    JTextArea absentChildren = new JTextArea();
    JButton exit = new JButton("Tillbaka till startsidan");


    public AttendanceScreen(ChildGroup group) {
        this.group = group;
        childList = group.getEnrolledChildren();
        attendanceList = attendanceDAO.getAttendanceToday();
        educator = group.getResponsibleEducators().get(0);
        System.out.println(educator.getFirstName());

        add(p);
        p.setLayout(new GridLayout(7, 1));
        p.add(all);

        all.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                allChildren.append("Narvarö " + LocalDate.now() + "\n");
                printAllChildren();
            }
        });

        p.add(allChildren);
        allChildren.setPreferredSize(new Dimension(50, 100));

        p.add(attendant);
        attendant.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                attendantChildren.append("Närvarande " + LocalDate.now());
                attendantChildren.append(printPresent());
            }
        });

        p.add(attendantChildren);
        attendantChildren.setPreferredSize(new Dimension(50, 100));
        p.add(absent);
        p.add(absentChildren);
        absentChildren.setPreferredSize(new Dimension(50, 100));
        p.add(exit);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    //TODO: rijesiti izlistavanje närvaro!!!

    private String printPresent() {
        String result = "";
        for (Attendance a : attendanceList) {
            if (a.getPresent())
                result = a.getChild().getFirstName() + " " + a.getChild().getLastName() + "\n";
        }
        return result;
    }

    private void printAllChildren() {
        String present = "";
        for (Attendance a : attendanceList) {
            if (!a.getPresent())
                present = "Frånvarande";
            else
                present = "Närvarande";
            allChildren.append(a.getChild().getFirstName() + " " + a.getChild().getLastName() +
                    " " + present + "\n");
        }

    }

    private void printTest(){
        String present = "";
        for (Attendance a : attendanceList){
            System.out.println(a.getChild());
            System.out.println(a.getEducatorForChild(a.getChild()));
            if (a.getEducatorForChild(a.getChild()).equals(educator)){
                System.out.println(educator);
                if (!a.getPresent())
                    present = "Frånvarande";
                else
                    present = "Närvarande";
                allChildren.append(a.getChild().getFirstName() + " " + a.getChild().getLastName() +
                        " " + present + "\n");
            }
        }
    }
}

