package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MainPage;
import resources.base;

public class LoginTests extends base{

	@BeforeMethod
	public void initialaze() throws IOException {
		driver = initiaslazeDriver();
	}
	@AfterMethod 
	public void terDown (){
		driver.manage().deleteAllCookies();
		driver.close();
		driver=null;
	}
	
	@Test(priority=0)
	public void successfulLogIn() {
		LoginPage lp = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		lp.accountName().sendKeys(prop.getProperty("CorrectName"));
		lp.passwordField().sendKeys(prop.getProperty("CorrectPass"));
		lp.logInButton().click();
		MainPage mp = new MainPage(driver);
		if  (mp.isAssistantMenuPresent()) {
			String welcomeText=mp.welcomeAssistant().getText();
			AssertJUnit.assertEquals(welcomeText, "Welcome to APARAVI");
			AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://qa.aparavi.com/#dashboard");
			mp.closeAssistantButton().click();
			System.out.println(welcomeText +" text displayed. Login sucsessful");
		}
		else {
			AssertJUnit.assertTrue(mp.logoutButton().isDisplayed());
			AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://qa.aparavi.com/#dashboard");
			System.out.println("Logout Button displayed. Login sucsessful");
		}
	}
	@Test(priority=1)
	public void successfulLogOut() {
		LoginPage lp = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		lp.accountName().sendKeys(prop.getProperty("CorrectName"));
		lp.passwordField().sendKeys(prop.getProperty("CorrectPass"));
		lp.logInButton().click();
		MainPage mp = new MainPage(driver);
		if  (mp.isAssistantMenuPresent()) {
			mp.closeAssistantButton().click();
		}
		mp.logoutButton().click();
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://qa.aparavi.com/#login");
		driver.get("https://qa.aparavi.com/#dashboard");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='assist-inline']/input[@type='text']")));
		AssertJUnit.assertTrue(driver.getCurrentUrl().contains("#login"));
	}
	@Test(priority=2)
	public void invalidUsername() {
		LoginPage lp = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		lp.accountName().sendKeys(prop.getProperty("InvalidName"));
		lp.passwordField().sendKeys(prop.getProperty("CorrectPass"));
		lp.logInButton().click();
		//System.out.println(lp.ErrorName());
		Assert.assertTrue(lp.isEroorPresent());
		Assert.assertTrue(lp.errorMessageText().contains("account"));
	}
	@Test(priority=3)
	public void invalidPassword() {
		LoginPage lp = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		lp.accountName().sendKeys(prop.getProperty("CorrectName"));
		lp.passwordField().sendKeys(prop.getProperty("InvalidPass"));
		lp.logInButton().click();
		//System.out.println(lp.ErrorName());
		Assert.assertTrue(lp.isEroorPresent());
		Assert.assertTrue(lp.errorMessageText().contains("The password is invalid"));
	}
}
