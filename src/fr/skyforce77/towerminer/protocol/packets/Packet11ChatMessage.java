package fr.skyforce77.towerminer.protocol.packets;


public class Packet11ChatMessage extends Packet{
	
	public String message;
	public String option;
	public boolean response = false;
	
	public Packet11ChatMessage() {}
	
	public Packet11ChatMessage(String message, String player) {
		this.message = message;
		this.option = player;
	}

}
