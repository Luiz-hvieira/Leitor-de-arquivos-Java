package br.com.alura.leitor.de.arquivos.classesAuxiliares;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Classe Leitor responsável por realizar todo o trabalho de leitura do arquivo.
 * @author Luiz Henrique
 *
 */

public class Leitor implements AutoCloseable{
	//atributos
	private BufferedReader br; 
	
	/**
	 * Construtor da classe, instancia o objeto que irá ler o arquivo
	 * 
	 * @param recebe o nome do arquivo a ser lido
	 */
	//Construtor
	public Leitor(String arquivo){
		//insere o arquivo no codigo
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(arquivo);
		} catch (FileNotFoundException e) {
			System.out.println("Não foi possível achar este arquivo!");
		}finally {
		InputStreamReader isr = new InputStreamReader(fis);
		this.br = new BufferedReader(isr);
		}
	}
	/**
	 * Método ler, encapsula a função principal do objeto de ler o arquivo.
	 * 
	 * @return o método retorna a linha que foi lida
	 */
	//Métodos
	public String ler() {
		try {
			return this.br.readLine();
		} catch (IOException e) {
			System.out.println("Não foi possível ler a linha!");
		}
		return " ";
	}
	/**
	 * Método getter do BufferedReader
	 * 
	 * @return retorna o buffered reader para verificação se o buffer está pronto
	 */
	public BufferedReader getBr() {
		return this.br;
	}
	/**
	 * Método close sobrescrito para implementação do contrato AutoCloseable
	 * 
	 */
	@Override
	public void close()  {
		try {
			this.br.close();
		} catch (IOException e) {
			System.out.println("Houve um erro ao fechar o leitor de arquivos! ");
		}
	}
	
}
