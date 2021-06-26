package base.service;

import java.util.Random;

import base.Baralho;
import base.Mesa;
import base.cartas.TipoCarta;

public interface MesaService {
	public Mesa adicionaLacaios(Mesa mesa, Random gerador, TipoCarta tc);
	public Mesa addMaoInicial(Mesa mesa, Baralho deck1, Baralho deck2, int maoInicial);
}
