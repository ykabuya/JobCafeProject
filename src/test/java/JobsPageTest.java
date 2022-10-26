import Pages.HomePage;
import Pages.JobsPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.logging.LogEntry;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Stream;
import static Consts.Consts.*;
import static org.junit.jupiter.api.Assertions.*;
public class JobsPageTest extends UseCaseBase {

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

    @Test
    public void isJobsPageIsOpened() {
        jobsPage.openJobsPage();
        Assertions.assertEquals(JOBS_PAGE, jobsPage.checkIfJobsIsOpened());
    }

    @Test
    public void isLogoVisible() throws IOException {
        boolean isVisible = jobsPage.openJobsPage().isFilterOnTheScreen();
        assertTrue(isVisible);
    }

//    @Test
//    public void logsTest() {
//        List<LogEntry> logs = jobsPage.logs();
//
//        for (LogEntry e : logs) {
//            System.out.println("Message: " + e.getMessage());
//            System.out.println("level: " + e.getLevel());
//            Assertions.assertNotEquals(Level.SEVERE, e.getLevel());
//        }



    @Test
    public void searchToronto() throws IOException, InterruptedException {
        jobsPage.openJobsPage().sendLocation("Toronto").clickSearchButton();
        jobsPage.sendLocation("Toronto").clickSearchButton();
        Thread.sleep(10000);
        boolean isOnScreen = jobsPage.isTorontoOnTheScreen();
        assertTrue(isOnScreen);

    }

    @Test
    public void searchTelAviv() throws IOException {
        boolean isOnScreen = jobsPage.openJobsPage().sendLocation("Tel Aviv").clickSearchButton().isTelAvivOnTheScreen();
        assertTrue(isOnScreen);
    }

    @Test
    public void searchChicago() throws IOException, InterruptedException {
        jobsPage.openJobsPage().sendLocation("Chicago").clickSearchButton();
        Thread.sleep(10000);
        boolean isOnScreen = jobsPage.isChicagoOnTheScreen();
        assertTrue(isOnScreen);
    }

    @Test
    public void searchNewYork() throws IOException, InterruptedException {
        jobsPage.openJobsPage().sendLocation("New York").clickSearchButton();
        Thread.sleep(10000);
        boolean isOnScreen = jobsPage.isNewYorkOnTheScreen();
        assertTrue(isOnScreen);
    }

    static Stream<Arguments> dataProvider() {

        return Stream.of(
                Arguments.of("QA", "//*[text()='#4068- QA Manual Engineer']"),
                Arguments.of("Developer", "//*[text()='Senior Full Stack Developer']"),
                Arguments.of("Project Manager", "//*[text()='Project Manager']"));
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void searchPositionTest(String position, String element) throws InterruptedException {
        jobsPage.openJobsPage().sendPosition(position);
        Thread.sleep(10000);
        jobsPage.clickSearchButton();
        boolean isPositionOnScreen = jobsPage.isPositionOnScreen(element);
        assertTrue(isPositionOnScreen);
    }

    @Test
    public void searchAppleCompanyTest() {
        jobsPage.openJobsPage().sendCompany("Apple").clickSearchButton();
        boolean isAppleOnScreen = jobsPage.isCompanyOnScreen(APPLE);
        assertTrue(isAppleOnScreen);
    }

    @Test
    public void searchFacebookCompanyTest() {
        jobsPage.openJobsPage().sendCompany("Facebook").clickSearchButton();
        boolean isOnScreen = jobsPage.isCompanyOnScreen(FACEBOOK);
        assertTrue(isOnScreen);
    }
    @Test
    public void searchGoogleCompanyTest() {
        jobsPage.openJobsPage().sendCompany("Google").clickSearchButton();
        boolean isOnScreen = jobsPage.isCompanyOnScreen(GOOGLE);
        assertTrue(isOnScreen);
    }
    @Test
    public void fullSearchTest() throws IOException, InterruptedException {
        jobsPage.openJobsPage().sendLocation("Canada").sendCompany("Google").clickSearchButton();
        Thread.sleep(10000);
        boolean onScreen = jobsPage.isCombinedSearchOnTheScreen();
        assertTrue(onScreen);
    }
    @Test
    public void wrongInputTest() throws InterruptedException {
        jobsPage.openJobsPage().sendPosition("khgfkgffk").clickSearchButton();
        assertNotNull(jobsPage.isExist());
        Thread.sleep(1000);
        assertNotNull(jobsPage.catchError());
    }
    @Test
    public void resetTest() throws InterruptedException, IOException {
        jobsPage.openJobsPage().sendPosition("QA").sendLocation("TelAviv").sendCompany("Google");
        jobsPage.clickSearchButton();
        Thread.sleep(1000);
        jobsPage.clickResetButton();
        assertTrue(jobsPage.isFilterOnTheScreen());


    }
}