import javax.swing.*;
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
    JLabel choose = new JLabel("Välj barn eller att ändra uppgifter");
    JButton changeData = new JButton("Ändra uppgifter");
    JButton exit = new JButton("Logga ut");
    String name;
    Caregiver caregiver;


    public WelcomeCaregiverScreen(String name) {
        this.name = name;
        caregiver = personDAO.getCaregiver(name);

        add(p);
        p.setLayout(new GridLayout(6, 1));
        p.add(welcome);
        welcome.setText("Välkommen " + personDAO.getCaregiver(name).getFirstName());
        p.add(choose);

        for (Child c : caregiver.getChildren()){
            JButton child = new JButton(c.getFirstName());
            child.addActionListener(this);
            p.add(child);
        }

        p.add(changeData);
        changeData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                System.out.println("Data");
                CaregiverDataScreen cds = new CaregiverDataScreen(caregiver);
            }
        });

        p.add(exit);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LogInScreen ls = new LogInScreen();
                dispose();
            }
        });

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton child = (JButton) e.getSource();
        ChildScreen cs = new ChildScreen(child.getText(), caregiver);
        System.out.println("Next screen");
        dispose();

    }
}
