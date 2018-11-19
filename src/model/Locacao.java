package model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Locacao {

	@Id
	@GeneratedValue
	private int id;
	@Transient
	@Temporal(TemporalType.DATE)
	private Date aluguel = new Date();
	@Temporal(TemporalType.DATE)
	private Date devolucao = new Date();
	
	// Um dvd tem muitas locacoes;
	@ManyToOne
	@JoinColumn(name="dvd_id")
	private Dvd dvd;

	// Um cliente tem muitas locações;
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	
	
	public Locacao() {}
	
	public Locacao(Date dataAluguel, Date dataDevolucao, Dvd dvd, Cliente cliente) {
		this.aluguel = dataAluguel;
		this.devolucao = dataDevolucao;
		this.cliente = cliente;
		this.dvd = dvd;
	}
	
		
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public Date getAluguel() {
		return aluguel;
	}
	public void setAluguel(Date aluguel) {
		this.aluguel = aluguel;
	}
	
	
	public Date getDevolucao() {
		return devolucao;
	}
	public void setDevolucao(Date devolucao) {		
		this.devolucao = devolucao;
	}

	
	public void setDvd(Dvd dvd) {
		this.dvd = dvd;
		//this.dvd.setEstoque(this.dvd.getEstoque() -1);
	}	
	public Dvd getDvd() {
		return dvd;
	}
	

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		//this.cliente.setLocacao(true);
	}
	
}
