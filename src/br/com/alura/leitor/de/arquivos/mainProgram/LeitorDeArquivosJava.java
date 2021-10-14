/**
 * Esse programa é um treino de implementações em java, visando aplicar o aprendido em aula
 * sua função é ler um arquivo de texto e copiar para outro arquivo se o usuário quiser.
 * @author Luiz Henrique Vieira Steff
 */
package br.com.alura.leitor.de.arquivos.mainProgram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.alura.leitor.de.arquivos.classesAuxiliares.Escritor;
import br.com.alura.leitor.de.arquivos.classesAuxiliares.Leitor;

/**
 * Classe principal com a função de instanciar as outras classes e falar com o usuário.
 *
 */

public class LeitorDeArquivosJava {
	public static void main(String []args) throws IOException{
		String entrada, escolha, saida;
		//Pergunta qual o arquivo a ser lido
		System.out.println("Insira abaixo o arquivo que gostaria de ler");
		Scanner sc = new Scanner(System.in);
		entrada = sc.next();
		
		//Instancia a classe leitor com o nome do arquivo
		try(Leitor leitor = new Leitor(entrada);){

			//Passa o arquivo para dentro do ArrayList "arquivo"
			ArrayList<String> arquivo = new ArrayList<>();
			while(leitor.getBr().ready()) {
				arquivo.add(leitor.ler()+"\n");
			}
			//imprime todo o arraylist e pergunta se gostaria de copiá-lo
			System.out.println(arquivo);
			System.out.println("Esse é o arquivo que você quis ler, "
					+ "gostaria de copiá-lo para outro arquivo?");
			escolha = sc.next();
			
			if (! ( escolha.contentEquals("nao") || escolha.contentEquals("NAO") )) {
				System.out.println("Agora insira abaixo qual o nome do arquivo que quer criar?");
				saida = sc.next();
				
				Escritor escritor = new Escritor(saida);
				for (String string : arquivo) {
					escritor.escreve(string);
				}
			}

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Não foi possível encontrar o arquivo!");
		}
		sc.close();
	}
}

