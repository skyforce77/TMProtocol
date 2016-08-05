package fr.skyforce77.towerminer.protocol.packets;


public class Packet17Player extends Packet{
	
	private static final long serialVersionUID = 888817L;
	
	public String player;
	
	public Packet17Player() {}
	
	public Packet17Player(String player) {
		this.player = player;
	}

}
