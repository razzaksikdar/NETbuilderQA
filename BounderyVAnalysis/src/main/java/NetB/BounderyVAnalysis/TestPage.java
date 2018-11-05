package NetB.BounderyVAnalysis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPage {
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/form/div/div[1]/input")
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
