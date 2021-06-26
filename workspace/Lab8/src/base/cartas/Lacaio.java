package base.cartas;
import java.util.UUID;

public class Lacaio extends Carta{
	
	private int ataque;
	private int vidaAtual;
	private int vidaMaxima;
	private HabilidadesLacaio habilidade;
	
	// Metodo construtor aqui
	public Lacaio(UUID id, String nome, int custoMana, int ataque, int vidaAtual, int vidaMaxima) {
		super(id, nome, custoMana);
		this.ataque = ataque;
		this.vidaAtual = vidaAtual;
		this.vidaMaxima = vidaMaxima;
	}
	
	public Lacaio(String nome, int custoMana, int ataque, int vidaAtual, int vidaMaxima) {
		super(nome, custoMana);
		this.ataque = ataque;
		this.vidaAtual = vidaAtual;
		this.vidaMaxima = vidaMaxima;
		
	}
	
	public Lacaio(UUID id, String nome, int custoMana, int ataque, int vidaAtual, int vidaMaxima, HabilidadesLacaio habilidade) {
		super(id, nome, custoMana);
		this.ataque = ataque;
		this.vidaAtual = vidaAtual;
		this.vidaMaxima = vidaMaxima;
		this.habilidade = habilidade;
	}
	
	public Lacaio(String nome, int custoMana, int ataque, int vidaAtual, int vidaMaxima, HabilidadesLacaio habilidade) {
		super(nome, custoMana);
		this.ataque = ataque;
		this.vidaAtual = vidaAtual;
		this.vidaMaxima = vidaMaxima;
		this.habilidade = habilidade;
		
	}
	// Demais metodos aqui
	
	//Gets e Sets
	//Ataque
	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	//Vida Atual
	public int getVidaAtual() {
		return vidaAtual;
	}

	public void setVidaAtual(int vidaAtual) {
		this.vidaAtual = vidaAtual;
	}
	
	//Vida Maxima
	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}
	
	//Habilidade
	public HabilidadesLacaio getHabilidade() {
		return this.habilidade;
	}
	
	public void setHabilidade(HabilidadesLacaio habilidade) {
		this.habilidade = habilidade;
	}

	@Override
	public String toString() {
		String out = super.toString();
		out = out + "Ataque: "+getAtaque()+"\n";
		out = out + "Vida Atual: "+getVidaAtual()+"\n";
		out = out + "Vida Maxima: "+getVidaMaxima()+"\n";
		return out;
	}

	@Override
	public void usar(Carta alvo) {
		this.setVidaAtual(this.getVidaAtual() - ((Lacaio) alvo).getAtaque());
		((Lacaio) alvo).setVidaAtual(((Lacaio) alvo).getVidaAtual() - this.getAtaque());
	}
}
