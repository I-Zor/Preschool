import java.util.List;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-07
 * Time: 15:10
 * Project: Preeschool
 * Copywrite: MIT
 */
public interface DatabaseDAO {
    void addChild(Child child);
    void deleteChild(Child child);
    void addCaregiver(Caregiver caregiver);
    void deleteCaregiver(Caregiver caregiver);
    void addEducator(Educator educator);
    void deleteEducator(Educator educator);
    void addAdministrator(Administrator admin);
    <T> List<T> deSerialize(String fileName);
    <T> void serialize(List <T> list, String fileName);



}
