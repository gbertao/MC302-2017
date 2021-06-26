package base.service;

import java.util.List;

import base.Jogada;
import base.Mesa;

public interface JogadaService {
	public List<Jogada> criarJogada(Mesa mesa, char jogador);
}
