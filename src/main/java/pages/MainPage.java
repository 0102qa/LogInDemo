package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	public WebDriver driver;

	By welcomeElement = By.xpath("//div[@class='assist-cat-item-text assist-cat-item-text-selected']/span");
	By closeAssistantButtonElement = By.xpath("//div[@class='assist-content-column-cat-cancel']/div/button");
	By logoutButtonElement = By.xpath("//div[contains(text(),'Logout')]");
	
			
	//constructor
	public MainPage(WebDriver driver) {
	this.driver = driver;
	}
			
	public WebElement welcomeAssistant() {
	return driver.findElement(welcomeElement);
	}
	public WebElement closeAssistantButton() {
	return driver.findElement(closeAssistantButtonElement);
	}
	public WebElement logoutButton() {
	return driver.findElement(logoutButtonElement);
	}
	public Boolean isAssistantMenuPresent () {
	Boolean isPresent = driver.findElements(welcomeElement).size()>0;
	return isPresent;
	}
}
