package fr.skyforce77.towerminer.protocol.packets;


public class Packet17Player extends Packet{
	
	public String player;
	
	public Packet17Player() {}
	
	public Packet17Player(String player) {
		this.player = player;
	}

}
