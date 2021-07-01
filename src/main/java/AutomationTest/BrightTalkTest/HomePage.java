package AutomationTest.BrightTalkTest;

import static AutomationTest.BrightTalkTest.LoadProp.getproperty;

import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;



public class HomePage extends BasePage {
	
	 public HomePage() {
	        PageFactory.initElements(driver, this);
	    }

    public static void homePage() throws InterruptedException {
    	
    	
        driver.get(getproperty("url"));
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Thread.sleep(3000);
        String expectedTitle = "Stack Overflow - Where Developers Learn, Share, & Build Careers";
        //Assert.assertEquals(expectedTitle, actualTitle,"Home Page title is not matched !!");
    }
}
