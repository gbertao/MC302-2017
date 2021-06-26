package base;

import java.util.ArrayList;
import java.util.Random;

import base.cartas.Carta;
import util.Util;

public class Mesa {
	private ArrayList<Carta> maoP;
	private ArrayList<Carta> maoS;
	private ArrayList<Carta> lacaiosP;
	private ArrayList<Carta> lacaiosS;
	int poderHeroiP;
	int poderHeroiS;
	int manaP;
	int manaS;
	
	public Mesa() {
		maoP = new ArrayList<Carta>(7);
		maoS = new ArrayList<Carta>(7);
		lacaiosP = new ArrayList<Carta>(7);
		lacaiosS = new ArrayList<Carta>(7);
		poderHeroiP = Util.PODER_HEROI;
		poderHeroiS = Util.PODER_HEROI;
		manaP = 1;
		manaS = 1;
	}

	public Mesa(ArrayList<Carta> maoP, ArrayList<Carta> maoS, ArrayList<Carta> lacaiosP, ArrayList<Carta> lacaiosS,
			int poderHeroiP, int poderHeroiS, int manaP, int manaS) {
		this.maoP = maoP;
		this.maoS = maoS;
		this.lacaiosP = lacaiosP;
		this.lacaiosS = lacaiosS;
		this.poderHeroiP = poderHeroiP;
		this.poderHeroiS = poderHeroiS;
		this.manaP = manaP;
		this.manaS = manaS;
	}

	public ArrayList<Carta> getMaoP() {
		return maoP;
	}

	public void setMaoP(ArrayList<Carta> maoP) {
		this.maoP = maoP;
	}

	public ArrayList<Carta> getMaoS() {
		return maoS;
	}

	public void setMaoS(ArrayList<Carta> maoS) {
		this.maoS = maoS;
	}

	public ArrayList<Carta> getLacaiosP() {
		return lacaiosP;
	}

	public void setLacaiosP(ArrayList<Carta> lacaiosP) {
		this.lacaiosP = lacaiosP;
	}

	public ArrayList<Carta> getLacaiosS() {
		return lacaiosS;
	}

	public void setLacaiosS(ArrayList<Carta> lacaiosS) {
		this.lacaiosS = lacaiosS;
	}

	public int getPoderHeroiP() {
		return poderHeroiP;
	}

	public void setPoderHeroiP(int poderHeroiP) {
		this.poderHeroiP = poderHeroiP;
	}

	public int getPoderHeroiS() {
		return poderHeroiS;
	}

	public void setPoderHeroiS(int poderHeroiS) {
		this.poderHeroiS = poderHeroiS;
	}

	public int getManaP() {
		return manaP;
	}

	public void setManaP(int manaP) {
		this.manaP = manaP;
	}

	public int getManaS() {
		return manaS;
	}

	public void setManaS(int manaS) {
		this.manaS = manaS;
	}
	
	public void decPoderHeroi(int qtd, char jogador) {
		if(jogador == 'P') {
			this.setPoderHeroiP(this.getPoderHeroiP() - qtd);
		} else {
			this.setPoderHeroiS(this.getPoderHeroiS() - qtd);
		}
	}
	
	public void decMana(int qtd, char jogador) {
		if(jogador == 'P') {
			this.setManaP(this.getManaP() - qtd);
		} else {
			this.setManaS(this.getManaS() - qtd);
		}
	}
	
	public Carta sacarCarta(char jogador) {
		if(jogador == 'P') {
			return maoP.remove(new Random().nextInt(maoP.size()));
		} else {
			return maoS.remove(new Random().nextInt(maoS.size()));
		}
	}
}
