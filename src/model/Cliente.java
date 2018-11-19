package model;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
	
	
	private boolean locacao;


	public Cliente() {}
	
	public Cliente(String nome, String cpf, int idade, String fone, Endereco endereco) {
		super(nome, cpf, idade, fone, endereco);
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
