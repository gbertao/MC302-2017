package base.serviceImpl;

import java.util.Random;

import base.Baralho;
import base.Mesa;
import base.cartas.TipoCarta;
import base.service.CartaService;
import base.service.MesaService;
import util.Util;

public class MesaServiceImpl implements MesaService{
	
	public Mesa adicionaLacaios(Mesa mesa, Random gerador, TipoCarta tc) {
		
		CartaService cartaService = new CartaServiceImpl();
		
		for(int i = mesa.getLacaiosP().size(); i < Util.MAX_LACAIOS; i++) {
			mesa.getLacaiosP()
					.add(cartaService.geraCartaAleatoria(gerador, Util.MAX_MANA,
							Util.MAX_ATAQUE, Util.MAX_VIDA, tc));
		}
		
		for(int i = mesa.getLacaiosS().size(); i < Util.MAX_LACAIOS; i++) {
			mesa.getLacaiosS()
					.add(cartaService.geraCartaAleatoria(gerador, Util.MAX_MANA,
							Util.MAX_ATAQUE, Util.MAX_VIDA, tc));
		}
		
		return mesa;
	}
	public Mesa addMaoInicial(Mesa mesa, Baralho deck1, Baralho deck2, int maoInicial) {
		
		for(int i = 0; i < maoInicial; i++) {
			mesa.getMaoP().add(deck1.comprarCarta());
			mesa.getMaoS().add(deck2.comprarCarta());
		}
		mesa.getMaoS().add(deck2.comprarCarta());
		
		return mesa;
	}
}
