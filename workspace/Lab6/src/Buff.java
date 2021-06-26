import java.util.UUID;

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
	
	public void usar(Lacaio alvo) {
		alvo.setVidaAtual(alvo.getVidaAtual()+getAumentoEmVida());
		alvo.setVidaMaxima(alvo.getVidaMaxima()+getAumentoEmVida());
		alvo.setAtaque(alvo.getAtaque()+getAumentoEmAtaque());
	}
}
