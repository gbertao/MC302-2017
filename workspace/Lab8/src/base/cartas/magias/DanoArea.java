package base.cartas.magias;

import java.util.List;
import java.util.UUID;

import base.cartas.Carta;
import base.cartas.Lacaio;

public class DanoArea extends Dano{
	
	public DanoArea(UUID id, String nome, int custoMana, int dano) {
		super(id, nome, custoMana, dano);
	}
	
	public DanoArea(String nome, int custoMana, int dano) {
		super(nome, custoMana, dano);
	}
	
	@Override
	public String toString() {
		String desc = super.toString();
		return desc;
	}

	public void usar(List<Carta> alvos) {
		for(Carta alvo : alvos) {
			((Lacaio)alvo).setVidaAtual(((Lacaio)alvo).getVidaAtual() - super.getDano());
		}
	}
}
