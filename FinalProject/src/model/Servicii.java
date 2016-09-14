package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the servicii database table.
 * 
 */
@Entity
@NamedQuery(name="Servicii.findAll", query="SELECT s FROM Servicii s")
public class Servicii implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date perioadaMinima;

	private double pret;

	private String tipServiciu;

	//bi-directional many-to-one association to Clientservice
	@OneToMany(mappedBy="servicii")
	private List<Clientservice> clientservices;

	//bi-directional many-to-one association to Furnizori
	@ManyToOne
	@JoinColumn(name="idFurnizor")
	private Furnizori furnizori;

	public Servicii() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPerioadaMinima() {
		return this.perioadaMinima;
	}

	public void setPerioadaMinima(Date perioadaMinima) {
		this.perioadaMinima = perioadaMinima;
	}

	public double getPret() {
		return this.pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public String getTipServiciu() {
		return this.tipServiciu;
	}

	public void setTipServiciu(String tipServiciu) {
		this.tipServiciu = tipServiciu;
	}

	public List<Clientservice> getClientservices() {
		return this.clientservices;
	}

	public void setClientservices(List<Clientservice> clientservices) {
		this.clientservices = clientservices;
	}

	public Clientservice addClientservice(Clientservice clientservice) {
		getClientservices().add(clientservice);
		clientservice.setServicii(this);

		return clientservice;
	}

	public Clientservice removeClientservice(Clientservice clientservice) {
		getClientservices().remove(clientservice);
		clientservice.setServicii(null);

		return clientservice;
	}

	public Furnizori getFurnizori() {
		return this.furnizori;
	}

	public void setFurnizori(Furnizori furnizori) {
		this.furnizori = furnizori;
	}

}