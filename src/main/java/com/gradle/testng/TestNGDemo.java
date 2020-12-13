package com.gradle.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo {

	//Git Pull Testing
	private WebDriver driver;
	
	@BeforeTest
	public void init() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/");
		System.out.println("Initializing Driver....");
	}

	@AfterTest()
	public void terminate() {
		System.out.println("Terminating Driver...");
		driver.quit();
	}

	@Test
	public void webTest() {
		try {
			driver.get("http://localhost:8080/");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void webTitleTest() {
		try {
			String title = driver.getTitle();
			System.out.println(title);
			Assert.assertEquals(title, "Spring Framework Guru");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Test
	public void webTagTest() {
		try {
			String tagValue = driver.findElement(By.tagName("h3")).getText();
			System.out.println(tagValue);
			Assert.assertEquals(tagValue, "Spring Boot Web App");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
