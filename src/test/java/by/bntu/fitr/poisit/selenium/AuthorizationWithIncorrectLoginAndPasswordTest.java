package by.bntu.fitr.poisit.selenium;// Generated by Selenium IDE

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class AuthorizationWithIncorrectLoginAndPasswordTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void authorizationWithIncorrectLoginAndPassword() {
        driver.get("http://localhost:8081/shop/");
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("SomeWrongLogin");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("blalblabla");
        driver.findElement(By.cssSelector(".btn:nth-child(3)")).click();
    }
}
