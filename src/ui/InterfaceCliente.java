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
		Endereco end = new Endereco(cidade, bairro, logradouro, nCasa);	
		
		
		/*
		 * 
		 * NECESSARIO PASSAR ID DE PESSOA PARA TELEFONE
		 * 
		 */

		//pessoa = new Pessoa(nome, cpf, idade, telefones, end);
		pessoa.setNome(nome);
		pessoa.setIdade(idade);
		pessoa.setCpf(cpf);
		pessoa.setEndereco(end);
		System.out.println(pessoaDao.salva(pessoa));
		
		List<Telefone> telefones = new ArrayList<Telefone>();
		
		if (fone1 != null){
			fone.setCodArea(obtemDD(fone1));
			fone.setNumero(obtemNumero(fone1));
			fone.setPessoa(pessoa);
			
			telefoneDao.salva(fone);
			telefones.add(fone);
		}
		
		if (fone2 != null){
			fone = new Telefone();;
			fone.setCodArea(obtemDD(fone2));
			fone.setNumero(obtemNumero(fone2));
			fone.setPessoa(pessoa);

			telefoneDao.salva(fone);
			telefones.add(fone);
		}
		
		if (fone3 != null){
			fone = new Telefone();;
			fone.setCodArea(obtemDD(fone3));
			fone.setNumero(obtemNumero(fone3));
			fone.setPessoa(pessoa);

			telefoneDao.salva(fone);
			telefones.add(fone);
		}		
		
		pessoa.setTelefones(telefones);
		

		
		
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
		List<Telefone> telefones = telefoneDao.listaTodos();
		String[] fones = new String[3];

		pulaLinhas();		
		System.out.println("\t LISTA DE CLIENTES: ");
		System.out.println("Id\t Nome\t\t CPF \t\t"
				+ "     Idade\t Fones\t\t\t"
				+ "\t\t\t Aluguel\t\t Endereço\n");		
				

		for ( Cliente c: clientes ) {			

			for (int i=0; i < 3; i++ ) {
				if ( c.getPessoa().getTelefones() != null ) {
					fones[i] = "(" +telefones.get(i).getCodArea()+ ")" +telefones.get(i).getNumero();
				}			
			}
			
			System.out.println(c.getId()+ "\t " +c.getPessoa().getNome()+ "\t " +c.getPessoa().getCpf()+ "\t      " +c.getPessoa().getIdade()+ 
					"\t" +fones[0]+ "," +fones[1]+ "," +fones[2]+ "\t " +c.isLocacao()+"\t\t " 
					+c.getPessoa().getEndereco().getLogradouro()+ ", " +c.getPessoa().getEndereco().getNumeroResidencia()+ " - " 
					+c.getPessoa().getEndereco().getBairro()+ ", " +c.getPessoa().getEndereco().getCidade());
		}
		
	}	
	
}
