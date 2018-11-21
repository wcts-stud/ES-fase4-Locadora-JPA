package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue
	private int Id;
	private int codArea;
	private String numero;
	
	//@ManyToOne
	//@JoinColumn(name="fk_pessoa", nullable=false)
	//private Pessoa pessoa;
	
	public Telefone() {}
	
	public Telefone(int cod, String numero) {
		this.codArea = cod;
		this.numero = numero;
	}
	
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	
	public int getCodArea() {
		return codArea;
	}
	public void setCodArea(int codArea) {
		this.codArea = codArea;
	}
	
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	/*
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	*/	
		
}
