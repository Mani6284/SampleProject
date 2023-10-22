package com.testng.attributes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.base.utils.BaseClass;

public class ThreadPoolSize extends BaseClass{

	@Test(invocationCount=5, threadPoolSize=2)
	public void searchJava() {
		browserOpen("chrome");
		loadUrl("https://www.google.com/");
		WebElement search = driver.findElement(By.name("q"));
		dataSend(search, "Java");
		//search.sendKeys("Java", Keys.ENTER);
		search.submit();
		pageClose();
	}
}
