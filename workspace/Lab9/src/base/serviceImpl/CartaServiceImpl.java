package base.serviceImpl;

import java.util.Random;
import java.util.UUID;

import base.cartas.Carta;
import base.cartas.HabilidadesLacaio;
import base.cartas.Lacaio;
import base.cartas.TipoCarta;
import base.cartas.magias.Buff;
import base.cartas.magias.Dano;
import base.cartas.magias.DanoArea;
import base.service.CartaService;
import util.RandomString;

public class CartaServiceImpl implements CartaService{
	/**
	 * Qual � a necessidade desses atributos se o construtor n�o recebe nenhum valor? 
	 */
	private RandomString stringGerador;
	private HabilidadesLacaio habilidade;
	private TipoCarta escolhido;
	
	public CartaServiceImpl() {
		stringGerador = null;
		habilidade = null;
		escolhido = null;
	}
	
	public Carta geraCartaAleatoria(Random gerador, int maxMana, int maxAtaque, int maxVida, TipoCarta tc) {
		Carta carta = null;
		int custoMana = randInt(gerador, 1, maxMana);
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
		
		stringGerador = new RandomString(gerador, gerador.nextInt(6) + 8);
		String nome = stringGerador.nextString();
		
		switch(tipoCarta) {
		case BUFF:
			nome = "Buff - " + nome;
			carta = new Buff(UUID.randomUUID(), nome, custoMana, 0, atk, vida);
			break;
		case DANO:
			nome = "Dano - " + nome;
			carta = new Dano(UUID.randomUUID(), nome, custoMana, atk);
			break;
		case DANO_AREA:
			nome = "Dano Area - " + nome;
			carta = new DanoArea(UUID.randomUUID(), nome, custoMana, atk);
			break;
		case LACAIO:
			habilidade = null;
			switch(gerador.nextInt(HabilidadesLacaio.values().length + 1)) {
			case 0:
				habilidade = null;
				break;
			case 1:
				habilidade = HabilidadesLacaio.EXAUSTAO;
				break;
			case 2:
				habilidade = HabilidadesLacaio.INVESTIDA;
				break;
			case 3:
				habilidade = HabilidadesLacaio.PROVOCAR;
				break;
			}
			
			nome = "Lacaio - " + nome;
			if(habilidade == null) {
				carta = new Lacaio(UUID.randomUUID(), nome, custoMana, atk, vida, vida);
			} else {
				carta = new Lacaio(UUID.randomUUID(), nome, custoMana, atk, vida, vida, habilidade);
			}
			break;
		}
		
		return carta;
	}
	
	public int randInt(Random gerador, int min, int max) {
		return gerador.nextInt((max - min) + 1) + min;
	}
}
