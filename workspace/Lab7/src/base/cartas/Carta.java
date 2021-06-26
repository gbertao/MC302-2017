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

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Carta)) {
			return false;
		}
		
		Carta c = (Carta) obj;
		if(custoMana != c.custoMana) {
			return false;
		}
		
		if(id == null) {
			if(c.id != null) {
				return false;
			}
		} else if (!id.equals(c.id)) {
			return false;
		}
		
		if(nome == null) { 
			if(c.nome != null) {
				return false;
			}
		} else if(!nome.equals(c.nome)) {
			return false;
		}
		return true;
	}	
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 67 * hash + custoMana;
		hash = 13 * hash + (id != null ? id.hashCode() : 0);
		hash = 13 * hash + (nome !=  null ? nome.hashCode() : 0);
		return hash;
	}
}