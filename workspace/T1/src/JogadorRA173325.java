import java.util.ArrayList;

public class JogadorRA173325 extends Jogador() {
	
	//Metodo construtor:
	public JogadorRA173325 (ArrayList <Carta> maoInicial, boolean primeiro){
		
		primeiroJogador = primeiro;
		mao = maoInicial;

		//Mensagem de depuracao:
		System.out.println("Sou o " + (primeiro?"primeiro":"segundo") + "jogador");
		System.out.println("Mao inicial:");
		for(int i = 0; i < mao.size(); i++) {
			System.out.println("ID: " + mao.get(i).getID() + ": " + mao.get(i));
		}
	}//Fim construtor

	//Metodo processar turno
	public ArrayList<Jogada> processarTurno (Mesa mesa, Carta cartaComprada, ArrayList<Jogada> jogadasOponente) {
		int minhaMana, oponenteMana;
		ArrayList<Carta> lacaiosMeus;
		ArrayList<Carta> lacaiosOponente;

		if(cartaComprada != null) {
			mao.add(cartaComprada);
		}

		if(primeiroJogador) {
			minhaMana = mesa.getManaHeroi1();
			oponenteMana = mesa.getManaHeroi2();
			lacaiosMeus = mesa.getLacaiosHeroi1();
			lacaiosOponente = mesa.getLacaiosHeroi2();
		} else {
			minhaMana = mesa.getManaHeroi2();
			oponenteMana = mesa.getManaHeroi1();
			lacaiosMeus = mesa.getLacaiosHeroi2();
			lacaiosOponente = mesa.getLacaiosHeroi1();
		}

		ArrayList<Jogada> minhaJogada = new ArrayList<Jogada>();

		//Decisao de quais jogadas serao efetuadas
		
		//Comportamento Agressivo
		//Ordenar a mao por ordem de ataque
		//Descer o lacaio mais forte ou utilizar uma magia de dano
		//Atacar diretamente o oponente

		return minhasJogadas;		
	}//Fim do metodo processar turno

	//Inicio do metodo Agressivo
	private ArrayList<Jogada> Agressivo() {
		ArrayList<Jogada> agressiva;

		return agressiva;
	}//Fim do metodo Agressivo
	
	//Inicio do metodo Controle
	private ArrayList<Jogada> Controle() {
		ArrayList<Jogada> controle;

		return controle;
	}//Fim do metodo Controle

	//Inicio do metodo CurvaDeMana
	private ArrayList<Jogada> CurvaDeMana() {
		ArrayList<Jogada> curva;

		return curva;
	}//Fim do metodo CurvaDeMana
}
