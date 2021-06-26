import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;
import java.util.UUID;
import java.util.Vector;
import java.util.stream.Collectors;

import base.cartas.Carta;
import base.cartas.Lacaio;
//TO-DO: Implementar RandomStrings
public class Main {

	public static void main(String[] args) {
		ArrayList<Carta> cartas = new ArrayList<Carta>(10000);
		Random gerador = new Random();
		
		for(int i = 0; i < 10000; i++) {
			String nome;
			switch(gerador.nextInt(2)) {
			case 0:
				nome = "Lacaio " + i;
				cartas.add(new Lacaio(UUID.randomUUID(), nome, i, 2 + i, 1 + i, 1 + i));
				break;
			default:
				nome = "Magia " + i;
				switch(gerador.nextInt(3)) {
				case 0:
					cartas.add(new Buff(UUID.randomUUID(), nome, i, 0, i + 1, i + 2));
					break;
				case 1:
					cartas.add(new Dano(UUID.randomUUID(), nome, i, i + 2));
					break;
				default:
					cartas.add(new DanoArea(UUID.randomUUID(), nome, i, 5 + i));
					break;
				}
				break;
			}
		}
		
		long s = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			cartas.get(i);
		}
		System.out.println("A opera��o demorou: " + (System.nanoTime() - s) / 1000000 + " ms");
		
		//2
		LinkedList<Carta>cartas2 = new LinkedList<Carta>();
		for(int i = 0; i < 10000; i++) {
			String nome;
			switch(gerador.nextInt(2)) {
			case 0:
				nome = "Lacaio " + i;
				cartas2.add(new Lacaio(UUID.randomUUID(), nome, i, 2 + i, 1 + i, 1 + i));
				break;
			default:
				nome = "Magia " + i;
				switch(gerador.nextInt(3)) {
				case 0:
					cartas2.add(new Buff(UUID.randomUUID(), nome, i, 0, i + 1, i + 2));
					break;
				case 1:
					cartas2.add(new Dano(UUID.randomUUID(), nome, i, i + 2));
					break;
				default:
					cartas2.add(new DanoArea(UUID.randomUUID(), nome, i, 5 + i));
					break;
				}
				break;
			}
		}
		long l = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			cartas2.get(i);
		}
		System.out.println("A opera��o demorou: " + (System.nanoTime() - l) / 1000000 + " ms");
		
		//3
		long g = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			cartas.contains(cartas.get(i));
		}
		System.out.println("A opera��o demorou: "+ (System.nanoTime() - g) / 1000000 + " ms");
		
		//4
		long t = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			cartas2.contains(cartas2.get(i));
		}
		System.out.println("A opera��o demorou: "+ (System.nanoTime() - t) / 1000000 + " ms");
		
		//5
		ArrayList<Carta> cArray = new ArrayList<Carta>();
		LinkedList<Carta> cLinked = new LinkedList<Carta>();
		Vector<Carta> cVector = new Vector<Carta>();
		Carta obj = new Carta(UUID.randomUUID(), "Giovanni", 10);
		
		cArray.add(obj);
		cLinked.add(obj);
		cVector.add(obj);
		
		cArray.add(obj);
		cLinked.add(obj);
		cVector.add(obj);
		
		//Secao 3
		HashSet<Carta> hashCartas = new HashSet<Carta>(10000);
		
		for(int i = 0; i < 10000; i++) {
			String nome;
			switch(gerador.nextInt(2)) {
			case 0:
				nome = "Lacaio " + i;
				hashCartas.add(new Lacaio(UUID.randomUUID(), nome, i, 2 + i, 1 + i, 1 + i));
				break;
			default:
				nome = "Magia " + i;
				switch(gerador.nextInt(3)) {
				case 0:
					hashCartas.add(new Buff(UUID.randomUUID(), nome, i, 0, i + 1, i + 2));
					break;
				case 1:
					hashCartas.add(new Dano(UUID.randomUUID(), nome, i, i + 2));
					break;
				default:
					hashCartas.add(new DanoArea(UUID.randomUUID(), nome, i, 5 + i));
					break;
				}
				break;
			}
		}
		
		//Buscar Elementos O contidos em HashCartas
		long tempo = 0;
		for(Carta card : hashCartas) {
			g = System.nanoTime();
			hashCartas.contains(card);
			tempo += System.nanoTime() - g;
		}
		System.out.println("A opera��o demorou: "+ tempo / 1000000 + " ms");
		
		
		//Tree set
		Collection<Carta> treeCartas = new TreeSet<Carta>((Carta a, Carta b) -> {
			if(a.getCustoMana() != b.getCustoMana()) {
				return a.getCustoMana() - b.getCustoMana();
			}
			if(a.getId() != b.getId()) {
				return a.getId().compareTo(b.getId());
			}
			if(!a.getNome().equals(b.getNome())) {
				return a.getNome().compareTo(b.getNome());
			}
			return 0;
		});
		
		for(int i = 0; i < 10000; i++) {
			String nome;
			switch(gerador.nextInt(2)) {
			case 0:
				nome = "Lacaio " + i;
				treeCartas.add(new Lacaio(UUID.randomUUID(), nome, i, 2 + i, 1 + i, 1 + i));
				break;
			default:
				nome = "Magia " + i;
				switch(gerador.nextInt(3)) {
				case 0:
					treeCartas.add(new Buff(UUID.randomUUID(), nome, i, 0, i + 1, i + 2));
					break;
				case 1:
					treeCartas.add(new Dano(UUID.randomUUID(), nome, i, i + 2));
					break;
				default:
					treeCartas.add(new DanoArea(UUID.randomUUID(), nome, i, 5 + i));
					break;
				}
				break;
			}
		}
		
		//Buscar Elementos O contidos em TreeCartas
		tempo = 0;
		g = 0;
		for(Carta card : treeCartas) {
			g = System.nanoTime();
			treeCartas.contains(card);
			tempo += System.nanoTime() - g;
		}
		System.out.println("A opera��o demorou: "+ tempo / 1000000 + " ms");
		
		
		Carta objCard = new Carta(UUID.randomUUID(), "Giovanni", 2);
		Carta objCard2 = new Carta(UUID.randomUUID(), "Giovanni", 3);
		
		hashCartas.clear();
		hashCartas.add(objCard);
		hashCartas.add(objCard);
		hashCartas.add(objCard2);
		hashCartas.add(objCard);
		
		treeCartas.clear();
		treeCartas.add(objCard);
		treeCartas.add(objCard);
		treeCartas.add(objCard2);
		
		//Secao 4
		System.out.println("\nA API Stream");
		Collection<Carta> cartasArray = Arrays.asList(
				new Lacaio(UUID.randomUUID(), "Lacaio 1", 1, 2, 3, 3),
				new Buff(UUID.randomUUID(), "Buffar 1", 1, 0, 1, 1),	
				new Dano(UUID.randomUUID(), "Dano 1", 1, 2),
				new DanoArea(UUID.randomUUID(), "Area 1", 1, 3),
				new Lacaio(UUID.randomUUID(), "Lacaio 2", 3, 4, 500, 500),
				new Buff(UUID.randomUUID(), "Buffar 2", 2, 0, 2, 2),	
				new Dano(UUID.randomUUID(), "Dano 2", 2, 3),
				new DanoArea(UUID.randomUUID(), "Area 2", 2, 4),
				new Lacaio(UUID.randomUUID(), "Lacaio 3", 50, 60, 70, 70),
				new Buff(UUID.randomUUID(), "Buffar 3", 3, 0, 4, 4),	
				new Dano(UUID.randomUUID(), "Dano 3", 5, 6),
				new DanoArea(UUID.randomUUID(), "Area 3", 5, 7));
		
		Carta maiorATK = cartasArray.stream()
				.filter(p -> p instanceof Lacaio)
				.sorted((p1, p2) -> ((Lacaio)p2).getAtaque() - ((Lacaio)p1).getAtaque())
				.findFirst()
				.orElse(null);
		System.out.println("\nMaior Ataque: \n"+maiorATK);
		
		Integer soma = new Integer(
				cartasArray.stream()
				.filter(p -> p instanceof Lacaio)
				.mapToInt(p -> ((Lacaio)p).getAtaque())
				.sum());
		System.out.println("Soma dos ataques: "+soma);
		
		Collection<Carta> ordemVidaCrescente = cartasArray.stream()
				.filter(p -> p instanceof Lacaio)
				.sorted((p1, p2) -> ((Lacaio)p1).getVidaMaxima() - ((Lacaio)p2).getVidaMaxima())
				.collect(Collectors.toList());
		System.out.println("\nOrdenar lacaios por vida:\n"+ordemVidaCrescente);
	}
}
