public class Educator extends Person implements IContactInformation {

    private String eMailAddress;
    private String phoneNumber;
    private String postAddress;
    private String username;

    Educator(String firstName, String lastName, String personalNumber) {
        super(firstName, lastName, personalNumber);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


}
