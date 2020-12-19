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
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.setBorder(new EmptyBorder(10, 10, 10, 10));
        p.add(choose);
        choose.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createRigidArea(new Dimension(100,10)));

        for (Child c : childList) {
            JButton button = new JButton(c.getFirstName() + " " + c.getLastName());
            button.addActionListener(this);
            p.add(button);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setPreferredSize(new Dimension(200,50));
            button.setMaximumSize(new Dimension(200,50));
        }

        p.add(info);
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.setPreferredSize(new Dimension(200,100));
        info.setMaximumSize(new Dimension(200,100));
        p.add(Box.createRigidArea(new Dimension(100,10)));

        p.add(clean);
        clean.setPreferredSize(new Dimension(200,50));
        clean.setMaximumSize(new Dimension(200,50));

        clean.setAlignmentX(Component.CENTER_ALIGNMENT);

        clean.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                info.selectAll();
                info.replaceSelection("");
            }
        });
        p.add(Box.createRigidArea(new Dimension(400,10)));

        p.add(exit);
        exit.setPreferredSize(new Dimension(200,50));
        exit.setMaximumSize(new Dimension(200,50));

        exit.setAlignmentX(Component.CENTER_ALIGNMENT);

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
