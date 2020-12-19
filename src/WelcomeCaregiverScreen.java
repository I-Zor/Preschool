import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-16
 * Time: 12:52
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class WelcomeCaregiverScreen extends JFrame implements ActionListener{

    protected Database d = new Database();

    protected PersonDAO personDAO = d;

    JPanel p = new JPanel();

    JLabel welcome = new JLabel();
    JLabel choose = new JLabel("Välj barn");
    JButton exit = new JButton("Logga ut");
    String name;
    Caregiver caregiver;



    public WelcomeCaregiverScreen(String name) {
        this.name = name;
        caregiver = personDAO.getCaregiver(name);

        add(p);
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.setBorder(new EmptyBorder(50, 50, 50, 50));
        p.add(welcome);
        p.add(Box.createRigidArea(new Dimension(500,50)));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcome.setText("Välkommen " + personDAO.getCaregiver(name).getFirstName());
        p.add(Box.createRigidArea(new Dimension(500,50)));
        p.add(choose);
        choose.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createRigidArea(new Dimension(500,50)));

        for (Child c : caregiver.getChildren()){
            JButton child = new JButton(c.getFirstName());
            child.addActionListener(this);
            child.setPreferredSize(new Dimension(200,50));
            child.setMaximumSize(new Dimension(200,50));
            child.setAlignmentX(Component.CENTER_ALIGNMENT);
            p.add(child);
        }

        p.add(Box.createRigidArea(new Dimension(500,50)));
        p.add(exit);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setPreferredSize(new Dimension(200,50));
        exit.setMaximumSize(new Dimension(200,50));

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LogInScreen ls = new LogInScreen();
                dispose();
            }
        });

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        for (Child child : caregiver.getChildren()){
            if (button.getText().trim().equals(child.getFirstName().trim())){
                ChildScreen cs = new ChildScreen(child, caregiver);
                System.out.println("Next screen");
                dispose();
            }
        }
    }
}
