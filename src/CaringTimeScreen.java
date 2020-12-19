import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
    JTextArea times = new JTextArea();
    JTextField newCaringTime = new JTextField(20);
    JButton save = new JButton("Spara");
    JButton end = new JButton("Tillbaka till startsidan");

    public CaringTimeScreen(Child child) {
        this.child = child;

        add(p);
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.setBorder(new EmptyBorder(50, 50, 50, 50));

        p.add(title);
        title.setText("Omsorgstider for " + child.getFirstName());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        p.add(Box.createRigidArea(new Dimension(500,30)));
        p.add(times);
        times.setEditable(false);
        times.setPreferredSize(new Dimension(200,100));
        times.setMaximumSize(new Dimension(200,100));
        times.setAlignmentX(Component.CENTER_ALIGNMENT);

        p.add(Box.createRigidArea(new Dimension(500,30)));

        showCaringTimes(child);

        p.add(question);
        question.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createRigidArea(new Dimension(500,30)));

        p.add(inputDay);
        inputDay.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputDay.setPreferredSize(new Dimension(200,50));
        inputDay.setMaximumSize(new Dimension(200,50));
        inputDay.addActionListener(this);

        p.add(Box.createRigidArea(new Dimension(500,30)));

        p.add(instruction);
        instruction.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createRigidArea(new Dimension(500,30)));

        p.add(newCaringTime);
        newCaringTime.setAlignmentX(Component.CENTER_ALIGNMENT);
        newCaringTime.setPreferredSize(new Dimension(200,50));
        newCaringTime.setMaximumSize(new Dimension(200,50));

        p.add(Box.createRigidArea(new Dimension(500,30)));

        p.add(save);
        save.setAlignmentX(Component.CENTER_ALIGNMENT);

        p.add(Box.createRigidArea(new Dimension(500,30)));

        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
                System.out.println("Sparad");
                inputDay.setText("");
            }
        });

        p.add(end);
        end.setAlignmentX(Component.CENTER_ALIGNMENT);

        p.add(Box.createRigidArea(new Dimension(500,30)));


        end.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void showCaringTimes(Child child) {
        for (CaringTime ct : child.getCaringTimes()) {
            times.append(ct.getDay() + ": " + ct.getStart() + " - " + ct.getStop()+"\n");
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
    }

    public void createCaringTime(int dayNumber, Child child, String day) {
        String time = newCaringTime.getText();
        String start = time.substring(0, time.indexOf(","));
        String stop = time.substring(time.indexOf(",") + 1);
        child.getCaringTimes().set(dayNumber, new CaringTime(day, LocalTime.parse(start), LocalTime.parse(stop)));
    }
}
