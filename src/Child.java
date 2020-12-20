import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Child extends Person  {

    private List<Caregiver> caregivers;
    protected List<CaringTime> caringTimes = new ArrayList<>();
    private List<RelatedPerson> relatedPeople;

    Child(String firstName, String lastName, String personalNumber) {
        super(firstName, lastName, personalNumber);
        caregivers = new ArrayList<>();
        relatedPeople = new ArrayList<>();
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

    public List<RelatedPerson> getRelatedPerson() {
        return relatedPeople;
    }

    public void addRelatedPerson(RelatedPerson relative){
        relatedPeople.add(relative);
    }

}
