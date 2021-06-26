public class Main {

	public static void main(String[] args) {
		CartaLacaio lac1 = new CartaLacaio(1, "Frodo Bolseiro", 2, 1, 1);
		CartaLacaio lac2 = new CartaLacaio(2, "Aragorn", 5, 7, 7);
		CartaLacaio lac3 = new CartaLacaio(3, "Legolas", 8, 4, 6);
		CartaMagica mag1 = new CartaMagica(4, "You shall not pass", 4, true, 7);
		CartaMagica mag2 = new CartaMagica(5, "Telecinese", 3, false, 2);		

		//Tarefas
		//1 - Instanciar lac4 atraves do construtor reduzido
		CartaLacaio lac4 = new CartaLacaio(6, "EU", 6);
		System.out.println(lac4);
		
		//2 - Alterar o atque de lac1 pelo do lac3
		lac1.setAtaque(lac3.getAtaque());
		System.out.println(lac1);
		
		//3 - Respondido em CartaMagica.java
		
		//4 - Instanciar lac5 atraves do construtor copia de lac2
		CartaLacaio lac5 = new CartaLacaio(lac2);
		System.out.println(lac2);
		System.out.println(lac5);
		/*lac5 e diferente de lac2. Lac5 e um novo objeto instanciado a partir dos valores de lac2
		 * isso nao significa que eles sao identicos.
		 */
		
		//5 - Alterar o a visibilidade do atributo nome da classe CartaMagica
		//System.out.println(mag1.nome);
		System.out.println(mag1.getNome());
		/* Como a visibilidade esta private outras classes nao conseguem acessar o atributo nome da classe
		 * CartaMagica. Pois, esta encapsulada.
		 */
		
		//6 - Buff
		//Primeiro Buffar
		System.out.println("Antes de Buffar:\n"+lac1);
		lac1.buffar(10);
		System.out.println("Depois de Buffar:\n"+lac1);
		
		System.out.println("Antes de Buffar:\n"+lac2);
		lac2.buffar(0);
		System.out.println("Depois de Buffar:\n"+lac2);
		
		System.out.println("Antes de Buffar:\n"+lac3);
		lac3.buffar(-1);
		System.out.println("Depois de Buffar:\n"+lac3);
		
		//Segundo Buffar
		System.out.println("Antes de Buffar:\n"+lac1);
		lac1.buffar(10, 2);
		System.out.println("Depois de Buffar:\n"+lac1);
		
		System.out.println("Antes de Buffar:\n"+lac2);
		lac2.buffar(0, 5);
		System.out.println("Depois de Buffar:\n"+lac2);
		
		System.out.println("Antes de Buffar:\n"+lac2);
		lac2.buffar(10, 0);
		System.out.println("Depois de Buffar:\n"+lac2);
		
		System.out.println("Antes de Buffar:\n"+lac3);
		lac3.buffar(0, 0);
		System.out.println("Depois de Buffar:\n"+lac3);
		
		System.out.println("Antes de Buffar:\n"+lac3);
		lac3.buffar(-6, -2);
		System.out.println("Depois de Buffar:\n"+lac3);
		
		System.out.println("Antes de Buffar:\n"+lac1);
		lac1.buffar(30, -10);
		System.out.println("Depois de Buffar:\n"+lac1);
		
		System.out.println("Antes de Buffar:\n"+lac1);
		lac1.buffar(-50, 200);
		System.out.println("Depois de Buffar:\n"+lac1);
		
		System.out.println("Antes de Buffar:\n"+lac4);
		lac4.buffar(-5, 0);
		System.out.println("Depois de Buffar:\n"+lac4);
		
		System.out.println("Antes de Buffar:\n"+lac5);
		lac5.buffar(2000, 2000);
		System.out.println("Depois de Buffar:\n"+lac5);
		
	}

}
