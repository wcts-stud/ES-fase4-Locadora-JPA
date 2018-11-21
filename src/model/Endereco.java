package model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	
	private String cidade;
	private String bairro;
	private String logradouro;
	private int numeroResidencia;
	
	public Endereco(){}
	
	public Endereco(String cidade, String bairro, String logradouro, int numeroResidencia) {
		this.cidade = cidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numeroResidencia = numeroResidencia;
	}
	
	
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	

	public int getNumeroResidencia() {
		return numeroResidencia;
	}
	public void setNumeroResidencia(int numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}
	
}
