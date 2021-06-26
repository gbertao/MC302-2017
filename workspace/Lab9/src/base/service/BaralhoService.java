package base.service;

import java.util.List;
import java.util.Random;

import base.cartas.Carta;

public interface BaralhoService {
	public List<Carta> preencheAleatorio(Random gerador, int maxCards, int maxMana, int maxAtaque, int maxVida);
}
