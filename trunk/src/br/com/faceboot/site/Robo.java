package br.com.faceboot.site;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Robo {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.facebook.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void logar(String email, String senha) throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		// driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(senha);
		driver.findElement(By.xpath("//label/input")).click();
		//driver.findElement(By.linkText("Página inicial")).click();

	}

	public void postar(String link, String texto) throws Exception {
		driver.get(link);
		try {
			driver.findElement(By.xpath("//span[2]/span[2]/a/span")).click();
		} catch (Exception e) {
			System.out.println("não curtiu!!!!");
			driver.findElement(By.xpath("//span/a/span")).click();
			driver.findElement(By.xpath("//span[2]/span[2]/a/span")).click();
		}
		driver.findElement(By.name("add_comment_text_text")).clear();
		driver.findElement(By.name("add_comment_text_text")).sendKeys(texto);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

	}

	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alert.getText();
		} finally {
			acceptNextAlert = true;
		}
	}

}
