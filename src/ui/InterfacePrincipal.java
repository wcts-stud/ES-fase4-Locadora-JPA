package ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import ui.InterfaceCliente;

public class InterfacePrincipal {
	
	private InterfaceCliente ic = new InterfaceCliente();
	private InterfaceDvd id = new InterfaceDvd();
	private InterfaceLocacao il = new InterfaceLocacao();
	
	
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
		
		// remove
		//teste();

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
				
			default:
				break;
		}
		
	}
	
	
	/*
	 * Formata data para o formato "dd/MM/yyyy",
	 * retornando um Date;
	 */
	public Date formataData(String d){		

		Date date = null;		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = df.parse(d);
		} catch (ParseException e){
			e.printStackTrace();
		}		
		
		return date;
	}
	
	
	/*
	 * Retorna data de hoje em obj Date chamando 
	 * metodo de formatacao da data;
	 */
	public Date dataAtual() {		
		Date date = new Date();

		/*
		// Formata data;
		String d = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		return (date = df.parse(d));
		*/
		
		String dateS = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
		return formataData(dateS);
	}
	
	
	/*
	 * Acrescenta 6 dias ao dia de hoje e retorna
	 *  o objeto Date;
	 */
	public Date addDiasAData(int qtdDias) {
		Date hoje = dataAtual();
		Date data = null;
		
		Calendar c = Calendar.getInstance();
		c.setTime(hoje);		
		c.add(Calendar.DATE, +qtdDias);
		
		data = c.getTime();
		
		return data;
	}
	
	
	
	private void teste() {
		Date data = new Date();
		System.out.println(data);
	}
	
}
