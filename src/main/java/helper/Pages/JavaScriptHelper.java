package helper.Pages;

import BaseClass.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptHelper extends TestBase {

    public JavaScriptHelper(WebDriver driver) {
        this.driver=driver;
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

    public void scroll_To_Element(WebElement element) {
        executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
        System.out.println(element);
    }

    public void scrollToElemetAndClick(WebElement element) {
        scroll_To_Element(element);
        element.click();
        System.out.println(element);
    }

    public void scroll_to_View(WebElement element) {
        executeScript("arguments[0].scrollIntoView()", element);
        System.out.println(element);
    }

    public void scroll_to_View_And_Click(WebElement element) {
        scroll_to_View(element);
        element.click();
        System.out.println(element);
    }

    public void Scroll(){
        executeScript("window.scrollBy(0,-250)");
    }




}
