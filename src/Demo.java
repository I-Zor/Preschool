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
        Caregiver c5 = new Caregiver("Erik", "Andersson", "8888888888");
        Caregiver c6 = new Caregiver("Lars", "Johansson", "5555555555");
        Caregiver c7 = new Caregiver("Anders", "Karlsson", "7777777777");
        Caregiver c8 = new Caregiver("Peter", "Jonsson", "9999999999");
        Caregiver c9 = new Caregiver("Ingrid", "Hansson", "3535353535");
        Caregiver c10 = new Caregiver("Sven", "Pettersson", "8787878787");

        d.addCaregiver(c1);d.addCaregiver(c2);d.addCaregiver(c3);d.addCaregiver(c4);d.addCaregiver(c5);
        d.addCaregiver(c6);d.addCaregiver(c7);d.addCaregiver(c8);d.addCaregiver(c9);d.addCaregiver(c10);

        c1.setEmailAddress("anna.andersson@gmail.com");
        c1.setPhoneNumber("070 222 333 44");
        c1.setPostAddress("Stockholm");
        c1.setUsername("anna.andersson");
        c2.setEmailAddress("eva.johansson@gmail.com");
        c2.setPhoneNumber("070 333 444 55");
        c2.setPostAddress("Stockholm");
        c2.setUsername("eva.johansson");
        c3.setEmailAddress("maria.karlsson@gmail.com");
        c3.setPhoneNumber("070 444 555 66");
        c3.setPostAddress("Stockholm");
        c3.setUsername("maria.karlsson");
        c4.setEmailAddress("karin.nilsson@gmail.com");
        c4.setPhoneNumber("070 555 666 77");
        c4.setPostAddress("Stockholm");
        c4.setUsername("karin.nilsson");
        c5.setEmailAddress("erik.andersson@gmail.com");
        c5.setPhoneNumber("070 555 666 77");
        c5.setPostAddress("Stockholm");
        c5.setUsername("erik.andersson");
        c6.setEmailAddress("lars.johansson@gmail.com");
        c6.setPhoneNumber("070 555 666 77");
        c6.setPostAddress("Stockholm");
        c6.setUsername("lars.johansson");
        c7.setEmailAddress("anders.karlsson@gmail.com");
        c7.setPhoneNumber("070 555 666 77");
        c7.setUsername("anders.karlsson");
        c7.setPostAddress("Stockholm");
        c8.setEmailAddress("peter.jonsson@gmail.com");
        c8.setPhoneNumber("070 555 666 77");
        c8.setPostAddress("Stockholm");
        c8.setUsername("peter.jonsson");
        c9.setEmailAddress("ingrid.hansson@gmail.com");
        c9.setPhoneNumber("070 555 666 77");
        c9.setPostAddress("Stockholm");
        c9.setUsername("ingrid.hansson");
        c10.setEmailAddress("sven.pettersson@gmail.com");
        c10.setPhoneNumber("070 555 666 77");
        c10.setPostAddress("Stockholm");
        c10.setUsername("sven.pettersson");


        Child b1 = new Child("Alice","Andersson","201502024785");
        Child b2 = new Child("Olivia","Johansson","201501015689");
        Child b3 = new Child("Lucas","Karlsson","201503036523");
        Child b4 = new Child("Liam","Nilsson","201504043256");
        Child b5 = new Child("Astrid","Nilsson","201605053325");
        Child b6 = new Child("Helena", "Andersson", "201913053212");
        Child b7 = new Child("Birgitta", "Karlsson", "201812125656");
        Child b8 = new Child("Nils", "Hansson", "201915069696");
        Child b9 = new Child("Fredrik", "Pettersson", "201824026565");

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

        b6.addCaringTime("måndag", "08:00", "16:30");
        b6.addCaringTime("tisdag", "08:00", "16:30");
        b6.addCaringTime("onsdag", "08:00", "16:30");
        b6.addCaringTime("torsdag", "08:00", "15:00");
        b6.addCaringTime("fredag", "08:00", "15:00");

        b7.addCaringTime("måndag", "08:00", "16:30");
        b7.addCaringTime("tisdag", "08:00", "16:30");
        b7.addCaringTime("onsdag", "08:00", "16:30");
        b7.addCaringTime("torsdag", "08:00", "15:00");
        b7.addCaringTime("fredag", "08:00", "15:00");

        b8.addCaringTime("måndag", "08:00", "16:30");
        b8.addCaringTime("tisdag", "08:00", "16:30");
        b8.addCaringTime("onsdag", "08:00", "16:30");
        b8.addCaringTime("torsdag", "08:00", "15:00");
        b8.addCaringTime("fredag", "08:00", "15:00");

        b9.addCaringTime("måndag", "08:00", "16:30");
        b9.addCaringTime("tisdag", "08:00", "16:30");
        b9.addCaringTime("onsdag", "08:00", "16:30");
        b9.addCaringTime("torsdag", "08:00", "15:00");
        b9.addCaringTime("fredag", "08:00", "15:00");

        b1.setPostAddress("Stockholm");
        b2.setPostAddress("Stockholm");
        b3.setPostAddress("Stockholm");
        b4.setPostAddress("Stockholm");
        b5.setPostAddress("Stockholm");
        b6.setPostAddress("Stockholm");
        b7.setPostAddress("Stockholm");
        b8.setPostAddress("Stockholm");
        b9.setPostAddress("Stockholm");

        d.addChild(b1);
        d.addChild(b2);
        d.addChild(b3);
        d.addChild(b4);
        d.addChild(b5);
        d.addChild(b6);
        d.addChild(b7);
        d.addChild(b8);
        d.addChild(b9);
        List<Child> childrenList = d.getChildList();

        c1.addChildren(b1);
        c1.addChildren(b6);
        c2.addChildren(b2);
        c3.addChildren(b3);
        c3.addChildren(b7);
        c4.addChildren(b4);
        c4.addChildren(b5);
        c5.addChildren(b1);
        c5.addChildren(b6);
        c6.addChildren(b2);
        c7.addChildren(b3);
        c7.addChildren(b7);
        c8.addChildren(b8);
        c9.addChildren(b8);
        c10.addChildren(b9);

        b1.addCaregiver(c1);
        b1.addCaregiver(c5);
        b2.addCaregiver(c2);
        b3.addCaregiver(c3);
        b4.addCaregiver(c4);
        b5.addCaregiver(c4);
        b6.addCaregiver(c1);
        b6.addCaregiver(c5);
        b7.addCaregiver(c3);
        b7.addCaregiver(c7);
        b8.addCaregiver(c8);
        b8.addCaregiver(c9);
        b9.addCaregiver(c10);

        Relative r1 = new Relative("Johanna","Eriksson");
        r1.addCloseChild(b1);
        r1.addCloseChild(b6);
        r1.setPhoneNumber("0738585858");
        r1.seteMailAddress("johanna.eriksson@gmail.com");
        r1.setRelationWithChild("Mormor");
        b1.addRelative(r1);
        b6.addRelative(r1);

        Relative r2 = new Relative("Lena","Johansson");
        r2.addCloseChild(b2);
        r2.setPhoneNumber("07335253525");
        r2.seteMailAddress("lena.johansson@gmail.com");
        r2.setRelationWithChild("Farmor");
        b2.addRelative(r2);

        Relative r3 = new Relative("Astrid","Andersson");
        r3.addCloseChild(b3);
        r3.setPhoneNumber("073444444");
        r3.seteMailAddress("astrid.andersson@gmail.com");
        r3.setRelationWithChild("Moster");
        b3.addRelative(r3);

        Relative r4 = new Relative("Noelia","Nilsson");
        r4.addCloseChild(b4);
        r4.setPhoneNumber("0735555556");
        r4.seteMailAddress("noelia.nilsson@gmail.com");
        r4.setRelationWithChild("Faster");
        r4.addCloseChild(b5);
        b4.addRelative(r4);
        b5.addRelative(r4);

        Relative r5 = new Relative("Marijeta","Zoricic");
        r5.addCloseChild(b4);
        r5.setPhoneNumber("0702110492");
        r5.seteMailAddress("marijeta.zoricic@gmail.com");
        r5.setRelationWithChild("Granne");
        r5.addCloseChild(b7);
        r5.addCloseChild(b8);
        r5.addCloseChild(b9);
        b7.addRelative(r5);
        b8.addRelative(r5);
        b9.addRelative(r5);


        Educator e1 = new Educator("Kristina","Eriksson","197807075564");
        d.addEducator(e1);
        e1.setEmailAddress("kristina.eriksson@gmail.com");
        e1.setPhoneNumber("070 123 45 67");
        e1.setPostAddress("Stockholm");
        e1.setPosition("Förskollärare");
        e1.setUsername("kristina.eriksson");

        Educator e2 = new Educator("Klara","Magnusson","197709092255");
        d.addEducator(e2);
        e2.setEmailAddress("klara.magnusson@gmail.com");
        e2.setPhoneNumber("070 334 66 55");
        e2.setPostAddress("Stockholm");
        e2.setPosition("Barnskötare");
        e2.setUsername("klara.magnusson");

        Educator e3 = new Educator("Sofia","Lindberg","198310091155");
        d.addEducator(e3);
        e3.setEmailAddress("sofia.lindberg@gmail.com");
        e3.setPhoneNumber("070 114 36 35");
        e3.setPostAddress("Stockholm");
        e3.setPosition("Barnskötare");
        e3.setUsername("sofia.lindberg");

        List<Educator> educatorList = d.getEducatorList();

        ChildGroup group1 = new ChildGroup("Humlan");
        d.addDepartments(group1);
        group1.addEducatorToGroup(e1);
        group1.addEnrolledChild(b1);
        group1.addEnrolledChild(b2);
        group1.addEnrolledChild(b3);
        e1.setChildGroup(group1);

        ChildGroup group2 = new ChildGroup("Fröet");
        d.addDepartments(group2);
        group2.addEducatorToGroup(e2);
        group2.addEnrolledChild(b4);
        group2.addEnrolledChild(b5);
        group2.addEnrolledChild(b6);
        e2.setChildGroup(group2);

        ChildGroup group3 = new ChildGroup("Nasselfjärillen");
        d.addDepartments(group3);
        group3.addEducatorToGroup(e3);
        group3.addEnrolledChild(b7);
        group3.addEnrolledChild(b8);
        group3.addEnrolledChild(b9);
        e3.setChildGroup(group3);


        b1.setChildGroup(group1);
        b2.setChildGroup(group1);
        b3.setChildGroup(group1);
        b4.setChildGroup(group2);
        b5.setChildGroup(group2);
        b6.setChildGroup(group2);
        b7.setChildGroup(group3);
        b8.setChildGroup(group3);
        b9.setChildGroup(group3);

        Administrator administrator = new Administrator("Ivona", "Zoricic", "198307084445");
        administrator.setUsername("ivona.zoricic");
        d.addAdministrator(administrator);
        List<Administrator> administratorList = d.getAdministratorList();

        System.out.println("Success");

        d.serialize(childrenList,"Children.ser");
        d.serialize(educatorList,"Educators.ser");
        d.serialize(administratorList, "Admin.ser");

    }
}
