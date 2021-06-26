package base;

import java.util.UUID;

public class Carta {
	private UUID id;
	private String nome;
	private int custoMana;
	
	public Carta(UUID id, String nome, int custoMana) {
		this.id = id;
		this.nome = nome;
		this.custoMana = custoMana;
	}
	
	public Carta(String nome, int custoMana) {
		this.nome = nome;
		this.custoMana = custoMana;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getCustoMana() {
		return custoMana;
	}
	
	public void setCustoMana() {
	
	}
	
	public void setNome() {
		
	}
	
@Override
	public String toString() {
		String desc = getNome() + " (ID: "+getId()+")\n";
		desc = desc + "Custo Mana: "+getCustoMana()+"\n";
		return desc;
	}
	
	public void usar(Carta alvo) {
		
	}
}
