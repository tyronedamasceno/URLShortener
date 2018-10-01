package com.example.demo;

public class IDConverter {

	private static IDConverter INSTANCE;
	private static String baseCharacters;
	public static final Integer BASE = 62;
	
	private IDConverter() {
		initialize();
	}

	public static synchronized IDConverter getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new IDConverter();
		}
		return INSTANCE;
	}
	
	public String toBase62(String input) {
		Integer inputValue = Integer.valueOf(input);
		if (inputValue == 0) return "0";
		String output = "";
		while (inputValue > 0) {
			int remain = inputValue % BASE;
			output += baseCharacters.charAt(remain);
			inputValue /= BASE;
		}	
		return output;
	}
	
	public String toBase10(String input) {
		Integer aux = 0;
		for (int i = input.length() - 1, exp = 0; i >= 0; i--, exp++) {
			aux += (int)(Math.pow(62, exp) * baseCharacters.indexOf(input.charAt(i)));
		}
		return String.valueOf(aux);
	}
	
	private void initialize() {
		baseCharacters = "";
		for (char i = '0'; i <= '9'; i++) baseCharacters += i;
		for (char i = 'a'; i <= 'z'; i++) baseCharacters += i;
		for (char i = 'A'; i <= 'Z'; i++) baseCharacters += i;
	}

}
