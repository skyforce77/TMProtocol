package fr.skyforce77.towerminer.protocol.chat;


public class IconModel extends ChatModel{

	private static final long serialVersionUID = 4659887846514541L;

	private String image;
	
	public IconModel(String image) {
		super("    ");
		this.image = image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getImage() {
		return image;
	}

}
