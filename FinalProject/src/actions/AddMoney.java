package actions;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javafx.scene.control.TextField;
import model.Clienti;

public class AddMoney extends Thread {

	private TextField addMoneyField;
	private String clientUsername;

	public Clienti fromServer;
	private static final int PORT = 8899;

	public AddMoney(TextField addMoneyField, String clientUsername2) {
		this.addMoneyField = addMoneyField;
		clientUsername = clientUsername2;
	}

	public void run() {

		Clienti clientAccountUpdated = new Clienti();
		clientAccountUpdated.setUsername(clientUsername);
		clientAccountUpdated.setSoldDisponibil(Double.parseDouble(addMoneyField.getText()));
		String localHostAdress = new String();

		try (Socket clientSocket = new Socket(localHostAdress, PORT);) {

			OutputStream out = clientSocket.getOutputStream();
			ObjectOutputStream objectOutput = new ObjectOutputStream(out);

			objectOutput.writeObject(new Actions(Actions.loginUser));
			objectOutput.writeObject(clientAccountUpdated);
			objectOutput.flush();

			InputStream in = clientSocket.getInputStream();
			ObjectInputStream objectInput = new ObjectInputStream(in);

			try {
				Object message = objectInput.readObject();
				System.out.println("merge");
				System.out.println("Message: " + message);
				in.close();
				out.close();
				fromServer = (Clienti) message;
				Thread.sleep(100);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("CLIENT FROM ClientAPP");
			System.out.println(objectInput.toString());
			try {
				clientSocket.close();
			} catch (IOException e) {
				System.out.println("Socket could not be closed");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public Clienti getClient() {
		return this.fromServer;
	}

}
