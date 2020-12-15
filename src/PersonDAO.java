import java.util.List;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-07
 * Time: 13:43
 * Project: Preeschool
 * Copywrite: MIT
 */
public interface PersonDAO {

   String getContactInformation(IContactInformation person);
   Child getChild(String name);
   Caregiver getCaregiver(String name);
   Educator getEducator(String name);
   List<Child> getChildList();
   List<Educator> getEducatorList();
   List<Caregiver> getCaregiverList();


}
