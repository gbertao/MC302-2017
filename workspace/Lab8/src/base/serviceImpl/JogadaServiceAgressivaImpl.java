package base.serviceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import base.Jogada;
import base.Mesa;
import base.cartas.Carta;
import base.cartas.Lacaio;
import base.cartas.magias.Dano;
import base.service.JogadaService;

public class JogadaServiceAgressivaImpl implements JogadaService{
	public JogadaServiceAgressivaImpl() {
	
	}
	
	public List<Jogada> criarJogada(Mesa mesa, char jogador) {
		List<Jogada> lista = new ArrayList<Jogada>();
		
		if(jogador == 'P'){
			for(Carta card : mesa.getLacaiosP()) {
				if(card instanceof Lacaio) {
					lista.add(new Jogada(card, null, 'P'));
				}
			}
		} else {
			for(Carta card : mesa.getLacaiosS()) {
				if(card instanceof Lacaio) {
					lista.add(new Jogada(card, null, 'S'));
				}
			}
		}
		return lista;
	}
	
	class DanoComparator implements Comparator<Carta>{
		DanoComparator() {
			super();
		}
		
		@Override
		public int compare(Carta c1, Carta c2) {
			return ((Dano)c1).getDano() - ((Dano)c2).getDano(); 
		}
	}
	
	class LacaioComparator implements Comparator<Carta>{
		LacaioComparator() {
			
		}
	
		@Override
		public int compare(Carta c1, Carta c2) {
			return ((Lacaio)c1).getAtaque() - ((Lacaio)c2).getAtaque(); 
		}
	}
}
