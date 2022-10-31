import Pages.HomePage;
import Pages.JobsPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.stream.Stream;
import static Consts.Consts.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Scenario2 extends UseCaseBase {

    private static HomePage homePage;
    private static JobsPage jobsPage;


    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage();
        jobsPage = new JobsPage();

    }

    @BeforeEach
    public void beforeTest() {
        homePage.navigateToHomePage();

    }
//    Navigate to the jobs page
//    Search for a location: Toronto, Tel-Aviv, Chicago, New-York
//    The results list is displayed for each city

//    Navigate to the jobs page
//    Search for a position: QA, Developer, Project Manager
//    The results list is displayed for each position

//    Navigate to the jobs page
//    Search for a company: Apple, Facebook, Google
//    The results list is displayed for each company

//    Make a combined search - look for manager positions in Google in USA
//    The results are visible

//    No results - enter abracadabra to position filter and press search button
//    "No results found! Please try different search criteria" message is displayed

//    Reset test -
//    Populate all the edit boxes
//    Press reset button
//    Verify all the input text has disappeared

    @Test
    public void scenario2() throws IOException {

        jobsPage = JobsPage.openJobsPage();
        Assertions.assertEquals(JOBS_PAGE, jobsPage.checkIfJobsIsOpened());

        jobsPage.openJobsPage().sendLocation("Toronto");
//        Thread.sleep(2000);
        jobsPage.clickSearchButton();
        boolean isTorontoOnScreen = jobsPage.isTorontoOnTheScreen();
        assertTrue(isTorontoOnScreen);
        jobsPage.clickResetButton();
        jobsPage.openJobsPage().sendLocation("Tel Aviv");
//        Thread.sleep(2000);
        jobsPage.clickSearchButton();
        boolean isTelAvivOnTheScreen = jobsPage.isTelAvivOnTheScreen();
        assertTrue(isTelAvivOnTheScreen);
        jobsPage.clickResetButton();
        jobsPage.openJobsPage().sendLocation("Chicago");
//        Thread.sleep(2000);
        jobsPage.clickSearchButton();
        boolean isChicagoOnTheScreen = jobsPage.isChicagoOnTheScreen();
        assertTrue(isChicagoOnTheScreen);
        jobsPage.clickResetButton();
        jobsPage.openJobsPage().sendLocation("New York");
//        Thread.sleep(2000);
        jobsPage.clickSearchButton();
        boolean isNewYorkOnTheScreen = jobsPage.isNewYorkOnTheScreen();
        assertTrue(isNewYorkOnTheScreen);
        jobsPage.clickResetButton();

        jobsPage.openJobsPage().sendPosition("QA");
//        Thread.sleep(2000);
        jobsPage.clickSearchButton();
        boolean isQAPositionOnTheScreen = jobsPage.isQAPositionOnTheScreen();
        assertTrue(isQAPositionOnTheScreen);
        Stream.of("QA", "//*[text()='Int QA Analyst to perform complex integrated system testing']");
        jobsPage.clickResetButton();
        jobsPage.openJobsPage().sendPosition("Developer");
//        Thread.sleep(2000);
        jobsPage.clickSearchButton();
        boolean isDeveloperPositionOnTheScreen = jobsPage.isDeveloperPositionOnTheScreen();
        assertTrue(isDeveloperPositionOnTheScreen);
        Stream.of("Developer", "//*[text()='Full Stack Developer -C#/Node.js & React/Angular']");
        jobsPage.clickResetButton();
        jobsPage.openJobsPage().sendPosition("Project Manager");
//        Thread.sleep(2000);
        jobsPage.clickSearchButton();
        boolean isProjectManagerPositionOnTheScreen = jobsPage.isProjectManagerPositionOnTheScreen();
        assertTrue(isProjectManagerPositionOnTheScreen);
        Stream.of(of("Project Manager", "//*[text()='Senior Project Manager']"));
        jobsPage.clickResetButton();

        jobsPage.openJobsPage().sendCompany("Apple");
        jobsPage.clickSearchButton();
        boolean isAppleOnTheScreen = jobsPage.isAppleOnTheScreen();
        assertTrue(isAppleOnTheScreen);
        jobsPage.clickResetButton();
        jobsPage.openJobsPage().sendCompany("Facebook");
        jobsPage.clickSearchButton();
        boolean isFacebookOnTheScreen = jobsPage.isFacebookOnTheScreen();
        assertTrue(isFacebookOnTheScreen);
        jobsPage.clickResetButton();
        jobsPage.openJobsPage().sendCompany("Google");
        jobsPage.clickSearchButton();
        boolean isGoogleOnTheScreen = jobsPage.isGoogleOnTheScreen();
        assertTrue(isGoogleOnTheScreen);
        jobsPage.clickResetButton();

        jobsPage.openJobsPage().sendLocation("USA").sendCompany("Google").sendPosition("Manager");
//        Thread.sleep(2000);
        jobsPage.clickSearchButton();
        boolean isCombinedSearchOnTheScreen = jobsPage.isCombinedSearchOnTheScreen();
        assertTrue(isCombinedSearchOnTheScreen);
        jobsPage.clickResetButton();

        jobsPage.openJobsPage().sendPosition("khgfkgffk");
        jobsPage.clickSearchButton();
        assertNotNull(jobsPage.isExist());
//        Thread.sleep(1000);
        assertNotNull(jobsPage.catchError());
        jobsPage.clickResetButton();

        jobsPage.openJobsPage().sendPosition("QA").sendLocation("Toronto").sendCompany("Facebook");
        jobsPage.clickSearchButton();
//        Thread.sleep(1000);
        jobsPage.clickResetButton();
        assertTrue(jobsPage.isFilterOnTheScreen());

    }
}

