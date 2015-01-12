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
	
	public void setCommandAutoComplete(String command) {
		this.link = "tmcmd://"+command;
	}
	
	public void setCommandAutoType(String command) {
		this.link = "tmtypecmd://"+command;
	}
	
	public void setPluginInteract(String channel, String... actions) {
		this.link = "tmplugin://"+channel;
		for(String action : actions) {
			this.link = link+"/"+action;
		}
	}
	
	public String getLink() {
		return link;
	}

}
