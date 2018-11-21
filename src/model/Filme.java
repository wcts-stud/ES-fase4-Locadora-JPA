package model;

import java.util.Collection;
//import java.sql.Date;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Filme {
	
	@Id
	@GeneratedValue
	private int id;
	private String titulo;
	private String genero;
	@Temporal(TemporalType.DATE)
	private Date dataLancamento;
	private long duracao;
	
	@OneToMany(
		mappedBy="filme",
		cascade = CascadeType.ALL)
	private Collection<Dvd> dvds;
	
	
	
	public Filme() {}
	

	public Filme(String titulo, String genero, Date dataLancamento, long duracao) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.dataLancamento = dataLancamento;
		this.duracao = duracao;
	}	
	
	
		
	public Collection<Dvd> getDvds() {
		return dvds;
	}

	public void setDvds(Collection<Dvd> dvds) {
		this.dvds = dvds;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Date getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}


	public long getDuracao() {
		return duracao;
	}
	public void setDuracao(long duracao) {
		this.duracao = duracao;
	}
	
}
