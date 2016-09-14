package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the facturi database table.
 * 
 */
@Entity
@NamedQuery(name="Facturi.findAll", query="SELECT f FROM Facturi f")
public class Facturi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double amenda;

	@Temporal(TemporalType.DATE)
	private Date dataEmitere;

	@Temporal(TemporalType.DATE)
	private Date dataScadenta;

	private byte isPaid;

	private double soldTotal;

	//bi-directional many-to-one association to Clientservice
	@ManyToOne
	@JoinColumn(name="clientServiceId")
	private Clientservice clientservice;

	public Facturi() {}

	public Facturi(int id2, java.sql.Date dataEmitere2, java.sql.Date dataScadenta2, double amenda2,double soldTotal2) 
	{
		this.id = id2;
		this.dataEmitere = dataEmitere2;
		this.dataScadenta = dataScadenta2;
		this.soldTotal = soldTotal2;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmenda() {
		return this.amenda;
	}

	public void setAmenda(double amenda) {
		this.amenda = amenda;
	}

	public Date getDataEmitere() {
		return this.dataEmitere;
	}

	public void setDataEmitere(Date dataEmitere) {
		this.dataEmitere = dataEmitere;
	}

	public Date getDataScadenta() {
		return this.dataScadenta;
	}

	public void setDataScadenta(Date dataScadenta) {
		this.dataScadenta = dataScadenta;
	}

	public byte getIsPaid() {
		return this.isPaid;
	}

	public void setIsPaid(byte isPaid) {
		this.isPaid = isPaid;
	}

	public double getSoldTotal() {
		return this.soldTotal;
	}

	public void setSoldTotal(double soldTotal) {
		this.soldTotal = soldTotal;
	}

	public Clientservice getClientservice() {
		return this.clientservice;
	}

	public void setClientservice(Clientservice clientservice) {
		this.clientservice = clientservice;
	}

}