package test;
import com.aurora.account.model.Applicant;
import com.aurora.account.model.Parent;
import org.junit.*;

public class ModelTesting {
    @Test
    public void TestApplicant(){
        Applicant applicant=new Applicant();
        applicant.setAppResult(0);
        applicant.setAge("10");
        applicant.setDiv_grama("gr1");
        applicant.setDiv_sec("sec1");
        applicant.setDistrict("dis1");
        applicant.setGender("male");
        applicant.setDob("2000-01-05");
        applicant.setInitials("a.s.d.f.k");
        applicant.setFirst_name("fname");
        applicant.setSecond_name("sname");
        applicant.setElectro_cert("true");
        applicant.setApplication_id("12345678");
        applicant.setReligion("rel1");

        System.out.println(applicant.toString());
        applicant.setAppResult(0);
        applicant.setElectro_cert(null);

        System.out.println(applicant.toString());
        applicant.setAppResult(0);
        applicant.setGrama_cert("true");

        System.out.println(applicant.toString());
        applicant.setElectro_cert("true");
        System.out.println(applicant.toString());


    }

    @Test
    public void TestParent(){
        Parent parent=new Parent();
        parent.setEmail("email");
        parent.setTelephone_no("1233456789");
        parent.setGender("male");
        parent.setOccupation("occu");
        parent.setInitials("a.s.d.f");
        parent.setSecond_name("sname");
        parent.setFirst_name("fname");
        parent.setNIC("123456789v");

        System.out.println(parent.toString());
    }

}
