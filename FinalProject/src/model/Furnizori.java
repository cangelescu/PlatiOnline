package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the furnizori database table.
 * 
 */
@Entity
@NamedQuery(name="Furnizori.findAll", query="SELECT f FROM Furnizori f")
public class Furnizori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFurnizor;

	private String parola;

	private double sold;

	private String username;

	//bi-directional many-to-one association to Servicii
	@OneToMany(mappedBy="furnizori")
	private List<Servicii> serviciis;

	public Furnizori() {}

	public Furnizori(int id2, String username2, String parola2) 
	{
		this.idFurnizor = id2;
		this.username = username2;
		this.parola = parola2;
	}

	public int getIdFurnizor() {
		return this.idFurnizor;
	}

	public void setIdFurnizor(int idFurnizor) {
		this.idFurnizor = idFurnizor;
	}

	public String getParola() {
		return this.parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public double getSold() {
		return this.sold;
	}

	public void setSold(double sold) {
		this.sold = sold;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Servicii> getServiciis() {
		return this.serviciis;
	}

	public void setServiciis(List<Servicii> serviciis) {
		this.serviciis = serviciis;
	}

	public Servicii addServicii(Servicii servicii) {
		getServiciis().add(servicii);
		servicii.setFurnizori(this);

		return servicii;
	}

	public Servicii removeServicii(Servicii servicii) {
		getServiciis().remove(servicii);
		servicii.setFurnizori(null);

		return servicii;
	}

}