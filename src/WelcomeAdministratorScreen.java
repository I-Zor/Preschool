import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-16
 * Time: 20:35
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class WelcomeAdministratorScreen extends JFrame {

    protected Database d = new Database();
    protected AttendanceDAO attendanceDAO = d;
    protected DatabaseDAO databaseDAO = d;
    protected PersonDAO personDAO = d;

    String name;
    Administrator admin;

    JPanel p = new JPanel();
    JLabel welcome = new JLabel();
    JLabel choose = new JLabel("Välj aktivitet");
    JButton registerChild = new JButton("Registrera nytt barn");
    JButton exit = new JButton("Logga ut");


    public WelcomeAdministratorScreen(String name) {
        this.name = name;
        admin = personDAO.getAdministrator(name);
//        add(p);
//        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
//        p.setBorder(new EmptyBorder(50, 50, 50, 50));
//        p.add(welcome);
//        p.add(Box.createRigidArea(new Dimension(500,50)));
//        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
//        welcome.setText("Välkommen " + personDAO.getCaregiver(name).getFirstName());
//        p.add(Box.createRigidArea(new Dimension(500,50)));
//        p.add(choose);
//        choose.setAlignmentX(Component.CENTER_ALIGNMENT);
//        p.add(Box.createRigidArea(new Dimension(500,50)));
//
//        p.add(exit);
//        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
//        exit.setPreferredSize(new Dimension(200,50));
//        exit.setMaximumSize(new Dimension(200,50));
//
//        exit.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                LogInScreen ls = new LogInScreen();
//                dispose();
//            }
//        });
//
//        setSize(1000, 600);
//        setLocationRelativeTo(null);
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(p);
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.setBorder(new EmptyBorder(50, 50, 50, 50));
        p.add(welcome);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcome.setText("Välkommen " + admin.getFirstName());
        p.add(Box.createRigidArea(new Dimension(500,50)));

        p.add(choose);
        choose.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createRigidArea(new Dimension(500,50)));

        p.add(registerChild);
        registerChild.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerChild.setPreferredSize(new Dimension(200,50));
        registerChild.setMaximumSize(new Dimension(200,50));


        registerChild.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterNewChildScreen r = new RegisterNewChildScreen();
            }
        });

        p.add(Box.createRigidArea(new Dimension(500,50)));

        p.add(exit);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setPreferredSize(new Dimension(200,50));
        exit.setMaximumSize(new Dimension(200,50));


        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                LogInScreen ls = new LogInScreen();
            }
        });

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);





    }
}
