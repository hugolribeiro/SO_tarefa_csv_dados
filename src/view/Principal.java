package view;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import javax.swing.JOptionPane;

import controller.Metodos;

public class Principal {

	public static void main(String[] args) {
		
		int option = 0;
		String nome_arquivo = "data.csv";
		Metodos metodo = new Metodos();
		Stack<String> pilhaBrasileiros = null;
		List<String> jovensRevelacoes = null;
		
		while (option != 99) {
			option = Integer.parseInt(JOptionPane.showInputDialog(""
					+ "Digite 1 para empilhar os jogadores brasileiros\n"
					+ "Digite 2 para desempilhar e mostrar os bons jogadores brasileiros\n"
					+ "Digite 3 para armazenar em uma lista os jogadores mais jovens\n"
					+ "Digite 4 para mostrar as boas revelações\n"
					+ "Digite 99 para encerrar."));
			
			switch (option) {
				case 1:

				try {
					pilhaBrasileiros = metodo.empilhaBrasileiros(nome_arquivo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				
				case 2:
				try {
					metodo.desempilhaBonsBrasileiros(pilhaBrasileiros);
				} catch (IOException e) {
					e.printStackTrace();
				}
					break;
					
				case 3:
				try {
					jovensRevelacoes = metodo.listaRevelacoes(nome_arquivo);
				} catch (IOException e) {
					e.printStackTrace();
				}
					break;
					
				case 4:
					metodo.buscaListaBonsJovens(jovensRevelacoes);
					break;
				
				case 99:
					System.out.println("Terminando...");
					break;
				default:
					System.out.println("Opção inválida!");
			}
		}
	}

}
