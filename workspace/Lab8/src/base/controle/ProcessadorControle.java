package base.controle;

import base.Jogada;
import base.Mesa;
import base.cartas.Lacaio;
import base.service.ProcessadorService;

public class ProcessadorControle {
	/**
	 * DUVIDA - Processador m�todo n�o possu� nenhum atributo. Ent�o, por que ele tem um construdor recebendo um objeto?
	 *
	 */
	ProcessadorControle(ProcessadorService algo) {
		
	}
	ProcessadorControle() {
		
	}
	
	/**
	 * DUVIDA - Segundo a UML: C:\Users\giova_000\Documents\UNICAMP\2017\1�Semestre\MC302\Lab8\Lab8.pdf
	 * ProcessadorControle e ProcessadorService est�o associados. Mas, ProcessadorService � uma interface.
	 * Ent�o, n�o deveria ser : ProcessadorControle -----> ProcessadorServiceImpl. Pois, quem tem toda a implementa��o do m�todo processar � ProcessadorServiceImpl ? 
	 * 
	 * confirmar ret bool
	 */
	public boolean processar(Jogada jogada, Mesa mesa) {
		//Processar Jogada de dano
		if(jogada.getAutor() == 'P') {
			mesa.setPoderHeroiS(mesa.getPoderHeroiS() - ((Lacaio)jogada.getJogada()).getAtaque());
		} else {
			mesa.setPoderHeroiP(mesa.getPoderHeroiP() - ((Lacaio)jogada.getJogada()).getAtaque());
		}
		
		//Verificar vida
		if(mesa.getPoderHeroiP() <= 0 || mesa.getPoderHeroiS() <= 0) {
			return true;
		} else {
			return false;
		}
	}
}
