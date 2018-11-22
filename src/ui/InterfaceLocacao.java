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
				+ "Informe id do dvd: ");
		int dvdId = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("Informe o id do cliente: ");
		int clienteId = entrada.nextInt();
		entrada.nextLine();
		
				
		Date alugado = dataAtual();
		Date devolucao = addDiasAData(6);
		
		
		cliente = clienteDao.pesquisa(clienteId);
		cliente.setLocacao(true);
		clienteDao.atualiza(cliente);
		
		dvd = dvdDao.pesquisa(dvdId);
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
			dvd.setLocacao(false);
			dvdDao.atualiza(dvd);
			
			locacaoDao.remove(locacaoId);
			
			pulaLinhas();
			System.out.println("\n\t Locação removida com sucesso!");
		} catch (Exception e) {
			System.err.println("Erro DELETE locacao: " +e);
		}
		
	}
	
	
	
	protected void listaTodosLocacao() {

		List<Locacao> locacao = locacaoDao.listaTodos();
		
		pulaLinhas();		
		System.out.println("\t LISTA DE LOCAÇÕES: ");
		System.out.println("Id\t Cliente\t Titulo filme\t\t Cod. Dvd");
		
		
		for ( Locacao l: locacao ) {

			System.out.println(l.getId()+ "\t " +l.getCliente().getPessoa().getNome()+ "\t " +l.getDvd().getFilme().getTitulo()+ "\t\t\t " +l.getDvd().getCod());
		}
		
	}	
	
}
