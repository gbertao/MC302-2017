package base.exception;

public class BaralhoVazioException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BaralhoVazioException(String mensagem) {
		super(mensagem);
	}
}
