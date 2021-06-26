package base;

import static util.Util.MAX_CARDS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import base.cartas.Carta;
import base.service.CartaService;
import base.serviceImpl.CartaServiceImpl;

public class Baralho {
	private ArrayList<Carta> vetorCartas;
	
	public Baralho() {
		vetorCartas = new ArrayList<Carta>();
	}
	
	public void adicionarCarta(Carta card) {
		if(vetorCartas.size() < MAX_CARDS) {
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (obj instanceof Baralho) {
			return false;
		}
		
		Baralho b = (Baralho) obj;
		if (vetorCartas == null) {
			if (b.vetorCartas != null)
				return false;
		} else if (!vetorCartas.equals(b.vetorCartas))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return 13 * 3 + (vetorCartas != null ? vetorCartas.hashCode() : 0);
	}
	
	public void preencheAleatorio(Random gerador, int maxCards, int maxMana, int maxAtaque, int maxVida) {
		CartaService cartaService = new CartaServiceImpl();
		for(int i = 0; i < maxCards; i++) {
			Carta card = cartaService.geraCartaAleatoria(gerador, gerador.nextInt(maxMana) + 1, gerador.nextInt(maxAtaque) + 1, gerador.nextInt(maxVida) + 1, null);
			vetorCartas.add(card);
		}
	}
}
