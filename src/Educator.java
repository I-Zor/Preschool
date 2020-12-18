/**
 * Created by Sara Carlsson
 * Date: 30/11/2020
 * Time:20:39
 * Project: Preeschool
 * Copywright: MIT
 */
public class Educator extends Person implements IContactInformation {

    private String eMailAddress;
    private String phoneNumber;
    private String postAddress;
    private String position;
    private String username;
    private ChildGroup childGroup;

    Educator(String firstName, String lastName, String personalNumber) {
        super(firstName, lastName, personalNumber);
    }

    @Override
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


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ChildGroup getChildGroup() {
        return childGroup;
    }

    public void setChildGroup(ChildGroup childGroup) {
        this.childGroup = childGroup;
    }
}
