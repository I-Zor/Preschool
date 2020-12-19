import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-15
 * Time: 15:10
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class LogInScreen extends JFrame implements ActionListener {

    protected Database d = new Database();

    protected PersonDAO personDAO = d;
    protected AttendanceDAO attendanceDAO = d;
    protected DatabaseDAO databaseDAO = d;


    JPanel p = new JPanel();
    JLabel title = new JLabel("Välkommen till förskolan!");
    JLabel logIninput = new JLabel("Skriv ditt användarnamn");
    JTextField username = new JTextField();
    JLabel info = new JLabel();
    JButton exit = new JButton("Sluta programmet");

    String name;

    public LogInScreen() {
        add(p);
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.setBorder(new EmptyBorder(50, 50, 50, 50));
        //        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //        util.setMainBackground(panel);
        //        panel.add(Box.createRigidArea(new Dimension(100, 80)));
        //        panel
        p.add(title);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createRigidArea(new Dimension(500,100)));
        p.add(logIninput);
        logIninput.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createRigidArea(new Dimension(500,30)));
        p.add(username);
        username.setAlignmentX(Component.CENTER_ALIGNMENT);
        username.setPreferredSize(new Dimension(200,30));
        username.setMaximumSize(new Dimension(200,20));
        p.add(Box.createRigidArea(new Dimension(500,30)));
        p.add(info);
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createRigidArea(new Dimension(500,200)));
        p.add(exit);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                saveAllFiles();
            }
        });

        username.addActionListener(this);

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void saveAllFiles() {
        attendanceDAO.addAttendanceTodayInList(attendanceDAO.getAttendanceToday());
        d.serialize(attendanceDAO.getAttendanceList(), SerFiles.LIST_OF_ATTENDANCES.serFiles);
        d.serialize(attendanceDAO.getAttendanceToday(), SerFiles.ATTENDANCE.serFiles);
        d.serialize(personDAO.getChildList(), SerFiles.CHILDREN.serFiles);
        d.serialize(personDAO.getEducatorList(), SerFiles.EDUCATOR.serFiles);
        d.serialize(personDAO.getAdministratorList(), "Admin.ser");
        d.serialize(databaseDAO.getDepartments(),"Departments.ser");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == username) {
            name = username.getText().trim();
            System.out.println(name);
            if (personDAO.getCaregiver(name) != null) {
                System.out.println("Welcome caregiver");
                dispose();
                WelcomeCaregiverScreen wc = new WelcomeCaregiverScreen(name);
            } else if (personDAO.getEducator(name) != null) {
                dispose();
                WelcomeEducatorScreen we = new WelcomeEducatorScreen(name);
                System.out.println("Welcome educator");
            } else if (personDAO.getAdministrator(name) != null) {
                dispose();
                WelcomeAdministratorScreen wa = new WelcomeAdministratorScreen(name);
                System.out.println("Welcome administrator");
            } else {
                info.setText("Var god försök igen");
                username.setText(" ");
                System.out.println("Försok igen");
            }
        }
    }

    public static void main(String[] args) {
        LogInScreen ls = new LogInScreen();
    }
}
