
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vilma Couturier Kaijser
 * Date: 2020-11-30
 * Project: Preeschool
 * Copyright: MIT
 */

public class Caregiver extends Person implements IContactInformation, Serializable {

    private String eMailAddress;
    private String phoneNumber;
    private String postAddress;
    List<Child> children;

    public Caregiver(String firstName, String lastName, String personalNumber) {
        super(firstName, lastName, personalNumber);
        children = new ArrayList<Child>();
    }

    public void addChildren(Child child){
        children.add(child);
    }

    public Child getChild(Child child){
        for(Child c: children){
            if(c.equals(child)){
                return c;
            }
        } return null;
    }

    public void registerCaringTime(Child child, String day, String start, String stop){
        // kommer hit från nån loop kanske så man kan ange flera dagar på rad
        child.addCaringTime(day, start, stop);
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
