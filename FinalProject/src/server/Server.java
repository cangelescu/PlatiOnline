package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import actions.Actions;
import db.ClientiDAOMySQL_impl;
import model.Clienti;

public class Server {

	private static final int PORT = 8899;

	public static void main(String[] args) throws ClassNotFoundException {

		try (ServerSocket serverSocket = new ServerSocket(PORT);){

			try{				
				while (true) {
					Socket clientSocket = serverSocket.accept();
					
					EntityManagerFactory factory = Persistence.createEntityManagerFactory("FinalProject");
					EntityManager em = factory.createEntityManager();
					
					InputStream in = clientSocket.getInputStream();
					ObjectInputStream objectInput = new ObjectInputStream(in);
					
					try{
						Object obj = new Object();
						obj = objectInput.readObject();
						if (obj instanceof Actions){
							Actions tmp = (Actions) obj;
							switch (tmp.value) {
							case Actions.loginUser:
								System.out.println("incerc logarea");
								Object loginObj = objectInput.readObject();
								Clienti c = (Clienti) loginObj;
								System.out.println(loginObj.toString());
								ClientiDAOMySQL_impl allClient = new ClientiDAOMySQL_impl();
								List<Clienti> l = allClient.getAll();
								for (int i = 0; i < l.size(); i++) {
									if (c.getUsername().equals(l.get(i).getUsername())
											&& c.getParola().equals(l.get(i).getParola())){
										System.out.println("gasit");
										OutputStream outLogin = clientSocket.getOutputStream();
										ObjectOutputStream objectOutput = new ObjectOutputStream(outLogin);
										objectOutput.writeObject(c);
										}
									else 
										System.out.println("username sau parola incorecta");
									}
								break;
								
							case Actions.registerUser:
								Object registerObj = objectInput.readObject();
								System.out.println(registerObj.toString());
								em.getTransaction().begin();
								em.persist(registerObj);
								em.getTransaction().commit();
								System.out.println("am adaugat");
								break;
								
							}
						}
					}
					catch(IOException e){
						e.printStackTrace();
					}
				}				
			}
			catch(IOException e){
				e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
