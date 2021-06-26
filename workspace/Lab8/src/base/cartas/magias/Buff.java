package base.cartas.magias;

import java.util.UUID;

import base.cartas.Carta;
import base.cartas.Lacaio;

public class Buff extends Magia{
	
	private int aumentoEmAtaque;
	private int aumentoEmVida;
	
	public Buff(UUID id, String nome, int custoMana, int dano, int aumentoEmAtaque, int aumentoEmVida) {
		super(id, nome, custoMana, dano);
		this.aumentoEmAtaque = aumentoEmAtaque;
		this.aumentoEmVida = aumentoEmVida;
	}
	
	public Buff(String nome, int custoMana, int dano, int aumentoEmAtaque, int aumentoEmVida) {
		super(nome, custoMana, dano);
		this.aumentoEmAtaque = aumentoEmAtaque;
		this.aumentoEmVida = aumentoEmVida;
	}
	
	public int getAumentoEmAtaque() {
		return this.aumentoEmAtaque;
	}
	
	public void setAumentoEmAtaque(int aumentoEmAtaque) {
		this.aumentoEmAtaque = aumentoEmAtaque;
	}
	
	public int getAumentoEmVida() {
		return this.aumentoEmVida;
	}
	
	public void setAumentoEmVida(int aumentoEmVida) {
		this.aumentoEmVida = aumentoEmVida;
	}
	
	@Override
	public String toString() {
		String desc = super.toString();
		desc+="Aumento em Ataque:"+ getAumentoEmAtaque()+"\n";
		desc+="Aumento em Vida: "+ getAumentoEmVida()+"\n";
		
		return desc;
	}
	
	@Override
	public void usar(Carta alvo) {
		((Lacaio) alvo).setVidaAtual(((Lacaio) alvo).getVidaAtual() + this.getAumentoEmVida());
		((Lacaio) alvo).setVidaMaxima(((Lacaio) alvo).getVidaMaxima() + this.getAumentoEmVida());
		((Lacaio) alvo).setAtaque(((Lacaio) alvo).getAtaque() + this.getAumentoEmAtaque());
	}
}
