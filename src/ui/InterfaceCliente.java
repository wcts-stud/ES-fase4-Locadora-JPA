package ui;

import java.util.List;

import dao.ClienteDao;
import model.Cliente;
import model.Dvd;
import model.Endereco;
import model.Locacao;


public class InterfaceCliente extends InterfaceModelo {

	

	private ClienteDao clienteDao = new ClienteDao();
		
		
	protected void insereCliente(){		
		/*
		 * 
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
	
	
	
	
	protected void removeCliente() {
		System.out.print("\t REMOVENDO CLIENTE \n"
				+ "Insira o Id do cliente a ser removido: ");
		int cliente_id = entrada.nextInt();
		
		clienteDao.remove(cliente_id);
	}	
	
	

	protected void listaTodosCliente() {
		List<Cliente> clientes = clienteDao.listaTodos();
		//String nome, String cpf, int idade, String fone, Endereco endereco) {

		InterfacePrincipal.pulaLinhas();		
		System.out.println("\t LISTA DE CLIENTES: ");
		System.out.println("Id\t Nome\t\t CPF \t\t Idade\t Fone\t\t\t Endereço\n");
				

		for ( Cliente c: clientes ) {

			System.out.println(c.getId()+ "\t " +c.getNome()+ "\t " +c.getCpf()+ "\t " +c.getIdade()+ 
					"\t " +c.getTelefone()+ "\t\t " 
					+c.getEndereco().getLogradouro()+ ", " +c.getEndereco().getNumeroResidencia()+ " - " 
					+c.getEndereco().getCidade()+ ", " +c.getEndereco().getBairro()					
					);
		}
		
		
	}
	
	
}
