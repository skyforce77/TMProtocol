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
	private boolean striked = false;
	private boolean underlined = false;
	private boolean italic = false;
	private boolean bold = false;
	
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
	
	public boolean isStriked() {
		return striked;
	}
	
	public boolean isUnderlined() {
		return underlined;
	}
	
	public boolean isItalic() {
		return italic;
	}
	
	public boolean isBold() {
		return bold;
	}
	
	public void setStriked(boolean striked) {
		this.striked = striked;
	}
	
	public void setUnderlined(boolean underlined) {
		this.underlined = underlined;
	}
	
	public void setItalic(boolean italic) {
		this.italic = italic;
	}
	
	public void setBold(boolean bold) {
		this.bold = bold;
	}

}
