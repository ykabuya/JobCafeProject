package Pages;

import Consts.Consts;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.logging.LogEntry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JobsPage extends BasePage {

    private static final String SEARCH_FILTER = "//*[@class = 'sidebar']";
    private static final String JOBS = "//*[@href='/job-page']";
    private static final String LOCATION_FIELD = "//input[@name='location']";
    private static final String POSITION_FIELD = "//input[@class='serch-input']";
    private static final String COMPANY_FIELD = "//input[@name='company']";
    private static final String SEARCH_BUTTON = "//button[@class='search-butom']";
    private static final String JOBS_PAGE = "//*[@class='jobs']";
    private static final String TORONTO = "//*[text()='Toronto, ON, Canada']";
    private static final String TEL_AVIV = "//*[text()='Tel Aviv-Yafo, Israel']";
    private static final String CHICAGO = "//*[text()='Chicago, IL, USA']";
    private static final String NewYork = "//*[text()='New York, NY, USA']";
    private static final String QA = "//*[text()='Int QA Analyst to perform complex integrated system testing']";
    private static final String DEVELOPER = "//*[text()='Full Stack Developer -C#/Node.js & React/Angular']";
    private static final String PROJECT_MANAGER = "//*[text()='Senior Project Manager']";
    private static final String APPLE = "//*[text()='Apple']";
    private static final String FACEBOOK = "//*[text()='Facebook']";
    private static final String GOOGLE = "//*[text()='Google']";
    private static final String ErrorMess = "//*[text()='No results found! Please try different search criteria']";
    private static final String RESET_BUTTON = "//*[text()='reset']";
    public static final String JOBS_HEADER = "//form[@class = 'search-form']";

    public void navigateToJobsPage() {
        webDriver.get(Consts.JOBS_PAGE);

    }

    public static JobsPage openJobsPage() {
        clickElementByXpath(JOBS);
        return new JobsPage();
    }

    public String checkIfJobsIsOpened() {
        String actualURL = getCurrentPageUrl();

        return actualURL;
    }


    public boolean isFilterOnTheScreen() throws IOException {
        File file = captureImage(SEARCH_FILTER).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("filter.png"));
        boolean isFilterOnTheScreen = elementExists(SEARCH_FILTER);
        return isFilterOnTheScreen;

    }


    public static List logs() {
        List<LogEntry> logs = BasePage.getLogs().getAll();
        return logs;

    }

    public JobsPage sendLocation(String text) {
        sendTextToElementByXpath(LOCATION_FIELD, text);
        return new JobsPage();
    }


    public JobsPage sendPosition(String text) {
        sendTextToElementByXpath(POSITION_FIELD, text);
        return new JobsPage();
    }

    public JobsPage sendCompany(String text) {
        sendTextToElementByXpath(COMPANY_FIELD, text);
        return new JobsPage();
    }

    public void clickSearchButton() {
        clickElementByXpath(JobsPage.SEARCH_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JOBS_HEADER)));
    }


    public void clickResetButton() {
        clickElementByXpath(JobsPage.RESET_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JOBS_HEADER)));
    }

    public boolean isTorontoOnTheScreen() throws IOException {
        File file = captureImage(JOBS_PAGE).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("toronto.png"));
        boolean isTorontoOnTheScreen = elementExists(TORONTO);
        return isTorontoOnTheScreen;

    }

    public boolean isTelAvivOnTheScreen() throws IOException {
        File file = captureImage(JOBS_PAGE).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("tel_aviv.png"));
        boolean isTelAvivOnTheScreen = elementExists(TEL_AVIV);
        return isTelAvivOnTheScreen;
    }

    public boolean isChicagoOnTheScreen() throws IOException {
        File file = captureImage(JOBS_PAGE).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("chicago.png"));
        boolean isChicagoOnTheScreen = elementExists(CHICAGO);
        return isChicagoOnTheScreen;
    }

    public boolean isNewYorkOnTheScreen() throws IOException {
        File file = captureImage(JOBS_PAGE).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("new_york.png"));
        boolean isNewYorkOnTheScreen = elementExists(NewYork);
        return isNewYorkOnTheScreen;
    }

    public boolean isQAPositionOnTheScreen() throws IOException {
        boolean isQAPositionOnTheScreen = elementExists(QA);
        return isQAPositionOnTheScreen;
    }

    public boolean isDeveloperPositionOnTheScreen() throws IOException {
        boolean isDeveloperPositionOnTheScreen = elementExists(DEVELOPER);
        return isDeveloperPositionOnTheScreen;
    }

    public boolean isProjectManagerPositionOnTheScreen() throws IOException {
        boolean isProjectManagerPositionOnTheScreen = elementExists(PROJECT_MANAGER);
        return isProjectManagerPositionOnTheScreen;
    }

    public boolean isPositionOnScreen(String element) {
        boolean isPositionOnScreen = elementExists(element);
        return isPositionOnScreen;
    }

    public boolean isCompanyOnScreen(String company) {
        boolean isCompanyOnScreen = elementExists(company);
        return isCompanyOnScreen;
    }

    public boolean isAppleOnTheScreen() throws IOException {
        boolean isAppleOnTheScreen = elementExists(APPLE);
        return isAppleOnTheScreen;
    }

    public boolean isFacebookOnTheScreen() throws IOException {
        boolean isFacebookOnTheScreen = elementExists(FACEBOOK);
        return isFacebookOnTheScreen;
    }

    public boolean isGoogleOnTheScreen() throws IOException {
        boolean isGoogleOnTheScreen = elementExists(GOOGLE);
        return isGoogleOnTheScreen;
    }

    public boolean isCombinedSearchOnTheScreen() throws IOException {
        File file = captureImage(JOBS_PAGE).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("combined_search.png"));
        boolean isCombinedSearchOnTheScreen = elementExists(GOOGLE);
        return isCombinedSearchOnTheScreen;
    }

    public boolean isExist() {
        boolean ifExist = elementExists(POSITION_FIELD);
        return ifExist;

    }

    public boolean catchError() {
        boolean error = elementExists(ErrorMess);
        return error;
    }

    public void waitJobsListLoaded() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='entry-meta']")));
    }
}
