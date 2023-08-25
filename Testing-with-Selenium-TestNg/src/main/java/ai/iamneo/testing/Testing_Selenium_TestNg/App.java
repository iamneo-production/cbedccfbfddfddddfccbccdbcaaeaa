import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class App {
  private WebDriver driver;

  public void openBrowser(String browser) {
    if (browser.equals("chrome")) {
      System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
      driver = new ChromeDriver();
    }
    // add other browser options if needed
  }

  public void navigateToDroppablePage() {
    driver.get("http://jqueryui.com/droppable/");
  }

  public void performDragAndDrop() {
    WebElement source = driver.findElement(By.id("draggable"));
    WebElement target = driver.findElement(By.id("droppable"));

    Actions actions = new Actions(driver);
    actions.dragAndDrop(source, target).build().perform();
  }

  public String getColor() {
    return driver.findElement(By.id("droppable")).getCssValue("background-color");
  }

  public String getText() {
    return driver.findElement(By.id("droppable")).getText();
  }

  public void closeBrowser() {
    driver.quit();
  }
}