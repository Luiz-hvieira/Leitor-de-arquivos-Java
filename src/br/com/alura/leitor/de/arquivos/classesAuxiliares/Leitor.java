package br.com.alura.leitor.de.arquivos.classesAuxiliares;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Classe Leitor respons�vel por realizar todo o trabalho de leitura do arquivo.
 * @author Luiz Henrique
 *
 */

public class Leitor implements AutoCloseable{
	//atributos
	private BufferedReader br; 
	
	/**
	 * Construtor da classe, instancia o objeto que ir� ler o arquivo
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
			System.out.println("N�o foi poss�vel achar este arquivo!");
		}finally {
		InputStreamReader isr = new InputStreamReader(fis);
		this.br = new BufferedReader(isr);
		}
	}
	/**
	 * M�todo ler, encapsula a fun��o principal do objeto de ler o arquivo.
	 * 
	 * @return o m�todo retorna a linha que foi lida
	 */
	//M�todos
	public String ler() {
		try {
			return this.br.readLine();
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel ler a linha!");
		}
		return " ";
	}
	/**
	 * M�todo getter do BufferedReader
	 * 
	 * @return retorna o buffered reader para verifica��o se o buffer est� pronto
	 */
	public BufferedReader getBr() {
		return this.br;
	}
	/**
	 * M�todo close sobrescrito para implementa��o do contrato AutoCloseable
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
