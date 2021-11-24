package com.flipkart.automation.stepDef;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	private String propertyFilePath = System.getProperty("user.dir")+"/src/main/java/com/flipkart/automation/utils/selector.properties";
	public Properties prop;
	private WebDriver driver=null;
	
	public WebDriver getDriver() throws IOException {
		initPropertiesFile();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		return driver;
	}
	
	public void initPropertiesFile() throws IOException {
		File file = new File(propertyFilePath);
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendKeysToWebElement(String xpath, String value) {
		try {
		By byLocator = By.xpath(xpath);		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator)).sendKeys(value);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitandclick(String xpath) {
		By byLocator = By.xpath(xpath);		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(byLocator)).click();
	}
	
	public void waitandclickbyCSS(String css) {
		By byLocator = By.cssSelector(css);		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(byLocator)).click();
	}
	
	public void sendEnterkeyStroke(String xpath) {
		try {
			By byLocator = By.xpath(xpath);		
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator)).sendKeys(Keys.ENTER);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void clickLink(String partialLinkText) {
		By byLocator = By.partialLinkText(partialLinkText);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(byLocator)).click();
	}
	
	public void clickUsingActions(String xpath) throws InterruptedException {
		By element = By.xpath(xpath);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(element)).click().build().perform();
	}

}
