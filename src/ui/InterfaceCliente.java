package ui;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import dao.PessoaDao;
import dao.TelefoneDao;
import model.Cliente;
import model.Endereco;
import model.Pessoa;
import model.Telefone;


public class InterfaceCliente extends InterfaceModelo {	

	private ClienteDao clienteDao = new ClienteDao();
	private TelefoneDao telefoneDao = new TelefoneDao();
	PessoaDao pessoaDao = new PessoaDao();
		
		
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
		
		System.out.print("Telefone 1 de " +nome+ ": ");
		String fone1 = entrada.nextLine();
				
		System.out.print("Telefone 2 de " +nome+ ": ");
		String fone2 = entrada.nextLine();
		
		System.out.print("Telefone 3 de " +nome+ ": ");
		String fone3 = entrada.nextLine();
		
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

		
		// Teste //
		
		String nome = "Teste 1";
		int idade = 19;
		String cpf = "111.222.333-45";
		
		String fone1 = "41 90000-0000";
		String fone2 = "42 91111-1111";
		String fone3 = "43 99999-9999";
		
		String cidade = "Mafra";
		String bairro = "Vila Nova";
		String logradouro = "Av. Vila Nova";
		int nCasa = 4567;
		
		
		
		
		Pessoa pessoa = new Pessoa();
		Cliente c = new Cliente();
		Telefone fone = new Telefone();
		
		
		List<Telefone> telefones = new ArrayList<Telefone>();
		
		if (fone1 != null){
			fone.setCodArea(obtemDD(fone1));
			fone.setNumero(obtemNumero(fone1));
			
			telefoneDao.salva(fone);
			telefones.add(fone);
		}
		
		if (fone2 != null){
			fone = new Telefone();;
			fone.setCodArea(obtemDD(fone2));
			fone.setNumero(obtemNumero(fone2));

			telefoneDao.salva(fone);
			telefones.add(fone);
		}
		
		if (fone3 != null){
			fone = new Telefone();;
			fone.setCodArea(obtemDD(fone3));
			fone.setNumero(obtemNumero(fone3));

			telefoneDao.salva(fone);
			telefones.add(fone);
		}		
		
		pessoa.setTelefones(telefones);		
		
		Endereco end = new Endereco(cidade, bairro, logradouro, nCasa);	

		pessoa = new Pessoa(nome, cpf, idade, telefones, end);
		System.out.println(pessoaDao.salva(pessoa));
		
		
		c.setPessoa(pessoa);
		pulaLinhas();
		System.out.println(clienteDao.salva(c));
	}
	
	
	private int obtemDD(String fone){
		int ddFone = Integer.parseInt(fone.substring(0,2));
		
		return ddFone;
	}	
	
	
	private String obtemNumero(String numero) {
		String fone = null;
		
		fone = numero.substring(2, numero.length());
		
		return fone;
	}	
	
	
	protected void removeCliente() {
		System.out.print("\t REMOVENDO CLIENTE \n"
				+ "Insira o Id do cliente a ser removido: ");
		int cliente_id = entrada.nextInt();
		
		clienteDao.remove(cliente_id);
	}	
	
	

	protected void listaTodosCliente() {
		List<Cliente> clientes = clienteDao.listaTodos();

		pulaLinhas();		
		System.out.println("\t LISTA DE CLIENTES: ");
		System.out.println("Id\t Nome\t\t CPF \t\t Idade\t Fone\t\t Aluguel\t\t Endereço\n");
				

		for ( Cliente c: clientes ) {

			System.out.println(c.getId()+ "\t " +c.getPessoa().getNome()+ "\t " +c.getPessoa().getCpf()+ "\t " +c.getPessoa().getIdade()+ 
					"\t " +c.getPessoa().getTelefones()+ "\t " +c.isLocacao()+"\t\t " 
					+c.getPessoa().getEndereco().getLogradouro()+ ", " +c.getPessoa().getEndereco().getNumeroResidencia()+ " - " 
					+c.getPessoa().getEndereco().getBairro()+ ", " +c.getPessoa().getEndereco().getCidade()
					);
		}		
		
	}
	
	
}
