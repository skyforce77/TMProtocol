package fr.skyforce77.towerminer.protocol.chat;

import java.awt.Color;
import java.io.Serializable;

public class MessageModel implements Serializable{

	private static final long serialVersionUID = 465988746514541L;
	
	private Color foreground = new Color(255,255,255);
	private Color background = new Color(0,0,0,40);
	private Color highlight = null;
	private String text = "";
	private String option = null;
	
	public MessageModel() {}
	
	public MessageModel(String text) {
		this.text = text;
	}
	
	public MessageModel(String text, String option) {
		this.text = text;
		this.option = option;
	}
	
	public MessageModel setForegroundColor(Color color) {
		foreground = color;
		return this;
	}
	
	public MessageModel setBackgroundColor(Color color) {
		background = color;
		return this;
	}
	
	public MessageModel setHighlightColor(Color color) {
		highlight = color;
		return this;
	}
	
	public MessageModel setText(String text) {
		this.text = text;
		return this;
	}
	
	public MessageModel setOption(String option) {
		this.option = option;
		return this;
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
