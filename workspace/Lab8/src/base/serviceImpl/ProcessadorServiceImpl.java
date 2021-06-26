package base.serviceImpl;

import java.util.ArrayList;
import java.util.stream.Collectors;

import base.Jogada;
import base.Mesa;
import base.cartas.Carta;
import base.cartas.HabilidadesLacaio;
import base.cartas.Lacaio;
import base.cartas.magias.Buff;
import base.cartas.magias.Dano;
import base.cartas.magias.DanoArea;
import base.service.ProcessadorService;

public class ProcessadorServiceImpl implements ProcessadorService{
	public ProcessadorServiceImpl() {
		
	}
	
	public boolean processar(Jogada jogada, Mesa mesa) {
		Carta card = jogada.getJogada();
		char autor = jogada.getAutor();
		
		//Log Inicial
		System.out.println("Log Inicial:");
		System.out.printf(jogada.toString()+"\n");
		if(autor == 'P') {
			System.out.println("Poder Heroi S: " + mesa.getPoderHeroiS());
			System.out.println("Quantidade de Lacaios: " + mesa.getLacaiosS().size());
			System.out.println("Lacaios Oponente:\n" + mesa.getLacaiosS());
		} else {
			System.out.println("Poder Heroi P: " +mesa.getPoderHeroiP());
			System.out.println("Quantidade de Lacaios: " + mesa.getLacaiosP().size());
			System.out.println("Lacaios Oponente:\n" + mesa.getLacaiosP());
		}
		
		//Decrementar Mana
		if(autor == 'P') {
			mesa.setManaP(mesa.getManaP() - card.getCustoMana() < 0 ? 0 : mesa.getManaP() - card.getCustoMana());
		} else {
			mesa.setManaS(mesa.getManaS() - card.getCustoMana() < 0 ? 0 : mesa.getManaS() - card.getCustoMana());
		}
		
		//Verificar qual o tipo de carta jogada
		if(card instanceof DanoArea) {
			int dano = ((DanoArea)card).getDano();
			if(autor == 'P') {
				((DanoArea)card).usar(mesa.getLacaiosS());
				mesa.decPoderHeroi(dano, 'S');
			} else {
				((DanoArea)card).usar(mesa.getLacaiosP());
				mesa.decPoderHeroi(dano, 'P');
			}
		} else if(card instanceof Dano) {
			if(autor == 'P') {
				Carta lacProvocar = mesa.getLacaiosS().stream()
						.filter(p -> ((Lacaio)p).getHabilidade() == HabilidadesLacaio.PROVOCAR)
						.findFirst()
						.orElse(null);
				if(lacProvocar != null) {
					((Dano)card).usar((Lacaio)lacProvocar);
					jogada.setAlvo(lacProvocar);
				} else if(jogada.getAlvo() != null){
					((Dano)card).usar((Lacaio)jogada.getAlvo());
				} else {
					mesa.decPoderHeroi(((Dano) card).getDano(), 'S');
				}
			} else {
				Carta lacProvocar = mesa.getLacaiosP().stream()
						.filter(p -> ((Lacaio)p).getHabilidade() == HabilidadesLacaio.PROVOCAR)
						.findFirst()
						.orElse(null);
				if(lacProvocar != null) {
					((Dano)card).usar((Lacaio)lacProvocar);
				} else if(jogada.getAlvo() != null){
					((Dano)card).usar((Lacaio)jogada.getAlvo());
				} else {
					mesa.decPoderHeroi(((Dano) card).getDano(), 'P');
				}
			}
		} else if(card instanceof Buff) {
			if(jogada.getAlvo() instanceof Lacaio) {
				/**
				 * Duvida - Devo implementar o sufixo Buff aqui?
				 */
				((Buff)card).usar((Lacaio)jogada.getAlvo());
			}
		} else if(card instanceof Lacaio) {
			if( ((Lacaio)card).getHabilidade() == HabilidadesLacaio.EXAUSTAO) {
				((Lacaio) card).setHabilidade(HabilidadesLacaio.INVESTIDA);
				if(autor == 'P') {
					ArrayList<Carta> lacaios = mesa.getLacaiosP();
					lacaios.add(card);
					mesa.setLacaiosP(lacaios);
				} else {
					ArrayList<Carta> lacaios = mesa.getLacaiosS();
					lacaios.add(card);
					mesa.setLacaiosS(lacaios);
				}
			} else if(jogada.getAlvo() != null){
				((Lacaio)card).usar((Lacaio)jogada.getAlvo());
			} else {
				if(autor == 'P') {
					mesa.decPoderHeroi(((Lacaio) card).getAtaque(), 'S');
				} else {
					mesa.decPoderHeroi(((Lacaio) card).getAtaque(), 'P');
				}
			}
		}
		
		//Atualizar Lacaios
		 ArrayList<Carta> lacaiosUpdateP = (ArrayList<Carta>) mesa.getLacaiosP().stream()
				.filter(p -> ((Lacaio)p).getVidaAtual() > 0)
				.collect(Collectors.toList());
		mesa.setLacaiosP(lacaiosUpdateP);
		
		ArrayList<Carta> lacaiosUpdateS = (ArrayList<Carta>) mesa.getLacaiosS().stream()
				.filter(p -> ((Lacaio)p).getVidaAtual() > 0)
				.collect(Collectors.toList());
		mesa.setLacaiosS(lacaiosUpdateS);
		
		//Log final
		System.out.println("\nAtualização de Log\n");
		if(autor == 'P') {
			System.out.println("Poder Heroi S: " + mesa.getPoderHeroiS());
			System.out.println("Quantidade de Lacaios Atualizado: " + mesa.getLacaiosS().size());
			System.out.println("Lacaios Oponente Atualizado:\n" + mesa.getLacaiosS());
		} else {
			System.out.println("Poder Heroi P: " + mesa.getPoderHeroiP());
			System.out.println("Quantidade de Lacaios Atualizado: " + mesa.getLacaiosP().size());
			System.out.println("Lacaios Oponente Atualizado:\n" + mesa.getLacaiosP());
		}
		System.out.println("-------------------------------------------------------");
		
		return true;
	}
}