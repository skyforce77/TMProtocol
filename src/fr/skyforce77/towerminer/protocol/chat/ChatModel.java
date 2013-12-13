package fr.skyforce77.towerminer.protocol.chat;

import java.awt.Color;
import java.io.Serializable;

public class ChatModel implements Serializable{

	private static final long serialVersionUID = 465988746514541L;
	
	private Color foreground = new Color(255,255,255);
	private Color background = new Color(0,0,0,40);
	private Color highlight = null;
	private String text = "";
	private String option = null;
	
	public ChatModel(String text) {
		this.text = text;
	}
	
	public ChatModel(String text, String option) {
		this.text = text;
		this.option = option;
	}
	
	public void setForegroundColor(Color color) {
		foreground = color;
	}
	
	public void setBackgroundColor(Color color) {
		background = color;
	}
	
	public void setHighlightColor(Color color) {
		highlight = color;
	}
	
	public Color getForegroundColor() {
		return foreground;
	}
	
	public Color getBackgroundColor() {
		return background;
	}
	
	public Color getHighlightColor() {
		return highlight;
	}
	
	public String getText() {
		return text;
	}
	
	public String getOption() {
		return option;
	}

}
