package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente {	
	
	@Id
	@GeneratedValue
	private int id;
	private boolean locacao;
	
	@OneToOne
	private Pessoa pessoa;
	

	public Cliente() {}
	
	public Cliente(Pessoa p) {
		this.locacao = false;
	}
	
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	

	public boolean isLocacao() {
		return locacao;
	}
	public void setLocacao(boolean locacao) {
		this.locacao = locacao;
	}	
	
	/*
	public Dvd getFilmeLocado() {
		return (Dvd) filmeLocado;
	}

	public void setFilmeLocado(Dvd filmeLocado) {
		this.filmeLocado = (List<Dvd>) filmeLocado;
	}
	*/
	

}
