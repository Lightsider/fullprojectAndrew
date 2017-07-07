import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Created by andrey.popov on 05.07.2017.
 */

public class Testreg extends Testbase{

    public static Context cont;



    @BeforeTest
    public void before()
    {
        cont.initInstance( "https://libertex-fxb3-test.web.test.fxclub.org");
    }

    @Test
    public void test() throws Exception
    {
        //1 вариант
        cont.pushSignup();
        cont.setFirstname("IvanTest");
        cont.setLastname("IvanovTest");
        cont.setEmail();
        cont.setPassword("password");
        cont.setNumber();
        cont.pushAgreement();
        cont.pushDate();

        //2 вариант

         /*cont.pushSignup();
         cont.setEmail();
         cont.setPassword("password");
         cont.pushAgreement();*/


        cont.pushRegisterButton();
        Assertions.assertThat(cont.getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/");
        Assertions.assertThat(cont.checkRegisterWindow());



    }

    /*public void invalidtest() throws Exception
    {
        cont.pushSignup();
        cont.setFirstname("IvanTest");
        cont.setLastname("IvanovTest");
        cont.setEmail();
        cont.setPassword("password");
        cont.setNumber();
        cont.pushAgreement();
        cont.pushDate();
        cont.pushRegisterButton();
        Assertions.assertThat(cont.getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/");
        Assertions.assertThat(cont.checkRegisterWindow());
        cont.pushLogout();
    }*/

    @AfterTest(alwaysRun = true)
    public void after(){
        cont.close();
        cont = null;
    }

}
