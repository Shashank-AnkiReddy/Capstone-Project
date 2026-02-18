package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;

import base.BaseTest;
import pages.DownloadPage;
import pages.HomePage;
import pages.PhotoDirectoryPage;

public class WordPressSteps extends BaseTest {

    HomePage home;
    DownloadPage download;
    PhotoDirectoryPage photoPage;

    @Given("User launches WordPress website")
    public void launchWebsite() {
        launchBrowser();
        driver.get("https://wordpress.org/");
        home = new HomePage(driver);
    }

    @Then("Verify page title")
    public void verifyTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("WordPress"));
    }

    @When("User clicks Get WordPress option")
    public void clickGetWordPress() {
        home.clickGetWordPress();
        download = new DownloadPage(driver);
    }

    @Then("Verify text {string}")
    public void verifyText(String expectedText) throws InterruptedException {
        String actualText = download.getHeaderText();
        Assert.assertEquals(actualText, expectedText);
        Thread.sleep(2000);
    }

    @When("User opens Photo Directory")
    public void openPhotoDirectory() {
        home.clickCommunity();
        home.clickPhotoDirectory();
        photoPage = new PhotoDirectoryPage(driver);
    }

    @Then("Search image and verify result")
    public void searchImage() {

        String keyword = "flower";

        photoPage.searchPhoto(keyword);

        int imageCount = photoPage.getImageCount();

        Assert.assertTrue(imageCount > 0,
                "No images found for keyword: " + keyword);

        closeBrowser();
    }
}