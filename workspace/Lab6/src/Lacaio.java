import java.util.UUID;

public class Lacaio extends Carta{
	
	private int ataque;
	private int vidaAtual;
	private int vidaMaxima;
	
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

@Override
	public String toString() {
		String out = super.toString();
		out = out + "Ataque: "+getAtaque()+"\n";
		out = out + "Vida Atual: "+getVidaAtual()+"\n";
		out = out + "Vida Maxima: "+getVidaMaxima()+"\n";
		return out;
	}

	public void usar(Lacaio alvo) {
		alvo.setVidaAtual(alvo.getVidaAtual() - getAtaque());
	}
}
