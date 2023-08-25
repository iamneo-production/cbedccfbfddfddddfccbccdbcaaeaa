import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest {
  private App app;

  @BeforeMethod
  public void setup() {
    app = new App();
    app.openBrowser("chrome");
    app.navigateToDroppablePage();
  }

  @Test
  public void testDragAndDrop() {
    app.performDragAndDrop();
    String expectedColor = "rgba(70, 130, 180, 1)";
    String actualColor = app.getColor();
    Assert.assertEquals(actualColor, expectedColor, "Color does not match");

    String expectedText = "Dropped!";
    String actualText = app.getText();
    Assert.assertEquals(actualText, expectedText, "Text does not match");
  }

  @AfterMethod
  public void tearDown() {
    app.closeBrowser();
  }
}