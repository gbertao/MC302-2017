package base.cartas.magias;

import java.util.UUID;
import base.cartas.Carta;

public abstract class Magia extends Carta{
	
	public Magia(UUID id, String nome, int custoMana, int dano) {
		super(id, nome, custoMana);
	}

	public Magia(String nome, int custoMana, int dano) {
		super(nome, custoMana);
	}
}
