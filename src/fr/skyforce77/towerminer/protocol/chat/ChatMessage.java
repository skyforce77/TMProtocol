package fr.skyforce77.towerminer.protocol.chat;

import java.io.Serializable;
import java.util.ArrayList;

public class ChatMessage implements Serializable{

	private static final long serialVersionUID = 235487764656546L;
	
	private ArrayList<ChatModel> models = new ArrayList<>();
	
	public ChatMessage() {}
	
	public ChatMessage(String text) {
		models.add(new ChatModel(text));
	}
	
	public ChatMessage(ChatModel... models) {
		for(ChatModel m : models) {
			this.models.add(m);
		}
	}
	
	public ArrayList<ChatModel> getModels() {
		return models;
	}
	
	public void addModel(ChatModel m) {
		models.add(m);
	}
	
	public void add(ChatMessage m) {
		for(ChatModel mo : m.getModels()) {
			models.add(mo);
		}
	}

}
