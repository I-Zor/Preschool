import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

    JPanel upper = new JPanel();
    JPanel middle = new JPanel();
    JPanel lower = new JPanel();
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
        attendanceList = d.deSerialize("Attendance.ser");
        for (Attendance a: attendanceList){
            System.out.println(a.getPresent());
        }
        educator = group.getResponsibleEducators().get(0);
        System.out.println(educator.getFirstName());

        add(upper);
        upper.setLayout(new GridLayout(1,3));
        upper.add(all);
        upper.add(attendant);
        upper.add(absent);

        add(middle);
        middle.setLayout(new GridLayout(1,3));
        middle.add(allChildren);
        middle.add(attendantChildren);
        middle.add(absentChildren);

        add(lower);
        lower.add(exit);

        all.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                allChildren.append("Narvarö " + LocalDate.now() + "\n");
                printAllChildren();
            }
        });

    //    allChildren.setPreferredSize(new Dimension(50, 200));

        attendant.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                attendantChildren.append("Närvarande " + LocalDate.now() + "\n");
                printPresent();
            }
        });

    //    attendantChildren.setPreferredSize(new Dimension(50, 200));

        absent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                absentChildren.append("Frånvarande " + LocalDate.now());
                printAbsent();
            }
        });
    //    absentChildren.setPreferredSize(new Dimension(50, 200));

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.add(upper, BorderLayout.NORTH);
        contentPane.add(middle, BorderLayout.CENTER);
        contentPane.add(lower,BorderLayout.SOUTH);

    }

    private void printPresent() {
        for (Attendance a : attendanceList) {
            if (a.getPresent())
                attendantChildren.append(a.getChild().getFirstName() + " " + a.getChild().getLastName() + "\n");
        }
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

    private void printAbsent(){
        for (Attendance a : attendanceList) {
            if (!a.getPresent())
                absentChildren.append(a.getChild().getFirstName() + " " + a.getChild().getLastName());
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

