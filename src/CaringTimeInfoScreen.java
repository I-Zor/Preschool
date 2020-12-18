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
 * Time: 10:13
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class CaringTimeInfoScreen extends JFrame implements ActionListener {

    protected Database d = new Database();
    protected AttendanceDAO attendanceDAO = d;
    protected DatabaseDAO databaseDAO = d;
    protected PersonDAO personDAO = d;

    ChildGroup group;
    List<Child> childList;

    JPanel p = new JPanel();
    JLabel choose = new JLabel("Välj barn");
    JTextArea info = new JTextArea();
    JButton clean = new JButton("Rensa");
    JButton exit = new JButton("Sluta");


    public CaringTimeInfoScreen(ChildGroup group) {
        this.group = group;
        childList = group.getEnrolledChildren();

        add(p);
        p.setLayout(new GridLayout(4, 1));
        p.add(choose);

        for (Child c : childList) {
            JButton button = new JButton(c.getFirstName() + " " + c.getLastName());
            button.addActionListener(this);
            p.add(button);
        }

        p.add(info);
        info.setPreferredSize(new Dimension(50,100));
        p.add(clean);
        clean.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                info.selectAll();
                info.replaceSelection("");
            }
        });

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
        JButton button = (JButton) e.getSource();
        String name = button.getText().trim();
        String firstName = name.substring(0, name.indexOf(" "));
        String secondName = name.substring(name.indexOf(" ") + 1);
        for (Child c : childList) {
            if (c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(secondName)) {
                for (CaringTime ct : c.getCaringTimes()) {
                    info.append(ct.getDay() + ": " + ct.getStart() + " - " + ct.getStop() + "\n");
                }
            }
        }
    }
}
