import java.util.ArrayList;
import java.util.List;

public class Caregiver extends Person implements IContactInformation {

    private String eMailAddress;
    private String phoneNumber;
    private String postAddress;
    List<Child> children;
    private String username;

    public Caregiver(String firstName, String lastName, String personalNumber) {
        super(firstName, lastName, personalNumber);
        children = new ArrayList<>();
    }

    public void addChildren(Child child){
        children.add(child);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Child> getChildren(){
        return children;
    }
   
    public void setEmailAddress(String emailAddress) {
        this.eMailAddress = emailAddress;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    @Override
    public String getEmailAddress() {
        return eMailAddress;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getPostAddress() {
        return postAddress;
    }

}
