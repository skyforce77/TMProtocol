package fr.skyforce77.towerminer.protocol.packets;

import fr.skyforce77.towerminer.protocol.chat.ChatMessage;


public class Packet11ChatMessage extends Packet{
	
	public byte[] message;
	public boolean response = false;
	
	public Packet11ChatMessage() {}
	
	public Packet11ChatMessage(ChatMessage message) {
		this.message = serialize(message);
	}
	
	public ChatMessage getMessage() {
		return (ChatMessage)deserialize(message);
	}

}
