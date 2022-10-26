import Pages.*;
import Utils.UseCaseBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static Consts.Consts.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Scenario1 extends UseCaseBase {
    private static HomePage homePage;
    private static AboutUsPage aboutUsPage;
    private static JobsPage jobsPage;



    @BeforeAll
    public static void classSetup() {

        homePage = new HomePage();
    }

    @BeforeEach
    public void beforeTest() {
        homePage.navigateToHomePage();

    }

//Navigate to Home Page http://167.99.178.249:3000/
//The page is loaded
//Logo is visible
//Coming soon image is on the screen
//From Home Page click on the About Us menu option
//About page is opened
//Logo is visible
//From Home Page click on the Jobs menu option
//Ignore: Login with a random username and password (no need to create an account)
//Ignore: The login page is loaded
//after submitting jobs page is opened

    @Test
    public void scenario1() throws IOException {

        assertEquals(HOME_PAGE, homePage.isPageLoaded());
        boolean isVisible = homePage.isLogoVisible();
        assertTrue(isVisible);
        boolean isOnScreen = homePage.isImageOnTheScreen();
        assertTrue(isOnScreen);
        aboutUsPage = AboutUsPage.openAboutUsPage();
        Assertions.assertEquals(ABOUT_US_PAGE, aboutUsPage.checkIfAboutUsOpened());
        boolean isLogoVisible = aboutUsPage.openAboutUsPage().isLogoVisible();
        assertTrue(isLogoVisible);
        homePage = HomePage.openHomePage();
        assertEquals(HOME_PAGE, homePage.isPageLoaded());
        boolean isLogoHPVisible = homePage.isLogoVisible();
        assertTrue(isLogoHPVisible);
        jobsPage = JobsPage.openJobsPage();
        Assertions.assertEquals(JOBS_PAGE, jobsPage.checkIfJobsIsOpened());

    }

}