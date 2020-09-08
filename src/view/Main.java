package view;

import javax.swing.JOptionPane;

import controller.MetodosController;

public class Main {

	public static void main(String[] args) {
		
		MetodosController metodos = new MetodosController();
		String SO = metodos.xSO();
		int menu,PID;
		String NOME;
		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog("Menu: \n" 
																+ "1 - Processos \n" 
																+ "2 - Kill por PID \n" 
																+ "3 - Kill por NOME \n" 
																+ "4 - Finalizar"));
			
			switch(menu) {
				case 1:
					metodos.Processos(SO);
					break;
				case 2:
					 PID = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID: "));
					 metodos.KillPID(SO, PID);
					break;
				case 3:
					NOME = JOptionPane.showInputDialog("Digite o NOME");
					metodos.KillNAME(SO, NOME);
					break;
				case 4:
					JOptionPane.showMessageDialog(null,"Programa finalizado");
					break;
				default:
					JOptionPane.showMessageDialog(null,"Valor inserido é invalido");
			}
			
		}while(menu!=4);
	}
 
}
