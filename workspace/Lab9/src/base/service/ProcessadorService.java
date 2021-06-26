package base.service;

import base.Jogada;
import base.Mesa;

public interface ProcessadorService {
	public boolean processar(Jogada jogada, Mesa mesa);
}
