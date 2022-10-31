package Pages;

import Consts.Consts;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class HomePage extends BasePage {

    private static final String LOGO_IMG = "//*[@class = 'logo']";
    private static final String COMING_SOON_IMG = "//img[@src = '/img/JC_comingSoon.jpg']";


    public void navigateToHomePage() {
        webDriver.get(Consts.HOME_PAGE);

    }
    public static HomePage openHomePage() {
        clickElementByXpath(LOGO_IMG);
        return new HomePage();
    }


    public boolean isLogoVisible() {
        boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }

    public String isPageLoaded() {
        String actualURL = getCurrentPageUrl();
        return actualURL;
    }

    public boolean isImageOnTheScreen() throws IOException {
        File file = captureImage(COMING_SOON_IMG).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));
        boolean isOnScreen = elementExists(COMING_SOON_IMG);
        return isOnScreen;


    }

}