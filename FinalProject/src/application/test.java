package application;

import java.util.List;
import db.ClientiDAOMySQL_impl;
import model.Clienti;

//returneaza lista de clienti din db
public class test {
	public static void main(String args[]){
		ClientiDAOMySQL_impl allClient = new ClientiDAOMySQL_impl();
		List<Clienti> l = allClient.getAll();
		for (int i = 0; i < l.size(); i++) {
			System.out.println("test");
			System.out.println(l.get(i).toString());		
		}
	}
}