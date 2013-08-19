
package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import main.URL;

public class Writer {

	private BufferedWriter bw;
	private String defaultLocation; 
	private String customLocation;
	private ArrayList<URL> urls;
	
	public Writer(ArrayList<URL> urls, String defaultLocation, String customLocation) {
		
		this.defaultLocation = defaultLocation;
		this.customLocation = customLocation;
		this.urls = urls;
	}
	
	public void writeAll() {
		
		if(customLocation.equals(defaultLocation)) {
			
			String[] defaultName = defaultLocation.split("\\.");
			
			defaultLocation = "." + defaultName[1] + "_parsed" + "." + defaultName[2];
			
			try {

				bw = new BufferedWriter(new FileWriter(defaultLocation));

				for (int i = 0; i < urls.size(); i++) {
					
					bw.append(urls.get(i).toString());
				}
				
				bw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		else {
			
			try {
				
				bw = new BufferedWriter(new FileWriter(customLocation));

				for (int i = 0; i < urls.size(); i++) {

					bw.append(urls.get(i).toString());
				}
				
				bw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
