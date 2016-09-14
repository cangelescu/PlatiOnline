package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clientservice database table.
 * 
 */
@Entity
@NamedQuery(name="Clientservice.findAll", query="SELECT c FROM Clientservice c")
public class Clientservice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Clienti
	@ManyToOne
	@JoinColumn(name="idClient")
	private Clienti clienti;

	//bi-directional many-to-one association to Servicii
	@ManyToOne
	@JoinColumn(name="idServiciu")
	private Servicii servicii;

	//bi-directional many-to-one association to Facturi
	@OneToMany(mappedBy="clientservice")
	private List<Facturi> facturis;

	public Clientservice() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Clienti getClienti() {
		return this.clienti;
	}

	public void setClienti(Clienti clienti) {
		this.clienti = clienti;
	}

	public Servicii getServicii() {
		return this.servicii;
	}

	public void setServicii(Servicii servicii) {
		this.servicii = servicii;
	}

	public List<Facturi> getFacturis() {
		return this.facturis;
	}

	public void setFacturis(List<Facturi> facturis) {
		this.facturis = facturis;
	}

	public Facturi addFacturi(Facturi facturi) {
		getFacturis().add(facturi);
		facturi.setClientservice(this);

		return facturi;
	}

	public Facturi removeFacturi(Facturi facturi) {
		getFacturis().remove(facturi);
		facturi.setClientservice(null);

		return facturi;
	}

}