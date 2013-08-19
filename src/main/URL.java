package main;

public class URL implements Comparable<URL> {

	private int cat;
	private String url;
	private static final String TAB_SEPARATOR = "\t";
	private static final String LINE_END = "\n";
	
	public URL(int cat, String url) {
		
		this.cat = cat;
		this.url = url;
	}
	
	public int getCat() {
		return cat;
	}

	public void setCat(int cat) {
		this.cat = cat;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return this.cat + TAB_SEPARATOR + this.url + LINE_END;
	}

	@Override
	public int compareTo(URL otherURL) {
		
		if (this.cat < otherURL.getCat()) {
            return -1;
        }
        if (this.cat > otherURL.getCat()) {
            return 1;
        }
        return 0;
	}
}
