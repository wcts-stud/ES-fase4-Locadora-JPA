package ui;

import java.util.Date;
import java.util.List;

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
	

	

	
	protected void insereLocacao(){
		
		System.out.print("\t INSERINDO LOCAÇÃO \n\n"
				+ "Informe id do filme: ");
		int dvdId = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("Informe o id do cliente: ");
		int clienteId = entrada.nextInt();
		entrada.nextLine();
		
		
		InterfacePrincipal ip = new InterfacePrincipal();
		
		Date alugado = ip.dataAtual();
		Date devolucao = ip.addDiasAData(6);
		
		/*
		 * issue #6
		 */
		cliente.setId(clienteId);
		//cliente.setLocacao(true);
		dvd.setId(dvdId);
		//dvd.setEstoque(dvd.getEstoque() -1);
		//dvdDao.atualiza(dvd);
		Locacao l = new Locacao(alugado, devolucao, dvd, cliente);
		
		
		locacaoDao.salva(l);
		
	}
	
	
	
	protected void removeLocacao() {
		
		System.out.print("\t REMOVENDO LOCAÇÃO \n\n"
				+ "Informe id da locação: ");
		int locacaoId = entrada.nextInt();
		entrada.nextLine();
		
		locacaoDao.remove(locacaoId);
		
	}
	
	

	protected void listaTodosLocacao() {

		List<Locacao> locacao = locacaoDao.listaTodos();
		
		InterfacePrincipal.pulaLinhas();		
		System.out.println("\t LISTA DE LOCAÇÕES: ");
		System.out.println("Id\t Cliente\t Titulo filme\t\t Qtd. Dvds estoque");
		
		
		for ( Locacao l: locacao ) {

			System.out.println(l.getId()+ "\t " +l.getCliente().getNome()+ "\t " +l.getDvd().getTitulo()+ "\t\t\t " +l.getDvd().getEstoque());
		}
		
	}
	
}
