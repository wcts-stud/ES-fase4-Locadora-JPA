package model;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Dvd extends Filme {
	
	private int estoque;
	private boolean locacao = false;
	
	/*
	@ManyToOne(cascade=CascadeType.ALL)
	
	@JoinColumn(name="cliente_id")
		@JoinColumn(name="cliente_id"),
		@JoinColumn(name="pessoa_id")
	private Cliente cliente;
	*/
	
	public Dvd() {}
	
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
	

	public boolean isLocacao() {
		return locacao;
	}
	public void setLocacao(boolean locacao) {
		this.locacao = locacao;
	}
	
}
