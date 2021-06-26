package com.giovanni.base;

import java.util.ArrayList;
import java.util.Collections;

public class BaralhoArrayList {
	private ArrayList<CartaLacaio> vetorCartas;
	
	public BaralhoArrayList() {
		vetorCartas = new ArrayList<CartaLacaio>();
	}
	
	public void adicionarCarta(CartaLacaio lac) {
		if(vetorCartas.size() < 30) {
			vetorCartas.add(lac);
		}
	}
	
	public CartaLacaio comprarCarta() {
		int ultimaCarta;
		
		ultimaCarta = vetorCartas.size() - 1;
		
		return vetorCartas.remove(ultimaCarta);
	}
	
	public void embaralhar() {
		Collections.shuffle(vetorCartas);
		Collections.reverse(vetorCartas);
		
		for(CartaLacaio lac : vetorCartas) {
			System.out.println(lac);
		}
	}
}
