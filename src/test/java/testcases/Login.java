package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import config.Setup;
import config.Url;
import object.Alert;
import object.Button;
import object.Input;
import utility.ReadExcel;

public class Login extends Setup {
	
	public String pathDataTest = "../ui/src/test/java/datatest/data.xlsx";
	
	@DataProvider
	public String[][] dataLogin() throws InvalidFormatException, IOException {
		ReadExcel readExcel = new ReadExcel();
		
		return readExcel.getCellData(pathDataTest, "login");
	}
	
	@Test(priority = 0, dataProvider = "dataLogin")
	public void loginPositive(String username, String password, String emailDisplay) {
		
		Url url = new Url();
		Input input = new Input(driver);
		Button button = new Button(driver);
		Alert alert = new Alert(driver);
		
		String urlLogin = url.urls("/login");
		
		
		driver.get(urlLogin);
		input.byId("username", username);
		input.byId("password", password);
		button.byId("btnLogin");
		
		button.byClassByIndex("nav-link", 5);
		alert.byId("email", emailDisplay);	
	}

}
