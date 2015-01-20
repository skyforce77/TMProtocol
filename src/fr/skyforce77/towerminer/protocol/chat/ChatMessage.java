package fr.skyforce77.towerminer.protocol.chat;

import java.io.Serializable;
import java.util.ArrayList;

public class ChatMessage implements Serializable{

	private static final long serialVersionUID = 235487764656546L;
	
	private ArrayList<ChatModel> models = new ArrayList<ChatModel>();
	
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
	
	public ArrayList<ChatModel> getModels(int start, int stop) {
		ArrayList<ChatModel> mod = new ArrayList<>();
		int actual = 0;
		for(ChatModel model : models) {
			if(actual >= start && actual+model.getText().length() <= stop) {
				mod.add(model);
			} else if(actual+model.getText().length() > start && actual+model.getText().length() <= stop) {
				model.setText(model.getText().substring(actual+model.getText().length()-start));
				mod.add(model);
			}
			actual += model.getText().length();
		}
		return mod;
	}
	
	public ChatMessage cutMessage(int start, int stop) {
		ChatMessage msg = new ChatMessage();
		for(ChatModel model : getModels(start, stop)) {
			msg.addModel(model);
		}
		return msg;
	}
	
	public void add(ChatMessage m) {
		for(ChatModel mo : m.getModels()) {
			models.add(mo);
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		for(ChatModel model : models) {
			s = s+model.getText();
		}
		return s;
	}

}
