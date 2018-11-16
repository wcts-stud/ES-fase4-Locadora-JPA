package ui;

import java.util.Scanner;

import model.Cliente;
import model.Endereco;


public class InterfaceCliente {

	private Scanner entrada = new Scanner(System.in);
	
	private void pulaLinhas() {
		for (int i=0; i < 15; i++) {System.out.println("\n");}
	}
	
	
	public void menuPrincipal() {
		
		int op = 0;
		
		do {
			System.out.println("\t MENU LOCADORA ");
			System.out.println("1 - Inserir locação");
			System.out.println("2 - Inserir DVD");
			System.out.println("3 - Inserir cliente");
			System.out.println("4 - Sair");
			System.out.println("Opção: ");
			
			op = entrada.nextInt();
			entrada.nextLine();
			pulaLinhas();
		} while ( op != 4);

		
		switch (op) {
			case 1: 
				insereLocacao();
				break;
			case 2: 
				insereDVD();
				break;
			case 3: 
				insereCliente();
				break;
			case 4: 
				System.exit(0);
				break;
			default:
				break;
		}
		
	}
	
	
	
	
	public void insereCliente(){		
		
		System.out.println("\t INSERINDO CLIENTE \n\n"
				+ "Informe o nome do cliente: ");
		String nome = entrada.nextLine();
		
		System.out.println("Informe a idade de " +nome+ ": ");
		int idade = entrada.nextInt();
		entrada.nextLine();
		
		System.out.println("CPF de " +nome+ ": ");
		String cpf = entrada.nextLine();
		
		System.out.println("Telefone de " +nome+ ": ");
		String fone = entrada.nextLine();
		
		System.out.println("Cidade de residencia: ");
		String cidade = entrada.nextLine();
		
		System.out.println("Bairro de residencia: ");
		String bairro = entrada.nextLine();
		
		System.out.println("Logradouro: ");
		String logradouro = entrada.nextLine();
		
		System.out.println("Numero residencia/apto: ");
		int nCasa = entrada.nextInt();
		entrada.nextLine();
		
		
		Endereco end = new Endereco(cidade, bairro, logradouro);
		
		
		Cliente c = new Cliente(nome, cpf, idade, fone, end, nCasa);
		
	}
	

	public void insereDVD() {}
	
	
	public void insereLocacao(){}
	
	
}
