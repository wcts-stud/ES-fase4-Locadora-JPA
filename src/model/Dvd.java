package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Dvd extends Filme {
	
	@Id
	@GeneratedValue
	private int id;
	private int estoque;
	@ManyToOne
	private Cliente cliente;

	
	public Dvd(String titulo, String genero, Date dataLancamento, long duracao, int estoque) {
		super(titulo, genero, dataLancamento, duracao);
		this.estoque = estoque;
	}

	
	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}


	
}
