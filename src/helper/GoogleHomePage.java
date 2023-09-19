package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleHomePage extends BasePage {
    Constants constant = new Constants();

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(constant.webLaunch);
    }

    public void searchFor(String query) {
        WebElement searchInput = driver.findElement(By.name(constant.searchLocator));
        searchInput.sendKeys(query);
        searchInput.submit();
    }

    public String getFirstResultText() {
        WebElement firstResult = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(constant.result)));
        return firstResult.getText();
    }
}
