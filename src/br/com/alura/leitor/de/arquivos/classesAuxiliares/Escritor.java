package br.com.alura.leitor.de.arquivos.classesAuxiliares;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Classe que engloba todas as fun��es referente a escrita do novo arquivo.
 * @author Luiz Henrique
 *
 */
public class Escritor {
	//atributos
	private BufferedWriter bw;
	//construtor
	/**
	 * Instancia os objetos respons�veis por escrever o arquivo.
	 * 
	 * @param recebe por par�metro o nome do arquivo a ser escrito.
	 */
	public Escritor(String string){
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(string);
		} catch (FileNotFoundException e) {
			System.out.println("N�o foi poss�vel criar este arquivo!");;
		}finally{
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
		}	
	}
	//M�todos
	/**
	 * M�todo que encapsula a fun��o de escrever no arquivo linha por linha.
	 * 
	 * @param o que deve ser escrito no arquivo.
	 */
	public void escreve(String string) {
		try {
			this.bw.append(string);
			this.bw.flush();
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel escrever no arquivo!");
		}
	}
	/**
	 * M�todo respons�vel por fechar os objetos usados na escrita.
	 * 
	 */
	public void fecha() {
		try {
			this.bw.close();
		} catch (IOException e) {
			System.out.println("N�o foi possivel fechar o escritor!");
		}
	}
}
