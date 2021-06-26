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

	public String toString() {
		String out = getNome() + " (ID: "+getID()+")\n";
		out = out + "Dano = "+getDano()+"\n";
		out = out + "Area = "+getArea()+"\n";
		out = out + "Custo de Mana = "+getCustoMana()+"\n";
		return out;
	}
}
