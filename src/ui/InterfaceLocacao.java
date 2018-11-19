package ui;

import java.util.Date;
import java.util.List;

import dao.ClienteDao;
import dao.DvdDao;
import dao.LocacaoDao;
import model.Cliente;
import model.Dvd;
import model.Locacao;

public class InterfaceLocacao extends InterfaceModelo  {

	private Dvd dvd = new Dvd();
	private Cliente cliente = new Cliente();
	
	private DvdDao dvdDao = new DvdDao();
	private LocacaoDao locacaoDao = new LocacaoDao();
	private ClienteDao clienteDao = new ClienteDao();
	

	

	
	protected void insereLocacao(){
		
		pulaLinhas();
		System.out.print("\t INSERINDO LOCAÇÃO \n\n"
				+ "Informe id do filme: ");
		int dvdId = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("Informe o id do cliente: ");
		int clienteId = entrada.nextInt();
		entrada.nextLine();
		
				
		Date alugado = dataAtual();
		Date devolucao = addDiasAData(6);
		
		/*
		 * issue #6
		 */
		cliente = clienteDao.pesquisa(clienteId);
		cliente.setLocacao(true);
		clienteDao.atualiza(cliente);
		
		dvd = dvdDao.pesquisa(dvdId);
		dvd.setEstoque(dvd.getEstoque() -1);
		dvd.setLocacao(true);
		dvdDao.atualiza(dvd);

		Locacao l = new Locacao(alugado, devolucao, dvd, cliente);
				
		locacaoDao.salva(l);
		
	}
	
	
	
	protected void removeLocacao() {
		
		pulaLinhas();
		System.out.print("\t REMOVENDO LOCAÇÃO \n\n"
				+ "Informe id da locação: ");
		int locacaoId = entrada.nextInt();
		entrada.nextLine();
		
		try {
			Locacao locacao = locacaoDao.pesquisa(locacaoId);
			cliente = clienteDao.pesquisa(locacao.getCliente().getId());
			cliente.setLocacao(false);
			clienteDao.atualiza(cliente);
			
			dvd = dvdDao.pesquisa(locacao.getDvd().getId());
			dvd.setEstoque(dvd.getEstoque() +1);
			dvd.setLocacao(false);
			dvdDao.atualiza(dvd);
			
			locacaoDao.remove(locacaoId);
			
			pulaLinhas();
			System.out.println("\n\t Inserido locação com sucesso!");
		} catch (Exception e) {
			System.err.println("Erro DELETE locacao: " +e);
		}
		
	}
	
	

	protected void listaTodosLocacao() {

		List<Locacao> locacao = locacaoDao.listaTodos();
		
		pulaLinhas();		
		System.out.println("\t LISTA DE LOCAÇÕES: ");
		System.out.println("Id\t Cliente\t Titulo filme\t\t Qtd. Dvds estoque");
		
		
		for ( Locacao l: locacao ) {

			System.out.println(l.getId()+ "\t " +l.getCliente().getNome()+ "\t " +l.getDvd().getTitulo()+ "\t\t\t " +l.getDvd().getEstoque());
		}
		
	}
	
}
