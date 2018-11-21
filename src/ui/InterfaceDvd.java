package ui;

import java.util.Date;
import java.util.List;

import dao.DvdDao;
import dao.FilmeDao;
import model.Dvd;
import model.Filme;

public class InterfaceDvd extends InterfaceModelo {
	
	private DvdDao dvdDao = new DvdDao();
	private FilmeDao filmeDao = new FilmeDao(); 

	protected void insereDvd() {
		
		/*
		 * 
		System.out.print("\t INSERINDO DVD \n\n"
				+ "Informe título do filme: ");
		String titulo = entrada.nextLine();
		
		System.out.print("Informe o gênero: ");
		String genero = entrada.nextLine();
		
		
		System.out.print("Data de lançamento: ");
		String dataEntrada = entrada.nextLine();
		Date lancamento = new InterfacePrincipal().formataData(dataEntrada);
		
		System.out.print("Duração do filme (em minutos): ");
		long duracao = entrada.nextLong();
		
		System.out.print("Quantidade em estoque: ");
		int qtdEstoque = entrada.nextInt();
		entrada.nextLine();
		*/

		String titulo = "Homem de ferro";
		String genero = "Ação";
		String dataEntrada = "11/10/2010";
		Date lancamento = new InterfacePrincipal().formataData(dataEntrada);
		long duracao = 123;
		
		
		Filme filme = new Filme(titulo, genero, lancamento, duracao);
		Dvd dvd = new Dvd();
		
		/*
		filmeDao.pesquisaByName(titulo);
		System.out.println("Pesquisa por nome...");
		System.exit(0);
		*/
		
		filmeDao.salva(filme);
		
		dvd.setFilme(filme);
		dvd.setCod(geraRandom());
		dvd.setLocacao(false);
				
		pulaLinhas();
		System.out.println(dvdDao.salva(dvd));
	}	
	

	
	protected void removeDvd() {

		System.out.print("\t EXCLUINDO DVD \n"
				+ "Informe o id do DVD: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		
		dvdDao.remove(id);
				
		/*
		 * 
		System.out.print("\t EXCLUINDO DVD \n"
				+ "1- Por Id\n"
				+ "2- Por nome\n"
				+ "  Opção: ");		
		int op = entrada.nextInt();
		
		
		if ( op == 1 ) {
			System.out.print("Informe o id do DVD: ");
			int id = entrada.nextInt();
			entrada.nextLine();

			dvdDao.remove(id);
		}
		
		
		if ( op == 2 ) {
			System.out.print("Informe o titulo do DVD: ");
			String titulo = entrada.nextLine();
			
			//Metodo dao remove por titulo
		}
		*/
		
	}
	
	
	
	protected void listaTodosDvd() {
		
		List<Dvd> dvd = dvdDao.listaTodos();
		
		pulaLinhas();		
		System.out.println("\t LISTA DE DVDs: ");
		System.out.println("Id\t Titulo\t Gênero\t Data de lançamento\t Duração\t Cod. Dvd\n");
		
		
		for ( Dvd d: dvd ) {

			System.out.println(d.getId()+ "\t " +d.getFilme().getTitulo()+ "\t " +d.getFilme().getGenero()+ "\t " 
					+d.getFilme().getDataLancamento()+ "\t " +d.getFilme().getDuracao()+ "\t\t\t " +d.getCod());
		}
		
	}
	
}
