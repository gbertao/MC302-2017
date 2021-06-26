package base.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import base.cartas.Carta;
import base.service.BaralhoService;
import base.service.CartaService;

public class BaralhoServiceImpl implements BaralhoService{
	
	public List<Carta> preencheAleatorio(Random gerador, int maxCards, int maxMana, int maxAtaque, int maxVida) {
		List<Carta> vetorCartas = new ArrayList<Carta>();
		CartaService cartaService = new CartaServiceImpl();
		for(int i = 0; i < maxCards; i++) {
			Carta card = cartaService.geraCartaAleatoria(gerador, gerador.nextInt(maxMana) + 1, gerador.nextInt(maxAtaque) + 1, gerador.nextInt(maxVida) + 1, null);
			vetorCartas.add(card);
		}
		return vetorCartas;
	}

}
