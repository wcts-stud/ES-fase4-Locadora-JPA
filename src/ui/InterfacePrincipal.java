package ui;

import java.util.Scanner;
import ui.InterfaceCliente;

public class InterfacePrincipal {
	
	private InterfaceCliente ic = new InterfaceCliente();
	
	
	private void pulaLinhas() {
		for (int i=0; i < 2; i++) {System.out.println("\n");}
	}
	
	
	
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
			System.out.println("3 - Sair");
			System.out.print("Opção: ");
			
			op = ic.entrada.nextInt();
			ic.entrada.nextLine();
			pulaLinhas();
		} while ( op <= 0 && op < 3);
		
		if ( op == 1 ) {
			menuEscolhido("i");
		} else if ( op == 2 ) {
			menuEscolhido("r");
		}

	}
	
	
	/*
	 * Altera menu conforme o solicitado no metodo @menuPrincipal;
	 */
	private void menuEscolhido(String operacao) {

		int op = 0;
		int multiplicador = 1;
		
		if ( operacao == "i"){
			operacao = "Inserir";
		} else if ( operacao == "r") {
			operacao = "Remover";
			multiplicador = 5;
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
				ic.insereLocacao();
				break;
			case 2: 
				ic.insereDvd();
				break;
			case 3: 
				ic.insereCliente();
				break;
			case 4: 
				System.exit(0);
				break;
				
			case 5: 
				ic.removeLocacao();
				break;
			case 10: 
				ic.removeDvd();
				break;
			case 15: 
				ic.removeCliente();
				break;
				
			default:
				break;
		}
		
	}
	
	
	
	
	
}
