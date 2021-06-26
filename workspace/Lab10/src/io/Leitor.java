package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import base.ILaMaSerializable;
import base.cartas.HabilidadesLacaio;

public class Leitor {

	public List <ILaMaSerializable > leObjetos () throws FileNotFoundException {
		List <ILaMaSerializable> lista = new ArrayList <ILaMaSerializable>();
		Scanner leitor = new Scanner(new File("saida.txt"));
		
		leitor.next();
		String classe = leitor.next();
		
		if(classe.equals("Lacaio")) {
			UUID id;
			String nome;
			int custoMana;
			int vidaAtual;
			int vidaMaxima;
			HabilidadesLacaio habilidade;
			
			String str = leitor.next();
			while(!str.equals("obj")) {
				if(str.equals("id")) {
					str = leitor.next();
					id = UUID.fromString(str);
				} else if(str.equals("nome")) {
					str = leitor.next();
					nome = str;
				} else if(str.equals("custoMana")) {
					str = leitor.next();
					custoMana = Integer.valueOf(str);
				} else if(str.equals("vidaAtual")) {
					str = leitor.next();
					vidaAtual = Integer.valueOf(str);
				} else if(str.equals("vidaMaxima")) {
					str = leitor.next();
					vidaMaxima = Integer.valueOf(str);
				} else if(str.equals("habilidade")) {
					str = leitor.next();
					habilidade = HabilidadesLacaio.valueOf(str);
				}
				str = leitor.next();
			}
			str = leitor.next();
		}
		
		
		return lista;
	}
	
}
