package io;

import java.io.FileWriter;
import java.io.IOException;

public class Escritor {
	private FileWriter algo;
	
	public Escritor() {
		try {
			algo = new FileWriter("saida.txt");
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
		
	public void escreveAtributo(String nomeAtributo, String valor) {
		try {
			algo.write(nomeAtributo+ " " + valor+"\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void escreveDelimObj(String nomeObj) {
		try {
			algo.write("obj " + nomeObj+"\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}		
	}
	
	public void finalizar() {
		try {
			algo.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}		
	}
}
