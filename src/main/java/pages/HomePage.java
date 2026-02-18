package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePage {

    WebDriver driver;

    By getWordPressButton = By.linkText("Get WordPress");
    By community = By.xpath("//span[text()='Community']");

    By photoDirectory = By.xpath("//a[.//span[text()='Photo Directory']]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickGetWordPress() {
        driver.findElement(getWordPressButton).click();
    }

    public void clickCommunity() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(community));

        driver.findElement(community).click();
    }
    
    public void clickPhotoDirectory() {
        driver.findElement(photoDirectory).click();
    }
}