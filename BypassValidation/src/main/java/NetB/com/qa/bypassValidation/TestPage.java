package NetB.com.qa.bypassValidation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPage {
	@FindBy(xpath="/html/body/div[2]/div/div/form/div/div/div/div/input")
	private WebElement inputField;
	
	@FindBy(xpath = "/html/body") 
	private static WebElement thePage;
	
	public void inputField(String input)
	{
		inputField.click();
		inputField.clear();
		inputField.sendKeys(input);
		inputField.submit();
	}
	
	public static Boolean confirmation(String input) {
		
		String retrievedText = thePage.getText();

		Boolean status = retrievedText.contains(input);
		
		return status;
	}
}
