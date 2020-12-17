import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-17
 * Time: 14:11
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class CaringTimeScreen extends JFrame implements ActionListener {

    protected Database d = new Database();
    protected AttendanceDAO attendanceDAO = d;
    protected DatabaseDAO databaseDAO = d;
    protected PersonDAO personDAO = d;

    Child child;

    JPanel p = new JPanel();

    JLabel title = new JLabel();
    JLabel question = new JLabel("Vilken dag vill du ändra?");
    JTextField inputDay = new JTextField(20);
    JLabel instruction = new JLabel();
    JTextField newCaringTime = new JTextField(20);
    JButton end = new JButton("Slut");

    public CaringTimeScreen(Child child) {
        this.child = child;

        add(p);
        p.setLayout(new GridLayout(7, 1));
        p.add(title);
        title.setText("Omsorgstider for " + child.getFirstName());

        showCaringTimes(child);

        p.add(question);
        p.add(inputDay);
        inputDay.addActionListener(this);
        p.add(instruction);
        p.add(newCaringTime);
        newCaringTime.addActionListener(this);
        p.add(end);
        end.addMouseListener(new MouseAdapter() {
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

    public void showCaringTimes(Child child) {
        for (CaringTime ct : child.getCaringTimes()) {
            new JLabel(ct.getDay() + ": " + ct.getStart() + " - " + ct.getStop());
            p.add(new JLabel(ct.getDay() + ": " + ct.getStart() + " - " + ct.getStop()));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inputDay) {
            String day = inputDay.getText();
            if (day.equals("måndag")) {
                instruction.setText("Var god ange lämningstid och hämtningstid på måndag:");
            } else if (day.equals("tisdag")) {
                instruction.setText("Var god ange lämningstid och hämtningstid på tisdag: ");
            } else if (day.equals("onsdag")) {
                instruction.setText("Var god ange lämningstid och hämtningstid på onsdag: ");
            } else if (day.equals("torsdag")) {
                instruction.setText("Var god ange lämningstid och hämtningstid på torsdag: ");
            } else if (day.equals("fredag")) {
                instruction.setText("Var god ange lämningstid och hämtningstid på fredag: ");
            } else {
                instruction.setText("Var god skriv dagen igen: ");
            }

        }
        if (e.getSource() == newCaringTime) {
            String day = inputDay.getText();
            if (day.equals("måndag"))
                createCaringTime(0, child, day);
            else if (day.equals("tisdag"))
                createCaringTime(1, child, day);
            else if (day.equals("onsdag"))
                createCaringTime(2, child, day);
            else if (day.equals("torsdag"))
                createCaringTime(3, child, day);
            else if (day.equals("fredag"))
                createCaringTime(4, child, day);
        }
    }

    public void createCaringTime(int dayNumber, Child child, String day) {
        String time = newCaringTime.getText();
        String start = time.substring(0, time.indexOf(","));
        String stop = time.substring(time.indexOf(",") + 1);
        child.getCaringTimes().set(dayNumber, new CaringTime(day, LocalTime.parse(start), LocalTime.parse(stop)));
    }
}
