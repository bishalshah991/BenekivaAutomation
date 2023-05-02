package helper.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptHelper {

    private final WebDriver driver;
    public JavaScriptHelper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Object executeScript(String script) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        System.out.println(script);
        return exe.executeScript(script);
    }

    public Object executeScript(String script, Object... args) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        System.out.println(script);
        return exe.executeScript(script, args);
    }

    public void scrollToElemet(WebElement element) {
        executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
        System.out.println(element);
    }

    public void scrollToElemetAndClick(WebElement element) {
        scrollToElemet(element);
        element.click();
        System.out.println(element);
    }

    public void scrollIntoView(WebElement element) {
        executeScript("arguments[0].scrollIntoView()", element);
        System.out.println(element);
    }

    public void scrollIntoViewAndClick(WebElement element) {
        scrollIntoView(element);
        element.click();
        System.out.println(element);
    }
}
