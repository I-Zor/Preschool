import javax.swing.*;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-16
 * Time: 20:34
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class WelcomeEducatorScreen {

    protected Database d = new Database();

    protected PersonDAO personDAO = d;

    JPanel p = new JPanel();

    JLabel welcome = new JLabel();
    JLabel choose = new JLabel("Välj mellan alternativerna");
    JButton absence = new JButton("Ange frånvaro");
    JButton attendance = new JButton("Se närvaro idag");
    JButton caringTime = new JButton("Se ett barns omsorgstider");
    JButton caregiverInfo = new JButton("Se vårdnadshavares kontaktuppgifter");
    JButton relativeInfo = new JButton("Se närstående kontaktuppgifter");

    JButton exit = new JButton("Logga ut");
    String name;
    Educator educator;


    public WelcomeEducatorScreen(String name) {
        this.name = name;
        educator = personDAO.getEducator(name);


        //TODO: frånvaro poseban prozor sa JButtons sa imenima djece.
        // Kad klikne na njega pojavi se tekst da je frånvaro registriran
        //TODO: närvaro idag poseban prozor (sve tri liste na jednom mjestu)
        //TODO: banrs omsorgstider poseban prozor. Klikne na dijete i pojavi se text

    }

}
