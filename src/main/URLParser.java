package main;

import java.util.ArrayList;
import java.util.Collections;
import file.Reader;
import file.Writer;

public class URLParser {
	
	private static String[] urls;
	private static ArrayList<URL> array;
	private static final String LINE_SEPARATOR = ";";
	
	public static void main(String[] args) {
		
		Reader reader = new Reader(args[0]); //Abre o arquivo CSV para leitura
		
		urls = reader.readAll(); //Le as urls
		
		array = new ArrayList<URL>();
		
		split();
		
		Writer saver = new Writer(array, args[0], args[1]); //Instancia o saver
		
		saver.writeAll(); //Executa a gravacao em disco
	}
	
	private static void split() {
		
		for (int i = 0; i < urls.length; i++) {
			
			String[] auxUrl = urls[i].split(LINE_SEPARATOR);
			
			if(auxUrl.length > 1)
				array.add(new URL(Integer.parseInt(auxUrl[1]) , auxUrl[0]));
		}
		
		Collections.sort(array);
	}
}
