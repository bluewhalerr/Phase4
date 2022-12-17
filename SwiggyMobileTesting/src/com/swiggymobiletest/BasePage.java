package com.swiggymobiletest;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	
	AndroidDriver<AndroidElement> driver;

	@Test
	public void swiggyApplication() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		
		//(1)App Installing
		File appdir = new File("src/com/swiggymobiletest/Swiggy Food & Grocery Delivery_4.21.2_Apkpure.apk");
		caps.setCapability("deviceName","emulator-5556");
		caps.setCapability(MobileCapabilityType.APP,appdir.getAbsolutePath());
		caps.setCapability("platformName","Android");
		caps.setCapability("platformVersion","9.0");
		caps.setCapability("noReset","true");
		caps.setCapability("appPackageName","in.swiggy.android");
		caps.setCapability("appActivityName","in.swiggy.android.activities.OfferActivityV2");
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),caps);
       
		
        //2)Location Deny
		Thread.sleep(5000);	
		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Location Permission is Off,Granting location permission will ensure accurate address and hassle free delivery\"]/android.widget.TextView")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("com.android.packageinstaller:id/permission_deny_button")).click();
		Thread.sleep(2000);
		
		//3)Searching for food
		driver.findElement(By.id("in.swiggy.android:id/disc_search_bar_container")).click();
		Thread.sleep(6000);
		driver.pressKey(new KeyEvent().withKey(AndroidKey.M));
		driver.pressKey(new KeyEvent().withKey(AndroidKey.A));
		driver.pressKey(new KeyEvent().withKey(AndroidKey.R));
		driver.pressKey(new KeyEvent().withKey(AndroidKey.G));
		driver.pressKey(new KeyEvent().withKey(AndroidKey.H));
		
		//4)Selecting Food
		Thread.sleep(3000);
		TouchAction a1 = new TouchAction(driver);
		a1.tap(PointOption.point(390,620)).perform();
	
		//5)Adding Food To cart and Proceeding to payment
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"add button\"])[2]/android.view.ViewGroup/android.widget.TextSwitcher/android.widget.TextView")).click();
		
		Thread.sleep(3000);
		a1.tap(PointOption.point(780,2160)).perform();
		Thread.sleep(3000);
		a1.tap(PointOption.point(790,2164)).perform();
		Thread.sleep(3000);
		a1.tap(PointOption.point(790,2164)).perform();
		Thread.sleep(3000);
		Thread.sleep(5000);
		a1.press(PointOption.point(756,2149)).perform();
	}
	
	

}
