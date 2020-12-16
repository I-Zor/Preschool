/**
 * Created by Ivona Zoricic
 * Date: 2020-12-15
 * Time: 14:40
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class Administrator extends Person{

    private String username;

    Administrator(String firstName, String lastName, String personalNumber) {
        super(firstName, lastName, personalNumber);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}