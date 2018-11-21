package model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {	
	
	private boolean locacao;

	

	public Cliente() {}
	
	public Cliente(String nome, String cpf, int idade, List<Telefone> fones, Endereco endereco) {
		super(nome, cpf, idade, fones, endereco);
		this.locacao = false;
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
