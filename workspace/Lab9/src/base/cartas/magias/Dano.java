package base.cartas.magias;

import java.util.UUID;

import base.cartas.Carta;
import base.cartas.Lacaio;

public class Dano extends Magia{
	private int dano;
	
	public Dano(UUID id, String nome, int custoMana, int dano) {
		super(id, nome, custoMana, dano);
		this.dano = dano;
	}
	
	public Dano(String nome, int custoMana, int dano) {
		super(nome, custoMana, dano);
		this.dano = dano;
	}
	
	public int getDano() {
		return this.dano;
	}
	
	public void setDano(int dano) {
		this.dano = dano;
	}
	
	@Override
	public String toString() {
		String desc = super.toString();
		desc+="Dano: "+getDano()+"\n";
		
		return desc;
	}
	
	@Override
	public void usar(Carta alvo) {
		((Lacaio)alvo).setVidaAtual(((Lacaio)alvo).getVidaAtual() - getDano());
	}
}
