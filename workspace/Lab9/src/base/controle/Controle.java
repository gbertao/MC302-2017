package base.controle;

import static util.Util.MAX_ATAQUE;
import static util.Util.MAX_CARDS;
import static util.Util.MAX_MANA;
import static util.Util.MAX_VIDA;

import java.util.List;
import java.util.Random;

import base.Baralho;
import base.Jogada;
import base.Mesa;
import base.cartas.TipoCarta;
import base.service.BaralhoService;
import base.service.JogadaService;
import base.service.MesaService;
import base.service.ProcessadorService;
import base.serviceImpl.BaralhoServiceImpl;
import base.serviceImpl.JogadaServiceAgressivaImpl;
import base.serviceImpl.MesaServiceImpl;
import base.serviceImpl.ProcessadorServiceImpl;
import util.Util;

public class Controle {
	
	private Mesa mesa;
	private Baralho baralhoP;
	private Baralho baralhoS;
	private Random gerador;
	private JogadaService jogadaService;
	private BaralhoService baralhoService;
	private MesaService mesaService;
	private ProcessadorService processadorService;
	
	public Controle() {
		this.baralhoP = new Baralho();
		this.baralhoS = new Baralho();
		this.mesa = new Mesa();
		gerador = new Random();
		jogadaService = new JogadaServiceAgressivaImpl();
		this.baralhoService = new BaralhoServiceImpl();
		this.mesaService = new MesaServiceImpl();
		this.processadorService = new ProcessadorServiceImpl();
	}
	
	public void executa() {
	
		baralhoP.addCartas(baralhoService.preencheAleatorio(gerador, MAX_CARDS, MAX_MANA, MAX_ATAQUE, MAX_VIDA));
		baralhoS.addCartas(baralhoService.preencheAleatorio(gerador, MAX_CARDS, MAX_MANA, MAX_ATAQUE, MAX_VIDA));
		
		mesa = mesaService.adicionaLacaios(mesa, gerador, TipoCarta.LACAIO);
		mesa = mesaService.addMaoInicial(mesa, baralhoP, baralhoS, Util.MAO_INI);
				
		List<Jogada> jogadas = jogadaService.criarJogada(mesa, 'P');
		for(Jogada jogada : jogadas) {
			if(processadorService.processar(jogada, mesa)) {
				System.out.println("###### " + jogada.getAutor() +" venceu!");
				break;
			}
		}
	}
}
