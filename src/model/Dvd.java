package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Dvd {
	
	@Id
	@GeneratedValue
	private int id;
	private int cod;
	private boolean locacao = false;
	
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;
	
	
	public Dvd() {}
	
	public Dvd(Filme filme, int cod, boolean locacao) {
		this.cod = cod;
		this.locacao = locacao;
	}	
	
	
	
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	

	public boolean isLocacao() {
		return locacao;
	}
	public void setLocacao(boolean locacao) {
		this.locacao = locacao;
	}
	
}
