package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clienti database table.
 * 
 */
@Entity(name="clienti")
@Table(name="clienti")
@NamedQuery(name="Clienti.findAll", query="SELECT c FROM clienti c")
public class Clienti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClient;

	private Integer autopay;

	private String email;

	private String name;

	private String parola;

	private double soldDisponibil;

	private String username;

	//bi-directional many-to-one association to Clientservice
	@OneToMany(mappedBy="clienti")
	private List<Clientservice> clientservices;

	public Clienti() {}

	

	public Clienti(int idClient, String name, String username, String parola, String email)
	{
		super();
		this.idClient = idClient;
		this.name = name;
		this.username = username;
		this.parola = parola;
		this.email = email;
	
	}
	
	public Clienti(String username, String parola)
	{
		super();
		this.username = username;
		this.parola = parola;

	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Integer getAutopay() {
		return this.autopay;
	}

	public void setAutopay(Integer autopay) {
		this.autopay = autopay;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParola() {
		return this.parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public double getSoldDisponibil() {
		return this.soldDisponibil;
	}

	public void setSoldDisponibil(double soldDisponibil) {
		this.soldDisponibil = soldDisponibil;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Clientservice> getClientservices() {
		return this.clientservices;
	}

	public void setClientservices(List<Clientservice> clientservices) {
		this.clientservices = clientservices;
	}

	public Clientservice addClientservice(Clientservice clientservice) {
		getClientservices().add(clientservice);
		clientservice.setClienti(this);

		return clientservice;
	}

	public Clientservice removeClientservice(Clientservice clientservice) {
		getClientservices().remove(clientservice);
		clientservice.setClienti(null);

		return clientservice;
	}
		
	@Override
	public String toString() {
		return "Clienti [idClient=" + idClient + ", autopay=" + autopay + ", email=" + email + ", name=" + name
				+ ", parola=" + parola + ", soldDisponibil=" + soldDisponibil + ", username=" + username
				+ ", clientservices=" + clientservices + "]";
	}

}