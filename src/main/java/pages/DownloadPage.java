package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DownloadPage {

    WebDriver driver;

    By headerText = By.xpath("//h1[contains(text(),'Get WordPress')]");

    public DownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderText() {
        return driver.findElement(headerText).getText();
    }
}