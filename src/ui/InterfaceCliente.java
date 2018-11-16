package ui;

import java.util.Scanner;

import dao.ClienteDao;
import model.Cliente;
import model.Endereco;


public class InterfaceCliente {

	protected Scanner entrada = new Scanner(System.in);
	

	private ClienteDao dao = new ClienteDao();
		
		
	protected void insereCliente(){		
		
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
		
		
		Endereco end = new Endereco(cidade, bairro, logradouro, nCasa);		
		Cliente c = new Cliente(nome, cpf, idade, fone, end);
		
		dao.salva(c);
	}
	
	

	protected void insereDvd() {}
	
	
	
	protected void insereLocacao(){}
	
	
	
	protected void removeLocacao() {}
	protected void removeDvd() {}
	protected void removeCliente() {}
	
}
