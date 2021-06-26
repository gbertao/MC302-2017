import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
	private ArrayList<Carta> vetorCartas;
	public final static int MAX_CARTAS = 30;
	
	public Baralho() {
		vetorCartas = new ArrayList<Carta>();
	}
	
	public void adicionarCarta(Carta card) {
		if(vetorCartas.size() < MAX_CARTAS) {
			vetorCartas.add(card);
		}
	}
	
	public Carta comprarCarta() {
		int ultimaCarta;
		
		ultimaCarta = vetorCartas.size() - 1;
		
		return vetorCartas.remove(ultimaCarta);
	}
	
	public void embaralhar() {
		Collections.shuffle(vetorCartas);
		Collections.reverse(vetorCartas);
		
		for(Carta card : vetorCartas) {
			System.out.println(card);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (obj instanceof Baralho) {
			return false;
		}
		
		Baralho b = (Baralho) obj;
		if (vetorCartas == null) {
			if (b.vetorCartas != null)
				return false;
		} else if (!vetorCartas.equals(b.vetorCartas))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return 13 * 3 + (vetorCartas != null ? vetorCartas.hashCode() : 0);
	}
}
