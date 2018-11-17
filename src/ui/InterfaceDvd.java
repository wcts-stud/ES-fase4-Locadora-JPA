package ui;

import java.util.Date;

import dao.DvdDao;
import model.Dvd;

public class InterfaceDvd extends InterfaceModelo {
	
	private DvdDao dvdDao = new DvdDao();

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
		int qtdEstoque = 3;
		
		
		//Filme filme = new Filme(titulo, genero, lancamento, duracao);
		
		Dvd dvd = new Dvd(titulo, genero, lancamento, duracao, qtdEstoque);
		
		dvdDao.salva(dvd);
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
	
	
	
	
}
