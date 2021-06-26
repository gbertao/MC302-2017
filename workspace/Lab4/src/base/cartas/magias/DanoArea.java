package base.cartas.magias;

import java.util.List;
import java.util.UUID;

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

	public void usar(List<Lacaio> alvos) {
		for(Lacaio alvo : alvos) {
			alvo.setVidaAtual(alvo.getVidaAtual() - super.getDano());
		}
	}
}
