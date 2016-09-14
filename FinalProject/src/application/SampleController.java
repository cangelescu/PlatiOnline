package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import actions.LoginClient;
import actions.RegisterClient;
import model.Clienti;

public class SampleController implements Initializable {
	
	@FXML Button loginButton;
	@FXML Button findButton;
	@FXML Button createAccountButton;
	@FXML TextField loginUsernameText;
	@FXML TextField loginPasswordText;
	@FXML TextField findEmailText;
	@FXML TextField usernameText;
	@FXML TextField nameText;
	@FXML TextField emailText;
	@FXML TextField passwordText;
	@FXML TextField repasswordText;
	
	@FXML
	public void loginButtonAction(ActionEvent event) {
		LoginClient loginClient = new LoginClient(loginUsernameText, loginPasswordText);
		loginClient.start();

		try {
			loginClient.join();

		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Clienti objectInput = loginClient.getClient();
		if (objectInput != null){
			new ClientPanelWindow();
			System.out.println("m-am logat");
		}
		else
			System.out.println("nu stiu ce se intampla");
	}

	@FXML
	public void createAccountButtonAction(ActionEvent event) {
		System.out.println("buton apasat");
		RegisterClient registerClient = new RegisterClient(usernameText, nameText, emailText, passwordText,
				repasswordText); 
		registerClient.start();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
}