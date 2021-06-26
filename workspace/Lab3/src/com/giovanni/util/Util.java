package com.giovanni.util;

import com.giovanni.base.CartaLacaio;

public class Util {
	public static final int MAX_CARDS = 30;
	
	public static void buffar(CartaLacaio lac, int a) {
		int oldAtaque, oldVidaAtual, oldVidaMaxima;
		
		oldAtaque = lac.getAtaque();
		oldVidaAtual = lac.getVidaAtual();
		oldVidaMaxima = lac.getVidaMaxima();
		
		lac.setAtaque(lac.getAtaque() + a);
		lac.setVidaAtual(lac.getVidaAtual() + a);
		lac.setVidaMaxima(lac.getVidaMaxima() + a);
		
		if(oldAtaque < lac.getAtaque() ||
		   oldVidaAtual < lac.getVidaAtual() ||
		   oldVidaMaxima < lac.getVidaMaxima()) {
			alterarNomeFortalecido(lac);
		}
	}
	public static void buffar(CartaLacaio lac, int a, int v) {
		int oldAtaque, oldVidaAtual, oldVidaMaxima;
		
		oldAtaque = lac.getAtaque();
		oldVidaAtual = lac.getVidaAtual();
		oldVidaMaxima = lac.getVidaMaxima();
		
		lac.setAtaque(lac.getAtaque() + a);
		lac.setVidaAtual(lac.getVidaAtual() + v);
		lac.setVidaMaxima(lac.getVidaMaxima() + v);
		
		if(oldAtaque < lac.getAtaque() ||
		   oldVidaAtual < lac.getVidaAtual() ||
		   oldVidaMaxima < lac.getVidaMaxima()) {
			alterarNomeFortalecido(lac);
		}
	}
	public static void alterarNomeFortalecido(CartaLacaio lac) {
		lac.setNome(lac.getNome() + " Buffed");
	}
}
