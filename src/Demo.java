import java.util.List;

/**
 * Created by Ivona Zoricic
 * Date: 2020-12-04
 * Time: 14:36
 * Project: Preeschool
 * Copywrite: MIT
 */
public class Demo {
    public static void main(String[] args) {


        Database d = new Database();

        Caregiver c1 = new Caregiver("Anna","Andersson","198902024785");
        Caregiver c2 = new Caregiver("Eva","Johansson","198801015689");
        Caregiver c3 = new Caregiver("Maria","Karlsson","198703036523");
        Caregiver c4 = new Caregiver("Karin","Nilsson", "198604043256");
        d.addCaregiver(c1);
        d.addCaregiver(c2);
        d.addCaregiver(c3);
        d.addCaregiver(c4);
        c1.setEmailAddress("anna.andersson@gmail.com");
        c1.setPhoneNumber("070 222 333 44");
        c1.setPostAddress("Stockholm");
        c2.setEmailAddress("eva.johansson@gmail.com");
        c2.setPhoneNumber("070 333 444 55");
        c2.setPostAddress("Solna");
        c3.setEmailAddress("maria.karlsson@gmail.com");
        c3.setPhoneNumber("070 444 555 66");
        c3.setPostAddress("Huddinge");
        c4.setEmailAddress("karin.nilsson@gmail.com");
        c4.setPhoneNumber("070 555 666 77");
        c4.setPostAddress("Södertälje");
        List<Caregiver> caregiverList = d.getCaregiverList();


        Child b1 = new Child("Alice","Andersson","201502024785");
        Child b2 = new Child("Olivia","Johansson","201501015689");
        Child b3 = new Child("Lucas","Karlsson","201503036523");
        Child b4 = new Child("Liam","Nilsson","201504043256");
        Child b5 = new Child("Astrid","Nilsson","01605053325");

        b1.addCaringTime("måndag", "08:00", "16:00");
        b1.addCaringTime("tisdag", "08:00", "16:00");
        b1.addCaringTime("onsdag", "08:00", "16:00");
        b1.addCaringTime("torsdag", "08:00", "15:00");
        b1.addCaringTime("fredag", "08:00", "15:00");

        b2.addCaringTime("måndag", "08:00", "15:00");
        b2.addCaringTime("tisdag", "08:00", "15:00");
        b2.addCaringTime("onsdag", "08:00", "15:00");
        b2.addCaringTime("torsdag", "08:00", "15:00");
        b2.addCaringTime("fredag", "08:00", "15:00");

        b3.addCaringTime("måndag", "08:00", "15:00");
        b3.addCaringTime("tisdag", "08:00", "15:00");
        b3.addCaringTime("onsdag", "08:00", "15:00");
        b3.addCaringTime("torsdag", "08:00", "15:00");
        b3.addCaringTime("fredag", "08:00", "15:00");

        b4.addCaringTime("måndag", "08:00", "16:30");
        b4.addCaringTime("tisdag", "08:00", "16:30");
        b4.addCaringTime("onsdag", "08:00", "16:30");
        b4.addCaringTime("torsdag", "08:00", "15:00");
        b4.addCaringTime("fredag", "08:00", "15:00");

        b5.addCaringTime("måndag", "08:00", "16:30");
        b5.addCaringTime("tisdag", "08:00", "16:30");
        b5.addCaringTime("onsdag", "08:00", "16:30");
        b5.addCaringTime("torsdag", "08:00", "15:00");
        b5.addCaringTime("fredag", "08:00", "15:00");


        d.addChild(b1);
        d.addChild(b2);
        d.addChild(b3);
        d.addChild(b4);
        d.addChild(b5);
        List<Child> childrenList = d.getChildList();


        c1.addChildren(b1);
        c2.addChildren(b2);
        c3.addChildren(b3);
        c4.addChildren(b4);
        c4.addChildren(b5);

        b1.addCaregiver(c1);
        b2.addCaregiver(c2);
        b3.addCaregiver(c3);
        b4.addCaregiver(c4);
        b5.addCaregiver(c4);

        RelatedPerson r1 = new RelatedPerson("Johanna","Eriksson");
        r1.addRelatedChild(b1);
        r1.setPhoneNumber("0738585858");
        r1.seteMailAddress("johanna.eriksson@gmail.com");
        r1.setRelationWithChild("Mormor");
        b1.addRelatedPerson(r1);

        RelatedPerson r2 = new RelatedPerson("Lena","Johansson");
        r2.addRelatedChild(b2);
        r2.setPhoneNumber("07335253525");
        r2.seteMailAddress("lena.johansson@gmail.com");
        r2.setRelationWithChild("Farmor");
        b2.addRelatedPerson(r2);

        RelatedPerson r3 = new RelatedPerson("Astrid","Andersson");
        r3.addRelatedChild(b3);
        r3.setPhoneNumber("073444444");
        r3.seteMailAddress("astrid.andersson@gmail.com");
        r3.setRelationWithChild("Moster");
        b3.addRelatedPerson(r3);

        RelatedPerson r4 = new RelatedPerson("Noelia","Nilsson");
        r4.addRelatedChild(b4);
        r4.setPhoneNumber("0735555556");
        r4.seteMailAddress("noelia.nilsson@gmail.com");
        r4.setRelationWithChild("Faster");
        r4.addRelatedChild(b5);
        b4.addRelatedPerson(r4);
        b5.addRelatedPerson(r4);


        Educator e = new Educator("Kristina","Eriksson","97807075564");
        d.addEducator(e);
        e.setEmailAddress("kristina.eriksson@gmail.com");
        e.setPhoneNumber("070 123 45 67");
        e.setPostAddress("Stockholm");
        List<Educator> educatorList = d.getEducatorList();

        Administrator administrator = new Administrator("Ivona", "Zoricic", "198307084445");
        d.addAdministrator(administrator);
        List<Administrator> administratorList = d.getAdministratorList();




        //d.serialize(caregiverList,"Caregivers.ser");
        d.serialize(childrenList,"Children.ser");
        d.serialize(educatorList,"Educators.ser");
        d.serialize(administratorList, "Admin.ser");


        /*
        List<Caregiver> caregivers = d.deSerialize(caregiverList,"Caregivers.ser");
        System.out.println(caregivers.size());

        List<Educator> educators = d.deSerialize(educatorList, "Educators.ser");
        System.out.println(educators.size());

        List<Child> children = d.deSerialize(childrenList, "Children.ser");
        System.out.println(children.size());

         */


    }
}
