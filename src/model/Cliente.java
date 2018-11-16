package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import dao.Bean;

@Entity
public class Cliente extends Pessoa implements Bean {
	
	@Id
	@GeneratedValue
	private long id;
	private boolean locacao;
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
	private List<Dvd> filmeLocado;

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
		return (Dvd) filmeLocado;
	}

	public void setFilmeLocado(Dvd filmeLocado) {
		this.filmeLocado = (List<Dvd>) filmeLocado;
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
