package speedDeliveryTimeClient.utils;

import javax.swing.JPanel;

public class ScrollPaneLine extends JPanel {
	private String content;
	private int numLine = 0;
	private static final long serialVersionUID = 1L;
	
	public ScrollPaneLine(String content, int numLine) {
		super();
		this.content = content;
		this.numLine = numLine;
	}

	public String getContent() {
		return content;
	}

	public int getNumLine() {
		return numLine;
	}
	
	

}
