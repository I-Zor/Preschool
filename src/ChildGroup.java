import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-15
 * Time: 10:24
 * Project: Preschool_upgraded
 * Copywrite: MIT
 */
public class ChildGroup implements Serializable {

    private String groupName;
    private List<Educator> responsibleEducators;
    private List<Child> enrolledChildren;
    private int numberOfChildren;

    public ChildGroup(String groupName) {
        this.groupName = groupName;
        responsibleEducators = new ArrayList<>();
        enrolledChildren = new ArrayList<>();
    }

    public void addEducatorToGroup(Educator educator){
        responsibleEducators.add(educator);
    }

    public void addEnrolledChild(Child child){
        enrolledChildren.add(child);
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Educator> getResponsibleEducators() {
        return responsibleEducators;
    }

    public List<Child> getEnrolledChildren() {
        return enrolledChildren;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public String printEducators(){
        for (Educator e : responsibleEducators){
            return e.getFirstName() + " " + e.getLastName() + "\n";
        }
        return null;
    }

    public String printEducatorInfo(){
        for (Educator e : responsibleEducators){
            return e.getFirstName()+" "+e.getLastName()+"\n"+
                    e.getPhoneNumber()+"n"+e.getEmailAddress()+"n";
        }
        return null;
    }
}
