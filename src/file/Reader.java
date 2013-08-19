package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
		
	private BufferedReader br;
	private static final String LINE_SEPARATOR = ",";
	
	public Reader(String csvLocation) {
		
		try {
			br = new BufferedReader(new FileReader(csvLocation));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public String[] readAll() {
		
		String line = new String();

		try {
			
			line = br.readLine();
				
			br.close();
			
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		String[] urls = line.split(LINE_SEPARATOR);
		
		return urls;
	}
}
