package actions;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Clienti;

public class RegisterClient extends Thread {
	@FXML TextField usernameText;
	@FXML TextField nameText;
	@FXML TextField emailText;
	@FXML TextField passwordText;
	@FXML TextField repasswordText;

	private static final int PORT = 8899;

	public RegisterClient(TextField usernameText, TextField nameText, TextField emailText, TextField passwordText,
			TextField repasswordText) {
		this.usernameText = usernameText;
		this.nameText = nameText;
		this.emailText = emailText;
		this.passwordText = passwordText;
		this.repasswordText = repasswordText;
	}

	@Override
	public void run() {

		Clienti c = new Clienti();
		c.setUsername(usernameText.getText());
		c.setName(nameText.getText());
		if (emailText.getText().contains("@") && emailText.getText().contains("."))
			c.setEmail(emailText.getText());
		else 
			System.out.println("adresa de mail invalida");
		if (passwordText.getText().compareTo(repasswordText.getText()) == 0)
			c.setParola(passwordText.getText());
		else 
			System.out.println("parola");

		String localHostAdress = new String();

		try (Socket clientSocket = new Socket(localHostAdress, PORT);) {
			// creating a socket to connect to the server
			System.out.println("Connected to localhost in port " + PORT);
			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.writeObject(new Actions(Actions.registerUser));
			out.writeObject(c);
			out.flush();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		usernameText.clear();
		passwordText.clear();
		nameText.clear();
		emailText.clear();
		repasswordText.clear();
	}

}
