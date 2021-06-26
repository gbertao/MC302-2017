package base;

import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
	private ArrayList<Carta> vetorCartas;
	
	public Baralho() {
		vetorCartas = new ArrayList<Carta>();
	}
	
	public void adicionarCarta(Carta card) {
		if(vetorCartas.size() < 30) {
			vetorCartas.add(card);
		}
	}
	
	public Carta comprarCarta() {
		int ultimaCarta;
		
		ultimaCarta = vetorCartas.size() - 1;
		
		return vetorCartas.remove(ultimaCarta);
	}
	
	public void embaralhar() {
		Collections.shuffle(vetorCartas);
		Collections.reverse(vetorCartas);
		
		for(Carta card : vetorCartas) {
			System.out.println(card);
		}
	}
}
