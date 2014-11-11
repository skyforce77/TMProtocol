package fr.skyforce77.towerminer.protocol.chat;


public class ChatModel extends MessageModel{

	private static final long serialVersionUID = 4659887846514541L;

	private MessageModel mousemodel;
	private String link;
	
	public ChatModel(String text) {
		super(text);
	}
	
	public ChatModel(String text, String option) {
		super(text, option);
	}
	
	public ChatModel setMouseModel(MessageModel model) {
		mousemodel = model;
		return this;
	}
	
	public MessageModel getMouseModel() {
		return mousemodel;
	}
	
	public boolean isLink() {
		return link != null;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getLink() {
		return link;
	}

}
