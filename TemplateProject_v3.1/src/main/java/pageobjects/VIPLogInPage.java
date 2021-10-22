package pageobjects;

import org.apache.poi.ss.usermodel.Textbox;
import org.openqa.selenium.By;
import auto.framework.PageBase;
import auto.framework.web.Element;
import auto.framework.web.TextBox;

public class VIPLogInPage extends PageBase{
	
	public static final VIPLogin vipLogIn = new VIPLogin();
	
	public static class VIPLogin extends Element{
		
		public final Element LogInButton;
		
		public VIPLogin() {
			super("Container", By.className("mainContainer"));
			
			LogInButton = new Element("Log In Button", By.xpath("//button[@class='login-block__button']"), this);
			
		}
	}
	
	public static final VIPSignin vipSignIn = new VIPSignin();
	
	public static class VIPSignin extends Element{
		
		public final Element AcnEmployeeButton;
		
		public VIPSignin() {
			super("Container", By.className("container"));
			
			AcnEmployeeButton = new Element("Accenture Employee Button", By.xpath("//input[@class='btn btn-info idpButton-customizable']"), this);
			
		}
	}
	
	public static final MicrosoftSignIn microsoftSignIn = new MicrosoftSignIn();
	
	public static class MicrosoftSignIn extends Element{
		
		public final TextBox EmailTextbox;
		public final Element NextButton;
		
		public MicrosoftSignIn() {
			super("Container", By.className("middle"));
			
			EmailTextbox = new TextBox("Email Textbox", By.xpath("//*[@id='i0116']"), this);
			NextButton = new Element("Next Button", By.xpath("//*[@id='idSIButton9']"), this);
			
		}
	}
	
	public static final ESO eso = new ESO();
	
	public static class ESO extends Element{
		
		public final TextBox PasswordTextbox;
		public final TextBox EIDTextbox;
		public final Element SignInButton;
		
		public ESO() {
			super("Container", By.id("formsAuthenticationArea"));
			
			EIDTextbox = new TextBox("EID Textbox", By.xpath("//*[@id='userNameInput']"), this);
			PasswordTextbox = new TextBox("Password Textbox", By.xpath("//*[@id='passwordInput']"), this);
			SignInButton = new Element("SignIn Button", By.xpath("//*[@id='submitButton']"), this);
			
		}
	}
	
	public static final OldArch oldArch = new OldArch();
	
	public static class OldArch extends Element{
		
		public final Element NewArchButton;
		
		public OldArch() {
			super("Container", By.id("user-navbar"));
			
			NewArchButton = new TextBox("New Arch Button", By.xpath("//*[@id='newArchBtn']"), this);
			
		}
	}
}