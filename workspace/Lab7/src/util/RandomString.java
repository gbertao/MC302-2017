package util;

public class RandomString {
	
	private static final char[] symbols;
	
	static {
		StringBuilder tmp = new StringBuilder();
		for(char ch = '0'; ch <= '9'; ++ch)
			tmp.append(ch);
		for(char ch = 'a'; ch <= 'z'; ++ch)
			tmp.append(ch);
		symbols = tmp.toString().toCharArray();
	}
	
	//TO-DO: Implementar RandomStrings
}
