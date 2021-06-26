import java.io.IOException;
import java.util.UUID;

import base.cartas.Lacaio;
import io.Escritor;
import io.Leitor;

public class Main {
	public static void main (String args[]) throws IOException {
		Lacaio obj = new Lacaio(UUID.randomUUID(), "Eu", 1, 2, 3, 3);
		
		//Serializar
		obj.escreveAtributos(new Escritor());
		
		//Ler
		Leitor leitor = new Leitor();
		leitor.leObjetos();
		
		//Impressao
	}
}
