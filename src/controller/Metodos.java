package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Metodos {
	
	public Stack<String> empilhaBrasileiros(String nomeArquivo) throws IOException{
		File arq = new File(nomeArquivo);
		Stack<String> pilha = new Stack<String>(); 
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine(); // pular a primeira linha
			String[] dadosDoJogador;
			while (linha != null) { // procurando EOF
				dadosDoJogador = linha.split(",");
				String nacionalidade = dadosDoJogador[5];
				if (nacionalidade.equals("Brazil")) {
					pilha.push(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			return pilha;
		} else {
			throw new IOException("Arquivo Inválido");
		}
		
	}

	public void desempilhaBonsBrasileiros(Stack<String> pilhaBrasileiros) throws IOException {
		int tamanhoPilha = pilhaBrasileiros.size();
		System.out.println(tamanhoPilha);
		String nome_jogador;
		// desempilha
		for (int i = 0; i < tamanhoPilha; i ++) {
			System.out.println(tamanhoPilha);
			String[] jogador = (pilhaBrasileiros.pop()).split(",");
			int overall = Integer.parseInt(jogador[7]);
			if (overall > 80){
				nome_jogador = jogador[2];
				System.out.println("Nome: "+nome_jogador+"\n"
						 + "Overall: "+overall+"\n"
				 		+ "______________________\n");
			}
			
		}
	}

	public List<String> listaRevelacoes(String nomeArquivo) throws IOException {
		// iniciar uma lista encadeada
		List<String> jovensRevelacoes = new LinkedList<String>();
		File arq = new File(nomeArquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine(); // pular a primeira linha
			String[] dadosDoJogador;
			while (linha != null) { // procurando EOF
				dadosDoJogador = linha.split(",");
				int idade = Integer.parseInt(dadosDoJogador[3]);
				if (idade <= 20) {
					jovensRevelacoes.add(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			return jovensRevelacoes;
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}

	public void buscaListaBonsJovens(List<String> jovensRevelacoes) {
		int tamanhoLista = jovensRevelacoes.size();
		String[] dadosDoJogador = null;
		int overall = 0;
		int idade = 0;
		String nome;
		//percorre a lista na do último para o primeiro elemento
		for (int i = tamanhoLista - 1; i >= 0; i--){
			dadosDoJogador = jovensRevelacoes.get(i).split(",");
			overall = Integer.parseInt(dadosDoJogador[7]);
			nome = dadosDoJogador[2];
			idade = Integer.parseInt(dadosDoJogador[3]);
			if (overall > 80) {
				System.out.println("Nome: "+nome+"\n"
								 + "Idade: "+idade+"\n"
						 		 + "Overall: "+overall+"\n"
						 		 +"__________________");
			}
		}
		
	}
}
