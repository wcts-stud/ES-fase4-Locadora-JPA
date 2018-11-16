package model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import dao.Bean;

@Entity
public class Cliente extends Pessoa implements Bean {
	
	private long id;
	private boolean locacao;
	@OneToMany
	private Dvd filmeLocado;

	public Cliente(String nome, String cpf, int idade, String fone, Endereco endereco) {
		super(nome, cpf, idade, fone, endereco);
		this.locacao = false;
		this.filmeLocado = null;
	}
	
	

	public boolean isLocacao() {
		return locacao;
	}

	public void setLocacao(boolean locacao) {
		this.locacao = locacao;
	}	
	

	public Dvd getFilmeLocado() {
		return filmeLocado;
	}

	public void setFilmeLocado(Dvd filmeLocado) {
		this.filmeLocado = filmeLocado;
	}



	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}



	@Override
	public void setId(Long id) {
		this.id = id;
		
	}
	

}
