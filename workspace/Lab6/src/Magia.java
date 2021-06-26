import java.util.UUID;

public class Magia extends Carta{
	
	public Magia(UUID id, String nome, int custoMana, int dano) {
		super(id, nome, custoMana);
	}

	public Magia(String nome, int custoMana, int dano) {
		super(nome, custoMana);
	}
}
