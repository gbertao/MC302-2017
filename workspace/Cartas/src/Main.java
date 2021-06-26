/*Lab 01 - MC302EF - Giovanni Bertao - ra173325
 * Classe: Main.
 * Funcao: Instanciar objetos(CartaMagica e CartaLacaio) e imprimir os valores dos atributos dos objetos instanciados.
 */

public class Main {
	public static void main (String[] args) {
		//Instanciando Objetos
		CartaLacaio lac1 = new CartaLacaio(1, "EU", 2, 1, 1);
		CartaLacaio lac2 = new CartaLacaio(2, "Diablo", 6, 6, 6);
		CartaMagica mag1 = new CartaMagica(3, "FireBolt", 3, false, 1);
		CartaLacaio lac3 = new CartaLacaio(4, "Baal", 5, 6, 5);
		CartaMagica mag2 = new CartaMagica(5, "You shall not pass", 4, true, 7);
		CartaMagica mag3 = new CartaMagica(6, "Irineu's question", 5, false, 7);
		CartaLacaio lac4 = new CartaLacaio(7, "Aidan", 7, 5, 6);
		CartaLacaio lac5 = new CartaLacaio(8, "Mephisto", 5, 7, 6);
		CartaLacaio lac6 = new CartaLacaio(9, "Bowazon", 8, 5, 5);
		CartaLacaio lac7 = new CartaLacaio(10, "Necro", 99, 99, 2);
		
		//Impressao dos objetos
		System.out.println("Primeiro Lacaio:\n"+lac1);
		System.out.println("Segundo Lacaio:\n"+lac2);
		System.out.println("Primeira magia:\n"+mag1);
		System.out.println("Terceiro Lacaio:\n"+lac3);
		System.out.println("Segunda magia:\n"+mag2);
		System.out.println("Terceira magia:\n"+mag3);
		System.out.println("Terceiro Lacaio:\n"+lac3);
		System.out.println("Quarto Lacaio:\n"+lac4);
		System.out.println("Quinto Lacaio:\n"+lac5);
		System.out.println("Sexto Lacaio:\n"+lac6);
		System.out.println("Setimo Lacaio:\n"+lac7);
	}
}