package ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


import dao.ClienteDao;
import dao.DvdDao;
import model.Cliente;
import model.Dvd;
import model.Endereco;


public class InterfaceCliente {

	protected Scanner entrada = new Scanner(System.in);
	

	private ClienteDao clienteDao = new ClienteDao();
	private DvdDao dvdDao = new DvdDao();
		
		
	protected void insereCliente(){		
		/*
		System.out.print("\t INSERINDO CLIENTE \n\n"
				+ "Informe o nome do cliente: ");
		String nome = entrada.nextLine();
		
		System.out.print("Informe a idade de " +nome+ ": ");
		int idade = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("CPF de " +nome+ ": ");
		String cpf = entrada.nextLine();
		
		System.out.print("Telefone de " +nome+ ": ");
		String fone = entrada.nextLine();
		
		System.out.print("Cidade de residencia: ");
		String cidade = entrada.nextLine();
		
		System.out.print("Bairro de residencia: ");
		String bairro = entrada.nextLine();
		
		System.out.print("Logradouro: ");
		String logradouro = entrada.nextLine();
		
		System.out.print("Numero residencia/apto: ");
		int nCasa = entrada.nextInt();
		entrada.nextLine();
		*/

		
		String nome = "Teste 1";
		int idade = 19;
		String cpf = "111.222.333-45";
		String fone = "47 99999-8888";
		String cidade = "Mafra";
		String bairro = "Vila Nova";
		String logradouro = "Av. Vila Nova";
		int nCasa = 4567;
		
		Endereco end = new Endereco(cidade, bairro, logradouro, nCasa);		

		//Pessoa p = new Pessoa(nome, cpf, idade, fone, end);
		
		//Cliente c = new Cliente(p, end);
		Cliente c = new Cliente(nome, cpf, idade, fone, end);
		
		clienteDao.salva(c);
	}
	
	

	protected void insereDvd() {
		System.out.print("\t INSERINDO DVD \n\n"
				+ "Informe título do filme: ");
		String titulo = entrada.nextLine();
		
		System.out.print("Informe o gênero: ");
		String genero = entrada.nextLine();
		
		
		System.out.print("Data de lançamento: ");
		String dataEntrada = entrada.nextLine();
		
		Date lancamento = null;		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			lancamento = df.parse(dataEntrada);
		} catch (ParseException e){
			e.printStackTrace();
		}
		
		
		System.out.print("Duração do filme: ");
		long duracao = entrada.nextLong();
		
		System.out.print("Quantidade em estoque: ");
		int qtdEstoque = entrada.nextInt();
		entrada.nextLine();
		
		//Filme filme = new Filme(titulo, genero, lancamento, duracao);
		
		Dvd dvd = new Dvd(titulo, genero, lancamento, duracao, qtdEstoque);
		
		dvdDao.salva(dvd);
	}
	
	
	protected void insereLocacao(){}
	
	
	
	protected void removeLocacao() {
		
	}
	
	
	
	protected void removeDvd() {
		System.out.print("\t EXCLUINDO DVD \n"
				+ "1- Por Id"
				+ "2- Por nome");		
		int op = entrada.nextInt();
		
		
		if ( op == 1 ) {
			System.out.print("Informe o titulo do filme: ");
			int id = entrada.nextInt();
			entrada.nextLine();
			
			//Metodo dao remove por Id
		}
		
		
		if ( op == 2 ) {
			System.out.print("Informe o titulo do filme: ");
			String titulo = entrada.nextLine();
			
			//Metodo dao remove por titulo
		}
		
	}
	
	
	
	protected void removeCliente() {}
	
}
