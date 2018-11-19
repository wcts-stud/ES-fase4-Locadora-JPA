package ui;

import ui.InterfaceCliente;

public class InterfacePrincipal extends InterfaceModelo {
	
	private InterfaceCliente ic = new InterfaceCliente();
	private InterfaceDvd id = new InterfaceDvd();
	private InterfaceLocacao il = new InterfaceLocacao();
	
	
	
	
	
	/*
	 * Menu principal para usuario;
	 */
	public void menuPrincipal() {

		int op = 0;
		
		do {
			pulaLinhas();
			System.out.println("\t MENU LOCADORA ");
			System.out.println("1 - Inserir locação, cliente ou DVD");
			System.out.println("2 - Remover locação, cliente ou DVD");
			System.out.println("3 - Listar locações, clientes ou DVDs");
			System.out.println("4 - Sair");
			System.out.print("Opção: ");
			
			op = ic.entrada.nextInt();
			ic.entrada.nextLine();
			pulaLinhas();
		} while ( op <= 0 && op < 4);
		
		if ( op == 1 ) {
			menuEscolhido("i");
		} else if ( op == 2 ) {
			menuEscolhido("r");
		} else if ( op == 3 ) {
			menuEscolhido("l");
		}

	}
	
	
	/*
	 * Altera menu conforme o solicitado no metodo @menuPrincipal;
	 */
	private void menuEscolhido(String operacao) {
		
		// remove
		//teste();

		int op = 0;
		int multiplicador = 1;
		
		if ( operacao == "i"){
			operacao = "Inserir";
		} else if ( operacao == "r") {
			operacao = "Remover";
			multiplicador = 5;
		} else if ( operacao == "l") {
			operacao = "Listar";
			multiplicador = 20;
		}
		
		
		do {
			System.out.println("\t SISTEMA ");
			System.out.println("1 - " +operacao+ " locação");
			System.out.println("2 - " +operacao+ " DVD");
			System.out.println("3 - " +operacao+ " cliente");
			System.out.println("4 - Sair");
			System.out.print("Opção: ");
			
			op = ic.entrada.nextInt();
			ic.entrada.nextLine();

		} while ( op <= 0 && op < 4);

		op *= multiplicador;
		
		switch (op) {
			case 1: 
				il.insereLocacao();
				break;
			case 2: 
				id.insereDvd();
				break;
			case 3: 
				ic.insereCliente();
				break;
			case 4: 
				System.exit(0);
				break;
				
			case 5: 
				il.removeLocacao();
				break;
			case 10: 
				id.removeDvd();
				break;
			case 15: 
				ic.removeCliente();
				break;

			case 20:
				il.listaTodosLocacao();
				break;
			case 40:
				id.listaTodosDvd();
				break;
			case 60:
				ic.listaTodosCliente();
				break;
				
			default:
				break;
		}		
	}	
	
}
