/*Lab 01 - MC302EF - Giovanni Bertao - ra173325
 * Classe: CartaMagica.
 * Atributos: ID, nome, dano, area, custoMana.
 * Metodos: getID, setID, getNome, setNome, getDano, setDano, getArea, setArea, getCustoMana, setCustoMana, toString.
 */

public class CartaMagica {

	private int ID;
	private String nome;
	private int dano;
	private boolean area;
	private int custoMana;

	//Metodo construtor
	public CartaMagica(int ID, String nome, int dano, boolean area, int custoMana) {
		this.ID = ID;
		this.nome = nome;
		this.dano = dano;
		this.area = area;
		this.custoMana = custoMana;
	}

	//Demais metodos aqui
	
	//Get e Set
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
	
	//Dano
	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	//Area
	public boolean getArea() {
		return area;
	}

	public void setArea(boolean area) {
		this.area = area;
	}

	//Custo Mana
	public int getCustoMana() {
		return custoMana;
	}

	public void setCustoMana(int custoMana) {
		this.custoMana = custoMana;
	}
	
	/* 3 - Quando executado o toString ele sobrepoem o toString da superclasse;
	 * 	   Inicia uma variavel out e insere a string resultante da concatenacao do nome e do ID
	 * 	   retornados pelos metodos getNome e getID;
	 * 	   Concatena tambem o dano, area e o custo de mana retornados respectivamente pelos metodos
	 * 	   getDano, getArea e getCustoMana;
	 * 	   Retorna o valor da variavel out ao final.
	 */
	
@Override
	public String toString() {
		String out = getNome() + " (ID: "+getID()+")\n";
		out = out + "Dano = "+getDano()+"\n";
		out = out + "Area = "+getArea()+"\n";
		out = out + "Custo de Mana = "+getCustoMana()+"\n";
		return out;
	}
}
