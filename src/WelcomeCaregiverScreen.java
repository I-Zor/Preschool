import javax.swing.*;
import java.awt.*;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-16
 * Time: 12:52
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class WelcomeCaregiverScreen extends JFrame {

    protected Database d = new Database();

    protected PersonDAO personDAO = d;
    protected AttendanceDAO attendanceDAO = d;
    protected DatabaseDAO databaseDAO = d;

    JPanel p = new JPanel();


    JLabel welcome = new JLabel();
    JLabel choose = new JLabel("Vad vill du göra?");
    JRadioButton child = new JRadioButton("Barn");
    JRadioButton changeData = new JRadioButton("Ändra uppgifter");
    ButtonGroup bg = new ButtonGroup();
    String name;

    public WelcomeCaregiverScreen(String name){
        this.name = name;

        add(p);
        p.setLayout(new GridLayout(5,1));
        p.add(welcome);
        welcome.setText("Välkommen " +personDAO.getCaregiver(name).getFirstName());
        p.add(choose);
        p.add(child);
        p.add(changeData);
        bg.add(child); bg.add(changeData);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
