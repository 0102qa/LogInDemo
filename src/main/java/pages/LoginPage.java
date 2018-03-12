package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

	By accountNameElement = By.xpath("//div[@class='assist-inline']/input[@type='text']");
	By passwordElement = By.cssSelector("div.assist-inline>[type='password']");
	By logInButtonElement = By.xpath("//button[@class='btn btn-default'][@tabindex=100]");
	By InvalidNameErrorElement = By.xpath("//div[@class='notify-box-item box-error']");
			
	//constructor
	public LoginPage(WebDriver driver) {
	this.driver = driver;
	}
			
	public WebElement accountName() {
	return driver.findElement(accountNameElement);
	}
	public WebElement passwordField() {
	return driver.findElement(passwordElement);
	}
	public WebElement logInButton() {		
	return driver.findElement(logInButtonElement);
	}
	public String errorMessageText () {
	String text = driver.findElement(InvalidNameErrorElement).getText();
	return text;
	}
	public Boolean isEroorPresent () {
	boolean isPresent = driver.findElements(InvalidNameErrorElement).size()>0;
	return isPresent;
	}
}
