/*Lab 01 - MC302EF - Giovanni Bertao - ra173325
 * Classe: CartaLacaio.
 * Atributos: ID, nome, ataque, vidaAtual, vidaMaxima, custoMana.
 * Metodos: getID, setID, getNome, setNome, setAtaque, getAtaque, getVidaAtual, setVidaAtual, 
 * 			getVidaMaxima, setVidaMaxima, getcustoMana, setCustoMana, toString.
 */

public class CartaLacaio {
	
	private int ID;
	private String nome;
	private int ataque;
	private int vidaAtual;
	private int vidaMaxima;
	private int custoMana;
	
	// Metodo construtor aqui
	public CartaLacaio(int ID, String nome, int ataque, int vida, int mana) {
		this.ID = ID;
		this.nome = nome;
		this.ataque = ataque;
		this.vidaAtual = vida;
		this.vidaMaxima = vida;
		this.custoMana = mana;
	}
	
	//Outros construtores
	//Construtor Reduzido
	public CartaLacaio(int ID, String nome, int mana) {
		this.ID = ID;
		this.nome = nome;
		this.custoMana = mana;
	}
	
	//Construtor Copia
	public CartaLacaio(CartaLacaio origem) {
		this.ID = origem.ID;
		this.nome = origem.nome;
		this.ataque = origem.ataque;
		this.vidaAtual = origem.vidaAtual;
		this.vidaMaxima = origem.vidaMaxima;
		this.custoMana = origem.custoMana;
	}
	
	// Demais metodos aqui
	//Gets e Sets
	//ID
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	//Nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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

	//Custo Mana
	public int getCustoMana() {
		return custoMana;
	}

	public void setCustoMana(int custoMana) {
		this.custoMana = custoMana;
	}
	
@Override
	public String toString() {
		String out = getNome() + " (ID: "+getID()+")\n";
		out = out + "Ataque = "+getAtaque()+"\n";
		out = out + "Vida Atual = "+getVidaAtual()+"\n";
		out = out + "Vida Maxima = "+getVidaMaxima()+"\n";
		out = out + "Custo de Mana = "+getCustoMana()+"\n";
		return out;
	}

	private void alteraNomeFortalecido() {
		this.nome = getNome() + " Buffed";
	}

	public void buffar(int a) {
		int oldAtaque, oldVidaAtual, oldVidaMaxima;
		
		oldAtaque = getAtaque();
		oldVidaAtual = getVidaAtual();
		oldVidaMaxima = getVidaMaxima();
		
		this.ataque = getAtaque() + a;
		this.vidaAtual = getVidaAtual() + a;
		this.vidaMaxima = getVidaMaxima() + a;
		
		if(getAtaque() > oldAtaque || getVidaAtual() > oldVidaAtual || getVidaMaxima() > oldVidaMaxima) {
			alteraNomeFortalecido();
		}
	}
	
	public void buffar(int a, int v) {
		int oldAtaque, oldVidaAtual, oldVidaMaxima;
		
		oldAtaque = getAtaque();
		oldVidaAtual = getVidaAtual();
		oldVidaMaxima = getVidaMaxima();
		
		this.ataque = getAtaque() + a;
		this.vidaAtual = getVidaAtual() + v;
		this.vidaMaxima = getVidaMaxima() + v;
		
		if(getAtaque() > oldAtaque || getVidaAtual() > oldVidaAtual || getVidaMaxima() > oldVidaMaxima) {
			alteraNomeFortalecido();
		}
	}
}
