import java.util.ArrayList;
import java.util.Random;

/**
* Esta classe representa um Jogador aleatório (realiza jogadas de maneira aleatória) para o jogo LaMa (Lacaios & Magias).
* @see java.lang.Object
* @author Rafael Arakaki - MC302
*/
public class JogadorRA173325 extends Jogador {
	private ArrayList<CartaLacaio> lacaios;
	private ArrayList<CartaLacaio> lacaiosOponente;
	
	/**
	  * O método construtor do JogadorAleatorio.
	  * 
	  * @param maoInicial Contém a mão inicial do jogador. Deve conter o número de cartas correto dependendo se esta classe Jogador que está sendo construída é o primeiro ou o segundo jogador da partida. 
	  * @param primeiro   Informa se esta classe Jogador que está sendo construída é o primeiro jogador a iniciar nesta jogada (true) ou se é o segundo jogador (false).
	  */
	public JogadorRA173325(ArrayList<Carta> maoInicial, boolean primeiro){
		primeiroJogador = primeiro;
		
		mao = maoInicial;
		lacaios = new ArrayList<CartaLacaio>();
		lacaiosOponente = new ArrayList<CartaLacaio>();
		
		// Mensagens de depuração:
		System.out.println("*Classe JogadorRA173325* Sou o " + (primeiro?"primeiro":"segundo") + " jogador (classe: JogadorRA173325)");
		System.out.println("Mao inicial:");
		for(int i = 0; i < mao.size(); i++)
			System.out.println("ID " + mao.get(i).getID() + ": " + mao.get(i));
	}
	
	/**
	  * Um método que processa o turno de cada jogador. Este método deve retornar as jogadas do Jogador decididas para o turno atual (ArrayList de Jogada).
	  * 
	  * @param mesa   O "estado do jogo" imediatamente antes do início do turno corrente. Este objeto de mesa contém todas as informações 'públicas' do jogo (lacaios vivos e suas vidas, vida dos heróis, etc).
	  * @param cartaComprada   A carta que o Jogador recebeu neste turno (comprada do Baralho). Obs: pode ser null se o Baralho estiver vazio ou o Jogador possuir mais de 10 cartas na mão.
	  * @param jogadasOponente   Um ArrayList de Jogada que foram os movimentos utilizados pelo oponente no último turno, em ordem.
	  * @return            um ArrayList com as Jogadas decididas
	  */
	public ArrayList<Jogada> processarTurno (Mesa mesa, Carta cartaComprada, ArrayList<Jogada> jogadasOponente){
		int minhaMana, minhaVida;
		if(cartaComprada != null)
			mao.add(cartaComprada);
		if(primeiroJogador){
			minhaMana = mesa.getManaJog1();
			minhaVida = mesa.getVidaHeroi1();
			lacaios = mesa.getLacaiosJog1();
			lacaiosOponente = mesa.getLacaiosJog2();
			//System.out.println("--------------------------------- Começo de turno pro jogador1");
		}
		else{
			minhaMana = mesa.getManaJog2();
			minhaVida = mesa.getVidaHeroi2();
			lacaios = mesa.getLacaiosJog2();
			lacaiosOponente = mesa.getLacaiosJog1();
			//System.out.println("--------------------------------- Começo de turno pro jogador2");
		}
		
		ArrayList<Jogada> minhasJogadas = new ArrayList<Jogada>();
		
		//Se houver mana disponivel usar uma carta Magia
		for(int i = 0; i < mao.size(); i++) {
			Carta card = mao.get(i);
			if(card instanceof CartaMagia && card.getMana() <= minhaMana) {
				Jogada mag = null;
				CartaMagia cardM = (CartaMagia) card;
				if(cardM.getMagiaTipo() == TipoMagia.BUFF) {
					//Verifica se tem lacaios na mesa
					if(lacaios.size()<=0) {
						continue;
					} else {
						mag = new Jogada(TipoJogada.MAGIA, card, lacaios.get(0));
					}
				} else {
					mag = new Jogada(TipoJogada.MAGIA, card, null);
				}
				minhasJogadas.add(mag);
				minhaMana -= card.getMana();
				System.out.println("Jogada: Decidi uma jogada de baixar a magia: "+card);
				mao.remove(i);
				break;//No máximo 1 Magia
			}
		}
		
		//Se houver mana disponivel usar uma carta Lacaio
		for(int i = 0; i < mao.size(); i++) {
			Carta card = mao.get(i);
			if(card instanceof CartaLacaio && card.getMana() <= minhaMana) {
				Jogada lac = new Jogada(TipoJogada.LACAIO, card, null);
				minhasJogadas.add(lac);
				minhaMana -= card.getMana();
				System.out.println("Jogada: Decidi uma jogada de baixar o lacaio: "+card);
				mao.remove(i);
				break;//No máximo 1 Lacaio
			}
		}
		
		//Atacar com todos os lacaios da mesa que não foram baixados nesse turno
		for(CartaLacaio lac : lacaios) {
			Jogada atacar = new Jogada(TipoJogada.ATAQUE, lac, null);
			minhasJogadas.add(atacar);
		}
		
		// O laço abaixo cria jogas de baixar lacaios da mão para a mesa se houver mana disponível.
		/*for(int i = 0; i < mao.size(); i++){
			Carta card = mao.get(i);
			if(card instanceof CartaLacaio && card.getMana() <= minhaMana){
				Jogada lac = new Jogada(TipoJogada.LACAIO, card, null);
				minhasJogadas.add(lac);
				minhaMana -= card.getMana();
				System.out.println("Jogada: Decidi uma jogada de baixar o lacaio: "+ card);
				mao.remove(i);
				i--;
			}
		}
		*/
		
		return minhasJogadas;
	}
}
