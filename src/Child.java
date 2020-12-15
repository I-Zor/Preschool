import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Child extends Person  {

    private List<Caregiver> caregivers;
    private List<CaringTime> caringTimes = new ArrayList<>();
    private String postAddress;
    private List<Relative> relatives;
    private ChildGroup childGroup;

    Child(String firstName, String lastName, String personalNumber) {
        super(firstName, lastName, personalNumber);
        caregivers = new ArrayList<>();
        relatives = new ArrayList<>();
    }

    public void addCaregiver(Caregiver c){
        caregivers.add(c);
    }

    public void addCaringTime(String inputDate, String inputStartTime, String inputStopTime){
        LocalTime start = LocalTime.parse(inputStartTime);
        LocalTime stop = LocalTime.parse(inputStopTime);
        caringTimes.add(new CaringTime(inputDate, start, stop));
    }

    public List<Caregiver> getCaregivers() {
        return caregivers;
    }

    public void setCaregivers(List<Caregiver> caregivers) {
        this.caregivers = caregivers;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public List<CaringTime> getCaringTimes() {
        return caringTimes;
    }

    public void setCaringTimes(List<CaringTime> caringTimes) {
        this.caringTimes = caringTimes;
    }

    public List<Relative> getRelatives() {
        return relatives;
    }

    public void addRelative(Relative relative){
        relatives.add(relative);
    }

    public ChildGroup getChildGroup() {
        return childGroup;
    }

    public void setChildGroup(ChildGroup childGroup) {
        this.childGroup = childGroup;
    }
}
