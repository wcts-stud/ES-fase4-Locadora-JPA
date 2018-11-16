package model;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
	private boolean locacao;
	private int numeroCasa;

	public Cliente(String nome, String cpf, int idade, String fone, Endereco endereco, int numeroCasa) {
		super(nome, cpf, idade, fone, endereco);
		this.locacao = false;
		this.numeroCasa = numeroCasa;
	}
	
	

}
