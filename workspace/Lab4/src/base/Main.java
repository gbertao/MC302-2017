package base;

import java.util.UUID;

import base.cartas.Lacaio;
import base.cartas.magias.DanoArea;

public class Main {

	public static void main(String[] args) {
		Baralho deck = new Baralho();
				
		Lacaio lac1 = new Lacaio(UUID.randomUUID(), "EU", 1, 2, 2, 2);
		deck.adicionarCarta(lac1);

		Lacaio lac2 = new Lacaio(UUID.randomUUID(), "Diablo", 6, 6, 6, 6);
		deck.adicionarCarta(lac2);
		
		DanoArea da1 = new DanoArea(UUID.randomUUID(), "Xablau", 6, 9);
		deck.adicionarCarta(da1);
		
		
		deck.embaralhar();
	}

}
