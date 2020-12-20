import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-20
 * Time: 16:11
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class RelatedPerson implements Serializable {
    private String firstName;
    private String secondName;
    private String relationWithChild;
    private String phoneNumber;
    private String eMailAddress;
    private List<Child> closeChildren = new ArrayList<>();

    public RelatedPerson(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getRelationWithChild() {
        return relationWithChild;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setRelationWithChild(String relationWithChild) {
        this.relationWithChild = relationWithChild;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void seteMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    public List<Child> getCloseChildren() {
        return closeChildren;
    }

    public void addRelatedChild(Child child){
        closeChildren.add(child);
    }
}
