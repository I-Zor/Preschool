import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-18
 * Time: 09:14
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class AbsenceScreen extends JFrame implements ActionListener {

    protected Database d = new Database();
    protected AttendanceDAO attendanceDAO = d;
    protected DatabaseDAO databaseDAO = d;
    protected PersonDAO personDAO = d;

    Educator educator;

    JPanel p = new JPanel();
    JLabel choose = new JLabel("Välj barn");
    JLabel result = new JLabel();
    JButton exit = new JButton("Slut");

    public AbsenceScreen(Educator educator){

        this.educator = educator;
        ChildGroup childGroup = educator.getChildGroup();
        List<Child> children = childGroup.getEnrolledChildren();

        add(p);
        p.setLayout(new GridLayout(6,1));
        p.add(choose);

        for (Child c : children){
            JButton child = new JButton(c.getFirstName() + " " + c.getLastName());
            child.addActionListener(this);
            p.add(child);
        }

        p.add(result);
        result.setPreferredSize(new Dimension(400,50));
        result.setMaximumSize(new Dimension(400,50));
        p.add(exit);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
             dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton child = (JButton) e.getSource();
        String s = child.getText();
        String firstName = s.substring(0,s.indexOf(" "));
        System.out.println(firstName);
        Child c = personDAO.getChild(firstName);
        result.setText("Frånvaro registrerad för " + child.getText());
        attendanceDAO.addAbsence(c);
        System.out.println("AbsenceScreen: attendanceDAO.addAbsence()");
        d.serialize(attendanceDAO.getAttendanceToday(), SerFiles.ATTENDANCE.serFiles);

    }
}
