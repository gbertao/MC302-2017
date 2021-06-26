package com.giovanni.base;

import com.giovanni.util.Util;

public class Main {

	public static void main(String[] args) {
		CartaLacaio lac1 = new CartaLacaio(1, "EU", 2, 1, 1);
		CartaLacaio lac2 = new CartaLacaio(2, "Necromancer", 4, 3, 2);
		CartaLacaio lac3 = new CartaLacaio(3, "Diablo", 6, 6, 6);
		
		//Baralho
		System.out.println(">>>Baralho<<<");
		
		Baralho deck = new Baralho();
		
		deck.adicionarCarta(lac1);
		deck.adicionarCarta(lac2);
		deck.adicionarCarta(lac3);
		
		deck.embaralhar();
		
		//Baralho Array List
		System.out.println(">>>Baralho Array List<<<");
		
		BaralhoArrayList deckA = new BaralhoArrayList();
		
		deckA.adicionarCarta(lac1);
		deckA.adicionarCarta(lac2);
		deckA.adicionarCarta(lac3);
		
		deckA.embaralhar();
		
		CartaLacaio comprada = deckA.comprarCarta();
		System.out.println(">>>Carta Comprada<<<\n" + comprada);
		
		//Buffar duas Cartas
		System.out.println(">>>Buffar Cartas<<<\n");
		Util.buffar(comprada, 10);
		System.out.println(comprada);
		
		comprada = deckA.comprarCarta();//Comprar denovo
		Util.buffar(comprada, 10);
		System.out.println(comprada);
		
	}

}
