package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PhotoDirectoryPage {

    WebDriver driver;

    By searchBox = By.xpath("//input[@placeholder='Search photos']");
    By images = By.cssSelector("img.attachment-post-thumbnail");

    public PhotoDirectoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchPhoto(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword);
        driver.findElement(searchBox).submit();
    }

    public int getImageCount() {
        return driver.findElements(images).size();
    }
}