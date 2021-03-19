package utils;

import java.awt.Desktop;
import java.net.URI;

public class OpenUrl {
	
	public String url;
	
	public OpenUrl(String u) {
		
		this.url=u;
		
		Desktop desktop = Desktop.getDesktop();
		
		try {
			URI uri = new URI(this.url);
			desktop.browse(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
