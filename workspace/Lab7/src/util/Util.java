package util;

import java.util.Random;
import base.cartas.Carta;
import base.cartas.HabilidadesLacaio;
import base.cartas.TipoCarta;

public class Util {
	public static Carta geraCartaAleatoria(Random gerador, int maxMana, int maxAtaque, int maxVida, TipoCarta tc) {
		Carta carta = null;
		int mana = randInt(gerador, 1, maxMana);
		int atk = randInt(gerador, 1, maxAtaque);
		int vida = randInt(gerador, 1, maxVida);
		TipoCarta tipoCarta = null;
		
		if(tc == null) {
			switch(gerador.nextInt(TipoCarta.values().length)) {
			case 0:
				tipoCarta = TipoCarta.BUFF;
				break;
			case 1:
				tipoCarta = TipoCarta.DANO;
				break;
			case 2:
				tipoCarta = TipoCarta.DANO_AREA;
				break;
			case 3:
				tipoCarta = TipoCarta.LACAIO;
				break;
			}
		} else {
			tipoCarta = tc;
		}
		
		String nome;
		
		switch(tipoCarta) {
		case BUFF:
			break;
		case DANO:
			break;
		case DANO_AREA:
			break;
		case LACAIO:
			HabilidadesLacaio habilidade;
			switch(gerador.nextInt(HabilidadesLacaio.values().length)) {
			case 0:
				habilidade = HabilidadesLacaio.EXAUSTAO;
				break;
			case 1:
				habilidade = HabilidadesLacaio.INVESTIDA;
				break;
			case 2:
				habilidade = HabilidadesLacaio.PROVOCAR;
				break;
			}
			break;
		}
		
		return carta;
	}
	
	public static int randInt(Random gerador, int min, int max) {
		return gerador.nextInt((max - min) + 1) + min;
	}
}
